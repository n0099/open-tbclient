package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class a {
    private b pVK;
    private b pVL;
    private b pVM;
    private g pVN;
    private g pVO;
    private C1060a pVP;
    private C1060a pVQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1060a {

        /* renamed from: a  reason: collision with root package name */
        private final int f7876a;

        /* renamed from: b  reason: collision with root package name */
        private int f7877b;

        C1060a(int i) {
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
            this.pVM.a(this.pVL.eCh(), j, max * max);
        }
    }

    public void a() {
        this.pVN = new g();
        this.pVO = new g();
        this.pVK = new b(1.0d);
        this.pVL = new b(10.0d);
        this.pVM = new b(0.15000000596046448d);
        this.pVP = new C1060a(10);
        this.pVQ = new C1060a(10);
    }

    public void a(g gVar) {
        if (this.pVM.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pVM.eCh());
        gVar.a(Math.min(1.0d, (this.pVM.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pVL.a(gVar, j);
        g.b(gVar, this.pVL.eCh(), this.pVN);
        this.pVQ.a(this.pVN.c() < 0.00800000037997961d);
        if (this.pVQ.a() && this.pVP.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pVK.a(gVar, j);
        g.b(gVar, this.pVK.eCh(), this.pVO);
        this.pVP.a(this.pVO.c() < 0.5d);
    }
}
