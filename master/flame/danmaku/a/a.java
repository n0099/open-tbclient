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
    private int pVq;
    private C1083a pVr;
    private master.flame.danmaku.danmaku.model.f pVs;
    private final Object pVt;
    private int pVu;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.pVq = 2;
        this.pVt = new Object();
        NativeBitmapFactory.eIu();
        this.pVq = i;
        if (NativeBitmapFactory.eIt()) {
            this.pVq = i * 2;
        }
        this.pVr = new C1083a(i, 3);
        this.pWU.a(this.pVr);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pWV = fVar;
        this.pVs = new master.flame.danmaku.danmaku.model.f();
        this.pVs.is(fVar.pXL);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.pVr != null) {
            this.pVr.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Bc(boolean z) {
        super.Bc(z);
        if (this.pVr != null) {
            this.pVr.eCu();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.pVr != null) {
            int i = this.pVu + 1;
            this.pVu = i;
            if (i > 5) {
                this.pVr.eCw();
                this.pVu = 0;
                return;
            }
            return;
        }
        n<?> eDe = dVar.eDe();
        if (eDe != null) {
            if (eDe.eDG()) {
                eDe.eDH();
            } else {
                eDe.destroy();
            }
            dVar.pXB = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a2 = super.a(bVar);
        synchronized (this.pVt) {
            this.pVt.notify();
        }
        if (a2 != null && this.pVr != null && a2.qat - a2.qau < -20) {
            this.pVr.eCw();
            this.pVr.ij(-this.pWm.pZw.pZB);
        }
        return a2;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.pVr == null) {
            start();
        }
        this.pVr.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eIu();
        if (this.pVr == null) {
            this.pVr = new C1083a(this.pVq, 3);
            this.pVr.eCo();
            this.pWU.a(this.pVr);
            return;
        }
        this.pVr.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.pWU.a((k) null);
        if (this.pVr != null) {
            this.pVr.end();
            this.pVr = null;
        }
        NativeBitmapFactory.eIv();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pWs == null) {
            throw new AssertionError();
        }
        b(this.pWs);
        this.pVr.eCo();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Sb(int i) {
        super.Sb(i);
        if (this.pVr != null) {
            this.pVr.Sb(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.pVr != null) {
            this.pVr.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1083a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int pVA;
        private HandlerC1084a pVB;
        master.flame.danmaku.danmaku.model.android.d pVw = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g pVx = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> pVy = master.flame.danmaku.danmaku.model.a.e.a(this.pVx, 800);
        private boolean pVC = false;
        private int pVz = 0;

        public C1083a(int i, int i2) {
            this.pVA = 3;
            this.mMaxSize = i;
            this.pVA = i2;
        }

        public void seek(long j) {
            if (this.pVB != null) {
                this.pVB.eCz();
                this.pVB.removeMessages(3);
                this.pVB.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.pVB != null) {
                if (dVar.lbl) {
                    if (dVar.pXC) {
                        if (!dVar.eDf()) {
                            this.pVB.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.pVB.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.pVB.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void eCo() {
            this.pVC = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.pVB == null) {
                this.pVB = new HandlerC1084a(this.mThread.getLooper());
            }
            this.pVB.eCo();
        }

        public void end() {
            this.pVC = true;
            synchronized (a.this.pVt) {
                a.this.pVt.notifyAll();
            }
            if (this.pVB != null) {
                this.pVB.pause();
                this.pVB = null;
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
            if (this.pVB != null) {
                this.pVB.resume();
            } else {
                eCo();
            }
        }

        public void Sb(int i) {
            if (this.pVB != null) {
                this.pVB.Bf(i == 1);
            }
        }

        public float eCp() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.pVz / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.pVw != null) {
                this.pVw.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                        C1083a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.pVw.clear();
            }
            this.pVz = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCq() {
            Bd(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bd(final boolean z) {
            if (this.pVw != null) {
                this.pVw.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.pXB;
                        boolean z2 = nVar != null && nVar.eDG();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C1083a.this.pVz -= nVar.size();
                                nVar.destroy();
                            }
                            C1083a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.eDg()) {
                            C1083a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> eDe = dVar.eDe();
            if (eDe != null) {
                long c = c(dVar);
                if (dVar.eDf()) {
                    a.this.pWm.eDN().eDc().t(dVar);
                }
                if (c > 0) {
                    this.pVz = (int) (this.pVz - c);
                    this.pVy.c((master.flame.danmaku.danmaku.model.android.e) eDe);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.pXB;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.eDG()) {
                nVar.eDH();
                dVar.pXB = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.pXB = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.pXB != null && !dVar.pXB.eDG()) {
                    return dVar.pXB.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCr() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eEe = this.pVy.eEe();
                if (eEe != null) {
                    eEe.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d eDx = this.pVw.eDx();
            while (true) {
                if (this.pVz + i <= this.mMaxSize || eDx == null) {
                    break;
                } else if (eDx.eDf()) {
                    a(false, eDx, dVar);
                    this.pVw.l(eDx);
                    eDx = this.pVw.eDx();
                } else if (!z) {
                    return false;
                }
            }
            this.pVw.k(dVar);
            this.pVz += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCs() {
            this.pVw.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.eDf()) {
                        synchronized (a.this.pVt) {
                            try {
                                a.this.pVt.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C1083a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.pWw.eDC() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d pVF;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: eCx */
                public master.flame.danmaku.danmaku.model.d eCy() {
                    return this.pVF;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bY(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> eDe = dVar2.eDe();
                    if (eDe == null || eDe.get() == null) {
                        return 0;
                    }
                    if (dVar2.pXu == dVar.pXu && dVar2.pXv == dVar.pXv && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.pVF = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.eDf()) {
                            if (eDe.eDG()) {
                                return 0;
                            }
                            float width = eDe.width() - dVar.pXu;
                            float height = eDe.height() - dVar.pXv;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.pVF = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.pVw.b(bVar);
            return bVar.eCy();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC1084a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean pVK;
            private boolean pVL;

            public HandlerC1084a(Looper looper) {
                super(looper);
            }

            public void eCz() {
                this.pVL = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C1083a.this.eCq();
                        for (int i = 0; i < 300; i++) {
                            C1083a.this.pVy.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.pWT == null || a.this.pWZ) || this.pVK;
                        Be(z);
                        if (z) {
                            this.pVK = false;
                        }
                        if (a.this.pWT != null && !a.this.pWZ) {
                            a.this.pWT.eCM();
                            a.this.pWZ = true;
                            return;
                        }
                        return;
                    case 4:
                        C1083a.this.eCs();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.pVs.pXL;
                            a.this.pVs.is(longValue);
                            this.pVK = true;
                            long eCt = C1083a.this.eCt();
                            if (longValue > j || eCt - longValue > a.this.pWm.pZw.pZB) {
                                C1083a.this.eCq();
                            } else {
                                C1083a.this.eCs();
                            }
                            Be(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C1083a.this.evictAll();
                        C1083a.this.eCr();
                        getLooper().quit();
                        return;
                    case 7:
                        C1083a.this.evictAll();
                        a.this.pVs.is(a.this.pWV.pXL - a.this.pWm.pZw.pZB);
                        this.pVK = true;
                        return;
                    case 8:
                        C1083a.this.Bd(true);
                        a.this.pVs.is(a.this.pWV.pXL);
                        return;
                    case 9:
                        C1083a.this.Bd(true);
                        a.this.pVs.is(a.this.pWV.pXL);
                        a.this.eCR();
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
                            n<?> eDe = dVar.eDe();
                            if (!((dVar.pXI & 1) != 0) && eDe != null && eDe.get() != null && !eDe.eDG()) {
                                dVar.pXB = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pWw, (master.flame.danmaku.danmaku.model.android.e) dVar.pXB);
                                C1083a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.lbl) {
                                C1083a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (eDe != null && eDe.eDG()) {
                                    eDe.destroy();
                                }
                                C1083a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.eDf()) {
                            f(dVar2);
                            if (dVar2.pXB != null) {
                                C1083a.this.a(dVar2, dVar2.pXB.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.pVL = false;
                        return;
                }
                long eCA = eCA();
                if (eCA <= 0) {
                    eCA = a.this.pWm.pZw.pZB / 2;
                }
                sendEmptyMessageDelayed(16, eCA);
            }

            private long eCA() {
                if (a.this.pVs.pXL <= a.this.pWV.pXL - a.this.pWm.pZw.pZB) {
                    C1083a.this.eCq();
                    a.this.pVs.is(a.this.pWV.pXL);
                    sendEmptyMessage(3);
                } else {
                    float eCp = C1083a.this.eCp();
                    master.flame.danmaku.danmaku.model.d eDx = C1083a.this.pVw.eDx();
                    long eDp = eDx != null ? eDx.eDp() - a.this.pWV.pXL : 0L;
                    long j = a.this.pWm.pZw.pZB * 2;
                    if (eCp < 0.6f && eDp > a.this.pWm.pZw.pZB) {
                        a.this.pVs.is(a.this.pWV.pXL);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (eCp > 0.4f && eDp < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (eCp < 0.9f) {
                        long j2 = a.this.pVs.pXL - a.this.pWV.pXL;
                        if (eDx != null && eDx.eDf() && j2 < (-a.this.pWm.pZw.pZB)) {
                            a.this.pVs.is(a.this.pWV.pXL);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.pXB : eVar;
                dVar.pXB = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C1083a.this.pVy.c(eVar2);
                }
            }

            private void eCB() {
                l lVar = null;
                try {
                    long j = a.this.pWV.pXL;
                    lVar = a.this.pWS.R(j - a.this.pWm.pZw.pZB, (a.this.pWm.pZw.pZB * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC1084a.this.mPause || HandlerC1084a.this.pVL) {
                                return 1;
                            }
                            if (!dVar.eDi()) {
                                a.this.pWm.pZv.a(dVar, 0, 0, null, true, a.this.pWm);
                            }
                            if (dVar.eDj()) {
                                return 0;
                            }
                            if (!dVar.eDd()) {
                                dVar.a((m) a.this.pWw, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.pWw, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.pVD.pVv.pVs.is(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long Be(final boolean z) {
                l lVar;
                eCB();
                final long j = a.this.pVs.pXL;
                long j2 = j + (a.this.pWm.pZw.pZB * C1083a.this.pVA);
                if (j2 < a.this.pWV.pXL) {
                    return 0L;
                }
                final long eEm = master.flame.danmaku.danmaku.c.c.eEm();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.pWS.R(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.iu(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d eDx = lVar.eDx();
                final master.flame.danmaku.danmaku.model.d eDy = lVar.eDy();
                if (eDx == null || eDy == null) {
                    a.this.pVs.is(j2);
                    return 0L;
                }
                long eDp = eDx.eDp() - a.this.pWV.pXL;
                final long min = Math.min(100L, eDp < 0 ? 30L : ((eDp * 10) / a.this.pWm.pZw.pZB) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int pVN = 0;
                    int pVO = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bY(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC1084a.this.mPause || HandlerC1084a.this.pVL || eDy.eDp() < a.this.pWV.pXL) {
                            return 1;
                        }
                        n<?> eDe = dVar2.eDe();
                        if (eDe == null || eDe.get() == null) {
                            if (z || (!dVar2.eDf() && dVar2.eDg())) {
                                if (!dVar2.eDi()) {
                                    a.this.pWm.pZv.a(dVar2, this.pVN, size, null, true, a.this.pWm);
                                }
                                if (dVar2.pXt == 0 && dVar2.eDj()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int eDp2 = (int) ((dVar2.eDp() - j) / a.this.pWm.pZw.pZB);
                                    if (this.pVO == eDp2) {
                                        this.pVN++;
                                    } else {
                                        this.pVN = 0;
                                        this.pVO = eDp2;
                                    }
                                }
                                if (!z && !HandlerC1084a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.pVt) {
                                            a.this.pVt.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC1084a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eEm2 = master.flame.danmaku.danmaku.c.c.eEm() - eEm;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.pWm.pZw;
                                        if (eEm2 >= 10000 * C1083a.this.pVA) {
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
                long eEm2 = master.flame.danmaku.danmaku.c.c.eEm() - eEm;
                if (0 != 0) {
                    a.this.pVs.is(dVar.eDp());
                    return eEm2;
                }
                a.this.pVs.is(j2);
                return eEm2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.eDd()) {
                    dVar.a((m) a.this.pWw, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pWw, C1083a.this.pVy.eEe());
                        dVar.pXB = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C1083a.this.pVy.c(eVar);
                        }
                        dVar.pXB = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C1083a.this.pVy.c(eVar);
                        }
                        dVar.pXB = null;
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
                if (!dVar.eDd()) {
                    dVar.a((m) a.this.pWw, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a2 = C1083a.this.a(dVar, true, 20);
                        r3 = a2 != null ? (master.flame.danmaku.danmaku.model.android.e) a2.pXB : null;
                        try {
                            if (r3 != null) {
                                r3.eDZ();
                                dVar.pXB = r3;
                                a.this.pVr.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C1083a c1083a = C1083a.this;
                            master.flame.danmaku.danmaku.model.d a3 = c1083a.a(dVar, false, 50);
                            eVar = c1083a;
                            if (a3 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a3.pXB;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a3.pXB = null;
                                    dVar.pXB = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pWw, r3);
                                    a.this.pVr.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eC((int) dVar.pXu, (int) dVar.pXv) + C1083a.this.pVz <= C1083a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a4 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pWw, C1083a.this.pVy.eEe());
                                    dVar.pXB = a4;
                                    boolean a5 = a.this.pVr.a(dVar, C1083a.this.d(dVar), z);
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
                if (!dVar.eDf()) {
                    if (dVar.eDp() <= a.this.pVs.pXL + a.this.pWm.pZw.pZB || dVar.lbl) {
                        if (dVar.pXt != 0 || !dVar.eDj()) {
                            n<?> eDe = dVar.eDe();
                            if (eDe == null || eDe.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void eCo() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.pWm.pZw.pZB);
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
                sendEmptyMessageDelayed(4, a.this.pWm.pZw.pZB);
            }

            public void ik(long j) {
                removeMessages(3);
                this.pVK = true;
                sendEmptyMessage(19);
                a.this.pVs.is(a.this.pWV.pXL + j);
                sendEmptyMessage(3);
            }

            public void Bf(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long eCt() {
            master.flame.danmaku.danmaku.model.d eDx;
            if (this.pVw == null || this.pVw.size() <= 0 || (eDx = this.pVw.eDx()) == null) {
                return 0L;
            }
            return eDx.eDp();
        }

        public void ij(long j) {
            if (this.pVB != null) {
                this.pVB.ik(j);
            }
        }

        public void eCu() {
            if (this.pVB != null) {
                this.pVB.removeMessages(3);
                this.pVB.removeMessages(19);
                this.pVB.eCz();
                this.pVB.removeMessages(7);
                this.pVB.sendEmptyMessage(7);
            }
        }

        public void eCv() {
            if (this.pVB != null) {
                this.pVB.removeMessages(9);
                this.pVB.sendEmptyMessage(9);
            }
        }

        public void eCw() {
            if (this.pVB != null) {
                this.pVB.removeMessages(4);
                this.pVB.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.pVB != null) {
                this.pVB.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.pWw.bE(this.pWm.pYU);
                eCR();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.pVr != null)) {
                    this.pVr.ij(0L);
                }
                eCR();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.pWw.bE(this.pWm.pYU);
                }
                if (this.pVr != null) {
                    this.pVr.eCu();
                    this.pVr.ij(-this.pWm.pZw.pZB);
                }
            } else if (this.pVr != null) {
                this.pVr.eCv();
                this.pVr.ij(0L);
            }
        }
        if (this.pWT != null && this.pVr != null) {
            this.pVr.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pWT.eCO();
                }
            });
            return true;
        }
        return true;
    }
}
