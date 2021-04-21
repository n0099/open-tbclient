package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x1 f40472a;

    public w1(x1 x1Var) {
        this.f40472a = x1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.f40472a.f40485a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            a1.a(this.f40472a.f40486b.f40009a).a(new b1(this.f40472a.f40486b.f40011c), this.f40472a.f40485a.getWidth(), this.f40472a.f40485a.getHeight()).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
