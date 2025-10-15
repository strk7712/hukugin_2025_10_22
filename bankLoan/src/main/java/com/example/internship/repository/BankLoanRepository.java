package com.example.internship.repository;

import com.example.internship.entity.BankLoanForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankLoanRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(BankLoanForm bankLoanForm) {
        // ユーザーの入力内容をDBに入れるSQLを準備
        String sql = "INSERT INTO bankLoan_table(bankName,branchName,bankAccountType,bankAccountNum,name,loanAmount,annualIncome,interestRate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        // ユーザーの入力内容をDBに入れるSQLを実施
        // bankLoan_tableのbankNameのカラムにbankLoanForm.getBankName()が入る(15行目のsqlのbankNameと一番目の?とbankLoanForm.getBankName()が紐づく)、その他も同様
        jdbcTemplate.update(sql, bankLoanForm.getBankName(), bankLoanForm.getBranchName(), bankLoanForm.getBankAccountType(),bankLoanForm.getBankAccountNum(),bankLoanForm.getName(),bankLoanForm.getLoanAmount(),bankLoanForm.getAnnualIncome(),bankLoanForm.getInterestRate());
    }

}
