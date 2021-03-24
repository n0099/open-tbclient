package com.win.opensdk;
/* loaded from: classes7.dex */
public class m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n1 f39973a;

    public m1(n1 n1Var) {
        this.f39973a = n1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        o1 o1Var = this.f39973a.f39989g;
        if (o1Var != null) {
            o1Var.a();
        }
    }
}
