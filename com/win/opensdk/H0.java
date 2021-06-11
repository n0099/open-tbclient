package com.win.opensdk;
/* loaded from: classes7.dex */
public class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f40508a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f40509b;

    public H0(K0 k0, PBError pBError) {
        this.f40509b = k0;
        this.f40508a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f40509b.f40539g;
        if (l0 != null) {
            l0.onFail(this.f40508a);
        }
    }
}
