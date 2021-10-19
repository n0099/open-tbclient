package j.a.a.e.k;

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
/* loaded from: classes2.dex */
public class e implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f79447a;

    public e(MiddleRevenueConfig middleRevenueConfig) {
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
        this.f79447a = middleRevenueConfig;
    }

    @Override // j.a.a.e.k.a
    public GetBannerConfigReqParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
            getBannerConfigReqParams.setAppId(this.f79447a.getAppId());
            getBannerConfigReqParams.setUsedChannel(this.f79447a.getUseChannel());
            getBannerConfigReqParams.setUid(this.f79447a.getUid());
            getBannerConfigReqParams.setToken(this.f79447a.getToken());
            getBannerConfigReqParams.setTokenCallback(this.f79447a.getTokenCallback());
            return getBannerConfigReqParams;
        }
        return (GetBannerConfigReqParams) invokeV.objValue;
    }

    @Override // j.a.a.e.k.a
    public QueryCurrencyReqParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f79447a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f79447a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f79447a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f79447a.getUid());
            queryCurrencyReqParams.setToken(this.f79447a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f79447a.getTokenCallback());
            queryCurrencyReqParams.setReturnYb(true);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // j.a.a.e.k.a
    public QueryCurrencyReqParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f79447a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f79447a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f79447a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f79447a.getUid());
            queryCurrencyReqParams.setToken(this.f79447a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f79447a.getTokenCallback());
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // j.a.a.e.k.a
    public j.a.a.b.b.a.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            j.a.a.b.b.a.a aVar = new j.a.a.b.b.a.a();
            aVar.A(this.f79447a.getUid());
            aVar.x(this.f79447a.getToken());
            aVar.B(this.f79447a.getUseChannel());
            aVar.s(this.f79447a.getCurrencyType());
            aVar.y(this.f79447a.getTokenCallback());
            String deviceId = this.f79447a.getDeviceId();
            MiddleReportConfig reportConfig = this.f79447a.getReportConfig();
            if (TextUtils.isEmpty(deviceId) && reportConfig != null && !TextUtils.isEmpty(reportConfig.getDeviceId())) {
                deviceId = reportConfig.getDeviceId();
            }
            if (deviceId != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceId", deviceId);
                aVar.t(hashMap);
            }
            return aVar;
        }
        return (j.a.a.b.b.a.a) invokeV.objValue;
    }
}
