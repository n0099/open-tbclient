package com.win.opensdk;
/* loaded from: classes7.dex */
public class k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f39963a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f39964b;

    public k1(n1 n1Var, PBError pBError) {
        this.f39964b = n1Var;
        this.f39963a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        o1 o1Var = this.f39964b.f39990g;
        if (o1Var != null) {
            o1Var.onFail(this.f39963a);
        }
    }
}
