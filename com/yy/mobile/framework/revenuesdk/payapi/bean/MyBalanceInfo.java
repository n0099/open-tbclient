package com.yy.mobile.framework.revenuesdk.payapi.bean;

import java.util.Map;
/* loaded from: classes7.dex */
public class MyBalanceInfo {
    public long minAmountLimit;
    public Map<Integer, AccountPeriod> myAccountPeriodMap;
    public Map<Integer, Account> myBalanceMap;

    /* loaded from: classes7.dex */
    public static class Account {
        public int accountFrozen;
        public long amount;
        public int currencyType;
        public long expireAmount;
        public String expireDate;
        public long freezed;

        public String toString() {
            return "Account{currencyType=" + this.currencyType + ", amount=" + this.amount + ", freezed=" + this.freezed + ", accountFrozen=" + this.accountFrozen + ", expireAmount = " + this.expireAmount + ", expireDate = " + this.expireDate + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class AccountPeriod {
        public int amount;
        public int currencyType;
        public long endTime;
        public long startTime;

        public String toString() {
            return "AccountPeriod{currencyType=" + this.currencyType + ", amount=" + this.amount + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
        }
    }

    public MyBalanceInfo(Map<Integer, Account> map, Map<Integer, AccountPeriod> map2, long j) {
        this.myBalanceMap = map;
        this.myAccountPeriodMap = map2;
        this.minAmountLimit = j;
    }

    public long getMinAmountLimit() {
        return this.minAmountLimit;
    }

    public AccountPeriod getMyAccountPeriod(int i2) {
        Map<Integer, AccountPeriod> map = this.myAccountPeriodMap;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.myAccountPeriodMap.get(Integer.valueOf(i2));
        }
        return new AccountPeriod();
    }

    public Account getMyBalance(int i2) {
        Map<Integer, Account> map = this.myBalanceMap;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.myBalanceMap.get(Integer.valueOf(i2));
        }
        return new Account();
    }

    public String toString() {
        return "MyBalanceInfo{myBalanceMap=" + this.myBalanceMap + "minAmountLimit=" + this.minAmountLimit + '}';
    }
}
