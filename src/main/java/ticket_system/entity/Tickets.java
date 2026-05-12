package ticket_system.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Tickets")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = Status.OPEN;
        if (this.priority == null) this.priority = Priority.MEDIUM;
    }

    public enum Status { OPEN, IN_PROGRESS, CLOSED }
    public enum Priority { LOW, MEDIUM, HIGH }
}
