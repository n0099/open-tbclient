package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetHasChargeInActivityResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int activityId;
    public int chargeCount;
    public int cmd;
    public String endTime;
    public boolean hasCharge;
    public String message;
    public int result;
    public String seq;
    public String startTime;
    public String tip;
    public long uid;

    public GetHasChargeInActivityResponse(String str) {
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
        this.cmd = RevenueServerConst.GetHasChargeInActivityResponse;
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
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString("seq");
                        this.result = jSONObject.optInt("result");
                        this.message = jSONObject.optString("message");
                        this.activityId = jSONObject.optInt("activityId");
                        this.startTime = jSONObject.optString(FetchLog.START_TIME);
                        this.endTime = jSONObject.optString(FetchLog.END_TIME);
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
}
