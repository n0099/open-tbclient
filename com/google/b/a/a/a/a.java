package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class a {
    private b pVk;
    private b pVl;
    private b pVm;
    private g pVn;
    private g pVo;
    private C1058a pVp;
    private C1058a pVq;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1058a {

        /* renamed from: a  reason: collision with root package name */
        private final int f7876a;

        /* renamed from: b  reason: collision with root package name */
        private int f7877b;

        C1058a(int i) {
            this.f7876a = i;
        }

        void a(boolean z) {
            if (z) {
                this.f7877b++;
            } else {
                this.f7877b = 0;
            }
        }

        boolean a() {
            return this.f7877b >= this.f7876a;
        }
    }

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.pVm.a(this.pVl.eBZ(), j, max * max);
        }
    }

    public void a() {
        this.pVn = new g();
        this.pVo = new g();
        this.pVk = new b(1.0d);
        this.pVl = new b(10.0d);
        this.pVm = new b(0.15000000596046448d);
        this.pVp = new C1058a(10);
        this.pVq = new C1058a(10);
    }

    public void a(g gVar) {
        if (this.pVm.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pVm.eBZ());
        gVar.a(Math.min(1.0d, (this.pVm.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pVl.a(gVar, j);
        g.b(gVar, this.pVl.eBZ(), this.pVn);
        this.pVq.a(this.pVn.c() < 0.00800000037997961d);
        if (this.pVq.a() && this.pVp.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pVk.a(gVar, j);
        g.b(gVar, this.pVk.eBZ(), this.pVo);
        this.pVp.a(this.pVo.c() < 0.5d);
    }
}
