package com.example.begraphqlnest.domain.service.impl;

import com.example.begraphqlnest.core.constraint.MemberStatus;
import com.example.begraphqlnest.core.graphql.input.CreateMemberInput;
import com.example.begraphqlnest.core.graphql.output.Member;
import com.example.begraphqlnest.domain.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private final List<Member> members = new ArrayList<>(List.of(
            new Member("1", "louis", "louis@example.com", "Louis Chuang", MemberStatus.ACTIVE),
            new Member("2", "amy", "amy@example.com", "Amy Wang", MemberStatus.INACTIVE),
            new Member("3", "jack", "jack@example.com", "Jack Chen", MemberStatus.LOCKED)
    ));

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findById(String id) {
        return members.stream()
                .filter(member -> member.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Member create(CreateMemberInput input) {
        Member member = new Member(
                UUID.randomUUID().toString(),
                input.username(),
                input.email(),
                input.displayName(),
                MemberStatus.ACTIVE
        );

        members.add(member);

        return member;
    }

    @Override
    public Member updateStatus(String id, MemberStatus status) {
        Optional<Member> optionalMember = members.stream()
                .filter(member -> member.id().equals(id))
                .findFirst();

        if (optionalMember.isEmpty()) {
            throw new IllegalArgumentException("Member not found: " + id);
        }

        Member oldMember = optionalMember.get();

        Member updatedMember = new Member(
                oldMember.id(),
                oldMember.username(),
                oldMember.email(),
                oldMember.displayName(),
                status
        );

        members.remove(oldMember);
        members.add(updatedMember);

        return updatedMember;
    }

}
