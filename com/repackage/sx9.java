package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes7.dex */
public interface sx9 {
    void f(Activity activity, ty9 ty9Var, Dialog dialog, IYYPayWayView iYYPayWayView);

    void l(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus);

    void o(int i, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar);
}
