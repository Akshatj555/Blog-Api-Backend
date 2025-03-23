package com.blog.blog_app_apis.controllers;

import com.blog.blog_app_apis.payload.PostDto;
import com.blog.blog_app_apis.payload.PostResponse;
import com.blog.blog_app_apis.services.PostService;
import com.blog.blog_app_apis.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){

        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

//    get Post By User

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){

        List<PostDto> postsByUser = postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
    }

//    get Post By Category

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){

        List<PostDto> postsByCategory = postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(postsByCategory, HttpStatus.OK);
    }

//    get All Posts

//    @GetMapping("/posts")
//    public ResponseEntity<List<PostDto>> getAllPosts(){
//
//        List<PostDto> allPosts = postService.getAllPost();
//        return new ResponseEntity<>(allPosts, HttpStatus.OK);
//    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){

        PostResponse allPosts = postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(allPosts, HttpStatus.OK);
    }


//    get Post By Id

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){

        PostDto postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById, HttpStatus.OK);
    }

// delete post

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId){

        postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post is successfully Deleted", true), HttpStatus.OK);
    }

//    update Post

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,@PathVariable Integer postId){

        PostDto updatePost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

}

