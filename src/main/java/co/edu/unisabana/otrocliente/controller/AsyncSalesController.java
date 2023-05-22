package co.edu.unisabana.otrocliente.controller;

import co.edu.unisabana.otrocliente.model.AsyncSale;
import co.edu.unisabana.otrocliente.model.CartItem;
import co.edu.unisabana.otrocliente.service.ISale;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class AsyncSalesController {
    private ISale saleService;
    private Gson gson;
    @PostMapping("/{document}/{address}")
    public String notifySale(@PathVariable int document, @PathVariable String address, @RequestBody List<CartItem> cartItems) {
        AsyncSale asyncSale = new AsyncSale(document, cartItems, address);
        String jsonSale = gson.toJson(asyncSale);
        return saleService.makeSaleAsync(jsonSale);
    }
}
