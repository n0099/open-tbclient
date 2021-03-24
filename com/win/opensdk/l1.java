package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39968a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f39969b;

    public l1(n1 n1Var, Info info) {
        this.f39969b = n1Var;
        this.f39968a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        o1 o1Var = this.f39969b.f39989g;
        if (o1Var != null) {
            o1Var.a(this.f39968a);
        }
    }
}
