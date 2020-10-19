package master.flame.danmaku.a;

import android.graphics.Canvas;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.a.a;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes6.dex */
public class e implements h {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected final DanmakuContext oTT;
    protected master.flame.danmaku.danmaku.a.a oTZ;
    h.a oUA;
    final master.flame.danmaku.danmaku.b.a oUB;
    master.flame.danmaku.danmaku.model.f oUC;
    protected boolean oUE;
    protected boolean oUG;
    private long oUH;
    private long oUI;
    protected int oUJ;
    private boolean oUK;
    private master.flame.danmaku.danmaku.model.d oUL;
    private l oUN;
    protected final master.flame.danmaku.danmaku.model.b oUd;
    protected l oUz;
    private l oUD = new master.flame.danmaku.danmaku.model.android.d(4);
    private long oUF = 0;
    private final a.b oUe = new a.b();
    private master.flame.danmaku.danmaku.model.android.d oUM = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a oUO = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.a
        public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return e.this.a(danmakuContext, danmakuConfigTag, objArr);
        }
    };

    static {
        $assertionsDisabled = !e.class.desiredAssertionStatus();
    }

    public e(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        if (danmakuContext == null) {
            throw new IllegalArgumentException("context is null");
        }
        this.oTT = danmakuContext;
        this.oUd = danmakuContext.epZ();
        this.oUA = aVar;
        this.oUB = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.oUB.a(new a.InterfaceC0992a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0992a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.oUA != null) {
                    e.this.oUA.i(dVar);
                }
            }
        });
        this.oUB.zM(this.oTT.eqd() || this.oTT.eqc());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.oTT.eqa());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.oTT.oXc.XC("1017_Filter");
            } else {
                this.oTT.oXc.XD("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.oUC = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.oUz != null) {
            if (dVar.kIy) {
                this.oUM.k(dVar);
                Pn(10);
            }
            dVar.index = this.oUz.size();
            boolean z = true;
            if (this.oUH <= dVar.epB() && dVar.epB() <= this.oUI) {
                synchronized (this.oUD) {
                    z = this.oUD.k(dVar);
                }
            } else if (dVar.kIy) {
                z = false;
            }
            synchronized (this.oUz) {
                k = this.oUz.k(dVar);
            }
            if (!z || !k) {
                this.oUI = 0L;
                this.oUH = 0L;
            }
            if (k && this.oUA != null) {
                this.oUA.h(dVar);
            }
            if (this.oUL == null || (dVar != null && this.oUL != null && dVar.epB() > this.oUL.epB())) {
                this.oUL = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void zC(boolean z) {
        if (this.oUz != null && !this.oUz.isEmpty()) {
            synchronized (this.oUz) {
                if (!z) {
                    l P = this.oUz.P((this.oUC.oVs - this.oTT.oXd.oXi) - 100, this.oUC.oVs + this.oTT.oXd.oXi);
                    if (P != null) {
                        this.oUD = P;
                    }
                }
                this.oUz.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Pn(final int i) {
        if (this.oUz != null && !this.oUz.isEmpty() && !this.oUM.isEmpty()) {
            this.oUM.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eqy();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean epr = dVar.epr();
                    if (master.flame.danmaku.danmaku.c.c.eqy() - this.startTime <= i && epr) {
                        e.this.oUz.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hy(long j) {
        l P = this.oUz.P((j - this.oTT.oXd.oXi) - 100, this.oTT.oXd.oXi + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (P != null && !P.isEmpty()) {
            P.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.eps()) {
                        dVar.k(dVar2);
                        return 0;
                    }
                    return 0;
                }
            });
        }
        return dVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        return a(bVar, this.oUC);
    }

    public void reset() {
        if (this.oUD != null) {
            this.oUD = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.oUB != null) {
            this.oUB.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d epK;
        reset();
        this.oTT.oXb.epD();
        this.oTT.oXb.epG();
        this.oTT.oXb.epH();
        this.oTT.oXb.epI();
        this.oUN = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.oUF = j;
        this.oUe.reset();
        this.oUe.endTime = this.oUF;
        this.oUI = 0L;
        this.oUH = 0L;
        if (this.oUz != null && (epK = this.oUz.epK()) != null && !epK.epr()) {
            this.oUL = epK;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hz(long j) {
        reset();
        this.oTT.oXb.epD();
        this.oTT.oXb.epG();
        this.oUF = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.oTT.a(this.oUO);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.oTT.eqe();
        if (this.oUB != null) {
            this.oUB.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oTZ == null) {
            throw new AssertionError();
        }
        b(this.oTZ);
        this.oUI = 0L;
        this.oUH = 0L;
        if (this.oUA != null) {
            this.oUA.eoY();
            this.oUG = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Pm(int i) {
        this.oUJ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.oUz = aVar.c(this.oTT).c(this.oUd).d(this.oUC).a(new a.InterfaceC0991a() { // from class: master.flame.danmaku.a.e.5
        }).eqs();
        this.oTT.oXb.resetAll();
        if (this.oUz != null) {
            this.oUL = this.oUz.epK();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oTZ = aVar;
        this.oUG = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.oUE) {
            this.oUB.eqv();
            this.oUE = false;
        }
        if (this.oUz != null) {
            d.e((Canvas) bVar.ud());
            if (this.oUK) {
                return this.oUe;
            }
            a.b bVar2 = this.oUe;
            long j3 = (fVar.oVs - this.oTT.oXd.oXi) - 100;
            long j4 = this.oTT.oXd.oXi + fVar.oVs;
            l lVar = this.oUD;
            if (this.oUH > j3 || fVar.oVs > this.oUI) {
                lVar = this.oUz.Q(j3, j4);
                if (lVar != null) {
                    this.oUD = lVar;
                }
                this.oUH = j3;
                this.oUI = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.oUH;
                j = this.oUI;
                j2 = j5;
            }
            l lVar2 = this.oUN;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.oUe.oXR = true;
                this.oUB.a(bVar, lVar2, 0L, this.oUe);
            }
            this.oUe.oXR = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.oUB.a(this.oUd, lVar, this.oUF, bVar2);
                a(bVar2);
                if (bVar2.oYd) {
                    if (this.oUL != null && this.oUL.epr()) {
                        this.oUL = null;
                        if (this.oUA != null) {
                            this.oUA.eoZ();
                        }
                    }
                    if (bVar2.beginTime == -1) {
                        bVar2.beginTime = j2;
                    }
                    if (bVar2.endTime == -1) {
                        bVar2.endTime = j;
                    }
                }
                return bVar2;
            }
            bVar2.oYd = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void epd() {
        this.oUI = 0L;
        this.oUH = 0L;
        this.oUK = false;
    }

    @Override // master.flame.danmaku.a.h
    public void epe() {
        this.oUE = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eqw = this.oUe.eqw();
        this.oUN = eqw;
        eqw.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.eps()) {
                    return 2;
                }
                dVar.hC(j3 + dVar.oUW);
                dVar.oVr = true;
                return 0;
            }
        });
        this.oUF = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.oUA != null) {
            this.oUA.epa();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        Boolean bool;
        boolean z;
        boolean z2 = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.oTT.oXc.XC("1017_Filter");
                } else {
                    this.oTT.oXc.XD("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            epe();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.oUB != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.oUB;
                if (this.oTT.eqd() || this.oTT.eqc()) {
                    z2 = true;
                }
                aVar.zM(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.oUB != null) {
                this.oUB.zN(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void epf() {
        this.oUK = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.oTY.hD(master.flame.danmaku.danmaku.c.c.eqy());
        bVar.oXS = 0;
        bVar.oXT = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.oYd = bVar.oYa == 0;
        if (bVar.oYd) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.oXU;
        bVar.oXU = null;
        bVar.endTime = dVar != null ? dVar.epB() : -1L;
        bVar.oYc = bVar.oTY.hD(master.flame.danmaku.danmaku.c.c.eqy());
    }
}
