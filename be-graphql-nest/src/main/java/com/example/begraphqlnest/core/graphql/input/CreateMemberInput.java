package com.example.begraphqlnest.core.graphql.input;

public record CreateMemberInput(
        String username,
        String email,
        String displayName
) {
}