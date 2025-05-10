package by.clevertec.comment.api.mapper;

import by.clevertec.comment.api.entity.CommentEntity;
import by.clevertec.comment.api.entity.dto.CommentCreate;
import by.clevertec.comment.api.entity.dto.CommentResponse;
import by.clevertec.comment.api.entity.dto.CommentUpdate;
import by.clevertec.comment.core.domain.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    Comment toDomain(CommentEntity commentEntity);
    List<Comment> toDomainList(List<CommentEntity> entities);

    List<CommentResponse> toResponseList(List<Comment> comments);

    CommentResponse toResponse(Comment comment);

    Comment toDomain(CommentCreate commentCreate);

    Comment toDomain(CommentUpdate commentUpdate);

    CommentEntity toEntity(Comment comment);

    List<CommentEntity> toEntities(List<Comment> comments);

}
