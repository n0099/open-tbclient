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
/* loaded from: classes2.dex */
public class m implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f73202a;

    /* renamed from: b  reason: collision with root package name */
    public int f73203b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.l.b f73204c;

    /* renamed from: d  reason: collision with root package name */
    public i f73205d;

    /* renamed from: e  reason: collision with root package name */
    public PayUIKitConfig f73206e;

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
        this.f73202a = i2;
        this.f73203b = i3;
        this.f73204c = bVar;
        this.f73205d = iVar;
        this.f73206e = payUIKitConfig;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.b a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) ? new YYPayAmountTopView(activity, this.f73202a, this.f73203b, this.f73206e) : (i.a.a.e.o.b) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar)) == null) ? new YYPayWayView(activity, this.f73202a, this.f73203b, bVar, this.f73204c, this.f73206e, this.f73205d) : (IYYPayWayView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar)) == null) ? new YYPayResultView(activity, this.f73206e, this.f73204c, this.f73202a, this.f73203b, cVar, this.f73205d) : (IYYPayResultView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.c d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayConfirmView(activity, this.f73202a, this.f73203b, this.f73206e) : (i.a.a.e.o.c) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public i.a.a.e.o.d e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) ? new YYPayGiftView(activity, this.f73202a, this.f73203b, this.f73206e) : (i.a.a.e.o.d) invokeL.objValue;
    }

    @Override // i.a.a.e.k.f
    public IYYPayAmountView f(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, viewParams)) == null) ? new YYPayAmountView(activity, this.f73202a, this.f73203b, this.f73206e, viewParams, this.f73204c, this.f73205d) : (IYYPayAmountView) invokeLL.objValue;
    }
}
