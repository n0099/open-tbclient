package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8179a;
    private boolean ac;
    private boolean ad;
    private long s;
    private float w;
    private int y;

    /* renamed from: b  reason: collision with root package name */
    private double[] f8180b = new double[16];
    private c pPO = new c();
    private c pPP = new c();
    private c pPQ = new c();
    private c pPR = new c();
    private c pPS = new c();
    private c pPT = new c();
    private c pPU = new c();
    private c pPV = new c();
    private c pPW = new c();
    private g pPX = new g();
    private g pPY = new g();
    private g pPZ = new g();
    private g pQa = new g();
    private g pQb = new g();
    private g pQc = new g();
    private g pQd = new g();
    private final g pQe = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pQf = new c();
    private c pQg = new c();
    private g pQh = new g();
    private c pQi = new c();
    private c pQj = new c();
    private c pQk = new c();
    private c pQl = new c();
    private c pQm = new c();
    private c pQn = new c();
    private c pQo = new c();
    private c pQp = new c();
    private g pQq = new g();
    private g pQr = new g();
    private g pQs = new g();
    private g pQt = new g();
    private g pQu = new g();
    private g pQv = new g();
    private g pQw = new g();
    private g pQx = new g();
    private c pQy = new c();
    private c pQz = new c();
    private c pQA = new c();
    private c pQB = new c();
    private c pQC = new c();
    private c pQD = new c();
    private c pQE = new c();
    private c pQF = new c();
    private c pQG = new c();
    private e pQH = new e();

    static {
        f8179a = !d.class.desiredAssertionStatus();
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
        c.a(cVar, this.pQc, this.pPZ);
        this.pQH.a(this.pPZ, this.pPY, this.pQF);
        this.pQH.a(this.pQF, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pPT.a(min * min);
    }

    private void c() {
        this.pPP.d(this.pQD);
        c.b(this.pPQ, this.pQD, this.pQE);
        c.b(this.pPP, this.pQE, this.pPQ);
        this.pPP.b();
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f8180b[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f8180b;
        double[] dArr2 = this.f8180b;
        this.f8180b[11] = 0.0d;
        dArr2[7] = 0.0d;
        dArr[3] = 0.0d;
        double[] dArr3 = this.f8180b;
        double[] dArr4 = this.f8180b;
        this.f8180b[14] = 0.0d;
        dArr4[13] = 0.0d;
        dArr3[12] = 0.0d;
        this.f8180b[15] = 1.0d;
        return this.f8180b;
    }

    public double[] Q(double d) {
        g gVar = this.pQh;
        gVar.a(this.pQe);
        gVar.a(-d);
        c cVar = this.pQf;
        f.a(gVar, cVar);
        c cVar2 = this.pQg;
        c.b(cVar, this.pPO, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pPO.b();
        this.pPP.b();
        this.pPQ.a();
        this.pPQ.a(25.0d);
        this.pPR.a();
        this.pPR.a(1.0d);
        this.pPS.a();
        this.pPS.a(0.0625d);
        this.pPT.a();
        this.pPT.a(0.5625d);
        this.pPU.a();
        this.pPV.a();
        this.pPW.a();
        this.pPX.a();
        this.pPY.a();
        this.pPZ.a();
        this.pQa.a();
        this.pQb.a();
        this.pQc.a(0.0d, 0.0d, 9.81d);
        this.pQd.a(0.0d, 1.0d, 0.0d);
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
            this.pQa.a(gVar);
            this.pQa.a(-f);
            f.a(this.pQa, this.pPP);
            this.pQj.a(this.pPO);
            c.b(this.pPP, this.pPO, this.pQj);
            this.pPO.a(this.pQj);
            c();
            this.pQk.a(this.pPR);
            this.pQk.b(f * f);
            this.pPQ.b(this.pQk);
        }
        this.s = j;
        this.pQe.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pPY.a(gVar);
        b(this.pPY.c());
        if (this.ac) {
            a(this.pPO, this.pPX);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pQs;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pQl);
                c.b(this.pQl, this.pPO, this.pQm);
                a(this.pQm, this.pQq);
                g.b(this.pPX, this.pQq, this.pQr);
                this.pQr.a(1.0d / 1.0E-7d);
                this.pPV.a(i, this.pQr);
            }
            this.pPV.d(this.pQn);
            c.b(this.pPQ, this.pQn, this.pQo);
            c.b(this.pPV, this.pQo, this.pQp);
            c.a(this.pQp, this.pPT, this.pPU);
            this.pPU.e(this.pQn);
            this.pPV.d(this.pQo);
            c.b(this.pQo, this.pQn, this.pQp);
            c.b(this.pPQ, this.pQp, this.pPW);
            c.a(this.pPW, this.pPX, this.pQb);
            c.b(this.pPW, this.pPV, this.pQn);
            this.pQo.b();
            this.pQo.c(this.pQn);
            c.b(this.pQo, this.pPQ, this.pQn);
            this.pPQ.a(this.pQn);
            f.a(this.pQb, this.pPP);
            c.b(this.pPP, this.pPO, this.pPO);
            c();
        } else {
            this.pQH.a(this.pQc, this.pPY, this.pPO);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
