package com.example.begraphqlnest.core.graphql.output;

public record MemberProfile(
        String memberId,
        String phone,
        String address,
        String birthday
) {
}