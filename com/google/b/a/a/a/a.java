package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class a {
    private b pNX;
    private b pNY;
    private b pNZ;
    private g pOa;
    private g pOb;
    private C1030a pOc;
    private C1030a pOd;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1030a {

        /* renamed from: a  reason: collision with root package name */
        private final int f8173a;

        /* renamed from: b  reason: collision with root package name */
        private int f8174b;

        C1030a(int i) {
            this.f8173a = i;
        }

        void a(boolean z) {
            if (z) {
                this.f8174b++;
            } else {
                this.f8174b = 0;
            }
        }

        boolean a() {
            return this.f8174b >= this.f8173a;
        }
    }

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.pNZ.a(this.pNY.eCV(), j, max * max);
        }
    }

    public void a() {
        this.pOa = new g();
        this.pOb = new g();
        this.pNX = new b(1.0d);
        this.pNY = new b(10.0d);
        this.pNZ = new b(0.15000000596046448d);
        this.pOc = new C1030a(10);
        this.pOd = new C1030a(10);
    }

    public void a(g gVar) {
        if (this.pNZ.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pNZ.eCV());
        gVar.a(Math.min(1.0d, (this.pNZ.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pNY.a(gVar, j);
        g.b(gVar, this.pNY.eCV(), this.pOa);
        this.pOd.a(this.pOa.c() < 0.00800000037997961d);
        if (this.pOd.a() && this.pOc.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pNX.a(gVar, j);
        g.b(gVar, this.pNX.eCV(), this.pOb);
        this.pOc.a(this.pOb.c() < 0.5d);
    }
}
