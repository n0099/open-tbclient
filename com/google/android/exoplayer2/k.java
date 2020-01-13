package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.b.h;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class k implements Handler.Callback, h.a, k.a, l.a {
    private int dT;
    private final Handler handler;
    private boolean isLoading;
    private final s[] lXJ;
    private final com.google.android.exoplayer2.b.h lXK;
    private final Handler lXM;
    private boolean lXP;
    private boolean lXQ;
    private q lXV;
    private final t[] lYb;
    private final n lYc;
    private final com.google.android.exoplayer2.util.q lYd;
    private final HandlerThread lYe;
    private final g lYf;
    private final o lYg;
    private s lYh;
    private com.google.android.exoplayer2.util.h lYi;
    private s[] lYj;
    private boolean lYk;
    private int lYl;
    private int lYm;
    private long lYn;
    private int lYo;
    private int lYp;
    private c lYq;
    private long lYr;
    private a lYs;
    private a lYt;
    private a lYu;
    private final x.b laT;
    private final x.a laU;
    private com.google.android.exoplayer2.source.l lbk;
    private boolean released;
    private int state = 1;
    private p lXW = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lXJ = sVarArr;
        this.lXK = hVar;
        this.lYc = nVar;
        this.lXP = z;
        this.dT = i;
        this.lXQ = z2;
        this.lXM = handler;
        this.lYf = gVar;
        this.lYb = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lYb[i2] = sVarArr[i2].drq();
        }
        this.lYd = new com.google.android.exoplayer2.util.q();
        this.lYj = new s[0];
        this.laT = new x.b();
        this.laU = new x.a();
        this.lYg = new o();
        hVar.a(this);
        this.lXV = q.lYW;
        this.lYe = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lYe.start();
        this.handler = new Handler(this.lYe.getLooper(), this);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
    }

    public void vu(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(12, i, 0).sendToTarget();
    }

    public void vv(boolean z) {
        this.handler.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
    }

    public void a(x xVar, int i, long j) {
        this.handler.obtainMessage(3, new c(xVar, i, j)).sendToTarget();
    }

    public void b(q qVar) {
        this.handler.obtainMessage(4, qVar).sendToTarget();
    }

    public void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public void a(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.lYl++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lYl;
            this.lYl = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lYm <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void release() {
        if (!this.released) {
            this.handler.sendEmptyMessage(6);
            boolean z = false;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
        this.handler.obtainMessage(7, new b(lVar, xVar, obj)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(com.google.android.exoplayer2.source.k kVar) {
        this.handler.obtainMessage(8, kVar).sendToTarget();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(com.google.android.exoplayer2.source.k kVar) {
        this.handler.obtainMessage(9, kVar).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        try {
            switch (message.what) {
                case 0:
                    b((com.google.android.exoplayer2.source.l) message.obj, message.arg1 != 0);
                    z = true;
                    break;
                case 1:
                    vw(message.arg1 != 0);
                    z = true;
                    break;
                case 2:
                    drU();
                    z = true;
                    break;
                case 3:
                    a((c) message.obj);
                    z = true;
                    break;
                case 4:
                    c((q) message.obj);
                    z = true;
                    break;
                case 5:
                    drV();
                    z = true;
                    break;
                case 6:
                    releaseInternal();
                    z = true;
                    break;
                case 7:
                    a((b) message.obj);
                    z = true;
                    break;
                case 8:
                    c((com.google.android.exoplayer2.source.k) message.obj);
                    z = true;
                    break;
                case 9:
                    d((com.google.android.exoplayer2.source.k) message.obj);
                    z = true;
                    break;
                case 10:
                    drW();
                    z = true;
                    break;
                case 11:
                    c((g.b[]) message.obj);
                    z = true;
                    break;
                case 12:
                    IP(message.arg1);
                    z = true;
                    break;
                case 13:
                    vx(message.arg1 != 0);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.lXM.obtainMessage(7, e).sendToTarget();
            drV();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lXM.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            drV();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lXM.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            drV();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lXM.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lXM.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lYo++;
        vy(true);
        this.lYc.onPrepared();
        if (z) {
            this.lXW = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lXW = new p(null, null, this.lXW.lYT, this.lXW.lYU, this.lXW.lYP);
        }
        this.lbk = lVar;
        lVar.a(this.lYf, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vw(boolean z) throws ExoPlaybackException {
        this.lYk = false;
        this.lXP = z;
        if (!z) {
            drS();
            drT();
        } else if (this.state == 3) {
            drR();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IP(int i) throws ExoPlaybackException {
        this.dT = i;
        this.lYg.setRepeatMode(i);
        drQ();
    }

    private void vx(boolean z) throws ExoPlaybackException {
        this.lXQ = z;
        this.lYg.vv(z);
        drQ();
    }

    private void drQ() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lYu != null ? this.lYu : this.lYs;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lXW.timeline.a(aVar.lYA.lYM.periodIndex, this.laU, this.laT, this.dT, this.lXQ);
                while (aVar.lYD != null && !aVar.lYA.lYR) {
                    aVar = aVar.lYD;
                }
                if (a2 == -1 || aVar.lYD == null || aVar.lYD.lYA.lYM.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lYD;
            }
            int i = this.lYs.index;
            int i2 = this.lYt != null ? this.lYt.index : -1;
            if (aVar.lYD != null) {
                a(aVar.lYD);
                aVar.lYD = null;
            }
            aVar.lYA = this.lYg.a(aVar.lYA);
            if (!(i <= aVar.index)) {
                this.lYs = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lYu != null) {
                l.b bVar = this.lYu.lYA.lYM;
                long a3 = a(bVar, this.lXW.lYU);
                if (a3 != this.lXW.lYU) {
                    this.lXW = this.lXW.b(bVar, a3, this.lXW.lYP);
                    this.lXM.obtainMessage(4, 3, 0, this.lXW).sendToTarget();
                }
            }
        }
    }

    private void drR() throws ExoPlaybackException {
        this.lYk = false;
        this.lYd.start();
        for (s sVar : this.lYj) {
            sVar.start();
        }
    }

    private void drS() throws ExoPlaybackException {
        this.lYd.stop();
        for (s sVar : this.lYj) {
            a(sVar);
        }
    }

    private void drT() throws ExoPlaybackException {
        if (this.lYu != null) {
            long duS = this.lYu.lYv.duS();
            if (duS != -9223372036854775807L) {
                fu(duS);
                this.lXW = this.lXW.b(this.lXW.lYT, duS, this.lXW.lYP);
                this.lXM.obtainMessage(4, 3, 0, this.lXW).sendToTarget();
            } else {
                if (this.lYh == null || this.lYh.atB() || (!this.lYh.isReady() && c(this.lYh))) {
                    this.lYr = this.lYd.dsW();
                } else {
                    this.lYr = this.lYi.dsW();
                    this.lYd.gx(this.lYr);
                }
                duS = this.lYu.fx(this.lYr);
            }
            this.lXW.lYU = duS;
            this.lYn = SystemClock.elapsedRealtime() * 1000;
            long duT = this.lYj.length == 0 ? Long.MIN_VALUE : this.lYu.lYv.duT();
            p pVar = this.lXW;
            if (duT == Long.MIN_VALUE) {
                duT = this.lYu.lYA.lYQ;
            }
            pVar.lYV = duT;
        }
    }

    private void drU() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean fv;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dsa();
        if (this.lYu == null) {
            drX();
            M(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        drT();
        this.lYu.lYv.gd(this.lXW.lYU);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lYj) {
            sVar.N(this.lYr, this.lYn);
            z2 = z2 && sVar.atB();
            boolean z3 = sVar.isReady() || sVar.atB() || c(sVar);
            if (!z3) {
                sVar.drw();
            }
            z = z && z3;
        }
        if (!z) {
            drX();
        }
        if (this.lYi != null) {
            q drF = this.lYi.drF();
            if (!drF.equals(this.lXV)) {
                this.lXV = drF;
                this.lYd.d(drF);
                this.lXM.obtainMessage(6, drF).sendToTarget();
            }
        }
        long j = this.lYu.lYA.lYQ;
        if (z2 && ((j == -9223372036854775807L || j <= this.lXW.lYU) && this.lYu.lYA.lYS)) {
            setState(4);
            drS();
        } else if (this.state == 2) {
            if (this.lYj.length > 0) {
                fv = z && this.lYs.f(this.lYk, this.lYr);
            } else {
                fv = fv(j);
            }
            if (fv) {
                setState(3);
                if (this.lXP) {
                    drR();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lYj.length > 0 ? z : fv(j))) {
                this.lYk = this.lXP;
                setState(2);
                drS();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lYj) {
                sVar2.drw();
            }
        }
        if ((this.lXP && this.state == 3) || this.state == 2) {
            M(elapsedRealtime, 10L);
        } else if (this.lYj.length != 0 && this.state != 4) {
            M(elapsedRealtime, 1000L);
        } else {
            this.handler.removeMessages(2);
        }
        com.google.android.exoplayer2.util.t.endSection();
    }

    private void M(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [693=6] */
    private void a(c cVar) throws ExoPlaybackException {
        boolean z;
        long j;
        x xVar = this.lXW.timeline;
        if (xVar == null) {
            this.lYp++;
            this.lYq = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vA(this.lXQ), this.laT).lZE;
            this.lXW = this.lXW.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lXM.obtainMessage(3, 1, 0, this.lXW.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vy(false);
            return;
        }
        boolean z2 = cVar.lYI == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b C = this.lYg.C(intValue, longValue);
        if (C.dvg()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (C.equals(this.lXW.lYT) && j / 1000 == this.lXW.lYU / 1000) {
                return;
            }
            long a2 = a(C, j);
            boolean z3 = z | (j != a2);
            this.lXW = this.lXW.b(C, a2, longValue);
            this.lXM.obtainMessage(3, z3 ? 1 : 0, 0, this.lXW).sendToTarget();
        } finally {
            this.lXW = this.lXW.b(C, j, longValue);
            this.lXM.obtainMessage(3, z ? 1 : 0, 0, this.lXW).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        drS();
        this.lYk = false;
        setState(2);
        if (this.lYu == null) {
            if (this.lYs != null) {
                this.lYs.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lYu; aVar2 != null; aVar2 = aVar2.lYD) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lYu != aVar || this.lYu != this.lYt) {
            for (s sVar : this.lYj) {
                b(sVar);
            }
            this.lYj = new s[0];
            this.lYu = null;
        }
        if (aVar != null) {
            aVar.lYD = null;
            this.lYs = aVar;
            this.lYt = aVar;
            b(aVar);
            if (this.lYu.lYC) {
                j = this.lYu.lYv.ge(j);
            }
            fu(j);
            dsc();
        } else {
            this.lYs = null;
            this.lYt = null;
            this.lYu = null;
            fu(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lYA.lYM) && aVar.lYB) {
            this.lXW.timeline.a(aVar.lYA.lYM.periodIndex, this.laU);
            int fD = this.laU.fD(j);
            if (fD == -1 || this.laU.IU(fD) == aVar.lYA.lYO) {
                return true;
            }
        }
        return false;
    }

    private void fu(long j) throws ExoPlaybackException {
        this.lYr = this.lYu == null ? 60000000 + j : this.lYu.fw(j);
        this.lYd.gx(this.lYr);
        for (s sVar : this.lYj) {
            sVar.fn(this.lYr);
        }
    }

    private void c(q qVar) {
        if (this.lYi != null) {
            qVar = this.lYi.d(qVar);
        }
        this.lYd.d(qVar);
        this.lXV = qVar;
        this.lXM.obtainMessage(6, qVar).sendToTarget();
    }

    private void drV() {
        vy(true);
        this.lYc.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vy(true);
        this.lYc.drA();
        setState(1);
        this.lYe.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vy(boolean z) {
        this.handler.removeMessages(2);
        this.lYk = false;
        this.lYd.stop();
        this.lYr = 60000000L;
        for (s sVar : this.lYj) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lYj = new s[0];
        a(this.lYu != null ? this.lYu : this.lYs);
        this.lYs = null;
        this.lYt = null;
        this.lYu = null;
        setIsLoading(false);
        if (z) {
            if (this.lbk != null) {
                this.lbk.releaseSource();
                this.lbk = null;
            }
            this.lYg.a((x) null);
            this.lXW = this.lXW.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lXH.k(bVar.messageType, bVar.lXI);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lYm++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lYm++;
                notifyAll();
                throw th;
            }
        }
    }

    private void a(s sVar) throws ExoPlaybackException {
        if (sVar.getState() == 2) {
            sVar.stop();
        }
    }

    private void b(s sVar) throws ExoPlaybackException {
        if (sVar == this.lYh) {
            this.lYi = null;
            this.lYh = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void drW() throws ExoPlaybackException {
        if (this.lYu != null) {
            boolean z = true;
            for (a aVar = this.lYu; aVar != null && aVar.lYB; aVar = aVar.lYD) {
                if (!aVar.dsg()) {
                    if (aVar == this.lYt) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lYt != this.lYu;
                        a(this.lYu.lYD);
                        this.lYu.lYD = null;
                        this.lYs = this.lYu;
                        this.lYt = this.lYu;
                        boolean[] zArr = new boolean[this.lXJ.length];
                        long a2 = this.lYu.a(this.lXW.lYU, z2, zArr);
                        if (this.state != 4 && a2 != this.lXW.lYU) {
                            this.lXW = this.lXW.b(this.lXW.lYT, a2, this.lXW.lYP);
                            this.lXM.obtainMessage(4, 3, 0, this.lXW).sendToTarget();
                            fu(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lXJ.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lXJ.length; i2++) {
                            s sVar = this.lXJ[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lYu.lYx[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.drs()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fn(this.lYr);
                                }
                            }
                        }
                        this.lXM.obtainMessage(2, aVar.lYE).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lYs = aVar;
                        for (a aVar2 = this.lYs.lYD; aVar2 != null; aVar2 = aVar2.lYD) {
                            aVar2.release();
                        }
                        this.lYs.lYD = null;
                        if (this.lYs.lYB) {
                            this.lYs.l(Math.max(this.lYs.lYA.lYN, this.lYs.fx(this.lYr)), false);
                        }
                    }
                    if (this.state != 4) {
                        dsc();
                        drT();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean fv(long j) {
        return j == -9223372036854775807L || this.lXW.lYU < j || (this.lYu.lYD != null && (this.lYu.lYD.lYB || this.lYu.lYD.lYA.lYM.dvg()));
    }

    private void drX() throws IOException {
        if (this.lYs == null || this.lYs.lYB) {
            return;
        }
        if (this.lYt == null || this.lYt.lYD == this.lYs) {
            for (s sVar : this.lYj) {
                if (!sVar.drt()) {
                    return;
                }
            }
            this.lYs.lYv.duQ();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lYG == this.lbk) {
            x xVar = this.lXW.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lYH;
            this.lYg.a(xVar2);
            this.lXW = this.lXW.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lYo;
                this.lYo = 0;
                if (this.lYp > 0) {
                    Pair<Integer, Long> b2 = b(this.lYq);
                    int i2 = this.lYp;
                    this.lYp = 0;
                    this.lYq = null;
                    if (b2 == null) {
                        dA(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b C = this.lYg.C(intValue, longValue);
                    this.lXW = this.lXW.b(C, C.dvg() ? 0L : longValue, longValue);
                    dB(i, i2);
                    return;
                } else if (this.lXW.lYN == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dA(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vA(this.lXQ), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b C2 = this.lYg.C(intValue2, longValue2);
                    this.lXW = this.lXW.b(C2, C2.dvg() ? 0L : longValue2, longValue2);
                    dB(i, 0);
                    return;
                } else {
                    dB(i, 0);
                    return;
                }
            }
            int i3 = this.lXW.lYT.periodIndex;
            a aVar = this.lYu != null ? this.lYu : this.lYs;
            if (aVar == null && i3 >= xVar.dsm()) {
                drZ();
                return;
            }
            int bu = xVar2.bu(aVar == null ? xVar.a(i3, this.laU, true).lYw : aVar.lYw);
            if (bu == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    drY();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.laU).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.laU, true);
                if (aVar != null) {
                    Object obj2 = this.laU.lYw;
                    aVar.lYA = aVar.lYA.IS(-1);
                    a aVar2 = aVar;
                    while (aVar2.lYD != null) {
                        aVar2 = aVar2.lYD;
                        if (aVar2.lYw.equals(obj2)) {
                            aVar2.lYA = this.lYg.a(aVar2.lYA, intValue3);
                        } else {
                            aVar2.lYA = aVar2.lYA.IS(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lXW = this.lXW.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                drZ();
                return;
            }
            if (bu != i3) {
                this.lXW = this.lXW.IT(bu);
            }
            if (this.lXW.lYT.dvg()) {
                l.b C3 = this.lYg.C(bu, this.lXW.lYP);
                if (!C3.dvg() || C3.mrt != this.lXW.lYT.mrt) {
                    this.lXW = this.lXW.b(C3, a(C3, this.lXW.lYP), C3.dvg() ? this.lXW.lYP : -9223372036854775807L);
                    drZ();
                    return;
                }
            }
            if (aVar == null) {
                drZ();
                return;
            }
            a a3 = a(aVar, bu);
            int i4 = bu;
            while (a3.lYD != null) {
                a aVar3 = a3.lYD;
                i4 = xVar2.a(i4, this.laU, this.laT, this.dT, this.lXQ);
                if (i4 != -1 && aVar3.lYw.equals(xVar2.a(i4, this.laU, true).lYw)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lYt != null && this.lYt.index < aVar3.index)) {
                        this.lXW = this.lXW.b(this.lYu.lYA.lYM, a(this.lYu.lYA.lYM, this.lXW.lYU), this.lXW.lYP);
                    } else {
                        this.lYs = a3;
                        this.lYs.lYD = null;
                        a(aVar3);
                    }
                    drZ();
                }
            }
            drZ();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lYA = this.lYg.a(aVar.lYA, i);
            if (aVar.lYA.lYR || aVar.lYD == null) {
                break;
            }
            aVar = aVar.lYD;
        }
        return aVar;
    }

    private void drY() {
        dA(0, 0);
    }

    private void dA(int i, int i2) {
        x xVar = this.lXW.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vA(this.lXQ), this.laT).lZE;
        this.lXW = this.lXW.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lXW.g(i3, 0L, -9223372036854775807L));
        vy(false);
    }

    private void drZ() {
        dB(0, 0);
    }

    private void dB(int i, int i2) {
        a(i, i2, this.lXW);
    }

    private void a(int i, int i2, p pVar) {
        this.lXM.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dsm = xVar.dsm();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dsm && i3 == -1) {
            int a2 = xVar.a(i4, this.laU, this.laT, this.dT, this.lXQ);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bu(xVar.a(a2, this.laU, true).lYw);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lXW.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.laT, this.laU, cVar.windowIndex, cVar.lYI);
            if (xVar == xVar2) {
                return a2;
            }
            int bu = xVar.bu(xVar2.a(((Integer) a2.first).intValue(), this.laU, true).lYw);
            if (bu != -1) {
                return Pair.create(Integer.valueOf(bu), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.laU).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lYI);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.laT, this.laU, i, j);
    }

    private void dsa() throws ExoPlaybackException, IOException {
        if (this.lXW.timeline == null) {
            this.lbk.duY();
            return;
        }
        dsb();
        if (this.lYs == null || this.lYs.dse()) {
            setIsLoading(false);
        } else if (this.lYs != null && !this.isLoading) {
            dsc();
        }
        if (this.lYu != null) {
            while (this.lXP && this.lYu != this.lYt && this.lYr >= this.lYu.lYD.lYz) {
                this.lYu.release();
                b(this.lYu.lYD);
                this.lXW = this.lXW.b(this.lYu.lYA.lYM, this.lYu.lYA.lYN, this.lYu.lYA.lYP);
                drT();
                this.lXM.obtainMessage(4, 0, 0, this.lXW).sendToTarget();
            }
            if (this.lYt.lYA.lYS) {
                for (int i = 0; i < this.lXJ.length; i++) {
                    s sVar = this.lXJ[i];
                    com.google.android.exoplayer2.source.p pVar = this.lYt.lYx[i];
                    if (pVar != null && sVar.drs() == pVar && sVar.drt()) {
                        sVar.dru();
                    }
                }
            } else if (this.lYt.lYD != null && this.lYt.lYD.lYB) {
                for (int i2 = 0; i2 < this.lXJ.length; i2++) {
                    s sVar2 = this.lXJ[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lYt.lYx[i2];
                    if (sVar2.drs() == pVar2) {
                        if (pVar2 != null && !sVar2.drt()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lYt.lYE;
                this.lYt = this.lYt.lYD;
                com.google.android.exoplayer2.b.i iVar2 = this.lYt.lYE;
                boolean z = this.lYt.lYv.duS() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lXJ.length; i3++) {
                    s sVar3 = this.lXJ[i3];
                    if (iVar.mCB[i3]) {
                        if (z) {
                            sVar3.dru();
                        } else if (!sVar3.drv()) {
                            com.google.android.exoplayer2.b.f LD = iVar2.mCC.LD(i3);
                            boolean z2 = iVar2.mCB[i3];
                            boolean z3 = this.lYb[i3].getTrackType() == 5;
                            u uVar = iVar.mCE[i3];
                            u uVar2 = iVar2.mCE[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LD), this.lYt.lYx[i3], this.lYt.dsd());
                            } else {
                                sVar3.dru();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dsb() throws IOException {
        o.a a2;
        if (this.lYs == null) {
            a2 = this.lYg.a(this.lXW);
        } else if (!this.lYs.lYA.lYS && this.lYs.dse() && this.lYs.lYA.lYQ != -9223372036854775807L) {
            if (this.lYu == null || this.lYs.index - this.lYu.index != 100) {
                a2 = this.lYg.a(this.lYs.lYA, this.lYs.dsd(), this.lYr);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.lbk.duY();
            return;
        }
        a aVar = new a(this.lXJ, this.lYb, this.lYs == null ? 60000000L : this.lYs.dsd() + this.lYs.lYA.lYQ, this.lXK, this.lYc, this.lbk, this.lXW.timeline.a(a2.lYM.periodIndex, this.laU, true).lYw, this.lYs == null ? 0 : this.lYs.index + 1, a2);
        if (this.lYs != null) {
            this.lYs.lYD = aVar;
        }
        this.lYs = aVar;
        this.lYs.lYv.a(this, a2.lYN);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lYs != null && this.lYs.lYv == kVar) {
            this.lYs.dsf();
            if (this.lYu == null) {
                this.lYt = this.lYs;
                fu(this.lYt.lYA.lYN);
                b(this.lYt);
            }
            dsc();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lYs != null && this.lYs.lYv == kVar) {
            dsc();
        }
    }

    private void dsc() {
        boolean fr = this.lYs.fr(this.lYr);
        setIsLoading(fr);
        if (fr) {
            this.lYs.fy(this.lYr);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lYD;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lYu != aVar) {
            boolean[] zArr = new boolean[this.lXJ.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lXJ.length; i2++) {
                s sVar = this.lXJ[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lYE.mCB[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lYE.mCB[i2] || (sVar.drv() && sVar.drs() == this.lYu.lYx[i2]))) {
                    b(sVar);
                }
            }
            this.lYu = aVar;
            this.lXM.obtainMessage(2, aVar.lYE).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lYj = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lXJ.length; i3++) {
            if (this.lYu.lYE.mCB[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lXJ[i];
        this.lYj[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lYu.lYE.mCE[i];
            Format[] a2 = a(this.lYu.lYE.mCC.LD(i));
            boolean z3 = this.lXP && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lYu.lYx[i], this.lYr, z2, this.lYu.dsd());
            com.google.android.exoplayer2.util.h drr = sVar.drr();
            if (drr != null) {
                if (this.lYi != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lYi = drr;
                this.lYh = sVar;
                this.lYi.d(this.lXV);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lYt.lYD != null && this.lYt.lYD.lYB && sVar.drt();
    }

    @NonNull
    private static Format[] a(com.google.android.exoplayer2.b.f fVar) {
        int length = fVar != null ? fVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = fVar.KL(i);
        }
        return formatArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final int index;
        private final s[] lXJ;
        private final com.google.android.exoplayer2.b.h lXK;
        public o.a lYA;
        public boolean lYB;
        public boolean lYC;
        public a lYD;
        public com.google.android.exoplayer2.b.i lYE;
        private com.google.android.exoplayer2.b.i lYF;
        private final t[] lYb;
        private final n lYc;
        public final com.google.android.exoplayer2.source.k lYv;
        public final Object lYw;
        public final com.google.android.exoplayer2.source.p[] lYx;
        public final boolean[] lYy;
        public final long lYz;
        private final com.google.android.exoplayer2.source.l lbk;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lXJ = sVarArr;
            this.lYb = tVarArr;
            this.lYz = j;
            this.lXK = hVar;
            this.lYc = nVar;
            this.lbk = lVar;
            this.lYw = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lYA = aVar;
            this.lYx = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lYy = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lYM, nVar.drB());
            if (aVar.lYO != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.S(0L, aVar.lYO);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lYv = cVar;
        }

        public long fw(long j) {
            return dsd() + j;
        }

        public long fx(long j) {
            return j - dsd();
        }

        public long dsd() {
            return this.index == 0 ? this.lYz : this.lYz - this.lYA.lYN;
        }

        public boolean dse() {
            return this.lYB && (!this.lYC || this.lYv.duT() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long duT = !this.lYB ? this.lYA.lYN : this.lYv.duT();
            if (duT == Long.MIN_VALUE) {
                if (this.lYA.lYS) {
                    return true;
                }
                duT = this.lYA.lYQ;
            }
            return this.lYc.k(duT - fx(j), z);
        }

        public void dsf() throws ExoPlaybackException {
            this.lYB = true;
            dsg();
            this.lYA = this.lYA.fA(l(this.lYA.lYN, false));
        }

        public boolean fr(long j) {
            long duU = !this.lYB ? 0L : this.lYv.duU();
            if (duU == Long.MIN_VALUE) {
                return false;
            }
            return this.lYc.fr(duU - fx(j));
        }

        public void fy(long j) {
            this.lYv.gf(fx(j));
        }

        public boolean dsg() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lXK.a(this.lYb, this.lYv.duR());
            if (a.a(this.lYF)) {
                return false;
            }
            this.lYE = a;
            return true;
        }

        public long l(long j, boolean z) {
            return a(j, z, new boolean[this.lXJ.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lYE.mCC;
            for (int i = 0; i < gVar.length; i++) {
                this.lYy[i] = !z && this.lYE.a(this.lYF, i);
            }
            a(this.lYx);
            long a = this.lYv.a(gVar.dxn(), this.lYy, this.lYx, zArr, j);
            b(this.lYx);
            this.lYF = this.lYE;
            this.lYC = false;
            for (int i2 = 0; i2 < this.lYx.length; i2++) {
                if (this.lYx[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lYE.mCB[i2]);
                    if (this.lYb[i2].getTrackType() != 5) {
                        this.lYC = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LD(i2) == null);
                }
            }
            this.lYc.a(this.lXJ, this.lYE.mCA, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lYA.lYO != Long.MIN_VALUE) {
                    this.lbk.e(((com.google.android.exoplayer2.source.c) this.lYv).lYv);
                } else {
                    this.lbk.e(this.lYv);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYb.length; i++) {
                if (this.lYb[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYb.length; i++) {
                if (this.lYb[i].getTrackType() == 5 && this.lYE.mCB[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        public final long lYI;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lYI = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lYG;
        public final Object lYH;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lYG = lVar;
            this.timeline = xVar;
            this.lYH = obj;
        }
    }
}
