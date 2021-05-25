package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0 f37025a;

    public d0(e0 e0Var) {
        this.f37025a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f37025a.f37034a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f37025a.f37035b.f37054a).a(new y0(this.f37025a.f37035b.f37056c), this.f37025a.f37034a.getWidth(), this.f37025a.f37034a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
