package i.a.a.e.l;

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
/* loaded from: classes3.dex */
public class g implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f72360a;

    public g(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72360a = middleRevenueConfig;
    }

    @Override // i.a.a.e.l.b
    public GetBannerConfigReqParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
            getBannerConfigReqParams.setAppId(this.f72360a.getAppId());
            getBannerConfigReqParams.setUsedChannel(this.f72360a.getUseChannel());
            getBannerConfigReqParams.setUid(this.f72360a.getUid());
            getBannerConfigReqParams.setToken(this.f72360a.getToken());
            getBannerConfigReqParams.setTokenCallback(this.f72360a.getTokenCallback());
            return getBannerConfigReqParams;
        }
        return (GetBannerConfigReqParams) invokeV.objValue;
    }

    @Override // i.a.a.e.l.b
    public i.a.a.b.b.a.a b(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType)) == null) {
            i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
            aVar.z(this.f72360a.getUid());
            aVar.w(this.f72360a.getToken());
            aVar.A(this.f72360a.getUseChannel());
            aVar.r(this.f72360a.getCurrencyType());
            aVar.x(this.f72360a.getTokenCallback());
            String deviceId = this.f72360a.getDeviceId();
            MiddleReportConfig reportConfig = this.f72360a.getReportConfig();
            if (TextUtils.isEmpty(deviceId) && reportConfig != null && !TextUtils.isEmpty(reportConfig.getDeviceId())) {
                deviceId = reportConfig.getDeviceId();
            }
            HashMap hashMap = new HashMap();
            if (deviceId != null) {
                hashMap.put("deviceId", deviceId);
            }
            hashMap.put("chargeScene", payFlowType == PayFlowType.ACTIVITY_PAY_FLOW ? "1" : "0");
            aVar.s(hashMap);
            return aVar;
        }
        return (i.a.a.b.b.a.a) invokeL.objValue;
    }

    @Override // i.a.a.e.l.b
    public QueryCurrencyReqParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f72360a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f72360a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f72360a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f72360a.getUid());
            queryCurrencyReqParams.setToken(this.f72360a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f72360a.getTokenCallback());
            queryCurrencyReqParams.setReturnYb(true);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // i.a.a.e.l.b
    public QueryCurrencyReqParams d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f72360a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f72360a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f72360a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f72360a.getUid());
            queryCurrencyReqParams.setToken(this.f72360a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f72360a.getTokenCallback());
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }
}
