package hello.hellospring.JPA;

public class Member {
    @Entity

    @Id
    private Long id;
    private String namel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }
}
