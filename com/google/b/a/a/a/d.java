package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8178a;
    private boolean ac;
    private boolean ad;
    private long s;
    private float w;
    private int y;

    /* renamed from: b  reason: collision with root package name */
    private double[] f8179b = new double[16];
    private c pOg = new c();
    private c pOh = new c();
    private c pOi = new c();
    private c pOj = new c();
    private c pOk = new c();
    private c pOl = new c();
    private c pOm = new c();
    private c pOn = new c();
    private c pOo = new c();
    private g pOp = new g();
    private g pOq = new g();
    private g pOr = new g();
    private g pOs = new g();
    private g pOt = new g();
    private g pOu = new g();
    private g pOv = new g();
    private final g pOw = new g();
    private double u = 0.0d;
    private double v = 0.0d;
    private boolean x = false;
    private boolean z = true;
    private c pOx = new c();
    private c pOy = new c();
    private g pOz = new g();
    private c pOA = new c();
    private c pOB = new c();
    private c pOC = new c();
    private c pOD = new c();
    private c pOE = new c();
    private c pOF = new c();
    private c pOG = new c();
    private c pOH = new c();
    private g pOI = new g();
    private g pOJ = new g();
    private g pOK = new g();
    private g pOL = new g();
    private g pOM = new g();
    private g pON = new g();
    private g pOO = new g();
    private g pOP = new g();
    private c pOQ = new c();
    private c pOR = new c();
    private c pOS = new c();
    private c pOT = new c();
    private c pOU = new c();
    private c pOV = new c();
    private c pOW = new c();
    private c pOX = new c();
    private c pOY = new c();
    private e pOZ = new e();

    static {
        f8178a = !d.class.desiredAssertionStatus();
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
        c.a(cVar, this.pOu, this.pOr);
        this.pOZ.a(this.pOr, this.pOq, this.pOX);
        this.pOZ.a(this.pOX, gVar);
    }

    private void b(double d) {
        double abs = Math.abs(d - this.u);
        this.u = d;
        this.v = (abs * 0.5d) + (this.v * 0.5d);
        double min = Math.min(7.0d, ((this.v / 0.15d) * 6.25d) + 0.75d);
        this.pOl.a(min * min);
    }

    private void c() {
        this.pOh.d(this.pOV);
        c.b(this.pOi, this.pOV, this.pOW);
        c.b(this.pOh, this.pOW, this.pOi);
        this.pOh.b();
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f8179b[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f8179b;
        double[] dArr2 = this.f8179b;
        this.f8179b[11] = 0.0d;
        dArr2[7] = 0.0d;
        dArr[3] = 0.0d;
        double[] dArr3 = this.f8179b;
        double[] dArr4 = this.f8179b;
        this.f8179b[14] = 0.0d;
        dArr4[13] = 0.0d;
        dArr3[12] = 0.0d;
        this.f8179b[15] = 1.0d;
        return this.f8179b;
    }

    public double[] Q(double d) {
        g gVar = this.pOz;
        gVar.a(this.pOw);
        gVar.a(-d);
        c cVar = this.pOx;
        f.a(gVar, cVar);
        c cVar2 = this.pOy;
        c.b(cVar, this.pOg, cVar2);
        return f(cVar2);
    }

    public synchronized void a() {
        this.s = 0L;
        this.pOg.b();
        this.pOh.b();
        this.pOi.a();
        this.pOi.a(25.0d);
        this.pOj.a();
        this.pOj.a(1.0d);
        this.pOk.a();
        this.pOk.a(0.0625d);
        this.pOl.a();
        this.pOl.a(0.5625d);
        this.pOm.a();
        this.pOn.a();
        this.pOo.a();
        this.pOp.a();
        this.pOq.a();
        this.pOr.a();
        this.pOs.a();
        this.pOt.a();
        this.pOu.a(0.0d, 0.0d, 9.81d);
        this.pOv.a(0.0d, 1.0d, 0.0d);
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
            this.pOs.a(gVar);
            this.pOs.a(-f);
            f.a(this.pOs, this.pOh);
            this.pOB.a(this.pOg);
            c.b(this.pOh, this.pOg, this.pOB);
            this.pOg.a(this.pOB);
            c();
            this.pOC.a(this.pOj);
            this.pOC.b(f * f);
            this.pOi.b(this.pOC);
        }
        this.s = j;
        this.pOw.a(gVar);
    }

    public synchronized void b(g gVar, long j) {
        this.pOq.a(gVar);
        b(this.pOq.c());
        if (this.ac) {
            a(this.pOg, this.pOp);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.pOK;
                gVar2.a();
                gVar2.c(i, 1.0E-7d);
                f.a(gVar2, this.pOD);
                c.b(this.pOD, this.pOg, this.pOE);
                a(this.pOE, this.pOI);
                g.b(this.pOp, this.pOI, this.pOJ);
                this.pOJ.a(1.0d / 1.0E-7d);
                this.pOn.a(i, this.pOJ);
            }
            this.pOn.d(this.pOF);
            c.b(this.pOi, this.pOF, this.pOG);
            c.b(this.pOn, this.pOG, this.pOH);
            c.a(this.pOH, this.pOl, this.pOm);
            this.pOm.e(this.pOF);
            this.pOn.d(this.pOG);
            c.b(this.pOG, this.pOF, this.pOH);
            c.b(this.pOi, this.pOH, this.pOo);
            c.a(this.pOo, this.pOp, this.pOt);
            c.b(this.pOo, this.pOn, this.pOF);
            this.pOG.b();
            this.pOG.c(this.pOF);
            c.b(this.pOG, this.pOi, this.pOF);
            this.pOi.a(this.pOF);
            f.a(this.pOt, this.pOh);
            c.b(this.pOh, this.pOg, this.pOg);
            c();
        } else {
            this.pOZ.a(this.pOu, this.pOq, this.pOg);
            this.ac = true;
        }
    }

    public boolean b() {
        return this.ac;
    }
}
