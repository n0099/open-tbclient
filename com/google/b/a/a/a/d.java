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
    private c pLo = new c();
    private c pLp = new c();
    private c pLq = new c();
    private c pLr = new c();
    private c pLs = new c();
    private c pLt = new c();
    private c pLu = new c();
    private c pLv = new c();
    private c pLw = new c();
    private g pLx = new g();
    private g pLy = new g();
    private g pLz = new g();
    private g pLA = new g();
    private g pLB = new g();
    private g pLC = new g();
    private g pLD = new g();
    private final g pLE = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pLF = new c();
    private c pLG = new c();
    private g pLH = new g();
    private c pLI = new c();
    private c pLJ = new c();
    private c pLK = new c();
    private c pLL = new c();
    private c pLM = new c();
    private c pLN = new c();
    private c pLO = new c();
    private c pLP = new c();
    private g pLQ = new g();
    private g pLR = new g();
    private g pLS = new g();
    private g pLT = new g();
    private g pLU = new g();
    private g pLV = new g();
    private g pLW = new g();
    private g pLX = new g();
    private c pLY = new c();
    private c pLZ = new c();
    private c pMa = new c();
    private c pMb = new c();
    private c pMc = new c();
    private c pMd = new c();
    private c pMe = new c();
    private c pMf = new c();
    private c pMg = new c();
    private e pMh = new e();

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
        c.a(cVar, this.pLC, this.pLz);
        this.pMh.a(this.pLz, this.pLy, this.pMf);
        this.pMh.a(this.pMf, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pLt.a(min * min);
    }

    private void c() {
        this.pLp.d(this.pMd);
        c.b(this.pLq, this.pMd, this.pMe);
        c.b(this.pLp, this.pMe, this.pLq);
        this.pLp.b();
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
        g gVar = this.pLH;
        gVar.a(this.pLE);
        gVar.a(-d);
        c cVar = this.pLF;
        f.a(gVar, cVar);
        c cVar2 = this.pLG;
        c.b(cVar, this.pLo, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pLo.b();
        this.pLp.b();
        this.pLq.a();
        this.pLq.a(25.0d);
        this.pLr.a();
        this.pLr.a(1.0d);
        this.pLs.a();
        this.pLs.a(0.0625d);
        this.pLt.a();
        this.pLt.a(0.5625d);
        this.pLu.a();
        this.pLv.a();
        this.pLw.a();
        this.pLx.a();
        this.pLy.a();
        this.pLz.a();
        this.pLA.a();
        this.pLB.a();
        this.pLC.a(0.0d, 0.0d, 9.81d);
        this.pLD.a(0.0d, 1.0d, 0.0d);
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
            this.pLA.a(gVar);
            this.pLA.a(-f);
            f.a(this.pLA, this.pLp);
            this.pLJ.a(this.pLo);
            c.b(this.pLp, this.pLo, this.pLJ);
            this.pLo.a(this.pLJ);
            c();
            this.pLK.a(this.pLr);
            this.pLK.b(f * f);
            this.pLq.b(this.pLK);
        }
        this.s = j;
        this.pLE.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pLy.a(gVar);
        b(this.pLy.c());
        if (this.ac) {
            a(this.pLo, this.pLx);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pLS;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pLL);
                c.b(this.pLL, this.pLo, this.pLM);
                a(this.pLM, this.pLQ);
                g.b(this.pLx, this.pLQ, this.pLR);
                this.pLR.a(1.0d / 1.0E-7d);
                this.pLv.a(i, this.pLR);
            }
            this.pLv.d(this.pLN);
            c.b(this.pLq, this.pLN, this.pLO);
            c.b(this.pLv, this.pLO, this.pLP);
            c.a(this.pLP, this.pLt, this.pLu);
            this.pLu.e(this.pLN);
            this.pLv.d(this.pLO);
            c.b(this.pLO, this.pLN, this.pLP);
            c.b(this.pLq, this.pLP, this.pLw);
            c.a(this.pLw, this.pLx, this.pLB);
            c.b(this.pLw, this.pLv, this.pLN);
            this.pLO.b();
            this.pLO.c(this.pLN);
            c.b(this.pLO, this.pLq, this.pLN);
            this.pLq.a(this.pLN);
            f.a(this.pLB, this.pLp);
            c.b(this.pLp, this.pLo, this.pLo);
            c();
        } else {
            this.pMh.a(this.pLC, this.pLy, this.pLo);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
