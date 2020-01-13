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
    private final Object nCA;
    private int nCB;
    private C0764a nCy;
    private master.flame.danmaku.danmaku.model.f nCz;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nCA = new Object();
        NativeBitmapFactory.dPH();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dPG()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nCy = new C0764a(i, 3);
        this.nEc.a(this.nCy);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nEd = fVar;
        this.nCz = new master.flame.danmaku.danmaku.model.f();
        this.nCz.hp(fVar.nEU);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nCy != null) {
            this.nCy.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wD(boolean z) {
        super.wD(z);
        if (this.nCy != null) {
            this.nCy.dJH();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nCy != null) {
            int i = this.nCB + 1;
            this.nCB = i;
            if (i > 5) {
                this.nCy.dJJ();
                this.nCB = 0;
                return;
            }
            return;
        }
        n<?> dKr = dVar.dKr();
        if (dKr != null) {
            if (dKr.dKS()) {
                dKr.dKT();
            } else {
                dKr.destroy();
            }
            dVar.nEK = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nCA) {
            this.nCA.notify();
        }
        if (a != null && this.nCy != null && a.nHF - a.nHG < -20) {
            this.nCy.dJJ();
            this.nCy.hg(-this.nDu.nGF.nGK);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nCy == null) {
            start();
        }
        this.nCy.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dPH();
        if (this.nCy == null) {
            this.nCy = new C0764a(this.mMaxCacheSize, 3);
            this.nCy.begin();
            this.nEc.a(this.nCy);
            return;
        }
        this.nCy.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nEc.a((k) null);
        if (this.nCy != null) {
            this.nCy.end();
            this.nCy = null;
        }
        NativeBitmapFactory.dPI();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nDA == null) {
            throw new AssertionError();
        }
        b(this.nDA);
        this.nCy.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NH(int i) {
        super.NH(i);
        if (this.nCy != null) {
            this.nCy.NH(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void j(long j, long j2, long j3) {
        super.j(j, j2, j3);
        if (this.nCy != null) {
            this.nCy.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0764a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nCH;
        private HandlerC0765a nCI;
        master.flame.danmaku.danmaku.model.android.d nCD = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nCE = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nCF = master.flame.danmaku.danmaku.model.a.e.a(this.nCE, 800);
        private boolean nCJ = false;
        private int nCG = 0;

        public C0764a(int i, int i2) {
            this.nCH = 3;
            this.mMaxSize = i;
            this.nCH = i2;
        }

        public void seek(long j) {
            if (this.nCI != null) {
                this.nCI.dJM();
                this.nCI.removeMessages(3);
                this.nCI.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nCI != null) {
                if (dVar.mwX) {
                    if (dVar.nEL) {
                        if (!dVar.isTimeOut()) {
                            this.nCI.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nCI.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nCI.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nCJ = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nCI == null) {
                this.nCI = new HandlerC0765a(this.mThread.getLooper());
            }
            this.nCI.begin();
        }

        public void end() {
            this.nCJ = true;
            synchronized (a.this.nCA) {
                a.this.nCA.notifyAll();
            }
            if (this.nCI != null) {
                this.nCI.pause();
                this.nCI = null;
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
            if (this.nCI != null) {
                this.nCI.resume();
            } else {
                begin();
            }
        }

        public void NH(int i) {
            if (this.nCI != null) {
                this.nCI.wG(i == 1);
            }
        }

        public float dJC() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nCG / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nCD != null) {
                this.nCD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                        C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nCD.clear();
            }
            this.nCG = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJD() {
            wE(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wE(final boolean z) {
            if (this.nCD != null) {
                this.nCD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nEK;
                        boolean z2 = nVar != null && nVar.dKS();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0764a.this.nCG -= nVar.size();
                                nVar.destroy();
                            }
                            C0764a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dKs()) {
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
            n<?> dKr = dVar.dKr();
            if (dKr != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nDu.dKZ().dKp().t(dVar);
                }
                if (c > 0) {
                    this.nCG = (int) (this.nCG - c);
                    this.nCF.c((master.flame.danmaku.danmaku.model.android.e) dKr);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nEK;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dKS()) {
                nVar.dKT();
                dVar.nEK = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nEK = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nEK != null && !dVar.nEK.dKS()) {
                    return dVar.nEK.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJE() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dLq = this.nCF.dLq();
                if (dLq != null) {
                    dLq.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dKJ = this.nCD.dKJ();
            while (true) {
                if (this.nCG + i <= this.mMaxSize || dKJ == null) {
                    break;
                } else if (dKJ.isTimeOut()) {
                    a(false, dKJ, dVar);
                    this.nCD.l(dKJ);
                    dKJ = this.nCD.dKJ();
                } else if (!z) {
                    return false;
                }
            }
            this.nCD.k(dVar);
            this.nCG += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJF() {
            this.nCD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nCA) {
                            try {
                                a.this.nCA.wait(30L);
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
                i2 = a.this.nDE.dKO() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nCM;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dJK */
                public master.flame.danmaku.danmaku.model.d dJL() {
                    return this.nCM;
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
                    n<?> dKr = dVar2.dKr();
                    if (dKr == null || dKr.get() == null) {
                        return 0;
                    }
                    if (dVar2.nED == dVar.nED && dVar2.nEE == dVar.nEE && dVar2.nEB == dVar.nEB && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nCM = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dKr.dKS()) {
                                return 0;
                            }
                            float width = dKr.width() - dVar.nED;
                            float height = dKr.height() - dVar.nEE;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nCM = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nCD.b(bVar);
            return bVar.dJL();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class HandlerC0765a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nCR;
            private boolean nCS;

            public HandlerC0765a(Looper looper) {
                super(looper);
            }

            public void dJM() {
                this.nCS = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0764a.this.dJD();
                        for (int i = 0; i < 300; i++) {
                            C0764a.this.nCF.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nEb == null || a.this.nEh) || this.nCR;
                        wF(z);
                        if (z) {
                            this.nCR = false;
                        }
                        if (a.this.nEb != null && !a.this.nEh) {
                            a.this.nEb.dJZ();
                            a.this.nEh = true;
                            return;
                        }
                        return;
                    case 4:
                        C0764a.this.dJF();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nCz.nEU;
                            a.this.nCz.hp(longValue);
                            this.nCR = true;
                            long dJG = C0764a.this.dJG();
                            if (longValue > j || dJG - longValue > a.this.nDu.nGF.nGK) {
                                C0764a.this.dJD();
                            } else {
                                C0764a.this.dJF();
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
                        C0764a.this.dJE();
                        getLooper().quit();
                        return;
                    case 7:
                        C0764a.this.evictAll();
                        a.this.nCz.hp(a.this.nEd.nEU - a.this.nDu.nGF.nGK);
                        this.nCR = true;
                        return;
                    case 8:
                        C0764a.this.wE(true);
                        a.this.nCz.hp(a.this.nEd.nEU);
                        return;
                    case 9:
                        C0764a.this.wE(true);
                        a.this.nCz.hp(a.this.nEd.nEU);
                        a.this.dKe();
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
                            n<?> dKr = dVar.dKr();
                            if (!((dVar.nER & 1) != 0) && dKr != null && dKr.get() != null && !dKr.dKS()) {
                                dVar.nEK = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDE, (master.flame.danmaku.danmaku.model.android.e) dVar.nEK);
                                C0764a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mwX) {
                                C0764a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dKr != null && dKr.dKS()) {
                                    dKr.destroy();
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
                            if (dVar2.nEK != null) {
                                C0764a.this.a(dVar2, dVar2.nEK.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nCS = false;
                        return;
                }
                long dJN = dJN();
                if (dJN <= 0) {
                    dJN = a.this.nDu.nGF.nGK / 2;
                }
                sendEmptyMessageDelayed(16, dJN);
            }

            private long dJN() {
                if (a.this.nCz.nEU <= a.this.nEd.nEU - a.this.nDu.nGF.nGK) {
                    C0764a.this.dJD();
                    a.this.nCz.hp(a.this.nEd.nEU);
                    sendEmptyMessage(3);
                } else {
                    float dJC = C0764a.this.dJC();
                    master.flame.danmaku.danmaku.model.d dKJ = C0764a.this.nCD.dKJ();
                    long dKB = dKJ != null ? dKJ.dKB() - a.this.nEd.nEU : 0L;
                    long j = a.this.nDu.nGF.nGK * 2;
                    if (dJC < 0.6f && dKB > a.this.nDu.nGF.nGK) {
                        a.this.nCz.hp(a.this.nEd.nEU);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dJC > 0.4f && dKB < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dJC < 0.9f) {
                        long j2 = a.this.nCz.nEU - a.this.nEd.nEU;
                        if (dKJ != null && dKJ.isTimeOut() && j2 < (-a.this.nDu.nGF.nGK)) {
                            a.this.nCz.hp(a.this.nEd.nEU);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nEK : eVar;
                dVar.nEK = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0764a.this.nCF.c(eVar2);
                }
            }

            private void dJO() {
                l lVar = null;
                try {
                    long j = a.this.nEd.nEU;
                    lVar = a.this.nEa.ag(j - a.this.nDu.nGF.nGK, (a.this.nDu.nGF.nGK * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0765a.this.mPause || HandlerC0765a.this.nCS) {
                                return 1;
                            }
                            if (!dVar.dKu()) {
                                a.this.nDu.nGE.a(dVar, 0, 0, null, true, a.this.nDu);
                            }
                            if (dVar.dKv()) {
                                return 0;
                            }
                            if (!dVar.dKq()) {
                                dVar.a((m) a.this.nDE, true);
                            }
                            if (dVar.aGB()) {
                                return 0;
                            }
                            dVar.b(a.this.nDE, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nCK.nCC.nCz.hp(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wF(final boolean z) {
                l lVar;
                dJO();
                final long j = a.this.nCz.nEU;
                long j2 = j + (a.this.nDu.nGF.nGK * C0764a.this.nCH);
                if (j2 < a.this.nEd.nEU) {
                    return 0L;
                }
                final long dLy = master.flame.danmaku.danmaku.c.c.dLy();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nEa.ag(j, j2);
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
                master.flame.danmaku.danmaku.model.d dKJ = lVar.dKJ();
                final master.flame.danmaku.danmaku.model.d dKK = lVar.dKK();
                if (dKJ == null || dKK == null) {
                    a.this.nCz.hp(j2);
                    return 0L;
                }
                long dKB = dKJ.dKB() - a.this.nEd.nEU;
                final long min = Math.min(100L, dKB < 0 ? 30L : ((dKB * 10) / a.this.nDu.nGF.nGK) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nCU = 0;
                    int nCV = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0765a.this.mPause || HandlerC0765a.this.nCS || dKK.dKB() < a.this.nEd.nEU) {
                            return 1;
                        }
                        n<?> dKr = dVar2.dKr();
                        if (dKr == null || dKr.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dKs())) {
                                if (!dVar2.dKu()) {
                                    a.this.nDu.nGE.a(dVar2, this.nCU, size, null, true, a.this.nDu);
                                }
                                if (dVar2.nEC == 0 && dVar2.dKv()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dKB2 = (int) ((dVar2.dKB() - j) / a.this.nDu.nGF.nGK);
                                    if (this.nCV == dKB2) {
                                        this.nCU++;
                                    } else {
                                        this.nCU = 0;
                                        this.nCV = dKB2;
                                    }
                                }
                                if (!z && !HandlerC0765a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nCA) {
                                            a.this.nCA.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0765a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dLy2 = master.flame.danmaku.danmaku.c.c.dLy() - dLy;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nDu.nGF;
                                        if (dLy2 >= 10000 * C0764a.this.nCH) {
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
                long dLy2 = master.flame.danmaku.danmaku.c.c.dLy() - dLy;
                if (0 != 0) {
                    a.this.nCz.hp(dVar.dKB());
                    return dLy2;
                }
                a.this.nCz.hp(j2);
                return dLy2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dKq()) {
                    dVar.a((m) a.this.nDE, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDE, C0764a.this.nCF.dLq());
                        dVar.nEK = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0764a.this.nCF.c(eVar);
                        }
                        dVar.nEK = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0764a.this.nCF.c(eVar);
                        }
                        dVar.nEK = null;
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
                if (!dVar.dKq()) {
                    dVar.a((m) a.this.nDE, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0764a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nEK : null;
                        try {
                            if (r3 != null) {
                                r3.dLl();
                                dVar.nEK = r3;
                                a.this.nCy.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0764a c0764a = C0764a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0764a.a(dVar, false, 50);
                            eVar = c0764a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nEK;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nEK = null;
                                    dVar.nEK = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDE, r3);
                                    a.this.nCy.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ez((int) dVar.nED, (int) dVar.nEE) + C0764a.this.nCG <= C0764a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nDE, C0764a.this.nCF.dLq());
                                    dVar.nEK = a3;
                                    boolean a4 = a.this.nCy.a(dVar, C0764a.this.d(dVar), z);
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
                    if (dVar.dKB() <= a.this.nCz.nEU + a.this.nDu.nGF.nGK || dVar.mwX) {
                        if (dVar.nEC != 0 || !dVar.dKv()) {
                            n<?> dKr = dVar.dKr();
                            if (dKr == null || dKr.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nDu.nGF.nGK);
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
                sendEmptyMessageDelayed(4, a.this.nDu.nGF.nGK);
            }

            public void hh(long j) {
                removeMessages(3);
                this.nCR = true;
                sendEmptyMessage(19);
                a.this.nCz.hp(a.this.nEd.nEU + j);
                sendEmptyMessage(3);
            }

            public void wG(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dJG() {
            master.flame.danmaku.danmaku.model.d dKJ;
            if (this.nCD == null || this.nCD.size() <= 0 || (dKJ = this.nCD.dKJ()) == null) {
                return 0L;
            }
            return dKJ.dKB();
        }

        public void hg(long j) {
            if (this.nCI != null) {
                this.nCI.hh(j);
            }
        }

        public void dJH() {
            if (this.nCI != null) {
                this.nCI.removeMessages(3);
                this.nCI.removeMessages(19);
                this.nCI.dJM();
                this.nCI.removeMessages(7);
                this.nCI.sendEmptyMessage(7);
            }
        }

        public void dJI() {
            if (this.nCI != null) {
                this.nCI.removeMessages(9);
                this.nCI.sendEmptyMessage(9);
            }
        }

        public void dJJ() {
            if (this.nCI != null) {
                this.nCI.removeMessages(4);
                this.nCI.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nCI != null) {
                this.nCI.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nDE.bH(this.nDu.nGd);
                dKe();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nCy != null)) {
                    this.nCy.hg(0L);
                }
                dKe();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nDE.bH(this.nDu.nGd);
                }
                if (this.nCy != null) {
                    this.nCy.dJH();
                    this.nCy.hg(-this.nDu.nGF.nGK);
                }
            } else if (this.nCy != null) {
                this.nCy.dJI();
                this.nCy.hg(0L);
            }
        }
        if (this.nEb != null && this.nCy != null) {
            this.nCy.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nEb.dKb();
                }
            });
            return true;
        }
        return true;
    }
}
