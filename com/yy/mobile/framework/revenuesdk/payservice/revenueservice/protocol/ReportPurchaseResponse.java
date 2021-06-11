package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ReportPurchaseResponse implements IBaseJsonResponse {
    public int cmd = RevenueServerConst.ReportPurchaseResponse;
    public String message;
    public String orderId;
    public String purchaseData;
    public String purchaseSign;
    public int result;
    public String seq;
    public long uid;

    public ReportPurchaseResponse(String str) {
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
                    this.purchaseData = jSONObject.optString("purchaseData");
                    this.purchaseSign = jSONObject.optString("purchaseSign");
                    this.orderId = jSONObject.optString("orderId");
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e2) {
                RLog.error("ReportPurchaseResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                RLog.error("ReportPurchaseResponse", "parserResponse error.", e3);
                return;
            }
        }
        RLog.error("ReportPurchaseResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
