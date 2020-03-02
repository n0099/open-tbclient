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
/* loaded from: classes5.dex */
public class a extends e {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int mMaxCacheSize;
    private final Object nDA;
    private int nDB;
    private C0772a nDy;
    private master.flame.danmaku.danmaku.model.f nDz;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nDA = new Object();
        NativeBitmapFactory.dQY();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dQX()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nDy = new C0772a(i, 3);
        this.nFb.a(this.nDy);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFc = fVar;
        this.nDz = new master.flame.danmaku.danmaku.model.f();
        this.nDz.hn(fVar.nFT);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nDy != null) {
            this.nDy.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wG(boolean z) {
        super.wG(z);
        if (this.nDy != null) {
            this.nDy.dKY();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nDy != null) {
            int i = this.nDB + 1;
            this.nDB = i;
            if (i > 5) {
                this.nDy.dLa();
                this.nDB = 0;
                return;
            }
            return;
        }
        n<?> dLI = dVar.dLI();
        if (dLI != null) {
            if (dLI.dMj()) {
                dLI.dMk();
            } else {
                dLI.destroy();
            }
            dVar.nFJ = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nDA) {
            this.nDA.notify();
        }
        if (a != null && this.nDy != null && a.nIC - a.nID < -20) {
            this.nDy.dLa();
            this.nDy.he(-this.nEt.nHD.nHI);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nDy == null) {
            start();
        }
        this.nDy.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dQY();
        if (this.nDy == null) {
            this.nDy = new C0772a(this.mMaxCacheSize, 3);
            this.nDy.begin();
            this.nFb.a(this.nDy);
            return;
        }
        this.nDy.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nFb.a((k) null);
        if (this.nDy != null) {
            this.nDy.end();
            this.nDy = null;
        }
        NativeBitmapFactory.dQZ();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEz == null) {
            throw new AssertionError();
        }
        b(this.nEz);
        this.nDy.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NK(int i) {
        super.NK(i);
        if (this.nDy != null) {
            this.nDy.NK(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void m(long j, long j2, long j3) {
        super.m(j, j2, j3);
        if (this.nDy != null) {
            this.nDy.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0772a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nDH;
        private HandlerC0773a nDI;
        master.flame.danmaku.danmaku.model.android.d nDD = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nDE = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nDF = master.flame.danmaku.danmaku.model.a.e.a(this.nDE, 800);
        private boolean nDJ = false;
        private int nDG = 0;

        public C0772a(int i, int i2) {
            this.nDH = 3;
            this.mMaxSize = i;
            this.nDH = i2;
        }

        public void seek(long j) {
            if (this.nDI != null) {
                this.nDI.dLd();
                this.nDI.removeMessages(3);
                this.nDI.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nDI != null) {
                if (dVar.mxK) {
                    if (dVar.nFK) {
                        if (!dVar.isTimeOut()) {
                            this.nDI.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nDI.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nDI.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nDJ = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nDI == null) {
                this.nDI = new HandlerC0773a(this.mThread.getLooper());
            }
            this.nDI.begin();
        }

        public void end() {
            this.nDJ = true;
            synchronized (a.this.nDA) {
                a.this.nDA.notifyAll();
            }
            if (this.nDI != null) {
                this.nDI.pause();
                this.nDI = null;
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
            if (this.nDI != null) {
                this.nDI.resume();
            } else {
                begin();
            }
        }

        public void NK(int i) {
            if (this.nDI != null) {
                this.nDI.wJ(i == 1);
            }
        }

        public float dKT() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nDG / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nDD != null) {
                this.nDD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nDD.clear();
            }
            this.nDG = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKU() {
            wH(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wH(final boolean z) {
            if (this.nDD != null) {
                this.nDD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nFJ;
                        boolean z2 = nVar != null && nVar.dMj();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0772a.this.nDG -= nVar.size();
                                nVar.destroy();
                            }
                            C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dLJ()) {
                            C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dLI = dVar.dLI();
            if (dLI != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nEt.dMq().dLG().t(dVar);
                }
                if (c > 0) {
                    this.nDG = (int) (this.nDG - c);
                    this.nDF.c((master.flame.danmaku.danmaku.model.android.e) dLI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nFJ;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dMj()) {
                nVar.dMk();
                dVar.nFJ = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nFJ = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nFJ != null && !dVar.nFJ.dMj()) {
                    return dVar.nFJ.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKV() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dMH = this.nDF.dMH();
                if (dMH != null) {
                    dMH.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dMa = this.nDD.dMa();
            while (true) {
                if (this.nDG + i <= this.mMaxSize || dMa == null) {
                    break;
                } else if (dMa.isTimeOut()) {
                    a(false, dMa, dVar);
                    this.nDD.l(dMa);
                    dMa = this.nDD.dMa();
                } else if (!z) {
                    return false;
                }
            }
            this.nDD.k(dVar);
            this.nDG += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKW() {
            this.nDD.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nDA) {
                            try {
                                a.this.nDA.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0772a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nED.dMf() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nDM;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dLb */
                public master.flame.danmaku.danmaku.model.d dLc() {
                    return this.nDM;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dLI = dVar2.dLI();
                    if (dLI == null || dLI.get() == null) {
                        return 0;
                    }
                    if (dVar2.nFC == dVar.nFC && dVar2.nFD == dVar.nFD && dVar2.nFA == dVar.nFA && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nDM = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dLI.dMj()) {
                                return 0;
                            }
                            float width = dLI.width() - dVar.nFC;
                            float height = dLI.height() - dVar.nFD;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nDM = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nDD.b(bVar);
            return bVar.dLc();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0773a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nDR;
            private boolean nDS;

            public HandlerC0773a(Looper looper) {
                super(looper);
            }

            public void dLd() {
                this.nDS = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0772a.this.dKU();
                        for (int i = 0; i < 300; i++) {
                            C0772a.this.nDF.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nFa == null || a.this.nFg) || this.nDR;
                        wI(z);
                        if (z) {
                            this.nDR = false;
                        }
                        if (a.this.nFa != null && !a.this.nFg) {
                            a.this.nFa.dLq();
                            a.this.nFg = true;
                            return;
                        }
                        return;
                    case 4:
                        C0772a.this.dKW();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nDz.nFT;
                            a.this.nDz.hn(longValue);
                            this.nDR = true;
                            long dKX = C0772a.this.dKX();
                            if (longValue > j || dKX - longValue > a.this.nEt.nHD.nHI) {
                                C0772a.this.dKU();
                            } else {
                                C0772a.this.dKW();
                            }
                            wI(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0772a.this.evictAll();
                        C0772a.this.dKV();
                        getLooper().quit();
                        return;
                    case 7:
                        C0772a.this.evictAll();
                        a.this.nDz.hn(a.this.nFc.nFT - a.this.nEt.nHD.nHI);
                        this.nDR = true;
                        return;
                    case 8:
                        C0772a.this.wH(true);
                        a.this.nDz.hn(a.this.nFc.nFT);
                        return;
                    case 9:
                        C0772a.this.wH(true);
                        a.this.nDz.hn(a.this.nFc.nFT);
                        a.this.dLv();
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
                            n<?> dLI = dVar.dLI();
                            if (!((dVar.nFQ & 1) != 0) && dLI != null && dLI.get() != null && !dLI.dMj()) {
                                dVar.nFJ = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nED, (master.flame.danmaku.danmaku.model.android.e) dVar.nFJ);
                                C0772a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mxK) {
                                C0772a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dLI != null && dLI.dMj()) {
                                    dLI.destroy();
                                }
                                C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nFJ != null) {
                                C0772a.this.a(dVar2, dVar2.nFJ.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nDS = false;
                        return;
                }
                long dLe = dLe();
                if (dLe <= 0) {
                    dLe = a.this.nEt.nHD.nHI / 2;
                }
                sendEmptyMessageDelayed(16, dLe);
            }

            private long dLe() {
                if (a.this.nDz.nFT <= a.this.nFc.nFT - a.this.nEt.nHD.nHI) {
                    C0772a.this.dKU();
                    a.this.nDz.hn(a.this.nFc.nFT);
                    sendEmptyMessage(3);
                } else {
                    float dKT = C0772a.this.dKT();
                    master.flame.danmaku.danmaku.model.d dMa = C0772a.this.nDD.dMa();
                    long dLS = dMa != null ? dMa.dLS() - a.this.nFc.nFT : 0L;
                    long j = a.this.nEt.nHD.nHI * 2;
                    if (dKT < 0.6f && dLS > a.this.nEt.nHD.nHI) {
                        a.this.nDz.hn(a.this.nFc.nFT);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dKT > 0.4f && dLS < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dKT < 0.9f) {
                        long j2 = a.this.nDz.nFT - a.this.nFc.nFT;
                        if (dMa != null && dMa.isTimeOut() && j2 < (-a.this.nEt.nHD.nHI)) {
                            a.this.nDz.hn(a.this.nFc.nFT);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nFJ : eVar;
                dVar.nFJ = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0772a.this.nDF.c(eVar2);
                }
            }

            private void dLf() {
                l lVar = null;
                try {
                    long j = a.this.nFc.nFT;
                    lVar = a.this.nEZ.ag(j - a.this.nEt.nHD.nHI, (a.this.nEt.nHD.nHI * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0773a.this.mPause || HandlerC0773a.this.nDS) {
                                return 1;
                            }
                            if (!dVar.dLL()) {
                                a.this.nEt.nHC.a(dVar, 0, 0, null, true, a.this.nEt);
                            }
                            if (dVar.dLM()) {
                                return 0;
                            }
                            if (!dVar.dLH()) {
                                dVar.a((m) a.this.nED, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nED, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nDK.nDC.nDz.hn(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wI(final boolean z) {
                l lVar;
                dLf();
                final long j = a.this.nDz.nFT;
                long j2 = j + (a.this.nEt.nHD.nHI * C0772a.this.nDH);
                if (j2 < a.this.nFc.nFT) {
                    return 0L;
                }
                final long dMP = master.flame.danmaku.danmaku.c.c.dMP();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nEZ.ag(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hp(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dMa = lVar.dMa();
                final master.flame.danmaku.danmaku.model.d dMb = lVar.dMb();
                if (dMa == null || dMb == null) {
                    a.this.nDz.hn(j2);
                    return 0L;
                }
                long dLS = dMa.dLS() - a.this.nFc.nFT;
                final long min = Math.min(100L, dLS < 0 ? 30L : ((dLS * 10) / a.this.nEt.nHD.nHI) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nDU = 0;
                    int nDV = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0773a.this.mPause || HandlerC0773a.this.nDS || dMb.dLS() < a.this.nFc.nFT) {
                            return 1;
                        }
                        n<?> dLI = dVar2.dLI();
                        if (dLI == null || dLI.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dLJ())) {
                                if (!dVar2.dLL()) {
                                    a.this.nEt.nHC.a(dVar2, this.nDU, size, null, true, a.this.nEt);
                                }
                                if (dVar2.nFB == 0 && dVar2.dLM()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dLS2 = (int) ((dVar2.dLS() - j) / a.this.nEt.nHD.nHI);
                                    if (this.nDV == dLS2) {
                                        this.nDU++;
                                    } else {
                                        this.nDU = 0;
                                        this.nDV = dLS2;
                                    }
                                }
                                if (!z && !HandlerC0773a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nDA) {
                                            a.this.nDA.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0773a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dMP2 = master.flame.danmaku.danmaku.c.c.dMP() - dMP;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nEt.nHD;
                                        if (dMP2 >= 10000 * C0772a.this.nDH) {
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
                long dMP2 = master.flame.danmaku.danmaku.c.c.dMP() - dMP;
                if (0 != 0) {
                    a.this.nDz.hn(dVar.dLS());
                    return dMP2;
                }
                a.this.nDz.hn(j2);
                return dMP2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dLH()) {
                    dVar.a((m) a.this.nED, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nED, C0772a.this.nDF.dMH());
                        dVar.nFJ = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0772a.this.nDF.c(eVar);
                        }
                        dVar.nFJ = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0772a.this.nDF.c(eVar);
                        }
                        dVar.nFJ = null;
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
                if (!dVar.dLH()) {
                    dVar.a((m) a.this.nED, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0772a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nFJ : null;
                        try {
                            if (r3 != null) {
                                r3.dMC();
                                dVar.nFJ = r3;
                                a.this.nDy.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0772a c0772a = C0772a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0772a.a(dVar, false, 50);
                            eVar = c0772a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nFJ;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nFJ = null;
                                    dVar.nFJ = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nED, r3);
                                    a.this.nDy.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eC((int) dVar.nFC, (int) dVar.nFD) + C0772a.this.nDG <= C0772a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nED, C0772a.this.nDF.dMH());
                                    dVar.nFJ = a3;
                                    boolean a4 = a.this.nDy.a(dVar, C0772a.this.d(dVar), z);
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
                    if (dVar.dLS() <= a.this.nDz.nFT + a.this.nEt.nHD.nHI || dVar.mxK) {
                        if (dVar.nFB != 0 || !dVar.dLM()) {
                            n<?> dLI = dVar.dLI();
                            if (dLI == null || dLI.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nEt.nHD.nHI);
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
                sendEmptyMessageDelayed(4, a.this.nEt.nHD.nHI);
            }

            public void hf(long j) {
                removeMessages(3);
                this.nDR = true;
                sendEmptyMessage(19);
                a.this.nDz.hn(a.this.nFc.nFT + j);
                sendEmptyMessage(3);
            }

            public void wJ(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dKX() {
            master.flame.danmaku.danmaku.model.d dMa;
            if (this.nDD == null || this.nDD.size() <= 0 || (dMa = this.nDD.dMa()) == null) {
                return 0L;
            }
            return dMa.dLS();
        }

        public void he(long j) {
            if (this.nDI != null) {
                this.nDI.hf(j);
            }
        }

        public void dKY() {
            if (this.nDI != null) {
                this.nDI.removeMessages(3);
                this.nDI.removeMessages(19);
                this.nDI.dLd();
                this.nDI.removeMessages(7);
                this.nDI.sendEmptyMessage(7);
            }
        }

        public void dKZ() {
            if (this.nDI != null) {
                this.nDI.removeMessages(9);
                this.nDI.sendEmptyMessage(9);
            }
        }

        public void dLa() {
            if (this.nDI != null) {
                this.nDI.removeMessages(4);
                this.nDI.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nDI != null) {
                this.nDI.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nED.bG(this.nEt.nHb);
                dLv();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nDy != null)) {
                    this.nDy.he(0L);
                }
                dLv();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nED.bG(this.nEt.nHb);
                }
                if (this.nDy != null) {
                    this.nDy.dKY();
                    this.nDy.he(-this.nEt.nHD.nHI);
                }
            } else if (this.nDy != null) {
                this.nDy.dKZ();
                this.nDy.he(0L);
            }
        }
        if (this.nFa != null && this.nDy != null) {
            this.nDy.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nFa.dLs();
                }
            });
            return true;
        }
        return true;
    }
}
