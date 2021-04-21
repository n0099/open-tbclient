package com.win.opensdk;
/* loaded from: classes7.dex */
public class z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f40501a;

    public z0(C0 c0) {
        this.f40501a = c0;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0 c0 = this.f40501a;
        if (c0.f40031e) {
            return;
        }
        c0.a();
        C0 c02 = this.f40501a;
        c02.f40032f.postDelayed(this, c02.f40033g);
    }
}
