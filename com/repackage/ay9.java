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
/* loaded from: classes5.dex */
public class ay9 implements tx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public py9 c;
    public PayUIKitConfig d;

    public ay9(int i, int i2, py9 py9Var, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), py9Var, payUIKitConfig};
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
        this.c = py9Var;
        this.d = payUIKitConfig;
    }

    @Override // com.repackage.tx9
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, ox9 ox9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, ox9Var)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, ox9Var) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.repackage.tx9
    public sz9 b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (sz9) invokeL.objValue;
    }

    @Override // com.repackage.tx9
    public rz9 c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayAmountCampaignView(activity, this.a, this.b, this.d) : (rz9) invokeL.objValue;
    }

    @Override // com.repackage.tx9
    public tz9 d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (tz9) invokeL.objValue;
    }

    @Override // com.repackage.tx9
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, ox9 ox9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, ox9Var)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, ox9Var) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.repackage.tx9
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, ox9 ox9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, ox9Var)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, ox9Var) : (IYYPayResultView) invokeLLL.objValue;
    }
}
