package by.clevertec.comment.core.service;

import by.clevertec.comment.core.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    List<Comment> findCommentsByNews(UUID newsId);
    Comment findComment(UUID commentID);

    Comment createComment(Comment comment);
    Comment updateContentComment(Comment update, UUID commentId);
    void deleteComment(UUID commentID);

    void deleteAllCommentByNews(UUID newsID);


}
