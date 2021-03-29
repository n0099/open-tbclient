package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f39962a;

    public k0(l0 l0Var) {
        this.f39962a = l0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f39962a.f39967a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            a1.a(this.f39962a.f39968b.f40005a).a(new b1(this.f39962a.f39968b.f40007c), this.f39962a.f39967a.getWidth(), this.f39962a.f39967a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
