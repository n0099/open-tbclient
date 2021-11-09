package i.a.a.e.k;

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

    /* renamed from: a  reason: collision with root package name */
    public int f72283a;

    /* renamed from: b  reason: collision with root package name */
    public int f72284b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.l.b f72285c;

    /* renamed from: d  reason: collision with root package name */
    public i f72286d;

    /* renamed from: e  reason: collision with root package name */
    public PayUIKitConfig f72287e;

    public m(int i2, int i3, i.a.a.e.l.b bVar, i iVar, PayUIKitConfig payUIKitConfig) {
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
        this.f72283a = i2;
        this.f72284b = i3;
        this.f72285c = bVar;
        this.f72286d = iVar;
        this.f72287e = payUIKitConfig;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.b a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) ? new YYPayAmountTopView(activity, this.f72283a, this.f72284b, this.f72287e) : (i.a.a.e.o.b) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar)) == null) ? new YYPayWayView(activity, this.f72283a, this.f72284b, bVar, this.f72285c, this.f72287e, this.f72286d) : (IYYPayWayView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar)) == null) ? new YYPayResultView(activity, this.f72287e, this.f72285c, this.f72283a, this.f72284b, cVar, this.f72286d) : (IYYPayResultView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.c d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayConfirmView(activity, this.f72283a, this.f72284b, this.f72287e) : (i.a.a.e.o.c) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.d e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) ? new YYPayGiftView(activity, this.f72283a, this.f72284b, this.f72287e) : (i.a.a.e.o.d) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayAmountView f(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, viewParams)) == null) ? new YYPayAmountView(activity, this.f72283a, this.f72284b, this.f72287e, viewParams, this.f72285c, this.f72286d) : (IYYPayAmountView) invokeLL.objValue;
    }
}
