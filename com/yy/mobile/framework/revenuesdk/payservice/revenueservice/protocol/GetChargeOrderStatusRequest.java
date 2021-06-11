package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetChargeOrderStatusRequest implements IRequestProtocol {
    public int appId;
    public String expand;
    public String orderId;
    public String seq;
    public long sid;
    public long uid;
    public int usedChannel;

    public GetChargeOrderStatusRequest(String str, long j, long j2, int i2, int i3, String str2, String str3) {
        this.sid = 0L;
        this.usedChannel = 10002;
        this.orderId = str;
        this.uid = j;
        this.sid = j2;
        this.appId = i2;
        this.usedChannel = i3;
        this.seq = str2;
        this.expand = str3;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", RevenueServerConst.GetChargeOrderStatusRequest);
            jSONObject.put("uid", this.uid);
            jSONObject.put("sid", this.sid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("orderId", this.orderId);
            jSONObject.put("expand", this.expand);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            RLog.error("GetChargeOrderStatusRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
