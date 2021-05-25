package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U0 f36952a;

    public T0(U0 u0) {
        this.f36952a = u0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f36952a.f36962a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            x0.a(this.f36952a.f36963b.f36981a).a(new y0(this.f36952a.f36963b.f36983c), this.f36952a.f36962a.getWidth(), this.f36952a.f36962a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
