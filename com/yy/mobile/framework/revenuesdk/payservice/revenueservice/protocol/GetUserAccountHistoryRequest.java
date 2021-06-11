package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetUserAccountHistoryRequest implements IRequestProtocol {
    public int appId;
    public int currencyType;
    public String expand;
    public long lastId;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetUserAccountHistoryRequest(long j, int i2, int i3, int i4, String str, String str2, long j2) {
        this(j, i2, i3, i4, str, str2, j2, "");
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1046);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("lastId", this.lastId);
            jSONObject.put("expand", this.expand);
            return jSONObject.toString();
        } catch (JSONException e2) {
            RLog.error("GetUserAccountHistoryRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }

    public GetUserAccountHistoryRequest(long j, int i2, int i3, int i4, String str, String str2, long j2, String str3) {
        this.usedChannel = 10002;
        this.uid = j;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.seq = str;
        this.lastId = j2;
        this.expand = str3;
    }
}
