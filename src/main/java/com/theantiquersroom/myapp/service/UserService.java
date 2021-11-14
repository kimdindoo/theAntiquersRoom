package com.theantiquersroom.myapp.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.theantiquersroom.myapp.domain.Criteria;
import com.theantiquersroom.myapp.domain.LoginDTO;
import com.theantiquersroom.myapp.domain.ProductVO;
import com.theantiquersroom.myapp.domain.UserDTO;
import com.theantiquersroom.myapp.domain.UserVO;


@Service
public interface UserService {

    // 회원가입
    public abstract boolean registerUser(UserDTO user);

    // 아이디 중복 검사
    public abstract boolean checkId(String userId);

    // 닉네임 중복검사
    public abstract boolean checkNickName(String nickName);

    // 연락처 중복검사
    public abstract boolean checkPhone(String phone);

    // 이메일 인증번호 매칭검사
    public abstract boolean confirmEmail(String userId, String auth) throws ParseException;

    // 이메일 발송
    public abstract boolean sendEmail(String userId) throws Exception;

    // 로그인 실행
    public abstract UserDTO login(LoginDTO dto) throws Exception;
    
    // 아이디 찾기 실행
    public abstract UserVO findId(String nickName, String phone);
    
    // 비밀번호 재설정
    public abstract boolean resetPwd(String userId, String nickName) throws Exception;
    
    // 회원 탈퇴
    public abstract boolean remove(String userId);

    
    // 나의 경매리스트 조회
    public abstract List<ProductVO> getMyAuctionList(String userId, Criteria cri);
    
    // 나의 입찰리스트 조회
    public abstract List<ProductVO> getBidList(Criteria cri);
    

	// 전체 회원 목록조회
	public abstract List<UserVO> getUserList();
	
	// 상세 회원 목록 조회
	public abstract UserVO get(String userId);
    
	// 회원 정보 수정
	public abstract boolean modify(UserDTO user);
	
    // 닉네임, 폰번호로 아이디찾기
    public abstract UserVO findId(UserVO vo);
    
    
    // =====================카카오 로그인 API 관련===================== //
    
    // 카카오 아이디 조회
    public abstract UserDTO getKakaoUser(String kakaoUniqueId);    
    
} // end interface


