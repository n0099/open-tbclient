package i.a.a.e.k;

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
/* loaded from: classes8.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f72816a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
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
        this.f72816a = middleRevenueConfig;
    }

    @Override // i.a.a.e.k.a
    public GetBannerConfigReqParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
            getBannerConfigReqParams.setAppId(this.f72816a.getAppId());
            getBannerConfigReqParams.setUsedChannel(this.f72816a.getUseChannel());
            getBannerConfigReqParams.setUid(this.f72816a.getUid());
            getBannerConfigReqParams.setToken(this.f72816a.getToken());
            getBannerConfigReqParams.setTokenCallback(this.f72816a.getTokenCallback());
            return getBannerConfigReqParams;
        }
        return (GetBannerConfigReqParams) invokeV.objValue;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f72816a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f72816a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f72816a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f72816a.getUid());
            queryCurrencyReqParams.setToken(this.f72816a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f72816a.getTokenCallback());
            queryCurrencyReqParams.setReturnYb(true);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.f72816a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.f72816a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.f72816a.getUseChannel());
            queryCurrencyReqParams.setUid(this.f72816a.getUid());
            queryCurrencyReqParams.setToken(this.f72816a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.f72816a.getTokenCallback());
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // i.a.a.e.k.a
    public i.a.a.b.b.a.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
            aVar.A(this.f72816a.getUid());
            aVar.x(this.f72816a.getToken());
            aVar.B(this.f72816a.getUseChannel());
            aVar.s(this.f72816a.getCurrencyType());
            aVar.y(this.f72816a.getTokenCallback());
            String deviceId = this.f72816a.getDeviceId();
            MiddleReportConfig reportConfig = this.f72816a.getReportConfig();
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
        return (i.a.a.b.b.a.a) invokeV.objValue;
    }
}
