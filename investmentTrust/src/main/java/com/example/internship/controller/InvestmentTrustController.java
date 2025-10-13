package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
        List<String> bankName = new ArrayList<>();
        bankName.add("海");
        bankName.add("陸");
        bankName.add("空");

        List<String> bankAccountType = new ArrayList<>();
        bankAccountType.add("普通");
        bankAccountType.add("定期");
        bankAccountType.add("当座");
        bankAccountType.add("貯蓄");
        bankAccountType.add("その他");

        List<String> fundName = new ArrayList<>();
        fundName.add("M&H 500");
        fundName.add("G&P 200");
        fundName.add("J&T 1000");

        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        model.addAttribute("bankName", bankName);
        model.addAttribute("bankAccountTypeOptions", bankAccountType);
        model.addAttribute("fundNameOptions", fundName);
        return "investmentTrustMain";
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        model.addAttribute("investmentTrustApplication", investmentTrustForm);
        model.addAttribute("bankName", investmentTrustForm.getBankName());
        model.addAttribute("branchName", investmentTrustForm.getBranchName());
        model.addAttribute("bankAccountType", investmentTrustForm.getBankAccountType());
        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
        model.addAttribute("name", investmentTrustForm.getName());
        model.addAttribute("fundName", investmentTrustForm.getFundName());
        model.addAttribute("money", investmentTrustForm.getMoney());
        return "investmentTrustConfirmation";
    }

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }

}
