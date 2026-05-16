package com.example.begraphqlnest.core.graphql.output;

public record Order(
        String id,
        String memberId,
        String productName,
        int amount
) {
}