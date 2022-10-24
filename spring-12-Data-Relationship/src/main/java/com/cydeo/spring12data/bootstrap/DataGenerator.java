package com.cydeo.spring12data.bootstrap;

import com.cydeo.spring12data.entitiy.Payment;
import com.cydeo.spring12data.entitiy.PaymentDetail;
import com.cydeo.spring12data.enums.Status;
import com.cydeo.spring12data.repository.PaymentRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;

    public DataGenerator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        System.out.println(paymentRepository.findById(2L).get().getPaymentDetail().getCommissionAmount());// coming jpa method

        paymentRepository.delete(payment1);
        //paymentDetailRepository.save(payment1) if we use it, it can work

    }
}
