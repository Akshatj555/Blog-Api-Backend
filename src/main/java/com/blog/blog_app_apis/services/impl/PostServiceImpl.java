package com.blog.blog_app_apis.services.impl;

import com.blog.blog_app_apis.entities.Category;
import com.blog.blog_app_apis.entities.Post;
import com.blog.blog_app_apis.entities.User;
import com.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog.blog_app_apis.payload.PostDto;
import com.blog.blog_app_apis.payload.PostResponse;
import com.blog.blog_app_apis.repositories.CategoryRepo;
import com.blog.blog_app_apis.repositories.PostRepo;
import com.blog.blog_app_apis.repositories.UserRepo;
import com.blog.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", " User Id ", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", " Category Id ", categoryId));

        Post createdPost = modelMapper.map(postDto, Post.class);
        createdPost.setImageName("default.png");
        createdPost.setAddedDate(new Date());
        System.out.println("Adding user: " + user);
        createdPost.setUser(user);
        System.out.println("Adding category: " + category);
        createdPost.setCategory(category);
        Post savedPost = postRepo.save(createdPost);
        PostDto createdPostDto = modelMapper.map(savedPost, PostDto.class);
        System.out.println("Saved PostDto: " + createdPostDto);
        return createdPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", " Id ", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = postRepo.save(post);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {

        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post "," Id ", postId));
        postRepo.delete(post);
    }

//    @Override
//    public List<PostDto> getAllPost() {
//
//        List<Post> allPosts = postRepo.findAll();
//        return allPosts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

//        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Pageable page = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> postsPage = postRepo.findAll(page);
        List<Post> allPosts = postsPage.getContent();
        List<PostDto> postDtos = allPosts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(postsPage.getNumber());
        postResponse.setPageSize(postsPage.getSize());
        postResponse.setTotalElements(postsPage.getTotalElements());
        postResponse.setTotalPages(postsPage.getTotalPages());
        postResponse.setLastPage(postsPage.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", " Post Id ", postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", " Category Id ", categoryId));
        List<Post> postsByCategory = postRepo.findByCategory(category);
        List<PostDto> postDtosList = postsByCategory.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtosList;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", " User Id ", userId));
        List<Post> postsByUser = postRepo.findByUser(user);
        List<PostDto> postDtoList = postsByUser.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
