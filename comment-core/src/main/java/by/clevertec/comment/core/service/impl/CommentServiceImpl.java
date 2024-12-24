package by.clevertec.comment.core.service.impl;

import by.clevertec.comment.core.domain.Comment;
import by.clevertec.comment.core.port.out.CommentOutPort;
import by.clevertec.comment.core.service.CommentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentOutPort adapter;

    @Override
    public List<Comment> findCommentsByNews(UUID newsId) {
        return adapter.findAllByNews(newsId);
    }
}
