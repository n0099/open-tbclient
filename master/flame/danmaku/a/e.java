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
    protected final master.flame.danmaku.danmaku.model.b nEB;
    protected l nEX;
    h.a nEY;
    final master.flame.danmaku.danmaku.b.a nEZ;
    protected final DanmakuContext nEr;
    protected master.flame.danmaku.danmaku.a.a nEx;
    master.flame.danmaku.danmaku.model.f nFa;
    protected boolean nFc;
    protected boolean nFe;
    private long nFf;
    private long nFg;
    protected int nFh;
    private boolean nFi;
    private master.flame.danmaku.danmaku.model.d nFj;
    private l nFl;
    private l nFb = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nFd = 0;
    private final a.b nEC = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nFk = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nFm = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nEr = danmakuContext;
        this.nEB = danmakuContext.dMo();
        this.nEY = aVar;
        this.nEZ = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nEZ.a(new a.InterfaceC0776a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0776a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nEY != null) {
                    e.this.nEY.i(dVar);
                }
            }
        });
        this.nEZ.wQ(this.nEr.dMs() || this.nEr.dMr());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nEr.dMp());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nEr.nHA.Sk("1017_Filter");
            } else {
                this.nEr.nHA.Sl("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFa = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nEX != null) {
            if (dVar.mxI) {
                this.nFk.k(dVar);
                NL(10);
            }
            dVar.index = this.nEX.size();
            boolean z = true;
            if (this.nFf <= dVar.dLQ() && dVar.dLQ() <= this.nFg) {
                synchronized (this.nFb) {
                    z = this.nFb.k(dVar);
                }
            } else if (dVar.mxI) {
                z = false;
            }
            synchronized (this.nEX) {
                k = this.nEX.k(dVar);
            }
            if (!z || !k) {
                this.nFg = 0L;
                this.nFf = 0L;
            }
            if (k && this.nEY != null) {
                this.nEY.h(dVar);
            }
            if (this.nFj == null || (dVar != null && this.nFj != null && dVar.dLQ() > this.nFj.dLQ())) {
                this.nFj = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wG(boolean z) {
        if (this.nEX != null && !this.nEX.isEmpty()) {
            synchronized (this.nEX) {
                if (!z) {
                    l ag = this.nEX.ag((this.nFa.nFR - this.nEr.nHB.nHG) - 100, this.nFa.nFR + this.nEr.nHB.nHG);
                    if (ag != null) {
                        this.nFb = ag;
                    }
                }
                this.nEX.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NL(final int i) {
        if (this.nEX != null && !this.nEX.isEmpty() && !this.nFk.isEmpty()) {
            this.nFk.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dMN();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dMN() - this.startTime <= i && isTimeOut) {
                        e.this.nEX.l(dVar);
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
        l ag = this.nEX.ag((j - this.nEr.nHB.nHG) - 100, this.nEr.nHB.nHG + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dLH()) {
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
        return a(bVar, this.nFa);
    }

    public void reset() {
        if (this.nFb != null) {
            this.nFb = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nEZ != null) {
            this.nEZ.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dLZ;
        reset();
        this.nEr.nHz.dLS();
        this.nEr.nHz.dLV();
        this.nEr.nHz.dLW();
        this.nEr.nHz.dLX();
        this.nFl = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nFd = j;
        this.nEC.reset();
        this.nEC.endTime = this.nFd;
        this.nFg = 0L;
        this.nFf = 0L;
        if (this.nEX != null && (dLZ = this.nEX.dLZ()) != null && !dLZ.isTimeOut()) {
            this.nFj = dLZ;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hj(long j) {
        reset();
        this.nEr.nHz.dLS();
        this.nEr.nHz.dLV();
        this.nFd = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nEr.a(this.nFm);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nEr.dMt();
        if (this.nEZ != null) {
            this.nEZ.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEx == null) {
            throw new AssertionError();
        }
        b(this.nEx);
        this.nFg = 0L;
        this.nFf = 0L;
        if (this.nEY != null) {
            this.nEY.dLo();
            this.nFe = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NK(int i) {
        this.nFh = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEX = aVar.c(this.nEr).c(this.nEB).d(this.nFa).a(new a.InterfaceC0775a() { // from class: master.flame.danmaku.a.e.5
        }).dMH();
        this.nEr.nHz.resetAll();
        if (this.nEX != null) {
            this.nFj = this.nEX.dLZ();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEx = aVar;
        this.nFe = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nFc) {
            this.nEZ.dMK();
            this.nFc = false;
        }
        if (this.nEX != null) {
            d.e((Canvas) bVar.nq());
            if (this.nFi) {
                return this.nEC;
            }
            a.b bVar2 = this.nEC;
            long j3 = (fVar.nFR - this.nEr.nHB.nHG) - 100;
            long j4 = this.nEr.nHB.nHG + fVar.nFR;
            l lVar = this.nFb;
            if (this.nFf > j3 || fVar.nFR > this.nFg) {
                lVar = this.nEX.ah(j3, j4);
                if (lVar != null) {
                    this.nFb = lVar;
                }
                this.nFf = j3;
                this.nFg = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nFf;
                j = this.nFg;
                j2 = j5;
            }
            l lVar2 = this.nFl;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nEC.nIr = true;
                this.nEZ.a(bVar, lVar2, 0L, this.nEC);
            }
            this.nEC.nIr = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nEZ.a(this.nEB, lVar, this.nFd, bVar2);
                a(bVar2);
                if (bVar2.nID) {
                    if (this.nFj != null && this.nFj.isTimeOut()) {
                        this.nFj = null;
                        if (this.nEY != null) {
                            this.nEY.dLp();
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
            bVar2.nID = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dLt() {
        this.nFg = 0L;
        this.nFf = 0L;
        this.nFi = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dLu() {
        this.nFc = true;
    }

    @Override // master.flame.danmaku.a.h
    public void m(long j, long j2, final long j3) {
        l dML = this.nEC.dML();
        this.nFl = dML;
        dML.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dLH()) {
                    return 2;
                }
                dVar.hm(j3 + dVar.nFu);
                dVar.nFQ = true;
                return 0;
            }
        });
        this.nFd = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nEY != null) {
            this.nEY.dLq();
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
                    this.nEr.nHA.Sk("1017_Filter");
                } else {
                    this.nEr.nHA.Sl("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dLu();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nEZ != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nEZ;
                if (this.nEr.dMs() || this.nEr.dMr()) {
                    z2 = true;
                }
                aVar.wQ(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nEZ != null) {
                this.nEZ.wR(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dLv() {
        this.nFi = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nEw.hn(master.flame.danmaku.danmaku.c.c.dMN());
        bVar.nIs = 0;
        bVar.nIt = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nID = bVar.nIA == 0;
        if (bVar.nID) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nIu;
        bVar.nIu = null;
        bVar.endTime = dVar != null ? dVar.dLQ() : -1L;
        bVar.nIC = bVar.nEw.hn(master.flame.danmaku.danmaku.c.c.dMN());
    }
}
