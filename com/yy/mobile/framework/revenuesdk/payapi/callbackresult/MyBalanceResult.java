package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
@Keep
/* loaded from: classes7.dex */
public class MyBalanceResult {
    public MyBalanceInfo myBalanceInfo;

    public MyBalanceResult(MyBalanceInfo myBalanceInfo) {
        this.myBalanceInfo = myBalanceInfo;
    }

    public MyBalanceInfo.AccountPeriod getMyAccountPeriod(int i2) {
        MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
        if (myBalanceInfo == null) {
            return new MyBalanceInfo.AccountPeriod();
        }
        return myBalanceInfo.getMyAccountPeriod(i2);
    }

    public MyBalanceInfo.Account getMyBalance(int i2) {
        MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
        if (myBalanceInfo == null) {
            return new MyBalanceInfo.Account();
        }
        return myBalanceInfo.getMyBalance(i2);
    }
}
