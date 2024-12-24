package by.clevertec.comment.core.service;

import by.clevertec.comment.core.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    List<Comment> findCommentsByNews(UUID newsId);


}
