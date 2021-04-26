package com.win.opensdk;

import android.view.View;
/* loaded from: classes6.dex */
public class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U0 f37778a;

    public T0(U0 u0) {
        this.f37778a = u0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f37778a.f37788a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f37778a.f37789b.f37807a).a(new y0(this.f37778a.f37789b.f37809c), this.f37778a.f37788a.getWidth(), this.f37778a.f37788a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
