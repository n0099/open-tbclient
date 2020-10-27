package master.flame.danmaku.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import tv.cjump.jni.NativeBitmapFactory;
/* loaded from: classes6.dex */
public class a extends e {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int pKt;
    private C1060a pKu;
    private master.flame.danmaku.danmaku.model.f pKv;
    private final Object pKw;
    private int pKx;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.pKt = 2;
        this.pKw = new Object();
        NativeBitmapFactory.eEE();
        this.pKt = i;
        if (NativeBitmapFactory.eED()) {
            this.pKt = i * 2;
        }
        this.pKu = new C1060a(i, 3);
        this.pLX.a(this.pKu);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pLY = fVar;
        this.pKv = new master.flame.danmaku.danmaku.model.f();
        this.pKv.hT(fVar.pMO);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.pKu != null) {
            this.pKu.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void AK(boolean z) {
        super.AK(z);
        if (this.pKu != null) {
            this.pKu.eyE();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.pKu != null) {
            int i = this.pKx + 1;
            this.pKx = i;
            if (i > 5) {
                this.pKu.eyG();
                this.pKx = 0;
                return;
            }
            return;
        }
        n<?> ezo = dVar.ezo();
        if (ezo != null) {
            if (ezo.ezQ()) {
                ezo.ezR();
            } else {
                ezo.destroy();
            }
            dVar.pME = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a2 = super.a(bVar);
        synchronized (this.pKw) {
            this.pKw.notify();
        }
        if (a2 != null && this.pKu != null && a2.pPw - a2.pPx < -20) {
            this.pKu.eyG();
            this.pKu.hK(-this.pLp.pOz.pOE);
        }
        return a2;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.pKu == null) {
            start();
        }
        this.pKu.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eEE();
        if (this.pKu == null) {
            this.pKu = new C1060a(this.pKt, 3);
            this.pKu.eyy();
            this.pLX.a(this.pKu);
            return;
        }
        this.pKu.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.pLX.a((k) null);
        if (this.pKu != null) {
            this.pKu.end();
            this.pKu = null;
        }
        NativeBitmapFactory.eEF();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pLv == null) {
            throw new AssertionError();
        }
        b(this.pLv);
        this.pKu.eyy();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Rd(int i) {
        super.Rd(i);
        if (this.pKu != null) {
            this.pKu.Rd(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.pKu != null) {
            this.pKu.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1060a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int pKD;
        private HandlerC1061a pKE;
        master.flame.danmaku.danmaku.model.android.d pKz = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g pKA = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> pKB = master.flame.danmaku.danmaku.model.a.e.a(this.pKA, 800);
        private boolean pKF = false;
        private int pKC = 0;

        public C1060a(int i, int i2) {
            this.pKD = 3;
            this.mMaxSize = i;
            this.pKD = i2;
        }

        public void seek(long j) {
            if (this.pKE != null) {
                this.pKE.eyJ();
                this.pKE.removeMessages(3);
                this.pKE.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.pKE != null) {
                if (dVar.kUV) {
                    if (dVar.pMF) {
                        if (!dVar.ezp()) {
                            this.pKE.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.pKE.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.pKE.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void eyy() {
            this.pKF = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.pKE == null) {
                this.pKE = new HandlerC1061a(this.mThread.getLooper());
            }
            this.pKE.eyy();
        }

        public void end() {
            this.pKF = true;
            synchronized (a.this.pKw) {
                a.this.pKw.notifyAll();
            }
            if (this.pKE != null) {
                this.pKE.pause();
                this.pKE = null;
            }
            if (this.mThread != null) {
                try {
                    this.mThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread.quit();
                this.mThread = null;
            }
        }

        public void resume() {
            if (this.pKE != null) {
                this.pKE.resume();
            } else {
                eyy();
            }
        }

        public void Rd(int i) {
            if (this.pKE != null) {
                this.pKE.AN(i == 1);
            }
        }

        public float eyz() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.pKC / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.pKz != null) {
                this.pKz.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                        C1060a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.pKz.clear();
            }
            this.pKC = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eyA() {
            AL(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void AL(final boolean z) {
            if (this.pKz != null) {
                this.pKz.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.pME;
                        boolean z2 = nVar != null && nVar.ezQ();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C1060a.this.pKC -= nVar.size();
                                nVar.destroy();
                            }
                            C1060a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.ezq()) {
                            C1060a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> ezo = dVar.ezo();
            if (ezo != null) {
                long c = c(dVar);
                if (dVar.ezp()) {
                    a.this.pLp.ezX().ezm().t(dVar);
                }
                if (c > 0) {
                    this.pKC = (int) (this.pKC - c);
                    this.pKB.c((master.flame.danmaku.danmaku.model.android.e) ezo);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.pME;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.ezQ()) {
                nVar.ezR();
                dVar.pME = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.pME = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.pME != null && !dVar.pME.ezQ()) {
                    return dVar.pME.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eyB() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eAo = this.pKB.eAo();
                if (eAo != null) {
                    eAo.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d ezH = this.pKz.ezH();
            while (true) {
                if (this.pKC + i <= this.mMaxSize || ezH == null) {
                    break;
                } else if (ezH.ezp()) {
                    a(false, ezH, dVar);
                    this.pKz.l(ezH);
                    ezH = this.pKz.ezH();
                } else if (!z) {
                    return false;
                }
            }
            this.pKz.k(dVar);
            this.pKC += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eyC() {
            this.pKz.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.ezp()) {
                        synchronized (a.this.pKw) {
                            try {
                                a.this.pKw.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C1060a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        i = 2;
                    }
                    return i;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public master.flame.danmaku.danmaku.model.d a(final master.flame.danmaku.danmaku.model.d dVar, final boolean z, final int i) {
            final int i2 = 0;
            if (!z) {
                i2 = a.this.pLz.ezM() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d pKI;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: eyH */
                public master.flame.danmaku.danmaku.model.d eyI() {
                    return this.pKI;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> ezo = dVar2.ezo();
                    if (ezo == null || ezo.get() == null) {
                        return 0;
                    }
                    if (dVar2.pMx == dVar.pMx && dVar2.pMy == dVar.pMy && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.pKI = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.ezp()) {
                            if (ezo.ezQ()) {
                                return 0;
                            }
                            float width = ezo.width() - dVar.pMx;
                            float height = ezo.height() - dVar.pMy;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.pKI = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.pKz.b(bVar);
            return bVar.eyI();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC1061a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean pKN;
            private boolean pKO;

            public HandlerC1061a(Looper looper) {
                super(looper);
            }

            public void eyJ() {
                this.pKO = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C1060a.this.eyA();
                        for (int i = 0; i < 300; i++) {
                            C1060a.this.pKB.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.pLW == null || a.this.pMc) || this.pKN;
                        AM(z);
                        if (z) {
                            this.pKN = false;
                        }
                        if (a.this.pLW != null && !a.this.pMc) {
                            a.this.pLW.eyW();
                            a.this.pMc = true;
                            return;
                        }
                        return;
                    case 4:
                        C1060a.this.eyC();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.pKv.pMO;
                            a.this.pKv.hT(longValue);
                            this.pKN = true;
                            long eyD = C1060a.this.eyD();
                            if (longValue > j || eyD - longValue > a.this.pLp.pOz.pOE) {
                                C1060a.this.eyA();
                            } else {
                                C1060a.this.eyC();
                            }
                            AM(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C1060a.this.evictAll();
                        C1060a.this.eyB();
                        getLooper().quit();
                        return;
                    case 7:
                        C1060a.this.evictAll();
                        a.this.pKv.hT(a.this.pLY.pMO - a.this.pLp.pOz.pOE);
                        this.pKN = true;
                        return;
                    case 8:
                        C1060a.this.AL(true);
                        a.this.pKv.hT(a.this.pLY.pMO);
                        return;
                    case 9:
                        C1060a.this.AL(true);
                        a.this.pKv.hT(a.this.pLY.pMO);
                        a.this.ezb();
                        return;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        return;
                    case 16:
                        break;
                    case 17:
                        master.flame.danmaku.danmaku.model.d dVar = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (dVar != null) {
                            n<?> ezo = dVar.ezo();
                            if (!((dVar.pML & 1) != 0) && ezo != null && ezo.get() != null && !ezo.ezQ()) {
                                dVar.pME = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pLz, (master.flame.danmaku.danmaku.model.android.e) dVar.pME);
                                C1060a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.kUV) {
                                C1060a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (ezo != null && ezo.ezQ()) {
                                    ezo.destroy();
                                }
                                C1060a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.ezp()) {
                            f(dVar2);
                            if (dVar2.pME != null) {
                                C1060a.this.a(dVar2, dVar2.pME.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.pKO = false;
                        return;
                }
                long eyK = eyK();
                if (eyK <= 0) {
                    eyK = a.this.pLp.pOz.pOE / 2;
                }
                sendEmptyMessageDelayed(16, eyK);
            }

            private long eyK() {
                if (a.this.pKv.pMO <= a.this.pLY.pMO - a.this.pLp.pOz.pOE) {
                    C1060a.this.eyA();
                    a.this.pKv.hT(a.this.pLY.pMO);
                    sendEmptyMessage(3);
                } else {
                    float eyz = C1060a.this.eyz();
                    master.flame.danmaku.danmaku.model.d ezH = C1060a.this.pKz.ezH();
                    long ezz = ezH != null ? ezH.ezz() - a.this.pLY.pMO : 0L;
                    long j = a.this.pLp.pOz.pOE * 2;
                    if (eyz < 0.6f && ezz > a.this.pLp.pOz.pOE) {
                        a.this.pKv.hT(a.this.pLY.pMO);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (eyz > 0.4f && ezz < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (eyz < 0.9f) {
                        long j2 = a.this.pKv.pMO - a.this.pLY.pMO;
                        if (ezH != null && ezH.ezp() && j2 < (-a.this.pLp.pOz.pOE)) {
                            a.this.pKv.hT(a.this.pLY.pMO);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                        } else if (j2 <= j) {
                            removeMessages(3);
                            sendEmptyMessage(3);
                        }
                    }
                }
                return 0L;
            }

            private void a(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.android.e eVar) {
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.pME : eVar;
                dVar.pME = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C1060a.this.pKB.c(eVar2);
                }
            }

            private void eyL() {
                l lVar = null;
                try {
                    long j = a.this.pLY.pMO;
                    lVar = a.this.pLV.Q(j - a.this.pLp.pOz.pOE, (a.this.pLp.pOz.pOE * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC1061a.this.mPause || HandlerC1061a.this.pKO) {
                                return 1;
                            }
                            if (!dVar.ezs()) {
                                a.this.pLp.pOy.a(dVar, 0, 0, null, true, a.this.pLp);
                            }
                            if (dVar.ezt()) {
                                return 0;
                            }
                            if (!dVar.ezn()) {
                                dVar.a((m) a.this.pLz, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.pLz, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.pKG.pKy.pKv.hT(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long AM(final boolean z) {
                l lVar;
                eyL();
                final long j = a.this.pKv.pMO;
                long j2 = j + (a.this.pLp.pOz.pOE * C1060a.this.pKD);
                if (j2 < a.this.pLY.pMO) {
                    return 0L;
                }
                final long eAw = master.flame.danmaku.danmaku.c.c.eAw();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.pLV.Q(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hV(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d ezH = lVar.ezH();
                final master.flame.danmaku.danmaku.model.d ezI = lVar.ezI();
                if (ezH == null || ezI == null) {
                    a.this.pKv.hT(j2);
                    return 0L;
                }
                long ezz = ezH.ezz() - a.this.pLY.pMO;
                final long min = Math.min(100L, ezz < 0 ? 30L : ((ezz * 10) / a.this.pLp.pOz.pOE) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int pKQ = 0;
                    int pKR = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC1061a.this.mPause || HandlerC1061a.this.pKO || ezI.ezz() < a.this.pLY.pMO) {
                            return 1;
                        }
                        n<?> ezo = dVar2.ezo();
                        if (ezo == null || ezo.get() == null) {
                            if (z || (!dVar2.ezp() && dVar2.ezq())) {
                                if (!dVar2.ezs()) {
                                    a.this.pLp.pOy.a(dVar2, this.pKQ, size, null, true, a.this.pLp);
                                }
                                if (dVar2.pMw == 0 && dVar2.ezt()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int ezz2 = (int) ((dVar2.ezz() - j) / a.this.pLp.pOz.pOE);
                                    if (this.pKR == ezz2) {
                                        this.pKQ++;
                                    } else {
                                        this.pKQ = 0;
                                        this.pKR = ezz2;
                                    }
                                }
                                if (!z && !HandlerC1061a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.pKw) {
                                            a.this.pKw.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC1061a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eAw2 = master.flame.danmaku.danmaku.c.c.eAw() - eAw;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.pLp.pOz;
                                        if (eAw2 >= 10000 * C1060a.this.pKD) {
                                            return 1;
                                        }
                                    }
                                    return 0;
                                }
                                return 1;
                            }
                            return 0;
                        }
                        return 0;
                    }
                });
                long eAw2 = master.flame.danmaku.danmaku.c.c.eAw() - eAw;
                if (0 != 0) {
                    a.this.pKv.hT(dVar.ezz());
                    return eAw2;
                }
                a.this.pKv.hT(j2);
                return eAw2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.ezn()) {
                    dVar.a((m) a.this.pLz, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pLz, C1060a.this.pKB.eAo());
                        dVar.pME = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C1060a.this.pKB.c(eVar);
                        }
                        dVar.pME = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C1060a.this.pKB.c(eVar);
                        }
                        dVar.pME = null;
                        return false;
                    }
                } catch (Exception e3) {
                    eVar = null;
                } catch (OutOfMemoryError e4) {
                    eVar = null;
                }
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00c8 */
            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: master.flame.danmaku.a.a$a */
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public byte a(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.ezn()) {
                    dVar.a((m) a.this.pLz, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a2 = C1060a.this.a(dVar, true, 20);
                        r3 = a2 != null ? (master.flame.danmaku.danmaku.model.android.e) a2.pME : null;
                        try {
                            if (r3 != null) {
                                r3.eAj();
                                dVar.pME = r3;
                                a.this.pKu.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C1060a c1060a = C1060a.this;
                            master.flame.danmaku.danmaku.model.d a3 = c1060a.a(dVar, false, 50);
                            eVar = c1060a;
                            if (a3 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a3.pME;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a3.pME = null;
                                    dVar.pME = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pLz, r3);
                                    a.this.pKu.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ey((int) dVar.pMx, (int) dVar.pMy) + C1060a.this.pKC <= C1060a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a4 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pLz, C1060a.this.pKB.eAo());
                                    dVar.pME = a4;
                                    boolean a5 = a.this.pKu.a(dVar, C1060a.this.d(dVar), z);
                                    if (!a5) {
                                        a(dVar, a4);
                                    }
                                    return a5 ? (byte) 0 : (byte) 1;
                                } else {
                                    return (byte) 1;
                                }
                            } catch (Exception e) {
                                r3 = eVar;
                                a(dVar, r3);
                                return (byte) 1;
                            } catch (OutOfMemoryError e2) {
                                a(dVar, eVar);
                                return (byte) 1;
                            }
                        } catch (OutOfMemoryError e3) {
                            eVar = r3;
                        }
                    } catch (OutOfMemoryError e4) {
                        eVar = null;
                    }
                } catch (Exception e5) {
                }
            }

            private final void g(master.flame.danmaku.danmaku.model.d dVar) {
                if (!dVar.ezp()) {
                    if (dVar.ezz() <= a.this.pKv.pMO + a.this.pLp.pOz.pOE || dVar.kUV) {
                        if (dVar.pMw != 0 || !dVar.ezt()) {
                            n<?> ezo = dVar.ezo();
                            if (ezo == null || ezo.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void eyy() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.pLp.pOz.pOE);
            }

            public void pause() {
                this.mPause = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void resume() {
                sendEmptyMessage(19);
                this.mPause = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, a.this.pLp.pOz.pOE);
            }

            public void hL(long j) {
                removeMessages(3);
                this.pKN = true;
                sendEmptyMessage(19);
                a.this.pKv.hT(a.this.pLY.pMO + j);
                sendEmptyMessage(3);
            }

            public void AN(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long eyD() {
            master.flame.danmaku.danmaku.model.d ezH;
            if (this.pKz == null || this.pKz.size() <= 0 || (ezH = this.pKz.ezH()) == null) {
                return 0L;
            }
            return ezH.ezz();
        }

        public void hK(long j) {
            if (this.pKE != null) {
                this.pKE.hL(j);
            }
        }

        public void eyE() {
            if (this.pKE != null) {
                this.pKE.removeMessages(3);
                this.pKE.removeMessages(19);
                this.pKE.eyJ();
                this.pKE.removeMessages(7);
                this.pKE.sendEmptyMessage(7);
            }
        }

        public void eyF() {
            if (this.pKE != null) {
                this.pKE.removeMessages(9);
                this.pKE.sendEmptyMessage(9);
            }
        }

        public void eyG() {
            if (this.pKE != null) {
                this.pKE.removeMessages(4);
                this.pKE.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.pKE != null) {
                this.pKE.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.pLz.bu(this.pLp.pNX);
                ezb();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.pKu != null)) {
                    this.pKu.hK(0L);
                }
                ezb();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.pLz.bu(this.pLp.pNX);
                }
                if (this.pKu != null) {
                    this.pKu.eyE();
                    this.pKu.hK(-this.pLp.pOz.pOE);
                }
            } else if (this.pKu != null) {
                this.pKu.eyF();
                this.pKu.hK(0L);
            }
        }
        if (this.pLW != null && this.pKu != null) {
            this.pKu.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pLW.eyY();
                }
            });
            return true;
        }
        return true;
    }
}
