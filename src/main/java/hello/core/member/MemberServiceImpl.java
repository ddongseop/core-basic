package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //추상(인터페이스)에만 의존 (DIP 지킴)

    public MemberServiceImpl(MemberRepository memberRepository) { //생성자 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
