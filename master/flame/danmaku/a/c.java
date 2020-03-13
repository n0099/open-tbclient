package master.flame.danmaku.a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import java.util.LinkedList;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
import tv.cjump.jni.DeviceUtils;
/* loaded from: classes5.dex */
public class c extends Handler {
    private boolean mReady;
    private DanmakuContext nEE;
    private long nEF;
    private boolean nEG;
    private long nEH;
    private a nEI;
    private master.flame.danmaku.danmaku.model.f nEJ;
    private master.flame.danmaku.danmaku.a.a nEK;
    public h nEL;
    private g nEM;
    private boolean nEN;
    private master.flame.danmaku.danmaku.model.b nEO;
    private final a.b nEP;
    private LinkedList<Long> nEQ;
    private i nER;
    private final boolean nES;
    private long nET;
    private long nEU;
    private long nEV;
    private long nEW;
    private long nEX;
    private boolean nEY;
    private long nEZ;
    private long nFa;
    private boolean nFb;
    private boolean nFc;
    private boolean nFd;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dLu();

        void dLv();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nEF = 0L;
        this.nEG = true;
        this.nEJ = new master.flame.danmaku.danmaku.model.f();
        this.nEN = true;
        this.nEP = new a.b();
        this.nEQ = new LinkedList<>();
        this.nET = 30L;
        this.nEU = 60L;
        this.nEV = 16L;
        this.nES = Runtime.getRuntime().availableProcessors() > 3;
        this.nFd = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wK(false);
        }
        this.nEN = z;
    }

    private void a(g gVar) {
        this.nEM = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nEE = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEK = aVar;
    }

    public void setCallback(a aVar) {
        this.nEI = aVar;
    }

    public void quit() {
        this.nEG = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nEG;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019c  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        Long l;
        boolean z;
        int i = message.what;
        switch (i) {
            case 1:
                l = (Long) message.obj;
                if (l == null) {
                    this.nEF = l.longValue();
                } else {
                    this.nEF = 0L;
                }
                if (i == 4) {
                    this.nEG = true;
                    dLi();
                    Long l2 = (Long) message.obj;
                    this.nEH -= l2.longValue() - this.nEJ.nGe;
                    this.nEJ.hn(l2.longValue());
                    this.nEE.nHM.dLW();
                    if (this.nEL != null) {
                        this.nEL.seek(l2.longValue());
                    }
                    this.nEF = l2.longValue();
                }
                removeMessages(7);
                this.nEG = false;
                if (!this.mReady) {
                    this.nEP.reset();
                    this.nEQ.clear();
                    this.nEH = master.flame.danmaku.danmaku.c.c.dMQ() - this.nEF;
                    this.nEJ.hn(this.nEF);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nEL.start();
                    dLo();
                    this.nEY = false;
                    if (this.nEL != null) {
                        this.nEL.NK(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nES) {
                    dLk();
                    return;
                } else {
                    dLj();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nEG = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nEG = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nEH = master.flame.danmaku.danmaku.c.c.dMQ();
                if (this.nEK == null || !this.nEM.dLz()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nEF = 0L;
                            c.this.mReady = true;
                            if (c.this.nEI != null) {
                                c.this.nEI.dLu();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nEG = true;
                dLl();
                this.nEF = this.nEJ.nGe;
                if (this.nER != null) {
                    dLo();
                    dLi();
                }
                if (i == 6) {
                    if (this.nEL != null) {
                        this.nEL.quit();
                    }
                    if (this.nEK != null) {
                        this.nEK.release();
                    }
                    if (getLooper() != Looper.getMainLooper()) {
                        getLooper().quit();
                        return;
                    }
                    return;
                }
                return;
            case 7:
                removeMessages(3);
                removeMessages(2);
                if (this.nEL != null) {
                    this.nEL.NK(2);
                }
                if (i == 6) {
                }
                this.nEG = true;
                dLl();
                this.nEF = this.nEJ.nGe;
                if (this.nER != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nEN = true;
                Long l3 = (Long) message.obj;
                if (this.nEL == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nEJ.hn(getCurrentTime());
                    this.nEL.dLw();
                    z = false;
                } else {
                    this.nEL.start();
                    this.nEL.seek(l3.longValue());
                    this.nEL.dLw();
                    z = true;
                }
                if (this.nEG && this.nEM != null) {
                    this.nEM.dLA();
                }
                dLo();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nEG = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nEN = false;
                if (this.nEM != null) {
                    this.nEM.clear();
                }
                if (this.nEL != null) {
                    this.nEL.dLw();
                    this.nEL.dLy();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nEL != null) {
                    this.nEL.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nEL != null) {
                }
                if (i == 6) {
                }
                this.nEG = true;
                dLl();
                this.nEF = this.nEJ.nGe;
                if (this.nER != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nEE.nHO.b(this.nEE);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nEE.nHM.dLW();
                    this.nEE.nHM.dLV();
                    this.nEL.dLx();
                    return;
                }
                return;
            case 11:
                dLo();
                return;
            case 12:
                if (this.nEG && this.nEM != null) {
                    this.nEL.dLw();
                    this.nEM.dLA();
                    dLo();
                    return;
                }
                return;
            case 13:
                if (this.nEL != null) {
                    this.nEL.hj(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dLi() {
        if (this.nER != null) {
            i iVar = this.nER;
            this.nER = null;
            synchronized (this.nEL) {
                this.nEL.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dLj() {
        if (!this.nEG) {
            long hg = hg(master.flame.danmaku.danmaku.c.c.dMQ());
            if (hg < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hg);
                return;
            }
            long dLA = this.nEM.dLA();
            removeMessages(2);
            if (dLA > this.nEU) {
                this.nEJ.ho(dLA);
                this.nEQ.clear();
            }
            if (!this.nEN) {
                hh(10000000L);
                return;
            }
            if (this.nEP.nIQ && this.nFd) {
                long j = this.nEP.endTime - this.nEJ.nGe;
                if (j > 500) {
                    hh(j - 10);
                    return;
                }
            }
            if (dLA < this.nEV) {
                sendEmptyMessageDelayed(2, this.nEV - dLA);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dLk() {
        if (this.nER == null) {
            this.nER = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dMQ = master.flame.danmaku.danmaku.c.c.dMQ();
                    while (!dLC() && !c.this.nEG) {
                        long dMQ2 = master.flame.danmaku.danmaku.c.c.dMQ();
                        if (c.this.nEV - (master.flame.danmaku.danmaku.c.c.dMQ() - dMQ) <= 1) {
                            long hg = c.this.hg(dMQ2);
                            if (hg >= 0) {
                                long dLA = c.this.nEM.dLA();
                                if (dLA > c.this.nEU) {
                                    c.this.nEJ.ho(dLA);
                                    c.this.nEQ.clear();
                                }
                                if (!c.this.nEN) {
                                    c.this.hh(10000000L);
                                } else if (c.this.nEP.nIQ && c.this.nFd) {
                                    long j = c.this.nEP.endTime - c.this.nEJ.nGe;
                                    if (j > 500) {
                                        c.this.dLo();
                                        c.this.hh(j - 10);
                                    }
                                }
                                dMQ = dMQ2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hp(60 - hg);
                                dMQ = dMQ2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hp(1L);
                        }
                    }
                }
            };
            this.nER.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hg(long j) {
        long j2;
        long j3 = 0;
        if (this.nEY || this.nFb) {
            return 0L;
        }
        this.nFb = true;
        long j4 = j - this.nEH;
        if (!this.nEN || this.nEP.nIQ || this.nFc) {
            this.nEJ.hn(j4);
            this.nFa = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nEJ.nGe;
            long max = Math.max(this.nEV, dLp());
            if (j2 <= 2000 && this.nEP.nIP <= this.nET && max <= this.nET) {
                long min = Math.min(this.nET, Math.max(this.nEV, (j2 / this.nEV) + max));
                long j5 = min - this.nEX;
                if (j5 > 3 && j5 < 8 && this.nEX >= this.nEV && this.nEX <= this.nET) {
                    min = this.nEX;
                }
                long j6 = j2 - min;
                this.nEX = min;
                j2 = min;
                j3 = j6;
            }
            this.nFa = j3;
            this.nEJ.ho(j2);
        }
        if (this.nEI != null) {
            this.nEI.b(this.nEJ);
        }
        this.nFb = false;
        return j2;
    }

    private void dLl() {
        if (this.nFc) {
            hg(master.flame.danmaku.danmaku.c.c.dMQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLm() {
        this.nET = Math.max(33L, ((float) 16) * 2.5f);
        this.nEU = ((float) this.nET) * 2.5f;
        this.nEV = Math.max(16L, (16 / 15) * 15);
        this.nEW = this.nEV + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nEL == null) {
            this.nEL = a(this.nEM.dLB(), this.nEJ, this.nEM.getContext(), this.nEM.getWidth(), this.nEM.getHeight(), this.nEM.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dLr() {
                    c.this.dLm();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dLT = dVar.dLT() - c.this.getCurrentTime();
                        if (dLT < c.this.nEE.nHO.nHT && (c.this.nFc || c.this.nEP.nIQ)) {
                            c.this.dLo();
                        } else if (dLT > 0 && dLT <= c.this.nEE.nHO.nHT) {
                            c.this.sendEmptyMessageDelayed(11, dLT);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nEI != null) {
                        c.this.nEI.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLs() {
                    if (c.this.nEI != null) {
                        c.this.nEI.dLv();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLt() {
                    c.this.dLn();
                }
            });
        } else {
            runnable.run();
        }
    }

    public boolean isPrepared() {
        return this.mReady;
    }

    private h a(boolean z, master.flame.danmaku.danmaku.model.f fVar, Context context, int i, int i2, boolean z2, h.a aVar) {
        this.nEO = this.nEE.dMr();
        this.nEO.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nEO.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nEO.bG(this.nEE.nHm);
        this.nEO.wM(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nEE, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nEE, aVar);
        aVar2.a(this.nEK);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nEL != null) {
            dVar.nGa = this.nEE.nHM;
            dVar.c(this.nEJ);
            this.nEL.a(dVar);
            obtainMessage(11).sendToTarget();
        }
    }

    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void prepare() {
        this.mReady = false;
        sendEmptyMessage(5);
    }

    public void pause() {
        removeMessages(3);
        dLl();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nEN) {
            this.nEN = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wK(boolean z) {
        if (!this.nEN) {
            return this.nEJ.nGe;
        }
        this.nEN = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nEJ.nGe;
    }

    public a.b ak(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dLG;
        if (this.nEL == null) {
            return this.nEP;
        }
        if (!this.nFc && (aVar = this.nEE.nHA) != null && ((dLG = aVar.dLG()) || this.nEG)) {
            int dLE = aVar.dLE();
            if (dLE == 2) {
                long j = this.nEJ.nGe;
                long dLD = aVar.dLD();
                long j2 = dLD - j;
                if (Math.abs(j2) > aVar.dLF()) {
                    if (dLG && this.nEG) {
                        resume();
                    }
                    this.nEL.m(j, dLD, j2);
                    this.nEJ.hn(dLD);
                    this.nEH = master.flame.danmaku.danmaku.c.c.dMQ() - dLD;
                    this.nFa = 0L;
                }
            } else if (dLE == 1 && dLG && !this.nEG) {
                pause();
            }
        }
        this.nEO.setExtraData(canvas);
        this.nEP.b(this.nEL.a(this.nEO));
        dLq();
        return this.nEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLn() {
        if (this.nEG && this.nEN) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLo() {
        if (this.nFc) {
            if (this.nEL != null) {
                this.nEL.dLw();
            }
            if (this.nES) {
                synchronized (this) {
                    this.nEQ.clear();
                }
                synchronized (this.nEL) {
                    this.nEL.notifyAll();
                }
            } else {
                this.nEQ.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nFc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(long j) {
        if (!isStop() && isPrepared() && !this.nEY) {
            this.nEP.eAe = master.flame.danmaku.danmaku.c.c.dMQ();
            this.nFc = true;
            if (this.nES) {
                if (this.nER != null) {
                    try {
                        synchronized (this.nEL) {
                            if (j == 10000000) {
                                this.nEL.wait();
                            } else {
                                this.nEL.wait(j);
                            }
                            sendEmptyMessage(11);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (j == 10000000) {
                removeMessages(11);
                removeMessages(2);
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j);
            }
        }
    }

    private synchronized long dLp() {
        long longValue;
        int size = this.nEQ.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nEQ.peekFirst();
            Long peekLast = this.nEQ.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dLq() {
        this.nEQ.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dMQ()));
        if (this.nEQ.size() > 500) {
            this.nEQ.removeFirst();
        }
    }

    public void eA(int i, int i2) {
        if (this.nEO != null) {
            if (this.nEO.getWidth() != i || this.nEO.getHeight() != i2) {
                this.nEO.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wG(boolean z) {
        if (this.nEL != null) {
            this.nEL.wG(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nEL != null) {
            return this.nEL.hi(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nEY) {
            return this.nEZ;
        }
        if (this.nEG || !this.nFc) {
            return this.nEJ.nGe - this.nFa;
        }
        return master.flame.danmaku.danmaku.c.c.dMQ() - this.nEH;
    }

    public DanmakuContext getConfig() {
        return this.nEE;
    }
}
