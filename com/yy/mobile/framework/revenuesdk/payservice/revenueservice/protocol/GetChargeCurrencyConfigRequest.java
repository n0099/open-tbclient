package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetChargeCurrencyConfigRequest implements IRequestProtocol {
    public int appId;
    public int currencyType;
    public String expand;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetChargeCurrencyConfigRequest(long j, int i, int i2, int i3, String str, String str2, String str3) {
        this.usedChannel = 10002;
        this.expand = "";
        this.uid = j;
        this.appId = i;
        this.usedChannel = i2;
        this.currencyType = i3;
        this.seq = str;
        this.expand = str3;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1021);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put("seq", this.seq);
            jSONObject.put("expand", this.expand);
            return jSONObject.toString();
        } catch (JSONException e) {
            RLog.error("GetChargeCurrencyConfigRequest", "constructPSCIMessageRequest error.", e);
            return "";
        }
    }
}
