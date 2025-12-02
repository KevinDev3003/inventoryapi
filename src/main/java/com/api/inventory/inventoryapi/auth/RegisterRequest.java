package com.api.inventory.inventoryapi.auth;

public record RegisterRequest(
        String username,
        String password
) {}