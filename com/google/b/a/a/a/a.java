package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class a {
    private b pWA;
    private b pWB;
    private g pWC;
    private g pWD;
    private C1077a pWE;
    private C1077a pWF;
    private b pWz;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1077a {

        /* renamed from: a  reason: collision with root package name */
        private final int f5274a;
        private int b;

        C1077a(int i) {
            this.f5274a = i;
        }

        void a(boolean z) {
            if (z) {
                this.b++;
            } else {
                this.b = 0;
            }
        }

        boolean a() {
            return this.b >= this.f5274a;
        }
    }

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.pWB.a(this.pWA.eCn(), j, max * max);
        }
    }

    public void a() {
        this.pWC = new g();
        this.pWD = new g();
        this.pWz = new b(1.0d);
        this.pWA = new b(10.0d);
        this.pWB = new b(0.15000000596046448d);
        this.pWE = new C1077a(10);
        this.pWF = new C1077a(10);
    }

    public void a(g gVar) {
        if (this.pWB.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pWB.eCn());
        gVar.a(Math.min(1.0d, (this.pWB.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pWA.a(gVar, j);
        g.b(gVar, this.pWA.eCn(), this.pWC);
        this.pWF.a(this.pWC.c() < 0.00800000037997961d);
        if (this.pWF.a() && this.pWE.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pWz.a(gVar, j);
        g.b(gVar, this.pWz.eCn(), this.pWD);
        this.pWE.a(this.pWD.c() < 0.5d);
    }
}
