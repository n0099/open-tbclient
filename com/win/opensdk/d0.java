package com.win.opensdk;

import android.view.View;
/* loaded from: classes6.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0 f37851a;

    public d0(e0 e0Var) {
        this.f37851a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f37851a.f37860a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f37851a.f37861b.f37880a).a(new y0(this.f37851a.f37861b.f37882c), this.f37851a.f37860a.getWidth(), this.f37851a.f37860a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
