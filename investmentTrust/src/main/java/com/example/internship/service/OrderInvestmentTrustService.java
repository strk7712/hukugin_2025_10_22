package com.example.internship.service;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.repository.InvestmentTrustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderInvestmentTrustService {
    @Autowired
    private InvestmentTrustRepository investmentTrustRepository;

    public void orderInvestmentTrust(InvestmentTrustForm investmentTrustForm) {
        // ユーザーの入力内容をDBに入れる（repository/InvestmentTrustRepository.javaのcreateメソッドへ）
        investmentTrustRepository.create(investmentTrustForm);
    }
}
