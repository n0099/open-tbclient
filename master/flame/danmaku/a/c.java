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
    private DanmakuContext mZU;
    private long mZV;
    private boolean mZW;
    private long mZX;
    private a mZY;
    private master.flame.danmaku.danmaku.model.f mZZ;
    private master.flame.danmaku.danmaku.a.a naa;
    public h nab;
    private g nac;
    private boolean nad;
    private master.flame.danmaku.danmaku.model.b nae;
    private final a.b naf;
    private LinkedList<Long> nag;
    private i nah;
    private final boolean nai;
    private long naj;
    private long nak;
    private long nal;
    private long nam;
    private long nan;
    private boolean nao;
    private long nap;
    private long naq;
    private boolean nar;
    private boolean nas;
    private boolean nat;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dER();

        void dES();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.mZV = 0L;
        this.mZW = true;
        this.mZZ = new master.flame.danmaku.danmaku.model.f();
        this.nad = true;
        this.naf = new a.b();
        this.nag = new LinkedList<>();
        this.naj = 30L;
        this.nak = 60L;
        this.nal = 16L;
        this.nai = Runtime.getRuntime().availableProcessors() > 3;
        this.nat = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            wx(false);
        }
        this.nad = z;
    }

    private void a(g gVar) {
        this.nac = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.mZU = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.naa = aVar;
    }

    public void setCallback(a aVar) {
        this.mZY = aVar;
    }

    public void quit() {
        this.mZW = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.mZW;
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
                    this.mZV = l.longValue();
                } else {
                    this.mZV = 0L;
                }
                if (i == 4) {
                    this.mZW = true;
                    dEF();
                    Long l2 = (Long) message.obj;
                    this.mZX -= l2.longValue() - this.mZZ.nbv;
                    this.mZZ.gp(l2.longValue());
                    this.mZU.ndf.dFt();
                    if (this.nab != null) {
                        this.nab.seek(l2.longValue());
                    }
                    this.mZV = l2.longValue();
                }
                removeMessages(7);
                this.mZW = false;
                if (!this.mReady) {
                    this.naf.reset();
                    this.nag.clear();
                    this.mZX = master.flame.danmaku.danmaku.c.c.dGn() - this.mZV;
                    this.mZZ.gp(this.mZV);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nab.start();
                    dEL();
                    this.nao = false;
                    if (this.nab != null) {
                        this.nab.Jk(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nai) {
                    dEH();
                    return;
                } else {
                    dEG();
                    return;
                }
            case 3:
                removeMessages(7);
                this.mZW = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.mZW = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.mZX = master.flame.danmaku.danmaku.c.c.dGn();
                if (this.naa == null || !this.nac.dEW()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    L(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.mZV = 0L;
                            c.this.mReady = true;
                            if (c.this.mZY != null) {
                                c.this.mZY.dER();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.mZW = true;
                dEI();
                this.mZV = this.mZZ.nbv;
                if (this.nah != null) {
                    dEL();
                    dEF();
                }
                if (i == 6) {
                    if (this.nab != null) {
                        this.nab.quit();
                    }
                    if (this.naa != null) {
                        this.naa.release();
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
                if (this.nab != null) {
                    this.nab.Jk(2);
                }
                if (i == 6) {
                }
                this.mZW = true;
                dEI();
                this.mZV = this.mZZ.nbv;
                if (this.nah != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nad = true;
                Long l3 = (Long) message.obj;
                if (this.nab == null) {
                    z = false;
                } else if (l3 == null) {
                    this.mZZ.gp(getCurrentTime());
                    this.nab.dET();
                    z = false;
                } else {
                    this.nab.start();
                    this.nab.seek(l3.longValue());
                    this.nab.dET();
                    z = true;
                }
                if (this.mZW && this.nac != null) {
                    this.nac.dEX();
                }
                dEL();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.mZW = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nad = false;
                if (this.nac != null) {
                    this.nac.clear();
                }
                if (this.nab != null) {
                    this.nab.dET();
                    this.nab.dEV();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nab != null) {
                    this.nab.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nab != null) {
                }
                if (i == 6) {
                }
                this.mZW = true;
                dEI();
                this.mZV = this.mZZ.nbv;
                if (this.nah != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.mZU.ndh.b(this.mZU);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.mZU.ndf.dFt();
                    this.mZU.ndf.dFs();
                    this.nab.dEU();
                    return;
                }
                return;
            case 11:
                dEL();
                return;
            case 12:
                if (this.mZW && this.nac != null) {
                    this.nab.dET();
                    this.nac.dEX();
                    dEL();
                    return;
                }
                return;
            case 13:
                if (this.nab != null) {
                    this.nab.gl(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dEF() {
        if (this.nah != null) {
            i iVar = this.nah;
            this.nah = null;
            synchronized (this.nab) {
                this.nab.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dEG() {
        if (!this.mZW) {
            long gi = gi(master.flame.danmaku.danmaku.c.c.dGn());
            if (gi < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gi);
                return;
            }
            long dEX = this.nac.dEX();
            removeMessages(2);
            if (dEX > this.nak) {
                this.mZZ.gq(dEX);
                this.nag.clear();
            }
            if (!this.nad) {
                gj(10000000L);
                return;
            }
            if (this.naf.nej && this.nat) {
                long j = this.naf.endTime - this.mZZ.nbv;
                if (j > 500) {
                    gj(j - 10);
                    return;
                }
            }
            if (dEX < this.nal) {
                sendEmptyMessageDelayed(2, this.nal - dEX);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dEH() {
        if (this.nah == null) {
            this.nah = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dGn = master.flame.danmaku.danmaku.c.c.dGn();
                    while (!dEZ() && !c.this.mZW) {
                        long dGn2 = master.flame.danmaku.danmaku.c.c.dGn();
                        if (c.this.nal - (master.flame.danmaku.danmaku.c.c.dGn() - dGn) <= 1) {
                            long gi = c.this.gi(dGn2);
                            if (gi >= 0) {
                                long dEX = c.this.nac.dEX();
                                if (dEX > c.this.nak) {
                                    c.this.mZZ.gq(dEX);
                                    c.this.nag.clear();
                                }
                                if (!c.this.nad) {
                                    c.this.gj(10000000L);
                                } else if (c.this.naf.nej && c.this.nat) {
                                    long j = c.this.naf.endTime - c.this.mZZ.nbv;
                                    if (j > 500) {
                                        c.this.dEL();
                                        c.this.gj(j - 10);
                                    }
                                }
                                dGn = dGn2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gr(60 - gi);
                                dGn = dGn2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gr(1L);
                        }
                    }
                }
            };
            this.nah.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gi(long j) {
        long j2;
        long j3 = 0;
        if (this.nao || this.nar) {
            return 0L;
        }
        this.nar = true;
        long j4 = j - this.mZX;
        if (!this.nad || this.naf.nej || this.nas) {
            this.mZZ.gp(j4);
            this.naq = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.mZZ.nbv;
            long max = Math.max(this.nal, dEM());
            if (j2 <= 2000 && this.naf.nei <= this.naj && max <= this.naj) {
                long min = Math.min(this.naj, Math.max(this.nal, (j2 / this.nal) + max));
                long j5 = min - this.nan;
                if (j5 > 3 && j5 < 8 && this.nan >= this.nal && this.nan <= this.naj) {
                    min = this.nan;
                }
                long j6 = j2 - min;
                this.nan = min;
                j2 = min;
                j3 = j6;
            }
            this.naq = j3;
            this.mZZ.gq(j2);
        }
        if (this.mZY != null) {
            this.mZY.b(this.mZZ);
        }
        this.nar = false;
        return j2;
    }

    private void dEI() {
        if (this.nas) {
            gi(master.flame.danmaku.danmaku.c.c.dGn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEJ() {
        this.naj = Math.max(33L, ((float) 16) * 2.5f);
        this.nak = ((float) this.naj) * 2.5f;
        this.nal = Math.max(16L, (16 / 15) * 15);
        this.nam = this.nal + 3;
    }

    private void L(final Runnable runnable) {
        if (this.nab == null) {
            this.nab = a(this.nac.dEY(), this.mZZ, this.nac.getContext(), this.nac.getWidth(), this.nac.getHeight(), this.nac.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dEO() {
                    c.this.dEJ();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dFq = dVar.dFq() - c.this.getCurrentTime();
                        if (dFq < c.this.mZU.ndh.ndm && (c.this.nas || c.this.naf.nej)) {
                            c.this.dEL();
                        } else if (dFq > 0 && dFq <= c.this.mZU.ndh.ndm) {
                            c.this.sendEmptyMessageDelayed(11, dFq);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.mZY != null) {
                        c.this.mZY.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dEP() {
                    if (c.this.mZY != null) {
                        c.this.mZY.dES();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dEQ() {
                    c.this.dEK();
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
        this.nae = this.mZU.dFO();
        this.nae.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nae.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nae.aN(this.mZU.ncF);
        this.nae.wz(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.mZU, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.mZU, aVar);
        aVar2.a(this.naa);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nab != null) {
            dVar.nbr = this.mZU.ndf;
            dVar.c(this.mZZ);
            this.nab.a(dVar);
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
        dEI();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.nad) {
            this.nad = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wx(boolean z) {
        if (!this.nad) {
            return this.mZZ.nbv;
        }
        this.nad = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.mZZ.nbv;
    }

    public a.b ae(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dFd;
        if (this.nab == null) {
            return this.naf;
        }
        if (!this.nas && (aVar = this.mZU.ncT) != null && ((dFd = aVar.dFd()) || this.mZW)) {
            int dFb = aVar.dFb();
            if (dFb == 2) {
                long j = this.mZZ.nbv;
                long dFa = aVar.dFa();
                long j2 = dFa - j;
                if (Math.abs(j2) > aVar.dFc()) {
                    if (dFd && this.mZW) {
                        resume();
                    }
                    this.nab.h(j, dFa, j2);
                    this.mZZ.gp(dFa);
                    this.mZX = master.flame.danmaku.danmaku.c.c.dGn() - dFa;
                    this.naq = 0L;
                }
            } else if (dFb == 1 && dFd && !this.mZW) {
                pause();
            }
        }
        this.nae.setExtraData(canvas);
        this.naf.b(this.nab.a(this.nae));
        dEN();
        return this.naf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEK() {
        if (this.mZW && this.nad) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEL() {
        if (this.nas) {
            if (this.nab != null) {
                this.nab.dET();
            }
            if (this.nai) {
                synchronized (this) {
                    this.nag.clear();
                }
                synchronized (this.nab) {
                    this.nab.notifyAll();
                }
            } else {
                this.nag.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nas = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(long j) {
        if (!isStop() && isPrepared() && !this.nao) {
            this.naf.feY = master.flame.danmaku.danmaku.c.c.dGn();
            this.nas = true;
            if (this.nai) {
                if (this.nah != null) {
                    try {
                        synchronized (this.nab) {
                            if (j == 10000000) {
                                this.nab.wait();
                            } else {
                                this.nab.wait(j);
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

    private synchronized long dEM() {
        long longValue;
        int size = this.nag.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nag.peekFirst();
            Long peekLast = this.nag.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dEN() {
        this.nag.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dGn()));
        if (this.nag.size() > 500) {
            this.nag.removeFirst();
        }
    }

    public void dM(int i, int i2) {
        if (this.nae != null) {
            if (this.nae.getWidth() != i || this.nae.getHeight() != i2) {
                this.nae.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wt(boolean z) {
        if (this.nab != null) {
            this.nab.wt(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nab != null) {
            return this.nab.gk(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nao) {
            return this.nap;
        }
        if (this.mZW || !this.nas) {
            return this.mZZ.nbv - this.naq;
        }
        return master.flame.danmaku.danmaku.c.c.dGn() - this.mZX;
    }

    public DanmakuContext getConfig() {
        return this.mZU;
    }
}
