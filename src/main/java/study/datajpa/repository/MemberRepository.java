package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    // data jpa 내부적으로 namedQuery 룰 먼저 찾기때문에 @Query 어노테이션을 생략해도 된다.
//    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    // 애플리케이션 로딩 시점에 검증을 해주는 장점이 있다.
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findByUser(@Param("username")String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    // 컬렉션 - 조회결과 없을 때 빈 리스트를 반환
    List<Member> findListByUsername(String username);
    // 단건 - 조회결과 없을 때 Null 반환
    Member findMemberByUsername(String username);
    // optional - null 일 가능성이 있다면, optional 로 받자
    Optional<Member> findOptionalByUsername(String username);
}
