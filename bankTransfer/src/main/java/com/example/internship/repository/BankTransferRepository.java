package com.example.internship.repository;

import com.example.internship.entity.BankTransferForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankTransferRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(BankTransferForm bankTransferForm) {
        // ユーザーの入力内容をDBに入れるSQLを準備
        String sql = "INSERT INTO bankTransfer_table(bankName, branchName, bankAccountType, bankAccountNum, name, money, transferDateTime) VALUES(?,?,?,?,?,?,?)";
        // ユーザーの入力内容をDBに入れるSQLを実施
        // bankTransfer_tableのbankNameのカラムにbankTransferForm.getBankName()が入る(15行目のsqlのbankNameと一番目の?とbankTransferForm.getBankName()が紐づく)、その他も同様
        jdbcTemplate.update(sql, bankTransferForm.getBankName(), bankTransferForm.getBranchName(), bankTransferForm.getBankAccountType(), bankTransferForm.getBankAccountNum(), bankTransferForm.getName(), bankTransferForm.getMoney(), bankTransferForm.getTransferDate());
    }
}