package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0 f40704a;

    public d0(e0 e0Var) {
        this.f40704a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40704a.f40713a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f40704a.f40714b.f40733a).a(new y0(this.f40704a.f40714b.f40735c), this.f40704a.f40713a.getWidth(), this.f40704a.f40713a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
