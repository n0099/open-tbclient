package master.flame.danmaku.a;

import android.graphics.Canvas;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.a.a;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes5.dex */
public class e implements h {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected final DanmakuContext nRT;
    protected master.flame.danmaku.danmaku.a.a nRZ;
    h.a nSA;
    final master.flame.danmaku.danmaku.b.a nSB;
    master.flame.danmaku.danmaku.model.f nSC;
    protected boolean nSE;
    protected boolean nSG;
    private long nSH;
    private long nSI;
    protected int nSJ;
    private boolean nSK;
    private master.flame.danmaku.danmaku.model.d nSL;
    private l nSN;
    protected final master.flame.danmaku.danmaku.model.b nSd;
    protected l nSz;
    private l nSD = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nSF = 0;
    private final a.b nSe = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nSM = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nSO = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nRT = danmakuContext;
        this.nSd = danmakuContext.dSC();
        this.nSA = aVar;
        this.nSB = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nSB.a(new a.InterfaceC0903a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0903a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nSA != null) {
                    e.this.nSA.i(dVar);
                }
            }
        });
        this.nSB.xy(this.nRT.dSG() || this.nRT.dSF());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nRT.dSD());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nRT.nVe.Sw("1017_Filter");
            } else {
                this.nRT.nVe.Sx("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nSC = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nSz != null) {
            if (dVar.jMK) {
                this.nSM.k(dVar);
                Lf(10);
            }
            dVar.index = this.nSz.size();
            boolean z = true;
            if (this.nSH <= dVar.dSe() && dVar.dSe() <= this.nSI) {
                synchronized (this.nSD) {
                    z = this.nSD.k(dVar);
                }
            } else if (dVar.jMK) {
                z = false;
            }
            synchronized (this.nSz) {
                k = this.nSz.k(dVar);
            }
            if (!z || !k) {
                this.nSI = 0L;
                this.nSH = 0L;
            }
            if (k && this.nSA != null) {
                this.nSA.h(dVar);
            }
            if (this.nSL == null || (dVar != null && this.nSL != null && dVar.dSe() > this.nSL.dSe())) {
                this.nSL = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void xo(boolean z) {
        if (this.nSz != null && !this.nSz.isEmpty()) {
            synchronized (this.nSz) {
                if (!z) {
                    l Q = this.nSz.Q((this.nSC.nTt - this.nRT.nVf.nVk) - 100, this.nSC.nTt + this.nRT.nVf.nVk);
                    if (Q != null) {
                        this.nSD = Q;
                    }
                }
                this.nSz.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Lf(final int i) {
        if (this.nSz != null && !this.nSz.isEmpty() && !this.nSM.isEmpty()) {
            this.nSM.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dTb();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dTb() - this.startTime <= i && isTimeOut) {
                        e.this.nSz.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gq(long j) {
        l Q = this.nSz.Q((j - this.nRT.nVf.nVk) - 100, this.nRT.nVf.nVk + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (Q != null && !Q.isEmpty()) {
            Q.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dRV()) {
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
        return a(bVar, this.nSC);
    }

    public void reset() {
        if (this.nSD != null) {
            this.nSD = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nSB != null) {
            this.nSB.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dSn;
        reset();
        this.nRT.nVd.dSg();
        this.nRT.nVd.dSj();
        this.nRT.nVd.dSk();
        this.nRT.nVd.dSl();
        this.nSN = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nSF = j;
        this.nSe.reset();
        this.nSe.endTime = this.nSF;
        this.nSI = 0L;
        this.nSH = 0L;
        if (this.nSz != null && (dSn = this.nSz.dSn()) != null && !dSn.isTimeOut()) {
            this.nSL = dSn;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gr(long j) {
        reset();
        this.nRT.nVd.dSg();
        this.nRT.nVd.dSj();
        this.nSF = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nRT.a(this.nSO);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nRT.dSH();
        if (this.nSB != null) {
            this.nSB.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nRZ == null) {
            throw new AssertionError();
        }
        b(this.nRZ);
        this.nSI = 0L;
        this.nSH = 0L;
        if (this.nSA != null) {
            this.nSA.dRC();
            this.nSG = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Le(int i) {
        this.nSJ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nSz = aVar.c(this.nRT).c(this.nSd).d(this.nSC).a(new a.InterfaceC0902a() { // from class: master.flame.danmaku.a.e.5
        }).dSV();
        this.nRT.nVd.resetAll();
        if (this.nSz != null) {
            this.nSL = this.nSz.dSn();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nRZ = aVar;
        this.nSG = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nSE) {
            this.nSB.dSY();
            this.nSE = false;
        }
        if (this.nSz != null) {
            d.e((Canvas) bVar.sk());
            if (this.nSK) {
                return this.nSe;
            }
            a.b bVar2 = this.nSe;
            long j3 = (fVar.nTt - this.nRT.nVf.nVk) - 100;
            long j4 = this.nRT.nVf.nVk + fVar.nTt;
            l lVar = this.nSD;
            if (this.nSH > j3 || fVar.nTt > this.nSI) {
                lVar = this.nSz.R(j3, j4);
                if (lVar != null) {
                    this.nSD = lVar;
                }
                this.nSH = j3;
                this.nSI = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nSH;
                j = this.nSI;
                j2 = j5;
            }
            l lVar2 = this.nSN;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nSe.nVU = true;
                this.nSB.a(bVar, lVar2, 0L, this.nSe);
            }
            this.nSe.nVU = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nSB.a(this.nSd, lVar, this.nSF, bVar2);
                a(bVar2);
                if (bVar2.nWg) {
                    if (this.nSL != null && this.nSL.isTimeOut()) {
                        this.nSL = null;
                        if (this.nSA != null) {
                            this.nSA.dRD();
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
            bVar2.nWg = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dRH() {
        this.nSI = 0L;
        this.nSH = 0L;
        this.nSK = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dRI() {
        this.nSE = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l dSZ = this.nSe.dSZ();
        this.nSN = dSZ;
        dSZ.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dRV()) {
                    return 2;
                }
                dVar.gu(j3 + dVar.nSW);
                dVar.nTs = true;
                return 0;
            }
        });
        this.nSF = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nSA != null) {
            this.nSA.dRE();
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
                    this.nRT.nVe.Sw("1017_Filter");
                } else {
                    this.nRT.nVe.Sx("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dRI();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nSB != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nSB;
                if (this.nRT.dSG() || this.nRT.dSF()) {
                    z2 = true;
                }
                aVar.xy(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nSB != null) {
                this.nSB.xz(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dRJ() {
        this.nSK = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nRY.gv(master.flame.danmaku.danmaku.c.c.dTb());
        bVar.nVV = 0;
        bVar.nVW = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nWg = bVar.nWd == 0;
        if (bVar.nWg) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nVX;
        bVar.nVX = null;
        bVar.endTime = dVar != null ? dVar.dSe() : -1L;
        bVar.nWf = bVar.nRY.gv(master.flame.danmaku.danmaku.c.c.dTb());
    }
}
