package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/ExchangeCurrencyRequest;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;", "", "getProtocol", "()Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ExchangeCurrencyReqParams;", "reqParam", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ExchangeCurrencyReqParams;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/ExchangeCurrencyReqParams;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ExchangeCurrencyRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExchangeCurrencyReqParams reqParam;

    public ExchangeCurrencyRequest(ExchangeCurrencyReqParams exchangeCurrencyReqParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {exchangeCurrencyReqParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reqParam = exchangeCurrencyReqParams;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", 1025);
            jSONObject.put("uid", this.reqParam.getUid());
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.reqParam.getAppId());
            jSONObject.put("usedChannel", this.reqParam.getUsedChannel());
            jSONObject.put("seq", this.reqParam.getSeq());
            jSONObject.put("srcCurrencyType", this.reqParam.getSrcCurrencyType());
            jSONObject.put("destCurrencyType", this.reqParam.getDestCurrencyType());
            jSONObject.put(PayUiEventContent.AMOUNT, this.reqParam.getAmount());
            jSONObject.put("configId", this.reqParam.getConfigId());
            jSONObject.put("expand", this.reqParam.getExpand());
            jSONObject.put("ip", this.reqParam.getIpAddress());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }
}
