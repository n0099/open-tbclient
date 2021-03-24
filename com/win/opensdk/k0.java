package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f39961a;

    public k0(l0 l0Var) {
        this.f39961a = l0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f39961a.f39966a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            a1.a(this.f39961a.f39967b.f40004a).a(new b1(this.f39961a.f39967b.f40006c), this.f39961a.f39966a.getWidth(), this.f39961a.f39966a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
