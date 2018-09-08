package com.hoony.msa.springboot.repository;

import org.apache.ibatis.annotations.Mapper;

import com.hoony.msa.springboot.repository.dvo.MemberDVO;

@Mapper
public interface ICoffeeMemberMapper {
	MemberDVO existsByMemberName(MemberDVO memberDVO);
	int createMemberTable();
	int insertMemberData();
}
