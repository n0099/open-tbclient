package h.a.a.e.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes7.dex */
public class g implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MiddleRevenueConfig a;

    public g(MiddleRevenueConfig middleRevenueConfig) {
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

    @Override // h.a.a.e.f.b
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

    @Override // h.a.a.e.f.b
    public h.a.a.b.b.a.a b(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType)) == null) {
            h.a.a.b.b.a.a aVar = new h.a.a.b.b.a.a();
            aVar.B(this.a.getUid());
            aVar.y(this.a.getToken());
            aVar.C(this.a.getUseChannel());
            aVar.s(this.a.getCurrencyType());
            aVar.z(this.a.getTokenCallback());
            String deviceId = this.a.getDeviceId();
            MiddleReportConfig reportConfig = this.a.getReportConfig();
            if (TextUtils.isEmpty(deviceId) && reportConfig != null && !TextUtils.isEmpty(reportConfig.getDeviceId())) {
                deviceId = reportConfig.getDeviceId();
            }
            HashMap hashMap = new HashMap();
            if (deviceId != null) {
                hashMap.put("deviceId", deviceId);
            }
            hashMap.put("chargeScene", payFlowType == PayFlowType.WALLET_PAY_FLOW ? "1" : "0");
            aVar.t(hashMap);
            return aVar;
        }
        return (h.a.a.b.b.a.a) invokeL.objValue;
    }

    @Override // h.a.a.e.f.b
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

    @Override // h.a.a.e.f.b
    public QueryCurrencyReqParams d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.a.getUseChannel());
            queryCurrencyReqParams.setUid(this.a.getUid());
            queryCurrencyReqParams.setToken(this.a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.a.getTokenCallback());
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }
}
