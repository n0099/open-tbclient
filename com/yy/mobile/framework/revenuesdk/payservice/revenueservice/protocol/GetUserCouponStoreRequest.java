package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetUserCouponStoreRequest implements IRequestProtocol {
    public int appId;
    public int goodsType;
    public boolean hasUsed;
    public boolean includeExpire;
    public int page;
    public int pageSize;
    public String seq;
    public long uid;

    public GetUserCouponStoreRequest(String str, long j, int i2, String str2, int i3, boolean z, int i4, int i5, boolean z2) {
        this.seq = str;
        this.uid = j;
        this.appId = i2;
        this.goodsType = i3;
        this.hasUsed = z;
        this.page = i4;
        this.pageSize = i5;
        this.includeExpire = z2;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1047);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("goodsType", this.goodsType);
            jSONObject.put("hasUsed", this.hasUsed);
            jSONObject.put("page", this.page);
            jSONObject.put("pageSize", this.pageSize);
            jSONObject.put("includeExpire", this.includeExpire);
            return jSONObject.toString();
        } catch (JSONException e2) {
            RLog.error("GetUserCouponStoreRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
