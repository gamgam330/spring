package hello.hellospring.JPA;

public class memberJPA {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try{
        Member member = new Member();
        member.setId(1L);
        member.setName(“HelloA”);
        em.persist(member); //멤버 저장.
        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close();
    }
    emf.close();


    /*
    // 수정
    try{
	    Member findMember = em.find(Member.class, 1L);
	    findMember.setName(“HelloJPA”);
	    //em.persist(findMember); < 이거 안해도 바뀜. JPA가 알아서 관리해서 커밋하는 시점에 다 체크함. 바뀌면 그냥 업데이트 쿼리 날려버림.
	    tx.commit();
    } catch (Exception e) {
	    tx.rollback();
    } finally {
	    em.close();
    }


    // 조회
    나이가 18살인 모든 고객을 찾으려면? -> JPQL을 사용해야함.

    try{
	    List<Member> result = em.createQuery(“select m from Member as m”, Member.class).
	    setFirstResult(5)
	    .setMaxREstulrs(8)
	    .getResultList();	// 5번부터 8개 가져와 라는 소리.
	    for(Member member : result) {
		    System.out.println(“member.name = ” + member.getName());
	    }
	    tx.commit();
    } catch (Exception e) {
	    tx.rollback();
    } finally {
	    em.close();
    }
     */
}
