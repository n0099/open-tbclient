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
    private c pVt = new c();
    private c pVu = new c();
    private c pVv = new c();
    private c pVw = new c();
    private c pVx = new c();
    private c pVy = new c();
    private c pVz = new c();
    private c pVA = new c();
    private c pVB = new c();
    private g pVC = new g();
    private g pVD = new g();
    private g pVE = new g();
    private g pVF = new g();
    private g pVG = new g();
    private g pVH = new g();
    private g pVI = new g();
    private final g pVJ = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pVK = new c();
    private c pVL = new c();
    private g pVM = new g();
    private c pVN = new c();
    private c pVO = new c();
    private c pVP = new c();
    private c pVQ = new c();
    private c pVR = new c();
    private c pVS = new c();
    private c pVT = new c();
    private c pVU = new c();
    private g pVV = new g();
    private g pVW = new g();
    private g pVX = new g();
    private g pVY = new g();
    private g pVZ = new g();
    private g pWa = new g();
    private g pWb = new g();
    private g pWc = new g();
    private c pWd = new c();
    private c pWe = new c();
    private c pWf = new c();
    private c pWg = new c();
    private c pWh = new c();
    private c pWi = new c();
    private c pWj = new c();
    private c pWk = new c();
    private c pWl = new c();
    private e pWm = new e();

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
        c.a(cVar, this.pVH, this.pVE);
        this.pWm.a(this.pVE, this.pVD, this.pWk);
        this.pWm.a(this.pWk, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pVy.a(min * min);
    }

    private void c() {
        this.pVu.d(this.pWi);
        c.b(this.pVv, this.pWi, this.pWj);
        c.b(this.pVu, this.pWj, this.pVv);
        this.pVu.b();
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
        g gVar = this.pVM;
        gVar.a(this.pVJ);
        gVar.a(-d);
        c cVar = this.pVK;
        f.a(gVar, cVar);
        c cVar2 = this.pVL;
        c.b(cVar, this.pVt, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pVt.b();
        this.pVu.b();
        this.pVv.a();
        this.pVv.a(25.0d);
        this.pVw.a();
        this.pVw.a(1.0d);
        this.pVx.a();
        this.pVx.a(0.0625d);
        this.pVy.a();
        this.pVy.a(0.5625d);
        this.pVz.a();
        this.pVA.a();
        this.pVB.a();
        this.pVC.a();
        this.pVD.a();
        this.pVE.a();
        this.pVF.a();
        this.pVG.a();
        this.pVH.a(0.0d, 0.0d, 9.81d);
        this.pVI.a(0.0d, 1.0d, 0.0d);
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
            this.pVF.a(gVar);
            this.pVF.a(-f);
            f.a(this.pVF, this.pVu);
            this.pVO.a(this.pVt);
            c.b(this.pVu, this.pVt, this.pVO);
            this.pVt.a(this.pVO);
            c();
            this.pVP.a(this.pVw);
            this.pVP.b(f * f);
            this.pVv.b(this.pVP);
        }
        this.s = j;
        this.pVJ.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pVD.a(gVar);
        b(this.pVD.c());
        if (this.ac) {
            a(this.pVt, this.pVC);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pVX;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pVQ);
                c.b(this.pVQ, this.pVt, this.pVR);
                a(this.pVR, this.pVV);
                g.b(this.pVC, this.pVV, this.pVW);
                this.pVW.a(1.0d / 1.0E-7d);
                this.pVA.a(i, this.pVW);
            }
            this.pVA.d(this.pVS);
            c.b(this.pVv, this.pVS, this.pVT);
            c.b(this.pVA, this.pVT, this.pVU);
            c.a(this.pVU, this.pVy, this.pVz);
            this.pVz.e(this.pVS);
            this.pVA.d(this.pVT);
            c.b(this.pVT, this.pVS, this.pVU);
            c.b(this.pVv, this.pVU, this.pVB);
            c.a(this.pVB, this.pVC, this.pVG);
            c.b(this.pVB, this.pVA, this.pVS);
            this.pVT.b();
            this.pVT.c(this.pVS);
            c.b(this.pVT, this.pVv, this.pVS);
            this.pVv.a(this.pVS);
            f.a(this.pVG, this.pVu);
            c.b(this.pVu, this.pVt, this.pVt);
            c();
        } else {
            this.pWm.a(this.pVH, this.pVD, this.pVt);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
