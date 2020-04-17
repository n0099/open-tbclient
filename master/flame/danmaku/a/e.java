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
    protected final DanmakuContext mZR;
    protected master.flame.danmaku.danmaku.a.a mZX;
    master.flame.danmaku.danmaku.model.f naA;
    protected boolean naC;
    protected boolean naE;
    private long naF;
    private long naG;
    protected int naH;
    private boolean naI;
    private master.flame.danmaku.danmaku.model.d naJ;
    private l naL;
    protected final master.flame.danmaku.danmaku.model.b nab;
    protected l nax;
    h.a nay;
    final master.flame.danmaku.danmaku.b.a naz;
    private l naB = new master.flame.danmaku.danmaku.model.android.d(4);
    private long naD = 0;
    private final a.b nac = new a.b();
    private master.flame.danmaku.danmaku.model.android.d naK = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a naM = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.mZR = danmakuContext;
        this.nab = danmakuContext.dFR();
        this.nay = aVar;
        this.naz = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.naz.a(new a.InterfaceC0800a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0800a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nay != null) {
                    e.this.nay.i(dVar);
                }
            }
        });
        this.naz.wD(this.mZR.dFV() || this.mZR.dFU());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.mZR.dFS());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.mZR.ndd.PA("1017_Filter");
            } else {
                this.mZR.ndd.PB("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.naA = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nax != null) {
            if (dVar.nbi) {
                this.naK.k(dVar);
                Jl(10);
            }
            dVar.index = this.nax.size();
            boolean z = true;
            if (this.naF <= dVar.dFt() && dVar.dFt() <= this.naG) {
                synchronized (this.naB) {
                    z = this.naB.k(dVar);
                }
            } else if (dVar.nbi) {
                z = false;
            }
            synchronized (this.nax) {
                k = this.nax.k(dVar);
            }
            if (!z || !k) {
                this.naG = 0L;
                this.naF = 0L;
            }
            if (k && this.nay != null) {
                this.nay.h(dVar);
            }
            if (this.naJ == null || (dVar != null && this.naJ != null && dVar.dFt() > this.naJ.dFt())) {
                this.naJ = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wt(boolean z) {
        if (this.nax != null && !this.nax.isEmpty()) {
            synchronized (this.nax) {
                if (!z) {
                    l O = this.nax.O((this.naA.nbs - this.mZR.nde.ndj) - 100, this.naA.nbs + this.mZR.nde.ndj);
                    if (O != null) {
                        this.naB = O;
                    }
                }
                this.nax.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Jl(final int i) {
        if (this.nax != null && !this.nax.isEmpty() && !this.naK.isEmpty()) {
            this.naK.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dGq();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dGq() - this.startTime <= i && isTimeOut) {
                        e.this.nax.l(dVar);
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
        l O = this.nax.O((j - this.mZR.nde.ndj) - 100, this.mZR.nde.ndj + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (O != null && !O.isEmpty()) {
            O.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dFk()) {
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
        return a(bVar, this.naA);
    }

    public void reset() {
        if (this.naB != null) {
            this.naB = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.naz != null) {
            this.naz.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dFC;
        reset();
        this.mZR.ndc.dFv();
        this.mZR.ndc.dFy();
        this.mZR.ndc.dFz();
        this.mZR.ndc.dFA();
        this.naL = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.naD = j;
        this.nac.reset();
        this.nac.endTime = this.naD;
        this.naG = 0L;
        this.naF = 0L;
        if (this.nax != null && (dFC = this.nax.dFC()) != null && !dFC.isTimeOut()) {
            this.naJ = dFC;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gl(long j) {
        reset();
        this.mZR.ndc.dFv();
        this.mZR.ndc.dFy();
        this.naD = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.mZR.a(this.naM);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.mZR.dFW();
        if (this.naz != null) {
            this.naz.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.mZX == null) {
            throw new AssertionError();
        }
        b(this.mZX);
        this.naG = 0L;
        this.naF = 0L;
        if (this.nay != null) {
            this.nay.dER();
            this.naE = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Jk(int i) {
        this.naH = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nax = aVar.c(this.mZR).c(this.nab).d(this.naA).a(new a.InterfaceC0799a() { // from class: master.flame.danmaku.a.e.5
        }).dGk();
        this.mZR.ndc.resetAll();
        if (this.nax != null) {
            this.naJ = this.nax.dFC();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.mZX = aVar;
        this.naE = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.naC) {
            this.naz.dGn();
            this.naC = false;
        }
        if (this.nax != null) {
            d.e((Canvas) bVar.rJ());
            if (this.naI) {
                return this.nac;
            }
            a.b bVar2 = this.nac;
            long j3 = (fVar.nbs - this.mZR.nde.ndj) - 100;
            long j4 = this.mZR.nde.ndj + fVar.nbs;
            l lVar = this.naB;
            if (this.naF > j3 || fVar.nbs > this.naG) {
                lVar = this.nax.P(j3, j4);
                if (lVar != null) {
                    this.naB = lVar;
                }
                this.naF = j3;
                this.naG = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.naF;
                j = this.naG;
                j2 = j5;
            }
            l lVar2 = this.naL;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nac.ndU = true;
                this.naz.a(bVar, lVar2, 0L, this.nac);
            }
            this.nac.ndU = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.naz.a(this.nab, lVar, this.naD, bVar2);
                a(bVar2);
                if (bVar2.neg) {
                    if (this.naJ != null && this.naJ.isTimeOut()) {
                        this.naJ = null;
                        if (this.nay != null) {
                            this.nay.dES();
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
            bVar2.neg = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dEW() {
        this.naG = 0L;
        this.naF = 0L;
        this.naI = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dEX() {
        this.naC = true;
    }

    @Override // master.flame.danmaku.a.h
    public void h(long j, long j2, final long j3) {
        l dGo = this.nac.dGo();
        this.naL = dGo;
        dGo.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dFk()) {
                    return 2;
                }
                dVar.go(j3 + dVar.naU);
                dVar.nbr = true;
                return 0;
            }
        });
        this.naD = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nay != null) {
            this.nay.dET();
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
                    this.mZR.ndd.PA("1017_Filter");
                } else {
                    this.mZR.ndd.PB("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dEX();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.naz != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.naz;
                if (this.mZR.dFV() || this.mZR.dFU()) {
                    z2 = true;
                }
                aVar.wD(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.naz != null) {
                this.naz.wE(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dEY() {
        this.naI = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.mZW.gp(master.flame.danmaku.danmaku.c.c.dGq());
        bVar.ndV = 0;
        bVar.ndW = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.neg = bVar.ned == 0;
        if (bVar.neg) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.ndX;
        bVar.ndX = null;
        bVar.endTime = dVar != null ? dVar.dFt() : -1L;
        bVar.nef = bVar.mZW.gp(master.flame.danmaku.danmaku.c.c.dGq());
    }
}
