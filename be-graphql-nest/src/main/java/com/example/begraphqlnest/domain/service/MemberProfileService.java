package com.example.begraphqlnest.domain.service;
 
import com.example.begraphqlnest.core.graphql.output.MemberProfile;

public interface MemberProfileService {

    MemberProfile findByMemberId(String memberId);

}
