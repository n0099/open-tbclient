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
/* loaded from: classes6.dex */
public class c extends Handler {
    private boolean mReady;
    private DanmakuContext pUJ;
    private long pUK;
    private boolean pUL;
    private long pUM;
    private a pUN;
    private master.flame.danmaku.danmaku.model.f pUO;
    private master.flame.danmaku.danmaku.a.a pUP;
    public h pUQ;
    private g pUR;
    private boolean pUS;
    private master.flame.danmaku.danmaku.model.b pUT;
    private final a.b pUU;
    private LinkedList<Long> pUV;
    private i pUW;
    private final boolean pUX;
    private long pUY;
    private long pUZ;
    private long pVa;
    private long pVb;
    private long pVc;
    private boolean pVd;
    private long pVe;
    private long pVf;
    private boolean pVg;
    private boolean pVh;
    private boolean pVi;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void eCO();

        void eCP();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.pUK = 0L;
        this.pUL = true;
        this.pUO = new master.flame.danmaku.danmaku.model.f();
        this.pUS = true;
        this.pUU = new a.b();
        this.pUV = new LinkedList<>();
        this.pUY = 30L;
        this.pUZ = 60L;
        this.pVa = 16L;
        this.pUX = Runtime.getRuntime().availableProcessors() > 3;
        this.pVi = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            j((Long) null);
        } else {
            AZ(false);
        }
        this.pUS = z;
    }

    private void a(g gVar) {
        this.pUR = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.pUJ = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pUP = aVar;
    }

    public void setCallback(a aVar) {
        this.pUN = aVar;
    }

    public void quit() {
        this.pUL = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.pUL;
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
                    this.pUK = l.longValue();
                } else {
                    this.pUK = 0L;
                }
                if (i == 4) {
                    this.pUL = true;
                    eCC();
                    Long l2 = (Long) message.obj;
                    this.pUM -= l2.longValue() - this.pUO.pWi;
                    this.pUO.ip(l2.longValue());
                    this.pUJ.pXR.eDr();
                    if (this.pUQ != null) {
                        this.pUQ.seek(l2.longValue());
                    }
                    this.pUK = l2.longValue();
                }
                removeMessages(7);
                this.pUL = false;
                if (!this.mReady) {
                    this.pUU.reset();
                    this.pUV.clear();
                    this.pUM = master.flame.danmaku.danmaku.c.c.eEl() - this.pUK;
                    this.pUO.ip(this.pUK);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.pUQ.start();
                    eCI();
                    this.pVd = false;
                    if (this.pUQ != null) {
                        this.pUQ.Ry(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.pUX) {
                    eCE();
                    return;
                } else {
                    eCD();
                    return;
                }
            case 3:
                removeMessages(7);
                this.pUL = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.pUL = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.pUM = master.flame.danmaku.danmaku.c.c.eEl();
                if (this.pUP == null || !this.pUR.eCT()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    L(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.pUK = 0L;
                            c.this.mReady = true;
                            if (c.this.pUN != null) {
                                c.this.pUN.eCO();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.pUL = true;
                eCF();
                this.pUK = this.pUO.pWi;
                if (this.pUW != null) {
                    eCI();
                    eCC();
                }
                if (i == 6) {
                    if (this.pUQ != null) {
                        this.pUQ.quit();
                    }
                    if (this.pUP != null) {
                        this.pUP.release();
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
                if (this.pUQ != null) {
                    this.pUQ.Ry(2);
                }
                if (i == 6) {
                }
                this.pUL = true;
                eCF();
                this.pUK = this.pUO.pWi;
                if (this.pUW != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.pUS = true;
                Long l3 = (Long) message.obj;
                if (this.pUQ == null) {
                    z = false;
                } else if (l3 == null) {
                    this.pUO.ip(getCurrentTime());
                    this.pUQ.eCQ();
                    z = false;
                } else {
                    this.pUQ.start();
                    this.pUQ.seek(l3.longValue());
                    this.pUQ.eCQ();
                    z = true;
                }
                if (this.pUL && this.pUR != null) {
                    this.pUR.eCU();
                }
                eCI();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.pUL = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.pUS = false;
                if (this.pUR != null) {
                    this.pUR.clear();
                }
                if (this.pUQ != null) {
                    this.pUQ.eCQ();
                    this.pUQ.eCS();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.pUQ != null) {
                    this.pUQ.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.pUQ != null) {
                }
                if (i == 6) {
                }
                this.pUL = true;
                eCF();
                this.pUK = this.pUO.pWi;
                if (this.pUW != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.pUJ.pXT.b(this.pUJ);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.pUJ.pXR.eDr();
                    this.pUJ.pXR.eDq();
                    this.pUQ.eCR();
                    return;
                }
                return;
            case 11:
                eCI();
                return;
            case 12:
                if (this.pUL && this.pUR != null) {
                    this.pUQ.eCQ();
                    this.pUR.eCU();
                    eCI();
                    return;
                }
                return;
            case 13:
                if (this.pUQ != null) {
                    this.pUQ.il(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eCC() {
        if (this.pUW != null) {
            i iVar = this.pUW;
            this.pUW = null;
            synchronized (this.pUQ) {
                this.pUQ.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eCD() {
        if (!this.pUL) {
            long ii = ii(master.flame.danmaku.danmaku.c.c.eEl());
            if (ii < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - ii);
                return;
            }
            long eCU = this.pUR.eCU();
            removeMessages(2);
            if (eCU > this.pUZ) {
                this.pUO.iq(eCU);
                this.pUV.clear();
            }
            if (!this.pUS) {
                ij(10000000L);
                return;
            }
            if (this.pUU.pYT && this.pVi) {
                long j = this.pUU.endTime - this.pUO.pWi;
                if (j > 500) {
                    ij(j - 10);
                    return;
                }
            }
            if (eCU < this.pVa) {
                sendEmptyMessageDelayed(2, this.pVa - eCU);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void eCE() {
        if (this.pUW == null) {
            this.pUW = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eEl = master.flame.danmaku.danmaku.c.c.eEl();
                    while (!eCW() && !c.this.pUL) {
                        long eEl2 = master.flame.danmaku.danmaku.c.c.eEl();
                        if (c.this.pVa - (master.flame.danmaku.danmaku.c.c.eEl() - eEl) <= 1) {
                            long ii = c.this.ii(eEl2);
                            if (ii >= 0) {
                                long eCU = c.this.pUR.eCU();
                                if (eCU > c.this.pUZ) {
                                    c.this.pUO.iq(eCU);
                                    c.this.pUV.clear();
                                }
                                if (!c.this.pUS) {
                                    c.this.ij(10000000L);
                                } else if (c.this.pUU.pYT && c.this.pVi) {
                                    long j = c.this.pUU.endTime - c.this.pUO.pWi;
                                    if (j > 500) {
                                        c.this.eCI();
                                        c.this.ij(j - 10);
                                    }
                                }
                                eEl = eEl2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.ir(60 - ii);
                                eEl = eEl2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.ir(1L);
                        }
                    }
                }
            };
            this.pUW.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long ii(long j) {
        long j2;
        long j3 = 0;
        if (this.pVd || this.pVg) {
            return 0L;
        }
        this.pVg = true;
        long j4 = j - this.pUM;
        if (!this.pUS || this.pUU.pYT || this.pVh) {
            this.pUO.ip(j4);
            this.pVf = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.pUO.pWi;
            long max = Math.max(this.pVa, eCJ());
            if (j2 <= 2000 && this.pUU.pYS <= this.pUY && max <= this.pUY) {
                long min = Math.min(this.pUY, Math.max(this.pVa, (j2 / this.pVa) + max));
                long j5 = min - this.pVc;
                if (j5 > 3 && j5 < 8 && this.pVc >= this.pVa && this.pVc <= this.pUY) {
                    min = this.pVc;
                }
                long j6 = j2 - min;
                this.pVc = min;
                j2 = min;
                j3 = j6;
            }
            this.pVf = j3;
            this.pUO.iq(j2);
        }
        if (this.pUN != null) {
            this.pUN.b(this.pUO);
        }
        this.pVg = false;
        return j2;
    }

    private void eCF() {
        if (this.pVh) {
            ii(master.flame.danmaku.danmaku.c.c.eEl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCG() {
        this.pUY = Math.max(33L, ((float) 16) * 2.5f);
        this.pUZ = ((float) this.pUY) * 2.5f;
        this.pVa = Math.max(16L, (16 / 15) * 15);
        this.pVb = this.pVa + 3;
    }

    private void L(final Runnable runnable) {
        if (this.pUQ == null) {
            this.pUQ = a(this.pUR.eCV(), this.pUO, this.pUR.getContext(), this.pUR.getWidth(), this.pUR.getHeight(), this.pUR.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void eCL() {
                    c.this.eCG();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.eDe()) {
                        long eDo = dVar.eDo() - c.this.getCurrentTime();
                        if (eDo < c.this.pUJ.pXT.pXY && (c.this.pVh || c.this.pUU.pYT)) {
                            c.this.eCI();
                        } else if (eDo > 0 && eDo <= c.this.pUJ.pXT.pXY) {
                            c.this.sendEmptyMessageDelayed(11, eDo);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.pUN != null) {
                        c.this.pUN.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eCM() {
                    if (c.this.pUN != null) {
                        c.this.pUN.eCP();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eCN() {
                    c.this.eCH();
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
        this.pUT = this.pUJ.eDM();
        this.pUT.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.pUT.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.pUT.bw(this.pUJ.pXr);
        this.pUT.Bb(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.pUJ, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.pUJ, aVar);
        aVar2.a(this.pUP);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pUQ != null) {
            dVar.pWe = this.pUJ.pXR;
            dVar.c(this.pUO);
            this.pUQ.a(dVar);
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
        eCF();
        sendEmptyMessage(7);
    }

    public void j(Long l) {
        if (!this.pUS) {
            this.pUS = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long AZ(boolean z) {
        if (!this.pUS) {
            return this.pUO.pWi;
        }
        this.pUS = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.pUO.pWi;
    }

    public a.b au(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean eDa;
        if (this.pUQ == null) {
            return this.pUU;
        }
        if (!this.pVh && (aVar = this.pUJ.pXF) != null && ((eDa = aVar.eDa()) || this.pUL)) {
            int eCY = aVar.eCY();
            if (eCY == 2) {
                long j = this.pUO.pWi;
                long eCX = aVar.eCX();
                long j2 = eCX - j;
                if (Math.abs(j2) > aVar.eCZ()) {
                    if (eDa && this.pUL) {
                        resume();
                    }
                    this.pUQ.k(j, eCX, j2);
                    this.pUO.ip(eCX);
                    this.pUM = master.flame.danmaku.danmaku.c.c.eEl() - eCX;
                    this.pVf = 0L;
                }
            } else if (eCY == 1 && eDa && !this.pUL) {
                pause();
            }
        }
        this.pUT.setExtraData(canvas);
        this.pUU.b(this.pUQ.a(this.pUT));
        eCK();
        return this.pUU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCH() {
        if (this.pUL && this.pUS) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCI() {
        if (this.pVh) {
            if (this.pUQ != null) {
                this.pUQ.eCQ();
            }
            if (this.pUX) {
                synchronized (this) {
                    this.pUV.clear();
                }
                synchronized (this.pUQ) {
                    this.pUQ.notifyAll();
                }
            } else {
                this.pUV.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.pVh = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(long j) {
        if (!isStop() && isPrepared() && !this.pVd) {
            this.pUU.gAn = master.flame.danmaku.danmaku.c.c.eEl();
            this.pVh = true;
            if (this.pUX) {
                if (this.pUW != null) {
                    try {
                        synchronized (this.pUQ) {
                            if (j == 10000000) {
                                this.pUQ.wait();
                            } else {
                                this.pUQ.wait(j);
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

    private synchronized long eCJ() {
        long longValue;
        int size = this.pUV.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.pUV.peekFirst();
            Long peekLast = this.pUV.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void eCK() {
        this.pUV.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eEl()));
        if (this.pUV.size() > 500) {
            this.pUV.removeFirst();
        }
    }

    public void ez(int i, int i2) {
        if (this.pUT != null) {
            if (this.pUT.getWidth() != i || this.pUT.getHeight() != i2) {
                this.pUT.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void AV(boolean z) {
        if (this.pUQ != null) {
            this.pUQ.AV(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.pUQ != null) {
            return this.pUQ.ik(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.pVd) {
            return this.pVe;
        }
        if (this.pUL || !this.pVh) {
            return this.pUO.pWi - this.pVf;
        }
        return master.flame.danmaku.danmaku.c.c.eEl() - this.pUM;
    }

    public DanmakuContext getConfig() {
        return this.pUJ;
    }
}
