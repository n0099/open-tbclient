package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ReportPurchaseResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int cmd;
    public String message;
    public String orderId;
    public String purchaseData;
    public String purchaseSign;
    public int result;
    public String seq;
    public long uid;

    public ReportPurchaseResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = RevenueServerConst.ReportPurchaseResponse;
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
}
