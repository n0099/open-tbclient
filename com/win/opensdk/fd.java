package com.win.opensdk;
/* loaded from: classes14.dex */
public class fd implements Runnable {
    public final /* synthetic */ C0 qkf;

    public fd(C0 c0) {
        this.qkf = c0;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0 c0 = this.qkf;
        if (!c0.e) {
            c0.a();
            C0 c02 = this.qkf;
            c02.f.postDelayed(this, c02.g);
        }
    }
}
