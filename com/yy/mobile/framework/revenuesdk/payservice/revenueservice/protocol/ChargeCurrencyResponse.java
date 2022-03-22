package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ChargeCurrencyResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appid;
    public String closeRiskEnhance;
    public int cmd;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = RevenueServerConst.ChargeCurrencyResponse;
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
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
                } catch (JSONException e2) {
                    RLog.error("ChargeCurrencyResponse", "parserResponse error.", e2);
                    return;
                } catch (Exception e3) {
                    RLog.error("ChargeCurrencyResponse", "parserResponse error.", e3);
                    return;
                }
            }
            RLog.error("ChargeCurrencyResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
