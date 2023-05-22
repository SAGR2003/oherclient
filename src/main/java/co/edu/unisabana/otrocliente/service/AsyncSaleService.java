package co.edu.unisabana.otrocliente.service;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@EnableRabbit
public class AsyncSaleService implements ISale {
    private RabbitTemplate rabbitTemplate;

    @Override
    public String makeSaleAsync(String shoppingCart) {
        rabbitTemplate.convertAndSend("exchangeSale", "Sale", shoppingCart);
        return shoppingCart;
    }
}