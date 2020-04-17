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
    private DanmakuContext mZR;
    private long mZS;
    private boolean mZT;
    private long mZU;
    private a mZV;
    private master.flame.danmaku.danmaku.model.f mZW;
    private master.flame.danmaku.danmaku.a.a mZX;
    public h mZY;
    private g mZZ;
    private boolean naa;
    private master.flame.danmaku.danmaku.model.b nab;
    private final a.b nac;
    private LinkedList<Long> nad;
    private i nae;
    private final boolean naf;
    private long nag;
    private long nah;
    private long nai;
    private long naj;
    private long nak;
    private boolean nal;
    private long nam;
    private long nan;
    private boolean nao;
    private boolean nap;
    private boolean naq;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dEU();

        void dEV();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.mZS = 0L;
        this.mZT = true;
        this.mZW = new master.flame.danmaku.danmaku.model.f();
        this.naa = true;
        this.nac = new a.b();
        this.nad = new LinkedList<>();
        this.nag = 30L;
        this.nah = 60L;
        this.nai = 16L;
        this.naf = Runtime.getRuntime().availableProcessors() > 3;
        this.naq = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            wx(false);
        }
        this.naa = z;
    }

    private void a(g gVar) {
        this.mZZ = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.mZR = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.mZX = aVar;
    }

    public void setCallback(a aVar) {
        this.mZV = aVar;
    }

    public void quit() {
        this.mZT = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.mZT;
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
                    this.mZS = l.longValue();
                } else {
                    this.mZS = 0L;
                }
                if (i == 4) {
                    this.mZT = true;
                    dEI();
                    Long l2 = (Long) message.obj;
                    this.mZU -= l2.longValue() - this.mZW.nbs;
                    this.mZW.gp(l2.longValue());
                    this.mZR.ndc.dFw();
                    if (this.mZY != null) {
                        this.mZY.seek(l2.longValue());
                    }
                    this.mZS = l2.longValue();
                }
                removeMessages(7);
                this.mZT = false;
                if (!this.mReady) {
                    this.nac.reset();
                    this.nad.clear();
                    this.mZU = master.flame.danmaku.danmaku.c.c.dGq() - this.mZS;
                    this.mZW.gp(this.mZS);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.mZY.start();
                    dEO();
                    this.nal = false;
                    if (this.mZY != null) {
                        this.mZY.Jk(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.naf) {
                    dEK();
                    return;
                } else {
                    dEJ();
                    return;
                }
            case 3:
                removeMessages(7);
                this.mZT = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.mZT = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.mZU = master.flame.danmaku.danmaku.c.c.dGq();
                if (this.mZX == null || !this.mZZ.dEZ()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    L(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.mZS = 0L;
                            c.this.mReady = true;
                            if (c.this.mZV != null) {
                                c.this.mZV.dEU();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.mZT = true;
                dEL();
                this.mZS = this.mZW.nbs;
                if (this.nae != null) {
                    dEO();
                    dEI();
                }
                if (i == 6) {
                    if (this.mZY != null) {
                        this.mZY.quit();
                    }
                    if (this.mZX != null) {
                        this.mZX.release();
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
                if (this.mZY != null) {
                    this.mZY.Jk(2);
                }
                if (i == 6) {
                }
                this.mZT = true;
                dEL();
                this.mZS = this.mZW.nbs;
                if (this.nae != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.naa = true;
                Long l3 = (Long) message.obj;
                if (this.mZY == null) {
                    z = false;
                } else if (l3 == null) {
                    this.mZW.gp(getCurrentTime());
                    this.mZY.dEW();
                    z = false;
                } else {
                    this.mZY.start();
                    this.mZY.seek(l3.longValue());
                    this.mZY.dEW();
                    z = true;
                }
                if (this.mZT && this.mZZ != null) {
                    this.mZZ.dFa();
                }
                dEO();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.mZT = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.naa = false;
                if (this.mZZ != null) {
                    this.mZZ.clear();
                }
                if (this.mZY != null) {
                    this.mZY.dEW();
                    this.mZY.dEY();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.mZY != null) {
                    this.mZY.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.mZY != null) {
                }
                if (i == 6) {
                }
                this.mZT = true;
                dEL();
                this.mZS = this.mZW.nbs;
                if (this.nae != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.mZR.nde.b(this.mZR);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.mZR.ndc.dFw();
                    this.mZR.ndc.dFv();
                    this.mZY.dEX();
                    return;
                }
                return;
            case 11:
                dEO();
                return;
            case 12:
                if (this.mZT && this.mZZ != null) {
                    this.mZY.dEW();
                    this.mZZ.dFa();
                    dEO();
                    return;
                }
                return;
            case 13:
                if (this.mZY != null) {
                    this.mZY.gl(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dEI() {
        if (this.nae != null) {
            i iVar = this.nae;
            this.nae = null;
            synchronized (this.mZY) {
                this.mZY.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dEJ() {
        if (!this.mZT) {
            long gi = gi(master.flame.danmaku.danmaku.c.c.dGq());
            if (gi < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gi);
                return;
            }
            long dFa = this.mZZ.dFa();
            removeMessages(2);
            if (dFa > this.nah) {
                this.mZW.gq(dFa);
                this.nad.clear();
            }
            if (!this.naa) {
                gj(10000000L);
                return;
            }
            if (this.nac.neg && this.naq) {
                long j = this.nac.endTime - this.mZW.nbs;
                if (j > 500) {
                    gj(j - 10);
                    return;
                }
            }
            if (dFa < this.nai) {
                sendEmptyMessageDelayed(2, this.nai - dFa);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dEK() {
        if (this.nae == null) {
            this.nae = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dGq = master.flame.danmaku.danmaku.c.c.dGq();
                    while (!dFc() && !c.this.mZT) {
                        long dGq2 = master.flame.danmaku.danmaku.c.c.dGq();
                        if (c.this.nai - (master.flame.danmaku.danmaku.c.c.dGq() - dGq) <= 1) {
                            long gi = c.this.gi(dGq2);
                            if (gi >= 0) {
                                long dFa = c.this.mZZ.dFa();
                                if (dFa > c.this.nah) {
                                    c.this.mZW.gq(dFa);
                                    c.this.nad.clear();
                                }
                                if (!c.this.naa) {
                                    c.this.gj(10000000L);
                                } else if (c.this.nac.neg && c.this.naq) {
                                    long j = c.this.nac.endTime - c.this.mZW.nbs;
                                    if (j > 500) {
                                        c.this.dEO();
                                        c.this.gj(j - 10);
                                    }
                                }
                                dGq = dGq2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gr(60 - gi);
                                dGq = dGq2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gr(1L);
                        }
                    }
                }
            };
            this.nae.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gi(long j) {
        long j2;
        long j3 = 0;
        if (this.nal || this.nao) {
            return 0L;
        }
        this.nao = true;
        long j4 = j - this.mZU;
        if (!this.naa || this.nac.neg || this.nap) {
            this.mZW.gp(j4);
            this.nan = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.mZW.nbs;
            long max = Math.max(this.nai, dEP());
            if (j2 <= 2000 && this.nac.nef <= this.nag && max <= this.nag) {
                long min = Math.min(this.nag, Math.max(this.nai, (j2 / this.nai) + max));
                long j5 = min - this.nak;
                if (j5 > 3 && j5 < 8 && this.nak >= this.nai && this.nak <= this.nag) {
                    min = this.nak;
                }
                long j6 = j2 - min;
                this.nak = min;
                j2 = min;
                j3 = j6;
            }
            this.nan = j3;
            this.mZW.gq(j2);
        }
        if (this.mZV != null) {
            this.mZV.b(this.mZW);
        }
        this.nao = false;
        return j2;
    }

    private void dEL() {
        if (this.nap) {
            gi(master.flame.danmaku.danmaku.c.c.dGq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEM() {
        this.nag = Math.max(33L, ((float) 16) * 2.5f);
        this.nah = ((float) this.nag) * 2.5f;
        this.nai = Math.max(16L, (16 / 15) * 15);
        this.naj = this.nai + 3;
    }

    private void L(final Runnable runnable) {
        if (this.mZY == null) {
            this.mZY = a(this.mZZ.dFb(), this.mZW, this.mZZ.getContext(), this.mZZ.getWidth(), this.mZZ.getHeight(), this.mZZ.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dER() {
                    c.this.dEM();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dFt = dVar.dFt() - c.this.getCurrentTime();
                        if (dFt < c.this.mZR.nde.ndj && (c.this.nap || c.this.nac.neg)) {
                            c.this.dEO();
                        } else if (dFt > 0 && dFt <= c.this.mZR.nde.ndj) {
                            c.this.sendEmptyMessageDelayed(11, dFt);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.mZV != null) {
                        c.this.mZV.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dES() {
                    if (c.this.mZV != null) {
                        c.this.mZV.dEV();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dET() {
                    c.this.dEN();
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
        this.nab = this.mZR.dFR();
        this.nab.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nab.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nab.aN(this.mZR.ncC);
        this.nab.wz(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.mZR, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.mZR, aVar);
        aVar2.a(this.mZX);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.mZY != null) {
            dVar.nbo = this.mZR.ndc;
            dVar.c(this.mZW);
            this.mZY.a(dVar);
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
        dEL();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.naa) {
            this.naa = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wx(boolean z) {
        if (!this.naa) {
            return this.mZW.nbs;
        }
        this.naa = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.mZW.nbs;
    }

    public a.b ae(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dFg;
        if (this.mZY == null) {
            return this.nac;
        }
        if (!this.nap && (aVar = this.mZR.ncQ) != null && ((dFg = aVar.dFg()) || this.mZT)) {
            int dFe = aVar.dFe();
            if (dFe == 2) {
                long j = this.mZW.nbs;
                long dFd = aVar.dFd();
                long j2 = dFd - j;
                if (Math.abs(j2) > aVar.dFf()) {
                    if (dFg && this.mZT) {
                        resume();
                    }
                    this.mZY.h(j, dFd, j2);
                    this.mZW.gp(dFd);
                    this.mZU = master.flame.danmaku.danmaku.c.c.dGq() - dFd;
                    this.nan = 0L;
                }
            } else if (dFe == 1 && dFg && !this.mZT) {
                pause();
            }
        }
        this.nab.setExtraData(canvas);
        this.nac.b(this.mZY.a(this.nab));
        dEQ();
        return this.nac;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEN() {
        if (this.mZT && this.naa) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEO() {
        if (this.nap) {
            if (this.mZY != null) {
                this.mZY.dEW();
            }
            if (this.naf) {
                synchronized (this) {
                    this.nad.clear();
                }
                synchronized (this.mZY) {
                    this.mZY.notifyAll();
                }
            } else {
                this.nad.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nap = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(long j) {
        if (!isStop() && isPrepared() && !this.nal) {
            this.nac.feT = master.flame.danmaku.danmaku.c.c.dGq();
            this.nap = true;
            if (this.naf) {
                if (this.nae != null) {
                    try {
                        synchronized (this.mZY) {
                            if (j == 10000000) {
                                this.mZY.wait();
                            } else {
                                this.mZY.wait(j);
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

    private synchronized long dEP() {
        long longValue;
        int size = this.nad.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nad.peekFirst();
            Long peekLast = this.nad.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dEQ() {
        this.nad.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dGq()));
        if (this.nad.size() > 500) {
            this.nad.removeFirst();
        }
    }

    public void dM(int i, int i2) {
        if (this.nab != null) {
            if (this.nab.getWidth() != i || this.nab.getHeight() != i2) {
                this.nab.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wt(boolean z) {
        if (this.mZY != null) {
            this.mZY.wt(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.mZY != null) {
            return this.mZY.gk(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nal) {
            return this.nam;
        }
        if (this.mZT || !this.nap) {
            return this.mZW.nbs - this.nan;
        }
        return master.flame.danmaku.danmaku.c.c.dGq() - this.mZU;
    }

    public DanmakuContext getConfig() {
        return this.mZR;
    }
}
