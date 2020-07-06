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
    protected final DanmakuContext nRW;
    protected l nSC;
    h.a nSD;
    final master.flame.danmaku.danmaku.b.a nSE;
    master.flame.danmaku.danmaku.model.f nSF;
    protected boolean nSH;
    protected boolean nSJ;
    private long nSK;
    private long nSL;
    protected int nSM;
    private boolean nSN;
    private master.flame.danmaku.danmaku.model.d nSO;
    private l nSQ;
    protected master.flame.danmaku.danmaku.a.a nSc;
    protected final master.flame.danmaku.danmaku.model.b nSg;
    private l nSG = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nSI = 0;
    private final a.b nSh = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nSP = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nSR = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nRW = danmakuContext;
        this.nSg = danmakuContext.dSG();
        this.nSD = aVar;
        this.nSE = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nSE.a(new a.InterfaceC0904a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0904a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nSD != null) {
                    e.this.nSD.i(dVar);
                }
            }
        });
        this.nSE.xy(this.nRW.dSK() || this.nRW.dSJ());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nRW.dSH());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nRW.nVh.Sx("1017_Filter");
            } else {
                this.nRW.nVh.Sy("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nSF = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nSC != null) {
            if (dVar.jMK) {
                this.nSP.k(dVar);
                Lf(10);
            }
            dVar.index = this.nSC.size();
            boolean z = true;
            if (this.nSK <= dVar.dSi() && dVar.dSi() <= this.nSL) {
                synchronized (this.nSG) {
                    z = this.nSG.k(dVar);
                }
            } else if (dVar.jMK) {
                z = false;
            }
            synchronized (this.nSC) {
                k = this.nSC.k(dVar);
            }
            if (!z || !k) {
                this.nSL = 0L;
                this.nSK = 0L;
            }
            if (k && this.nSD != null) {
                this.nSD.h(dVar);
            }
            if (this.nSO == null || (dVar != null && this.nSO != null && dVar.dSi() > this.nSO.dSi())) {
                this.nSO = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void xo(boolean z) {
        if (this.nSC != null && !this.nSC.isEmpty()) {
            synchronized (this.nSC) {
                if (!z) {
                    l Q = this.nSC.Q((this.nSF.nTw - this.nRW.nVi.nVn) - 100, this.nSF.nTw + this.nRW.nVi.nVn);
                    if (Q != null) {
                        this.nSG = Q;
                    }
                }
                this.nSC.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Lf(final int i) {
        if (this.nSC != null && !this.nSC.isEmpty() && !this.nSP.isEmpty()) {
            this.nSP.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dTf();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dTf() - this.startTime <= i && isTimeOut) {
                        e.this.nSC.l(dVar);
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
        l Q = this.nSC.Q((j - this.nRW.nVi.nVn) - 100, this.nRW.nVi.nVn + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (Q != null && !Q.isEmpty()) {
            Q.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dRZ()) {
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
        return a(bVar, this.nSF);
    }

    public void reset() {
        if (this.nSG != null) {
            this.nSG = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nSE != null) {
            this.nSE.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dSr;
        reset();
        this.nRW.nVg.dSk();
        this.nRW.nVg.dSn();
        this.nRW.nVg.dSo();
        this.nRW.nVg.dSp();
        this.nSQ = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nSI = j;
        this.nSh.reset();
        this.nSh.endTime = this.nSI;
        this.nSL = 0L;
        this.nSK = 0L;
        if (this.nSC != null && (dSr = this.nSC.dSr()) != null && !dSr.isTimeOut()) {
            this.nSO = dSr;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gr(long j) {
        reset();
        this.nRW.nVg.dSk();
        this.nRW.nVg.dSn();
        this.nSI = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nRW.a(this.nSR);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nRW.dSL();
        if (this.nSE != null) {
            this.nSE.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nSc == null) {
            throw new AssertionError();
        }
        b(this.nSc);
        this.nSL = 0L;
        this.nSK = 0L;
        if (this.nSD != null) {
            this.nSD.dRG();
            this.nSJ = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Le(int i) {
        this.nSM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nSC = aVar.c(this.nRW).c(this.nSg).d(this.nSF).a(new a.InterfaceC0903a() { // from class: master.flame.danmaku.a.e.5
        }).dSZ();
        this.nRW.nVg.resetAll();
        if (this.nSC != null) {
            this.nSO = this.nSC.dSr();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nSc = aVar;
        this.nSJ = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nSH) {
            this.nSE.dTc();
            this.nSH = false;
        }
        if (this.nSC != null) {
            d.e((Canvas) bVar.sk());
            if (this.nSN) {
                return this.nSh;
            }
            a.b bVar2 = this.nSh;
            long j3 = (fVar.nTw - this.nRW.nVi.nVn) - 100;
            long j4 = this.nRW.nVi.nVn + fVar.nTw;
            l lVar = this.nSG;
            if (this.nSK > j3 || fVar.nTw > this.nSL) {
                lVar = this.nSC.R(j3, j4);
                if (lVar != null) {
                    this.nSG = lVar;
                }
                this.nSK = j3;
                this.nSL = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nSK;
                j = this.nSL;
                j2 = j5;
            }
            l lVar2 = this.nSQ;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nSh.nVX = true;
                this.nSE.a(bVar, lVar2, 0L, this.nSh);
            }
            this.nSh.nVX = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nSE.a(this.nSg, lVar, this.nSI, bVar2);
                a(bVar2);
                if (bVar2.nWj) {
                    if (this.nSO != null && this.nSO.isTimeOut()) {
                        this.nSO = null;
                        if (this.nSD != null) {
                            this.nSD.dRH();
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
            bVar2.nWj = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dRL() {
        this.nSL = 0L;
        this.nSK = 0L;
        this.nSN = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dRM() {
        this.nSH = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l dTd = this.nSh.dTd();
        this.nSQ = dTd;
        dTd.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dRZ()) {
                    return 2;
                }
                dVar.gu(j3 + dVar.nSZ);
                dVar.nTv = true;
                return 0;
            }
        });
        this.nSI = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nSD != null) {
            this.nSD.dRI();
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
                    this.nRW.nVh.Sx("1017_Filter");
                } else {
                    this.nRW.nVh.Sy("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dRM();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nSE != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nSE;
                if (this.nRW.dSK() || this.nRW.dSJ()) {
                    z2 = true;
                }
                aVar.xy(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nSE != null) {
                this.nSE.xz(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dRN() {
        this.nSN = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nSb.gv(master.flame.danmaku.danmaku.c.c.dTf());
        bVar.nVY = 0;
        bVar.nVZ = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nWj = bVar.nWg == 0;
        if (bVar.nWj) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nWa;
        bVar.nWa = null;
        bVar.endTime = dVar != null ? dVar.dSi() : -1L;
        bVar.nWi = bVar.nSb.gv(master.flame.danmaku.danmaku.c.c.dTf());
    }
}
