package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class j1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public long f40247a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f40248b;

    public j1(n1 n1Var) {
        this.f40248b = n1Var;
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        Z0 a2 = a1.a(this.f40248b.f40273a);
        b1 b1Var = new b1(null);
        b1Var.f40176a = this.f40248b.f40274b;
        a2.a(b1Var, System.currentTimeMillis() - this.f40247a, i, 0).a();
        this.f40248b.j.removeMessages(100101);
        this.f40248b.f40276d = false;
        this.f40248b.a(this.f40248b.a(i));
    }

    @Override // com.win.opensdk.S0
    public void a() {
        this.f40247a = System.currentTimeMillis();
        n1 n1Var = this.f40248b;
        n1Var.j.sendEmptyMessageDelayed(100101, n1Var.f40278f * 1000);
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        D d2 = (D) obj;
        this.f40248b.j.removeMessages(100101);
        this.f40248b.f40276d = false;
        int size = d2.f39942a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f40247a;
        Info info = size > 0 ? (Info) d2.f39942a.get(0) : null;
        Z0 a2 = a1.a(this.f40248b.f40273a);
        b1 b1Var = new b1(info);
        b1Var.f40176a = this.f40248b.f40274b;
        a2.a(b1Var, currentTimeMillis, 200, size).a();
        this.f40248b.a(d2);
        h1 h1Var = this.f40248b.f40275c;
        if (h1Var != null && !h1Var.c()) {
            n1 n1Var = this.f40248b;
            if (n1Var.f40280h) {
                return;
            }
            Info b2 = n1Var.f40275c.b();
            if (b2 != null) {
                this.f40248b.a(b2);
                return;
            }
        }
        this.f40248b.a(PBError.NO_FILL);
    }
}
