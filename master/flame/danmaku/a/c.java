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
/* loaded from: classes4.dex */
public class c extends Handler {
    private boolean mReady;
    private long nDA;
    private boolean nDB;
    private long nDC;
    private a nDD;
    private master.flame.danmaku.danmaku.model.f nDE;
    private master.flame.danmaku.danmaku.a.a nDF;
    public h nDG;
    private g nDH;
    private boolean nDI;
    private master.flame.danmaku.danmaku.model.b nDJ;
    private final a.b nDK;
    private LinkedList<Long> nDL;
    private i nDM;
    private final boolean nDN;
    private long nDO;
    private long nDP;
    private long nDQ;
    private long nDR;
    private long nDS;
    private boolean nDT;
    private long nDU;
    private long nDV;
    private boolean nDW;
    private boolean nDX;
    private boolean nDY;
    private DanmakuContext nDz;

    /* loaded from: classes4.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dKe();

        void dKf();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nDA = 0L;
        this.nDB = true;
        this.nDE = new master.flame.danmaku.danmaku.model.f();
        this.nDI = true;
        this.nDK = new a.b();
        this.nDL = new LinkedList<>();
        this.nDO = 30L;
        this.nDP = 60L;
        this.nDQ = 16L;
        this.nDN = Runtime.getRuntime().availableProcessors() > 3;
        this.nDY = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wH(false);
        }
        this.nDI = z;
    }

    private void a(g gVar) {
        this.nDH = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nDz = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nDF = aVar;
    }

    public void setCallback(a aVar) {
        this.nDD = aVar;
    }

    public void quit() {
        this.nDB = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nDB;
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
                    this.nDA = l.longValue();
                } else {
                    this.nDA = 0L;
                }
                if (i == 4) {
                    this.nDB = true;
                    dJS();
                    Long l2 = (Long) message.obj;
                    this.nDC -= l2.longValue() - this.nDE.nEZ;
                    this.nDE.hp(l2.longValue());
                    this.nDz.nGI.dKG();
                    if (this.nDG != null) {
                        this.nDG.seek(l2.longValue());
                    }
                    this.nDA = l2.longValue();
                }
                removeMessages(7);
                this.nDB = false;
                if (!this.mReady) {
                    this.nDK.reset();
                    this.nDL.clear();
                    this.nDC = master.flame.danmaku.danmaku.c.c.dLA() - this.nDA;
                    this.nDE.hp(this.nDA);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nDG.start();
                    dJY();
                    this.nDT = false;
                    if (this.nDG != null) {
                        this.nDG.NH(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nDN) {
                    dJU();
                    return;
                } else {
                    dJT();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nDB = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nDB = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nDC = master.flame.danmaku.danmaku.c.c.dLA();
                if (this.nDF == null || !this.nDH.dKj()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nDA = 0L;
                            c.this.mReady = true;
                            if (c.this.nDD != null) {
                                c.this.nDD.dKe();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nDB = true;
                dJV();
                this.nDA = this.nDE.nEZ;
                if (this.nDM != null) {
                    dJY();
                    dJS();
                }
                if (i == 6) {
                    if (this.nDG != null) {
                        this.nDG.quit();
                    }
                    if (this.nDF != null) {
                        this.nDF.release();
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
                if (this.nDG != null) {
                    this.nDG.NH(2);
                }
                if (i == 6) {
                }
                this.nDB = true;
                dJV();
                this.nDA = this.nDE.nEZ;
                if (this.nDM != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nDI = true;
                Long l3 = (Long) message.obj;
                if (this.nDG == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nDE.hp(getCurrentTime());
                    this.nDG.dKg();
                    z = false;
                } else {
                    this.nDG.start();
                    this.nDG.seek(l3.longValue());
                    this.nDG.dKg();
                    z = true;
                }
                if (this.nDB && this.nDH != null) {
                    this.nDH.dKk();
                }
                dJY();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nDB = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nDI = false;
                if (this.nDH != null) {
                    this.nDH.clear();
                }
                if (this.nDG != null) {
                    this.nDG.dKg();
                    this.nDG.dKi();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nDG != null) {
                    this.nDG.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nDG != null) {
                }
                if (i == 6) {
                }
                this.nDB = true;
                dJV();
                this.nDA = this.nDE.nEZ;
                if (this.nDM != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nDz.nGK.b(this.nDz);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nDz.nGI.dKG();
                    this.nDz.nGI.dKF();
                    this.nDG.dKh();
                    return;
                }
                return;
            case 11:
                dJY();
                return;
            case 12:
                if (this.nDB && this.nDH != null) {
                    this.nDG.dKg();
                    this.nDH.dKk();
                    dJY();
                    return;
                }
                return;
            case 13:
                if (this.nDG != null) {
                    this.nDG.hl(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dJS() {
        if (this.nDM != null) {
            i iVar = this.nDM;
            this.nDM = null;
            synchronized (this.nDG) {
                this.nDG.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dJT() {
        if (!this.nDB) {
            long hi = hi(master.flame.danmaku.danmaku.c.c.dLA());
            if (hi < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hi);
                return;
            }
            long dKk = this.nDH.dKk();
            removeMessages(2);
            if (dKk > this.nDP) {
                this.nDE.hq(dKk);
                this.nDL.clear();
            }
            if (!this.nDI) {
                hj(10000000L);
                return;
            }
            if (this.nDK.nHN && this.nDY) {
                long j = this.nDK.endTime - this.nDE.nEZ;
                if (j > 500) {
                    hj(j - 10);
                    return;
                }
            }
            if (dKk < this.nDQ) {
                sendEmptyMessageDelayed(2, this.nDQ - dKk);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dJU() {
        if (this.nDM == null) {
            this.nDM = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dLA = master.flame.danmaku.danmaku.c.c.dLA();
                    while (!dKm() && !c.this.nDB) {
                        long dLA2 = master.flame.danmaku.danmaku.c.c.dLA();
                        if (c.this.nDQ - (master.flame.danmaku.danmaku.c.c.dLA() - dLA) <= 1) {
                            long hi = c.this.hi(dLA2);
                            if (hi >= 0) {
                                long dKk = c.this.nDH.dKk();
                                if (dKk > c.this.nDP) {
                                    c.this.nDE.hq(dKk);
                                    c.this.nDL.clear();
                                }
                                if (!c.this.nDI) {
                                    c.this.hj(10000000L);
                                } else if (c.this.nDK.nHN && c.this.nDY) {
                                    long j = c.this.nDK.endTime - c.this.nDE.nEZ;
                                    if (j > 500) {
                                        c.this.dJY();
                                        c.this.hj(j - 10);
                                    }
                                }
                                dLA = dLA2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hr(60 - hi);
                                dLA = dLA2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hr(1L);
                        }
                    }
                }
            };
            this.nDM.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hi(long j) {
        long j2;
        long j3 = 0;
        if (this.nDT || this.nDW) {
            return 0L;
        }
        this.nDW = true;
        long j4 = j - this.nDC;
        if (!this.nDI || this.nDK.nHN || this.nDX) {
            this.nDE.hp(j4);
            this.nDV = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nDE.nEZ;
            long max = Math.max(this.nDQ, dJZ());
            if (j2 <= 2000 && this.nDK.nHM <= this.nDO && max <= this.nDO) {
                long min = Math.min(this.nDO, Math.max(this.nDQ, (j2 / this.nDQ) + max));
                long j5 = min - this.nDS;
                if (j5 > 3 && j5 < 8 && this.nDS >= this.nDQ && this.nDS <= this.nDO) {
                    min = this.nDS;
                }
                long j6 = j2 - min;
                this.nDS = min;
                j2 = min;
                j3 = j6;
            }
            this.nDV = j3;
            this.nDE.hq(j2);
        }
        if (this.nDD != null) {
            this.nDD.b(this.nDE);
        }
        this.nDW = false;
        return j2;
    }

    private void dJV() {
        if (this.nDX) {
            hi(master.flame.danmaku.danmaku.c.c.dLA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJW() {
        this.nDO = Math.max(33L, ((float) 16) * 2.5f);
        this.nDP = ((float) this.nDO) * 2.5f;
        this.nDQ = Math.max(16L, (16 / 15) * 15);
        this.nDR = this.nDQ + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nDG == null) {
            this.nDG = a(this.nDH.dKl(), this.nDE, this.nDH.getContext(), this.nDH.getWidth(), this.nDH.getHeight(), this.nDH.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dKb() {
                    c.this.dJW();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dKD = dVar.dKD() - c.this.getCurrentTime();
                        if (dKD < c.this.nDz.nGK.nGP && (c.this.nDX || c.this.nDK.nHN)) {
                            c.this.dJY();
                        } else if (dKD > 0 && dKD <= c.this.nDz.nGK.nGP) {
                            c.this.sendEmptyMessageDelayed(11, dKD);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nDD != null) {
                        c.this.nDD.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dKc() {
                    if (c.this.nDD != null) {
                        c.this.nDD.dKf();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dKd() {
                    c.this.dJX();
                }
            });
        } else {
            runnable.run();
        }
    }

    public boolean aGB() {
        return this.mReady;
    }

    private h a(boolean z, master.flame.danmaku.danmaku.model.f fVar, Context context, int i, int i2, boolean z2, h.a aVar) {
        this.nDJ = this.nDz.dLb();
        this.nDJ.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nDJ.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nDJ.bH(this.nDz.nGi);
        this.nDJ.wJ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nDz, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nDz, aVar);
        aVar2.a(this.nDF);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nDG != null) {
            dVar.nEV = this.nDz.nGI;
            dVar.c(this.nDE);
            this.nDG.a(dVar);
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
        dJV();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nDI) {
            this.nDI = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wH(boolean z) {
        if (!this.nDI) {
            return this.nDE.nEZ;
        }
        this.nDI = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nDE.nEZ;
    }

    public a.b ak(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dKq;
        if (this.nDG == null) {
            return this.nDK;
        }
        if (!this.nDX && (aVar = this.nDz.nGw) != null && ((dKq = aVar.dKq()) || this.nDB)) {
            int dKo = aVar.dKo();
            if (dKo == 2) {
                long j = this.nDE.nEZ;
                long dKn = aVar.dKn();
                long j2 = dKn - j;
                if (Math.abs(j2) > aVar.dKp()) {
                    if (dKq && this.nDB) {
                        resume();
                    }
                    this.nDG.j(j, dKn, j2);
                    this.nDE.hp(dKn);
                    this.nDC = master.flame.danmaku.danmaku.c.c.dLA() - dKn;
                    this.nDV = 0L;
                }
            } else if (dKo == 1 && dKq && !this.nDB) {
                pause();
            }
        }
        this.nDJ.setExtraData(canvas);
        this.nDK.b(this.nDG.a(this.nDJ));
        dKa();
        return this.nDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJX() {
        if (this.nDB && this.nDI) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJY() {
        if (this.nDX) {
            if (this.nDG != null) {
                this.nDG.dKg();
            }
            if (this.nDN) {
                synchronized (this) {
                    this.nDL.clear();
                }
                synchronized (this.nDG) {
                    this.nDG.notifyAll();
                }
            } else {
                this.nDL.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nDX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(long j) {
        if (!isStop() && aGB() && !this.nDT) {
            this.nDK.evF = master.flame.danmaku.danmaku.c.c.dLA();
            this.nDX = true;
            if (this.nDN) {
                if (this.nDM != null) {
                    try {
                        synchronized (this.nDG) {
                            if (j == 10000000) {
                                this.nDG.wait();
                            } else {
                                this.nDG.wait(j);
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

    private synchronized long dJZ() {
        long longValue;
        int size = this.nDL.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nDL.peekFirst();
            Long peekLast = this.nDL.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dKa() {
        this.nDL.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dLA()));
        if (this.nDL.size() > 500) {
            this.nDL.removeFirst();
        }
    }

    public void ex(int i, int i2) {
        if (this.nDJ != null) {
            if (this.nDJ.getWidth() != i || this.nDJ.getHeight() != i2) {
                this.nDJ.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wD(boolean z) {
        if (this.nDG != null) {
            this.nDG.wD(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nDG != null) {
            return this.nDG.hk(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nDT) {
            return this.nDU;
        }
        if (this.nDB || !this.nDX) {
            return this.nDE.nEZ - this.nDV;
        }
        return master.flame.danmaku.danmaku.c.c.dLA() - this.nDC;
    }

    public DanmakuContext getConfig() {
        return this.nDz;
    }
}
