package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장되는거
    Optional<Member> findById(Long id); //회원찾기
    Optional<Member> findByName(String name);
    List<Member> findAll();  //지금까지 저장했던 모든 회원 끌어오기
}
