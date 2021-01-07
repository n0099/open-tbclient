package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class a {
    private b pPF;
    private b pPG;
    private b pPH;
    private g pPI;
    private g pPJ;
    private C1071a pPK;
    private C1071a pPL;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1071a {

        /* renamed from: a  reason: collision with root package name */
        private final int f8174a;

        /* renamed from: b  reason: collision with root package name */
        private int f8175b;

        C1071a(int i) {
            this.f8174a = i;
        }

        void a(boolean z) {
            if (z) {
                this.f8175b++;
            } else {
                this.f8175b = 0;
            }
        }

        boolean a() {
            return this.f8175b >= this.f8174a;
        }
    }

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.pPH.a(this.pPG.eDz(), j, max * max);
        }
    }

    public void a() {
        this.pPI = new g();
        this.pPJ = new g();
        this.pPF = new b(1.0d);
        this.pPG = new b(10.0d);
        this.pPH = new b(0.15000000596046448d);
        this.pPK = new C1071a(10);
        this.pPL = new C1071a(10);
    }

    public void a(g gVar) {
        if (this.pPH.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pPH.eDz());
        gVar.a(Math.min(1.0d, (this.pPH.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pPG.a(gVar, j);
        g.b(gVar, this.pPG.eDz(), this.pPI);
        this.pPL.a(this.pPI.c() < 0.00800000037997961d);
        if (this.pPL.a() && this.pPK.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pPF.a(gVar, j);
        g.b(gVar, this.pPF.eDz(), this.pPJ);
        this.pPK.a(this.pPJ.c() < 0.5d);
    }
}
