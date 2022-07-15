package com.repackage;

import android.app.Activity;
import android.view.ViewGroup;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes6.dex */
public interface ox9 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(CancelType cancelType);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(CancelType cancelType);

        void b();
    }

    GiftBagsInfo a();

    boolean b(Activity activity, b bVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler);

    void c(ViewGroup viewGroup, Activity activity);

    void d(GiftBagsInfo giftBagsInfo);

    boolean e(Activity activity, a aVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler);

    void f(GiftBagsInfo giftBagsInfo);
}
