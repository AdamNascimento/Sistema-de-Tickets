package ticket_system.repository;
import ticket_system.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

    public interface TicketRepository extends JpaRepository<Tickets, Long> {
        List<Tickets> findByUserId(Long userId);

    }