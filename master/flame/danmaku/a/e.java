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
    protected final master.flame.danmaku.danmaku.model.b nGB;
    protected l nGX;
    h.a nGY;
    final master.flame.danmaku.danmaku.b.a nGZ;
    protected final DanmakuContext nGr;
    protected master.flame.danmaku.danmaku.a.a nGx;
    master.flame.danmaku.danmaku.model.f nHa;
    protected boolean nHc;
    protected boolean nHe;
    private long nHf;
    private long nHg;
    protected int nHh;
    private boolean nHi;
    private master.flame.danmaku.danmaku.model.d nHj;
    private l nHl;
    private l nHb = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nHd = 0;
    private final a.b nGC = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nHk = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nHm = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nGr = danmakuContext;
        this.nGB = danmakuContext.dMR();
        this.nGY = aVar;
        this.nGZ = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nGZ.a(new a.InterfaceC0777a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0777a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nGY != null) {
                    e.this.nGY.i(dVar);
                }
            }
        });
        this.nGZ.wY(this.nGr.dMV() || this.nGr.dMU());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nGr.dMS());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nGr.nJA.Sl("1017_Filter");
            } else {
                this.nGr.nJA.Sm("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nHa = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nGX != null) {
            if (dVar.mzB) {
                this.nHk.k(dVar);
                NR(10);
            }
            dVar.index = this.nGX.size();
            boolean z = true;
            if (this.nHf <= dVar.dMt() && dVar.dMt() <= this.nHg) {
                synchronized (this.nHb) {
                    z = this.nHb.k(dVar);
                }
            } else if (dVar.mzB) {
                z = false;
            }
            synchronized (this.nGX) {
                k = this.nGX.k(dVar);
            }
            if (!z || !k) {
                this.nHg = 0L;
                this.nHf = 0L;
            }
            if (k && this.nGY != null) {
                this.nGY.h(dVar);
            }
            if (this.nHj == null || (dVar != null && this.nHj != null && dVar.dMt() > this.nHj.dMt())) {
                this.nHj = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wO(boolean z) {
        if (this.nGX != null && !this.nGX.isEmpty()) {
            synchronized (this.nGX) {
                if (!z) {
                    l ag = this.nGX.ag((this.nHa.nHR - this.nGr.nJB.nJG) - 100, this.nHa.nHR + this.nGr.nJB.nJG);
                    if (ag != null) {
                        this.nHb = ag;
                    }
                }
                this.nGX.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NR(final int i) {
        if (this.nGX != null && !this.nGX.isEmpty() && !this.nHk.isEmpty()) {
            this.nHk.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dNq();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dNq() - this.startTime <= i && isTimeOut) {
                        e.this.nGX.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hj(long j) {
        l ag = this.nGX.ag((j - this.nGr.nJB.nJG) - 100, this.nGr.nJB.nJG + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dMk()) {
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
        return a(bVar, this.nHa);
    }

    public void reset() {
        if (this.nHb != null) {
            this.nHb = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nGZ != null) {
            this.nGZ.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dMC;
        reset();
        this.nGr.nJz.dMv();
        this.nGr.nJz.dMy();
        this.nGr.nJz.dMz();
        this.nGr.nJz.dMA();
        this.nHl = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nHd = j;
        this.nGC.reset();
        this.nGC.endTime = this.nHd;
        this.nHg = 0L;
        this.nHf = 0L;
        if (this.nGX != null && (dMC = this.nGX.dMC()) != null && !dMC.isTimeOut()) {
            this.nHj = dMC;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hk(long j) {
        reset();
        this.nGr.nJz.dMv();
        this.nGr.nJz.dMy();
        this.nHd = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nGr.a(this.nHm);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nGr.dMW();
        if (this.nGZ != null) {
            this.nGZ.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nGx == null) {
            throw new AssertionError();
        }
        b(this.nGx);
        this.nHg = 0L;
        this.nHf = 0L;
        if (this.nGY != null) {
            this.nGY.dLR();
            this.nHe = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NQ(int i) {
        this.nHh = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nGX = aVar.c(this.nGr).c(this.nGB).d(this.nHa).a(new a.InterfaceC0776a() { // from class: master.flame.danmaku.a.e.5
        }).dNk();
        this.nGr.nJz.resetAll();
        if (this.nGX != null) {
            this.nHj = this.nGX.dMC();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nGx = aVar;
        this.nHe = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nHc) {
            this.nGZ.dNn();
            this.nHc = false;
        }
        if (this.nGX != null) {
            d.e((Canvas) bVar.nq());
            if (this.nHi) {
                return this.nGC;
            }
            a.b bVar2 = this.nGC;
            long j3 = (fVar.nHR - this.nGr.nJB.nJG) - 100;
            long j4 = this.nGr.nJB.nJG + fVar.nHR;
            l lVar = this.nHb;
            if (this.nHf > j3 || fVar.nHR > this.nHg) {
                lVar = this.nGX.ah(j3, j4);
                if (lVar != null) {
                    this.nHb = lVar;
                }
                this.nHf = j3;
                this.nHg = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nHf;
                j = this.nHg;
                j2 = j5;
            }
            l lVar2 = this.nHl;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nGC.nKr = true;
                this.nGZ.a(bVar, lVar2, 0L, this.nGC);
            }
            this.nGC.nKr = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nGZ.a(this.nGB, lVar, this.nHd, bVar2);
                a(bVar2);
                if (bVar2.nKD) {
                    if (this.nHj != null && this.nHj.isTimeOut()) {
                        this.nHj = null;
                        if (this.nGY != null) {
                            this.nGY.dLS();
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
            bVar2.nKD = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dLW() {
        this.nHg = 0L;
        this.nHf = 0L;
        this.nHi = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dLX() {
        this.nHc = true;
    }

    @Override // master.flame.danmaku.a.h
    public void m(long j, long j2, final long j3) {
        l dNo = this.nGC.dNo();
        this.nHl = dNo;
        dNo.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dMk()) {
                    return 2;
                }
                dVar.hn(j3 + dVar.nHu);
                dVar.nHQ = true;
                return 0;
            }
        });
        this.nHd = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nGY != null) {
            this.nGY.dLT();
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
                    this.nGr.nJA.Sl("1017_Filter");
                } else {
                    this.nGr.nJA.Sm("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dLX();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nGZ != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nGZ;
                if (this.nGr.dMV() || this.nGr.dMU()) {
                    z2 = true;
                }
                aVar.wY(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nGZ != null) {
                this.nGZ.wZ(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dLY() {
        this.nHi = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nGw.ho(master.flame.danmaku.danmaku.c.c.dNq());
        bVar.nKs = 0;
        bVar.nKt = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nKD = bVar.nKA == 0;
        if (bVar.nKD) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nKu;
        bVar.nKu = null;
        bVar.endTime = dVar != null ? dVar.dMt() : -1L;
        bVar.nKC = bVar.nGw.ho(master.flame.danmaku.danmaku.c.c.dNq());
    }
}
