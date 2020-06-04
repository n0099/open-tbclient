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
    protected l nwN;
    h.a nwO;
    final master.flame.danmaku.danmaku.b.a nwP;
    master.flame.danmaku.danmaku.model.f nwQ;
    protected boolean nwS;
    protected boolean nwU;
    private long nwV;
    private long nwW;
    protected int nwX;
    private boolean nwY;
    private master.flame.danmaku.danmaku.model.d nwZ;
    protected final DanmakuContext nwh;
    protected master.flame.danmaku.danmaku.a.a nwn;
    protected final master.flame.danmaku.danmaku.model.b nwr;
    private l nxb;
    private l nwR = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nwT = 0;
    private final a.b nws = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nxa = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nxc = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nwh = danmakuContext;
        this.nwr = danmakuContext.dNW();
        this.nwO = aVar;
        this.nwP = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nwP.a(new a.InterfaceC0884a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0884a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nwO != null) {
                    e.this.nwO.i(dVar);
                }
            }
        });
        this.nwP.xd(this.nwh.dOa() || this.nwh.dNZ());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nwh.dNX());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nwh.nzt.RK("1017_Filter");
            } else {
                this.nwh.nzt.RL("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nwQ = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nwN != null) {
            if (dVar.nxy) {
                this.nxa.k(dVar);
                JY(10);
            }
            dVar.index = this.nwN.size();
            boolean z = true;
            if (this.nwV <= dVar.dNy() && dVar.dNy() <= this.nwW) {
                synchronized (this.nwR) {
                    z = this.nwR.k(dVar);
                }
            } else if (dVar.nxy) {
                z = false;
            }
            synchronized (this.nwN) {
                k = this.nwN.k(dVar);
            }
            if (!z || !k) {
                this.nwW = 0L;
                this.nwV = 0L;
            }
            if (k && this.nwO != null) {
                this.nwO.h(dVar);
            }
            if (this.nwZ == null || (dVar != null && this.nwZ != null && dVar.dNy() > this.nwZ.dNy())) {
                this.nwZ = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wT(boolean z) {
        if (this.nwN != null && !this.nwN.isEmpty()) {
            synchronized (this.nwN) {
                if (!z) {
                    l P = this.nwN.P((this.nwQ.nxI - this.nwh.nzu.nzz) - 100, this.nwQ.nxI + this.nwh.nzu.nzz);
                    if (P != null) {
                        this.nwR = P;
                    }
                }
                this.nwN.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void JY(final int i) {
        if (this.nwN != null && !this.nwN.isEmpty() && !this.nxa.isEmpty()) {
            this.nxa.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dOv();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dOv() - this.startTime <= i && isTimeOut) {
                        e.this.nwN.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gl(long j) {
        l P = this.nwN.P((j - this.nwh.nzu.nzz) - 100, this.nwh.nzu.nzz + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (P != null && !P.isEmpty()) {
            P.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dNp()) {
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
        return a(bVar, this.nwQ);
    }

    public void reset() {
        if (this.nwR != null) {
            this.nwR = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nwP != null) {
            this.nwP.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dNH;
        reset();
        this.nwh.nzs.dNA();
        this.nwh.nzs.dND();
        this.nwh.nzs.dNE();
        this.nwh.nzs.dNF();
        this.nxb = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nwT = j;
        this.nws.reset();
        this.nws.endTime = this.nwT;
        this.nwW = 0L;
        this.nwV = 0L;
        if (this.nwN != null && (dNH = this.nwN.dNH()) != null && !dNH.isTimeOut()) {
            this.nwZ = dNH;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gm(long j) {
        reset();
        this.nwh.nzs.dNA();
        this.nwh.nzs.dND();
        this.nwT = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nwh.a(this.nxc);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nwh.dOb();
        if (this.nwP != null) {
            this.nwP.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nwn == null) {
            throw new AssertionError();
        }
        b(this.nwn);
        this.nwW = 0L;
        this.nwV = 0L;
        if (this.nwO != null) {
            this.nwO.dMW();
            this.nwU = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void JX(int i) {
        this.nwX = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nwN = aVar.c(this.nwh).c(this.nwr).d(this.nwQ).a(new a.InterfaceC0883a() { // from class: master.flame.danmaku.a.e.5
        }).dOp();
        this.nwh.nzs.resetAll();
        if (this.nwN != null) {
            this.nwZ = this.nwN.dNH();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nwn = aVar;
        this.nwU = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nwS) {
            this.nwP.dOs();
            this.nwS = false;
        }
        if (this.nwN != null) {
            d.e((Canvas) bVar.rS());
            if (this.nwY) {
                return this.nws;
            }
            a.b bVar2 = this.nws;
            long j3 = (fVar.nxI - this.nwh.nzu.nzz) - 100;
            long j4 = this.nwh.nzu.nzz + fVar.nxI;
            l lVar = this.nwR;
            if (this.nwV > j3 || fVar.nxI > this.nwW) {
                lVar = this.nwN.Q(j3, j4);
                if (lVar != null) {
                    this.nwR = lVar;
                }
                this.nwV = j3;
                this.nwW = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nwV;
                j = this.nwW;
                j2 = j5;
            }
            l lVar2 = this.nxb;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nws.nAj = true;
                this.nwP.a(bVar, lVar2, 0L, this.nws);
            }
            this.nws.nAj = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nwP.a(this.nwr, lVar, this.nwT, bVar2);
                a(bVar2);
                if (bVar2.nAv) {
                    if (this.nwZ != null && this.nwZ.isTimeOut()) {
                        this.nwZ = null;
                        if (this.nwO != null) {
                            this.nwO.dMX();
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
            bVar2.nAv = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dNb() {
        this.nwW = 0L;
        this.nwV = 0L;
        this.nwY = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dNc() {
        this.nwS = true;
    }

    @Override // master.flame.danmaku.a.h
    public void h(long j, long j2, final long j3) {
        l dOt = this.nws.dOt();
        this.nxb = dOt;
        dOt.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dNp()) {
                    return 2;
                }
                dVar.gp(j3 + dVar.nxk);
                dVar.nxH = true;
                return 0;
            }
        });
        this.nwT = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nwO != null) {
            this.nwO.dMY();
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
                    this.nwh.nzt.RK("1017_Filter");
                } else {
                    this.nwh.nzt.RL("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dNc();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nwP != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nwP;
                if (this.nwh.dOa() || this.nwh.dNZ()) {
                    z2 = true;
                }
                aVar.xd(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nwP != null) {
                this.nwP.xe(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dNd() {
        this.nwY = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nwm.gq(master.flame.danmaku.danmaku.c.c.dOv());
        bVar.nAk = 0;
        bVar.nAl = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nAv = bVar.nAs == 0;
        if (bVar.nAv) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nAm;
        bVar.nAm = null;
        bVar.endTime = dVar != null ? dVar.dNy() : -1L;
        bVar.nAu = bVar.nwm.gq(master.flame.danmaku.danmaku.c.c.dOv());
    }
}
