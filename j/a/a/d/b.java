package j.a.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IEventReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
/* loaded from: classes5.dex */
public final class b implements IMiddleRevenue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* renamed from: b  reason: collision with root package name */
    public final IRevenue f62421b;

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
        this.f62421b = iRevenue;
        IAppPayService appPayService = this.f62421b.getAppPayService();
        Intrinsics.checkExpressionValueIsNotNull(appPayService, "revenue.appPayService");
        this.a = new a(middleRevenueConfig, appPayService);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (IAppPayService) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IEventReporter getEventReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (IEventReporter) invokeV.objValue;
    }

    @Override // tv.athena.revenue.api.IMiddleRevenue
    public IMiddlePayService getMiddlePayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (IMiddlePayService) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IPayReporter getPayReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (IPayReporter) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, revenueConfig) == null) {
            this.f62421b.updateConfig(revenueConfig);
        }
    }
}
