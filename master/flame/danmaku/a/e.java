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
    protected final DanmakuContext nuX;
    protected l nvD;
    h.a nvE;
    final master.flame.danmaku.danmaku.b.a nvF;
    master.flame.danmaku.danmaku.model.f nvG;
    protected boolean nvI;
    protected boolean nvK;
    private long nvL;
    private long nvM;
    protected int nvN;
    private boolean nvO;
    private master.flame.danmaku.danmaku.model.d nvP;
    private l nvR;
    protected master.flame.danmaku.danmaku.a.a nvd;
    protected final master.flame.danmaku.danmaku.model.b nvh;
    private l nvH = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nvJ = 0;
    private final a.b nvi = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nvQ = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nvS = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nuX = danmakuContext;
        this.nvh = danmakuContext.dNI();
        this.nvE = aVar;
        this.nvF = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nvF.a(new a.InterfaceC0883a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0883a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nvE != null) {
                    e.this.nvE.i(dVar);
                }
            }
        });
        this.nvF.xb(this.nuX.dNM() || this.nuX.dNL());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nuX.dNJ());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nuX.nyj.RJ("1017_Filter");
            } else {
                this.nuX.nyj.RK("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nvG = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nvD != null) {
            if (dVar.nwo) {
                this.nvQ.k(dVar);
                JW(10);
            }
            dVar.index = this.nvD.size();
            boolean z = true;
            if (this.nvL <= dVar.dNk() && dVar.dNk() <= this.nvM) {
                synchronized (this.nvH) {
                    z = this.nvH.k(dVar);
                }
            } else if (dVar.nwo) {
                z = false;
            }
            synchronized (this.nvD) {
                k = this.nvD.k(dVar);
            }
            if (!z || !k) {
                this.nvM = 0L;
                this.nvL = 0L;
            }
            if (k && this.nvE != null) {
                this.nvE.h(dVar);
            }
            if (this.nvP == null || (dVar != null && this.nvP != null && dVar.dNk() > this.nvP.dNk())) {
                this.nvP = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wR(boolean z) {
        if (this.nvD != null && !this.nvD.isEmpty()) {
            synchronized (this.nvD) {
                if (!z) {
                    l P = this.nvD.P((this.nvG.nwy - this.nuX.nyk.nyp) - 100, this.nvG.nwy + this.nuX.nyk.nyp);
                    if (P != null) {
                        this.nvH = P;
                    }
                }
                this.nvD.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void JW(final int i) {
        if (this.nvD != null && !this.nvD.isEmpty() && !this.nvQ.isEmpty()) {
            this.nvQ.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dOh();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dOh() - this.startTime <= i && isTimeOut) {
                        e.this.nvD.l(dVar);
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
        l P = this.nvD.P((j - this.nuX.nyk.nyp) - 100, this.nuX.nyk.nyp + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (P != null && !P.isEmpty()) {
            P.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dNb()) {
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
        return a(bVar, this.nvG);
    }

    public void reset() {
        if (this.nvH != null) {
            this.nvH = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nvF != null) {
            this.nvF.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dNt;
        reset();
        this.nuX.nyi.dNm();
        this.nuX.nyi.dNp();
        this.nuX.nyi.dNq();
        this.nuX.nyi.dNr();
        this.nvR = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nvJ = j;
        this.nvi.reset();
        this.nvi.endTime = this.nvJ;
        this.nvM = 0L;
        this.nvL = 0L;
        if (this.nvD != null && (dNt = this.nvD.dNt()) != null && !dNt.isTimeOut()) {
            this.nvP = dNt;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gm(long j) {
        reset();
        this.nuX.nyi.dNm();
        this.nuX.nyi.dNp();
        this.nvJ = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nuX.a(this.nvS);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nuX.dNN();
        if (this.nvF != null) {
            this.nvF.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nvd == null) {
            throw new AssertionError();
        }
        b(this.nvd);
        this.nvM = 0L;
        this.nvL = 0L;
        if (this.nvE != null) {
            this.nvE.dMI();
            this.nvK = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void JV(int i) {
        this.nvN = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nvD = aVar.c(this.nuX).c(this.nvh).d(this.nvG).a(new a.InterfaceC0882a() { // from class: master.flame.danmaku.a.e.5
        }).dOb();
        this.nuX.nyi.resetAll();
        if (this.nvD != null) {
            this.nvP = this.nvD.dNt();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nvd = aVar;
        this.nvK = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nvI) {
            this.nvF.dOe();
            this.nvI = false;
        }
        if (this.nvD != null) {
            d.e((Canvas) bVar.rS());
            if (this.nvO) {
                return this.nvi;
            }
            a.b bVar2 = this.nvi;
            long j3 = (fVar.nwy - this.nuX.nyk.nyp) - 100;
            long j4 = this.nuX.nyk.nyp + fVar.nwy;
            l lVar = this.nvH;
            if (this.nvL > j3 || fVar.nwy > this.nvM) {
                lVar = this.nvD.Q(j3, j4);
                if (lVar != null) {
                    this.nvH = lVar;
                }
                this.nvL = j3;
                this.nvM = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nvL;
                j = this.nvM;
                j2 = j5;
            }
            l lVar2 = this.nvR;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nvi.nyZ = true;
                this.nvF.a(bVar, lVar2, 0L, this.nvi);
            }
            this.nvi.nyZ = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nvF.a(this.nvh, lVar, this.nvJ, bVar2);
                a(bVar2);
                if (bVar2.nzl) {
                    if (this.nvP != null && this.nvP.isTimeOut()) {
                        this.nvP = null;
                        if (this.nvE != null) {
                            this.nvE.dMJ();
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
            bVar2.nzl = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dMN() {
        this.nvM = 0L;
        this.nvL = 0L;
        this.nvO = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dMO() {
        this.nvI = true;
    }

    @Override // master.flame.danmaku.a.h
    public void h(long j, long j2, final long j3) {
        l dOf = this.nvi.dOf();
        this.nvR = dOf;
        dOf.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dNb()) {
                    return 2;
                }
                dVar.gp(j3 + dVar.nwa);
                dVar.nwx = true;
                return 0;
            }
        });
        this.nvJ = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nvE != null) {
            this.nvE.dMK();
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
                    this.nuX.nyj.RJ("1017_Filter");
                } else {
                    this.nuX.nyj.RK("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dMO();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nvF != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nvF;
                if (this.nuX.dNM() || this.nuX.dNL()) {
                    z2 = true;
                }
                aVar.xb(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nvF != null) {
                this.nvF.xc(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dMP() {
        this.nvO = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nvc.gq(master.flame.danmaku.danmaku.c.c.dOh());
        bVar.nza = 0;
        bVar.nzb = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nzl = bVar.nzi == 0;
        if (bVar.nzl) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nzc;
        bVar.nzc = null;
        bVar.endTime = dVar != null ? dVar.dNk() : -1L;
        bVar.nzk = bVar.nvc.gq(master.flame.danmaku.danmaku.c.c.dOh());
    }
}
