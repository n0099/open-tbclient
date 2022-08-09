package com.repackage;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes7.dex */
public interface q0a extends i0a {
    boolean b(PayFlowType payFlowType);

    void c(Activity activity);

    void d(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(PayFlowType payFlowType);

    void f(String str, PayFlowType payFlowType);

    boolean g();

    void h(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    void j(String str, PayFlowType payFlowType);

    void refreshWindow(WindowParams windowParams);

    void release();
}
