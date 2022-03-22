package h.a.a.e.e;

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
/* loaded from: classes7.dex */
public class p implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45154b;

    /* renamed from: c  reason: collision with root package name */
    public h.a.a.e.f.b f45155c;

    /* renamed from: d  reason: collision with root package name */
    public PayUIKitConfig f45156d;

    public p(int i, int i2, h.a.a.e.f.b bVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), bVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayViewImpl", "create PayViewImpl mAppId:" + i + " mUserChannel:" + i2);
        this.a = i;
        this.f45154b = i2;
        this.f45155c = bVar;
        this.f45156d = payUIKitConfig;
    }

    @Override // h.a.a.e.e.i
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, dVar)) == null) ? new YYPayAmountView(activity, this.a, this.f45154b, this.f45156d, viewParams, this.f45155c, dVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // h.a.a.e.e.i
    public h.a.a.e.i.c b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.f45154b, this.f45156d) : (h.a.a.e.i.c) invokeL.objValue;
    }

    @Override // h.a.a.e.e.i
    public h.a.a.e.i.b c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayAmountCampaignView(activity, this.a, this.f45154b, this.f45156d) : (h.a.a.e.i.b) invokeL.objValue;
    }

    @Override // h.a.a.e.e.i
    public h.a.a.e.i.d d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.f45154b, this.f45156d) : (h.a.a.e.i.d) invokeL.objValue;
    }

    @Override // h.a.a.e.e.i
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, dVar)) == null) ? new YYPayWayView(activity, this.a, this.f45154b, bVar, this.f45155c, this.f45156d, dVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // h.a.a.e.e.i
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, dVar)) == null) ? new YYPayResultView(activity, this.f45156d, this.f45155c, this.a, this.f45154b, cVar, dVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
