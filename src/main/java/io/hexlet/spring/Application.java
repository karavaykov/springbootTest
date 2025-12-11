package io.hexlet.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import io.hexlet.spring.Post;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String home() {

        return "Home";
    }



    // BEGIN (write your solution here)
    @GetMapping("/posts")
    public List<Post> index(@RequestParam(defaultValue = "10") Integer limit) {
                var a = posts.stream().limit(limit).toList();
        return a;
    }

@GetMapping("/posts/{id}")
    public Optional<Post> show(@PathVariable String id) {
        try {
            Long postId = Long.parseLong(id);
            int index = Math.toIntExact(postId) - 1;
            if (index >= 0 && index < posts.size()) {
                return Optional.of(posts.get(index));
            } else {
                return Optional.empty();
            }
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}") // Обновление страницы
    public Post update(@PathVariable String id, @RequestBody Post data) {
        var maybePage = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePage.isPresent()) {
            var post = maybePage.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }


    // END
}

