package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class j1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public long f39958a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f39959b;

    public j1(n1 n1Var) {
        this.f39959b = n1Var;
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        Z0 a2 = a1.a(this.f39959b.f39984a);
        b1 b1Var = new b1(null);
        b1Var.f39887a = this.f39959b.f39985b;
        a2.a(b1Var, System.currentTimeMillis() - this.f39958a, i, 0).a();
        this.f39959b.j.removeMessages(100101);
        this.f39959b.f39987d = false;
        this.f39959b.a(this.f39959b.a(i));
    }

    @Override // com.win.opensdk.S0
    public void a() {
        this.f39958a = System.currentTimeMillis();
        n1 n1Var = this.f39959b;
        n1Var.j.sendEmptyMessageDelayed(100101, n1Var.f39989f * 1000);
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        D d2 = (D) obj;
        this.f39959b.j.removeMessages(100101);
        this.f39959b.f39987d = false;
        int size = d2.f39653a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f39958a;
        Info info = size > 0 ? (Info) d2.f39653a.get(0) : null;
        Z0 a2 = a1.a(this.f39959b.f39984a);
        b1 b1Var = new b1(info);
        b1Var.f39887a = this.f39959b.f39985b;
        a2.a(b1Var, currentTimeMillis, 200, size).a();
        this.f39959b.a(d2);
        h1 h1Var = this.f39959b.f39986c;
        if (h1Var != null && !h1Var.c()) {
            n1 n1Var = this.f39959b;
            if (n1Var.f39991h) {
                return;
            }
            Info b2 = n1Var.f39986c.b();
            if (b2 != null) {
                this.f39959b.a(b2);
                return;
            }
        }
        this.f39959b.a(PBError.NO_FILL);
    }
}
