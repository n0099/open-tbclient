package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetHasChargeInActivityRequest implements IRequestProtocol {
    public int activityId;
    public int appId;
    public int currencyType;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetHasChargeInActivityRequest(String str, long j, int i2, int i3, int i4, int i5, String str2) {
        this.seq = str;
        this.uid = j;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.activityId = i5;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1026);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put("activityId", this.activityId);
            return jSONObject.toString();
        } catch (JSONException e2) {
            RLog.error("GetHasChargeInActivityRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
