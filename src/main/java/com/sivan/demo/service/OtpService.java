package com.sivan.demo.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OtpService {

    private Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public String generateOtp(String phone) {
        String otp = String.valueOf((int)(Math.random() * 9000) + 1000);
        otpStorage.put(phone, otp);
        return otp;
    }

    public boolean verifyOtp(String phone, String otp) {
        return otp.equals(otpStorage.get(phone));
    }
}
