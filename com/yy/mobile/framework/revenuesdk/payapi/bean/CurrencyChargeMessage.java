package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public class CurrencyChargeMessage {
    public long amount;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public String orderId;
    public boolean pollingTimeout;
    public int status;
    public long uid;
    public int usedChannel;

    public String toString() {
        return "CurrencyChargeMessage{appid=" + this.appid + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', pollingTimeout='" + this.pollingTimeout + "'}";
    }
}
