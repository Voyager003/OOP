package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈로 실제 서비스는 concurrent 해시맵사용

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);  // 아이디 save
    }

    @Override
    public Member findById(Long memberId) {  // 아이디 찾기
        return store.get(memberId);
    }
}
