package gps.base.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "favorite")
@IdClass(FavoriteId.class)
public class Favorite {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @Column(name = "added_at", nullable = false, updatable = false)
    private LocalDateTime addedAt;

    @Column(name = "is_favorite", nullable = false)
    private Boolean isFavorite;



    // Constructor

    public Favorite() {
    }


    // 현재시간 자동 생성
    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "user=" + (user != null ? user.getUserId() : null) +
                ", gym=" + (gym != null ? gym.getGymId() : null) +
                ", addedAt=" + addedAt +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
