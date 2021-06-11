package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetUserYbDetailsRequest implements IRequestProtocol {
    public int appId;
    public int page;
    public int pagesize;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetUserYbDetailsRequest(long j, int i2, int i3, int i4, String str, int i5) {
        this.pagesize = 20;
        this.uid = j;
        this.appId = i2;
        this.pagesize = i3;
        this.page = i4;
        this.seq = str;
        this.usedChannel = i5;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", RevenueServerConst.GetUserYbDetailsRequest);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("pagesize", this.pagesize);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("page", this.page);
            jSONObject.put("usedChannel", this.usedChannel);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            RLog.error("GetUserYbDetailsRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
