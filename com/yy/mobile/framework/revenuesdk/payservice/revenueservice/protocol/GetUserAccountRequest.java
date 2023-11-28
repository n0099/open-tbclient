package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetUserAccountRequest implements IRequestProtocol {
    public int appId;
    public boolean returnYb;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetUserAccountRequest(String str, long j, int i, int i2, boolean z) {
        this.seq = str;
        this.uid = j;
        this.appId = i;
        this.usedChannel = i2;
        this.returnYb = z;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1005);
            jSONObject.put("seq", this.seq);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("returnYb", this.returnYb);
            jSONObject.put("returnImid", true);
            return jSONObject.toString();
        } catch (JSONException e) {
            RLog.error("GetUserAccountRequest", "constructPSCIMessageRequest error.", e);
            return "";
        }
    }
}
