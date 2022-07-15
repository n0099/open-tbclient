package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class ny9 implements IYYPayWayView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IYYPayWayView c;
    public IYYPayWayView.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public qx9 f;

    public ny9(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, qx9 qx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, iYYPayWayView, bVar, iPayCallback, qx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayViewCallback", "create PayWayViewCallback");
        this.a = activity;
        this.b = dialog;
        this.c = iYYPayWayView;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = qx9Var;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void a(ty9 ty9Var, qy9 qy9Var, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ty9Var, qy9Var, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay");
            this.f.d(this.a, ty9Var, qy9Var, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail");
            gz9.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }
}
