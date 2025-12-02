package com.api.inventory.inventoryapi.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey; // Debe ser Base64

    @Value("${jwt.expiration-ms:86400000}") // 1 día
    private long expirationMs;

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generar token
    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(System.currentTimeMillis() + expirationMs);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(getSignInKey())
                .compact();
    }

    // Extraer username
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Validar token
    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // ✅ Versión correcta con jjwt 0.12.5
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())   // usa SecretKey
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
