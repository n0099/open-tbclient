package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class CurrencyChargeMessage {
    public long amount;
    public Map<String, String> appClientExpand;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public String orderId;
    public String payChannel;
    public String payMethod;
    public ChargeCurrencyReqParams reqParams;
    public int status;
    public boolean timeout;
    public long uid;
    public int usedChannel;

    public String toString() {
        return "CurrencyChargeMessage{appid=" + this.appid + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', timeout='" + this.timeout + "', appClientExpand='" + this.appClientExpand + "', payMethod='" + this.payMethod + "'}";
    }
}
