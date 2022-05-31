package com.repackage;

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
public class w0a implements p0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public l1a c;
    public PayUIKitConfig d;

    public w0a(int i, int i2, l1a l1aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), l1aVar, payUIKitConfig};
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
        this.b = i2;
        this.c = l1aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.repackage.p0a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, k0a k0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, k0aVar)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, k0aVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.repackage.p0a
    public o2a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (o2a) invokeL.objValue;
    }

    @Override // com.repackage.p0a
    public n2a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayAmountCampaignView(activity, this.a, this.b, this.d) : (n2a) invokeL.objValue;
    }

    @Override // com.repackage.p0a
    public p2a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (p2a) invokeL.objValue;
    }

    @Override // com.repackage.p0a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, k0a k0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, k0aVar)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, k0aVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.repackage.p0a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, k0a k0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, k0aVar)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, k0aVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
