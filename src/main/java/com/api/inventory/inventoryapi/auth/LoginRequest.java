package com.api.inventory.inventoryapi.auth;

public record LoginRequest(
        String username,
        String password
) {}