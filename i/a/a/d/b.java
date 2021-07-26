package i.a.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
/* loaded from: classes9.dex */
public final class b implements IMiddleRevenue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f73230a;

    /* renamed from: b  reason: collision with root package name */
    public final IRevenue f73231b;

    public b(MiddleRevenueConfig middleRevenueConfig, IRevenue iRevenue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig, iRevenue};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73231b = iRevenue;
        IAppPayService appPayService = this.f73231b.getAppPayService();
        Intrinsics.checkExpressionValueIsNotNull(appPayService, "revenue.appPayService");
        this.f73230a = new a(middleRevenueConfig, appPayService);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73230a : (IAppPayService) invokeV.objValue;
    }

    @Override // tv.athena.revenue.api.IMiddleRevenue
    public IMiddlePayService getMiddlePayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73230a : (IMiddlePayService) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public ISDKReporter getSDKReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ISDKReporter) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, revenueConfig) == null) {
            this.f73231b.updateConfig(revenueConfig);
        }
    }
}
