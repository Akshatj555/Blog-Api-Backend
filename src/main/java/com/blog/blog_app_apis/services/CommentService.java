package com.blog.blog_app_apis.services;

import com.blog.blog_app_apis.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
