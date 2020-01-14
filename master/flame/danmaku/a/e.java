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
    protected master.flame.danmaku.danmaku.a.a nDF;
    protected final master.flame.danmaku.danmaku.model.b nDJ;
    protected final DanmakuContext nDz;
    protected l nEf;
    h.a nEg;
    final master.flame.danmaku.danmaku.b.a nEh;
    master.flame.danmaku.danmaku.model.f nEi;
    protected boolean nEk;
    protected boolean nEm;
    private long nEn;
    private long nEo;
    protected int nEp;
    private boolean nEq;
    private master.flame.danmaku.danmaku.model.d nEr;
    private l nEt;
    private l nEj = new master.flame.danmaku.danmaku.model.android.d(4);
    private long nEl = 0;
    private final a.b nDK = new a.b();
    private master.flame.danmaku.danmaku.model.android.d nEs = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a nEu = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.nDz = danmakuContext;
        this.nDJ = danmakuContext.dLb();
        this.nEg = aVar;
        this.nEh = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.nEh.a(new a.InterfaceC0768a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0768a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.nEg != null) {
                    e.this.nEg.i(dVar);
                }
            }
        });
        this.nEh.wN(this.nDz.dLf() || this.nDz.dLe());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.nDz.dLc());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.nDz.nGJ.RZ("1017_Filter");
            } else {
                this.nDz.nGJ.Sa("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nEi = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.nEf != null) {
            if (dVar.mxc) {
                this.nEs.k(dVar);
                NI(10);
            }
            dVar.index = this.nEf.size();
            boolean z = true;
            if (this.nEn <= dVar.dKD() && dVar.dKD() <= this.nEo) {
                synchronized (this.nEj) {
                    z = this.nEj.k(dVar);
                }
            } else if (dVar.mxc) {
                z = false;
            }
            synchronized (this.nEf) {
                k = this.nEf.k(dVar);
            }
            if (!z || !k) {
                this.nEo = 0L;
                this.nEn = 0L;
            }
            if (k && this.nEg != null) {
                this.nEg.h(dVar);
            }
            if (this.nEr == null || (dVar != null && this.nEr != null && dVar.dKD() > this.nEr.dKD())) {
                this.nEr = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void wD(boolean z) {
        if (this.nEf != null && !this.nEf.isEmpty()) {
            synchronized (this.nEf) {
                if (!z) {
                    l ag = this.nEf.ag((this.nEi.nEZ - this.nDz.nGK.nGP) - 100, this.nEi.nEZ + this.nDz.nGK.nGP);
                    if (ag != null) {
                        this.nEj = ag;
                    }
                }
                this.nEf.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void NI(final int i) {
        if (this.nEf != null && !this.nEf.isEmpty() && !this.nEs.isEmpty()) {
            this.nEs.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.dLA();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean isTimeOut = dVar.isTimeOut();
                    if (master.flame.danmaku.danmaku.c.c.dLA() - this.startTime <= i && isTimeOut) {
                        e.this.nEf.l(dVar);
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
        l ag = this.nEf.ag((j - this.nDz.nGK.nGP) - 100, this.nDz.nGK.nGP + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (ag != null && !ag.isEmpty()) {
            ag.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.dKu()) {
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
        return a(bVar, this.nEi);
    }

    public void reset() {
        if (this.nEj != null) {
            this.nEj = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.nEh != null) {
            this.nEh.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d dKM;
        reset();
        this.nDz.nGI.dKF();
        this.nDz.nGI.dKI();
        this.nDz.nGI.dKJ();
        this.nDz.nGI.dKK();
        this.nEt = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.nEl = j;
        this.nDK.reset();
        this.nDK.endTime = this.nEl;
        this.nEo = 0L;
        this.nEn = 0L;
        if (this.nEf != null && (dKM = this.nEf.dKM()) != null && !dKM.isTimeOut()) {
            this.nEr = dKM;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hl(long j) {
        reset();
        this.nDz.nGI.dKF();
        this.nDz.nGI.dKI();
        this.nEl = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.nDz.a(this.nEu);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.nDz.dLg();
        if (this.nEh != null) {
            this.nEh.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nDF == null) {
            throw new AssertionError();
        }
        b(this.nDF);
        this.nEo = 0L;
        this.nEn = 0L;
        if (this.nEg != null) {
            this.nEg.dKb();
            this.nEm = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void NH(int i) {
        this.nEp = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEf = aVar.c(this.nDz).c(this.nDJ).d(this.nEi).a(new a.InterfaceC0767a() { // from class: master.flame.danmaku.a.e.5
        }).dLu();
        this.nDz.nGI.resetAll();
        if (this.nEf != null) {
            this.nEr = this.nEf.dKM();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nDF = aVar;
        this.nEm = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.nEk) {
            this.nEh.dLx();
            this.nEk = false;
        }
        if (this.nEf != null) {
            d.e((Canvas) bVar.mZ());
            if (this.nEq) {
                return this.nDK;
            }
            a.b bVar2 = this.nDK;
            long j3 = (fVar.nEZ - this.nDz.nGK.nGP) - 100;
            long j4 = this.nDz.nGK.nGP + fVar.nEZ;
            l lVar = this.nEj;
            if (this.nEn > j3 || fVar.nEZ > this.nEo) {
                lVar = this.nEf.ah(j3, j4);
                if (lVar != null) {
                    this.nEj = lVar;
                }
                this.nEn = j3;
                this.nEo = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.nEn;
                j = this.nEo;
                j2 = j5;
            }
            l lVar2 = this.nEt;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.nDK.nHB = true;
                this.nEh.a(bVar, lVar2, 0L, this.nDK);
            }
            this.nDK.nHB = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.nEh.a(this.nDJ, lVar, this.nEl, bVar2);
                a(bVar2);
                if (bVar2.nHN) {
                    if (this.nEr != null && this.nEr.isTimeOut()) {
                        this.nEr = null;
                        if (this.nEg != null) {
                            this.nEg.dKc();
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
            bVar2.nHN = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void dKg() {
        this.nEo = 0L;
        this.nEn = 0L;
        this.nEq = false;
    }

    @Override // master.flame.danmaku.a.h
    public void dKh() {
        this.nEk = true;
    }

    @Override // master.flame.danmaku.a.h
    public void j(long j, long j2, final long j3) {
        l dLy = this.nDK.dLy();
        this.nEt = dLy;
        dLy.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.dKu()) {
                    return 2;
                }
                dVar.ho(j3 + dVar.nEC);
                dVar.nEY = true;
                return 0;
            }
        });
        this.nEl = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.nEg != null) {
            this.nEg.dKd();
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
                    this.nDz.nGJ.RZ("1017_Filter");
                } else {
                    this.nDz.nGJ.Sa("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            dKh();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.nEh != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.nEh;
                if (this.nDz.dLf() || this.nDz.dLe()) {
                    z2 = true;
                }
                aVar.wN(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.nEh != null) {
                this.nEh.wO(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void dKi() {
        this.nEq = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.nDE.hp(master.flame.danmaku.danmaku.c.c.dLA());
        bVar.nHC = 0;
        bVar.nHD = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.nHN = bVar.nHK == 0;
        if (bVar.nHN) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.nHE;
        bVar.nHE = null;
        bVar.endTime = dVar != null ? dVar.dKD() : -1L;
        bVar.nHM = bVar.nDE.hp(master.flame.danmaku.danmaku.c.c.dLA());
    }
}
