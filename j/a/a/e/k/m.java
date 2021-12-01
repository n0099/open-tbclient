package j.a.a.e.k;

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
import tv.athena.revenue.payui.view.YYPayAmountTopView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayConfirmView;
import tv.athena.revenue.payui.view.YYPayGiftView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes3.dex */
public class m implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64141b;

    /* renamed from: c  reason: collision with root package name */
    public j.a.a.e.l.b f64142c;

    /* renamed from: d  reason: collision with root package name */
    public i f64143d;

    /* renamed from: e  reason: collision with root package name */
    public PayUIKitConfig f64144e;

    public m(int i2, int i3, j.a.a.e.l.b bVar, i iVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bVar, iVar, payUIKitConfig};
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
        this.f64141b = i3;
        this.f64142c = bVar;
        this.f64143d = iVar;
        this.f64144e = payUIKitConfig;
    }

    @Override // j.a.a.e.k.f
    public j.a.a.e.o.b a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) ? new YYPayAmountTopView(activity, this.a, this.f64141b, this.f64144e) : (j.a.a.e.o.b) invokeL.objValue;
    }

    @Override // j.a.a.e.k.f
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar)) == null) ? new YYPayWayView(activity, this.a, this.f64141b, bVar, this.f64142c, this.f64144e, this.f64143d) : (IYYPayWayView) invokeLL.objValue;
    }

    @Override // j.a.a.e.k.f
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar)) == null) ? new YYPayResultView(activity, this.f64144e, this.f64142c, this.a, this.f64141b, cVar, this.f64143d) : (IYYPayResultView) invokeLL.objValue;
    }

    @Override // j.a.a.e.k.f
    public j.a.a.e.o.c d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.f64141b, this.f64144e) : (j.a.a.e.o.c) invokeL.objValue;
    }

    @Override // j.a.a.e.k.f
    public j.a.a.e.o.d e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.f64141b, this.f64144e) : (j.a.a.e.o.d) invokeL.objValue;
    }

    @Override // j.a.a.e.k.f
    public IYYPayAmountView f(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, viewParams)) == null) ? new YYPayAmountView(activity, this.a, this.f64141b, this.f64144e, viewParams, this.f64142c, this.f64143d) : (IYYPayAmountView) invokeLL.objValue;
    }
}
