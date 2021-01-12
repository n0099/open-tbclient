package com.google.b.a.a.a;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7879a;
    private boolean ac;
    private boolean ad;
    private long s;
    private float w;
    private int y;

    /* renamed from: b  reason: collision with root package name */
    private double[] f7880b = new double[16];
    private c pLn = new c();
    private c pLo = new c();
    private c pLp = new c();
    private c pLq = new c();
    private c pLr = new c();
    private c pLs = new c();
    private c pLt = new c();
    private c pLu = new c();
    private c pLv = new c();
    private g pLw = new g();
    private g pLx = new g();
    private g pLy = new g();
    private g pLz = new g();
    private g pLA = new g();
    private g pLB = new g();
    private g pLC = new g();
    private final g pLD = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pLE = new c();
    private c pLF = new c();
    private g pLG = new g();
    private c pLH = new c();
    private c pLI = new c();
    private c pLJ = new c();
    private c pLK = new c();
    private c pLL = new c();
    private c pLM = new c();
    private c pLN = new c();
    private c pLO = new c();
    private g pLP = new g();
    private g pLQ = new g();
    private g pLR = new g();
    private g pLS = new g();
    private g pLT = new g();
    private g pLU = new g();
    private g pLV = new g();
    private g pLW = new g();
    private c pLX = new c();
    private c pLY = new c();
    private c pLZ = new c();
    private c pMa = new c();
    private c pMb = new c();
    private c pMc = new c();
    private c pMd = new c();
    private c pMe = new c();
    private c pMf = new c();
    private e pMg = new e();

    static {
        f7879a = !d.class.desiredAssertionStatus();
    }

    public d() {
        a();
    }

    private void a(float f) {
        if (!this.x) {
            this.w = f;
            this.y = 1;
            this.x = true;
            return;
        }
        this.w = (0.95f * this.w) + (0.050000012f * f);
        int i = this.y + 1;
        this.y = i;
        if (i > 10.0f) {
            this.z = true;
        }
    }

    private void a(c cVar, g gVar) {
        c.a(cVar, this.pLB, this.pLy);
        this.pMg.a(this.pLy, this.pLx, this.pMe);
        this.pMg.a(this.pMe, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pLs.a(min * min);
    }

    private void c() {
        this.pLo.d(this.pMc);
        c.b(this.pLp, this.pMc, this.pMd);
        c.b(this.pLo, this.pMd, this.pLp);
        this.pLo.b();
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f7880b[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f7880b;
        double[] dArr2 = this.f7880b;
        this.f7880b[11] = 0.0d;
        dArr2[7] = 0.0d;
        dArr[3] = 0.0d;
        double[] dArr3 = this.f7880b;
        double[] dArr4 = this.f7880b;
        this.f7880b[14] = 0.0d;
        dArr4[13] = 0.0d;
        dArr3[12] = 0.0d;
        this.f7880b[15] = 1.0d;
        return this.f7880b;
    }

    public double[] K(double d) {
        g gVar = this.pLG;
        gVar.a(this.pLD);
        gVar.a(-d);
        c cVar = this.pLE;
        f.a(gVar, cVar);
        c cVar2 = this.pLF;
        c.b(cVar, this.pLn, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pLn.b();
        this.pLo.b();
        this.pLp.a();
        this.pLp.a(25.0d);
        this.pLq.a();
        this.pLq.a(1.0d);
        this.pLr.a();
        this.pLr.a(0.0625d);
        this.pLs.a();
        this.pLs.a(0.5625d);
        this.pLt.a();
        this.pLu.a();
        this.pLv.a();
        this.pLw.a();
        this.pLx.a();
        this.pLy.a();
        this.pLz.a();
        this.pLA.a();
        this.pLB.a(0.0d, 0.0d, 9.81d);
        this.pLC.a(0.0d, 1.0d, 0.0d);
        this.ac = false;
        this.ad = false;
    }

    public synchronized void a(g gVar, long j) {
        if (this.s != 0) {
            float f = ((float) (j - this.s)) * 1.0E-9f;
            if (f > 0.04f) {
                f = this.z ? this.w : 0.01f;
            } else {
                a(f);
            }
            this.pLz.a(gVar);
            this.pLz.a(-f);
            f.a(this.pLz, this.pLo);
            this.pLI.a(this.pLn);
            c.b(this.pLo, this.pLn, this.pLI);
            this.pLn.a(this.pLI);
            c();
            this.pLJ.a(this.pLq);
            this.pLJ.b(f * f);
            this.pLp.b(this.pLJ);
        }
        this.s = j;
        this.pLD.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pLx.a(gVar);
        b(this.pLx.c());
        if (this.ac) {
            a(this.pLn, this.pLw);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pLR;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pLK);
                c.b(this.pLK, this.pLn, this.pLL);
                a(this.pLL, this.pLP);
                g.b(this.pLw, this.pLP, this.pLQ);
                this.pLQ.a(1.0d / 1.0E-7d);
                this.pLu.a(i, this.pLQ);
            }
            this.pLu.d(this.pLM);
            c.b(this.pLp, this.pLM, this.pLN);
            c.b(this.pLu, this.pLN, this.pLO);
            c.a(this.pLO, this.pLs, this.pLt);
            this.pLt.e(this.pLM);
            this.pLu.d(this.pLN);
            c.b(this.pLN, this.pLM, this.pLO);
            c.b(this.pLp, this.pLO, this.pLv);
            c.a(this.pLv, this.pLw, this.pLA);
            c.b(this.pLv, this.pLu, this.pLM);
            this.pLN.b();
            this.pLN.c(this.pLM);
            c.b(this.pLN, this.pLp, this.pLM);
            this.pLp.a(this.pLM);
            f.a(this.pLA, this.pLo);
            c.b(this.pLo, this.pLn, this.pLn);
            c();
        } else {
            this.pMg.a(this.pLB, this.pLx, this.pLn);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
