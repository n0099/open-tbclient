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
public class c4a implements v3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public r4a c;
    public PayUIKitConfig d;

    public c4a(int i, int i2, r4a r4aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), r4aVar, payUIKitConfig};
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
        this.c = r4aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.repackage.v3a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, q3a q3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, q3aVar)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, q3aVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.repackage.v3a
    public u5a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (u5a) invokeL.objValue;
    }

    @Override // com.repackage.v3a
    public t5a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayAmountCampaignView(activity, this.a, this.b, this.d) : (t5a) invokeL.objValue;
    }

    @Override // com.repackage.v3a
    public v5a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (v5a) invokeL.objValue;
    }

    @Override // com.repackage.v3a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, q3a q3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, q3aVar)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, q3aVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.repackage.v3a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, q3a q3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, q3aVar)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, q3aVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
