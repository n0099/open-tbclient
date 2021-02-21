package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7881a;
    private boolean ac;
    private boolean ad;
    private long s;
    private float w;
    private int y;

    /* renamed from: b  reason: collision with root package name */
    private double[] f7882b = new double[16];
    private c pVT = new c();
    private c pVU = new c();
    private c pVV = new c();
    private c pVW = new c();
    private c pVX = new c();
    private c pVY = new c();
    private c pVZ = new c();
    private c pWa = new c();
    private c pWb = new c();
    private g pWc = new g();
    private g pWd = new g();
    private g pWe = new g();
    private g pWf = new g();
    private g pWg = new g();
    private g pWh = new g();
    private g pWi = new g();
    private final g pWj = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pWk = new c();
    private c pWl = new c();
    private g pWm = new g();
    private c pWn = new c();
    private c pWo = new c();
    private c pWp = new c();
    private c pWq = new c();
    private c pWr = new c();
    private c pWs = new c();
    private c pWt = new c();
    private c pWu = new c();
    private g pWv = new g();
    private g pWw = new g();
    private g pWx = new g();
    private g pWy = new g();
    private g pWz = new g();
    private g pWA = new g();
    private g pWB = new g();
    private g pWC = new g();
    private c pWD = new c();
    private c pWE = new c();
    private c pWF = new c();
    private c pWG = new c();
    private c pWH = new c();
    private c pWI = new c();
    private c pWJ = new c();
    private c pWK = new c();
    private c pWL = new c();
    private e pWM = new e();

    static {
        f7881a = !d.class.desiredAssertionStatus();
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
        c.a(cVar, this.pWh, this.pWe);
        this.pWM.a(this.pWe, this.pWd, this.pWK);
        this.pWM.a(this.pWK, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pVY.a(min * min);
    }

    private void c() {
        this.pVU.d(this.pWI);
        c.b(this.pVV, this.pWI, this.pWJ);
        c.b(this.pVU, this.pWJ, this.pVV);
        this.pVU.b();
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f7882b[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f7882b;
        double[] dArr2 = this.f7882b;
        this.f7882b[11] = 0.0d;
        dArr2[7] = 0.0d;
        dArr[3] = 0.0d;
        double[] dArr3 = this.f7882b;
        double[] dArr4 = this.f7882b;
        this.f7882b[14] = 0.0d;
        dArr4[13] = 0.0d;
        dArr3[12] = 0.0d;
        this.f7882b[15] = 1.0d;
        return this.f7882b;
    }

    public double[] K(double d) {
        g gVar = this.pWm;
        gVar.a(this.pWj);
        gVar.a(-d);
        c cVar = this.pWk;
        f.a(gVar, cVar);
        c cVar2 = this.pWl;
        c.b(cVar, this.pVT, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pVT.b();
        this.pVU.b();
        this.pVV.a();
        this.pVV.a(25.0d);
        this.pVW.a();
        this.pVW.a(1.0d);
        this.pVX.a();
        this.pVX.a(0.0625d);
        this.pVY.a();
        this.pVY.a(0.5625d);
        this.pVZ.a();
        this.pWa.a();
        this.pWb.a();
        this.pWc.a();
        this.pWd.a();
        this.pWe.a();
        this.pWf.a();
        this.pWg.a();
        this.pWh.a(0.0d, 0.0d, 9.81d);
        this.pWi.a(0.0d, 1.0d, 0.0d);
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
            this.pWf.a(gVar);
            this.pWf.a(-f);
            f.a(this.pWf, this.pVU);
            this.pWo.a(this.pVT);
            c.b(this.pVU, this.pVT, this.pWo);
            this.pVT.a(this.pWo);
            c();
            this.pWp.a(this.pVW);
            this.pWp.b(f * f);
            this.pVV.b(this.pWp);
        }
        this.s = j;
        this.pWj.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pWd.a(gVar);
        b(this.pWd.c());
        if (this.ac) {
            a(this.pVT, this.pWc);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pWx;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pWq);
                c.b(this.pWq, this.pVT, this.pWr);
                a(this.pWr, this.pWv);
                g.b(this.pWc, this.pWv, this.pWw);
                this.pWw.a(1.0d / 1.0E-7d);
                this.pWa.a(i, this.pWw);
            }
            this.pWa.d(this.pWs);
            c.b(this.pVV, this.pWs, this.pWt);
            c.b(this.pWa, this.pWt, this.pWu);
            c.a(this.pWu, this.pVY, this.pVZ);
            this.pVZ.e(this.pWs);
            this.pWa.d(this.pWt);
            c.b(this.pWt, this.pWs, this.pWu);
            c.b(this.pVV, this.pWu, this.pWb);
            c.a(this.pWb, this.pWc, this.pWg);
            c.b(this.pWb, this.pWa, this.pWs);
            this.pWt.b();
            this.pWt.c(this.pWs);
            c.b(this.pWt, this.pVV, this.pWs);
            this.pVV.a(this.pWs);
            f.a(this.pWg, this.pVU);
            c.b(this.pVU, this.pVT, this.pVT);
            c();
        } else {
            this.pWM.a(this.pWh, this.pWd, this.pVT);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
