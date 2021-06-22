package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0 f40807a;

    public d0(e0 e0Var) {
        this.f40807a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40807a.f40816a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f40807a.f40817b.f40836a).a(new y0(this.f40807a.f40817b.f40838c), this.f40807a.f40816a.getWidth(), this.f40807a.f40816a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
