package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0 f37096a;

    public d0(e0 e0Var) {
        this.f37096a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f37096a.f37105a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f37096a.f37106b.f37125a).a(new y0(this.f37096a.f37106b.f37127c), this.f37096a.f37105a.getWidth(), this.f37096a.f37105a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
