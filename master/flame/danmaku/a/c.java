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
    private DanmakuContext nuX;
    private long nuY;
    private boolean nuZ;
    private long nva;
    private a nvb;
    private master.flame.danmaku.danmaku.model.f nvc;
    private master.flame.danmaku.danmaku.a.a nvd;
    public h nve;
    private g nvf;
    private boolean nvg;
    private master.flame.danmaku.danmaku.model.b nvh;
    private final a.b nvi;
    private LinkedList<Long> nvj;
    private i nvk;
    private final boolean nvl;
    private long nvm;
    private long nvn;
    private long nvo;
    private long nvp;
    private long nvq;
    private boolean nvr;
    private long nvs;
    private long nvt;
    private boolean nvu;
    private boolean nvv;
    private boolean nvw;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dML();

        void dMM();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nuY = 0L;
        this.nuZ = true;
        this.nvc = new master.flame.danmaku.danmaku.model.f();
        this.nvg = true;
        this.nvi = new a.b();
        this.nvj = new LinkedList<>();
        this.nvm = 30L;
        this.nvn = 60L;
        this.nvo = 16L;
        this.nvl = Runtime.getRuntime().availableProcessors() > 3;
        this.nvw = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            wV(false);
        }
        this.nvg = z;
    }

    private void a(g gVar) {
        this.nvf = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nuX = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nvd = aVar;
    }

    public void setCallback(a aVar) {
        this.nvb = aVar;
    }

    public void quit() {
        this.nuZ = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nuZ;
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
                    this.nuY = l.longValue();
                } else {
                    this.nuY = 0L;
                }
                if (i == 4) {
                    this.nuZ = true;
                    dMz();
                    Long l2 = (Long) message.obj;
                    this.nva -= l2.longValue() - this.nvc.nwy;
                    this.nvc.gq(l2.longValue());
                    this.nuX.nyi.dNn();
                    if (this.nve != null) {
                        this.nve.seek(l2.longValue());
                    }
                    this.nuY = l2.longValue();
                }
                removeMessages(7);
                this.nuZ = false;
                if (!this.mReady) {
                    this.nvi.reset();
                    this.nvj.clear();
                    this.nva = master.flame.danmaku.danmaku.c.c.dOh() - this.nuY;
                    this.nvc.gq(this.nuY);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nve.start();
                    dMF();
                    this.nvr = false;
                    if (this.nve != null) {
                        this.nve.JV(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nvl) {
                    dMB();
                    return;
                } else {
                    dMA();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nuZ = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nuZ = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nva = master.flame.danmaku.danmaku.c.c.dOh();
                if (this.nvd == null || !this.nvf.dMQ()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    N(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nuY = 0L;
                            c.this.mReady = true;
                            if (c.this.nvb != null) {
                                c.this.nvb.dML();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nuZ = true;
                dMC();
                this.nuY = this.nvc.nwy;
                if (this.nvk != null) {
                    dMF();
                    dMz();
                }
                if (i == 6) {
                    if (this.nve != null) {
                        this.nve.quit();
                    }
                    if (this.nvd != null) {
                        this.nvd.release();
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
                if (this.nve != null) {
                    this.nve.JV(2);
                }
                if (i == 6) {
                }
                this.nuZ = true;
                dMC();
                this.nuY = this.nvc.nwy;
                if (this.nvk != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nvg = true;
                Long l3 = (Long) message.obj;
                if (this.nve == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nvc.gq(getCurrentTime());
                    this.nve.dMN();
                    z = false;
                } else {
                    this.nve.start();
                    this.nve.seek(l3.longValue());
                    this.nve.dMN();
                    z = true;
                }
                if (this.nuZ && this.nvf != null) {
                    this.nvf.dMR();
                }
                dMF();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nuZ = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nvg = false;
                if (this.nvf != null) {
                    this.nvf.clear();
                }
                if (this.nve != null) {
                    this.nve.dMN();
                    this.nve.dMP();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nve != null) {
                    this.nve.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nve != null) {
                }
                if (i == 6) {
                }
                this.nuZ = true;
                dMC();
                this.nuY = this.nvc.nwy;
                if (this.nvk != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nuX.nyk.b(this.nuX);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nuX.nyi.dNn();
                    this.nuX.nyi.dNm();
                    this.nve.dMO();
                    return;
                }
                return;
            case 11:
                dMF();
                return;
            case 12:
                if (this.nuZ && this.nvf != null) {
                    this.nve.dMN();
                    this.nvf.dMR();
                    dMF();
                    return;
                }
                return;
            case 13:
                if (this.nve != null) {
                    this.nve.gm(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dMz() {
        if (this.nvk != null) {
            i iVar = this.nvk;
            this.nvk = null;
            synchronized (this.nve) {
                this.nve.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dMA() {
        if (!this.nuZ) {
            long gj = gj(master.flame.danmaku.danmaku.c.c.dOh());
            if (gj < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gj);
                return;
            }
            long dMR = this.nvf.dMR();
            removeMessages(2);
            if (dMR > this.nvn) {
                this.nvc.gr(dMR);
                this.nvj.clear();
            }
            if (!this.nvg) {
                gk(10000000L);
                return;
            }
            if (this.nvi.nzl && this.nvw) {
                long j = this.nvi.endTime - this.nvc.nwy;
                if (j > 500) {
                    gk(j - 10);
                    return;
                }
            }
            if (dMR < this.nvo) {
                sendEmptyMessageDelayed(2, this.nvo - dMR);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dMB() {
        if (this.nvk == null) {
            this.nvk = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dOh = master.flame.danmaku.danmaku.c.c.dOh();
                    while (!dMT() && !c.this.nuZ) {
                        long dOh2 = master.flame.danmaku.danmaku.c.c.dOh();
                        if (c.this.nvo - (master.flame.danmaku.danmaku.c.c.dOh() - dOh) <= 1) {
                            long gj = c.this.gj(dOh2);
                            if (gj >= 0) {
                                long dMR = c.this.nvf.dMR();
                                if (dMR > c.this.nvn) {
                                    c.this.nvc.gr(dMR);
                                    c.this.nvj.clear();
                                }
                                if (!c.this.nvg) {
                                    c.this.gk(10000000L);
                                } else if (c.this.nvi.nzl && c.this.nvw) {
                                    long j = c.this.nvi.endTime - c.this.nvc.nwy;
                                    if (j > 500) {
                                        c.this.dMF();
                                        c.this.gk(j - 10);
                                    }
                                }
                                dOh = dOh2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gs(60 - gj);
                                dOh = dOh2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gs(1L);
                        }
                    }
                }
            };
            this.nvk.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gj(long j) {
        long j2;
        long j3 = 0;
        if (this.nvr || this.nvu) {
            return 0L;
        }
        this.nvu = true;
        long j4 = j - this.nva;
        if (!this.nvg || this.nvi.nzl || this.nvv) {
            this.nvc.gq(j4);
            this.nvt = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nvc.nwy;
            long max = Math.max(this.nvo, dMG());
            if (j2 <= 2000 && this.nvi.nzk <= this.nvm && max <= this.nvm) {
                long min = Math.min(this.nvm, Math.max(this.nvo, (j2 / this.nvo) + max));
                long j5 = min - this.nvq;
                if (j5 > 3 && j5 < 8 && this.nvq >= this.nvo && this.nvq <= this.nvm) {
                    min = this.nvq;
                }
                long j6 = j2 - min;
                this.nvq = min;
                j2 = min;
                j3 = j6;
            }
            this.nvt = j3;
            this.nvc.gr(j2);
        }
        if (this.nvb != null) {
            this.nvb.b(this.nvc);
        }
        this.nvu = false;
        return j2;
    }

    private void dMC() {
        if (this.nvv) {
            gj(master.flame.danmaku.danmaku.c.c.dOh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMD() {
        this.nvm = Math.max(33L, ((float) 16) * 2.5f);
        this.nvn = ((float) this.nvm) * 2.5f;
        this.nvo = Math.max(16L, (16 / 15) * 15);
        this.nvp = this.nvo + 3;
    }

    private void N(final Runnable runnable) {
        if (this.nve == null) {
            this.nve = a(this.nvf.dMS(), this.nvc, this.nvf.getContext(), this.nvf.getWidth(), this.nvf.getHeight(), this.nvf.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dMI() {
                    c.this.dMD();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dNk = dVar.dNk() - c.this.getCurrentTime();
                        if (dNk < c.this.nuX.nyk.nyp && (c.this.nvv || c.this.nvi.nzl)) {
                            c.this.dMF();
                        } else if (dNk > 0 && dNk <= c.this.nuX.nyk.nyp) {
                            c.this.sendEmptyMessageDelayed(11, dNk);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nvb != null) {
                        c.this.nvb.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dMJ() {
                    if (c.this.nvb != null) {
                        c.this.nvb.dMM();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dMK() {
                    c.this.dME();
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
        this.nvh = this.nuX.dNI();
        this.nvh.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nvh.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nvh.aM(this.nuX.nxI);
        this.nvh.wX(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nuX, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nuX, aVar);
        aVar2.a(this.nvd);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nve != null) {
            dVar.nwu = this.nuX.nyi;
            dVar.c(this.nvc);
            this.nve.a(dVar);
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
        dMC();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.nvg) {
            this.nvg = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wV(boolean z) {
        if (!this.nvg) {
            return this.nvc.nwy;
        }
        this.nvg = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nvc.nwy;
    }

    public a.b ag(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dMX;
        if (this.nve == null) {
            return this.nvi;
        }
        if (!this.nvv && (aVar = this.nuX.nxW) != null && ((dMX = aVar.dMX()) || this.nuZ)) {
            int dMV = aVar.dMV();
            if (dMV == 2) {
                long j = this.nvc.nwy;
                long dMU = aVar.dMU();
                long j2 = dMU - j;
                if (Math.abs(j2) > aVar.dMW()) {
                    if (dMX && this.nuZ) {
                        resume();
                    }
                    this.nve.h(j, dMU, j2);
                    this.nvc.gq(dMU);
                    this.nva = master.flame.danmaku.danmaku.c.c.dOh() - dMU;
                    this.nvt = 0L;
                }
            } else if (dMV == 1 && dMX && !this.nuZ) {
                pause();
            }
        }
        this.nvh.setExtraData(canvas);
        this.nvi.b(this.nve.a(this.nvh));
        dMH();
        return this.nvi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dME() {
        if (this.nuZ && this.nvg) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMF() {
        if (this.nvv) {
            if (this.nve != null) {
                this.nve.dMN();
            }
            if (this.nvl) {
                synchronized (this) {
                    this.nvj.clear();
                }
                synchronized (this.nve) {
                    this.nve.notifyAll();
                }
            } else {
                this.nvj.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nvv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(long j) {
        if (!isStop() && isPrepared() && !this.nvr) {
            this.nvi.fsD = master.flame.danmaku.danmaku.c.c.dOh();
            this.nvv = true;
            if (this.nvl) {
                if (this.nvk != null) {
                    try {
                        synchronized (this.nve) {
                            if (j == 10000000) {
                                this.nve.wait();
                            } else {
                                this.nve.wait(j);
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

    private synchronized long dMG() {
        long longValue;
        int size = this.nvj.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nvj.peekFirst();
            Long peekLast = this.nvj.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dMH() {
        this.nvj.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dOh()));
        if (this.nvj.size() > 500) {
            this.nvj.removeFirst();
        }
    }

    public void dR(int i, int i2) {
        if (this.nvh != null) {
            if (this.nvh.getWidth() != i || this.nvh.getHeight() != i2) {
                this.nvh.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wR(boolean z) {
        if (this.nve != null) {
            this.nve.wR(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nve != null) {
            return this.nve.gl(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nvr) {
            return this.nvs;
        }
        if (this.nuZ || !this.nvv) {
            return this.nvc.nwy - this.nvt;
        }
        return master.flame.danmaku.danmaku.c.c.dOh() - this.nva;
    }

    public DanmakuContext getConfig() {
        return this.nuX;
    }
}
