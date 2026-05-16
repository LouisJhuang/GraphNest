package com.example.begraphqlnest.domain.service.impl;

import com.example.begraphqlnest.core.graphql.output.MemberProfile;
import com.example.begraphqlnest.domain.service.MemberProfileService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberProfileServiceImpl implements MemberProfileService {

    private final Map<String, MemberProfile> profiles = Map.of(
            "1", new MemberProfile("1", "0912-345-678", "Taipei", "1995-01-01"),
            "2", new MemberProfile("2", "0922-333-444", "Taichung", "1996-02-02"),
            "3", new MemberProfile("3", "0933-555-666", "Kaohsiung", "1997-03-03")
    );

    @Override
    public MemberProfile findByMemberId(String memberId) {
        return profiles.get(memberId);
    }

}
