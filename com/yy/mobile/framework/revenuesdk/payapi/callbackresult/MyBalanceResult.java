package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.f;
@Keep
/* loaded from: classes7.dex */
public class MyBalanceResult {
    public f myBalanceInfo;

    public MyBalanceResult(f fVar) {
        this.myBalanceInfo = fVar;
    }

    public f.b getMyAccountPeriod(int i2) {
        f fVar = this.myBalanceInfo;
        if (fVar == null) {
            return new f.b();
        }
        return fVar.a(i2);
    }

    public f.a getMyBalance(int i2) {
        f fVar = this.myBalanceInfo;
        if (fVar == null) {
            return new f.a();
        }
        return fVar.b(i2);
    }
}
