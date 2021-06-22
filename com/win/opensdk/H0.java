package com.win.opensdk;
/* loaded from: classes7.dex */
public class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f40611a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f40612b;

    public H0(K0 k0, PBError pBError) {
        this.f40612b = k0;
        this.f40611a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f40612b.f40642g;
        if (l0 != null) {
            l0.onFail(this.f40611a);
        }
    }
}
