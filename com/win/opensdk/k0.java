package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f40346a;

    public k0(l0 l0Var) {
        this.f40346a = l0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40346a.f40351a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            a1.a(this.f40346a.f40352b.f40389a).a(new b1(this.f40346a.f40352b.f40391c), this.f40346a.f40351a.getWidth(), this.f40346a.f40351a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
