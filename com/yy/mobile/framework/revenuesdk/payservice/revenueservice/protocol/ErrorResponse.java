package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ErrorResponse implements IBaseJsonResponse {
    public int appid;
    public int cmd;
    public int result;
    public String seq;
    public long uid;

    public ErrorResponse(String str) {
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cmd = jSONObject.optInt("cmd");
                this.appid = jSONObject.optInt("appid");
                this.uid = jSONObject.optLong("uid");
                this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                RLog.info("ErrorResponse", "jsonObject", jSONObject);
                return;
            } catch (JSONException e2) {
                RLog.error("ErrorResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                RLog.error("ErrorResponse", "parserResponse error.", e3);
                return;
            }
        }
        RLog.error("ErrorResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
