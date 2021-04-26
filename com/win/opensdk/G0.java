package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class G0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public long f37650a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f37651b;

    public G0(K0 k0) {
        this.f37651b = k0;
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        w0 a2 = x0.a(this.f37651b.f37680a);
        y0 y0Var = new y0(null);
        y0Var.f38009a = this.f37651b.f37681b;
        a2.a(y0Var, System.currentTimeMillis() - this.f37650a, i2, 0).a();
        this.f37651b.j.removeMessages(100101);
        this.f37651b.f37683d = false;
        this.f37651b.a(this.f37651b.a(i2));
    }

    @Override // com.win.opensdk.r0
    public void a() {
        this.f37650a = System.currentTimeMillis();
        K0 k0 = this.f37651b;
        k0.j.sendEmptyMessageDelayed(100101, k0.f37685f * 1000);
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        w wVar = (w) obj;
        this.f37651b.j.removeMessages(100101);
        this.f37651b.f37683d = false;
        int size = wVar.f37980a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f37650a;
        Info info = size > 0 ? (Info) wVar.f37980a.get(0) : null;
        w0 a2 = x0.a(this.f37651b.f37680a);
        y0 y0Var = new y0(info);
        y0Var.f38009a = this.f37651b.f37681b;
        a2.a(y0Var, currentTimeMillis, 200, size).a();
        this.f37651b.a(wVar);
        E0 e0 = this.f37651b.f37682c;
        if (e0 != null && !e0.c()) {
            K0 k0 = this.f37651b;
            if (k0.f37687h) {
                return;
            }
            Info b2 = k0.f37682c.b();
            if (b2 != null) {
                this.f37651b.a(b2);
                return;
            }
        }
        this.f37651b.a(PBError.NO_FILL);
    }
}
