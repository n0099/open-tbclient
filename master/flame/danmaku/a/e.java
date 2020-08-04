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
    protected final DanmakuContext oaH;
    protected master.flame.danmaku.danmaku.a.a oaN;
    protected final master.flame.danmaku.danmaku.model.b oaR;
    private master.flame.danmaku.danmaku.model.d obA;
    private l obC;
    protected l obo;
    h.a obp;
    final master.flame.danmaku.danmaku.b.a obq;
    master.flame.danmaku.danmaku.model.f obr;
    protected boolean obt;
    protected boolean obv;
    private long obw;
    private long obx;
    protected int oby;
    private boolean obz;
    private l obs = new master.flame.danmaku.danmaku.model.android.d(4);
    private long obu = 0;
    private final a.b oaS = new a.b();
    private master.flame.danmaku.danmaku.model.android.d obB = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a obD = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.oaH = danmakuContext;
        this.oaR = danmakuContext.dWd();
        this.obp = aVar;
        this.obq = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.obq.a(new a.InterfaceC0919a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0919a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.obp != null) {
                    e.this.obp.i(dVar);
                }
            }
        });
        this.obq.yd(this.oaH.dWh() || this.oaH.dWg());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.oaH.dWe());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.oaH.odT.Ti("1017_Filter");
            } else {
                this.oaH.odT.Tj("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.obr = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.obo != null) {
            if (dVar.jVk) {
                this.obB.k(dVar);
                Lz(10);
            }
            dVar.index = this.obo.size();
            boolean z = true;
            if (this.obw <= dVar.dVF() && dVar.dVF() <= this.obx) {
                synchronized (this.obs) {
                    z = this.obs.k(dVar);
                }
            } else if (dVar.jVk) {
                z = false;
            }
            synchronized (this.obo) {
                k = this.obo.k(dVar);
            }
            if (!z || !k) {
                this.obx = 0L;
                this.obw = 0L;
            }
            if (k && this.obp != null) {
                this.obp.h(dVar);
            }
            if (this.obA == null || (dVar != null && this.obA != null && dVar.dVF() > this.obA.dVF())) {
                this.obA = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void xT(boolean z) {
        if (this.obo != null && !this.obo.isEmpty()) {
            synchronized (this.obo) {
                if (!z) {
                    l S = this.obo.S((this.obr.och - this.oaH.odU.odZ) - 100, this.obr.och + this.oaH.odU.odZ);
                    if (S != null) {
                        this.obs = S;
                    }
                }
                this.obo.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Lz(final int i) {
        if (this.obo != null && !this.obo.isEmpty() && !this.obB.isEmpty()) {
            this.obB.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dWC();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dWC() - this.startTime <= i && isTimeOut) {
                        e.this.obo.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gD(long j) {
        l S = this.obo.S((j - this.oaH.odU.odZ) - 100, this.oaH.odU.odZ + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (S != null && !S.isEmpty()) {
            S.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dVw()) {
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
        return a(bVar, this.obr);
    }

    public void reset() {
        if (this.obs != null) {
            this.obs = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.obq != null) {
            this.obq.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dVO;
        reset();
        this.oaH.odS.dVH();
        this.oaH.odS.dVK();
        this.oaH.odS.dVL();
        this.oaH.odS.dVM();
        this.obC = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.obu = j;
        this.oaS.reset();
        this.oaS.endTime = this.obu;
        this.obx = 0L;
        this.obw = 0L;
        if (this.obo != null && (dVO = this.obo.dVO()) != null && !dVO.isTimeOut()) {
            this.obA = dVO;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gE(long j) {
        reset();
        this.oaH.odS.dVH();
        this.oaH.odS.dVK();
        this.obu = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.oaH.a(this.obD);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.oaH.dWi();
        if (this.obq != null) {
            this.obq.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oaN == null) {
            throw new AssertionError();
        }
        b(this.oaN);
        this.obx = 0L;
        this.obw = 0L;
        if (this.obp != null) {
            this.obp.dVd();
            this.obv = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Ly(int i) {
        this.oby = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.obo = aVar.c(this.oaH).c(this.oaR).d(this.obr).a(new a.InterfaceC0918a() { // from class: master.flame.danmaku.a.e.5
        }).dWw();
        this.oaH.odS.resetAll();
        if (this.obo != null) {
            this.obA = this.obo.dVO();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oaN = aVar;
        this.obv = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.obt) {
            this.obq.dWz();
            this.obt = false;
        }
        if (this.obo != null) {
            d.e((Canvas) bVar.sm());
            if (this.obz) {
                return this.oaS;
            }
            a.b bVar2 = this.oaS;
            long j3 = (fVar.och - this.oaH.odU.odZ) - 100;
            long j4 = this.oaH.odU.odZ + fVar.och;
            l lVar = this.obs;
            if (this.obw > j3 || fVar.och > this.obx) {
                lVar = this.obo.T(j3, j4);
                if (lVar != null) {
                    this.obs = lVar;
                }
                this.obw = j3;
                this.obx = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.obw;
                j = this.obx;
                j2 = j5;
            }
            l lVar2 = this.obC;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.oaS.oeJ = true;
                this.obq.a(bVar, lVar2, 0L, this.oaS);
            }
            this.oaS.oeJ = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.obq.a(this.oaR, lVar, this.obu, bVar2);
                a(bVar2);
                if (bVar2.oeV) {
                    if (this.obA != null && this.obA.isTimeOut()) {
                        this.obA = null;
                        if (this.obp != null) {
                            this.obp.dVe();
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
            bVar2.oeV = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dVi() {
        this.obx = 0L;
        this.obw = 0L;
        this.obz = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dVj() {
        this.obt = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l dWA = this.oaS.dWA();
        this.obC = dWA;
        dWA.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dVw()) {
                    return 2;
                }
                dVar.gH(j3 + dVar.obL);
                dVar.ocg = true;
                return 0;
            }
        });
        this.obu = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.obp != null) {
            this.obp.dVf();
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
                    this.oaH.odT.Ti("1017_Filter");
                } else {
                    this.oaH.odT.Tj("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dVj();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.obq != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.obq;
                if (this.oaH.dWh() || this.oaH.dWg()) {
                    z2 = true;
                }
                aVar.yd(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.obq != null) {
                this.obq.ye(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dVk() {
        this.obz = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.oaM.gI(master.flame.danmaku.danmaku.c.c.dWC());
        bVar.oeK = 0;
        bVar.oeL = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.oeV = bVar.oeS == 0;
        if (bVar.oeV) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.oeM;
        bVar.oeM = null;
        bVar.endTime = dVar != null ? dVar.dVF() : -1L;
        bVar.oeU = bVar.oaM.gI(master.flame.danmaku.danmaku.c.c.dWC());
    }
}
