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
    private int nQX;
    private C0899a nQY;
    private master.flame.danmaku.danmaku.model.f nQZ;
    private final Object nRa;
    private int nRb;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nQX = 2;
        this.nRa = new Object();
        NativeBitmapFactory.dXm();
        this.nQX = i;
        if (NativeBitmapFactory.dXl()) {
            this.nQX = i * 2;
        }
        this.nQY = new C0899a(i, 3);
        this.nSB.a(this.nQY);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nSC = fVar;
        this.nQZ = new master.flame.danmaku.danmaku.model.f();
        this.nQZ.gv(fVar.nTt);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nQY != null) {
            this.nQY.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void xo(boolean z) {
        super.xo(z);
        if (this.nQY != null) {
            this.nQY.dRk();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nQY != null) {
            int i = this.nRb + 1;
            this.nRb = i;
            if (i > 5) {
                this.nQY.dRm();
                this.nRb = 0;
                return;
            }
            return;
        }
        n<?> dRU = dVar.dRU();
        if (dRU != null) {
            if (dRU.dSv()) {
                dRU.dSw();
            } else {
                dRU.destroy();
            }
            dVar.nTj = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nRa) {
            this.nRa.notify();
        }
        if (a != null && this.nQY != null && a.nWd - a.nWe < -20) {
            this.nQY.dRm();
            this.nQY.gm(-this.nRT.nVf.nVk);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nQY == null) {
            start();
        }
        this.nQY.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dXm();
        if (this.nQY == null) {
            this.nQY = new C0899a(this.nQX, 3);
            this.nQY.dRe();
            this.nSB.a(this.nQY);
            return;
        }
        this.nQY.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nSB.a((k) null);
        if (this.nQY != null) {
            this.nQY.end();
            this.nQY = null;
        }
        NativeBitmapFactory.dXn();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nRZ == null) {
            throw new AssertionError();
        }
        b(this.nRZ);
        this.nQY.dRe();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Le(int i) {
        super.Le(i);
        if (this.nQY != null) {
            this.nQY.Le(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.nQY != null) {
            this.nQY.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0899a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nRh;
        private HandlerC0900a nRi;
        master.flame.danmaku.danmaku.model.android.d nRd = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nRe = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nRf = master.flame.danmaku.danmaku.model.a.e.a(this.nRe, 800);
        private boolean nRj = false;
        private int nRg = 0;

        public C0899a(int i, int i2) {
            this.nRh = 3;
            this.mMaxSize = i;
            this.nRh = i2;
        }

        public void seek(long j) {
            if (this.nRi != null) {
                this.nRi.dRp();
                this.nRi.removeMessages(3);
                this.nRi.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nRi != null) {
                if (dVar.jMK) {
                    if (dVar.nTk) {
                        if (!dVar.isTimeOut()) {
                            this.nRi.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nRi.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nRi.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dRe() {
            this.nRj = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nRi == null) {
                this.nRi = new HandlerC0900a(this.mThread.getLooper());
            }
            this.nRi.dRe();
        }

        public void end() {
            this.nRj = true;
            synchronized (a.this.nRa) {
                a.this.nRa.notifyAll();
            }
            if (this.nRi != null) {
                this.nRi.pause();
                this.nRi = null;
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
            if (this.nRi != null) {
                this.nRi.resume();
            } else {
                dRe();
            }
        }

        public void Le(int i) {
            if (this.nRi != null) {
                this.nRi.xr(i == 1);
            }
        }

        public float dRf() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nRg / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nRd != null) {
                this.nRd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        C0899a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nRd.clear();
            }
            this.nRg = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRg() {
            xp(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xp(final boolean z) {
            if (this.nRd != null) {
                this.nRd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nTj;
                        boolean z2 = nVar != null && nVar.dSv();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0899a.this.nRg -= nVar.size();
                                nVar.destroy();
                            }
                            C0899a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dRV()) {
                            C0899a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dRU = dVar.dRU();
            if (dRU != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nRT.dSC().dRS().t(dVar);
                }
                if (c > 0) {
                    this.nRg = (int) (this.nRg - c);
                    this.nRf.c((master.flame.danmaku.danmaku.model.android.e) dRU);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nTj;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dSv()) {
                nVar.dSw();
                dVar.nTj = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nTj = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nTj != null && !dVar.nTj.dSv()) {
                    return dVar.nTj.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRh() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dST = this.nRf.dST();
                if (dST != null) {
                    dST.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dSm = this.nRd.dSm();
            while (true) {
                if (this.nRg + i <= this.mMaxSize || dSm == null) {
                    break;
                } else if (dSm.isTimeOut()) {
                    a(false, dSm, dVar);
                    this.nRd.l(dSm);
                    dSm = this.nRd.dSm();
                } else if (!z) {
                    return false;
                }
            }
            this.nRd.k(dVar);
            this.nRg += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRi() {
            this.nRd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nRa) {
                            try {
                                a.this.nRa.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0899a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nSd.dSr() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nRm;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dRn */
                public master.flame.danmaku.danmaku.model.d dRo() {
                    return this.nRm;
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
                    n<?> dRU = dVar2.dRU();
                    if (dRU == null || dRU.get() == null) {
                        return 0;
                    }
                    if (dVar2.nTc == dVar.nTc && dVar2.nTd == dVar.nTd && dVar2.nTa == dVar.nTa && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nRm = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dRU.dSv()) {
                                return 0;
                            }
                            float width = dRU.width() - dVar.nTc;
                            float height = dRU.height() - dVar.nTd;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nRm = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nRd.b(bVar);
            return bVar.dRo();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0900a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nRr;
            private boolean nRs;

            public HandlerC0900a(Looper looper) {
                super(looper);
            }

            public void dRp() {
                this.nRs = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0899a.this.dRg();
                        for (int i = 0; i < 300; i++) {
                            C0899a.this.nRf.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nSA == null || a.this.nSG) || this.nRr;
                        xq(z);
                        if (z) {
                            this.nRr = false;
                        }
                        if (a.this.nSA != null && !a.this.nSG) {
                            a.this.nSA.dRC();
                            a.this.nSG = true;
                            return;
                        }
                        return;
                    case 4:
                        C0899a.this.dRi();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nQZ.nTt;
                            a.this.nQZ.gv(longValue);
                            this.nRr = true;
                            long dRj = C0899a.this.dRj();
                            if (longValue > j || dRj - longValue > a.this.nRT.nVf.nVk) {
                                C0899a.this.dRg();
                            } else {
                                C0899a.this.dRi();
                            }
                            xq(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0899a.this.evictAll();
                        C0899a.this.dRh();
                        getLooper().quit();
                        return;
                    case 7:
                        C0899a.this.evictAll();
                        a.this.nQZ.gv(a.this.nSC.nTt - a.this.nRT.nVf.nVk);
                        this.nRr = true;
                        return;
                    case 8:
                        C0899a.this.xp(true);
                        a.this.nQZ.gv(a.this.nSC.nTt);
                        return;
                    case 9:
                        C0899a.this.xp(true);
                        a.this.nQZ.gv(a.this.nSC.nTt);
                        a.this.dRH();
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
                            n<?> dRU = dVar.dRU();
                            if (!((dVar.nTq & 1) != 0) && dRU != null && dRU.get() != null && !dRU.dSv()) {
                                dVar.nTj = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSd, (master.flame.danmaku.danmaku.model.android.e) dVar.nTj);
                                C0899a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.jMK) {
                                C0899a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dRU != null && dRU.dSv()) {
                                    dRU.destroy();
                                }
                                C0899a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nTj != null) {
                                C0899a.this.a(dVar2, dVar2.nTj.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nRs = false;
                        return;
                }
                long dRq = dRq();
                if (dRq <= 0) {
                    dRq = a.this.nRT.nVf.nVk / 2;
                }
                sendEmptyMessageDelayed(16, dRq);
            }

            private long dRq() {
                if (a.this.nQZ.nTt <= a.this.nSC.nTt - a.this.nRT.nVf.nVk) {
                    C0899a.this.dRg();
                    a.this.nQZ.gv(a.this.nSC.nTt);
                    sendEmptyMessage(3);
                } else {
                    float dRf = C0899a.this.dRf();
                    master.flame.danmaku.danmaku.model.d dSm = C0899a.this.nRd.dSm();
                    long dSe = dSm != null ? dSm.dSe() - a.this.nSC.nTt : 0L;
                    long j = a.this.nRT.nVf.nVk * 2;
                    if (dRf < 0.6f && dSe > a.this.nRT.nVf.nVk) {
                        a.this.nQZ.gv(a.this.nSC.nTt);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dRf > 0.4f && dSe < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dRf < 0.9f) {
                        long j2 = a.this.nQZ.nTt - a.this.nSC.nTt;
                        if (dSm != null && dSm.isTimeOut() && j2 < (-a.this.nRT.nVf.nVk)) {
                            a.this.nQZ.gv(a.this.nSC.nTt);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nTj : eVar;
                dVar.nTj = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0899a.this.nRf.c(eVar2);
                }
            }

            private void dRr() {
                l lVar = null;
                try {
                    long j = a.this.nSC.nTt;
                    lVar = a.this.nSz.Q(j - a.this.nRT.nVf.nVk, (a.this.nRT.nVf.nVk * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0900a.this.mPause || HandlerC0900a.this.nRs) {
                                return 1;
                            }
                            if (!dVar.dRX()) {
                                a.this.nRT.nVe.a(dVar, 0, 0, null, true, a.this.nRT);
                            }
                            if (dVar.dRY()) {
                                return 0;
                            }
                            if (!dVar.dRT()) {
                                dVar.a((m) a.this.nSd, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nSd, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nRk.nRc.nQZ.gv(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long xq(final boolean z) {
                l lVar;
                dRr();
                final long j = a.this.nQZ.nTt;
                long j2 = j + (a.this.nRT.nVf.nVk * C0899a.this.nRh);
                if (j2 < a.this.nSC.nTt) {
                    return 0L;
                }
                final long dTb = master.flame.danmaku.danmaku.c.c.dTb();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nSz.Q(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gx(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dSm = lVar.dSm();
                final master.flame.danmaku.danmaku.model.d dSn = lVar.dSn();
                if (dSm == null || dSn == null) {
                    a.this.nQZ.gv(j2);
                    return 0L;
                }
                long dSe = dSm.dSe() - a.this.nSC.nTt;
                final long min = Math.min(100L, dSe < 0 ? 30L : ((dSe * 10) / a.this.nRT.nVf.nVk) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nRu = 0;
                    int nRv = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0900a.this.mPause || HandlerC0900a.this.nRs || dSn.dSe() < a.this.nSC.nTt) {
                            return 1;
                        }
                        n<?> dRU = dVar2.dRU();
                        if (dRU == null || dRU.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dRV())) {
                                if (!dVar2.dRX()) {
                                    a.this.nRT.nVe.a(dVar2, this.nRu, size, null, true, a.this.nRT);
                                }
                                if (dVar2.nTb == 0 && dVar2.dRY()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dSe2 = (int) ((dVar2.dSe() - j) / a.this.nRT.nVf.nVk);
                                    if (this.nRv == dSe2) {
                                        this.nRu++;
                                    } else {
                                        this.nRu = 0;
                                        this.nRv = dSe2;
                                    }
                                }
                                if (!z && !HandlerC0900a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nRa) {
                                            a.this.nRa.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0900a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dTb2 = master.flame.danmaku.danmaku.c.c.dTb() - dTb;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nRT.nVf;
                                        if (dTb2 >= 10000 * C0899a.this.nRh) {
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
                long dTb2 = master.flame.danmaku.danmaku.c.c.dTb() - dTb;
                if (0 != 0) {
                    a.this.nQZ.gv(dVar.dSe());
                    return dTb2;
                }
                a.this.nQZ.gv(j2);
                return dTb2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dRT()) {
                    dVar.a((m) a.this.nSd, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSd, C0899a.this.nRf.dST());
                        dVar.nTj = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0899a.this.nRf.c(eVar);
                        }
                        dVar.nTj = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0899a.this.nRf.c(eVar);
                        }
                        dVar.nTj = null;
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
                if (!dVar.dRT()) {
                    dVar.a((m) a.this.nSd, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0899a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nTj : null;
                        try {
                            if (r3 != null) {
                                r3.dSO();
                                dVar.nTj = r3;
                                a.this.nQY.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0899a c0899a = C0899a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0899a.a(dVar, false, 50);
                            eVar = c0899a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nTj;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nTj = null;
                                    dVar.nTj = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSd, r3);
                                    a.this.nQY.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ec((int) dVar.nTc, (int) dVar.nTd) + C0899a.this.nRg <= C0899a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSd, C0899a.this.nRf.dST());
                                    dVar.nTj = a3;
                                    boolean a4 = a.this.nQY.a(dVar, C0899a.this.d(dVar), z);
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
                    if (dVar.dSe() <= a.this.nQZ.nTt + a.this.nRT.nVf.nVk || dVar.jMK) {
                        if (dVar.nTb != 0 || !dVar.dRY()) {
                            n<?> dRU = dVar.dRU();
                            if (dRU == null || dRU.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dRe() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nRT.nVf.nVk);
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
                sendEmptyMessageDelayed(4, a.this.nRT.nVf.nVk);
            }

            public void gn(long j) {
                removeMessages(3);
                this.nRr = true;
                sendEmptyMessage(19);
                a.this.nQZ.gv(a.this.nSC.nTt + j);
                sendEmptyMessage(3);
            }

            public void xr(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dRj() {
            master.flame.danmaku.danmaku.model.d dSm;
            if (this.nRd == null || this.nRd.size() <= 0 || (dSm = this.nRd.dSm()) == null) {
                return 0L;
            }
            return dSm.dSe();
        }

        public void gm(long j) {
            if (this.nRi != null) {
                this.nRi.gn(j);
            }
        }

        public void dRk() {
            if (this.nRi != null) {
                this.nRi.removeMessages(3);
                this.nRi.removeMessages(19);
                this.nRi.dRp();
                this.nRi.removeMessages(7);
                this.nRi.sendEmptyMessage(7);
            }
        }

        public void dRl() {
            if (this.nRi != null) {
                this.nRi.removeMessages(9);
                this.nRi.sendEmptyMessage(9);
            }
        }

        public void dRm() {
            if (this.nRi != null) {
                this.nRi.removeMessages(4);
                this.nRi.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nRi != null) {
                this.nRi.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nSd.aS(this.nRT.nUD);
                dRH();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nQY != null)) {
                    this.nQY.gm(0L);
                }
                dRH();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nSd.aS(this.nRT.nUD);
                }
                if (this.nQY != null) {
                    this.nQY.dRk();
                    this.nQY.gm(-this.nRT.nVf.nVk);
                }
            } else if (this.nQY != null) {
                this.nQY.dRl();
                this.nQY.gm(0L);
            }
        }
        if (this.nSA != null && this.nQY != null) {
            this.nQY.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nSA.dRE();
                }
            });
            return true;
        }
        return true;
    }
}
