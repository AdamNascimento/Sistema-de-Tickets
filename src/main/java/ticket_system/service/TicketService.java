package ticket_system.service;

import ticket_system.entity.Tickets;
import ticket_system.entity.User;
import ticket_system.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ticket_system.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TicketService {

    private final TicketRepository ticketRepository;
// Cria o ticket e salva no repositorio
    public Tickets create(Tickets ticket, User user){
        ticket.setUser(user);
        return ticketRepository.save(ticket);

    }
//Lista os tickets salvos
    public List<Tickets> findAll(){
        return ticketRepository.findAll();
    }
//Procura os tickets salvos
    public Tickets findById(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado "));
    }
//Atualiza os tickets salvos podendo mudar; titulo, Descrição, Status, Prioridade e Usuario
    public Tickets update(Long id, Tickets updated){
        Tickets ticket = findById(id);
        ticket.setTitle(updated.getTitle());
        ticket.setDescription(updated.getDescription());
        ticket.setStatus(updated.getStatus());
        ticket.setPriority(updated.getPriority());
        ticket.setUser(updated.getUser());
        return ticketRepository.save(ticket);
    }
//Deleta
    public void delete(Long id){
        ticketRepository.deleteById(id);
    }
}
