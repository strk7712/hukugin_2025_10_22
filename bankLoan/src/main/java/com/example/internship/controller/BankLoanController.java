package com.example.internship.controller;

import com.example.internship.entity.BankLoanForm;
import com.example.internship.service.ApplyBankLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BankLoanController {

    @Autowired
    private ApplyBankLoanService applyBankLoanService;

    // /bankLoanにアクセスされたものは24行目から動くように設定
    @GetMapping("/bankLoan")
    public String bankLoan(Model model) {
        // 金融機関名のセレクトボックス内の選択肢を生成
        List<String> bankName = new ArrayList<>();
        bankName.add("A銀行");
        bankName.add("B銀行");
        bankName.add("C銀行");

        // 科目名のセレクトボックス内の選択肢を生成
        List<String> bankAccountType = new ArrayList<>();
        bankAccountType.add("普通");
        bankAccountType.add("定期");
        bankAccountType.add("当座");
        bankAccountType.add("貯蓄");
        bankAccountType.add("その他");

        //bankLoanMain.htmlのbankLoanApplicationという文字列にBankLoanFormが入る
        model.addAttribute("bankLoanApplication", new BankLoanForm());
        //bankLoanMain.htmlのbankNameという文字列に変数bankNameに入っているデータが入る(以下同様)
        model.addAttribute("bankName", bankName);
        model.addAttribute("bankAccountTypeOptions", bankAccountType);
        // resources/templates/bankLoanMain.htmlを画面へ描写
        return "bankLoanMain";
    }

    // postで/bankLoanConfirmationに飛んできたものは50行目から動くように設定
    @PostMapping("/bankLoanConfirmation")
    public String confirmation(@ModelAttribute BankLoanForm bankLoanForm, Model model) {
        //bankLoanConfirmation.htmlのbankLoanApplicationという文字列にbankLoanFormが入る
        model.addAttribute("bankLoanApplication", bankLoanForm);
        //bankLoanConfirmation.htmlのbankNameという文字列に変数bankLoanFormに入っているbankNameのデータが入る(以下同様)
        model.addAttribute("bankName", bankLoanForm.getBankName());
        model.addAttribute("branchName", bankLoanForm.getBranchName());
        model.addAttribute("bankAccountType", bankLoanForm.getBankAccountType());
        model.addAttribute("bankAccountNum", bankLoanForm.getBankAccountNum());
        model.addAttribute("name", bankLoanForm.getName());
        model.addAttribute("loanAmount", bankLoanForm.getLoanAmount());
        model.addAttribute("annualIncome", bankLoanForm.getAnnualIncome());
        model.addAttribute("interestRate", bankLoanForm.getInterestRate());
        return "bankLoanConfirmation";
    }

    // postで/bankLoanCompletionに飛んできたものは67行目から動くように設定
    @PostMapping("/bankLoanCompletion")
    public String completion(@ModelAttribute BankLoanForm bankLoanForm) {
        // ユーザーの入力内容をDBに入れる（service/ApplyBankLoanService.javaのapplyBankLoanServiceメソッドへ
        applyBankLoanService.applyBankLoan(bankLoanForm);
        return "bankLoanCompletion";
    }

}
