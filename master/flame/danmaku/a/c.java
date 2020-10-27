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
    private final a.b pLA;
    private LinkedList<Long> pLB;
    private i pLC;
    private final boolean pLD;
    private long pLE;
    private long pLF;
    private long pLG;
    private long pLH;
    private long pLI;
    private boolean pLJ;
    private long pLK;
    private long pLL;
    private boolean pLM;
    private boolean pLN;
    private boolean pLO;
    private DanmakuContext pLp;
    private long pLq;
    private boolean pLr;
    private long pLs;
    private a pLt;
    private master.flame.danmaku.danmaku.model.f pLu;
    private master.flame.danmaku.danmaku.a.a pLv;
    public h pLw;
    private g pLx;
    private boolean pLy;
    private master.flame.danmaku.danmaku.model.b pLz;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void eyZ();

        void eza();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.pLq = 0L;
        this.pLr = true;
        this.pLu = new master.flame.danmaku.danmaku.model.f();
        this.pLy = true;
        this.pLA = new a.b();
        this.pLB = new LinkedList<>();
        this.pLE = 30L;
        this.pLF = 60L;
        this.pLG = 16L;
        this.pLD = Runtime.getRuntime().availableProcessors() > 3;
        this.pLO = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            j((Long) null);
        } else {
            AO(false);
        }
        this.pLy = z;
    }

    private void a(g gVar) {
        this.pLx = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.pLp = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pLv = aVar;
    }

    public void setCallback(a aVar) {
        this.pLt = aVar;
    }

    public void quit() {
        this.pLr = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.pLr;
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
                    this.pLq = l.longValue();
                } else {
                    this.pLq = 0L;
                }
                if (i == 4) {
                    this.pLr = true;
                    eyN();
                    Long l2 = (Long) message.obj;
                    this.pLs -= l2.longValue() - this.pLu.pMO;
                    this.pLu.hT(l2.longValue());
                    this.pLp.pOx.ezC();
                    if (this.pLw != null) {
                        this.pLw.seek(l2.longValue());
                    }
                    this.pLq = l2.longValue();
                }
                removeMessages(7);
                this.pLr = false;
                if (!this.mReady) {
                    this.pLA.reset();
                    this.pLB.clear();
                    this.pLs = master.flame.danmaku.danmaku.c.c.eAw() - this.pLq;
                    this.pLu.hT(this.pLq);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.pLw.start();
                    eyT();
                    this.pLJ = false;
                    if (this.pLw != null) {
                        this.pLw.Rd(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.pLD) {
                    eyP();
                    return;
                } else {
                    eyO();
                    return;
                }
            case 3:
                removeMessages(7);
                this.pLr = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.pLr = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.pLs = master.flame.danmaku.danmaku.c.c.eAw();
                if (this.pLv == null || !this.pLx.eze()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    L(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.pLq = 0L;
                            c.this.mReady = true;
                            if (c.this.pLt != null) {
                                c.this.pLt.eyZ();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.pLr = true;
                eyQ();
                this.pLq = this.pLu.pMO;
                if (this.pLC != null) {
                    eyT();
                    eyN();
                }
                if (i == 6) {
                    if (this.pLw != null) {
                        this.pLw.quit();
                    }
                    if (this.pLv != null) {
                        this.pLv.release();
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
                if (this.pLw != null) {
                    this.pLw.Rd(2);
                }
                if (i == 6) {
                }
                this.pLr = true;
                eyQ();
                this.pLq = this.pLu.pMO;
                if (this.pLC != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.pLy = true;
                Long l3 = (Long) message.obj;
                if (this.pLw == null) {
                    z = false;
                } else if (l3 == null) {
                    this.pLu.hT(getCurrentTime());
                    this.pLw.ezb();
                    z = false;
                } else {
                    this.pLw.start();
                    this.pLw.seek(l3.longValue());
                    this.pLw.ezb();
                    z = true;
                }
                if (this.pLr && this.pLx != null) {
                    this.pLx.ezf();
                }
                eyT();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.pLr = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.pLy = false;
                if (this.pLx != null) {
                    this.pLx.clear();
                }
                if (this.pLw != null) {
                    this.pLw.ezb();
                    this.pLw.ezd();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.pLw != null) {
                    this.pLw.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.pLw != null) {
                }
                if (i == 6) {
                }
                this.pLr = true;
                eyQ();
                this.pLq = this.pLu.pMO;
                if (this.pLC != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.pLp.pOz.b(this.pLp);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.pLp.pOx.ezC();
                    this.pLp.pOx.ezB();
                    this.pLw.ezc();
                    return;
                }
                return;
            case 11:
                eyT();
                return;
            case 12:
                if (this.pLr && this.pLx != null) {
                    this.pLw.ezb();
                    this.pLx.ezf();
                    eyT();
                    return;
                }
                return;
            case 13:
                if (this.pLw != null) {
                    this.pLw.hP(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eyN() {
        if (this.pLC != null) {
            i iVar = this.pLC;
            this.pLC = null;
            synchronized (this.pLw) {
                this.pLw.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eyO() {
        if (!this.pLr) {
            long hM = hM(master.flame.danmaku.danmaku.c.c.eAw());
            if (hM < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hM);
                return;
            }
            long ezf = this.pLx.ezf();
            removeMessages(2);
            if (ezf > this.pLF) {
                this.pLu.hU(ezf);
                this.pLB.clear();
            }
            if (!this.pLy) {
                hN(10000000L);
                return;
            }
            if (this.pLA.pPz && this.pLO) {
                long j = this.pLA.endTime - this.pLu.pMO;
                if (j > 500) {
                    hN(j - 10);
                    return;
                }
            }
            if (ezf < this.pLG) {
                sendEmptyMessageDelayed(2, this.pLG - ezf);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void eyP() {
        if (this.pLC == null) {
            this.pLC = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eAw = master.flame.danmaku.danmaku.c.c.eAw();
                    while (!ezh() && !c.this.pLr) {
                        long eAw2 = master.flame.danmaku.danmaku.c.c.eAw();
                        if (c.this.pLG - (master.flame.danmaku.danmaku.c.c.eAw() - eAw) <= 1) {
                            long hM = c.this.hM(eAw2);
                            if (hM >= 0) {
                                long ezf = c.this.pLx.ezf();
                                if (ezf > c.this.pLF) {
                                    c.this.pLu.hU(ezf);
                                    c.this.pLB.clear();
                                }
                                if (!c.this.pLy) {
                                    c.this.hN(10000000L);
                                } else if (c.this.pLA.pPz && c.this.pLO) {
                                    long j = c.this.pLA.endTime - c.this.pLu.pMO;
                                    if (j > 500) {
                                        c.this.eyT();
                                        c.this.hN(j - 10);
                                    }
                                }
                                eAw = eAw2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hV(60 - hM);
                                eAw = eAw2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hV(1L);
                        }
                    }
                }
            };
            this.pLC.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hM(long j) {
        long j2;
        long j3 = 0;
        if (this.pLJ || this.pLM) {
            return 0L;
        }
        this.pLM = true;
        long j4 = j - this.pLs;
        if (!this.pLy || this.pLA.pPz || this.pLN) {
            this.pLu.hT(j4);
            this.pLL = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.pLu.pMO;
            long max = Math.max(this.pLG, eyU());
            if (j2 <= 2000 && this.pLA.pPy <= this.pLE && max <= this.pLE) {
                long min = Math.min(this.pLE, Math.max(this.pLG, (j2 / this.pLG) + max));
                long j5 = min - this.pLI;
                if (j5 > 3 && j5 < 8 && this.pLI >= this.pLG && this.pLI <= this.pLE) {
                    min = this.pLI;
                }
                long j6 = j2 - min;
                this.pLI = min;
                j2 = min;
                j3 = j6;
            }
            this.pLL = j3;
            this.pLu.hU(j2);
        }
        if (this.pLt != null) {
            this.pLt.b(this.pLu);
        }
        this.pLM = false;
        return j2;
    }

    private void eyQ() {
        if (this.pLN) {
            hM(master.flame.danmaku.danmaku.c.c.eAw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eyR() {
        this.pLE = Math.max(33L, ((float) 16) * 2.5f);
        this.pLF = ((float) this.pLE) * 2.5f;
        this.pLG = Math.max(16L, (16 / 15) * 15);
        this.pLH = this.pLG + 3;
    }

    private void L(final Runnable runnable) {
        if (this.pLw == null) {
            this.pLw = a(this.pLx.ezg(), this.pLu, this.pLx.getContext(), this.pLx.getWidth(), this.pLx.getHeight(), this.pLx.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void eyW() {
                    c.this.eyR();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.ezp()) {
                        long ezz = dVar.ezz() - c.this.getCurrentTime();
                        if (ezz < c.this.pLp.pOz.pOE && (c.this.pLN || c.this.pLA.pPz)) {
                            c.this.eyT();
                        } else if (ezz > 0 && ezz <= c.this.pLp.pOz.pOE) {
                            c.this.sendEmptyMessageDelayed(11, ezz);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.pLt != null) {
                        c.this.pLt.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eyX() {
                    if (c.this.pLt != null) {
                        c.this.pLt.eza();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eyY() {
                    c.this.eyS();
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
        this.pLz = this.pLp.ezX();
        this.pLz.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.pLz.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.pLz.bu(this.pLp.pNX);
        this.pLz.AQ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.pLp, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.pLp, aVar);
        aVar2.a(this.pLv);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pLw != null) {
            dVar.pMK = this.pLp.pOx;
            dVar.c(this.pLu);
            this.pLw.a(dVar);
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
        eyQ();
        sendEmptyMessage(7);
    }

    public void j(Long l) {
        if (!this.pLy) {
            this.pLy = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long AO(boolean z) {
        if (!this.pLy) {
            return this.pLu.pMO;
        }
        this.pLy = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.pLu.pMO;
    }

    public a.b au(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean ezl;
        if (this.pLw == null) {
            return this.pLA;
        }
        if (!this.pLN && (aVar = this.pLp.pOl) != null && ((ezl = aVar.ezl()) || this.pLr)) {
            int ezj = aVar.ezj();
            if (ezj == 2) {
                long j = this.pLu.pMO;
                long ezi = aVar.ezi();
                long j2 = ezi - j;
                if (Math.abs(j2) > aVar.ezk()) {
                    if (ezl && this.pLr) {
                        resume();
                    }
                    this.pLw.k(j, ezi, j2);
                    this.pLu.hT(ezi);
                    this.pLs = master.flame.danmaku.danmaku.c.c.eAw() - ezi;
                    this.pLL = 0L;
                }
            } else if (ezj == 1 && ezl && !this.pLr) {
                pause();
            }
        }
        this.pLz.setExtraData(canvas);
        this.pLA.b(this.pLw.a(this.pLz));
        eyV();
        return this.pLA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eyS() {
        if (this.pLr && this.pLy) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eyT() {
        if (this.pLN) {
            if (this.pLw != null) {
                this.pLw.ezb();
            }
            if (this.pLD) {
                synchronized (this) {
                    this.pLB.clear();
                }
                synchronized (this.pLw) {
                    this.pLw.notifyAll();
                }
            } else {
                this.pLB.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.pLN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hN(long j) {
        if (!isStop() && isPrepared() && !this.pLJ) {
            this.pLA.guz = master.flame.danmaku.danmaku.c.c.eAw();
            this.pLN = true;
            if (this.pLD) {
                if (this.pLC != null) {
                    try {
                        synchronized (this.pLw) {
                            if (j == 10000000) {
                                this.pLw.wait();
                            } else {
                                this.pLw.wait(j);
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

    private synchronized long eyU() {
        long longValue;
        int size = this.pLB.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.pLB.peekFirst();
            Long peekLast = this.pLB.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void eyV() {
        this.pLB.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eAw()));
        if (this.pLB.size() > 500) {
            this.pLB.removeFirst();
        }
    }

    public void ew(int i, int i2) {
        if (this.pLz != null) {
            if (this.pLz.getWidth() != i || this.pLz.getHeight() != i2) {
                this.pLz.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void AK(boolean z) {
        if (this.pLw != null) {
            this.pLw.AK(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.pLw != null) {
            return this.pLw.hO(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.pLJ) {
            return this.pLK;
        }
        if (this.pLr || !this.pLN) {
            return this.pLu.pMO - this.pLL;
        }
        return master.flame.danmaku.danmaku.c.c.eAw() - this.pLs;
    }

    public DanmakuContext getConfig() {
        return this.pLp;
    }
}
