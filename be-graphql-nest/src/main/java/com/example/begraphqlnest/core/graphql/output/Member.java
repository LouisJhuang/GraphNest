package com.example.begraphqlnest.core.graphql.output;

import com.example.begraphqlnest.core.constraint.MemberStatus;

public record Member(
        String id,
        String username,
        String email,
        String displayName,
        MemberStatus status
) {
}