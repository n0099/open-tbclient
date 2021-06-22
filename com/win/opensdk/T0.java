package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U0 f40734a;

    public T0(U0 u0) {
        this.f40734a = u0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40734a.f40744a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f40734a.f40745b.f40763a).a(new y0(this.f40734a.f40745b.f40765c), this.f40734a.f40744a.getWidth(), this.f40734a.f40744a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
