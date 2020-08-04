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
    private int nZL;
    private C0915a nZM;
    private master.flame.danmaku.danmaku.model.f nZN;
    private final Object nZO;
    private int nZP;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nZL = 2;
        this.nZO = new Object();
        NativeBitmapFactory.eaN();
        this.nZL = i;
        if (NativeBitmapFactory.eaM()) {
            this.nZL = i * 2;
        }
        this.nZM = new C0915a(i, 3);
        this.obq.a(this.nZM);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.obr = fVar;
        this.nZN = new master.flame.danmaku.danmaku.model.f();
        this.nZN.gI(fVar.och);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nZM != null) {
            this.nZM.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void xT(boolean z) {
        super.xT(z);
        if (this.nZM != null) {
            this.nZM.dUL();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nZM != null) {
            int i = this.nZP + 1;
            this.nZP = i;
            if (i > 5) {
                this.nZM.dUN();
                this.nZP = 0;
                return;
            }
            return;
        }
        n<?> dVv = dVar.dVv();
        if (dVv != null) {
            if (dVv.dVW()) {
                dVv.dVX();
            } else {
                dVv.destroy();
            }
            dVar.obX = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nZO) {
            this.nZO.notify();
        }
        if (a != null && this.nZM != null && a.oeS - a.oeT < -20) {
            this.nZM.dUN();
            this.nZM.gz(-this.oaH.odU.odZ);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nZM == null) {
            start();
        }
        this.nZM.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eaN();
        if (this.nZM == null) {
            this.nZM = new C0915a(this.nZL, 3);
            this.nZM.dUF();
            this.obq.a(this.nZM);
            return;
        }
        this.nZM.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.obq.a((k) null);
        if (this.nZM != null) {
            this.nZM.end();
            this.nZM = null;
        }
        NativeBitmapFactory.eaO();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oaN == null) {
            throw new AssertionError();
        }
        b(this.oaN);
        this.nZM.dUF();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Ly(int i) {
        super.Ly(i);
        if (this.nZM != null) {
            this.nZM.Ly(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.nZM != null) {
            this.nZM.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0915a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nZV;
        private HandlerC0916a nZW;
        master.flame.danmaku.danmaku.model.android.d nZR = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nZS = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nZT = master.flame.danmaku.danmaku.model.a.e.a(this.nZS, 800);
        private boolean nZX = false;
        private int nZU = 0;

        public C0915a(int i, int i2) {
            this.nZV = 3;
            this.mMaxSize = i;
            this.nZV = i2;
        }

        public void seek(long j) {
            if (this.nZW != null) {
                this.nZW.dUQ();
                this.nZW.removeMessages(3);
                this.nZW.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nZW != null) {
                if (dVar.jVk) {
                    if (dVar.obY) {
                        if (!dVar.isTimeOut()) {
                            this.nZW.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nZW.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nZW.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dUF() {
            this.nZX = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nZW == null) {
                this.nZW = new HandlerC0916a(this.mThread.getLooper());
            }
            this.nZW.dUF();
        }

        public void end() {
            this.nZX = true;
            synchronized (a.this.nZO) {
                a.this.nZO.notifyAll();
            }
            if (this.nZW != null) {
                this.nZW.pause();
                this.nZW = null;
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
            if (this.nZW != null) {
                this.nZW.resume();
            } else {
                dUF();
            }
        }

        public void Ly(int i) {
            if (this.nZW != null) {
                this.nZW.xW(i == 1);
            }
        }

        public float dUG() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nZU / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nZR != null) {
                this.nZR.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nZR.clear();
            }
            this.nZU = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUH() {
            xU(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xU(final boolean z) {
            if (this.nZR != null) {
                this.nZR.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.obX;
                        boolean z2 = nVar != null && nVar.dVW();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0915a.this.nZU -= nVar.size();
                                nVar.destroy();
                            }
                            C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dVw()) {
                            C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dVv = dVar.dVv();
            if (dVv != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.oaH.dWd().dVt().t(dVar);
                }
                if (c > 0) {
                    this.nZU = (int) (this.nZU - c);
                    this.nZT.c((master.flame.danmaku.danmaku.model.android.e) dVv);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.obX;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dVW()) {
                nVar.dVX();
                dVar.obX = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.obX = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.obX != null && !dVar.obX.dVW()) {
                    return dVar.obX.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUI() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dWu = this.nZT.dWu();
                if (dWu != null) {
                    dWu.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dVN = this.nZR.dVN();
            while (true) {
                if (this.nZU + i <= this.mMaxSize || dVN == null) {
                    break;
                } else if (dVN.isTimeOut()) {
                    a(false, dVN, dVar);
                    this.nZR.l(dVN);
                    dVN = this.nZR.dVN();
                } else if (!z) {
                    return false;
                }
            }
            this.nZR.k(dVar);
            this.nZU += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUJ() {
            this.nZR.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nZO) {
                            try {
                                a.this.nZO.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0915a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.oaR.dVS() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d oaa;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dUO */
                public master.flame.danmaku.danmaku.model.d dUP() {
                    return this.oaa;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dVv = dVar2.dVv();
                    if (dVv == null || dVv.get() == null) {
                        return 0;
                    }
                    if (dVar2.obQ == dVar.obQ && dVar2.obR == dVar.obR && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.oaa = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dVv.dVW()) {
                                return 0;
                            }
                            float width = dVv.width() - dVar.obQ;
                            float height = dVv.height() - dVar.obR;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.oaa = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nZR.b(bVar);
            return bVar.dUP();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0916a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean oaf;
            private boolean oag;

            public HandlerC0916a(Looper looper) {
                super(looper);
            }

            public void dUQ() {
                this.oag = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0915a.this.dUH();
                        for (int i = 0; i < 300; i++) {
                            C0915a.this.nZT.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.obp == null || a.this.obv) || this.oaf;
                        xV(z);
                        if (z) {
                            this.oaf = false;
                        }
                        if (a.this.obp != null && !a.this.obv) {
                            a.this.obp.dVd();
                            a.this.obv = true;
                            return;
                        }
                        return;
                    case 4:
                        C0915a.this.dUJ();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nZN.och;
                            a.this.nZN.gI(longValue);
                            this.oaf = true;
                            long dUK = C0915a.this.dUK();
                            if (longValue > j || dUK - longValue > a.this.oaH.odU.odZ) {
                                C0915a.this.dUH();
                            } else {
                                C0915a.this.dUJ();
                            }
                            xV(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0915a.this.evictAll();
                        C0915a.this.dUI();
                        getLooper().quit();
                        return;
                    case 7:
                        C0915a.this.evictAll();
                        a.this.nZN.gI(a.this.obr.och - a.this.oaH.odU.odZ);
                        this.oaf = true;
                        return;
                    case 8:
                        C0915a.this.xU(true);
                        a.this.nZN.gI(a.this.obr.och);
                        return;
                    case 9:
                        C0915a.this.xU(true);
                        a.this.nZN.gI(a.this.obr.och);
                        a.this.dVi();
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
                            n<?> dVv = dVar.dVv();
                            if (!((dVar.oce & 1) != 0) && dVv != null && dVv.get() != null && !dVv.dVW()) {
                                dVar.obX = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaR, (master.flame.danmaku.danmaku.model.android.e) dVar.obX);
                                C0915a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.jVk) {
                                C0915a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dVv != null && dVv.dVW()) {
                                    dVv.destroy();
                                }
                                C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.obX != null) {
                                C0915a.this.a(dVar2, dVar2.obX.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oag = false;
                        return;
                }
                long dUR = dUR();
                if (dUR <= 0) {
                    dUR = a.this.oaH.odU.odZ / 2;
                }
                sendEmptyMessageDelayed(16, dUR);
            }

            private long dUR() {
                if (a.this.nZN.och <= a.this.obr.och - a.this.oaH.odU.odZ) {
                    C0915a.this.dUH();
                    a.this.nZN.gI(a.this.obr.och);
                    sendEmptyMessage(3);
                } else {
                    float dUG = C0915a.this.dUG();
                    master.flame.danmaku.danmaku.model.d dVN = C0915a.this.nZR.dVN();
                    long dVF = dVN != null ? dVN.dVF() - a.this.obr.och : 0L;
                    long j = a.this.oaH.odU.odZ * 2;
                    if (dUG < 0.6f && dVF > a.this.oaH.odU.odZ) {
                        a.this.nZN.gI(a.this.obr.och);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dUG > 0.4f && dVF < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dUG < 0.9f) {
                        long j2 = a.this.nZN.och - a.this.obr.och;
                        if (dVN != null && dVN.isTimeOut() && j2 < (-a.this.oaH.odU.odZ)) {
                            a.this.nZN.gI(a.this.obr.och);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.obX : eVar;
                dVar.obX = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0915a.this.nZT.c(eVar2);
                }
            }

            private void dUS() {
                l lVar = null;
                try {
                    long j = a.this.obr.och;
                    lVar = a.this.obo.S(j - a.this.oaH.odU.odZ, (a.this.oaH.odU.odZ * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0916a.this.mPause || HandlerC0916a.this.oag) {
                                return 1;
                            }
                            if (!dVar.dVy()) {
                                a.this.oaH.odT.a(dVar, 0, 0, null, true, a.this.oaH);
                            }
                            if (dVar.dVz()) {
                                return 0;
                            }
                            if (!dVar.dVu()) {
                                dVar.a((m) a.this.oaR, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.oaR, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nZY.nZQ.nZN.gI(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long xV(final boolean z) {
                l lVar;
                dUS();
                final long j = a.this.nZN.och;
                long j2 = j + (a.this.oaH.odU.odZ * C0915a.this.nZV);
                if (j2 < a.this.obr.och) {
                    return 0L;
                }
                final long dWC = master.flame.danmaku.danmaku.c.c.dWC();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.obo.S(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gK(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dVN = lVar.dVN();
                final master.flame.danmaku.danmaku.model.d dVO = lVar.dVO();
                if (dVN == null || dVO == null) {
                    a.this.nZN.gI(j2);
                    return 0L;
                }
                long dVF = dVN.dVF() - a.this.obr.och;
                final long min = Math.min(100L, dVF < 0 ? 30L : ((dVF * 10) / a.this.oaH.odU.odZ) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int oai = 0;
                    int oaj = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0916a.this.mPause || HandlerC0916a.this.oag || dVO.dVF() < a.this.obr.och) {
                            return 1;
                        }
                        n<?> dVv = dVar2.dVv();
                        if (dVv == null || dVv.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dVw())) {
                                if (!dVar2.dVy()) {
                                    a.this.oaH.odT.a(dVar2, this.oai, size, null, true, a.this.oaH);
                                }
                                if (dVar2.obP == 0 && dVar2.dVz()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dVF2 = (int) ((dVar2.dVF() - j) / a.this.oaH.odU.odZ);
                                    if (this.oaj == dVF2) {
                                        this.oai++;
                                    } else {
                                        this.oai = 0;
                                        this.oaj = dVF2;
                                    }
                                }
                                if (!z && !HandlerC0916a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nZO) {
                                            a.this.nZO.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0916a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dWC2 = master.flame.danmaku.danmaku.c.c.dWC() - dWC;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.oaH.odU;
                                        if (dWC2 >= 10000 * C0915a.this.nZV) {
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
                long dWC2 = master.flame.danmaku.danmaku.c.c.dWC() - dWC;
                if (0 != 0) {
                    a.this.nZN.gI(dVar.dVF());
                    return dWC2;
                }
                a.this.nZN.gI(j2);
                return dWC2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dVu()) {
                    dVar.a((m) a.this.oaR, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaR, C0915a.this.nZT.dWu());
                        dVar.obX = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0915a.this.nZT.c(eVar);
                        }
                        dVar.obX = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0915a.this.nZT.c(eVar);
                        }
                        dVar.obX = null;
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
                if (!dVar.dVu()) {
                    dVar.a((m) a.this.oaR, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0915a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.obX : null;
                        try {
                            if (r3 != null) {
                                r3.dWp();
                                dVar.obX = r3;
                                a.this.nZM.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0915a c0915a = C0915a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0915a.a(dVar, false, 50);
                            eVar = c0915a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.obX;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.obX = null;
                                    dVar.obX = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaR, r3);
                                    a.this.nZM.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ee((int) dVar.obQ, (int) dVar.obR) + C0915a.this.nZU <= C0915a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaR, C0915a.this.nZT.dWu());
                                    dVar.obX = a3;
                                    boolean a4 = a.this.nZM.a(dVar, C0915a.this.d(dVar), z);
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
                    if (dVar.dVF() <= a.this.nZN.och + a.this.oaH.odU.odZ || dVar.jVk) {
                        if (dVar.obP != 0 || !dVar.dVz()) {
                            n<?> dVv = dVar.dVv();
                            if (dVv == null || dVv.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dUF() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.oaH.odU.odZ);
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
                sendEmptyMessageDelayed(4, a.this.oaH.odU.odZ);
            }

            public void gA(long j) {
                removeMessages(3);
                this.oaf = true;
                sendEmptyMessage(19);
                a.this.nZN.gI(a.this.obr.och + j);
                sendEmptyMessage(3);
            }

            public void xW(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dUK() {
            master.flame.danmaku.danmaku.model.d dVN;
            if (this.nZR == null || this.nZR.size() <= 0 || (dVN = this.nZR.dVN()) == null) {
                return 0L;
            }
            return dVN.dVF();
        }

        public void gz(long j) {
            if (this.nZW != null) {
                this.nZW.gA(j);
            }
        }

        public void dUL() {
            if (this.nZW != null) {
                this.nZW.removeMessages(3);
                this.nZW.removeMessages(19);
                this.nZW.dUQ();
                this.nZW.removeMessages(7);
                this.nZW.sendEmptyMessage(7);
            }
        }

        public void dUM() {
            if (this.nZW != null) {
                this.nZW.removeMessages(9);
                this.nZW.sendEmptyMessage(9);
            }
        }

        public void dUN() {
            if (this.nZW != null) {
                this.nZW.removeMessages(4);
                this.nZW.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nZW != null) {
                this.nZW.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.oaR.aR(this.oaH.ods);
                dVi();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nZM != null)) {
                    this.nZM.gz(0L);
                }
                dVi();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.oaR.aR(this.oaH.ods);
                }
                if (this.nZM != null) {
                    this.nZM.dUL();
                    this.nZM.gz(-this.oaH.odU.odZ);
                }
            } else if (this.nZM != null) {
                this.nZM.dUM();
                this.nZM.gz(0L);
            }
        }
        if (this.obp != null && this.nZM != null) {
            this.nZM.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.obp.dVf();
                }
            });
            return true;
        }
        return true;
    }
}
