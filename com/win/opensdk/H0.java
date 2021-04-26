package com.win.opensdk;
/* loaded from: classes6.dex */
public class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f37655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f37656b;

    public H0(K0 k0, PBError pBError) {
        this.f37656b = k0;
        this.f37655a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f37656b.f37686g;
        if (l0 != null) {
            l0.onFail(this.f37655a);
        }
    }
}
