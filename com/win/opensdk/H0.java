package com.win.opensdk;
/* loaded from: classes7.dex */
public class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f36829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f36830b;

    public H0(K0 k0, PBError pBError) {
        this.f36830b = k0;
        this.f36829a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f36830b.f36860g;
        if (l0 != null) {
            l0.onFail(this.f36829a);
        }
    }
}
