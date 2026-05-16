package com.example.begraphqlnest.domain.service;

import com.example.begraphqlnest.core.constraint.MemberStatus;
import com.example.begraphqlnest.core.graphql.input.CreateMemberInput;
import com.example.begraphqlnest.core.graphql.output.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(String id);

    Member create(CreateMemberInput input);

    Member updateStatus(String id, MemberStatus status);

}
