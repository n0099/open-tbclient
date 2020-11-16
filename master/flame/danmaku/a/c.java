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
    private final boolean pWA;
    private long pWB;
    private long pWC;
    private long pWD;
    private long pWE;
    private long pWF;
    private boolean pWG;
    private long pWH;
    private long pWI;
    private boolean pWJ;
    private boolean pWK;
    private boolean pWL;
    private DanmakuContext pWm;
    private long pWn;
    private boolean pWo;
    private long pWp;
    private a pWq;
    private master.flame.danmaku.danmaku.model.f pWr;
    private master.flame.danmaku.danmaku.a.a pWs;
    public h pWt;
    private g pWu;
    private boolean pWv;
    private master.flame.danmaku.danmaku.model.b pWw;
    private final a.b pWx;
    private LinkedList<Long> pWy;
    private i pWz;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void eCP();

        void eCQ();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.pWn = 0L;
        this.pWo = true;
        this.pWr = new master.flame.danmaku.danmaku.model.f();
        this.pWv = true;
        this.pWx = new a.b();
        this.pWy = new LinkedList<>();
        this.pWB = 30L;
        this.pWC = 60L;
        this.pWD = 16L;
        this.pWA = Runtime.getRuntime().availableProcessors() > 3;
        this.pWL = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            k((Long) null);
        } else {
            Bg(false);
        }
        this.pWv = z;
    }

    private void a(g gVar) {
        this.pWu = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.pWm = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pWs = aVar;
    }

    public void setCallback(a aVar) {
        this.pWq = aVar;
    }

    public void quit() {
        this.pWo = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.pWo;
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
                    this.pWn = l.longValue();
                } else {
                    this.pWn = 0L;
                }
                if (i == 4) {
                    this.pWo = true;
                    eCD();
                    Long l2 = (Long) message.obj;
                    this.pWp -= l2.longValue() - this.pWr.pXL;
                    this.pWr.is(l2.longValue());
                    this.pWm.pZu.eDs();
                    if (this.pWt != null) {
                        this.pWt.seek(l2.longValue());
                    }
                    this.pWn = l2.longValue();
                }
                removeMessages(7);
                this.pWo = false;
                if (!this.mReady) {
                    this.pWx.reset();
                    this.pWy.clear();
                    this.pWp = master.flame.danmaku.danmaku.c.c.eEm() - this.pWn;
                    this.pWr.is(this.pWn);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.pWt.start();
                    eCJ();
                    this.pWG = false;
                    if (this.pWt != null) {
                        this.pWt.Sb(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.pWA) {
                    eCF();
                    return;
                } else {
                    eCE();
                    return;
                }
            case 3:
                removeMessages(7);
                this.pWo = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.pWo = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.pWp = master.flame.danmaku.danmaku.c.c.eEm();
                if (this.pWs == null || !this.pWu.eCU()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    L(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.pWn = 0L;
                            c.this.mReady = true;
                            if (c.this.pWq != null) {
                                c.this.pWq.eCP();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.pWo = true;
                eCG();
                this.pWn = this.pWr.pXL;
                if (this.pWz != null) {
                    eCJ();
                    eCD();
                }
                if (i == 6) {
                    if (this.pWt != null) {
                        this.pWt.quit();
                    }
                    if (this.pWs != null) {
                        this.pWs.release();
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
                if (this.pWt != null) {
                    this.pWt.Sb(2);
                }
                if (i == 6) {
                }
                this.pWo = true;
                eCG();
                this.pWn = this.pWr.pXL;
                if (this.pWz != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.pWv = true;
                Long l3 = (Long) message.obj;
                if (this.pWt == null) {
                    z = false;
                } else if (l3 == null) {
                    this.pWr.is(getCurrentTime());
                    this.pWt.eCR();
                    z = false;
                } else {
                    this.pWt.start();
                    this.pWt.seek(l3.longValue());
                    this.pWt.eCR();
                    z = true;
                }
                if (this.pWo && this.pWu != null) {
                    this.pWu.eCV();
                }
                eCJ();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.pWo = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.pWv = false;
                if (this.pWu != null) {
                    this.pWu.clear();
                }
                if (this.pWt != null) {
                    this.pWt.eCR();
                    this.pWt.eCT();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.pWt != null) {
                    this.pWt.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.pWt != null) {
                }
                if (i == 6) {
                }
                this.pWo = true;
                eCG();
                this.pWn = this.pWr.pXL;
                if (this.pWz != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.pWm.pZw.b(this.pWm);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.pWm.pZu.eDs();
                    this.pWm.pZu.eDr();
                    this.pWt.eCS();
                    return;
                }
                return;
            case 11:
                eCJ();
                return;
            case 12:
                if (this.pWo && this.pWu != null) {
                    this.pWt.eCR();
                    this.pWu.eCV();
                    eCJ();
                    return;
                }
                return;
            case 13:
                if (this.pWt != null) {
                    this.pWt.io(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eCD() {
        if (this.pWz != null) {
            i iVar = this.pWz;
            this.pWz = null;
            synchronized (this.pWt) {
                this.pWt.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eCE() {
        if (!this.pWo) {
            long il = il(master.flame.danmaku.danmaku.c.c.eEm());
            if (il < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - il);
                return;
            }
            long eCV = this.pWu.eCV();
            removeMessages(2);
            if (eCV > this.pWC) {
                this.pWr.it(eCV);
                this.pWy.clear();
            }
            if (!this.pWv) {
                im(10000000L);
                return;
            }
            if (this.pWx.qaw && this.pWL) {
                long j = this.pWx.endTime - this.pWr.pXL;
                if (j > 500) {
                    im(j - 10);
                    return;
                }
            }
            if (eCV < this.pWD) {
                sendEmptyMessageDelayed(2, this.pWD - eCV);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void eCF() {
        if (this.pWz == null) {
            this.pWz = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eEm = master.flame.danmaku.danmaku.c.c.eEm();
                    while (!eCX() && !c.this.pWo) {
                        long eEm2 = master.flame.danmaku.danmaku.c.c.eEm();
                        if (c.this.pWD - (master.flame.danmaku.danmaku.c.c.eEm() - eEm) <= 1) {
                            long il = c.this.il(eEm2);
                            if (il >= 0) {
                                long eCV = c.this.pWu.eCV();
                                if (eCV > c.this.pWC) {
                                    c.this.pWr.it(eCV);
                                    c.this.pWy.clear();
                                }
                                if (!c.this.pWv) {
                                    c.this.im(10000000L);
                                } else if (c.this.pWx.qaw && c.this.pWL) {
                                    long j = c.this.pWx.endTime - c.this.pWr.pXL;
                                    if (j > 500) {
                                        c.this.eCJ();
                                        c.this.im(j - 10);
                                    }
                                }
                                eEm = eEm2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.iu(60 - il);
                                eEm = eEm2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.iu(1L);
                        }
                    }
                }
            };
            this.pWz.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long il(long j) {
        long j2;
        long j3 = 0;
        if (this.pWG || this.pWJ) {
            return 0L;
        }
        this.pWJ = true;
        long j4 = j - this.pWp;
        if (!this.pWv || this.pWx.qaw || this.pWK) {
            this.pWr.is(j4);
            this.pWI = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.pWr.pXL;
            long max = Math.max(this.pWD, eCK());
            if (j2 <= 2000 && this.pWx.qav <= this.pWB && max <= this.pWB) {
                long min = Math.min(this.pWB, Math.max(this.pWD, (j2 / this.pWD) + max));
                long j5 = min - this.pWF;
                if (j5 > 3 && j5 < 8 && this.pWF >= this.pWD && this.pWF <= this.pWB) {
                    min = this.pWF;
                }
                long j6 = j2 - min;
                this.pWF = min;
                j2 = min;
                j3 = j6;
            }
            this.pWI = j3;
            this.pWr.it(j2);
        }
        if (this.pWq != null) {
            this.pWq.b(this.pWr);
        }
        this.pWJ = false;
        return j2;
    }

    private void eCG() {
        if (this.pWK) {
            il(master.flame.danmaku.danmaku.c.c.eEm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCH() {
        this.pWB = Math.max(33L, ((float) 16) * 2.5f);
        this.pWC = ((float) this.pWB) * 2.5f;
        this.pWD = Math.max(16L, (16 / 15) * 15);
        this.pWE = this.pWD + 3;
    }

    private void L(final Runnable runnable) {
        if (this.pWt == null) {
            this.pWt = a(this.pWu.eCW(), this.pWr, this.pWu.getContext(), this.pWu.getWidth(), this.pWu.getHeight(), this.pWu.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void eCM() {
                    c.this.eCH();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.eDf()) {
                        long eDp = dVar.eDp() - c.this.getCurrentTime();
                        if (eDp < c.this.pWm.pZw.pZB && (c.this.pWK || c.this.pWx.qaw)) {
                            c.this.eCJ();
                        } else if (eDp > 0 && eDp <= c.this.pWm.pZw.pZB) {
                            c.this.sendEmptyMessageDelayed(11, eDp);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.pWq != null) {
                        c.this.pWq.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eCN() {
                    if (c.this.pWq != null) {
                        c.this.pWq.eCQ();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eCO() {
                    c.this.eCI();
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
        this.pWw = this.pWm.eDN();
        this.pWw.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.pWw.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.pWw.bE(this.pWm.pYU);
        this.pWw.Bi(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.pWm, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.pWm, aVar);
        aVar2.a(this.pWs);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pWt != null) {
            dVar.pXH = this.pWm.pZu;
            dVar.c(this.pWr);
            this.pWt.a(dVar);
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
        eCG();
        sendEmptyMessage(7);
    }

    public void k(Long l) {
        if (!this.pWv) {
            this.pWv = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long Bg(boolean z) {
        if (!this.pWv) {
            return this.pWr.pXL;
        }
        this.pWv = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.pWr.pXL;
    }

    public a.b av(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean eDb;
        if (this.pWt == null) {
            return this.pWx;
        }
        if (!this.pWK && (aVar = this.pWm.pZi) != null && ((eDb = aVar.eDb()) || this.pWo)) {
            int eCZ = aVar.eCZ();
            if (eCZ == 2) {
                long j = this.pWr.pXL;
                long eCY = aVar.eCY();
                long j2 = eCY - j;
                if (Math.abs(j2) > aVar.eDa()) {
                    if (eDb && this.pWo) {
                        resume();
                    }
                    this.pWt.k(j, eCY, j2);
                    this.pWr.is(eCY);
                    this.pWp = master.flame.danmaku.danmaku.c.c.eEm() - eCY;
                    this.pWI = 0L;
                }
            } else if (eCZ == 1 && eDb && !this.pWo) {
                pause();
            }
        }
        this.pWw.setExtraData(canvas);
        this.pWx.b(this.pWt.a(this.pWw));
        eCL();
        return this.pWx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCI() {
        if (this.pWo && this.pWv) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eCJ() {
        if (this.pWK) {
            if (this.pWt != null) {
                this.pWt.eCR();
            }
            if (this.pWA) {
                synchronized (this) {
                    this.pWy.clear();
                }
                synchronized (this.pWt) {
                    this.pWt.notifyAll();
                }
            } else {
                this.pWy.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.pWK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(long j) {
        if (!isStop() && isPrepared() && !this.pWG) {
            this.pWx.gzU = master.flame.danmaku.danmaku.c.c.eEm();
            this.pWK = true;
            if (this.pWA) {
                if (this.pWz != null) {
                    try {
                        synchronized (this.pWt) {
                            if (j == 10000000) {
                                this.pWt.wait();
                            } else {
                                this.pWt.wait(j);
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

    private synchronized long eCK() {
        long longValue;
        int size = this.pWy.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.pWy.peekFirst();
            Long peekLast = this.pWy.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void eCL() {
        this.pWy.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eEm()));
        if (this.pWy.size() > 500) {
            this.pWy.removeFirst();
        }
    }

    public void eA(int i, int i2) {
        if (this.pWw != null) {
            if (this.pWw.getWidth() != i || this.pWw.getHeight() != i2) {
                this.pWw.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void Bc(boolean z) {
        if (this.pWt != null) {
            this.pWt.Bc(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.pWt != null) {
            return this.pWt.in(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.pWG) {
            return this.pWH;
        }
        if (this.pWo || !this.pWK) {
            return this.pWr.pXL - this.pWI;
        }
        return master.flame.danmaku.danmaku.c.c.eEm() - this.pWp;
    }

    public DanmakuContext getConfig() {
        return this.pWm;
    }
}
