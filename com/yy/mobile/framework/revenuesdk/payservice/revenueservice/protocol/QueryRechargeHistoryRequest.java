package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/QueryRechargeHistoryRequest;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;", "", "getProtocol", "()Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryRechargeHistoryReqParams;", "reqParam", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryRechargeHistoryReqParams;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryRechargeHistoryReqParams;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class QueryRechargeHistoryRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QueryRechargeHistoryReqParams reqParam;

    public QueryRechargeHistoryRequest(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {queryRechargeHistoryReqParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reqParam = queryRechargeHistoryReqParams;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", RevenueServerConst.ChargeCurrencyHistoryRequest);
            jSONObject.put("uid", this.reqParam.getUid());
            jSONObject.put("usedChannel", this.reqParam.getUsedChannel());
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.reqParam.getAppId());
            jSONObject.put(IAdRequestParam.SEQ, this.reqParam.getSeq());
            jSONObject.put("status", this.reqParam.getStatus());
            jSONObject.put("pagesize", this.reqParam.getPagesize());
            jSONObject.put("page", this.reqParam.getPage());
            jSONObject.put("startTime", this.reqParam.getStartTime());
            jSONObject.put("endTime", this.reqParam.getEndTime());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }
}
