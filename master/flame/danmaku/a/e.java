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
    protected final master.flame.danmaku.danmaku.model.b nED;
    protected l nEZ;
    protected final DanmakuContext nEt;
    protected master.flame.danmaku.danmaku.a.a nEz;
    h.a nFa;
    final master.flame.danmaku.danmaku.b.a nFb;
    master.flame.danmaku.danmaku.model.f nFc;
    protected boolean nFe;
    protected boolean nFg;
    private long nFh;
    private long nFi;
    protected int nFj;
    private boolean nFk;
    private master.flame.danmaku.danmaku.model.d nFl;
    private l nFn;
    private l nFd = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nFf = 0;
    private final a.b nEE = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nFm = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nFo = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nEt = danmakuContext;
        this.nED = danmakuContext.dMq();
        this.nFa = aVar;
        this.nFb = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nFb.a(new a.InterfaceC0776a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0776a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nFa != null) {
                    e.this.nFa.i(dVar);
                }
            }
        });
        this.nFb.wQ(this.nEt.dMu() || this.nEt.dMt());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nEt.dMr());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nEt.nHC.Sk("1017_Filter");
            } else {
                this.nEt.nHC.Sl("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFc = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nEZ != null) {
            if (dVar.mxK) {
                this.nFm.k(dVar);
                NL(10);
            }
            dVar.index = this.nEZ.size();
            boolean z = true;
            if (this.nFh <= dVar.dLS() && dVar.dLS() <= this.nFi) {
                synchronized (this.nFd) {
                    z = this.nFd.k(dVar);
                }
            } else if (dVar.mxK) {
                z = false;
            }
            synchronized (this.nEZ) {
                k = this.nEZ.k(dVar);
            }
            if (!z || !k) {
                this.nFi = 0L;
                this.nFh = 0L;
            }
            if (k && this.nFa != null) {
                this.nFa.h(dVar);
            }
            if (this.nFl == null || (dVar != null && this.nFl != null && dVar.dLS() > this.nFl.dLS())) {
                this.nFl = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wG(boolean z) {
        if (this.nEZ != null && !this.nEZ.isEmpty()) {
            synchronized (this.nEZ) {
                if (!z) {
                    l ag = this.nEZ.ag((this.nFc.nFT - this.nEt.nHD.nHI) - 100, this.nFc.nFT + this.nEt.nHD.nHI);
                    if (ag != null) {
                        this.nFd = ag;
                    }
                }
                this.nEZ.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NL(final int i) {
        if (this.nEZ != null && !this.nEZ.isEmpty() && !this.nFm.isEmpty()) {
            this.nFm.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dMP();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dMP() - this.startTime <= i && isTimeOut) {
                        e.this.nEZ.l(dVar);
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
        l ag = this.nEZ.ag((j - this.nEt.nHD.nHI) - 100, this.nEt.nHD.nHI + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dLJ()) {
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
        return a(bVar, this.nFc);
    }

    public void reset() {
        if (this.nFd != null) {
            this.nFd = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nFb != null) {
            this.nFb.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dMb;
        reset();
        this.nEt.nHB.dLU();
        this.nEt.nHB.dLX();
        this.nEt.nHB.dLY();
        this.nEt.nHB.dLZ();
        this.nFn = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nFf = j;
        this.nEE.reset();
        this.nEE.endTime = this.nFf;
        this.nFi = 0L;
        this.nFh = 0L;
        if (this.nEZ != null && (dMb = this.nEZ.dMb()) != null && !dMb.isTimeOut()) {
            this.nFl = dMb;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hj(long j) {
        reset();
        this.nEt.nHB.dLU();
        this.nEt.nHB.dLX();
        this.nFf = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nEt.a(this.nFo);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nEt.dMv();
        if (this.nFb != null) {
            this.nFb.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEz == null) {
            throw new AssertionError();
        }
        b(this.nEz);
        this.nFi = 0L;
        this.nFh = 0L;
        if (this.nFa != null) {
            this.nFa.dLq();
            this.nFg = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NK(int i) {
        this.nFj = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEZ = aVar.c(this.nEt).c(this.nED).d(this.nFc).a(new a.InterfaceC0775a() { // from class: master.flame.danmaku.a.e.5
        }).dMJ();
        this.nEt.nHB.resetAll();
        if (this.nEZ != null) {
            this.nFl = this.nEZ.dMb();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEz = aVar;
        this.nFg = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nFe) {
            this.nFb.dMM();
            this.nFe = false;
        }
        if (this.nEZ != null) {
            d.e((Canvas) bVar.nq());
            if (this.nFk) {
                return this.nEE;
            }
            a.b bVar2 = this.nEE;
            long j3 = (fVar.nFT - this.nEt.nHD.nHI) - 100;
            long j4 = this.nEt.nHD.nHI + fVar.nFT;
            l lVar = this.nFd;
            if (this.nFh > j3 || fVar.nFT > this.nFi) {
                lVar = this.nEZ.ah(j3, j4);
                if (lVar != null) {
                    this.nFd = lVar;
                }
                this.nFh = j3;
                this.nFi = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nFh;
                j = this.nFi;
                j2 = j5;
            }
            l lVar2 = this.nFn;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nEE.nIt = true;
                this.nFb.a(bVar, lVar2, 0L, this.nEE);
            }
            this.nEE.nIt = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nFb.a(this.nED, lVar, this.nFf, bVar2);
                a(bVar2);
                if (bVar2.nIF) {
                    if (this.nFl != null && this.nFl.isTimeOut()) {
                        this.nFl = null;
                        if (this.nFa != null) {
                            this.nFa.dLr();
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
            bVar2.nIF = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dLv() {
        this.nFi = 0L;
        this.nFh = 0L;
        this.nFk = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dLw() {
        this.nFe = true;
    }

    @Override // master.flame.danmaku.a.h
    public void m(long j, long j2, final long j3) {
        l dMN = this.nEE.dMN();
        this.nFn = dMN;
        dMN.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dLJ()) {
                    return 2;
                }
                dVar.hm(j3 + dVar.nFw);
                dVar.nFS = true;
                return 0;
            }
        });
        this.nFf = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nFa != null) {
            this.nFa.dLs();
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
                    this.nEt.nHC.Sk("1017_Filter");
                } else {
                    this.nEt.nHC.Sl("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dLw();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nFb != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nFb;
                if (this.nEt.dMu() || this.nEt.dMt()) {
                    z2 = true;
                }
                aVar.wQ(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nFb != null) {
                this.nFb.wR(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dLx() {
        this.nFk = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nEy.hn(master.flame.danmaku.danmaku.c.c.dMP());
        bVar.nIu = 0;
        bVar.nIv = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nIF = bVar.nIC == 0;
        if (bVar.nIF) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nIw;
        bVar.nIw = null;
        bVar.endTime = dVar != null ? dVar.dLS() : -1L;
        bVar.nIE = bVar.nEy.hn(master.flame.danmaku.danmaku.c.c.dMP());
    }
}
