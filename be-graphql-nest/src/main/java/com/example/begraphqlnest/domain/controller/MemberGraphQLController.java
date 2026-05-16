package com.example.begraphqlnest.domain.controller;

import com.example.begraphqlnest.core.constraint.MemberStatus;
import com.example.begraphqlnest.core.graphql.input.CreateMemberInput;
import com.example.begraphqlnest.core.graphql.output.Member;
import com.example.begraphqlnest.core.graphql.output.MemberProfile;
import com.example.begraphqlnest.core.graphql.output.Order;
import com.example.begraphqlnest.domain.service.MemberProfileService;
import com.example.begraphqlnest.domain.service.MemberService;
import com.example.begraphqlnest.domain.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

@Controller
public class MemberGraphQLController {

    private final MemberService memberService;
    private final MemberProfileService memberProfileService;
    private final OrderService orderService;

    public MemberGraphQLController(
            MemberService memberService,
            MemberProfileService memberProfileService,
            OrderService orderService) {
        this.memberService = memberService;
        this.memberProfileService = memberProfileService;
        this.orderService = orderService;
    }

    @QueryMapping
    public Member member(@Argument String id) {
        return memberService.findById(id);
    }

    @QueryMapping
    public List<Member> members() {
        return memberService.findAll();
    }

    @MutationMapping
    public Member createMember(@Argument CreateMemberInput input) {
        return memberService.create(input);
    }

    @MutationMapping
    public Member updateMemberStatus(
            @Argument String id,
            @Argument MemberStatus status
    ) {
        return memberService.updateStatus(id, status);
    }

    @SchemaMapping(typeName = "Member", field = "profile")
    public MemberProfile profile(Member member) {
        return memberProfileService.findByMemberId(member.id());
    }

    @SchemaMapping(typeName = "Member", field = "orders")
    public List<Order> orders(Member member) {
        return orderService.findByMemberId(member.id());
    }

}
