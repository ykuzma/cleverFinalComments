package by.clevertec.comment.core.port.out;

import by.clevertec.comment.core.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentOutPort {
    List<Comment> findAllByNews(UUID newsId);
}
