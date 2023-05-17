package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes10.dex */
public class CurrencyChargeMessage {
    public long amount;
    public Map<String, String> appClientExpand;
    public int appid;
    public int cid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public GiftBagsInfo giftBagsInfo;
    public String message;
    public String orderId;
    public String payChannel;
    public String payMethod;
    public List<SplitRecordItem> splitRecordItemList;
    public int status;
    public String traceid = "";
    public long uid;
    public int usedChannel;

    public String toString() {
        return "CurrencyChargeMessage{appid=" + this.appid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", message=" + this.message + ", finish=" + this.finish + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', cid='" + this.cid + "', traceid='" + this.traceid + "', appClientExpand='" + this.appClientExpand + "', payMethod='" + this.payMethod + "', payChannel='" + this.payChannel + "', giftBagsInfo='" + this.giftBagsInfo + "', splitRecordItemList='" + this.splitRecordItemList + "'}";
    }
}
