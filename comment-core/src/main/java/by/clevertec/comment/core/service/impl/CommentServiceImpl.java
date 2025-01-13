package by.clevertec.comment.core.service.impl;

import by.clevertec.comment.core.domain.Comment;
import by.clevertec.comment.core.port.out.CommentOutPort;
import by.clevertec.comment.core.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentOutPort adapter;

    @Override
    public List<Comment> findCommentsByNews(UUID newsId) {
        return adapter.findAllByNews(newsId);
    }

    @Override
    public Comment findComment(UUID commentID) {
        return adapter.findComment(commentID);
    }

    @Override
    public Comment createComment(Comment comment) {
        return adapter.createComment(comment);
    }

    @Override
    public Comment updateContentComment(Comment update, UUID commentID) {
        Comment commentActual = findComment(commentID);
        return commentActual.update(update);
    }

    @Override
    public void deleteComment(UUID commentID) {
        adapter.deleteComment(findComment(commentID));
    }

    @Override
    public void deleteAllCommentByNews(UUID newsID) {
        adapter.findAllByNews(newsID);
        adapter.deleteAllCommentByNews(adapter.findAllByNews(newsID));
    }
}
