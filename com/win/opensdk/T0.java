package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U0 f37023a;

    public T0(U0 u0) {
        this.f37023a = u0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f37023a.f37033a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f37023a.f37034b.f37052a).a(new y0(this.f37023a.f37034b.f37054c), this.f37023a.f37033a.getWidth(), this.f37023a.f37033a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
