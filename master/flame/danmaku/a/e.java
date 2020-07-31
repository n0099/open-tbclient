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
    protected final DanmakuContext oaF;
    protected master.flame.danmaku.danmaku.a.a oaL;
    protected final master.flame.danmaku.danmaku.model.b oaP;
    private l obA;
    protected l obm;
    h.a obn;
    final master.flame.danmaku.danmaku.b.a obo;
    master.flame.danmaku.danmaku.model.f obp;
    protected boolean obr;
    protected boolean obt;
    private long obu;
    private long obv;
    protected int obw;
    private boolean obx;
    private master.flame.danmaku.danmaku.model.d oby;
    private l obq = new master.flame.danmaku.danmaku.model.android.d(4);
    private long obs = 0;
    private final a.b oaQ = new a.b();
    private master.flame.danmaku.danmaku.model.android.d obz = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a obB = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.oaF = danmakuContext;
        this.oaP = danmakuContext.dWc();
        this.obn = aVar;
        this.obo = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.obo.a(new a.InterfaceC0919a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0919a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.obn != null) {
                    e.this.obn.i(dVar);
                }
            }
        });
        this.obo.yd(this.oaF.dWg() || this.oaF.dWf());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.oaF.dWd());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.oaF.odR.Ti("1017_Filter");
            } else {
                this.oaF.odR.Tj("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.obp = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.obm != null) {
            if (dVar.jVi) {
                this.obz.k(dVar);
                Lz(10);
            }
            dVar.index = this.obm.size();
            boolean z = true;
            if (this.obu <= dVar.dVE() && dVar.dVE() <= this.obv) {
                synchronized (this.obq) {
                    z = this.obq.k(dVar);
                }
            } else if (dVar.jVi) {
                z = false;
            }
            synchronized (this.obm) {
                k = this.obm.k(dVar);
            }
            if (!z || !k) {
                this.obv = 0L;
                this.obu = 0L;
            }
            if (k && this.obn != null) {
                this.obn.h(dVar);
            }
            if (this.oby == null || (dVar != null && this.oby != null && dVar.dVE() > this.oby.dVE())) {
                this.oby = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void xT(boolean z) {
        if (this.obm != null && !this.obm.isEmpty()) {
            synchronized (this.obm) {
                if (!z) {
                    l S = this.obm.S((this.obp.ocf - this.oaF.odS.odX) - 100, this.obp.ocf + this.oaF.odS.odX);
                    if (S != null) {
                        this.obq = S;
                    }
                }
                this.obm.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Lz(final int i) {
        if (this.obm != null && !this.obm.isEmpty() && !this.obz.isEmpty()) {
            this.obz.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dWB();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dWB() - this.startTime <= i && isTimeOut) {
                        e.this.obm.l(dVar);
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
        l S = this.obm.S((j - this.oaF.odS.odX) - 100, this.oaF.odS.odX + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (S != null && !S.isEmpty()) {
            S.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dVv()) {
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
        return a(bVar, this.obp);
    }

    public void reset() {
        if (this.obq != null) {
            this.obq = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.obo != null) {
            this.obo.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dVN;
        reset();
        this.oaF.odQ.dVG();
        this.oaF.odQ.dVJ();
        this.oaF.odQ.dVK();
        this.oaF.odQ.dVL();
        this.obA = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.obs = j;
        this.oaQ.reset();
        this.oaQ.endTime = this.obs;
        this.obv = 0L;
        this.obu = 0L;
        if (this.obm != null && (dVN = this.obm.dVN()) != null && !dVN.isTimeOut()) {
            this.oby = dVN;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gE(long j) {
        reset();
        this.oaF.odQ.dVG();
        this.oaF.odQ.dVJ();
        this.obs = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.oaF.a(this.obB);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.oaF.dWh();
        if (this.obo != null) {
            this.obo.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oaL == null) {
            throw new AssertionError();
        }
        b(this.oaL);
        this.obv = 0L;
        this.obu = 0L;
        if (this.obn != null) {
            this.obn.dVc();
            this.obt = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Ly(int i) {
        this.obw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.obm = aVar.c(this.oaF).c(this.oaP).d(this.obp).a(new a.InterfaceC0918a() { // from class: master.flame.danmaku.a.e.5
        }).dWv();
        this.oaF.odQ.resetAll();
        if (this.obm != null) {
            this.oby = this.obm.dVN();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oaL = aVar;
        this.obt = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.obr) {
            this.obo.dWy();
            this.obr = false;
        }
        if (this.obm != null) {
            d.e((Canvas) bVar.sm());
            if (this.obx) {
                return this.oaQ;
            }
            a.b bVar2 = this.oaQ;
            long j3 = (fVar.ocf - this.oaF.odS.odX) - 100;
            long j4 = this.oaF.odS.odX + fVar.ocf;
            l lVar = this.obq;
            if (this.obu > j3 || fVar.ocf > this.obv) {
                lVar = this.obm.T(j3, j4);
                if (lVar != null) {
                    this.obq = lVar;
                }
                this.obu = j3;
                this.obv = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.obu;
                j = this.obv;
                j2 = j5;
            }
            l lVar2 = this.obA;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.oaQ.oeH = true;
                this.obo.a(bVar, lVar2, 0L, this.oaQ);
            }
            this.oaQ.oeH = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.obo.a(this.oaP, lVar, this.obs, bVar2);
                a(bVar2);
                if (bVar2.oeT) {
                    if (this.oby != null && this.oby.isTimeOut()) {
                        this.oby = null;
                        if (this.obn != null) {
                            this.obn.dVd();
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
            bVar2.oeT = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dVh() {
        this.obv = 0L;
        this.obu = 0L;
        this.obx = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dVi() {
        this.obr = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l dWz = this.oaQ.dWz();
        this.obA = dWz;
        dWz.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dVv()) {
                    return 2;
                }
                dVar.gH(j3 + dVar.obJ);
                dVar.oce = true;
                return 0;
            }
        });
        this.obs = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.obn != null) {
            this.obn.dVe();
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
                    this.oaF.odR.Ti("1017_Filter");
                } else {
                    this.oaF.odR.Tj("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dVi();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.obo != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.obo;
                if (this.oaF.dWg() || this.oaF.dWf()) {
                    z2 = true;
                }
                aVar.yd(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.obo != null) {
                this.obo.ye(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dVj() {
        this.obx = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.oaK.gI(master.flame.danmaku.danmaku.c.c.dWB());
        bVar.oeI = 0;
        bVar.oeJ = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.oeT = bVar.oeQ == 0;
        if (bVar.oeT) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.oeK;
        bVar.oeK = null;
        bVar.endTime = dVar != null ? dVar.dVE() : -1L;
        bVar.oeS = bVar.oaK.gI(master.flame.danmaku.danmaku.c.c.dWB());
    }
}
