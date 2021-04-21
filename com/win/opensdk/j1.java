package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class j1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public long f40342a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n1 f40343b;

    public j1(n1 n1Var) {
        this.f40343b = n1Var;
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        Z0 a2 = a1.a(this.f40343b.f40368a);
        b1 b1Var = new b1(null);
        b1Var.f40271a = this.f40343b.f40369b;
        a2.a(b1Var, System.currentTimeMillis() - this.f40342a, i, 0).a();
        this.f40343b.j.removeMessages(100101);
        this.f40343b.f40371d = false;
        this.f40343b.a(this.f40343b.a(i));
    }

    @Override // com.win.opensdk.S0
    public void a() {
        this.f40342a = System.currentTimeMillis();
        n1 n1Var = this.f40343b;
        n1Var.j.sendEmptyMessageDelayed(100101, n1Var.f40373f * 1000);
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        D d2 = (D) obj;
        this.f40343b.j.removeMessages(100101);
        this.f40343b.f40371d = false;
        int size = d2.f40037a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f40342a;
        Info info = size > 0 ? (Info) d2.f40037a.get(0) : null;
        Z0 a2 = a1.a(this.f40343b.f40368a);
        b1 b1Var = new b1(info);
        b1Var.f40271a = this.f40343b.f40369b;
        a2.a(b1Var, currentTimeMillis, 200, size).a();
        this.f40343b.a(d2);
        h1 h1Var = this.f40343b.f40370c;
        if (h1Var != null && !h1Var.c()) {
            n1 n1Var = this.f40343b;
            if (n1Var.f40375h) {
                return;
            }
            Info b2 = n1Var.f40370c.b();
            if (b2 != null) {
                this.f40343b.a(b2);
                return;
            }
        }
        this.f40343b.a(PBError.NO_FILL);
    }
}
