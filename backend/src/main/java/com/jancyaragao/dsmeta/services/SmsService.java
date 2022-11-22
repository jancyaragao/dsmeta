package com.jancyaragao.dsmeta.services;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jancyaragao.dsmeta.entities.Sale;
import com.jancyaragao.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        Locale locale = Locale.of("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);

        String text = "O vendedor " + sale.getSellerName() + " foi destaque em " + formatter.format(sale.getDate()
                .getMonth()) + " de " + sale.getDate().getYear() + " com um total de " + sale.getVisited()
                + " visitas, resultando em " + sale.getDeals() + " venda(s) que totalizaram R$"
                + String.format("%.2f", sale.getAmount());

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, text).create();

        System.out.println(message.getSid());
    }

}
