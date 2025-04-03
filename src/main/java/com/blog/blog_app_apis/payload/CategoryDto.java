package com.blog.blog_app_apis.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "Category Title should be more than 4 characters!!")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Category Description should be more than 10 characters!!")
    private String categoryDescription;
}
