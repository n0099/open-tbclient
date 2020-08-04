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
    private DanmakuContext oaH;
    private long oaI;
    private boolean oaJ;
    private long oaK;
    private a oaL;
    private master.flame.danmaku.danmaku.model.f oaM;
    private master.flame.danmaku.danmaku.a.a oaN;
    public h oaO;
    private g oaP;
    private boolean oaQ;
    private master.flame.danmaku.danmaku.model.b oaR;
    private final a.b oaS;
    private LinkedList<Long> oaT;
    private i oaU;
    private final boolean oaV;
    private long oaW;
    private long oaX;
    private long oaY;
    private long oaZ;
    private long oba;
    private boolean obb;
    private long obc;
    private long obd;
    private boolean obe;
    private boolean obf;
    private boolean obg;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dVg();

        void dVh();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.oaI = 0L;
        this.oaJ = true;
        this.oaM = new master.flame.danmaku.danmaku.model.f();
        this.oaQ = true;
        this.oaS = new a.b();
        this.oaT = new LinkedList<>();
        this.oaW = 30L;
        this.oaX = 60L;
        this.oaY = 16L;
        this.oaV = Runtime.getRuntime().availableProcessors() > 3;
        this.obg = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            xX(false);
        }
        this.oaQ = z;
    }

    private void a(g gVar) {
        this.oaP = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.oaH = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oaN = aVar;
    }

    public void setCallback(a aVar) {
        this.oaL = aVar;
    }

    public void quit() {
        this.oaJ = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.oaJ;
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
                    this.oaI = l.longValue();
                } else {
                    this.oaI = 0L;
                }
                if (i == 4) {
                    this.oaJ = true;
                    dUU();
                    Long l2 = (Long) message.obj;
                    this.oaK -= l2.longValue() - this.oaM.och;
                    this.oaM.gI(l2.longValue());
                    this.oaH.odS.dVI();
                    if (this.oaO != null) {
                        this.oaO.seek(l2.longValue());
                    }
                    this.oaI = l2.longValue();
                }
                removeMessages(7);
                this.oaJ = false;
                if (!this.mReady) {
                    this.oaS.reset();
                    this.oaT.clear();
                    this.oaK = master.flame.danmaku.danmaku.c.c.dWC() - this.oaI;
                    this.oaM.gI(this.oaI);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.oaO.start();
                    dVa();
                    this.obb = false;
                    if (this.oaO != null) {
                        this.oaO.Ly(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.oaV) {
                    dUW();
                    return;
                } else {
                    dUV();
                    return;
                }
            case 3:
                removeMessages(7);
                this.oaJ = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.oaJ = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.oaK = master.flame.danmaku.danmaku.c.c.dWC();
                if (this.oaN == null || !this.oaP.dVl()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    M(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oaI = 0L;
                            c.this.mReady = true;
                            if (c.this.oaL != null) {
                                c.this.oaL.dVg();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.oaJ = true;
                dUX();
                this.oaI = this.oaM.och;
                if (this.oaU != null) {
                    dVa();
                    dUU();
                }
                if (i == 6) {
                    if (this.oaO != null) {
                        this.oaO.quit();
                    }
                    if (this.oaN != null) {
                        this.oaN.release();
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
                if (this.oaO != null) {
                    this.oaO.Ly(2);
                }
                if (i == 6) {
                }
                this.oaJ = true;
                dUX();
                this.oaI = this.oaM.och;
                if (this.oaU != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.oaQ = true;
                Long l3 = (Long) message.obj;
                if (this.oaO == null) {
                    z = false;
                } else if (l3 == null) {
                    this.oaM.gI(getCurrentTime());
                    this.oaO.dVi();
                    z = false;
                } else {
                    this.oaO.start();
                    this.oaO.seek(l3.longValue());
                    this.oaO.dVi();
                    z = true;
                }
                if (this.oaJ && this.oaP != null) {
                    this.oaP.dVm();
                }
                dVa();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.oaJ = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.oaQ = false;
                if (this.oaP != null) {
                    this.oaP.clear();
                }
                if (this.oaO != null) {
                    this.oaO.dVi();
                    this.oaO.dVk();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.oaO != null) {
                    this.oaO.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.oaO != null) {
                }
                if (i == 6) {
                }
                this.oaJ = true;
                dUX();
                this.oaI = this.oaM.och;
                if (this.oaU != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.oaH.odU.b(this.oaH);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.oaH.odS.dVI();
                    this.oaH.odS.dVH();
                    this.oaO.dVj();
                    return;
                }
                return;
            case 11:
                dVa();
                return;
            case 12:
                if (this.oaJ && this.oaP != null) {
                    this.oaO.dVi();
                    this.oaP.dVm();
                    dVa();
                    return;
                }
                return;
            case 13:
                if (this.oaO != null) {
                    this.oaO.gE(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dUU() {
        if (this.oaU != null) {
            i iVar = this.oaU;
            this.oaU = null;
            synchronized (this.oaO) {
                this.oaO.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dUV() {
        if (!this.oaJ) {
            long gB = gB(master.flame.danmaku.danmaku.c.c.dWC());
            if (gB < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gB);
                return;
            }
            long dVm = this.oaP.dVm();
            removeMessages(2);
            if (dVm > this.oaX) {
                this.oaM.gJ(dVm);
                this.oaT.clear();
            }
            if (!this.oaQ) {
                gC(10000000L);
                return;
            }
            if (this.oaS.oeV && this.obg) {
                long j = this.oaS.endTime - this.oaM.och;
                if (j > 500) {
                    gC(j - 10);
                    return;
                }
            }
            if (dVm < this.oaY) {
                sendEmptyMessageDelayed(2, this.oaY - dVm);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dUW() {
        if (this.oaU == null) {
            this.oaU = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dWC = master.flame.danmaku.danmaku.c.c.dWC();
                    while (!dVo() && !c.this.oaJ) {
                        long dWC2 = master.flame.danmaku.danmaku.c.c.dWC();
                        if (c.this.oaY - (master.flame.danmaku.danmaku.c.c.dWC() - dWC) <= 1) {
                            long gB = c.this.gB(dWC2);
                            if (gB >= 0) {
                                long dVm = c.this.oaP.dVm();
                                if (dVm > c.this.oaX) {
                                    c.this.oaM.gJ(dVm);
                                    c.this.oaT.clear();
                                }
                                if (!c.this.oaQ) {
                                    c.this.gC(10000000L);
                                } else if (c.this.oaS.oeV && c.this.obg) {
                                    long j = c.this.oaS.endTime - c.this.oaM.och;
                                    if (j > 500) {
                                        c.this.dVa();
                                        c.this.gC(j - 10);
                                    }
                                }
                                dWC = dWC2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gK(60 - gB);
                                dWC = dWC2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gK(1L);
                        }
                    }
                }
            };
            this.oaU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gB(long j) {
        long j2;
        long j3 = 0;
        if (this.obb || this.obe) {
            return 0L;
        }
        this.obe = true;
        long j4 = j - this.oaK;
        if (!this.oaQ || this.oaS.oeV || this.obf) {
            this.oaM.gI(j4);
            this.obd = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.oaM.och;
            long max = Math.max(this.oaY, dVb());
            if (j2 <= 2000 && this.oaS.oeU <= this.oaW && max <= this.oaW) {
                long min = Math.min(this.oaW, Math.max(this.oaY, (j2 / this.oaY) + max));
                long j5 = min - this.oba;
                if (j5 > 3 && j5 < 8 && this.oba >= this.oaY && this.oba <= this.oaW) {
                    min = this.oba;
                }
                long j6 = j2 - min;
                this.oba = min;
                j2 = min;
                j3 = j6;
            }
            this.obd = j3;
            this.oaM.gJ(j2);
        }
        if (this.oaL != null) {
            this.oaL.b(this.oaM);
        }
        this.obe = false;
        return j2;
    }

    private void dUX() {
        if (this.obf) {
            gB(master.flame.danmaku.danmaku.c.c.dWC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUY() {
        this.oaW = Math.max(33L, ((float) 16) * 2.5f);
        this.oaX = ((float) this.oaW) * 2.5f;
        this.oaY = Math.max(16L, (16 / 15) * 15);
        this.oaZ = this.oaY + 3;
    }

    private void M(final Runnable runnable) {
        if (this.oaO == null) {
            this.oaO = a(this.oaP.dVn(), this.oaM, this.oaP.getContext(), this.oaP.getWidth(), this.oaP.getHeight(), this.oaP.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dVd() {
                    c.this.dUY();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dVF = dVar.dVF() - c.this.getCurrentTime();
                        if (dVF < c.this.oaH.odU.odZ && (c.this.obf || c.this.oaS.oeV)) {
                            c.this.dVa();
                        } else if (dVF > 0 && dVF <= c.this.oaH.odU.odZ) {
                            c.this.sendEmptyMessageDelayed(11, dVF);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.oaL != null) {
                        c.this.oaL.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dVe() {
                    if (c.this.oaL != null) {
                        c.this.oaL.dVh();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dVf() {
                    c.this.dUZ();
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
        this.oaR = this.oaH.dWd();
        this.oaR.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.oaR.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.oaR.aR(this.oaH.ods);
        this.oaR.xZ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.oaH, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.oaH, aVar);
        aVar2.a(this.oaN);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oaO != null) {
            dVar.ocd = this.oaH.odS;
            dVar.c(this.oaM);
            this.oaO.a(dVar);
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
        dUX();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.oaQ) {
            this.oaQ = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long xX(boolean z) {
        if (!this.oaQ) {
            return this.oaM.och;
        }
        this.oaQ = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.oaM.och;
    }

    public a.b al(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dVs;
        if (this.oaO == null) {
            return this.oaS;
        }
        if (!this.obf && (aVar = this.oaH.odG) != null && ((dVs = aVar.dVs()) || this.oaJ)) {
            int dVq = aVar.dVq();
            if (dVq == 2) {
                long j = this.oaM.och;
                long dVp = aVar.dVp();
                long j2 = dVp - j;
                if (Math.abs(j2) > aVar.dVr()) {
                    if (dVs && this.oaJ) {
                        resume();
                    }
                    this.oaO.k(j, dVp, j2);
                    this.oaM.gI(dVp);
                    this.oaK = master.flame.danmaku.danmaku.c.c.dWC() - dVp;
                    this.obd = 0L;
                }
            } else if (dVq == 1 && dVs && !this.oaJ) {
                pause();
            }
        }
        this.oaR.setExtraData(canvas);
        this.oaS.b(this.oaO.a(this.oaR));
        dVc();
        return this.oaS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUZ() {
        if (this.oaJ && this.oaQ) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVa() {
        if (this.obf) {
            if (this.oaO != null) {
                this.oaO.dVi();
            }
            if (this.oaV) {
                synchronized (this) {
                    this.oaT.clear();
                }
                synchronized (this.oaO) {
                    this.oaO.notifyAll();
                }
            } else {
                this.oaT.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.obf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(long j) {
        if (!isStop() && isPrepared() && !this.obb) {
            this.oaS.fJu = master.flame.danmaku.danmaku.c.c.dWC();
            this.obf = true;
            if (this.oaV) {
                if (this.oaU != null) {
                    try {
                        synchronized (this.oaO) {
                            if (j == 10000000) {
                                this.oaO.wait();
                            } else {
                                this.oaO.wait(j);
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

    private synchronized long dVb() {
        long longValue;
        int size = this.oaT.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.oaT.peekFirst();
            Long peekLast = this.oaT.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dVc() {
        this.oaT.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dWC()));
        if (this.oaT.size() > 500) {
            this.oaT.removeFirst();
        }
    }

    public void ec(int i, int i2) {
        if (this.oaR != null) {
            if (this.oaR.getWidth() != i || this.oaR.getHeight() != i2) {
                this.oaR.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void xT(boolean z) {
        if (this.oaO != null) {
            this.oaO.xT(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.oaO != null) {
            return this.oaO.gD(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.obb) {
            return this.obc;
        }
        if (this.oaJ || !this.obf) {
            return this.oaM.och - this.obd;
        }
        return master.flame.danmaku.danmaku.c.c.dWC() - this.oaK;
    }

    public DanmakuContext getConfig() {
        return this.oaH;
    }
}
