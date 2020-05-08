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
    protected final DanmakuContext mZU;
    protected l naA;
    h.a naB;
    final master.flame.danmaku.danmaku.b.a naC;
    master.flame.danmaku.danmaku.model.f naD;
    protected boolean naF;
    protected boolean naH;
    private long naI;
    private long naJ;
    protected int naK;
    private boolean naL;
    private master.flame.danmaku.danmaku.model.d naM;
    private l naO;
    protected master.flame.danmaku.danmaku.a.a naa;
    protected final master.flame.danmaku.danmaku.model.b nae;
    private l naE = new master.flame.danmaku.danmaku.model.android.d(4);
    private long naG = 0;
    private final a.b naf = new a.b();
    private master.flame.danmaku.danmaku.model.android.d naN = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a naP = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.mZU = danmakuContext;
        this.nae = danmakuContext.dFN();
        this.naB = aVar;
        this.naC = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.naC.a(new a.InterfaceC0821a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0821a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.naB != null) {
                    e.this.naB.i(dVar);
                }
            }
        });
        this.naC.wD(this.mZU.dFR() || this.mZU.dFQ());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.mZU.dFO());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.mZU.ndg.PD("1017_Filter");
            } else {
                this.mZU.ndg.PE("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.naD = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.naA != null) {
            if (dVar.nbl) {
                this.naN.k(dVar);
                Jl(10);
            }
            dVar.index = this.naA.size();
            boolean z = true;
            if (this.naI <= dVar.dFp() && dVar.dFp() <= this.naJ) {
                synchronized (this.naE) {
                    z = this.naE.k(dVar);
                }
            } else if (dVar.nbl) {
                z = false;
            }
            synchronized (this.naA) {
                k = this.naA.k(dVar);
            }
            if (!z || !k) {
                this.naJ = 0L;
                this.naI = 0L;
            }
            if (k && this.naB != null) {
                this.naB.h(dVar);
            }
            if (this.naM == null || (dVar != null && this.naM != null && dVar.dFp() > this.naM.dFp())) {
                this.naM = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wt(boolean z) {
        if (this.naA != null && !this.naA.isEmpty()) {
            synchronized (this.naA) {
                if (!z) {
                    l O = this.naA.O((this.naD.nbv - this.mZU.ndh.ndm) - 100, this.naD.nbv + this.mZU.ndh.ndm);
                    if (O != null) {
                        this.naE = O;
                    }
                }
                this.naA.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Jl(final int i) {
        if (this.naA != null && !this.naA.isEmpty() && !this.naN.isEmpty()) {
            this.naN.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dGm();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dGm() - this.startTime <= i && isTimeOut) {
                        e.this.naA.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gk(long j) {
        l O = this.naA.O((j - this.mZU.ndh.ndm) - 100, this.mZU.ndh.ndm + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (O != null && !O.isEmpty()) {
            O.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bF(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dFg()) {
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
        return a(bVar, this.naD);
    }

    public void reset() {
        if (this.naE != null) {
            this.naE = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.naC != null) {
            this.naC.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dFy;
        reset();
        this.mZU.ndf.dFr();
        this.mZU.ndf.dFu();
        this.mZU.ndf.dFv();
        this.mZU.ndf.dFw();
        this.naO = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.naG = j;
        this.naf.reset();
        this.naf.endTime = this.naG;
        this.naJ = 0L;
        this.naI = 0L;
        if (this.naA != null && (dFy = this.naA.dFy()) != null && !dFy.isTimeOut()) {
            this.naM = dFy;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gl(long j) {
        reset();
        this.mZU.ndf.dFr();
        this.mZU.ndf.dFu();
        this.naG = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.mZU.a(this.naP);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.mZU.dFS();
        if (this.naC != null) {
            this.naC.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.naa == null) {
            throw new AssertionError();
        }
        b(this.naa);
        this.naJ = 0L;
        this.naI = 0L;
        if (this.naB != null) {
            this.naB.dEN();
            this.naH = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Jk(int i) {
        this.naK = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.naA = aVar.c(this.mZU).c(this.nae).d(this.naD).a(new a.InterfaceC0820a() { // from class: master.flame.danmaku.a.e.5
        }).dGg();
        this.mZU.ndf.resetAll();
        if (this.naA != null) {
            this.naM = this.naA.dFy();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.naa = aVar;
        this.naH = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.naF) {
            this.naC.dGj();
            this.naF = false;
        }
        if (this.naA != null) {
            d.e((Canvas) bVar.rJ());
            if (this.naL) {
                return this.naf;
            }
            a.b bVar2 = this.naf;
            long j3 = (fVar.nbv - this.mZU.ndh.ndm) - 100;
            long j4 = this.mZU.ndh.ndm + fVar.nbv;
            l lVar = this.naE;
            if (this.naI > j3 || fVar.nbv > this.naJ) {
                lVar = this.naA.P(j3, j4);
                if (lVar != null) {
                    this.naE = lVar;
                }
                this.naI = j3;
                this.naJ = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.naI;
                j = this.naJ;
                j2 = j5;
            }
            l lVar2 = this.naO;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.naf.ndX = true;
                this.naC.a(bVar, lVar2, 0L, this.naf);
            }
            this.naf.ndX = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.naC.a(this.nae, lVar, this.naG, bVar2);
                a(bVar2);
                if (bVar2.nej) {
                    if (this.naM != null && this.naM.isTimeOut()) {
                        this.naM = null;
                        if (this.naB != null) {
                            this.naB.dEO();
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
            bVar2.nej = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dES() {
        this.naJ = 0L;
        this.naI = 0L;
        this.naL = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dET() {
        this.naF = true;
    }

    @Override // master.flame.danmaku.a.h
    public void h(long j, long j2, final long j3) {
        l dGk = this.naf.dGk();
        this.naO = dGk;
        dGk.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dFg()) {
                    return 2;
                }
                dVar.go(j3 + dVar.naX);
                dVar.nbu = true;
                return 0;
            }
        });
        this.naG = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.naB != null) {
            this.naB.dEP();
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
                    this.mZU.ndg.PD("1017_Filter");
                } else {
                    this.mZU.ndg.PE("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dET();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.naC != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.naC;
                if (this.mZU.dFR() || this.mZU.dFQ()) {
                    z2 = true;
                }
                aVar.wD(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.naC != null) {
                this.naC.wE(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dEU() {
        this.naL = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.mZZ.gp(master.flame.danmaku.danmaku.c.c.dGm());
        bVar.ndY = 0;
        bVar.ndZ = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nej = bVar.neg == 0;
        if (bVar.nej) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nea;
        bVar.nea = null;
        bVar.endTime = dVar != null ? dVar.dFp() : -1L;
        bVar.nei = bVar.mZZ.gp(master.flame.danmaku.danmaku.c.c.dGm());
    }
}
