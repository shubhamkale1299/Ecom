package org.zeroclub.ecom.contoller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zeroclub.ecom.dto.OrderResponse;
import org.zeroclub.ecom.service.OrderService;

@RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/orders")
    public class OrderController {
        private final OrderService orderService;

        @PostMapping
        public ResponseEntity<OrderResponse> createOrder(
                @RequestHeader("X-User-ID") String userId) {
            return orderService.createOrder(userId)
                    .map(orderResponse -> new ResponseEntity<>(orderResponse, HttpStatus.CREATED))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

