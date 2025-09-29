package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //hello.html에 1.${data}키값으로간다. 2.${data}는 hello를 출력하게된다
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {  //모델에 담으면 그걸 뷰에서 렌더할때 쓴데
        model.addAttribute("name", name); //앞에께 key고 뒤에가 매개변수
        return "hello-template";
}

    @GetMapping("hello-string") //이걸 쓸일은 거의 없다
    @ResponseBody //HTTP body부에 이 데이터를 직접 넣어주겠다라는 뜻
                  //response body, 응답 body부에다 이 내용을 직접 넣겠다라는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring으로 적혀내려감 데이터를 그대로~
    }

    @GetMapping("hello-api")  //json이라는 방식이다: key밸류로 이루어진 방식 톰캣에 던져
    @ResponseBody  //객체를 주면 json데이터를 만들어서 http응답에 반환하겠다
    public Hello helloApi(@RequestParam("name")String name) {
        Hello hello = new Hello();
        hello.setName(name);  //넘겼죠
        return hello;
    }

    static class Hello { //HelloController.Hello라고 볼수있겠지 static을 썼으니까
        private String name; //이름은 외부에서 못보게 해야지 ㅇㅇ

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}