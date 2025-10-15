package com.example.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankLoanForm {
    @NonNull
    private String bankName;
    @NonNull
    private String branchName;
    @NonNull
    private String bankAccountType;
    @NonNull
    private Integer bankAccountNum;
    @NonNull
    private String name;
    @NonNull
    private Integer loanAmount;
    @NonNull
    private Integer annualIncome;
    @NonNull
    private Integer interestRate;

    // BankLoanFormにあるbankNameのデータを取り出す関数
    public @NonNull String getBankName() {
        return bankName;
    }

    // BankLoanFormにあるbankNameにデータを入れる・上書きする関数
    public void setBankName(@NonNull String bankName) {
        this.bankName = bankName;
    }

    public @NonNull String getBranchName() {
        return branchName;
    }

    public void setBranchName(@NonNull String branchName) {
        this.branchName = branchName;
    }

    public @NonNull String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(@NonNull String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public @NonNull Integer getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(@NonNull Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(@NonNull Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public @NonNull Integer getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(@NonNull Integer annualIncome) {
        this.annualIncome = annualIncome;
    }

    public @NonNull Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(@NonNull Integer interestRate) {
        this.interestRate = interestRate;
    }
}
