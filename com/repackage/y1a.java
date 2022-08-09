package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes7.dex */
public class y1a implements t1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MiddleRevenueConfig a;

    public y1a(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = middleRevenueConfig;
    }

    @Override // com.repackage.t1a
    public GetBannerConfigReqParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
            getBannerConfigReqParams.setAppId(this.a.getAppId());
            getBannerConfigReqParams.setUsedChannel(this.a.getUseChannel());
            getBannerConfigReqParams.setUid(this.a.getUid());
            getBannerConfigReqParams.setToken(this.a.getToken());
            getBannerConfigReqParams.setTokenCallback(this.a.getTokenCallback());
            return getBannerConfigReqParams;
        }
        return (GetBannerConfigReqParams) invokeV.objValue;
    }

    @Override // com.repackage.t1a
    public oz9 b(PayFlowType payFlowType, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType, map)) == null) {
            oz9 oz9Var = new oz9();
            oz9Var.B(this.a.getUid());
            oz9Var.y(this.a.getToken());
            oz9Var.C(this.a.getUseChannel());
            oz9Var.s(this.a.getCurrencyType());
            oz9Var.z(this.a.getTokenCallback());
            String deviceId = this.a.getDeviceId();
            RLog.info("QueryParamsProvider", "getMiddlePayWithProductInfoParams deviceId:" + deviceId);
            HashMap hashMap = new HashMap();
            if (deviceId != null) {
                hashMap.put("deviceId", deviceId);
            } else {
                RLog.error("QueryParamsProvider", "getMiddlePayWithProductInfoParams deviceId null", new Object[0]);
            }
            hashMap.put("chargeScene", payFlowType == PayFlowType.WALLET_PAY_FLOW ? "1" : "0");
            JSONObject e = e(map);
            if (e != null) {
                hashMap.put("clientInfo", e);
            }
            oz9Var.t(hashMap);
            return oz9Var;
        }
        return (oz9) invokeLL.objValue;
    }

    @Override // com.repackage.t1a
    public QueryCurrencyReqParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.a.getUseChannel());
            queryCurrencyReqParams.setUid(this.a.getUid());
            queryCurrencyReqParams.setToken(this.a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.a.getTokenCallback());
            queryCurrencyReqParams.setReturnYb(true);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // com.repackage.t1a
    public QueryCurrencyReqParams d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.a.getUseChannel());
            queryCurrencyReqParams.setUid(this.a.getUid());
            queryCurrencyReqParams.setToken(this.a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.a.getTokenCallback());
            HashMap hashMap = new HashMap();
            JSONObject e = e(map);
            if (e != null) {
                hashMap.put("clientInfo", e);
            }
            queryCurrencyReqParams.setExpandMap(hashMap);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeL.objValue;
    }

    public final JSONObject e(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, map)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        if (map == null) {
            return null;
        }
        try {
            if (map.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return jSONObject2;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject2;
                    RLog.error("QueryParamsProvider", "getClientInfoJsonObject JSONException" + e.getLocalizedMessage(), new Object[0]);
                    return jSONObject;
                }
            }
            return null;
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
