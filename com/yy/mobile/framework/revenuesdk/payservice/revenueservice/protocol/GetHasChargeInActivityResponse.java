package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetHasChargeInActivityResponse implements IBaseJsonResponse {
    public int activityId;
    public int chargeCount;
    public int cmd = RevenueServerConst.GetHasChargeInActivityResponse;
    public String endTime;
    public boolean hasCharge;
    public String message;
    public int result;
    public String seq;
    public String startTime;
    public String tip;
    public long uid;

    public GetHasChargeInActivityResponse(String str) {
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.cmd == optInt) {
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                    this.result = jSONObject.optInt("result");
                    this.message = jSONObject.optString("message");
                    this.activityId = jSONObject.optInt("activityId");
                    this.startTime = jSONObject.optString("startTime");
                    this.endTime = jSONObject.optString("endTime");
                    this.hasCharge = jSONObject.optBoolean("hasCharge");
                    this.tip = jSONObject.optString("tip");
                    this.chargeCount = jSONObject.optInt("chargeCount");
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e2) {
                RLog.error("GetHasChargeInActivityResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                RLog.error("GetHasChargeInActivityResponse", "parserResponse error.", e3);
                return;
            }
        }
        RLog.error("GetHasChargeInActivityResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
