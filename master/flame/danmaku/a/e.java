package master.flame.danmaku.a;

import android.graphics.Canvas;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.a.a;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes4.dex */
public class e implements h {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected master.flame.danmaku.danmaku.a.a nDA;
    protected final master.flame.danmaku.danmaku.model.b nDE;
    protected final DanmakuContext nDu;
    protected l nEa;
    h.a nEb;
    final master.flame.danmaku.danmaku.b.a nEc;
    master.flame.danmaku.danmaku.model.f nEd;
    protected boolean nEf;
    protected boolean nEh;
    private long nEi;
    private long nEj;
    protected int nEk;
    private boolean nEl;
    private master.flame.danmaku.danmaku.model.d nEm;
    private l nEo;
    private l nEe = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nEg = 0;
    private final a.b nDF = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nEn = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nEp = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nDu = danmakuContext;
        this.nDE = danmakuContext.dKZ();
        this.nEb = aVar;
        this.nEc = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nEc.a(new a.InterfaceC0768a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0768a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nEb != null) {
                    e.this.nEb.i(dVar);
                }
            }
        });
        this.nEc.wN(this.nDu.dLd() || this.nDu.dLc());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nDu.dLa());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nDu.nGE.RZ("1017_Filter");
            } else {
                this.nDu.nGE.Sa("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nEd = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nEa != null) {
            if (dVar.mwX) {
                this.nEn.k(dVar);
                NI(10);
            }
            dVar.index = this.nEa.size();
            boolean z = true;
            if (this.nEi <= dVar.dKB() && dVar.dKB() <= this.nEj) {
                synchronized (this.nEe) {
                    z = this.nEe.k(dVar);
                }
            } else if (dVar.mwX) {
                z = false;
            }
            synchronized (this.nEa) {
                k = this.nEa.k(dVar);
            }
            if (!z || !k) {
                this.nEj = 0L;
                this.nEi = 0L;
            }
            if (k && this.nEb != null) {
                this.nEb.h(dVar);
            }
            if (this.nEm == null || (dVar != null && this.nEm != null && dVar.dKB() > this.nEm.dKB())) {
                this.nEm = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wD(boolean z) {
        if (this.nEa != null && !this.nEa.isEmpty()) {
            synchronized (this.nEa) {
                if (!z) {
                    l ag = this.nEa.ag((this.nEd.nEU - this.nDu.nGF.nGK) - 100, this.nEd.nEU + this.nDu.nGF.nGK);
                    if (ag != null) {
                        this.nEe = ag;
                    }
                }
                this.nEa.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NI(final int i) {
        if (this.nEa != null && !this.nEa.isEmpty() && !this.nEn.isEmpty()) {
            this.nEn.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dLy();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dLy() - this.startTime <= i && isTimeOut) {
                        e.this.nEa.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hk(long j) {
        l ag = this.nEa.ag((j - this.nDu.nGF.nGK) - 100, this.nDu.nGF.nGK + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dKs()) {
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
        return a(bVar, this.nEd);
    }

    public void reset() {
        if (this.nEe != null) {
            this.nEe = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nEc != null) {
            this.nEc.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dKK;
        reset();
        this.nDu.nGD.dKD();
        this.nDu.nGD.dKG();
        this.nDu.nGD.dKH();
        this.nDu.nGD.dKI();
        this.nEo = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nEg = j;
        this.nDF.reset();
        this.nDF.endTime = this.nEg;
        this.nEj = 0L;
        this.nEi = 0L;
        if (this.nEa != null && (dKK = this.nEa.dKK()) != null && !dKK.isTimeOut()) {
            this.nEm = dKK;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hl(long j) {
        reset();
        this.nDu.nGD.dKD();
        this.nDu.nGD.dKG();
        this.nEg = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nDu.a(this.nEp);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nDu.dLe();
        if (this.nEc != null) {
            this.nEc.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nDA == null) {
            throw new AssertionError();
        }
        b(this.nDA);
        this.nEj = 0L;
        this.nEi = 0L;
        if (this.nEb != null) {
            this.nEb.dJZ();
            this.nEh = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NH(int i) {
        this.nEk = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEa = aVar.c(this.nDu).c(this.nDE).d(this.nEd).a(new a.InterfaceC0767a() { // from class: master.flame.danmaku.a.e.5
        }).dLs();
        this.nDu.nGD.resetAll();
        if (this.nEa != null) {
            this.nEm = this.nEa.dKK();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nDA = aVar;
        this.nEh = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nEf) {
            this.nEc.dLv();
            this.nEf = false;
        }
        if (this.nEa != null) {
            d.e((Canvas) bVar.mZ());
            if (this.nEl) {
                return this.nDF;
            }
            a.b bVar2 = this.nDF;
            long j3 = (fVar.nEU - this.nDu.nGF.nGK) - 100;
            long j4 = this.nDu.nGF.nGK + fVar.nEU;
            l lVar = this.nEe;
            if (this.nEi > j3 || fVar.nEU > this.nEj) {
                lVar = this.nEa.ah(j3, j4);
                if (lVar != null) {
                    this.nEe = lVar;
                }
                this.nEi = j3;
                this.nEj = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nEi;
                j = this.nEj;
                j2 = j5;
            }
            l lVar2 = this.nEo;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nDF.nHw = true;
                this.nEc.a(bVar, lVar2, 0L, this.nDF);
            }
            this.nDF.nHw = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nEc.a(this.nDE, lVar, this.nEg, bVar2);
                a(bVar2);
                if (bVar2.nHI) {
                    if (this.nEm != null && this.nEm.isTimeOut()) {
                        this.nEm = null;
                        if (this.nEb != null) {
                            this.nEb.dKa();
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
            bVar2.nHI = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dKe() {
        this.nEj = 0L;
        this.nEi = 0L;
        this.nEl = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dKf() {
        this.nEf = true;
    }

    @Override // master.flame.danmaku.a.h
    public void j(long j, long j2, final long j3) {
        l dLw = this.nDF.dLw();
        this.nEo = dLw;
        dLw.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dKs()) {
                    return 2;
                }
                dVar.ho(j3 + dVar.nEx);
                dVar.nET = true;
                return 0;
            }
        });
        this.nEg = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nEb != null) {
            this.nEb.dKb();
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
                    this.nDu.nGE.RZ("1017_Filter");
                } else {
                    this.nDu.nGE.Sa("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dKf();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nEc != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nEc;
                if (this.nDu.dLd() || this.nDu.dLc()) {
                    z2 = true;
                }
                aVar.wN(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nEc != null) {
                this.nEc.wO(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dKg() {
        this.nEl = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nDz.hp(master.flame.danmaku.danmaku.c.c.dLy());
        bVar.nHx = 0;
        bVar.nHy = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nHI = bVar.nHF == 0;
        if (bVar.nHI) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nHz;
        bVar.nHz = null;
        bVar.endTime = dVar != null ? dVar.dKB() : -1L;
        bVar.nHH = bVar.nDz.hp(master.flame.danmaku.danmaku.c.c.dLy());
    }
}
