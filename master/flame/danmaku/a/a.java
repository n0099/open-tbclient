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
    private C0773a nFw;
    private master.flame.danmaku.danmaku.model.f nFx;
    private final Object nFy;
    private int nFz;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nFy = new Object();
        NativeBitmapFactory.dRz();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dRy()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nFw = new C0773a(i, 3);
        this.nGZ.a(this.nFw);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nHa = fVar;
        this.nFx = new master.flame.danmaku.danmaku.model.f();
        this.nFx.ho(fVar.nHR);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nFw != null) {
            this.nFw.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wO(boolean z) {
        super.wO(z);
        if (this.nFw != null) {
            this.nFw.dLz();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nFw != null) {
            int i = this.nFz + 1;
            this.nFz = i;
            if (i > 5) {
                this.nFw.dLB();
                this.nFz = 0;
                return;
            }
            return;
        }
        n<?> dMj = dVar.dMj();
        if (dMj != null) {
            if (dMj.dMK()) {
                dMj.dML();
            } else {
                dMj.destroy();
            }
            dVar.nHH = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nFy) {
            this.nFy.notify();
        }
        if (a != null && this.nFw != null && a.nKA - a.nKB < -20) {
            this.nFw.dLB();
            this.nFw.hf(-this.nGr.nJB.nJG);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nFw == null) {
            start();
        }
        this.nFw.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dRz();
        if (this.nFw == null) {
            this.nFw = new C0773a(this.mMaxCacheSize, 3);
            this.nFw.begin();
            this.nGZ.a(this.nFw);
            return;
        }
        this.nFw.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nGZ.a((k) null);
        if (this.nFw != null) {
            this.nFw.end();
            this.nFw = null;
        }
        NativeBitmapFactory.dRA();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nGx == null) {
            throw new AssertionError();
        }
        b(this.nGx);
        this.nFw.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NQ(int i) {
        super.NQ(i);
        if (this.nFw != null) {
            this.nFw.NQ(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void m(long j, long j2, long j3) {
        super.m(j, j2, j3);
        if (this.nFw != null) {
            this.nFw.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0773a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nFF;
        private HandlerC0774a nFG;
        master.flame.danmaku.danmaku.model.android.d nFB = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nFC = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nFD = master.flame.danmaku.danmaku.model.a.e.a(this.nFC, 800);
        private boolean nFH = false;
        private int nFE = 0;

        public C0773a(int i, int i2) {
            this.nFF = 3;
            this.mMaxSize = i;
            this.nFF = i2;
        }

        public void seek(long j) {
            if (this.nFG != null) {
                this.nFG.dLE();
                this.nFG.removeMessages(3);
                this.nFG.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nFG != null) {
                if (dVar.mzB) {
                    if (dVar.nHI) {
                        if (!dVar.isTimeOut()) {
                            this.nFG.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nFG.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nFG.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nFH = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nFG == null) {
                this.nFG = new HandlerC0774a(this.mThread.getLooper());
            }
            this.nFG.begin();
        }

        public void end() {
            this.nFH = true;
            synchronized (a.this.nFy) {
                a.this.nFy.notifyAll();
            }
            if (this.nFG != null) {
                this.nFG.pause();
                this.nFG = null;
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
            if (this.nFG != null) {
                this.nFG.resume();
            } else {
                begin();
            }
        }

        public void NQ(int i) {
            if (this.nFG != null) {
                this.nFG.wR(i == 1);
            }
        }

        public float dLu() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nFE / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nFB != null) {
                this.nFB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        C0773a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nFB.clear();
            }
            this.nFE = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dLv() {
            wP(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wP(final boolean z) {
            if (this.nFB != null) {
                this.nFB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nHH;
                        boolean z2 = nVar != null && nVar.dMK();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0773a.this.nFE -= nVar.size();
                                nVar.destroy();
                            }
                            C0773a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dMk()) {
                            C0773a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dMj = dVar.dMj();
            if (dMj != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nGr.dMR().dMh().t(dVar);
                }
                if (c > 0) {
                    this.nFE = (int) (this.nFE - c);
                    this.nFD.c((master.flame.danmaku.danmaku.model.android.e) dMj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nHH;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dMK()) {
                nVar.dML();
                dVar.nHH = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nHH = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nHH != null && !dVar.nHH.dMK()) {
                    return dVar.nHH.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dLw() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dNi = this.nFD.dNi();
                if (dNi != null) {
                    dNi.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dMB = this.nFB.dMB();
            while (true) {
                if (this.nFE + i <= this.mMaxSize || dMB == null) {
                    break;
                } else if (dMB.isTimeOut()) {
                    a(false, dMB, dVar);
                    this.nFB.l(dMB);
                    dMB = this.nFB.dMB();
                } else if (!z) {
                    return false;
                }
            }
            this.nFB.k(dVar);
            this.nFE += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dLx() {
            this.nFB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nFy) {
                            try {
                                a.this.nFy.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0773a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nGB.dMG() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nFK;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dLC */
                public master.flame.danmaku.danmaku.model.d dLD() {
                    return this.nFK;
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
                    n<?> dMj = dVar2.dMj();
                    if (dMj == null || dMj.get() == null) {
                        return 0;
                    }
                    if (dVar2.nHA == dVar.nHA && dVar2.nHB == dVar.nHB && dVar2.nHy == dVar.nHy && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nFK = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dMj.dMK()) {
                                return 0;
                            }
                            float width = dMj.width() - dVar.nHA;
                            float height = dMj.height() - dVar.nHB;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nFK = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nFB.b(bVar);
            return bVar.dLD();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0774a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nFP;
            private boolean nFQ;

            public HandlerC0774a(Looper looper) {
                super(looper);
            }

            public void dLE() {
                this.nFQ = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0773a.this.dLv();
                        for (int i = 0; i < 300; i++) {
                            C0773a.this.nFD.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nGY == null || a.this.nHe) || this.nFP;
                        wQ(z);
                        if (z) {
                            this.nFP = false;
                        }
                        if (a.this.nGY != null && !a.this.nHe) {
                            a.this.nGY.dLR();
                            a.this.nHe = true;
                            return;
                        }
                        return;
                    case 4:
                        C0773a.this.dLx();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nFx.nHR;
                            a.this.nFx.ho(longValue);
                            this.nFP = true;
                            long dLy = C0773a.this.dLy();
                            if (longValue > j || dLy - longValue > a.this.nGr.nJB.nJG) {
                                C0773a.this.dLv();
                            } else {
                                C0773a.this.dLx();
                            }
                            wQ(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0773a.this.evictAll();
                        C0773a.this.dLw();
                        getLooper().quit();
                        return;
                    case 7:
                        C0773a.this.evictAll();
                        a.this.nFx.ho(a.this.nHa.nHR - a.this.nGr.nJB.nJG);
                        this.nFP = true;
                        return;
                    case 8:
                        C0773a.this.wP(true);
                        a.this.nFx.ho(a.this.nHa.nHR);
                        return;
                    case 9:
                        C0773a.this.wP(true);
                        a.this.nFx.ho(a.this.nHa.nHR);
                        a.this.dLW();
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
                            n<?> dMj = dVar.dMj();
                            if (!((dVar.nHO & 1) != 0) && dMj != null && dMj.get() != null && !dMj.dMK()) {
                                dVar.nHH = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nGB, (master.flame.danmaku.danmaku.model.android.e) dVar.nHH);
                                C0773a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mzB) {
                                C0773a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dMj != null && dMj.dMK()) {
                                    dMj.destroy();
                                }
                                C0773a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nHH != null) {
                                C0773a.this.a(dVar2, dVar2.nHH.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nFQ = false;
                        return;
                }
                long dLF = dLF();
                if (dLF <= 0) {
                    dLF = a.this.nGr.nJB.nJG / 2;
                }
                sendEmptyMessageDelayed(16, dLF);
            }

            private long dLF() {
                if (a.this.nFx.nHR <= a.this.nHa.nHR - a.this.nGr.nJB.nJG) {
                    C0773a.this.dLv();
                    a.this.nFx.ho(a.this.nHa.nHR);
                    sendEmptyMessage(3);
                } else {
                    float dLu = C0773a.this.dLu();
                    master.flame.danmaku.danmaku.model.d dMB = C0773a.this.nFB.dMB();
                    long dMt = dMB != null ? dMB.dMt() - a.this.nHa.nHR : 0L;
                    long j = a.this.nGr.nJB.nJG * 2;
                    if (dLu < 0.6f && dMt > a.this.nGr.nJB.nJG) {
                        a.this.nFx.ho(a.this.nHa.nHR);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dLu > 0.4f && dMt < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dLu < 0.9f) {
                        long j2 = a.this.nFx.nHR - a.this.nHa.nHR;
                        if (dMB != null && dMB.isTimeOut() && j2 < (-a.this.nGr.nJB.nJG)) {
                            a.this.nFx.ho(a.this.nHa.nHR);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nHH : eVar;
                dVar.nHH = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0773a.this.nFD.c(eVar2);
                }
            }

            private void dLG() {
                l lVar = null;
                try {
                    long j = a.this.nHa.nHR;
                    lVar = a.this.nGX.ag(j - a.this.nGr.nJB.nJG, (a.this.nGr.nJB.nJG * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0774a.this.mPause || HandlerC0774a.this.nFQ) {
                                return 1;
                            }
                            if (!dVar.dMm()) {
                                a.this.nGr.nJA.a(dVar, 0, 0, null, true, a.this.nGr);
                            }
                            if (dVar.dMn()) {
                                return 0;
                            }
                            if (!dVar.dMi()) {
                                dVar.a((m) a.this.nGB, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nGB, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nFI.nFA.nFx.ho(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wQ(final boolean z) {
                l lVar;
                dLG();
                final long j = a.this.nFx.nHR;
                long j2 = j + (a.this.nGr.nJB.nJG * C0773a.this.nFF);
                if (j2 < a.this.nHa.nHR) {
                    return 0L;
                }
                final long dNq = master.flame.danmaku.danmaku.c.c.dNq();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nGX.ag(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hq(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dMB = lVar.dMB();
                final master.flame.danmaku.danmaku.model.d dMC = lVar.dMC();
                if (dMB == null || dMC == null) {
                    a.this.nFx.ho(j2);
                    return 0L;
                }
                long dMt = dMB.dMt() - a.this.nHa.nHR;
                final long min = Math.min(100L, dMt < 0 ? 30L : ((dMt * 10) / a.this.nGr.nJB.nJG) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nFS = 0;
                    int nFT = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0774a.this.mPause || HandlerC0774a.this.nFQ || dMC.dMt() < a.this.nHa.nHR) {
                            return 1;
                        }
                        n<?> dMj = dVar2.dMj();
                        if (dMj == null || dMj.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dMk())) {
                                if (!dVar2.dMm()) {
                                    a.this.nGr.nJA.a(dVar2, this.nFS, size, null, true, a.this.nGr);
                                }
                                if (dVar2.nHz == 0 && dVar2.dMn()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dMt2 = (int) ((dVar2.dMt() - j) / a.this.nGr.nJB.nJG);
                                    if (this.nFT == dMt2) {
                                        this.nFS++;
                                    } else {
                                        this.nFS = 0;
                                        this.nFT = dMt2;
                                    }
                                }
                                if (!z && !HandlerC0774a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nFy) {
                                            a.this.nFy.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0774a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dNq2 = master.flame.danmaku.danmaku.c.c.dNq() - dNq;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nGr.nJB;
                                        if (dNq2 >= 10000 * C0773a.this.nFF) {
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
                long dNq2 = master.flame.danmaku.danmaku.c.c.dNq() - dNq;
                if (0 != 0) {
                    a.this.nFx.ho(dVar.dMt());
                    return dNq2;
                }
                a.this.nFx.ho(j2);
                return dNq2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dMi()) {
                    dVar.a((m) a.this.nGB, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nGB, C0773a.this.nFD.dNi());
                        dVar.nHH = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0773a.this.nFD.c(eVar);
                        }
                        dVar.nHH = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0773a.this.nFD.c(eVar);
                        }
                        dVar.nHH = null;
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
                if (!dVar.dMi()) {
                    dVar.a((m) a.this.nGB, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0773a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nHH : null;
                        try {
                            if (r3 != null) {
                                r3.dNd();
                                dVar.nHH = r3;
                                a.this.nFw.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0773a c0773a = C0773a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0773a.a(dVar, false, 50);
                            eVar = c0773a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nHH;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nHH = null;
                                    dVar.nHH = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nGB, r3);
                                    a.this.nFw.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eD((int) dVar.nHA, (int) dVar.nHB) + C0773a.this.nFE <= C0773a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nGB, C0773a.this.nFD.dNi());
                                    dVar.nHH = a3;
                                    boolean a4 = a.this.nFw.a(dVar, C0773a.this.d(dVar), z);
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
                    if (dVar.dMt() <= a.this.nFx.nHR + a.this.nGr.nJB.nJG || dVar.mzB) {
                        if (dVar.nHz != 0 || !dVar.dMn()) {
                            n<?> dMj = dVar.dMj();
                            if (dMj == null || dMj.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nGr.nJB.nJG);
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
                sendEmptyMessageDelayed(4, a.this.nGr.nJB.nJG);
            }

            public void hg(long j) {
                removeMessages(3);
                this.nFP = true;
                sendEmptyMessage(19);
                a.this.nFx.ho(a.this.nHa.nHR + j);
                sendEmptyMessage(3);
            }

            public void wR(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dLy() {
            master.flame.danmaku.danmaku.model.d dMB;
            if (this.nFB == null || this.nFB.size() <= 0 || (dMB = this.nFB.dMB()) == null) {
                return 0L;
            }
            return dMB.dMt();
        }

        public void hf(long j) {
            if (this.nFG != null) {
                this.nFG.hg(j);
            }
        }

        public void dLz() {
            if (this.nFG != null) {
                this.nFG.removeMessages(3);
                this.nFG.removeMessages(19);
                this.nFG.dLE();
                this.nFG.removeMessages(7);
                this.nFG.sendEmptyMessage(7);
            }
        }

        public void dLA() {
            if (this.nFG != null) {
                this.nFG.removeMessages(9);
                this.nFG.sendEmptyMessage(9);
            }
        }

        public void dLB() {
            if (this.nFG != null) {
                this.nFG.removeMessages(4);
                this.nFG.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nFG != null) {
                this.nFG.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nGB.bG(this.nGr.nIZ);
                dLW();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nFw != null)) {
                    this.nFw.hf(0L);
                }
                dLW();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nGB.bG(this.nGr.nIZ);
                }
                if (this.nFw != null) {
                    this.nFw.dLz();
                    this.nFw.hf(-this.nGr.nJB.nJG);
                }
            } else if (this.nFw != null) {
                this.nFw.dLA();
                this.nFw.hf(0L);
            }
        }
        if (this.nGY != null && this.nFw != null) {
            this.nFw.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nGY.dLT();
                }
            });
            return true;
        }
        return true;
    }
}
