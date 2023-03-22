package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
@Keep
/* loaded from: classes9.dex */
public class MyBalanceResult {
    public MyBalanceInfo myBalanceInfo;

    public MyBalanceResult(MyBalanceInfo myBalanceInfo) {
        this.myBalanceInfo = myBalanceInfo;
    }

    public MyBalanceInfo.AccountPeriod getMyAccountPeriod(int i) {
        MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
        if (myBalanceInfo == null) {
            return new MyBalanceInfo.AccountPeriod();
        }
        return myBalanceInfo.getMyAccountPeriod(i);
    }

    public MyBalanceInfo.Account getMyBalance(int i) {
        MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
        if (myBalanceInfo == null) {
            return new MyBalanceInfo.Account();
        }
        return myBalanceInfo.getMyBalance(i);
    }

    public MyBalanceInfo getMyBalanceInfo() {
        return this.myBalanceInfo;
    }
}
