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
    protected final DanmakuContext nEE;
    protected master.flame.danmaku.danmaku.a.a nEK;
    protected final master.flame.danmaku.danmaku.model.b nEO;
    protected l nFk;
    h.a nFl;
    final master.flame.danmaku.danmaku.b.a nFm;
    master.flame.danmaku.danmaku.model.f nFn;
    protected boolean nFp;
    protected boolean nFr;
    private long nFs;
    private long nFt;
    protected int nFu;
    private boolean nFv;
    private master.flame.danmaku.danmaku.model.d nFw;
    private l nFy;
    private l nFo = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nFq = 0;
    private final a.b nEP = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nFx = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nFz = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nEE = danmakuContext;
        this.nEO = danmakuContext.dMr();
        this.nFl = aVar;
        this.nFm = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nFm.a(new a.InterfaceC0776a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0776a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nFl != null) {
                    e.this.nFl.i(dVar);
                }
            }
        });
        this.nFm.wQ(this.nEE.dMv() || this.nEE.dMu());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nEE.dMs());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nEE.nHN.Sl("1017_Filter");
            } else {
                this.nEE.nHN.Sm("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFn = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nFk != null) {
            if (dVar.mxV) {
                this.nFx.k(dVar);
                NL(10);
            }
            dVar.index = this.nFk.size();
            boolean z = true;
            if (this.nFs <= dVar.dLT() && dVar.dLT() <= this.nFt) {
                synchronized (this.nFo) {
                    z = this.nFo.k(dVar);
                }
            } else if (dVar.mxV) {
                z = false;
            }
            synchronized (this.nFk) {
                k = this.nFk.k(dVar);
            }
            if (!z || !k) {
                this.nFt = 0L;
                this.nFs = 0L;
            }
            if (k && this.nFl != null) {
                this.nFl.h(dVar);
            }
            if (this.nFw == null || (dVar != null && this.nFw != null && dVar.dLT() > this.nFw.dLT())) {
                this.nFw = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wG(boolean z) {
        if (this.nFk != null && !this.nFk.isEmpty()) {
            synchronized (this.nFk) {
                if (!z) {
                    l ag = this.nFk.ag((this.nFn.nGe - this.nEE.nHO.nHT) - 100, this.nFn.nGe + this.nEE.nHO.nHT);
                    if (ag != null) {
                        this.nFo = ag;
                    }
                }
                this.nFk.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NL(final int i) {
        if (this.nFk != null && !this.nFk.isEmpty() && !this.nFx.isEmpty()) {
            this.nFx.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dMQ();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dMQ() - this.startTime <= i && isTimeOut) {
                        e.this.nFk.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hi(long j) {
        l ag = this.nFk.ag((j - this.nEE.nHO.nHT) - 100, this.nEE.nHO.nHT + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dLK()) {
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
        return a(bVar, this.nFn);
    }

    public void reset() {
        if (this.nFo != null) {
            this.nFo = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nFm != null) {
            this.nFm.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dMc;
        reset();
        this.nEE.nHM.dLV();
        this.nEE.nHM.dLY();
        this.nEE.nHM.dLZ();
        this.nEE.nHM.dMa();
        this.nFy = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nFq = j;
        this.nEP.reset();
        this.nEP.endTime = this.nFq;
        this.nFt = 0L;
        this.nFs = 0L;
        if (this.nFk != null && (dMc = this.nFk.dMc()) != null && !dMc.isTimeOut()) {
            this.nFw = dMc;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hj(long j) {
        reset();
        this.nEE.nHM.dLV();
        this.nEE.nHM.dLY();
        this.nFq = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nEE.a(this.nFz);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nEE.dMw();
        if (this.nFm != null) {
            this.nFm.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEK == null) {
            throw new AssertionError();
        }
        b(this.nEK);
        this.nFt = 0L;
        this.nFs = 0L;
        if (this.nFl != null) {
            this.nFl.dLr();
            this.nFr = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NK(int i) {
        this.nFu = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nFk = aVar.c(this.nEE).c(this.nEO).d(this.nFn).a(new a.InterfaceC0775a() { // from class: master.flame.danmaku.a.e.5
        }).dMK();
        this.nEE.nHM.resetAll();
        if (this.nFk != null) {
            this.nFw = this.nFk.dMc();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEK = aVar;
        this.nFr = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nFp) {
            this.nFm.dMN();
            this.nFp = false;
        }
        if (this.nFk != null) {
            d.e((Canvas) bVar.nq());
            if (this.nFv) {
                return this.nEP;
            }
            a.b bVar2 = this.nEP;
            long j3 = (fVar.nGe - this.nEE.nHO.nHT) - 100;
            long j4 = this.nEE.nHO.nHT + fVar.nGe;
            l lVar = this.nFo;
            if (this.nFs > j3 || fVar.nGe > this.nFt) {
                lVar = this.nFk.ah(j3, j4);
                if (lVar != null) {
                    this.nFo = lVar;
                }
                this.nFs = j3;
                this.nFt = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nFs;
                j = this.nFt;
                j2 = j5;
            }
            l lVar2 = this.nFy;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nEP.nIE = true;
                this.nFm.a(bVar, lVar2, 0L, this.nEP);
            }
            this.nEP.nIE = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nFm.a(this.nEO, lVar, this.nFq, bVar2);
                a(bVar2);
                if (bVar2.nIQ) {
                    if (this.nFw != null && this.nFw.isTimeOut()) {
                        this.nFw = null;
                        if (this.nFl != null) {
                            this.nFl.dLs();
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
            bVar2.nIQ = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dLw() {
        this.nFt = 0L;
        this.nFs = 0L;
        this.nFv = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dLx() {
        this.nFp = true;
    }

    @Override // master.flame.danmaku.a.h
    public void m(long j, long j2, final long j3) {
        l dMO = this.nEP.dMO();
        this.nFy = dMO;
        dMO.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dLK()) {
                    return 2;
                }
                dVar.hm(j3 + dVar.nFH);
                dVar.nGd = true;
                return 0;
            }
        });
        this.nFq = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nFl != null) {
            this.nFl.dLt();
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
                    this.nEE.nHN.Sl("1017_Filter");
                } else {
                    this.nEE.nHN.Sm("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dLx();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nFm != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nFm;
                if (this.nEE.dMv() || this.nEE.dMu()) {
                    z2 = true;
                }
                aVar.wQ(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nFm != null) {
                this.nFm.wR(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dLy() {
        this.nFv = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nEJ.hn(master.flame.danmaku.danmaku.c.c.dMQ());
        bVar.nIF = 0;
        bVar.nIG = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nIQ = bVar.nIN == 0;
        if (bVar.nIQ) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nIH;
        bVar.nIH = null;
        bVar.endTime = dVar != null ? dVar.dLT() : -1L;
        bVar.nIP = bVar.nEJ.hn(master.flame.danmaku.danmaku.c.c.dMQ());
    }
}
