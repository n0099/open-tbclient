package com.yy.mobile.framework.revenuesdk.payapi.bean;

import java.util.Map;
/* loaded from: classes2.dex */
public class MyBalanceInfo {
    public long imid;
    public long minAmountLimit;
    public Map<Integer, AccountPeriod> myAccountPeriodMap;
    public Map<Integer, Account> myBalanceMap;

    public MyBalanceInfo(Map<Integer, Account> map, Map<Integer, AccountPeriod> map2, long j, long j2) {
        this.myBalanceMap = map;
        this.myAccountPeriodMap = map2;
        this.minAmountLimit = j;
        this.imid = j2;
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class AccountPeriod {
        public int amount;
        public int currencyType;
        public long endTime;
        public long startTime;

        public String toString() {
            return "AccountPeriod{currencyType=" + this.currencyType + ", amount=" + this.amount + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
        }
    }

    public long getImid() {
        return this.imid;
    }

    public long getMinAmountLimit() {
        return this.minAmountLimit;
    }

    public String toString() {
        return "MyBalanceInfo{myBalanceMap=" + this.myBalanceMap + "minAmountLimit=" + this.minAmountLimit + "imid=" + this.imid + '}';
    }

    public AccountPeriod getMyAccountPeriod(int i) {
        Map<Integer, AccountPeriod> map = this.myAccountPeriodMap;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            return this.myAccountPeriodMap.get(Integer.valueOf(i));
        }
        return new AccountPeriod();
    }

    public Account getMyBalance(int i) {
        Map<Integer, Account> map = this.myBalanceMap;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            return this.myBalanceMap.get(Integer.valueOf(i));
        }
        return new Account();
    }
}
