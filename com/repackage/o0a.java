package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface o0a {
    void f(Activity activity, p1a p1aVar, Dialog dialog, IYYPayWayView iYYPayWayView);

    void l(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus);

    void o(int i, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar);
}
