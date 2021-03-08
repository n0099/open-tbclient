package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f5277a;
    private boolean ac;
    private boolean ad;
    private long s;
    private float w;
    private int y;
    private double[] b = new double[16];
    private c pWI = new c();
    private c pWJ = new c();
    private c pWK = new c();
    private c pWL = new c();
    private c pWM = new c();
    private c pWN = new c();
    private c pWO = new c();
    private c pWP = new c();
    private c pWQ = new c();
    private g pWR = new g();
    private g pWS = new g();
    private g pWT = new g();
    private g pWU = new g();
    private g pWV = new g();
    private g pWW = new g();
    private g pWX = new g();
    private final g pWY = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pWZ = new c();
    private c pXa = new c();
    private g pXb = new g();
    private c pXc = new c();
    private c pXd = new c();
    private c pXe = new c();
    private c pXf = new c();
    private c pXg = new c();
    private c pXh = new c();
    private c pXi = new c();
    private c pXj = new c();
    private g pXk = new g();
    private g pXl = new g();
    private g pXm = new g();
    private g pXn = new g();
    private g pXo = new g();
    private g pXp = new g();
    private g pXq = new g();
    private g pXr = new g();
    private c pXs = new c();
    private c pXt = new c();
    private c pXu = new c();
    private c pXv = new c();
    private c pXw = new c();
    private c pXx = new c();
    private c pXy = new c();
    private c pXz = new c();
    private c pXA = new c();
    private e pXB = new e();

    static {
        f5277a = !d.class.desiredAssertionStatus();
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
        c.a(cVar, this.pWW, this.pWT);
        this.pXB.a(this.pWT, this.pWS, this.pXz);
        this.pXB.a(this.pXz, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pWN.a(min * min);
    }

    private void c() {
        this.pWJ.d(this.pXx);
        c.b(this.pWK, this.pXx, this.pXy);
        c.b(this.pWJ, this.pXy, this.pWK);
        this.pWJ.b();
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.b[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.b;
        double[] dArr2 = this.b;
        this.b[11] = 0.0d;
        dArr2[7] = 0.0d;
        dArr[3] = 0.0d;
        double[] dArr3 = this.b;
        double[] dArr4 = this.b;
        this.b[14] = 0.0d;
        dArr4[13] = 0.0d;
        dArr3[12] = 0.0d;
        this.b[15] = 1.0d;
        return this.b;
    }

    public double[] K(double d) {
        g gVar = this.pXb;
        gVar.a(this.pWY);
        gVar.a(-d);
        c cVar = this.pWZ;
        f.a(gVar, cVar);
        c cVar2 = this.pXa;
        c.b(cVar, this.pWI, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pWI.b();
        this.pWJ.b();
        this.pWK.a();
        this.pWK.a(25.0d);
        this.pWL.a();
        this.pWL.a(1.0d);
        this.pWM.a();
        this.pWM.a(0.0625d);
        this.pWN.a();
        this.pWN.a(0.5625d);
        this.pWO.a();
        this.pWP.a();
        this.pWQ.a();
        this.pWR.a();
        this.pWS.a();
        this.pWT.a();
        this.pWU.a();
        this.pWV.a();
        this.pWW.a(0.0d, 0.0d, 9.81d);
        this.pWX.a(0.0d, 1.0d, 0.0d);
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
            this.pWU.a(gVar);
            this.pWU.a(-f);
            f.a(this.pWU, this.pWJ);
            this.pXd.a(this.pWI);
            c.b(this.pWJ, this.pWI, this.pXd);
            this.pWI.a(this.pXd);
            c();
            this.pXe.a(this.pWL);
            this.pXe.b(f * f);
            this.pWK.b(this.pXe);
        }
        this.s = j;
        this.pWY.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pWS.a(gVar);
        b(this.pWS.c());
        if (this.ac) {
            a(this.pWI, this.pWR);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pXm;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pXf);
                c.b(this.pXf, this.pWI, this.pXg);
                a(this.pXg, this.pXk);
                g.b(this.pWR, this.pXk, this.pXl);
                this.pXl.a(1.0d / 1.0E-7d);
                this.pWP.a(i, this.pXl);
            }
            this.pWP.d(this.pXh);
            c.b(this.pWK, this.pXh, this.pXi);
            c.b(this.pWP, this.pXi, this.pXj);
            c.a(this.pXj, this.pWN, this.pWO);
            this.pWO.e(this.pXh);
            this.pWP.d(this.pXi);
            c.b(this.pXi, this.pXh, this.pXj);
            c.b(this.pWK, this.pXj, this.pWQ);
            c.a(this.pWQ, this.pWR, this.pWV);
            c.b(this.pWQ, this.pWP, this.pXh);
            this.pXi.b();
            this.pXi.c(this.pXh);
            c.b(this.pXi, this.pWK, this.pXh);
            this.pWK.a(this.pXh);
            f.a(this.pWV, this.pWJ);
            c.b(this.pWJ, this.pWI, this.pWI);
            c();
        } else {
            this.pXB.a(this.pWW, this.pWS, this.pWI);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
