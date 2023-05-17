package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetSplitOrderConfigRequest implements IRequestProtocol {
    public long amount;
    public int appId;
    public int currencyType;
    public String expand;
    public String orderId;
    public String seq;
    public int type;
    public long uid;
    public int usedChannel;

    public GetSplitOrderConfigRequest(long j, int i, int i2, int i3, String str, String str2, String str3, long j2, int i4) {
        this.usedChannel = 10002;
        this.uid = j;
        this.type = i;
        this.appId = i2;
        this.usedChannel = i3;
        this.seq = str;
        this.expand = str2;
        this.orderId = str3;
        this.amount = j2;
        this.currencyType = i4;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", RevenueServerConst.GetChargeCurrencySplitRequest);
            jSONObject.put("uid", this.uid);
            jSONObject.put("type", this.type);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("seq", this.seq);
            jSONObject.put("orderId", this.orderId);
            jSONObject.put(PayUiEventContent.AMOUNT, this.amount);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put("expand", this.expand);
            return jSONObject.toString();
        } catch (JSONException e) {
            RLog.error("GetSplitOrderConfigRequest", "constructPSCIMessageRequest", e);
            return "";
        }
    }
}
