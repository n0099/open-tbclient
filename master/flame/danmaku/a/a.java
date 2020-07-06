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
    private int nRa;
    private C0900a nRb;
    private master.flame.danmaku.danmaku.model.f nRc;
    private final Object nRd;
    private int nRe;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nRa = 2;
        this.nRd = new Object();
        NativeBitmapFactory.dXq();
        this.nRa = i;
        if (NativeBitmapFactory.dXp()) {
            this.nRa = i * 2;
        }
        this.nRb = new C0900a(i, 3);
        this.nSE.a(this.nRb);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nSF = fVar;
        this.nRc = new master.flame.danmaku.danmaku.model.f();
        this.nRc.gv(fVar.nTw);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nRb != null) {
            this.nRb.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void xo(boolean z) {
        super.xo(z);
        if (this.nRb != null) {
            this.nRb.dRo();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nRb != null) {
            int i = this.nRe + 1;
            this.nRe = i;
            if (i > 5) {
                this.nRb.dRq();
                this.nRe = 0;
                return;
            }
            return;
        }
        n<?> dRY = dVar.dRY();
        if (dRY != null) {
            if (dRY.dSz()) {
                dRY.dSA();
            } else {
                dRY.destroy();
            }
            dVar.nTm = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nRd) {
            this.nRd.notify();
        }
        if (a != null && this.nRb != null && a.nWg - a.nWh < -20) {
            this.nRb.dRq();
            this.nRb.gm(-this.nRW.nVi.nVn);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nRb == null) {
            start();
        }
        this.nRb.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dXq();
        if (this.nRb == null) {
            this.nRb = new C0900a(this.nRa, 3);
            this.nRb.dRi();
            this.nSE.a(this.nRb);
            return;
        }
        this.nRb.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nSE.a((k) null);
        if (this.nRb != null) {
            this.nRb.end();
            this.nRb = null;
        }
        NativeBitmapFactory.dXr();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nSc == null) {
            throw new AssertionError();
        }
        b(this.nSc);
        this.nRb.dRi();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Le(int i) {
        super.Le(i);
        if (this.nRb != null) {
            this.nRb.Le(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.nRb != null) {
            this.nRb.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0900a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nRk;
        private HandlerC0901a nRl;
        master.flame.danmaku.danmaku.model.android.d nRg = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nRh = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nRi = master.flame.danmaku.danmaku.model.a.e.a(this.nRh, 800);
        private boolean nRm = false;
        private int nRj = 0;

        public C0900a(int i, int i2) {
            this.nRk = 3;
            this.mMaxSize = i;
            this.nRk = i2;
        }

        public void seek(long j) {
            if (this.nRl != null) {
                this.nRl.dRt();
                this.nRl.removeMessages(3);
                this.nRl.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nRl != null) {
                if (dVar.jMK) {
                    if (dVar.nTn) {
                        if (!dVar.isTimeOut()) {
                            this.nRl.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nRl.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nRl.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dRi() {
            this.nRm = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nRl == null) {
                this.nRl = new HandlerC0901a(this.mThread.getLooper());
            }
            this.nRl.dRi();
        }

        public void end() {
            this.nRm = true;
            synchronized (a.this.nRd) {
                a.this.nRd.notifyAll();
            }
            if (this.nRl != null) {
                this.nRl.pause();
                this.nRl = null;
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
            if (this.nRl != null) {
                this.nRl.resume();
            } else {
                dRi();
            }
        }

        public void Le(int i) {
            if (this.nRl != null) {
                this.nRl.xr(i == 1);
            }
        }

        public float dRj() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nRj / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nRg != null) {
                this.nRg.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        C0900a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nRg.clear();
            }
            this.nRj = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRk() {
            xp(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xp(final boolean z) {
            if (this.nRg != null) {
                this.nRg.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nTm;
                        boolean z2 = nVar != null && nVar.dSz();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0900a.this.nRj -= nVar.size();
                                nVar.destroy();
                            }
                            C0900a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dRZ()) {
                            C0900a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dRY = dVar.dRY();
            if (dRY != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nRW.dSG().dRW().t(dVar);
                }
                if (c > 0) {
                    this.nRj = (int) (this.nRj - c);
                    this.nRi.c((master.flame.danmaku.danmaku.model.android.e) dRY);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nTm;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dSz()) {
                nVar.dSA();
                dVar.nTm = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nTm = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nTm != null && !dVar.nTm.dSz()) {
                    return dVar.nTm.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRl() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dSX = this.nRi.dSX();
                if (dSX != null) {
                    dSX.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dSq = this.nRg.dSq();
            while (true) {
                if (this.nRj + i <= this.mMaxSize || dSq == null) {
                    break;
                } else if (dSq.isTimeOut()) {
                    a(false, dSq, dVar);
                    this.nRg.l(dSq);
                    dSq = this.nRg.dSq();
                } else if (!z) {
                    return false;
                }
            }
            this.nRg.k(dVar);
            this.nRj += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRm() {
            this.nRg.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nRd) {
                            try {
                                a.this.nRd.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0900a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nSg.dSv() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nRp;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dRr */
                public master.flame.danmaku.danmaku.model.d dRs() {
                    return this.nRp;
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
                    n<?> dRY = dVar2.dRY();
                    if (dRY == null || dRY.get() == null) {
                        return 0;
                    }
                    if (dVar2.nTf == dVar.nTf && dVar2.nTg == dVar.nTg && dVar2.nTd == dVar.nTd && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nRp = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dRY.dSz()) {
                                return 0;
                            }
                            float width = dRY.width() - dVar.nTf;
                            float height = dRY.height() - dVar.nTg;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nRp = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nRg.b(bVar);
            return bVar.dRs();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0901a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nRu;
            private boolean nRv;

            public HandlerC0901a(Looper looper) {
                super(looper);
            }

            public void dRt() {
                this.nRv = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0900a.this.dRk();
                        for (int i = 0; i < 300; i++) {
                            C0900a.this.nRi.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nSD == null || a.this.nSJ) || this.nRu;
                        xq(z);
                        if (z) {
                            this.nRu = false;
                        }
                        if (a.this.nSD != null && !a.this.nSJ) {
                            a.this.nSD.dRG();
                            a.this.nSJ = true;
                            return;
                        }
                        return;
                    case 4:
                        C0900a.this.dRm();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nRc.nTw;
                            a.this.nRc.gv(longValue);
                            this.nRu = true;
                            long dRn = C0900a.this.dRn();
                            if (longValue > j || dRn - longValue > a.this.nRW.nVi.nVn) {
                                C0900a.this.dRk();
                            } else {
                                C0900a.this.dRm();
                            }
                            xq(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0900a.this.evictAll();
                        C0900a.this.dRl();
                        getLooper().quit();
                        return;
                    case 7:
                        C0900a.this.evictAll();
                        a.this.nRc.gv(a.this.nSF.nTw - a.this.nRW.nVi.nVn);
                        this.nRu = true;
                        return;
                    case 8:
                        C0900a.this.xp(true);
                        a.this.nRc.gv(a.this.nSF.nTw);
                        return;
                    case 9:
                        C0900a.this.xp(true);
                        a.this.nRc.gv(a.this.nSF.nTw);
                        a.this.dRL();
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
                            n<?> dRY = dVar.dRY();
                            if (!((dVar.nTt & 1) != 0) && dRY != null && dRY.get() != null && !dRY.dSz()) {
                                dVar.nTm = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSg, (master.flame.danmaku.danmaku.model.android.e) dVar.nTm);
                                C0900a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.jMK) {
                                C0900a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dRY != null && dRY.dSz()) {
                                    dRY.destroy();
                                }
                                C0900a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nTm != null) {
                                C0900a.this.a(dVar2, dVar2.nTm.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nRv = false;
                        return;
                }
                long dRu = dRu();
                if (dRu <= 0) {
                    dRu = a.this.nRW.nVi.nVn / 2;
                }
                sendEmptyMessageDelayed(16, dRu);
            }

            private long dRu() {
                if (a.this.nRc.nTw <= a.this.nSF.nTw - a.this.nRW.nVi.nVn) {
                    C0900a.this.dRk();
                    a.this.nRc.gv(a.this.nSF.nTw);
                    sendEmptyMessage(3);
                } else {
                    float dRj = C0900a.this.dRj();
                    master.flame.danmaku.danmaku.model.d dSq = C0900a.this.nRg.dSq();
                    long dSi = dSq != null ? dSq.dSi() - a.this.nSF.nTw : 0L;
                    long j = a.this.nRW.nVi.nVn * 2;
                    if (dRj < 0.6f && dSi > a.this.nRW.nVi.nVn) {
                        a.this.nRc.gv(a.this.nSF.nTw);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dRj > 0.4f && dSi < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dRj < 0.9f) {
                        long j2 = a.this.nRc.nTw - a.this.nSF.nTw;
                        if (dSq != null && dSq.isTimeOut() && j2 < (-a.this.nRW.nVi.nVn)) {
                            a.this.nRc.gv(a.this.nSF.nTw);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nTm : eVar;
                dVar.nTm = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0900a.this.nRi.c(eVar2);
                }
            }

            private void dRv() {
                l lVar = null;
                try {
                    long j = a.this.nSF.nTw;
                    lVar = a.this.nSC.Q(j - a.this.nRW.nVi.nVn, (a.this.nRW.nVi.nVn * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0901a.this.mPause || HandlerC0901a.this.nRv) {
                                return 1;
                            }
                            if (!dVar.dSb()) {
                                a.this.nRW.nVh.a(dVar, 0, 0, null, true, a.this.nRW);
                            }
                            if (dVar.dSc()) {
                                return 0;
                            }
                            if (!dVar.dRX()) {
                                dVar.a((m) a.this.nSg, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nSg, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nRn.nRf.nRc.gv(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long xq(final boolean z) {
                l lVar;
                dRv();
                final long j = a.this.nRc.nTw;
                long j2 = j + (a.this.nRW.nVi.nVn * C0900a.this.nRk);
                if (j2 < a.this.nSF.nTw) {
                    return 0L;
                }
                final long dTf = master.flame.danmaku.danmaku.c.c.dTf();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nSC.Q(j, j2);
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
                master.flame.danmaku.danmaku.model.d dSq = lVar.dSq();
                final master.flame.danmaku.danmaku.model.d dSr = lVar.dSr();
                if (dSq == null || dSr == null) {
                    a.this.nRc.gv(j2);
                    return 0L;
                }
                long dSi = dSq.dSi() - a.this.nSF.nTw;
                final long min = Math.min(100L, dSi < 0 ? 30L : ((dSi * 10) / a.this.nRW.nVi.nVn) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nRx = 0;
                    int nRy = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0901a.this.mPause || HandlerC0901a.this.nRv || dSr.dSi() < a.this.nSF.nTw) {
                            return 1;
                        }
                        n<?> dRY = dVar2.dRY();
                        if (dRY == null || dRY.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dRZ())) {
                                if (!dVar2.dSb()) {
                                    a.this.nRW.nVh.a(dVar2, this.nRx, size, null, true, a.this.nRW);
                                }
                                if (dVar2.nTe == 0 && dVar2.dSc()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dSi2 = (int) ((dVar2.dSi() - j) / a.this.nRW.nVi.nVn);
                                    if (this.nRy == dSi2) {
                                        this.nRx++;
                                    } else {
                                        this.nRx = 0;
                                        this.nRy = dSi2;
                                    }
                                }
                                if (!z && !HandlerC0901a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nRd) {
                                            a.this.nRd.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0901a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dTf2 = master.flame.danmaku.danmaku.c.c.dTf() - dTf;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nRW.nVi;
                                        if (dTf2 >= 10000 * C0900a.this.nRk) {
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
                long dTf2 = master.flame.danmaku.danmaku.c.c.dTf() - dTf;
                if (0 != 0) {
                    a.this.nRc.gv(dVar.dSi());
                    return dTf2;
                }
                a.this.nRc.gv(j2);
                return dTf2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dRX()) {
                    dVar.a((m) a.this.nSg, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSg, C0900a.this.nRi.dSX());
                        dVar.nTm = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0900a.this.nRi.c(eVar);
                        }
                        dVar.nTm = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0900a.this.nRi.c(eVar);
                        }
                        dVar.nTm = null;
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
                if (!dVar.dRX()) {
                    dVar.a((m) a.this.nSg, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0900a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nTm : null;
                        try {
                            if (r3 != null) {
                                r3.dSS();
                                dVar.nTm = r3;
                                a.this.nRb.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0900a c0900a = C0900a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0900a.a(dVar, false, 50);
                            eVar = c0900a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nTm;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nTm = null;
                                    dVar.nTm = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSg, r3);
                                    a.this.nRb.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ec((int) dVar.nTf, (int) dVar.nTg) + C0900a.this.nRj <= C0900a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nSg, C0900a.this.nRi.dSX());
                                    dVar.nTm = a3;
                                    boolean a4 = a.this.nRb.a(dVar, C0900a.this.d(dVar), z);
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
                    if (dVar.dSi() <= a.this.nRc.nTw + a.this.nRW.nVi.nVn || dVar.jMK) {
                        if (dVar.nTe != 0 || !dVar.dSc()) {
                            n<?> dRY = dVar.dRY();
                            if (dRY == null || dRY.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dRi() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nRW.nVi.nVn);
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
                sendEmptyMessageDelayed(4, a.this.nRW.nVi.nVn);
            }

            public void gn(long j) {
                removeMessages(3);
                this.nRu = true;
                sendEmptyMessage(19);
                a.this.nRc.gv(a.this.nSF.nTw + j);
                sendEmptyMessage(3);
            }

            public void xr(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dRn() {
            master.flame.danmaku.danmaku.model.d dSq;
            if (this.nRg == null || this.nRg.size() <= 0 || (dSq = this.nRg.dSq()) == null) {
                return 0L;
            }
            return dSq.dSi();
        }

        public void gm(long j) {
            if (this.nRl != null) {
                this.nRl.gn(j);
            }
        }

        public void dRo() {
            if (this.nRl != null) {
                this.nRl.removeMessages(3);
                this.nRl.removeMessages(19);
                this.nRl.dRt();
                this.nRl.removeMessages(7);
                this.nRl.sendEmptyMessage(7);
            }
        }

        public void dRp() {
            if (this.nRl != null) {
                this.nRl.removeMessages(9);
                this.nRl.sendEmptyMessage(9);
            }
        }

        public void dRq() {
            if (this.nRl != null) {
                this.nRl.removeMessages(4);
                this.nRl.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nRl != null) {
                this.nRl.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nSg.aS(this.nRW.nUG);
                dRL();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nRb != null)) {
                    this.nRb.gm(0L);
                }
                dRL();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nSg.aS(this.nRW.nUG);
                }
                if (this.nRb != null) {
                    this.nRb.dRo();
                    this.nRb.gm(-this.nRW.nVi.nVn);
                }
            } else if (this.nRb != null) {
                this.nRb.dRp();
                this.nRb.gm(0L);
            }
        }
        if (this.nSD != null && this.nRb != null) {
            this.nRb.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nSD.dRI();
                }
            });
            return true;
        }
        return true;
    }
}
