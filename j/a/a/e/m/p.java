package j.a.a.e.m;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayAmountCampaignView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayConfirmView;
import tv.athena.revenue.payui.view.YYPayGiftView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes4.dex */
public class p implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64717b;

    /* renamed from: c  reason: collision with root package name */
    public j.a.a.e.n.b f64718c;

    /* renamed from: d  reason: collision with root package name */
    public PayUIKitConfig f64719d;

    public p(int i2, int i3, j.a.a.e.n.b bVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayViewImpl", "create PayViewImpl mAppId:" + i2 + " mUserChannel:" + i3);
        this.a = i2;
        this.f64717b = i3;
        this.f64718c = bVar;
        this.f64719d = payUIKitConfig;
    }

    @Override // j.a.a.e.m.i
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, dVar)) == null) ? new YYPayAmountView(activity, this.a, this.f64717b, this.f64719d, viewParams, this.f64718c, dVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // j.a.a.e.m.i
    public j.a.a.e.q.c b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.f64717b, this.f64719d) : (j.a.a.e.q.c) invokeL.objValue;
    }

    @Override // j.a.a.e.m.i
    public j.a.a.e.q.b c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayAmountCampaignView(activity, this.a, this.f64717b, this.f64719d) : (j.a.a.e.q.b) invokeL.objValue;
    }

    @Override // j.a.a.e.m.i
    public j.a.a.e.q.d d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.f64717b, this.f64719d) : (j.a.a.e.q.d) invokeL.objValue;
    }

    @Override // j.a.a.e.m.i
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, dVar)) == null) ? new YYPayWayView(activity, this.a, this.f64717b, bVar, this.f64718c, this.f64719d, dVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // j.a.a.e.m.i
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, dVar)) == null) ? new YYPayResultView(activity, this.f64719d, this.f64718c, this.a, this.f64717b, cVar, dVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
