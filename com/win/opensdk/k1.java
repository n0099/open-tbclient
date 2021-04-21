package com.win.opensdk;
/* loaded from: classes7.dex */
public class k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBError f40347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f40348b;

    public k1(n1 n1Var, PBError pBError) {
        this.f40348b = n1Var;
        this.f40347a = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        o1 o1Var = this.f40348b.f40374g;
        if (o1Var != null) {
            o1Var.onFail(this.f40347a);
        }
    }
}
