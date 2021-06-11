package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class G0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public long f40503a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f40504b;

    public G0(K0 k0) {
        this.f40504b = k0;
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        w0 a2 = x0.a(this.f40504b.f40533a);
        y0 y0Var = new y0(null);
        y0Var.f40862a = this.f40504b.f40534b;
        a2.a(y0Var, System.currentTimeMillis() - this.f40503a, i2, 0).a();
        this.f40504b.j.removeMessages(100101);
        this.f40504b.f40536d = false;
        this.f40504b.a(this.f40504b.a(i2));
    }

    @Override // com.win.opensdk.r0
    public void a() {
        this.f40503a = System.currentTimeMillis();
        K0 k0 = this.f40504b;
        k0.j.sendEmptyMessageDelayed(100101, k0.f40538f * 1000);
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        w wVar = (w) obj;
        this.f40504b.j.removeMessages(100101);
        this.f40504b.f40536d = false;
        int size = wVar.f40833a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f40503a;
        Info info = size > 0 ? (Info) wVar.f40833a.get(0) : null;
        w0 a2 = x0.a(this.f40504b.f40533a);
        y0 y0Var = new y0(info);
        y0Var.f40862a = this.f40504b.f40534b;
        a2.a(y0Var, currentTimeMillis, 200, size).a();
        this.f40504b.a(wVar);
        E0 e0 = this.f40504b.f40535c;
        if (e0 != null && !e0.c()) {
            K0 k0 = this.f40504b;
            if (k0.f40540h) {
                return;
            }
            Info b2 = k0.f40535c.b();
            if (b2 != null) {
                this.f40504b.a(b2);
                return;
            }
        }
        this.f40504b.a(PBError.NO_FILL);
    }
}
