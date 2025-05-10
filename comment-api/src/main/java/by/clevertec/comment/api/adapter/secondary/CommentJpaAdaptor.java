package by.clevertec.comment.api.adapter.secondary;

import by.clevertec.comment.api.entity.CommentEntity;
import by.clevertec.comment.api.exception.NotFoundDataException;
import by.clevertec.comment.api.mapper.CommentMapper;
import by.clevertec.comment.api.repository.CommentRepository;
import by.clevertec.comment.core.domain.Comment;
import by.clevertec.comment.core.port.out.CommentOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentJpaAdaptor implements CommentOutPort {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Override
    public List<Comment> findAllByNews(UUID newsId) {
        return mapper.toDomainList(
                repository.findAllByNewsId(newsId));
    }

    @Override
    public Comment findComment(UUID commentID) {
        return mapper.toDomain(repository.findById(commentID).orElseThrow(
                () -> new NotFoundDataException(commentID, CommentEntity.class)
        ));
    }

    @Override
    public Comment createComment(Comment comment) {
        return mapper.toDomain(repository.save(mapper.toEntity(comment)));
    }

    @Override
    public void deleteComment(Comment comment) {
        repository.delete(mapper.toEntity(comment));
    }

    @Override
    public void deleteAllCommentByNews(List<Comment> comments) {
        repository.deleteAll(mapper.toEntities(comments));
    }
}
