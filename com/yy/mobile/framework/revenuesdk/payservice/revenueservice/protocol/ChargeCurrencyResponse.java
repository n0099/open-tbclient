package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ChargeCurrencyResponse implements IBaseJsonResponse {
    public int appid;
    public String closeRiskEnhance;
    public int cmd = 2022;
    public String expand;
    public String message;
    public String orderId;
    public String payChannel;
    public String payMethod;
    public String payUrl;
    public PollingModeInfo pollingModeInfo;
    public int result;
    public String seq;
    public String traceId;
    public long uid;
    public int usedChannel;

    public ChargeCurrencyResponse(String str) {
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.cmd == optInt) {
                    this.appid = jSONObject.optInt("appid");
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString("seq");
                    this.usedChannel = jSONObject.optInt("usedChannel");
                    this.result = jSONObject.optInt("result");
                    this.message = jSONObject.optString("message");
                    this.orderId = jSONObject.optString("orderId");
                    this.payUrl = jSONObject.optString("payUrl");
                    this.traceId = jSONObject.optString("traceId");
                    this.expand = jSONObject.optString("expand");
                    this.payChannel = jSONObject.optString("payChannel");
                    this.payMethod = jSONObject.optString("payMethod");
                    this.closeRiskEnhance = jSONObject.optString("closeRiskEnhance");
                    String optString = jSONObject.optString("pollingMode");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        PollingModeInfo pollingModeInfo = new PollingModeInfo();
                        this.pollingModeInfo = pollingModeInfo;
                        pollingModeInfo.totalPollTimes = jSONObject2.optInt("times");
                        this.pollingModeInfo.pollInterval = jSONObject2.optInt("interval");
                    }
                    RLog.debug("ChargeCurrencyResponse", "jsonObject", jSONObject);
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e) {
                RLog.error("ChargeCurrencyResponse", "parserResponse error.", e);
                return;
            } catch (Exception e2) {
                RLog.error("ChargeCurrencyResponse", "parserResponse error.", e2);
                return;
            }
        }
        RLog.error("ChargeCurrencyResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
