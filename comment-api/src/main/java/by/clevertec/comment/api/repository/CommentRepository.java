package by.clevertec.comment.api.repository;

import by.clevertec.comment.api.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
    List<CommentEntity> findAllByNewsId(UUID newsId);
}
