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
    protected l pLV;
    h.a pLW;
    final master.flame.danmaku.danmaku.b.a pLX;
    master.flame.danmaku.danmaku.model.f pLY;
    protected final DanmakuContext pLp;
    protected master.flame.danmaku.danmaku.a.a pLv;
    protected final master.flame.danmaku.danmaku.model.b pLz;
    protected boolean pMa;
    protected boolean pMc;
    private long pMd;
    private long pMe;
    protected int pMf;
    private boolean pMg;
    private master.flame.danmaku.danmaku.model.d pMh;
    private l pMj;
    private l pLZ = new master.flame.danmaku.danmaku.model.android.d(4);
    private long pMb = 0;
    private final a.b pLA = new a.b();
    private master.flame.danmaku.danmaku.model.android.d pMi = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a pMk = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.pLp = danmakuContext;
        this.pLz = danmakuContext.ezX();
        this.pLW = aVar;
        this.pLX = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.pLX.a(new a.InterfaceC1064a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC1064a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.pLW != null) {
                    e.this.pLW.i(dVar);
                }
            }
        });
        this.pLX.AU(this.pLp.eAb() || this.pLp.eAa());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.pLp.ezY());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.pLp.pOy.Zp("1017_Filter");
            } else {
                this.pLp.pOy.Zq("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pLY = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.pLV != null) {
            if (dVar.kUV) {
                this.pMi.k(dVar);
                Re(10);
            }
            dVar.index = this.pLV.size();
            boolean z = true;
            if (this.pMd <= dVar.ezz() && dVar.ezz() <= this.pMe) {
                synchronized (this.pLZ) {
                    z = this.pLZ.k(dVar);
                }
            } else if (dVar.kUV) {
                z = false;
            }
            synchronized (this.pLV) {
                k = this.pLV.k(dVar);
            }
            if (!z || !k) {
                this.pMe = 0L;
                this.pMd = 0L;
            }
            if (k && this.pLW != null) {
                this.pLW.h(dVar);
            }
            if (this.pMh == null || (dVar != null && this.pMh != null && dVar.ezz() > this.pMh.ezz())) {
                this.pMh = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void AK(boolean z) {
        if (this.pLV != null && !this.pLV.isEmpty()) {
            synchronized (this.pLV) {
                if (!z) {
                    l Q = this.pLV.Q((this.pLY.pMO - this.pLp.pOz.pOE) - 100, this.pLY.pMO + this.pLp.pOz.pOE);
                    if (Q != null) {
                        this.pLZ = Q;
                    }
                }
                this.pLV.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Re(final int i) {
        if (this.pLV != null && !this.pLV.isEmpty() && !this.pMi.isEmpty()) {
            this.pMi.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eAw();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean ezp = dVar.ezp();
                    if (master.flame.danmaku.danmaku.c.c.eAw() - this.startTime <= i && ezp) {
                        e.this.pLV.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hO(long j) {
        l Q = this.pLV.Q((j - this.pLp.pOz.pOE) - 100, this.pLp.pOz.pOE + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (Q != null && !Q.isEmpty()) {
            Q.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.ezq()) {
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
        return a(bVar, this.pLY);
    }

    public void reset() {
        if (this.pLZ != null) {
            this.pLZ = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.pLX != null) {
            this.pLX.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d ezI;
        reset();
        this.pLp.pOx.ezB();
        this.pLp.pOx.ezE();
        this.pLp.pOx.ezF();
        this.pLp.pOx.ezG();
        this.pMj = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.pMb = j;
        this.pLA.reset();
        this.pLA.endTime = this.pMb;
        this.pMe = 0L;
        this.pMd = 0L;
        if (this.pLV != null && (ezI = this.pLV.ezI()) != null && !ezI.ezp()) {
            this.pMh = ezI;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hP(long j) {
        reset();
        this.pLp.pOx.ezB();
        this.pLp.pOx.ezE();
        this.pMb = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.pLp.a(this.pMk);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.pLp.eAc();
        if (this.pLX != null) {
            this.pLX.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pLv == null) {
            throw new AssertionError();
        }
        b(this.pLv);
        this.pMe = 0L;
        this.pMd = 0L;
        if (this.pLW != null) {
            this.pLW.eyW();
            this.pMc = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Rd(int i) {
        this.pMf = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.pLV = aVar.c(this.pLp).c(this.pLz).d(this.pLY).a(new a.InterfaceC1063a() { // from class: master.flame.danmaku.a.e.5
        }).eAq();
        this.pLp.pOx.resetAll();
        if (this.pLV != null) {
            this.pMh = this.pLV.ezI();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pLv = aVar;
        this.pMc = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.pMa) {
            this.pLX.eAt();
            this.pMa = false;
        }
        if (this.pLV != null) {
            d.e((Canvas) bVar.ud());
            if (this.pMg) {
                return this.pLA;
            }
            a.b bVar2 = this.pLA;
            long j3 = (fVar.pMO - this.pLp.pOz.pOE) - 100;
            long j4 = this.pLp.pOz.pOE + fVar.pMO;
            l lVar = this.pLZ;
            if (this.pMd > j3 || fVar.pMO > this.pMe) {
                lVar = this.pLV.R(j3, j4);
                if (lVar != null) {
                    this.pLZ = lVar;
                }
                this.pMd = j3;
                this.pMe = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.pMd;
                j = this.pMe;
                j2 = j5;
            }
            l lVar2 = this.pMj;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.pLA.pPn = true;
                this.pLX.a(bVar, lVar2, 0L, this.pLA);
            }
            this.pLA.pPn = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.pLX.a(this.pLz, lVar, this.pMb, bVar2);
                a(bVar2);
                if (bVar2.pPz) {
                    if (this.pMh != null && this.pMh.ezp()) {
                        this.pMh = null;
                        if (this.pLW != null) {
                            this.pLW.eyX();
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
            bVar2.pPz = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void ezb() {
        this.pMe = 0L;
        this.pMd = 0L;
        this.pMg = false;
    }

    @Override // master.flame.danmaku.a.h
    public void ezc() {
        this.pMa = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eAu = this.pLA.eAu();
        this.pMj = eAu;
        eAu.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.ezq()) {
                    return 2;
                }
                dVar.hS(j3 + dVar.pMs);
                dVar.pMN = true;
                return 0;
            }
        });
        this.pMb = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.pLW != null) {
            this.pLW.eyY();
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
                    this.pLp.pOy.Zp("1017_Filter");
                } else {
                    this.pLp.pOy.Zq("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            ezc();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.pLX != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.pLX;
                if (this.pLp.eAb() || this.pLp.eAa()) {
                    z2 = true;
                }
                aVar.AU(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.pLX != null) {
                this.pLX.AV(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void ezd() {
        this.pMg = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.pLu.hT(master.flame.danmaku.danmaku.c.c.eAw());
        bVar.pPo = 0;
        bVar.pPp = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.pPz = bVar.pPw == 0;
        if (bVar.pPz) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.pPq;
        bVar.pPq = null;
        bVar.endTime = dVar != null ? dVar.ezz() : -1L;
        bVar.pPy = bVar.pLu.hT(master.flame.danmaku.danmaku.c.c.eAw());
    }
}
