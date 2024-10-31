package com.example.demo.controller;

import com.example.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

//    @GetMapping("/")
//    public ResponseEntity<String> test() {
//        return new ResponseEntity<>("<html>\n" +
//                "<!-- Text between angle brackets is an HTML tag and is not displayed.\n" +
//                "Most tags, such as the HTML and /HTML tags that surround the contents of\n" +
//                "a page, come in pairs; some tags, like HR, for a horizontal rule, stand \n" +
//                "alone. Comments, such as the text you're reading, are not displayed when\n" +
//                "the Web page is shown. The information between the HEAD and /HEAD tags is \n" +
//                "not displayed. The information between the BODY and /BODY tags is displayed.-->\n" +
//                "<head>\n" +
//                "<title>Enter a title, displayed at the top of the window.</title>\n" +
//                "</head>\n" +
//                "<!-- The information between the BODY and /BODY tags is displayed.-->\n" +
//                "<body>\n" +
//                "<h1>Enter the main heading, usually the same as the title.</h1>\n" +
//                "<p>Be <b>bold</b> in stating your key points. Put them in a list: </p>\n" +
//                "<ul>\n" +
//                "<li>The first item in your list</li>\n" +
//                "<li>The second item; <i>italicize</i> key words</li>\n" +
//                "</ul>\n" +
//                "<p>Improve your image by including an image. </p>\n" +
//                "<p><img src=\"http://www.mygifs.com/CoverImage.gif\" alt=\"A Great HTML Resource\"></p>\n" +
//                "<p>Add a link to your favorite <a href=\"https://www.dummies.com/\">Web site</a>.\n" +
//                "Break up your page with a horizontal rule or two. </p>\n" +
//                "<hr>\n" +
//                "<p>Finally, link to <a href=\"page2.html\">another page</a> in your own Web site.</p>\n" +
//                "<!-- And add a copyright notice.-->\n" +
//                "<p>© Wiley Publishing, 2011</p>\n" +
//                "</body>\n" +
//                "</html>", HttpStatus.OK);
//    }

    private final ArrayList<Student> studentList = new ArrayList<>(List.of(new Student(1,"Test1"), new Student(2,"Test2")));

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        return "Hello, Spring Boot!" + request.getSession().getId();
    }


    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }


}
