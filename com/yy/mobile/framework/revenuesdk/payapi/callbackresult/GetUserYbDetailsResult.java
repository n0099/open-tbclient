package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.YbChargeItemInfo;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class GetUserYbDetailsResult {
    public int result;
    public int total;
    public List<YbChargeItemInfo> ybChargeItemInfoList;

    public GetUserYbDetailsResult(int i2, int i3, List<YbChargeItemInfo> list) {
        this.result = -1;
        this.result = i2;
        this.total = i3;
        this.ybChargeItemInfoList = list;
    }

    public int getResult() {
        return this.result;
    }

    public int getTotal() {
        return this.total;
    }

    public List<YbChargeItemInfo> getYbChargeItemInfoList() {
        return this.ybChargeItemInfoList;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }

    public void setYbChargeItemInfoList(List<YbChargeItemInfo> list) {
        this.ybChargeItemInfoList = list;
    }
}
