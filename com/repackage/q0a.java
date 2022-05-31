package com.repackage;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface q0a extends j0a {
    void b(Activity activity);

    void c(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void d(PayFlowType payFlowType);

    boolean e();

    void f(String str, PayFlowType payFlowType);

    boolean g(PayFlowType payFlowType);

    void h(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    void j(String str, PayFlowType payFlowType);

    void release();
}
