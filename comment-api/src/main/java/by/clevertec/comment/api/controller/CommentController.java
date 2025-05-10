package by.clevertec.comment.api.controller;

import by.clevertec.comment.api.entity.dto.CommentCreate;
import by.clevertec.comment.api.entity.dto.CommentResponse;
import by.clevertec.comment.api.entity.dto.CommentUpdate;
import by.clevertec.comment.api.mapper.CommentMapper;
import by.clevertec.comment.core.service.CommentService;
import by.clevertec.starter.logging.annotation.Logging;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentMapper mapper;
    private final CommentService service;

    @Logging
    @GetMapping("/news/{newsId}")
    public ResponseEntity<List<CommentResponse>> getCommentsByNews(@PathVariable UUID newsId) {

        return new ResponseEntity<>(
                mapper.toResponseList(service.findCommentsByNews(newsId)),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentResponse> addComment(@RequestBody CommentCreate commentCreate) {
        return new ResponseEntity<>(
                mapper.toResponse(service.createComment(mapper.toDomain(commentCreate))),
                HttpStatus.CREATED);
    }

    @GetMapping("/{commentsID}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable UUID commentsID) {
        return new ResponseEntity<>(
                mapper.toResponse(service.findComment(commentsID)),
                HttpStatus.OK);
    }

    @PutMapping("/{commentsId}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable UUID commentsId,
                                                         @RequestBody CommentUpdate commentsUpdate) {
        return new ResponseEntity<>(
                mapper.toResponse(service.updateContentComment(
                        mapper.toDomain(commentsUpdate),
                        commentsId)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable UUID commentId){
        service.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/news/{newsId}")
    public ResponseEntity<Void> deleteCommentByNews(@PathVariable UUID newsId){
        service.deleteAllCommentByNews(newsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
