package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x1 f40088a;

    public w1(x1 x1Var) {
        this.f40088a = x1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40088a.f40101a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            a1.a(this.f40088a.f40102b.f39625a).a(new b1(this.f40088a.f40102b.f39627c), this.f40088a.f40101a.getWidth(), this.f40088a.f40101a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
