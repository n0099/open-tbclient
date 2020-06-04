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
    private int nvl;
    private C0880a nvm;
    private master.flame.danmaku.danmaku.model.f nvn;
    private final Object nvo;
    private int nvp;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nvl = 2;
        this.nvo = new Object();
        NativeBitmapFactory.dSG();
        this.nvl = i;
        if (NativeBitmapFactory.dSF()) {
            this.nvl = i * 2;
        }
        this.nvm = new C0880a(i, 3);
        this.nwP.a(this.nvm);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nwQ = fVar;
        this.nvn = new master.flame.danmaku.danmaku.model.f();
        this.nvn.gq(fVar.nxI);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nvm != null) {
            this.nvm.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wT(boolean z) {
        super.wT(z);
        if (this.nvm != null) {
            this.nvm.dME();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nvm != null) {
            int i = this.nvp + 1;
            this.nvp = i;
            if (i > 5) {
                this.nvm.dMG();
                this.nvp = 0;
                return;
            }
            return;
        }
        n<?> dNo = dVar.dNo();
        if (dNo != null) {
            if (dNo.dNP()) {
                dNo.dNQ();
            } else {
                dNo.destroy();
            }
            dVar.nxx = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nvo) {
            this.nvo.notify();
        }
        if (a != null && this.nvm != null && a.nAs - a.nAt < -20) {
            this.nvm.dMG();
            this.nvm.gh(-this.nwh.nzu.nzz);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nvm == null) {
            start();
        }
        this.nvm.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dSG();
        if (this.nvm == null) {
            this.nvm = new C0880a(this.nvl, 3);
            this.nvm.dMy();
            this.nwP.a(this.nvm);
            return;
        }
        this.nvm.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nwP.a((k) null);
        if (this.nvm != null) {
            this.nvm.end();
            this.nvm = null;
        }
        NativeBitmapFactory.dSH();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nwn == null) {
            throw new AssertionError();
        }
        b(this.nwn);
        this.nvm.dMy();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void JX(int i) {
        super.JX(i);
        if (this.nvm != null) {
            this.nvm.JX(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void h(long j, long j2, long j3) {
        super.h(j, j2, j3);
        if (this.nvm != null) {
            this.nvm.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0880a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nvv;
        private HandlerC0881a nvw;
        master.flame.danmaku.danmaku.model.android.d nvr = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nvs = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nvt = master.flame.danmaku.danmaku.model.a.e.a(this.nvs, 800);
        private boolean nvx = false;
        private int nvu = 0;

        public C0880a(int i, int i2) {
            this.nvv = 3;
            this.mMaxSize = i;
            this.nvv = i2;
        }

        public void seek(long j) {
            if (this.nvw != null) {
                this.nvw.dMJ();
                this.nvw.removeMessages(3);
                this.nvw.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nvw != null) {
                if (dVar.nxy) {
                    if (dVar.nxz) {
                        if (!dVar.isTimeOut()) {
                            this.nvw.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nvw.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nvw.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dMy() {
            this.nvx = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nvw == null) {
                this.nvw = new HandlerC0881a(this.mThread.getLooper());
            }
            this.nvw.dMy();
        }

        public void end() {
            this.nvx = true;
            synchronized (a.this.nvo) {
                a.this.nvo.notifyAll();
            }
            if (this.nvw != null) {
                this.nvw.pause();
                this.nvw = null;
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
            if (this.nvw != null) {
                this.nvw.resume();
            } else {
                dMy();
            }
        }

        public void JX(int i) {
            if (this.nvw != null) {
                this.nvw.wW(i == 1);
            }
        }

        public float dMz() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nvu / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nvr != null) {
                this.nvr.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                        C0880a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nvr.clear();
            }
            this.nvu = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMA() {
            wU(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wU(final boolean z) {
            if (this.nvr != null) {
                this.nvr.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nxx;
                        boolean z2 = nVar != null && nVar.dNP();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0880a.this.nvu -= nVar.size();
                                nVar.destroy();
                            }
                            C0880a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dNp()) {
                            C0880a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dNo = dVar.dNo();
            if (dNo != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nwh.dNW().dNm().t(dVar);
                }
                if (c > 0) {
                    this.nvu = (int) (this.nvu - c);
                    this.nvt.c((master.flame.danmaku.danmaku.model.android.e) dNo);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nxx;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dNP()) {
                nVar.dNQ();
                dVar.nxx = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nxx = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nxx != null && !dVar.nxx.dNP()) {
                    return dVar.nxx.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMB() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dOn = this.nvt.dOn();
                if (dOn != null) {
                    dOn.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dNG = this.nvr.dNG();
            while (true) {
                if (this.nvu + i <= this.mMaxSize || dNG == null) {
                    break;
                } else if (dNG.isTimeOut()) {
                    a(false, dNG, dVar);
                    this.nvr.l(dNG);
                    dNG = this.nvr.dNG();
                } else if (!z) {
                    return false;
                }
            }
            this.nvr.k(dVar);
            this.nvu += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMC() {
            this.nvr.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nvo) {
                            try {
                                a.this.nvo.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0880a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nwr.dNL() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nvA;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dMH */
                public master.flame.danmaku.danmaku.model.d dMI() {
                    return this.nvA;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dNo = dVar2.dNo();
                    if (dNo == null || dNo.get() == null) {
                        return 0;
                    }
                    if (dVar2.nxq == dVar.nxq && dVar2.nxr == dVar.nxr && dVar2.nxo == dVar.nxo && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nvA = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dNo.dNP()) {
                                return 0;
                            }
                            float width = dNo.width() - dVar.nxq;
                            float height = dNo.height() - dVar.nxr;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nvA = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nvr.b(bVar);
            return bVar.dMI();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0881a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nvF;
            private boolean nvG;

            public HandlerC0881a(Looper looper) {
                super(looper);
            }

            public void dMJ() {
                this.nvG = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0880a.this.dMA();
                        for (int i = 0; i < 300; i++) {
                            C0880a.this.nvt.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nwO == null || a.this.nwU) || this.nvF;
                        wV(z);
                        if (z) {
                            this.nvF = false;
                        }
                        if (a.this.nwO != null && !a.this.nwU) {
                            a.this.nwO.dMW();
                            a.this.nwU = true;
                            return;
                        }
                        return;
                    case 4:
                        C0880a.this.dMC();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nvn.nxI;
                            a.this.nvn.gq(longValue);
                            this.nvF = true;
                            long dMD = C0880a.this.dMD();
                            if (longValue > j || dMD - longValue > a.this.nwh.nzu.nzz) {
                                C0880a.this.dMA();
                            } else {
                                C0880a.this.dMC();
                            }
                            wV(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0880a.this.evictAll();
                        C0880a.this.dMB();
                        getLooper().quit();
                        return;
                    case 7:
                        C0880a.this.evictAll();
                        a.this.nvn.gq(a.this.nwQ.nxI - a.this.nwh.nzu.nzz);
                        this.nvF = true;
                        return;
                    case 8:
                        C0880a.this.wU(true);
                        a.this.nvn.gq(a.this.nwQ.nxI);
                        return;
                    case 9:
                        C0880a.this.wU(true);
                        a.this.nvn.gq(a.this.nwQ.nxI);
                        a.this.dNb();
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
                            n<?> dNo = dVar.dNo();
                            if (!((dVar.nxF & 1) != 0) && dNo != null && dNo.get() != null && !dNo.dNP()) {
                                dVar.nxx = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nwr, (master.flame.danmaku.danmaku.model.android.e) dVar.nxx);
                                C0880a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.nxy) {
                                C0880a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dNo != null && dNo.dNP()) {
                                    dNo.destroy();
                                }
                                C0880a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nxx != null) {
                                C0880a.this.a(dVar2, dVar2.nxx.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nvG = false;
                        return;
                }
                long dMK = dMK();
                if (dMK <= 0) {
                    dMK = a.this.nwh.nzu.nzz / 2;
                }
                sendEmptyMessageDelayed(16, dMK);
            }

            private long dMK() {
                if (a.this.nvn.nxI <= a.this.nwQ.nxI - a.this.nwh.nzu.nzz) {
                    C0880a.this.dMA();
                    a.this.nvn.gq(a.this.nwQ.nxI);
                    sendEmptyMessage(3);
                } else {
                    float dMz = C0880a.this.dMz();
                    master.flame.danmaku.danmaku.model.d dNG = C0880a.this.nvr.dNG();
                    long dNy = dNG != null ? dNG.dNy() - a.this.nwQ.nxI : 0L;
                    long j = a.this.nwh.nzu.nzz * 2;
                    if (dMz < 0.6f && dNy > a.this.nwh.nzu.nzz) {
                        a.this.nvn.gq(a.this.nwQ.nxI);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dMz > 0.4f && dNy < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dMz < 0.9f) {
                        long j2 = a.this.nvn.nxI - a.this.nwQ.nxI;
                        if (dNG != null && dNG.isTimeOut() && j2 < (-a.this.nwh.nzu.nzz)) {
                            a.this.nvn.gq(a.this.nwQ.nxI);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nxx : eVar;
                dVar.nxx = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0880a.this.nvt.c(eVar2);
                }
            }

            private void dML() {
                l lVar = null;
                try {
                    long j = a.this.nwQ.nxI;
                    lVar = a.this.nwN.P(j - a.this.nwh.nzu.nzz, (a.this.nwh.nzu.nzz * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0881a.this.mPause || HandlerC0881a.this.nvG) {
                                return 1;
                            }
                            if (!dVar.dNr()) {
                                a.this.nwh.nzt.a(dVar, 0, 0, null, true, a.this.nwh);
                            }
                            if (dVar.dNs()) {
                                return 0;
                            }
                            if (!dVar.dNn()) {
                                dVar.a((m) a.this.nwr, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nwr, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nvy.nvq.nvn.gq(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wV(final boolean z) {
                l lVar;
                dML();
                final long j = a.this.nvn.nxI;
                long j2 = j + (a.this.nwh.nzu.nzz * C0880a.this.nvv);
                if (j2 < a.this.nwQ.nxI) {
                    return 0L;
                }
                final long dOv = master.flame.danmaku.danmaku.c.c.dOv();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nwN.P(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gs(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dNG = lVar.dNG();
                final master.flame.danmaku.danmaku.model.d dNH = lVar.dNH();
                if (dNG == null || dNH == null) {
                    a.this.nvn.gq(j2);
                    return 0L;
                }
                long dNy = dNG.dNy() - a.this.nwQ.nxI;
                final long min = Math.min(100L, dNy < 0 ? 30L : ((dNy * 10) / a.this.nwh.nzu.nzz) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nvI = 0;
                    int nvJ = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0881a.this.mPause || HandlerC0881a.this.nvG || dNH.dNy() < a.this.nwQ.nxI) {
                            return 1;
                        }
                        n<?> dNo = dVar2.dNo();
                        if (dNo == null || dNo.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dNp())) {
                                if (!dVar2.dNr()) {
                                    a.this.nwh.nzt.a(dVar2, this.nvI, size, null, true, a.this.nwh);
                                }
                                if (dVar2.nxp == 0 && dVar2.dNs()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dNy2 = (int) ((dVar2.dNy() - j) / a.this.nwh.nzu.nzz);
                                    if (this.nvJ == dNy2) {
                                        this.nvI++;
                                    } else {
                                        this.nvI = 0;
                                        this.nvJ = dNy2;
                                    }
                                }
                                if (!z && !HandlerC0881a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nvo) {
                                            a.this.nvo.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0881a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dOv2 = master.flame.danmaku.danmaku.c.c.dOv() - dOv;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nwh.nzu;
                                        if (dOv2 >= 10000 * C0880a.this.nvv) {
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
                long dOv2 = master.flame.danmaku.danmaku.c.c.dOv() - dOv;
                if (0 != 0) {
                    a.this.nvn.gq(dVar.dNy());
                    return dOv2;
                }
                a.this.nvn.gq(j2);
                return dOv2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dNn()) {
                    dVar.a((m) a.this.nwr, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nwr, C0880a.this.nvt.dOn());
                        dVar.nxx = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0880a.this.nvt.c(eVar);
                        }
                        dVar.nxx = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0880a.this.nvt.c(eVar);
                        }
                        dVar.nxx = null;
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
                if (!dVar.dNn()) {
                    dVar.a((m) a.this.nwr, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0880a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nxx : null;
                        try {
                            if (r3 != null) {
                                r3.dOi();
                                dVar.nxx = r3;
                                a.this.nvm.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0880a c0880a = C0880a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0880a.a(dVar, false, 50);
                            eVar = c0880a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nxx;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nxx = null;
                                    dVar.nxx = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nwr, r3);
                                    a.this.nvm.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.dT((int) dVar.nxq, (int) dVar.nxr) + C0880a.this.nvu <= C0880a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nwr, C0880a.this.nvt.dOn());
                                    dVar.nxx = a3;
                                    boolean a4 = a.this.nvm.a(dVar, C0880a.this.d(dVar), z);
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
                    if (dVar.dNy() <= a.this.nvn.nxI + a.this.nwh.nzu.nzz || dVar.nxy) {
                        if (dVar.nxp != 0 || !dVar.dNs()) {
                            n<?> dNo = dVar.dNo();
                            if (dNo == null || dNo.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dMy() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nwh.nzu.nzz);
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
                sendEmptyMessageDelayed(4, a.this.nwh.nzu.nzz);
            }

            public void gi(long j) {
                removeMessages(3);
                this.nvF = true;
                sendEmptyMessage(19);
                a.this.nvn.gq(a.this.nwQ.nxI + j);
                sendEmptyMessage(3);
            }

            public void wW(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dMD() {
            master.flame.danmaku.danmaku.model.d dNG;
            if (this.nvr == null || this.nvr.size() <= 0 || (dNG = this.nvr.dNG()) == null) {
                return 0L;
            }
            return dNG.dNy();
        }

        public void gh(long j) {
            if (this.nvw != null) {
                this.nvw.gi(j);
            }
        }

        public void dME() {
            if (this.nvw != null) {
                this.nvw.removeMessages(3);
                this.nvw.removeMessages(19);
                this.nvw.dMJ();
                this.nvw.removeMessages(7);
                this.nvw.sendEmptyMessage(7);
            }
        }

        public void dMF() {
            if (this.nvw != null) {
                this.nvw.removeMessages(9);
                this.nvw.sendEmptyMessage(9);
            }
        }

        public void dMG() {
            if (this.nvw != null) {
                this.nvw.removeMessages(4);
                this.nvw.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nvw != null) {
                this.nvw.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nwr.aM(this.nwh.nyS);
                dNb();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nvm != null)) {
                    this.nvm.gh(0L);
                }
                dNb();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nwr.aM(this.nwh.nyS);
                }
                if (this.nvm != null) {
                    this.nvm.dME();
                    this.nvm.gh(-this.nwh.nzu.nzz);
                }
            } else if (this.nvm != null) {
                this.nvm.dMF();
                this.nvm.gh(0L);
            }
        }
        if (this.nwO != null && this.nvm != null) {
            this.nvm.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nwO.dMY();
                }
            });
            return true;
        }
        return true;
    }
}
