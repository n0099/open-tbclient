package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetChargeOrderStatusResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long amount;
    public int appId;
    public int cmd;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public int hasGotSalePromotion;
    public String message;
    public int result;
    public String seq;
    public int status;
    public long uid;
    public int usedChannel;

    public GetChargeOrderStatusResponse(String str) {
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
        this.cmd = RevenueServerConst.GetChargeOrderStatusResponse;
        parserResponse(str);
    }

    public GetChargeOrderStatusResult getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new GetChargeOrderStatusResult(this.expand, this.status, this.hasGotSalePromotion, this.currencyType, this.amount, this.currencyAmount, this.finish) : (GetChargeOrderStatusResult) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                        this.result = jSONObject.optInt("result");
                        this.message = jSONObject.optString("message");
                        this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                        this.usedChannel = jSONObject.optInt("usedChannel");
                        this.expand = jSONObject.optString("expand");
                        this.status = jSONObject.optInt("status");
                        this.hasGotSalePromotion = jSONObject.optInt("hasGotSalePromotion");
                        this.currencyAmount = jSONObject.optLong("currencyAmount");
                        this.currencyType = jSONObject.optInt("currencyType");
                        this.amount = jSONObject.optLong(PayUiEventContent.AMOUNT);
                        this.finish = jSONObject.optBoolean(ConstantHelper.LOG_FINISH, false);
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (JSONException e2) {
                    RLog.error("GetChargeOrderStatusResponse", "parserResponse error.", e2);
                    return;
                } catch (Exception e3) {
                    RLog.error("GetChargeOrderStatusResponse", "parserResponse error.", e3);
                    return;
                }
            }
            RLog.error("GetChargeOrderStatusResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
