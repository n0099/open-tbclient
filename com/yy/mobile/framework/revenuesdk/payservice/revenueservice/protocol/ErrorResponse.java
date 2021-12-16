package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ErrorResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appid;
    public int cmd;
    public int result;
    public String seq;
    public long uid;

    public ErrorResponse(String str) {
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
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.cmd = jSONObject.optInt("cmd");
                    this.appid = jSONObject.optInt("appid");
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString("seq");
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
}
