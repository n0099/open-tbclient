package com.yy.mobile.framework.revenuesdk.payapi.bean;
@Deprecated
/* loaded from: classes8.dex */
public class AccountDelayMessage {
    public long amount;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public long uid;
    public int usedChannel;

    public String toString() {
        return "CurrencyChargeMessage{appid=" + this.appid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", expand='" + this.expand + "'}";
    }
}
