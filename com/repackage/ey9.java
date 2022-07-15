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
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class ey9 implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Dialog c;
    public IYYPayAmountView.ViewParams d;
    public Activity e;
    public IPayCallback<CurrencyChargeMessage> f;
    public qx9 g;

    public ey9(int i, int i2, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, qx9 qx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), dialog, viewParams, activity, iPayCallback, qx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayAmountViewCallback", "create PayAmountViewCallback appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = dialog;
        this.d = viewParams;
        this.e = activity;
        this.f = iPayCallback;
        this.g = qx9Var;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i + " failReason:" + str, new Object[0]);
            gz9.b(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog");
            gz9.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.j(activity, list, this.d, this.f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(qy9 qy9Var, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, qy9Var, list) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog");
            gz9.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.g(this.e, qy9Var, list, this.d, this.f);
            yy9.b(this.a, this.b, UiEventType.purchasegotopay);
        }
    }
}
