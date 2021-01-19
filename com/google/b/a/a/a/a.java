package com.google.b.a.a.a;
/* loaded from: classes4.dex */
public class a {
    private b pLf;
    private b pLg;
    private b pLh;
    private g pLi;
    private g pLj;
    private C1054a pLk;
    private C1054a pLl;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1054a {

        /* renamed from: a  reason: collision with root package name */
        private final int f7874a;

        /* renamed from: b  reason: collision with root package name */
        private int f7875b;

        C1054a(int i) {
            this.f7874a = i;
        }

        void a(boolean z) {
            if (z) {
                this.f7875b++;
            } else {
                this.f7875b = 0;
            }
        }

        boolean a() {
            return this.f7875b >= this.f7874a;
        }
    }

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.pLh.a(this.pLg.ezH(), j, max * max);
        }
    }

    public void a() {
        this.pLi = new g();
        this.pLj = new g();
        this.pLf = new b(1.0d);
        this.pLg = new b(10.0d);
        this.pLh = new b(0.15000000596046448d);
        this.pLk = new C1054a(10);
        this.pLl = new C1054a(10);
    }

    public void a(g gVar) {
        if (this.pLh.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.pLh.ezH());
        gVar.a(Math.min(1.0d, (this.pLh.a() - 30) / 100.0d));
    }

    public void a(g gVar, long j) {
        this.pLg.a(gVar, j);
        g.b(gVar, this.pLg.ezH(), this.pLi);
        this.pLl.a(this.pLi.c() < 0.00800000037997961d);
        if (this.pLl.a() && this.pLk.a()) {
            c(gVar, j);
        }
    }

    public void b(g gVar, long j) {
        this.pLf.a(gVar, j);
        g.b(gVar, this.pLf.ezH(), this.pLj);
        this.pLk.a(this.pLj.c() < 0.5d);
    }
}
