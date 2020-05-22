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
    private int nua;
    private C0879a nub;
    private master.flame.danmaku.danmaku.model.f nuc;
    private final Object nud;
    private int nue;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nua = 2;
        this.nud = new Object();
        NativeBitmapFactory.dSs();
        this.nua = i;
        if (NativeBitmapFactory.dSr()) {
            this.nua = i * 2;
        }
        this.nub = new C0879a(i, 3);
        this.nvF.a(this.nub);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nvG = fVar;
        this.nuc = new master.flame.danmaku.danmaku.model.f();
        this.nuc.gq(fVar.nwy);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nub != null) {
            this.nub.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wR(boolean z) {
        super.wR(z);
        if (this.nub != null) {
            this.nub.dMq();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nub != null) {
            int i = this.nue + 1;
            this.nue = i;
            if (i > 5) {
                this.nub.dMs();
                this.nue = 0;
                return;
            }
            return;
        }
        n<?> dNa = dVar.dNa();
        if (dNa != null) {
            if (dNa.dNB()) {
                dNa.dNC();
            } else {
                dNa.destroy();
            }
            dVar.nwn = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nud) {
            this.nud.notify();
        }
        if (a != null && this.nub != null && a.nzi - a.nzj < -20) {
            this.nub.dMs();
            this.nub.gh(-this.nuX.nyk.nyp);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nub == null) {
            start();
        }
        this.nub.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dSs();
        if (this.nub == null) {
            this.nub = new C0879a(this.nua, 3);
            this.nub.dMk();
            this.nvF.a(this.nub);
            return;
        }
        this.nub.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nvF.a((k) null);
        if (this.nub != null) {
            this.nub.end();
            this.nub = null;
        }
        NativeBitmapFactory.dSt();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nvd == null) {
            throw new AssertionError();
        }
        b(this.nvd);
        this.nub.dMk();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void JV(int i) {
        super.JV(i);
        if (this.nub != null) {
            this.nub.JV(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void h(long j, long j2, long j3) {
        super.h(j, j2, j3);
        if (this.nub != null) {
            this.nub.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0879a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nuk;
        private HandlerC0880a nul;
        master.flame.danmaku.danmaku.model.android.d nug = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nuh = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nui = master.flame.danmaku.danmaku.model.a.e.a(this.nuh, 800);
        private boolean nun = false;
        private int nuj = 0;

        public C0879a(int i, int i2) {
            this.nuk = 3;
            this.mMaxSize = i;
            this.nuk = i2;
        }

        public void seek(long j) {
            if (this.nul != null) {
                this.nul.dMv();
                this.nul.removeMessages(3);
                this.nul.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nul != null) {
                if (dVar.nwo) {
                    if (dVar.nwp) {
                        if (!dVar.isTimeOut()) {
                            this.nul.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nul.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nul.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dMk() {
            this.nun = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nul == null) {
                this.nul = new HandlerC0880a(this.mThread.getLooper());
            }
            this.nul.dMk();
        }

        public void end() {
            this.nun = true;
            synchronized (a.this.nud) {
                a.this.nud.notifyAll();
            }
            if (this.nul != null) {
                this.nul.pause();
                this.nul = null;
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
            if (this.nul != null) {
                this.nul.resume();
            } else {
                dMk();
            }
        }

        public void JV(int i) {
            if (this.nul != null) {
                this.nul.wU(i == 1);
            }
        }

        public float dMl() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nuj / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nug != null) {
                this.nug.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                        C0879a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nug.clear();
            }
            this.nuj = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMm() {
            wS(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wS(final boolean z) {
            if (this.nug != null) {
                this.nug.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nwn;
                        boolean z2 = nVar != null && nVar.dNB();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0879a.this.nuj -= nVar.size();
                                nVar.destroy();
                            }
                            C0879a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dNb()) {
                            C0879a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dNa = dVar.dNa();
            if (dNa != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nuX.dNI().dMY().t(dVar);
                }
                if (c > 0) {
                    this.nuj = (int) (this.nuj - c);
                    this.nui.c((master.flame.danmaku.danmaku.model.android.e) dNa);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nwn;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dNB()) {
                nVar.dNC();
                dVar.nwn = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nwn = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nwn != null && !dVar.nwn.dNB()) {
                    return dVar.nwn.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMn() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dNZ = this.nui.dNZ();
                if (dNZ != null) {
                    dNZ.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dNs = this.nug.dNs();
            while (true) {
                if (this.nuj + i <= this.mMaxSize || dNs == null) {
                    break;
                } else if (dNs.isTimeOut()) {
                    a(false, dNs, dVar);
                    this.nug.l(dNs);
                    dNs = this.nug.dNs();
                } else if (!z) {
                    return false;
                }
            }
            this.nug.k(dVar);
            this.nuj += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dMo() {
            this.nug.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nud) {
                            try {
                                a.this.nud.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0879a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nvh.dNx() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nuq;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dMt */
                public master.flame.danmaku.danmaku.model.d dMu() {
                    return this.nuq;
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
                    n<?> dNa = dVar2.dNa();
                    if (dNa == null || dNa.get() == null) {
                        return 0;
                    }
                    if (dVar2.nwg == dVar.nwg && dVar2.nwh == dVar.nwh && dVar2.nwe == dVar.nwe && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nuq = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dNa.dNB()) {
                                return 0;
                            }
                            float width = dNa.width() - dVar.nwg;
                            float height = dNa.height() - dVar.nwh;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nuq = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nug.b(bVar);
            return bVar.dMu();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0880a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nuv;
            private boolean nuw;

            public HandlerC0880a(Looper looper) {
                super(looper);
            }

            public void dMv() {
                this.nuw = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0879a.this.dMm();
                        for (int i = 0; i < 300; i++) {
                            C0879a.this.nui.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nvE == null || a.this.nvK) || this.nuv;
                        wT(z);
                        if (z) {
                            this.nuv = false;
                        }
                        if (a.this.nvE != null && !a.this.nvK) {
                            a.this.nvE.dMI();
                            a.this.nvK = true;
                            return;
                        }
                        return;
                    case 4:
                        C0879a.this.dMo();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nuc.nwy;
                            a.this.nuc.gq(longValue);
                            this.nuv = true;
                            long dMp = C0879a.this.dMp();
                            if (longValue > j || dMp - longValue > a.this.nuX.nyk.nyp) {
                                C0879a.this.dMm();
                            } else {
                                C0879a.this.dMo();
                            }
                            wT(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0879a.this.evictAll();
                        C0879a.this.dMn();
                        getLooper().quit();
                        return;
                    case 7:
                        C0879a.this.evictAll();
                        a.this.nuc.gq(a.this.nvG.nwy - a.this.nuX.nyk.nyp);
                        this.nuv = true;
                        return;
                    case 8:
                        C0879a.this.wS(true);
                        a.this.nuc.gq(a.this.nvG.nwy);
                        return;
                    case 9:
                        C0879a.this.wS(true);
                        a.this.nuc.gq(a.this.nvG.nwy);
                        a.this.dMN();
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
                            n<?> dNa = dVar.dNa();
                            if (!((dVar.nwv & 1) != 0) && dNa != null && dNa.get() != null && !dNa.dNB()) {
                                dVar.nwn = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nvh, (master.flame.danmaku.danmaku.model.android.e) dVar.nwn);
                                C0879a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.nwo) {
                                C0879a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dNa != null && dNa.dNB()) {
                                    dNa.destroy();
                                }
                                C0879a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nwn != null) {
                                C0879a.this.a(dVar2, dVar2.nwn.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nuw = false;
                        return;
                }
                long dMw = dMw();
                if (dMw <= 0) {
                    dMw = a.this.nuX.nyk.nyp / 2;
                }
                sendEmptyMessageDelayed(16, dMw);
            }

            private long dMw() {
                if (a.this.nuc.nwy <= a.this.nvG.nwy - a.this.nuX.nyk.nyp) {
                    C0879a.this.dMm();
                    a.this.nuc.gq(a.this.nvG.nwy);
                    sendEmptyMessage(3);
                } else {
                    float dMl = C0879a.this.dMl();
                    master.flame.danmaku.danmaku.model.d dNs = C0879a.this.nug.dNs();
                    long dNk = dNs != null ? dNs.dNk() - a.this.nvG.nwy : 0L;
                    long j = a.this.nuX.nyk.nyp * 2;
                    if (dMl < 0.6f && dNk > a.this.nuX.nyk.nyp) {
                        a.this.nuc.gq(a.this.nvG.nwy);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dMl > 0.4f && dNk < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dMl < 0.9f) {
                        long j2 = a.this.nuc.nwy - a.this.nvG.nwy;
                        if (dNs != null && dNs.isTimeOut() && j2 < (-a.this.nuX.nyk.nyp)) {
                            a.this.nuc.gq(a.this.nvG.nwy);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nwn : eVar;
                dVar.nwn = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0879a.this.nui.c(eVar2);
                }
            }

            private void dMx() {
                l lVar = null;
                try {
                    long j = a.this.nvG.nwy;
                    lVar = a.this.nvD.P(j - a.this.nuX.nyk.nyp, (a.this.nuX.nyk.nyp * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0880a.this.mPause || HandlerC0880a.this.nuw) {
                                return 1;
                            }
                            if (!dVar.dNd()) {
                                a.this.nuX.nyj.a(dVar, 0, 0, null, true, a.this.nuX);
                            }
                            if (dVar.dNe()) {
                                return 0;
                            }
                            if (!dVar.dMZ()) {
                                dVar.a((m) a.this.nvh, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nvh, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nuo.nuf.nuc.gq(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wT(final boolean z) {
                l lVar;
                dMx();
                final long j = a.this.nuc.nwy;
                long j2 = j + (a.this.nuX.nyk.nyp * C0879a.this.nuk);
                if (j2 < a.this.nvG.nwy) {
                    return 0L;
                }
                final long dOh = master.flame.danmaku.danmaku.c.c.dOh();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nvD.P(j, j2);
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
                master.flame.danmaku.danmaku.model.d dNs = lVar.dNs();
                final master.flame.danmaku.danmaku.model.d dNt = lVar.dNt();
                if (dNs == null || dNt == null) {
                    a.this.nuc.gq(j2);
                    return 0L;
                }
                long dNk = dNs.dNk() - a.this.nvG.nwy;
                final long min = Math.min(100L, dNk < 0 ? 30L : ((dNk * 10) / a.this.nuX.nyk.nyp) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nuy = 0;
                    int nuz = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bL(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0880a.this.mPause || HandlerC0880a.this.nuw || dNt.dNk() < a.this.nvG.nwy) {
                            return 1;
                        }
                        n<?> dNa = dVar2.dNa();
                        if (dNa == null || dNa.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dNb())) {
                                if (!dVar2.dNd()) {
                                    a.this.nuX.nyj.a(dVar2, this.nuy, size, null, true, a.this.nuX);
                                }
                                if (dVar2.nwf == 0 && dVar2.dNe()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dNk2 = (int) ((dVar2.dNk() - j) / a.this.nuX.nyk.nyp);
                                    if (this.nuz == dNk2) {
                                        this.nuy++;
                                    } else {
                                        this.nuy = 0;
                                        this.nuz = dNk2;
                                    }
                                }
                                if (!z && !HandlerC0880a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nud) {
                                            a.this.nud.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0880a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dOh2 = master.flame.danmaku.danmaku.c.c.dOh() - dOh;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nuX.nyk;
                                        if (dOh2 >= 10000 * C0879a.this.nuk) {
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
                long dOh2 = master.flame.danmaku.danmaku.c.c.dOh() - dOh;
                if (0 != 0) {
                    a.this.nuc.gq(dVar.dNk());
                    return dOh2;
                }
                a.this.nuc.gq(j2);
                return dOh2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dMZ()) {
                    dVar.a((m) a.this.nvh, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nvh, C0879a.this.nui.dNZ());
                        dVar.nwn = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0879a.this.nui.c(eVar);
                        }
                        dVar.nwn = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0879a.this.nui.c(eVar);
                        }
                        dVar.nwn = null;
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
                if (!dVar.dMZ()) {
                    dVar.a((m) a.this.nvh, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0879a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nwn : null;
                        try {
                            if (r3 != null) {
                                r3.dNU();
                                dVar.nwn = r3;
                                a.this.nub.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0879a c0879a = C0879a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0879a.a(dVar, false, 50);
                            eVar = c0879a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nwn;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nwn = null;
                                    dVar.nwn = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nvh, r3);
                                    a.this.nub.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.dT((int) dVar.nwg, (int) dVar.nwh) + C0879a.this.nuj <= C0879a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nvh, C0879a.this.nui.dNZ());
                                    dVar.nwn = a3;
                                    boolean a4 = a.this.nub.a(dVar, C0879a.this.d(dVar), z);
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
                    if (dVar.dNk() <= a.this.nuc.nwy + a.this.nuX.nyk.nyp || dVar.nwo) {
                        if (dVar.nwf != 0 || !dVar.dNe()) {
                            n<?> dNa = dVar.dNa();
                            if (dNa == null || dNa.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dMk() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nuX.nyk.nyp);
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
                sendEmptyMessageDelayed(4, a.this.nuX.nyk.nyp);
            }

            public void gi(long j) {
                removeMessages(3);
                this.nuv = true;
                sendEmptyMessage(19);
                a.this.nuc.gq(a.this.nvG.nwy + j);
                sendEmptyMessage(3);
            }

            public void wU(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dMp() {
            master.flame.danmaku.danmaku.model.d dNs;
            if (this.nug == null || this.nug.size() <= 0 || (dNs = this.nug.dNs()) == null) {
                return 0L;
            }
            return dNs.dNk();
        }

        public void gh(long j) {
            if (this.nul != null) {
                this.nul.gi(j);
            }
        }

        public void dMq() {
            if (this.nul != null) {
                this.nul.removeMessages(3);
                this.nul.removeMessages(19);
                this.nul.dMv();
                this.nul.removeMessages(7);
                this.nul.sendEmptyMessage(7);
            }
        }

        public void dMr() {
            if (this.nul != null) {
                this.nul.removeMessages(9);
                this.nul.sendEmptyMessage(9);
            }
        }

        public void dMs() {
            if (this.nul != null) {
                this.nul.removeMessages(4);
                this.nul.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nul != null) {
                this.nul.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nvh.aM(this.nuX.nxI);
                dMN();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nub != null)) {
                    this.nub.gh(0L);
                }
                dMN();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nvh.aM(this.nuX.nxI);
                }
                if (this.nub != null) {
                    this.nub.dMq();
                    this.nub.gh(-this.nuX.nyk.nyp);
                }
            } else if (this.nub != null) {
                this.nub.dMr();
                this.nub.gh(0L);
            }
        }
        if (this.nvE != null && this.nub != null) {
            this.nub.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nvE.dMK();
                }
            });
            return true;
        }
        return true;
    }
}
