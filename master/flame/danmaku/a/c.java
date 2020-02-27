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
    private boolean nEA;
    private master.flame.danmaku.danmaku.model.b nEB;
    private final a.b nEC;
    private LinkedList<Long> nED;
    private i nEE;
    private final boolean nEF;
    private long nEG;
    private long nEH;
    private long nEI;
    private long nEJ;
    private long nEK;
    private boolean nEL;
    private long nEM;
    private long nEN;
    private boolean nEO;
    private boolean nEP;
    private boolean nEQ;
    private DanmakuContext nEr;
    private long nEs;
    private boolean nEt;
    private long nEu;
    private a nEv;
    private master.flame.danmaku.danmaku.model.f nEw;
    private master.flame.danmaku.danmaku.a.a nEx;
    public h nEy;
    private g nEz;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dLr();

        void dLs();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nEs = 0L;
        this.nEt = true;
        this.nEw = new master.flame.danmaku.danmaku.model.f();
        this.nEA = true;
        this.nEC = new a.b();
        this.nED = new LinkedList<>();
        this.nEG = 30L;
        this.nEH = 60L;
        this.nEI = 16L;
        this.nEF = Runtime.getRuntime().availableProcessors() > 3;
        this.nEQ = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wK(false);
        }
        this.nEA = z;
    }

    private void a(g gVar) {
        this.nEz = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nEr = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEx = aVar;
    }

    public void setCallback(a aVar) {
        this.nEv = aVar;
    }

    public void quit() {
        this.nEt = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nEt;
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
                    this.nEs = l.longValue();
                } else {
                    this.nEs = 0L;
                }
                if (i == 4) {
                    this.nEt = true;
                    dLf();
                    Long l2 = (Long) message.obj;
                    this.nEu -= l2.longValue() - this.nEw.nFR;
                    this.nEw.hn(l2.longValue());
                    this.nEr.nHz.dLT();
                    if (this.nEy != null) {
                        this.nEy.seek(l2.longValue());
                    }
                    this.nEs = l2.longValue();
                }
                removeMessages(7);
                this.nEt = false;
                if (!this.mReady) {
                    this.nEC.reset();
                    this.nED.clear();
                    this.nEu = master.flame.danmaku.danmaku.c.c.dMN() - this.nEs;
                    this.nEw.hn(this.nEs);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nEy.start();
                    dLl();
                    this.nEL = false;
                    if (this.nEy != null) {
                        this.nEy.NK(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nEF) {
                    dLh();
                    return;
                } else {
                    dLg();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nEt = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nEt = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nEu = master.flame.danmaku.danmaku.c.c.dMN();
                if (this.nEx == null || !this.nEz.dLw()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nEs = 0L;
                            c.this.mReady = true;
                            if (c.this.nEv != null) {
                                c.this.nEv.dLr();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nEt = true;
                dLi();
                this.nEs = this.nEw.nFR;
                if (this.nEE != null) {
                    dLl();
                    dLf();
                }
                if (i == 6) {
                    if (this.nEy != null) {
                        this.nEy.quit();
                    }
                    if (this.nEx != null) {
                        this.nEx.release();
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
                if (this.nEy != null) {
                    this.nEy.NK(2);
                }
                if (i == 6) {
                }
                this.nEt = true;
                dLi();
                this.nEs = this.nEw.nFR;
                if (this.nEE != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nEA = true;
                Long l3 = (Long) message.obj;
                if (this.nEy == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nEw.hn(getCurrentTime());
                    this.nEy.dLt();
                    z = false;
                } else {
                    this.nEy.start();
                    this.nEy.seek(l3.longValue());
                    this.nEy.dLt();
                    z = true;
                }
                if (this.nEt && this.nEz != null) {
                    this.nEz.dLx();
                }
                dLl();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nEt = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nEA = false;
                if (this.nEz != null) {
                    this.nEz.clear();
                }
                if (this.nEy != null) {
                    this.nEy.dLt();
                    this.nEy.dLv();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nEy != null) {
                    this.nEy.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nEy != null) {
                }
                if (i == 6) {
                }
                this.nEt = true;
                dLi();
                this.nEs = this.nEw.nFR;
                if (this.nEE != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nEr.nHB.b(this.nEr);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nEr.nHz.dLT();
                    this.nEr.nHz.dLS();
                    this.nEy.dLu();
                    return;
                }
                return;
            case 11:
                dLl();
                return;
            case 12:
                if (this.nEt && this.nEz != null) {
                    this.nEy.dLt();
                    this.nEz.dLx();
                    dLl();
                    return;
                }
                return;
            case 13:
                if (this.nEy != null) {
                    this.nEy.hj(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dLf() {
        if (this.nEE != null) {
            i iVar = this.nEE;
            this.nEE = null;
            synchronized (this.nEy) {
                this.nEy.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dLg() {
        if (!this.nEt) {
            long hg = hg(master.flame.danmaku.danmaku.c.c.dMN());
            if (hg < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hg);
                return;
            }
            long dLx = this.nEz.dLx();
            removeMessages(2);
            if (dLx > this.nEH) {
                this.nEw.ho(dLx);
                this.nED.clear();
            }
            if (!this.nEA) {
                hh(10000000L);
                return;
            }
            if (this.nEC.nID && this.nEQ) {
                long j = this.nEC.endTime - this.nEw.nFR;
                if (j > 500) {
                    hh(j - 10);
                    return;
                }
            }
            if (dLx < this.nEI) {
                sendEmptyMessageDelayed(2, this.nEI - dLx);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dLh() {
        if (this.nEE == null) {
            this.nEE = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dMN = master.flame.danmaku.danmaku.c.c.dMN();
                    while (!dLz() && !c.this.nEt) {
                        long dMN2 = master.flame.danmaku.danmaku.c.c.dMN();
                        if (c.this.nEI - (master.flame.danmaku.danmaku.c.c.dMN() - dMN) <= 1) {
                            long hg = c.this.hg(dMN2);
                            if (hg >= 0) {
                                long dLx = c.this.nEz.dLx();
                                if (dLx > c.this.nEH) {
                                    c.this.nEw.ho(dLx);
                                    c.this.nED.clear();
                                }
                                if (!c.this.nEA) {
                                    c.this.hh(10000000L);
                                } else if (c.this.nEC.nID && c.this.nEQ) {
                                    long j = c.this.nEC.endTime - c.this.nEw.nFR;
                                    if (j > 500) {
                                        c.this.dLl();
                                        c.this.hh(j - 10);
                                    }
                                }
                                dMN = dMN2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hp(60 - hg);
                                dMN = dMN2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hp(1L);
                        }
                    }
                }
            };
            this.nEE.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hg(long j) {
        long j2;
        long j3 = 0;
        if (this.nEL || this.nEO) {
            return 0L;
        }
        this.nEO = true;
        long j4 = j - this.nEu;
        if (!this.nEA || this.nEC.nID || this.nEP) {
            this.nEw.hn(j4);
            this.nEN = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nEw.nFR;
            long max = Math.max(this.nEI, dLm());
            if (j2 <= 2000 && this.nEC.nIC <= this.nEG && max <= this.nEG) {
                long min = Math.min(this.nEG, Math.max(this.nEI, (j2 / this.nEI) + max));
                long j5 = min - this.nEK;
                if (j5 > 3 && j5 < 8 && this.nEK >= this.nEI && this.nEK <= this.nEG) {
                    min = this.nEK;
                }
                long j6 = j2 - min;
                this.nEK = min;
                j2 = min;
                j3 = j6;
            }
            this.nEN = j3;
            this.nEw.ho(j2);
        }
        if (this.nEv != null) {
            this.nEv.b(this.nEw);
        }
        this.nEO = false;
        return j2;
    }

    private void dLi() {
        if (this.nEP) {
            hg(master.flame.danmaku.danmaku.c.c.dMN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLj() {
        this.nEG = Math.max(33L, ((float) 16) * 2.5f);
        this.nEH = ((float) this.nEG) * 2.5f;
        this.nEI = Math.max(16L, (16 / 15) * 15);
        this.nEJ = this.nEI + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nEy == null) {
            this.nEy = a(this.nEz.dLy(), this.nEw, this.nEz.getContext(), this.nEz.getWidth(), this.nEz.getHeight(), this.nEz.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dLo() {
                    c.this.dLj();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dLQ = dVar.dLQ() - c.this.getCurrentTime();
                        if (dLQ < c.this.nEr.nHB.nHG && (c.this.nEP || c.this.nEC.nID)) {
                            c.this.dLl();
                        } else if (dLQ > 0 && dLQ <= c.this.nEr.nHB.nHG) {
                            c.this.sendEmptyMessageDelayed(11, dLQ);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nEv != null) {
                        c.this.nEv.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLp() {
                    if (c.this.nEv != null) {
                        c.this.nEv.dLs();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLq() {
                    c.this.dLk();
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
        this.nEB = this.nEr.dMo();
        this.nEB.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nEB.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nEB.bG(this.nEr.nGZ);
        this.nEB.wM(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nEr, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nEr, aVar);
        aVar2.a(this.nEx);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nEy != null) {
            dVar.nFN = this.nEr.nHz;
            dVar.c(this.nEw);
            this.nEy.a(dVar);
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
        dLi();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nEA) {
            this.nEA = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wK(boolean z) {
        if (!this.nEA) {
            return this.nEw.nFR;
        }
        this.nEA = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nEw.nFR;
    }

    public a.b ak(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dLD;
        if (this.nEy == null) {
            return this.nEC;
        }
        if (!this.nEP && (aVar = this.nEr.nHn) != null && ((dLD = aVar.dLD()) || this.nEt)) {
            int dLB = aVar.dLB();
            if (dLB == 2) {
                long j = this.nEw.nFR;
                long dLA = aVar.dLA();
                long j2 = dLA - j;
                if (Math.abs(j2) > aVar.dLC()) {
                    if (dLD && this.nEt) {
                        resume();
                    }
                    this.nEy.m(j, dLA, j2);
                    this.nEw.hn(dLA);
                    this.nEu = master.flame.danmaku.danmaku.c.c.dMN() - dLA;
                    this.nEN = 0L;
                }
            } else if (dLB == 1 && dLD && !this.nEt) {
                pause();
            }
        }
        this.nEB.setExtraData(canvas);
        this.nEC.b(this.nEy.a(this.nEB));
        dLn();
        return this.nEC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLk() {
        if (this.nEt && this.nEA) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLl() {
        if (this.nEP) {
            if (this.nEy != null) {
                this.nEy.dLt();
            }
            if (this.nEF) {
                synchronized (this) {
                    this.nED.clear();
                }
                synchronized (this.nEy) {
                    this.nEy.notifyAll();
                }
            } else {
                this.nED.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nEP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(long j) {
        if (!isStop() && isPrepared() && !this.nEL) {
            this.nEC.ezQ = master.flame.danmaku.danmaku.c.c.dMN();
            this.nEP = true;
            if (this.nEF) {
                if (this.nEE != null) {
                    try {
                        synchronized (this.nEy) {
                            if (j == 10000000) {
                                this.nEy.wait();
                            } else {
                                this.nEy.wait(j);
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

    private synchronized long dLm() {
        long longValue;
        int size = this.nED.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nED.peekFirst();
            Long peekLast = this.nED.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dLn() {
        this.nED.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dMN()));
        if (this.nED.size() > 500) {
            this.nED.removeFirst();
        }
    }

    public void eA(int i, int i2) {
        if (this.nEB != null) {
            if (this.nEB.getWidth() != i || this.nEB.getHeight() != i2) {
                this.nEB.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wG(boolean z) {
        if (this.nEy != null) {
            this.nEy.wG(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nEy != null) {
            return this.nEy.hi(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nEL) {
            return this.nEM;
        }
        if (this.nEt || !this.nEP) {
            return this.nEw.nFR - this.nEN;
        }
        return master.flame.danmaku.danmaku.c.c.dMN() - this.nEu;
    }

    public DanmakuContext getConfig() {
        return this.nEr;
    }
}
