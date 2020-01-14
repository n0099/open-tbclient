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
/* loaded from: classes4.dex */
public class a extends e {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int mMaxCacheSize;
    private C0764a nCD;
    private master.flame.danmaku.danmaku.model.f nCE;
    private final Object nCF;
    private int nCG;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nCF = new Object();
        NativeBitmapFactory.dPJ();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dPI()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nCD = new C0764a(i, 3);
        this.nEh.a(this.nCD);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nEi = fVar;
        this.nCE = new master.flame.danmaku.danmaku.model.f();
        this.nCE.hp(fVar.nEZ);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nCD != null) {
            this.nCD.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wD(boolean z) {
        super.wD(z);
        if (this.nCD != null) {
            this.nCD.dJJ();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nCD != null) {
            int i = this.nCG + 1;
            this.nCG = i;
            if (i > 5) {
                this.nCD.dJL();
                this.nCG = 0;
                return;
            }
            return;
        }
        n<?> dKt = dVar.dKt();
        if (dKt != null) {
            if (dKt.dKU()) {
                dKt.dKV();
            } else {
                dKt.destroy();
            }
            dVar.nEP = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nCF) {
            this.nCF.notify();
        }
        if (a != null && this.nCD != null && a.nHK - a.nHL < -20) {
            this.nCD.dJL();
            this.nCD.hg(-this.nDz.nGK.nGP);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nCD == null) {
            start();
        }
        this.nCD.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dPJ();
        if (this.nCD == null) {
            this.nCD = new C0764a(this.mMaxCacheSize, 3);
            this.nCD.begin();
            this.nEh.a(this.nCD);
            return;
        }
        this.nCD.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nEh.a((k) null);
        if (this.nCD != null) {
            this.nCD.end();
            this.nCD = null;
        }
        NativeBitmapFactory.dPK();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nDF == null) {
            throw new AssertionError();
        }
        b(this.nDF);
        this.nCD.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NH(int i) {
        super.NH(i);
        if (this.nCD != null) {
            this.nCD.NH(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void j(long j, long j2, long j3) {
        super.j(j, j2, j3);
        if (this.nCD != null) {
            this.nCD.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0764a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nCM;
        private HandlerC0765a nCN;
        master.flame.danmaku.danmaku.model.android.d nCI = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nCJ = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nCK = master.flame.danmaku.danmaku.model.a.e.a(this.nCJ, 800);
        private boolean nCO = false;
        private int nCL = 0;

        public C0764a(int i, int i2) {
            this.nCM = 3;
            this.mMaxSize = i;
            this.nCM = i2;
        }

        public void seek(long j) {
            if (this.nCN != null) {
                this.nCN.dJO();
                this.nCN.removeMessages(3);
                this.nCN.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nCN != null) {
                if (dVar.mxc) {
                    if (dVar.nEQ) {
                        if (!dVar.isTimeOut()) {
                            this.nCN.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nCN.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nCN.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nCO = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nCN == null) {
                this.nCN = new HandlerC0765a(this.mThread.getLooper());
            }
            this.nCN.begin();
        }

        public void end() {
            this.nCO = true;
            synchronized (a.this.nCF) {
                a.this.nCF.notifyAll();
            }
            if (this.nCN != null) {
                this.nCN.pause();
                this.nCN = null;
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
            if (this.nCN != null) {
                this.nCN.resume();
            } else {
                begin();
            }
        }

        public void NH(int i) {
            if (this.nCN != null) {
                this.nCN.wG(i == 1);
            }
        }

        public float dJE() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nCL / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nCI != null) {
                this.nCI.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                        C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nCI.clear();
            }
            this.nCL = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJF() {
            wE(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wE(final boolean z) {
            if (this.nCI != null) {
                this.nCI.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nEP;
                        boolean z2 = nVar != null && nVar.dKU();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0764a.this.nCL -= nVar.size();
                                nVar.destroy();
                            }
                            C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dKu()) {
                            C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dKt = dVar.dKt();
            if (dKt != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nDz.dLb().dKr().t(dVar);
                }
                if (c > 0) {
                    this.nCL = (int) (this.nCL - c);
                    this.nCK.c((master.flame.danmaku.danmaku.model.android.e) dKt);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nEP;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dKU()) {
                nVar.dKV();
                dVar.nEP = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nEP = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nEP != null && !dVar.nEP.dKU()) {
                    return dVar.nEP.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJG() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dLs = this.nCK.dLs();
                if (dLs != null) {
                    dLs.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dKL = this.nCI.dKL();
            while (true) {
                if (this.nCL + i <= this.mMaxSize || dKL == null) {
                    break;
                } else if (dKL.isTimeOut()) {
                    a(false, dKL, dVar);
                    this.nCI.l(dKL);
                    dKL = this.nCI.dKL();
                } else if (!z) {
                    return false;
                }
            }
            this.nCI.k(dVar);
            this.nCL += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJH() {
            this.nCI.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nCF) {
                            try {
                                a.this.nCF.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0764a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nDJ.dKQ() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nCR;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dJM */
                public master.flame.danmaku.danmaku.model.d dJN() {
                    return this.nCR;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dKt = dVar2.dKt();
                    if (dKt == null || dKt.get() == null) {
                        return 0;
                    }
                    if (dVar2.nEI == dVar.nEI && dVar2.nEJ == dVar.nEJ && dVar2.nEG == dVar.nEG && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nCR = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dKt.dKU()) {
                                return 0;
                            }
                            float width = dKt.width() - dVar.nEI;
                            float height = dKt.height() - dVar.nEJ;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nCR = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nCI.b(bVar);
            return bVar.dJN();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class HandlerC0765a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nCW;
            private boolean nCX;

            public HandlerC0765a(Looper looper) {
                super(looper);
            }

            public void dJO() {
                this.nCX = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0764a.this.dJF();
                        for (int i = 0; i < 300; i++) {
                            C0764a.this.nCK.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nEg == null || a.this.nEm) || this.nCW;
                        wF(z);
                        if (z) {
                            this.nCW = false;
                        }
                        if (a.this.nEg != null && !a.this.nEm) {
                            a.this.nEg.dKb();
                            a.this.nEm = true;
                            return;
                        }
                        return;
                    case 4:
                        C0764a.this.dJH();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nCE.nEZ;
                            a.this.nCE.hp(longValue);
                            this.nCW = true;
                            long dJI = C0764a.this.dJI();
                            if (longValue > j || dJI - longValue > a.this.nDz.nGK.nGP) {
                                C0764a.this.dJF();
                            } else {
                                C0764a.this.dJH();
                            }
                            wF(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0764a.this.evictAll();
                        C0764a.this.dJG();
                        getLooper().quit();
                        return;
                    case 7:
                        C0764a.this.evictAll();
                        a.this.nCE.hp(a.this.nEi.nEZ - a.this.nDz.nGK.nGP);
                        this.nCW = true;
                        return;
                    case 8:
                        C0764a.this.wE(true);
                        a.this.nCE.hp(a.this.nEi.nEZ);
                        return;
                    case 9:
                        C0764a.this.wE(true);
                        a.this.nCE.hp(a.this.nEi.nEZ);
                        a.this.dKg();
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
                            n<?> dKt = dVar.dKt();
                            if (!((dVar.nEW & 1) != 0) && dKt != null && dKt.get() != null && !dKt.dKU()) {
                                dVar.nEP = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDJ, (master.flame.danmaku.danmaku.model.android.e) dVar.nEP);
                                C0764a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mxc) {
                                C0764a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dKt != null && dKt.dKU()) {
                                    dKt.destroy();
                                }
                                C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nEP != null) {
                                C0764a.this.a(dVar2, dVar2.nEP.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nCX = false;
                        return;
                }
                long dJP = dJP();
                if (dJP <= 0) {
                    dJP = a.this.nDz.nGK.nGP / 2;
                }
                sendEmptyMessageDelayed(16, dJP);
            }

            private long dJP() {
                if (a.this.nCE.nEZ <= a.this.nEi.nEZ - a.this.nDz.nGK.nGP) {
                    C0764a.this.dJF();
                    a.this.nCE.hp(a.this.nEi.nEZ);
                    sendEmptyMessage(3);
                } else {
                    float dJE = C0764a.this.dJE();
                    master.flame.danmaku.danmaku.model.d dKL = C0764a.this.nCI.dKL();
                    long dKD = dKL != null ? dKL.dKD() - a.this.nEi.nEZ : 0L;
                    long j = a.this.nDz.nGK.nGP * 2;
                    if (dJE < 0.6f && dKD > a.this.nDz.nGK.nGP) {
                        a.this.nCE.hp(a.this.nEi.nEZ);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dJE > 0.4f && dKD < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dJE < 0.9f) {
                        long j2 = a.this.nCE.nEZ - a.this.nEi.nEZ;
                        if (dKL != null && dKL.isTimeOut() && j2 < (-a.this.nDz.nGK.nGP)) {
                            a.this.nCE.hp(a.this.nEi.nEZ);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nEP : eVar;
                dVar.nEP = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0764a.this.nCK.c(eVar2);
                }
            }

            private void dJQ() {
                l lVar = null;
                try {
                    long j = a.this.nEi.nEZ;
                    lVar = a.this.nEf.ag(j - a.this.nDz.nGK.nGP, (a.this.nDz.nGK.nGP * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0765a.this.mPause || HandlerC0765a.this.nCX) {
                                return 1;
                            }
                            if (!dVar.dKw()) {
                                a.this.nDz.nGJ.a(dVar, 0, 0, null, true, a.this.nDz);
                            }
                            if (dVar.dKx()) {
                                return 0;
                            }
                            if (!dVar.dKs()) {
                                dVar.a((m) a.this.nDJ, true);
                            }
                            if (dVar.aGB()) {
                                return 0;
                            }
                            dVar.b(a.this.nDJ, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nCP.nCH.nCE.hp(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wF(final boolean z) {
                l lVar;
                dJQ();
                final long j = a.this.nCE.nEZ;
                long j2 = j + (a.this.nDz.nGK.nGP * C0764a.this.nCM);
                if (j2 < a.this.nEi.nEZ) {
                    return 0L;
                }
                final long dLA = master.flame.danmaku.danmaku.c.c.dLA();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nEf.ag(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hr(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dKL = lVar.dKL();
                final master.flame.danmaku.danmaku.model.d dKM = lVar.dKM();
                if (dKL == null || dKM == null) {
                    a.this.nCE.hp(j2);
                    return 0L;
                }
                long dKD = dKL.dKD() - a.this.nEi.nEZ;
                final long min = Math.min(100L, dKD < 0 ? 30L : ((dKD * 10) / a.this.nDz.nGK.nGP) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nCZ = 0;
                    int nDa = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0765a.this.mPause || HandlerC0765a.this.nCX || dKM.dKD() < a.this.nEi.nEZ) {
                            return 1;
                        }
                        n<?> dKt = dVar2.dKt();
                        if (dKt == null || dKt.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dKu())) {
                                if (!dVar2.dKw()) {
                                    a.this.nDz.nGJ.a(dVar2, this.nCZ, size, null, true, a.this.nDz);
                                }
                                if (dVar2.nEH == 0 && dVar2.dKx()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dKD2 = (int) ((dVar2.dKD() - j) / a.this.nDz.nGK.nGP);
                                    if (this.nDa == dKD2) {
                                        this.nCZ++;
                                    } else {
                                        this.nCZ = 0;
                                        this.nDa = dKD2;
                                    }
                                }
                                if (!z && !HandlerC0765a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nCF) {
                                            a.this.nCF.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0765a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dLA2 = master.flame.danmaku.danmaku.c.c.dLA() - dLA;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nDz.nGK;
                                        if (dLA2 >= 10000 * C0764a.this.nCM) {
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
                long dLA2 = master.flame.danmaku.danmaku.c.c.dLA() - dLA;
                if (0 != 0) {
                    a.this.nCE.hp(dVar.dKD());
                    return dLA2;
                }
                a.this.nCE.hp(j2);
                return dLA2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dKs()) {
                    dVar.a((m) a.this.nDJ, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDJ, C0764a.this.nCK.dLs());
                        dVar.nEP = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0764a.this.nCK.c(eVar);
                        }
                        dVar.nEP = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0764a.this.nCK.c(eVar);
                        }
                        dVar.nEP = null;
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
                if (!dVar.dKs()) {
                    dVar.a((m) a.this.nDJ, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0764a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nEP : null;
                        try {
                            if (r3 != null) {
                                r3.dLn();
                                dVar.nEP = r3;
                                a.this.nCD.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0764a c0764a = C0764a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0764a.a(dVar, false, 50);
                            eVar = c0764a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nEP;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nEP = null;
                                    dVar.nEP = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDJ, r3);
                                    a.this.nCD.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ez((int) dVar.nEI, (int) dVar.nEJ) + C0764a.this.nCL <= C0764a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDJ, C0764a.this.nCK.dLs());
                                    dVar.nEP = a3;
                                    boolean a4 = a.this.nCD.a(dVar, C0764a.this.d(dVar), z);
                                    if (!a4) {
                                        a(dVar, a3);
                                    }
                                    return a4 ? (byte) 0 : (byte) 1;
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
                if (!dVar.isTimeOut()) {
                    if (dVar.dKD() <= a.this.nCE.nEZ + a.this.nDz.nGK.nGP || dVar.mxc) {
                        if (dVar.nEH != 0 || !dVar.dKx()) {
                            n<?> dKt = dVar.dKt();
                            if (dKt == null || dKt.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nDz.nGK.nGP);
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
                sendEmptyMessageDelayed(4, a.this.nDz.nGK.nGP);
            }

            public void hh(long j) {
                removeMessages(3);
                this.nCW = true;
                sendEmptyMessage(19);
                a.this.nCE.hp(a.this.nEi.nEZ + j);
                sendEmptyMessage(3);
            }

            public void wG(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dJI() {
            master.flame.danmaku.danmaku.model.d dKL;
            if (this.nCI == null || this.nCI.size() <= 0 || (dKL = this.nCI.dKL()) == null) {
                return 0L;
            }
            return dKL.dKD();
        }

        public void hg(long j) {
            if (this.nCN != null) {
                this.nCN.hh(j);
            }
        }

        public void dJJ() {
            if (this.nCN != null) {
                this.nCN.removeMessages(3);
                this.nCN.removeMessages(19);
                this.nCN.dJO();
                this.nCN.removeMessages(7);
                this.nCN.sendEmptyMessage(7);
            }
        }

        public void dJK() {
            if (this.nCN != null) {
                this.nCN.removeMessages(9);
                this.nCN.sendEmptyMessage(9);
            }
        }

        public void dJL() {
            if (this.nCN != null) {
                this.nCN.removeMessages(4);
                this.nCN.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nCN != null) {
                this.nCN.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nDJ.bH(this.nDz.nGi);
                dKg();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nCD != null)) {
                    this.nCD.hg(0L);
                }
                dKg();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nDJ.bH(this.nDz.nGi);
                }
                if (this.nCD != null) {
                    this.nCD.dJJ();
                    this.nCD.hg(-this.nDz.nGK.nGP);
                }
            } else if (this.nCD != null) {
                this.nCD.dJK();
                this.nCD.hg(0L);
            }
        }
        if (this.nEg != null && this.nCD != null) {
            this.nCD.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nEg.dKd();
                }
            });
            return true;
        }
        return true;
    }
}
