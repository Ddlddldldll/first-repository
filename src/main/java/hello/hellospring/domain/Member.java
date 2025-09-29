package hello.hellospring.domain;

public class Member {

    private Long id;  //임의의값(시스템이 저장하는)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
