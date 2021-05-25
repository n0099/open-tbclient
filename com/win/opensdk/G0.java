package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class G0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public long f36824a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f36825b;

    public G0(K0 k0) {
        this.f36825b = k0;
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        w0 a2 = x0.a(this.f36825b.f36854a);
        y0 y0Var = new y0(null);
        y0Var.f37183a = this.f36825b.f36855b;
        a2.a(y0Var, System.currentTimeMillis() - this.f36824a, i2, 0).a();
        this.f36825b.j.removeMessages(100101);
        this.f36825b.f36857d = false;
        this.f36825b.a(this.f36825b.a(i2));
    }

    @Override // com.win.opensdk.r0
    public void a() {
        this.f36824a = System.currentTimeMillis();
        K0 k0 = this.f36825b;
        k0.j.sendEmptyMessageDelayed(100101, k0.f36859f * 1000);
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        w wVar = (w) obj;
        this.f36825b.j.removeMessages(100101);
        this.f36825b.f36857d = false;
        int size = wVar.f37154a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f36824a;
        Info info = size > 0 ? (Info) wVar.f37154a.get(0) : null;
        w0 a2 = x0.a(this.f36825b.f36854a);
        y0 y0Var = new y0(info);
        y0Var.f37183a = this.f36825b.f36855b;
        a2.a(y0Var, currentTimeMillis, 200, size).a();
        this.f36825b.a(wVar);
        E0 e0 = this.f36825b.f36856c;
        if (e0 != null && !e0.c()) {
            K0 k0 = this.f36825b;
            if (k0.f36861h) {
                return;
            }
            Info b2 = k0.f36856c.b();
            if (b2 != null) {
                this.f36825b.a(b2);
                return;
            }
        }
        this.f36825b.a(PBError.NO_FILL);
    }
}
