package by.clevertec.comment.core.port.out;

import by.clevertec.comment.core.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentOutPort {
    List<Comment> findAllByNews(UUID newsId);
    Comment findComment(UUID commentID);

    Comment createComment(Comment comment);

    void deleteComment(Comment comment);
    void deleteAllCommentByNews(List<Comment> comments);

}
