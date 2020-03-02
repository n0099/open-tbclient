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
/* loaded from: classes6.dex */
public final class k implements Handler.Callback, h.a, k.a, l.a {
    private int dU;
    private final Handler handler;
    private boolean isLoading;
    private boolean lYC;
    private boolean lYD;
    private q lYI;
    private final t[] lYO;
    private final n lYP;
    private final com.google.android.exoplayer2.util.q lYQ;
    private final HandlerThread lYR;
    private final g lYS;
    private final o lYT;
    private s lYU;
    private com.google.android.exoplayer2.util.h lYV;
    private s[] lYW;
    private boolean lYX;
    private int lYY;
    private int lYZ;
    private final s[] lYw;
    private final com.google.android.exoplayer2.b.h lYx;
    private final Handler lYz;
    private long lZa;
    private int lZb;
    private int lZc;
    private c lZd;
    private long lZe;
    private a lZf;
    private a lZg;
    private a lZh;
    private final x.b lbG;
    private final x.a lbH;
    private com.google.android.exoplayer2.source.l lbX;
    private boolean released;
    private int state = 1;
    private p lYJ = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lYw = sVarArr;
        this.lYx = hVar;
        this.lYP = nVar;
        this.lYC = z;
        this.dU = i;
        this.lYD = z2;
        this.lYz = handler;
        this.lYS = gVar;
        this.lYO = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lYO[i2] = sVarArr[i2].dsG();
        }
        this.lYQ = new com.google.android.exoplayer2.util.q();
        this.lYW = new s[0];
        this.lbG = new x.b();
        this.lbH = new x.a();
        this.lYT = new o();
        hVar.a(this);
        this.lYI = q.lZJ;
        this.lYR = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lYR.start();
        this.handler = new Handler(this.lYR.getLooper(), this);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
    }

    public void vy(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(12, i, 0).sendToTarget();
    }

    public void vz(boolean z) {
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
        this.lYY++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lYY;
            this.lYY = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lYZ <= i) {
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
                    vA(message.arg1 != 0);
                    z = true;
                    break;
                case 2:
                    dtk();
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
                    dtl();
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
                    dtm();
                    z = true;
                    break;
                case 11:
                    c((g.b[]) message.obj);
                    z = true;
                    break;
                case 12:
                    IU(message.arg1);
                    z = true;
                    break;
                case 13:
                    vB(message.arg1 != 0);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.lYz.obtainMessage(7, e).sendToTarget();
            dtl();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lYz.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            dtl();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lYz.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            dtl();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lYz.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lYz.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lZb++;
        vC(true);
        this.lYP.onPrepared();
        if (z) {
            this.lYJ = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lYJ = new p(null, null, this.lYJ.lZG, this.lYJ.lZH, this.lYJ.lZC);
        }
        this.lbX = lVar;
        lVar.a(this.lYS, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vA(boolean z) throws ExoPlaybackException {
        this.lYX = false;
        this.lYC = z;
        if (!z) {
            dti();
            dtj();
        } else if (this.state == 3) {
            dth();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IU(int i) throws ExoPlaybackException {
        this.dU = i;
        this.lYT.setRepeatMode(i);
        dtg();
    }

    private void vB(boolean z) throws ExoPlaybackException {
        this.lYD = z;
        this.lYT.vz(z);
        dtg();
    }

    private void dtg() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lZh != null ? this.lZh : this.lZf;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lYJ.timeline.a(aVar.lZn.lZz.periodIndex, this.lbH, this.lbG, this.dU, this.lYD);
                while (aVar.lZq != null && !aVar.lZn.lZE) {
                    aVar = aVar.lZq;
                }
                if (a2 == -1 || aVar.lZq == null || aVar.lZq.lZn.lZz.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lZq;
            }
            int i = this.lZf.index;
            int i2 = this.lZg != null ? this.lZg.index : -1;
            if (aVar.lZq != null) {
                a(aVar.lZq);
                aVar.lZq = null;
            }
            aVar.lZn = this.lYT.a(aVar.lZn);
            if (!(i <= aVar.index)) {
                this.lZf = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lZh != null) {
                l.b bVar = this.lZh.lZn.lZz;
                long a3 = a(bVar, this.lYJ.lZH);
                if (a3 != this.lYJ.lZH) {
                    this.lYJ = this.lYJ.b(bVar, a3, this.lYJ.lZC);
                    this.lYz.obtainMessage(4, 3, 0, this.lYJ).sendToTarget();
                }
            }
        }
    }

    private void dth() throws ExoPlaybackException {
        this.lYX = false;
        this.lYQ.start();
        for (s sVar : this.lYW) {
            sVar.start();
        }
    }

    private void dti() throws ExoPlaybackException {
        this.lYQ.stop();
        for (s sVar : this.lYW) {
            a(sVar);
        }
    }

    private void dtj() throws ExoPlaybackException {
        if (this.lZh != null) {
            long dwg = this.lZh.lZi.dwg();
            if (dwg != -9223372036854775807L) {
                fs(dwg);
                this.lYJ = this.lYJ.b(this.lYJ.lZG, dwg, this.lYJ.lZC);
                this.lYz.obtainMessage(4, 3, 0, this.lYJ).sendToTarget();
            } else {
                if (this.lYU == null || this.lYU.avR() || (!this.lYU.isReady() && c(this.lYU))) {
                    this.lZe = this.lYQ.dul();
                } else {
                    this.lZe = this.lYV.dul();
                    this.lYQ.gv(this.lZe);
                }
                dwg = this.lZh.fv(this.lZe);
            }
            this.lYJ.lZH = dwg;
            this.lZa = SystemClock.elapsedRealtime() * 1000;
            long dwh = this.lYW.length == 0 ? Long.MIN_VALUE : this.lZh.lZi.dwh();
            p pVar = this.lYJ;
            if (dwh == Long.MIN_VALUE) {
                dwh = this.lZh.lZn.lZD;
            }
            pVar.lZI = dwh;
        }
    }

    private void dtk() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean ft;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dtq();
        if (this.lZh == null) {
            dtn();
            L(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        dtj();
        this.lZh.lZi.gb(this.lYJ.lZH);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lYW) {
            sVar.M(this.lZe, this.lZa);
            z2 = z2 && sVar.avR();
            boolean z3 = sVar.isReady() || sVar.avR() || c(sVar);
            if (!z3) {
                sVar.dsM();
            }
            z = z && z3;
        }
        if (!z) {
            dtn();
        }
        if (this.lYV != null) {
            q dsV = this.lYV.dsV();
            if (!dsV.equals(this.lYI)) {
                this.lYI = dsV;
                this.lYQ.d(dsV);
                this.lYz.obtainMessage(6, dsV).sendToTarget();
            }
        }
        long j = this.lZh.lZn.lZD;
        if (z2 && ((j == -9223372036854775807L || j <= this.lYJ.lZH) && this.lZh.lZn.lZF)) {
            setState(4);
            dti();
        } else if (this.state == 2) {
            if (this.lYW.length > 0) {
                ft = z && this.lZf.f(this.lYX, this.lZe);
            } else {
                ft = ft(j);
            }
            if (ft) {
                setState(3);
                if (this.lYC) {
                    dth();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lYW.length > 0 ? z : ft(j))) {
                this.lYX = this.lYC;
                setState(2);
                dti();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lYW) {
                sVar2.dsM();
            }
        }
        if ((this.lYC && this.state == 3) || this.state == 2) {
            L(elapsedRealtime, 10L);
        } else if (this.lYW.length != 0 && this.state != 4) {
            L(elapsedRealtime, 1000L);
        } else {
            this.handler.removeMessages(2);
        }
        com.google.android.exoplayer2.util.t.endSection();
    }

    private void L(long j, long j2) {
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
        x xVar = this.lYJ.timeline;
        if (xVar == null) {
            this.lZc++;
            this.lZd = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYD), this.lbG).mat;
            this.lYJ = this.lYJ.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lYz.obtainMessage(3, 1, 0, this.lYJ.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vC(false);
            return;
        }
        boolean z2 = cVar.lZv == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b B = this.lYT.B(intValue, longValue);
        if (B.dwu()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (B.equals(this.lYJ.lZG) && j / 1000 == this.lYJ.lZH / 1000) {
                return;
            }
            long a2 = a(B, j);
            boolean z3 = z | (j != a2);
            this.lYJ = this.lYJ.b(B, a2, longValue);
            this.lYz.obtainMessage(3, z3 ? 1 : 0, 0, this.lYJ).sendToTarget();
        } finally {
            this.lYJ = this.lYJ.b(B, j, longValue);
            this.lYz.obtainMessage(3, z ? 1 : 0, 0, this.lYJ).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        dti();
        this.lYX = false;
        setState(2);
        if (this.lZh == null) {
            if (this.lZf != null) {
                this.lZf.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lZh; aVar2 != null; aVar2 = aVar2.lZq) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lZh != aVar || this.lZh != this.lZg) {
            for (s sVar : this.lYW) {
                b(sVar);
            }
            this.lYW = new s[0];
            this.lZh = null;
        }
        if (aVar != null) {
            aVar.lZq = null;
            this.lZf = aVar;
            this.lZg = aVar;
            b(aVar);
            if (this.lZh.lZp) {
                j = this.lZh.lZi.gc(j);
            }
            fs(j);
            dts();
        } else {
            this.lZf = null;
            this.lZg = null;
            this.lZh = null;
            fs(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lZn.lZz) && aVar.lZo) {
            this.lYJ.timeline.a(aVar.lZn.lZz.periodIndex, this.lbH);
            int fB = this.lbH.fB(j);
            if (fB == -1 || this.lbH.IZ(fB) == aVar.lZn.lZB) {
                return true;
            }
        }
        return false;
    }

    private void fs(long j) throws ExoPlaybackException {
        this.lZe = this.lZh == null ? 60000000 + j : this.lZh.fu(j);
        this.lYQ.gv(this.lZe);
        for (s sVar : this.lYW) {
            sVar.fl(this.lZe);
        }
    }

    private void c(q qVar) {
        if (this.lYV != null) {
            qVar = this.lYV.d(qVar);
        }
        this.lYQ.d(qVar);
        this.lYI = qVar;
        this.lYz.obtainMessage(6, qVar).sendToTarget();
    }

    private void dtl() {
        vC(true);
        this.lYP.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vC(true);
        this.lYP.dsQ();
        setState(1);
        this.lYR.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vC(boolean z) {
        this.handler.removeMessages(2);
        this.lYX = false;
        this.lYQ.stop();
        this.lZe = 60000000L;
        for (s sVar : this.lYW) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lYW = new s[0];
        a(this.lZh != null ? this.lZh : this.lZf);
        this.lZf = null;
        this.lZg = null;
        this.lZh = null;
        setIsLoading(false);
        if (z) {
            if (this.lbX != null) {
                this.lbX.releaseSource();
                this.lbX = null;
            }
            this.lYT.a((x) null);
            this.lYJ = this.lYJ.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lYu.k(bVar.messageType, bVar.lYv);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lYZ++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lYZ++;
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
        if (sVar == this.lYU) {
            this.lYV = null;
            this.lYU = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void dtm() throws ExoPlaybackException {
        if (this.lZh != null) {
            boolean z = true;
            for (a aVar = this.lZh; aVar != null && aVar.lZo; aVar = aVar.lZq) {
                if (!aVar.dtw()) {
                    if (aVar == this.lZg) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lZg != this.lZh;
                        a(this.lZh.lZq);
                        this.lZh.lZq = null;
                        this.lZf = this.lZh;
                        this.lZg = this.lZh;
                        boolean[] zArr = new boolean[this.lYw.length];
                        long a2 = this.lZh.a(this.lYJ.lZH, z2, zArr);
                        if (this.state != 4 && a2 != this.lYJ.lZH) {
                            this.lYJ = this.lYJ.b(this.lYJ.lZG, a2, this.lYJ.lZC);
                            this.lYz.obtainMessage(4, 3, 0, this.lYJ).sendToTarget();
                            fs(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lYw.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lYw.length; i2++) {
                            s sVar = this.lYw[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lZh.lZk[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dsI()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fl(this.lZe);
                                }
                            }
                        }
                        this.lYz.obtainMessage(2, aVar.lZr).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lZf = aVar;
                        for (a aVar2 = this.lZf.lZq; aVar2 != null; aVar2 = aVar2.lZq) {
                            aVar2.release();
                        }
                        this.lZf.lZq = null;
                        if (this.lZf.lZo) {
                            this.lZf.n(Math.max(this.lZf.lZn.lZA, this.lZf.fv(this.lZe)), false);
                        }
                    }
                    if (this.state != 4) {
                        dts();
                        dtj();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean ft(long j) {
        return j == -9223372036854775807L || this.lYJ.lZH < j || (this.lZh.lZq != null && (this.lZh.lZq.lZo || this.lZh.lZq.lZn.lZz.dwu()));
    }

    private void dtn() throws IOException {
        if (this.lZf == null || this.lZf.lZo) {
            return;
        }
        if (this.lZg == null || this.lZg.lZq == this.lZf) {
            for (s sVar : this.lYW) {
                if (!sVar.dsJ()) {
                    return;
                }
            }
            this.lZf.lZi.dwe();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lZt == this.lbX) {
            x xVar = this.lYJ.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lZu;
            this.lYT.a(xVar2);
            this.lYJ = this.lYJ.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lZb;
                this.lZb = 0;
                if (this.lZc > 0) {
                    Pair<Integer, Long> b2 = b(this.lZd);
                    int i2 = this.lZc;
                    this.lZc = 0;
                    this.lZd = null;
                    if (b2 == null) {
                        dD(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b B = this.lYT.B(intValue, longValue);
                    this.lYJ = this.lYJ.b(B, B.dwu() ? 0L : longValue, longValue);
                    dE(i, i2);
                    return;
                } else if (this.lYJ.lZA == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dD(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vE(this.lYD), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b B2 = this.lYT.B(intValue2, longValue2);
                    this.lYJ = this.lYJ.b(B2, B2.dwu() ? 0L : longValue2, longValue2);
                    dE(i, 0);
                    return;
                } else {
                    dE(i, 0);
                    return;
                }
            }
            int i3 = this.lYJ.lZG.periodIndex;
            a aVar = this.lZh != null ? this.lZh : this.lZf;
            if (aVar == null && i3 >= xVar.dtC()) {
                dtp();
                return;
            }
            int bw = xVar2.bw(aVar == null ? xVar.a(i3, this.lbH, true).lZj : aVar.lZj);
            if (bw == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dto();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.lbH).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.lbH, true);
                if (aVar != null) {
                    Object obj2 = this.lbH.lZj;
                    aVar.lZn = aVar.lZn.IX(-1);
                    a aVar2 = aVar;
                    while (aVar2.lZq != null) {
                        aVar2 = aVar2.lZq;
                        if (aVar2.lZj.equals(obj2)) {
                            aVar2.lZn = this.lYT.a(aVar2.lZn, intValue3);
                        } else {
                            aVar2.lZn = aVar2.lZn.IX(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lYJ = this.lYJ.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dtp();
                return;
            }
            if (bw != i3) {
                this.lYJ = this.lYJ.IY(bw);
            }
            if (this.lYJ.lZG.dwu()) {
                l.b B3 = this.lYT.B(bw, this.lYJ.lZC);
                if (!B3.dwu() || B3.msh != this.lYJ.lZG.msh) {
                    this.lYJ = this.lYJ.b(B3, a(B3, this.lYJ.lZC), B3.dwu() ? this.lYJ.lZC : -9223372036854775807L);
                    dtp();
                    return;
                }
            }
            if (aVar == null) {
                dtp();
                return;
            }
            a a3 = a(aVar, bw);
            int i4 = bw;
            while (a3.lZq != null) {
                a aVar3 = a3.lZq;
                i4 = xVar2.a(i4, this.lbH, this.lbG, this.dU, this.lYD);
                if (i4 != -1 && aVar3.lZj.equals(xVar2.a(i4, this.lbH, true).lZj)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lZg != null && this.lZg.index < aVar3.index)) {
                        this.lYJ = this.lYJ.b(this.lZh.lZn.lZz, a(this.lZh.lZn.lZz, this.lYJ.lZH), this.lYJ.lZC);
                    } else {
                        this.lZf = a3;
                        this.lZf.lZq = null;
                        a(aVar3);
                    }
                    dtp();
                }
            }
            dtp();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lZn = this.lYT.a(aVar.lZn, i);
            if (aVar.lZn.lZE || aVar.lZq == null) {
                break;
            }
            aVar = aVar.lZq;
        }
        return aVar;
    }

    private void dto() {
        dD(0, 0);
    }

    private void dD(int i, int i2) {
        x xVar = this.lYJ.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYD), this.lbG).mat;
        this.lYJ = this.lYJ.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lYJ.g(i3, 0L, -9223372036854775807L));
        vC(false);
    }

    private void dtp() {
        dE(0, 0);
    }

    private void dE(int i, int i2) {
        a(i, i2, this.lYJ);
    }

    private void a(int i, int i2, p pVar) {
        this.lYz.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dtC = xVar.dtC();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dtC && i3 == -1) {
            int a2 = xVar.a(i4, this.lbH, this.lbG, this.dU, this.lYD);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bw(xVar.a(a2, this.lbH, true).lZj);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lYJ.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.lbG, this.lbH, cVar.windowIndex, cVar.lZv);
            if (xVar == xVar2) {
                return a2;
            }
            int bw = xVar.bw(xVar2.a(((Integer) a2.first).intValue(), this.lbH, true).lZj);
            if (bw != -1) {
                return Pair.create(Integer.valueOf(bw), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.lbH).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lZv);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.lbG, this.lbH, i, j);
    }

    private void dtq() throws ExoPlaybackException, IOException {
        if (this.lYJ.timeline == null) {
            this.lbX.dwm();
            return;
        }
        dtr();
        if (this.lZf == null || this.lZf.dtu()) {
            setIsLoading(false);
        } else if (this.lZf != null && !this.isLoading) {
            dts();
        }
        if (this.lZh != null) {
            while (this.lYC && this.lZh != this.lZg && this.lZe >= this.lZh.lZq.lZm) {
                this.lZh.release();
                b(this.lZh.lZq);
                this.lYJ = this.lYJ.b(this.lZh.lZn.lZz, this.lZh.lZn.lZA, this.lZh.lZn.lZC);
                dtj();
                this.lYz.obtainMessage(4, 0, 0, this.lYJ).sendToTarget();
            }
            if (this.lZg.lZn.lZF) {
                for (int i = 0; i < this.lYw.length; i++) {
                    s sVar = this.lYw[i];
                    com.google.android.exoplayer2.source.p pVar = this.lZg.lZk[i];
                    if (pVar != null && sVar.dsI() == pVar && sVar.dsJ()) {
                        sVar.dsK();
                    }
                }
            } else if (this.lZg.lZq != null && this.lZg.lZq.lZo) {
                for (int i2 = 0; i2 < this.lYw.length; i2++) {
                    s sVar2 = this.lYw[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lZg.lZk[i2];
                    if (sVar2.dsI() == pVar2) {
                        if (pVar2 != null && !sVar2.dsJ()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lZg.lZr;
                this.lZg = this.lZg.lZq;
                com.google.android.exoplayer2.b.i iVar2 = this.lZg.lZr;
                boolean z = this.lZg.lZi.dwg() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lYw.length; i3++) {
                    s sVar3 = this.lYw[i3];
                    if (iVar.mDp[i3]) {
                        if (z) {
                            sVar3.dsK();
                        } else if (!sVar3.dsL()) {
                            com.google.android.exoplayer2.b.f LI = iVar2.mDq.LI(i3);
                            boolean z2 = iVar2.mDp[i3];
                            boolean z3 = this.lYO[i3].getTrackType() == 5;
                            u uVar = iVar.mDs[i3];
                            u uVar2 = iVar2.mDs[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LI), this.lZg.lZk[i3], this.lZg.dtt());
                            } else {
                                sVar3.dsK();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dtr() throws IOException {
        o.a a2;
        if (this.lZf == null) {
            a2 = this.lYT.a(this.lYJ);
        } else if (!this.lZf.lZn.lZF && this.lZf.dtu() && this.lZf.lZn.lZD != -9223372036854775807L) {
            if (this.lZh == null || this.lZf.index - this.lZh.index != 100) {
                a2 = this.lYT.a(this.lZf.lZn, this.lZf.dtt(), this.lZe);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.lbX.dwm();
            return;
        }
        a aVar = new a(this.lYw, this.lYO, this.lZf == null ? 60000000L : this.lZf.dtt() + this.lZf.lZn.lZD, this.lYx, this.lYP, this.lbX, this.lYJ.timeline.a(a2.lZz.periodIndex, this.lbH, true).lZj, this.lZf == null ? 0 : this.lZf.index + 1, a2);
        if (this.lZf != null) {
            this.lZf.lZq = aVar;
        }
        this.lZf = aVar;
        this.lZf.lZi.a(this, a2.lZA);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lZf != null && this.lZf.lZi == kVar) {
            this.lZf.dtv();
            if (this.lZh == null) {
                this.lZg = this.lZf;
                fs(this.lZg.lZn.lZA);
                b(this.lZg);
            }
            dts();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lZf != null && this.lZf.lZi == kVar) {
            dts();
        }
    }

    private void dts() {
        boolean fp = this.lZf.fp(this.lZe);
        setIsLoading(fp);
        if (fp) {
            this.lZf.fw(this.lZe);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lZq;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lZh != aVar) {
            boolean[] zArr = new boolean[this.lYw.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lYw.length; i2++) {
                s sVar = this.lYw[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lZr.mDp[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lZr.mDp[i2] || (sVar.dsL() && sVar.dsI() == this.lZh.lZk[i2]))) {
                    b(sVar);
                }
            }
            this.lZh = aVar;
            this.lYz.obtainMessage(2, aVar.lZr).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lYW = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lYw.length; i3++) {
            if (this.lZh.lZr.mDp[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lYw[i];
        this.lYW[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lZh.lZr.mDs[i];
            Format[] a2 = a(this.lZh.lZr.mDq.LI(i));
            boolean z3 = this.lYC && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lZh.lZk[i], this.lZe, z2, this.lZh.dtt());
            com.google.android.exoplayer2.util.h dsH = sVar.dsH();
            if (dsH != null) {
                if (this.lYV != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lYV = dsH;
                this.lYU = sVar;
                this.lYV.d(this.lYI);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lZg.lZq != null && this.lZg.lZq.lZo && sVar.dsJ();
    }

    @NonNull
    private static Format[] a(com.google.android.exoplayer2.b.f fVar) {
        int length = fVar != null ? fVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = fVar.KQ(i);
        }
        return formatArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int index;
        private final t[] lYO;
        private final n lYP;
        private final s[] lYw;
        private final com.google.android.exoplayer2.b.h lYx;
        public final com.google.android.exoplayer2.source.k lZi;
        public final Object lZj;
        public final com.google.android.exoplayer2.source.p[] lZk;
        public final boolean[] lZl;
        public final long lZm;
        public o.a lZn;
        public boolean lZo;
        public boolean lZp;
        public a lZq;
        public com.google.android.exoplayer2.b.i lZr;
        private com.google.android.exoplayer2.b.i lZs;
        private final com.google.android.exoplayer2.source.l lbX;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lYw = sVarArr;
            this.lYO = tVarArr;
            this.lZm = j;
            this.lYx = hVar;
            this.lYP = nVar;
            this.lbX = lVar;
            this.lZj = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lZn = aVar;
            this.lZk = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lZl = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lZz, nVar.dsR());
            if (aVar.lZB != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.R(0L, aVar.lZB);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lZi = cVar;
        }

        public long fu(long j) {
            return dtt() + j;
        }

        public long fv(long j) {
            return j - dtt();
        }

        public long dtt() {
            return this.index == 0 ? this.lZm : this.lZm - this.lZn.lZA;
        }

        public boolean dtu() {
            return this.lZo && (!this.lZp || this.lZi.dwh() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long dwh = !this.lZo ? this.lZn.lZA : this.lZi.dwh();
            if (dwh == Long.MIN_VALUE) {
                if (this.lZn.lZF) {
                    return true;
                }
                dwh = this.lZn.lZD;
            }
            return this.lYP.m(dwh - fv(j), z);
        }

        public void dtv() throws ExoPlaybackException {
            this.lZo = true;
            dtw();
            this.lZn = this.lZn.fy(n(this.lZn.lZA, false));
        }

        public boolean fp(long j) {
            long dwi = !this.lZo ? 0L : this.lZi.dwi();
            if (dwi == Long.MIN_VALUE) {
                return false;
            }
            return this.lYP.fp(dwi - fv(j));
        }

        public void fw(long j) {
            this.lZi.gd(fv(j));
        }

        public boolean dtw() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lYx.a(this.lYO, this.lZi.dwf());
            if (a.a(this.lZs)) {
                return false;
            }
            this.lZr = a;
            return true;
        }

        public long n(long j, boolean z) {
            return a(j, z, new boolean[this.lYw.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lZr.mDq;
            for (int i = 0; i < gVar.length; i++) {
                this.lZl[i] = !z && this.lZr.a(this.lZs, i);
            }
            a(this.lZk);
            long a = this.lZi.a(gVar.dyB(), this.lZl, this.lZk, zArr, j);
            b(this.lZk);
            this.lZs = this.lZr;
            this.lZp = false;
            for (int i2 = 0; i2 < this.lZk.length; i2++) {
                if (this.lZk[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lZr.mDp[i2]);
                    if (this.lYO[i2].getTrackType() != 5) {
                        this.lZp = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LI(i2) == null);
                }
            }
            this.lYP.a(this.lYw, this.lZr.mDo, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lZn.lZB != Long.MIN_VALUE) {
                    this.lbX.e(((com.google.android.exoplayer2.source.c) this.lZi).lZi);
                } else {
                    this.lbX.e(this.lZi);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYO.length; i++) {
                if (this.lYO[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYO.length; i++) {
                if (this.lYO[i].getTrackType() == 5 && this.lZr.mDp[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final long lZv;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lZv = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lZt;
        public final Object lZu;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lZt = lVar;
            this.timeline = xVar;
            this.lZu = obj;
        }
    }
}
