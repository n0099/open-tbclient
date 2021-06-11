package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U0 f40631a;

    public T0(U0 u0) {
        this.f40631a = u0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40631a.f40641a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f40631a.f40642b.f40660a).a(new y0(this.f40631a.f40642b.f40662c), this.f40631a.f40641a.getWidth(), this.f40631a.f40641a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
