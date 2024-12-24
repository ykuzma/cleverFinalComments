package by.clevertec.comment.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private UUID id;
    private LocalDateTime time;
    private String text;
    private String username;
    private UUID newsId;

    public Comment update(Comment update) {
        return Comment.builder()
                .id(id)
                .time(time)
                .newsId(newsId)
                .username(username)
                .text(update.getText())
                .build();
    }
}
