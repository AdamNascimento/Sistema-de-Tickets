import jakarta.persistence.*;
import lombok.*;

@Entity
@table(name = "Users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class user {
    @Id
    @GeneratedValue(strategy = GeneretionType.IDENTITY)

    private Long id;
    private String nome;

    //garante que dois usuarios não tenham o mesmo email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private enum Role{ USER, ADMNIN}

}