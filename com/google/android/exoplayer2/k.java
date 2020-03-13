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
    private final s[] lYH;
    private final com.google.android.exoplayer2.b.h lYI;
    private final Handler lYK;
    private boolean lYN;
    private boolean lYO;
    private q lYT;
    private final t[] lYZ;
    private final n lZa;
    private final com.google.android.exoplayer2.util.q lZb;
    private final HandlerThread lZc;
    private final g lZd;
    private final o lZe;
    private s lZf;
    private com.google.android.exoplayer2.util.h lZg;
    private s[] lZh;
    private boolean lZi;
    private int lZj;
    private int lZk;
    private long lZl;
    private int lZm;
    private int lZn;
    private c lZo;
    private long lZp;
    private a lZq;
    private a lZr;
    private a lZs;
    private final x.b lbS;
    private final x.a lbT;
    private com.google.android.exoplayer2.source.l lcj;
    private boolean released;
    private int state = 1;
    private p lYU = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lYH = sVarArr;
        this.lYI = hVar;
        this.lZa = nVar;
        this.lYN = z;
        this.dU = i;
        this.lYO = z2;
        this.lYK = handler;
        this.lZd = gVar;
        this.lYZ = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lYZ[i2] = sVarArr[i2].dsH();
        }
        this.lZb = new com.google.android.exoplayer2.util.q();
        this.lZh = new s[0];
        this.lbS = new x.b();
        this.lbT = new x.a();
        this.lZe = new o();
        hVar.a(this);
        this.lYT = q.lZU;
        this.lZc = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lZc.start();
        this.handler = new Handler(this.lZc.getLooper(), this);
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
        this.lZj++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lZj;
            this.lZj = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lZk <= i) {
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
                    dtl();
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
                    dtm();
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
                    dtn();
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
            this.lYK.obtainMessage(7, e).sendToTarget();
            dtm();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lYK.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            dtm();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lYK.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            dtm();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lYK.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lYK.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lZm++;
        vC(true);
        this.lZa.onPrepared();
        if (z) {
            this.lYU = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lYU = new p(null, null, this.lYU.lZR, this.lYU.lZS, this.lYU.lZN);
        }
        this.lcj = lVar;
        lVar.a(this.lZd, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vA(boolean z) throws ExoPlaybackException {
        this.lZi = false;
        this.lYN = z;
        if (!z) {
            dtj();
            dtk();
        } else if (this.state == 3) {
            dti();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IU(int i) throws ExoPlaybackException {
        this.dU = i;
        this.lZe.setRepeatMode(i);
        dth();
    }

    private void vB(boolean z) throws ExoPlaybackException {
        this.lYO = z;
        this.lZe.vz(z);
        dth();
    }

    private void dth() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lZs != null ? this.lZs : this.lZq;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lYU.timeline.a(aVar.lZy.lZK.periodIndex, this.lbT, this.lbS, this.dU, this.lYO);
                while (aVar.lZB != null && !aVar.lZy.lZP) {
                    aVar = aVar.lZB;
                }
                if (a2 == -1 || aVar.lZB == null || aVar.lZB.lZy.lZK.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lZB;
            }
            int i = this.lZq.index;
            int i2 = this.lZr != null ? this.lZr.index : -1;
            if (aVar.lZB != null) {
                a(aVar.lZB);
                aVar.lZB = null;
            }
            aVar.lZy = this.lZe.a(aVar.lZy);
            if (!(i <= aVar.index)) {
                this.lZq = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lZs != null) {
                l.b bVar = this.lZs.lZy.lZK;
                long a3 = a(bVar, this.lYU.lZS);
                if (a3 != this.lYU.lZS) {
                    this.lYU = this.lYU.b(bVar, a3, this.lYU.lZN);
                    this.lYK.obtainMessage(4, 3, 0, this.lYU).sendToTarget();
                }
            }
        }
    }

    private void dti() throws ExoPlaybackException {
        this.lZi = false;
        this.lZb.start();
        for (s sVar : this.lZh) {
            sVar.start();
        }
    }

    private void dtj() throws ExoPlaybackException {
        this.lZb.stop();
        for (s sVar : this.lZh) {
            a(sVar);
        }
    }

    private void dtk() throws ExoPlaybackException {
        if (this.lZs != null) {
            long dwh = this.lZs.lZt.dwh();
            if (dwh != -9223372036854775807L) {
                fs(dwh);
                this.lYU = this.lYU.b(this.lYU.lZR, dwh, this.lYU.lZN);
                this.lYK.obtainMessage(4, 3, 0, this.lYU).sendToTarget();
            } else {
                if (this.lZf == null || this.lZf.avR() || (!this.lZf.isReady() && c(this.lZf))) {
                    this.lZp = this.lZb.dum();
                } else {
                    this.lZp = this.lZg.dum();
                    this.lZb.gv(this.lZp);
                }
                dwh = this.lZs.fv(this.lZp);
            }
            this.lYU.lZS = dwh;
            this.lZl = SystemClock.elapsedRealtime() * 1000;
            long dwi = this.lZh.length == 0 ? Long.MIN_VALUE : this.lZs.lZt.dwi();
            p pVar = this.lYU;
            if (dwi == Long.MIN_VALUE) {
                dwi = this.lZs.lZy.lZO;
            }
            pVar.lZT = dwi;
        }
    }

    private void dtl() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean ft;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dtr();
        if (this.lZs == null) {
            dto();
            L(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        dtk();
        this.lZs.lZt.gb(this.lYU.lZS);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lZh) {
            sVar.M(this.lZp, this.lZl);
            z2 = z2 && sVar.avR();
            boolean z3 = sVar.isReady() || sVar.avR() || c(sVar);
            if (!z3) {
                sVar.dsN();
            }
            z = z && z3;
        }
        if (!z) {
            dto();
        }
        if (this.lZg != null) {
            q dsW = this.lZg.dsW();
            if (!dsW.equals(this.lYT)) {
                this.lYT = dsW;
                this.lZb.d(dsW);
                this.lYK.obtainMessage(6, dsW).sendToTarget();
            }
        }
        long j = this.lZs.lZy.lZO;
        if (z2 && ((j == -9223372036854775807L || j <= this.lYU.lZS) && this.lZs.lZy.lZQ)) {
            setState(4);
            dtj();
        } else if (this.state == 2) {
            if (this.lZh.length > 0) {
                ft = z && this.lZq.f(this.lZi, this.lZp);
            } else {
                ft = ft(j);
            }
            if (ft) {
                setState(3);
                if (this.lYN) {
                    dti();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lZh.length > 0 ? z : ft(j))) {
                this.lZi = this.lYN;
                setState(2);
                dtj();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lZh) {
                sVar2.dsN();
            }
        }
        if ((this.lYN && this.state == 3) || this.state == 2) {
            L(elapsedRealtime, 10L);
        } else if (this.lZh.length != 0 && this.state != 4) {
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
        x xVar = this.lYU.timeline;
        if (xVar == null) {
            this.lZn++;
            this.lZo = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYO), this.lbS).maF;
            this.lYU = this.lYU.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lYK.obtainMessage(3, 1, 0, this.lYU.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vC(false);
            return;
        }
        boolean z2 = cVar.lZG == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b B = this.lZe.B(intValue, longValue);
        if (B.dwv()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (B.equals(this.lYU.lZR) && j / 1000 == this.lYU.lZS / 1000) {
                return;
            }
            long a2 = a(B, j);
            boolean z3 = z | (j != a2);
            this.lYU = this.lYU.b(B, a2, longValue);
            this.lYK.obtainMessage(3, z3 ? 1 : 0, 0, this.lYU).sendToTarget();
        } finally {
            this.lYU = this.lYU.b(B, j, longValue);
            this.lYK.obtainMessage(3, z ? 1 : 0, 0, this.lYU).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        dtj();
        this.lZi = false;
        setState(2);
        if (this.lZs == null) {
            if (this.lZq != null) {
                this.lZq.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lZs; aVar2 != null; aVar2 = aVar2.lZB) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lZs != aVar || this.lZs != this.lZr) {
            for (s sVar : this.lZh) {
                b(sVar);
            }
            this.lZh = new s[0];
            this.lZs = null;
        }
        if (aVar != null) {
            aVar.lZB = null;
            this.lZq = aVar;
            this.lZr = aVar;
            b(aVar);
            if (this.lZs.lZA) {
                j = this.lZs.lZt.gc(j);
            }
            fs(j);
            dtt();
        } else {
            this.lZq = null;
            this.lZr = null;
            this.lZs = null;
            fs(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lZy.lZK) && aVar.lZz) {
            this.lYU.timeline.a(aVar.lZy.lZK.periodIndex, this.lbT);
            int fB = this.lbT.fB(j);
            if (fB == -1 || this.lbT.IZ(fB) == aVar.lZy.lZM) {
                return true;
            }
        }
        return false;
    }

    private void fs(long j) throws ExoPlaybackException {
        this.lZp = this.lZs == null ? 60000000 + j : this.lZs.fu(j);
        this.lZb.gv(this.lZp);
        for (s sVar : this.lZh) {
            sVar.fl(this.lZp);
        }
    }

    private void c(q qVar) {
        if (this.lZg != null) {
            qVar = this.lZg.d(qVar);
        }
        this.lZb.d(qVar);
        this.lYT = qVar;
        this.lYK.obtainMessage(6, qVar).sendToTarget();
    }

    private void dtm() {
        vC(true);
        this.lZa.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vC(true);
        this.lZa.dsR();
        setState(1);
        this.lZc.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vC(boolean z) {
        this.handler.removeMessages(2);
        this.lZi = false;
        this.lZb.stop();
        this.lZp = 60000000L;
        for (s sVar : this.lZh) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lZh = new s[0];
        a(this.lZs != null ? this.lZs : this.lZq);
        this.lZq = null;
        this.lZr = null;
        this.lZs = null;
        setIsLoading(false);
        if (z) {
            if (this.lcj != null) {
                this.lcj.releaseSource();
                this.lcj = null;
            }
            this.lZe.a((x) null);
            this.lYU = this.lYU.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lYF.k(bVar.messageType, bVar.lYG);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lZk++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lZk++;
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
        if (sVar == this.lZf) {
            this.lZg = null;
            this.lZf = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void dtn() throws ExoPlaybackException {
        if (this.lZs != null) {
            boolean z = true;
            for (a aVar = this.lZs; aVar != null && aVar.lZz; aVar = aVar.lZB) {
                if (!aVar.dtx()) {
                    if (aVar == this.lZr) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lZr != this.lZs;
                        a(this.lZs.lZB);
                        this.lZs.lZB = null;
                        this.lZq = this.lZs;
                        this.lZr = this.lZs;
                        boolean[] zArr = new boolean[this.lYH.length];
                        long a2 = this.lZs.a(this.lYU.lZS, z2, zArr);
                        if (this.state != 4 && a2 != this.lYU.lZS) {
                            this.lYU = this.lYU.b(this.lYU.lZR, a2, this.lYU.lZN);
                            this.lYK.obtainMessage(4, 3, 0, this.lYU).sendToTarget();
                            fs(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lYH.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lYH.length; i2++) {
                            s sVar = this.lYH[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lZs.lZv[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dsJ()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fl(this.lZp);
                                }
                            }
                        }
                        this.lYK.obtainMessage(2, aVar.lZC).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lZq = aVar;
                        for (a aVar2 = this.lZq.lZB; aVar2 != null; aVar2 = aVar2.lZB) {
                            aVar2.release();
                        }
                        this.lZq.lZB = null;
                        if (this.lZq.lZz) {
                            this.lZq.n(Math.max(this.lZq.lZy.lZL, this.lZq.fv(this.lZp)), false);
                        }
                    }
                    if (this.state != 4) {
                        dtt();
                        dtk();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean ft(long j) {
        return j == -9223372036854775807L || this.lYU.lZS < j || (this.lZs.lZB != null && (this.lZs.lZB.lZz || this.lZs.lZB.lZy.lZK.dwv()));
    }

    private void dto() throws IOException {
        if (this.lZq == null || this.lZq.lZz) {
            return;
        }
        if (this.lZr == null || this.lZr.lZB == this.lZq) {
            for (s sVar : this.lZh) {
                if (!sVar.dsK()) {
                    return;
                }
            }
            this.lZq.lZt.dwf();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lZE == this.lcj) {
            x xVar = this.lYU.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lZF;
            this.lZe.a(xVar2);
            this.lYU = this.lYU.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lZm;
                this.lZm = 0;
                if (this.lZn > 0) {
                    Pair<Integer, Long> b2 = b(this.lZo);
                    int i2 = this.lZn;
                    this.lZn = 0;
                    this.lZo = null;
                    if (b2 == null) {
                        dD(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b B = this.lZe.B(intValue, longValue);
                    this.lYU = this.lYU.b(B, B.dwv() ? 0L : longValue, longValue);
                    dE(i, i2);
                    return;
                } else if (this.lYU.lZL == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dD(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vE(this.lYO), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b B2 = this.lZe.B(intValue2, longValue2);
                    this.lYU = this.lYU.b(B2, B2.dwv() ? 0L : longValue2, longValue2);
                    dE(i, 0);
                    return;
                } else {
                    dE(i, 0);
                    return;
                }
            }
            int i3 = this.lYU.lZR.periodIndex;
            a aVar = this.lZs != null ? this.lZs : this.lZq;
            if (aVar == null && i3 >= xVar.dtD()) {
                dtq();
                return;
            }
            int bw = xVar2.bw(aVar == null ? xVar.a(i3, this.lbT, true).lZu : aVar.lZu);
            if (bw == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dtp();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.lbT).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.lbT, true);
                if (aVar != null) {
                    Object obj2 = this.lbT.lZu;
                    aVar.lZy = aVar.lZy.IX(-1);
                    a aVar2 = aVar;
                    while (aVar2.lZB != null) {
                        aVar2 = aVar2.lZB;
                        if (aVar2.lZu.equals(obj2)) {
                            aVar2.lZy = this.lZe.a(aVar2.lZy, intValue3);
                        } else {
                            aVar2.lZy = aVar2.lZy.IX(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lYU = this.lYU.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dtq();
                return;
            }
            if (bw != i3) {
                this.lYU = this.lYU.IY(bw);
            }
            if (this.lYU.lZR.dwv()) {
                l.b B3 = this.lZe.B(bw, this.lYU.lZN);
                if (!B3.dwv() || B3.mss != this.lYU.lZR.mss) {
                    this.lYU = this.lYU.b(B3, a(B3, this.lYU.lZN), B3.dwv() ? this.lYU.lZN : -9223372036854775807L);
                    dtq();
                    return;
                }
            }
            if (aVar == null) {
                dtq();
                return;
            }
            a a3 = a(aVar, bw);
            int i4 = bw;
            while (a3.lZB != null) {
                a aVar3 = a3.lZB;
                i4 = xVar2.a(i4, this.lbT, this.lbS, this.dU, this.lYO);
                if (i4 != -1 && aVar3.lZu.equals(xVar2.a(i4, this.lbT, true).lZu)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lZr != null && this.lZr.index < aVar3.index)) {
                        this.lYU = this.lYU.b(this.lZs.lZy.lZK, a(this.lZs.lZy.lZK, this.lYU.lZS), this.lYU.lZN);
                    } else {
                        this.lZq = a3;
                        this.lZq.lZB = null;
                        a(aVar3);
                    }
                    dtq();
                }
            }
            dtq();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lZy = this.lZe.a(aVar.lZy, i);
            if (aVar.lZy.lZP || aVar.lZB == null) {
                break;
            }
            aVar = aVar.lZB;
        }
        return aVar;
    }

    private void dtp() {
        dD(0, 0);
    }

    private void dD(int i, int i2) {
        x xVar = this.lYU.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYO), this.lbS).maF;
        this.lYU = this.lYU.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lYU.g(i3, 0L, -9223372036854775807L));
        vC(false);
    }

    private void dtq() {
        dE(0, 0);
    }

    private void dE(int i, int i2) {
        a(i, i2, this.lYU);
    }

    private void a(int i, int i2, p pVar) {
        this.lYK.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dtD = xVar.dtD();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dtD && i3 == -1) {
            int a2 = xVar.a(i4, this.lbT, this.lbS, this.dU, this.lYO);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bw(xVar.a(a2, this.lbT, true).lZu);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lYU.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.lbS, this.lbT, cVar.windowIndex, cVar.lZG);
            if (xVar == xVar2) {
                return a2;
            }
            int bw = xVar.bw(xVar2.a(((Integer) a2.first).intValue(), this.lbT, true).lZu);
            if (bw != -1) {
                return Pair.create(Integer.valueOf(bw), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.lbT).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lZG);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.lbS, this.lbT, i, j);
    }

    private void dtr() throws ExoPlaybackException, IOException {
        if (this.lYU.timeline == null) {
            this.lcj.dwn();
            return;
        }
        dts();
        if (this.lZq == null || this.lZq.dtv()) {
            setIsLoading(false);
        } else if (this.lZq != null && !this.isLoading) {
            dtt();
        }
        if (this.lZs != null) {
            while (this.lYN && this.lZs != this.lZr && this.lZp >= this.lZs.lZB.lZx) {
                this.lZs.release();
                b(this.lZs.lZB);
                this.lYU = this.lYU.b(this.lZs.lZy.lZK, this.lZs.lZy.lZL, this.lZs.lZy.lZN);
                dtk();
                this.lYK.obtainMessage(4, 0, 0, this.lYU).sendToTarget();
            }
            if (this.lZr.lZy.lZQ) {
                for (int i = 0; i < this.lYH.length; i++) {
                    s sVar = this.lYH[i];
                    com.google.android.exoplayer2.source.p pVar = this.lZr.lZv[i];
                    if (pVar != null && sVar.dsJ() == pVar && sVar.dsK()) {
                        sVar.dsL();
                    }
                }
            } else if (this.lZr.lZB != null && this.lZr.lZB.lZz) {
                for (int i2 = 0; i2 < this.lYH.length; i2++) {
                    s sVar2 = this.lYH[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lZr.lZv[i2];
                    if (sVar2.dsJ() == pVar2) {
                        if (pVar2 != null && !sVar2.dsK()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lZr.lZC;
                this.lZr = this.lZr.lZB;
                com.google.android.exoplayer2.b.i iVar2 = this.lZr.lZC;
                boolean z = this.lZr.lZt.dwh() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lYH.length; i3++) {
                    s sVar3 = this.lYH[i3];
                    if (iVar.mDC[i3]) {
                        if (z) {
                            sVar3.dsL();
                        } else if (!sVar3.dsM()) {
                            com.google.android.exoplayer2.b.f LI = iVar2.mDD.LI(i3);
                            boolean z2 = iVar2.mDC[i3];
                            boolean z3 = this.lYZ[i3].getTrackType() == 5;
                            u uVar = iVar.mDF[i3];
                            u uVar2 = iVar2.mDF[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LI), this.lZr.lZv[i3], this.lZr.dtu());
                            } else {
                                sVar3.dsL();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dts() throws IOException {
        o.a a2;
        if (this.lZq == null) {
            a2 = this.lZe.a(this.lYU);
        } else if (!this.lZq.lZy.lZQ && this.lZq.dtv() && this.lZq.lZy.lZO != -9223372036854775807L) {
            if (this.lZs == null || this.lZq.index - this.lZs.index != 100) {
                a2 = this.lZe.a(this.lZq.lZy, this.lZq.dtu(), this.lZp);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.lcj.dwn();
            return;
        }
        a aVar = new a(this.lYH, this.lYZ, this.lZq == null ? 60000000L : this.lZq.dtu() + this.lZq.lZy.lZO, this.lYI, this.lZa, this.lcj, this.lYU.timeline.a(a2.lZK.periodIndex, this.lbT, true).lZu, this.lZq == null ? 0 : this.lZq.index + 1, a2);
        if (this.lZq != null) {
            this.lZq.lZB = aVar;
        }
        this.lZq = aVar;
        this.lZq.lZt.a(this, a2.lZL);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lZq != null && this.lZq.lZt == kVar) {
            this.lZq.dtw();
            if (this.lZs == null) {
                this.lZr = this.lZq;
                fs(this.lZr.lZy.lZL);
                b(this.lZr);
            }
            dtt();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lZq != null && this.lZq.lZt == kVar) {
            dtt();
        }
    }

    private void dtt() {
        boolean fp = this.lZq.fp(this.lZp);
        setIsLoading(fp);
        if (fp) {
            this.lZq.fw(this.lZp);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lZB;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lZs != aVar) {
            boolean[] zArr = new boolean[this.lYH.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lYH.length; i2++) {
                s sVar = this.lYH[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lZC.mDC[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lZC.mDC[i2] || (sVar.dsM() && sVar.dsJ() == this.lZs.lZv[i2]))) {
                    b(sVar);
                }
            }
            this.lZs = aVar;
            this.lYK.obtainMessage(2, aVar.lZC).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lZh = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lYH.length; i3++) {
            if (this.lZs.lZC.mDC[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lYH[i];
        this.lZh[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lZs.lZC.mDF[i];
            Format[] a2 = a(this.lZs.lZC.mDD.LI(i));
            boolean z3 = this.lYN && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lZs.lZv[i], this.lZp, z2, this.lZs.dtu());
            com.google.android.exoplayer2.util.h dsI = sVar.dsI();
            if (dsI != null) {
                if (this.lZg != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lZg = dsI;
                this.lZf = sVar;
                this.lZg.d(this.lYT);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lZr.lZB != null && this.lZr.lZB.lZz && sVar.dsK();
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
        private final s[] lYH;
        private final com.google.android.exoplayer2.b.h lYI;
        private final t[] lYZ;
        public boolean lZA;
        public a lZB;
        public com.google.android.exoplayer2.b.i lZC;
        private com.google.android.exoplayer2.b.i lZD;
        private final n lZa;
        public final com.google.android.exoplayer2.source.k lZt;
        public final Object lZu;
        public final com.google.android.exoplayer2.source.p[] lZv;
        public final boolean[] lZw;
        public final long lZx;
        public o.a lZy;
        public boolean lZz;
        private final com.google.android.exoplayer2.source.l lcj;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lYH = sVarArr;
            this.lYZ = tVarArr;
            this.lZx = j;
            this.lYI = hVar;
            this.lZa = nVar;
            this.lcj = lVar;
            this.lZu = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lZy = aVar;
            this.lZv = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lZw = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lZK, nVar.dsS());
            if (aVar.lZM != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.R(0L, aVar.lZM);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lZt = cVar;
        }

        public long fu(long j) {
            return dtu() + j;
        }

        public long fv(long j) {
            return j - dtu();
        }

        public long dtu() {
            return this.index == 0 ? this.lZx : this.lZx - this.lZy.lZL;
        }

        public boolean dtv() {
            return this.lZz && (!this.lZA || this.lZt.dwi() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long dwi = !this.lZz ? this.lZy.lZL : this.lZt.dwi();
            if (dwi == Long.MIN_VALUE) {
                if (this.lZy.lZQ) {
                    return true;
                }
                dwi = this.lZy.lZO;
            }
            return this.lZa.m(dwi - fv(j), z);
        }

        public void dtw() throws ExoPlaybackException {
            this.lZz = true;
            dtx();
            this.lZy = this.lZy.fy(n(this.lZy.lZL, false));
        }

        public boolean fp(long j) {
            long dwj = !this.lZz ? 0L : this.lZt.dwj();
            if (dwj == Long.MIN_VALUE) {
                return false;
            }
            return this.lZa.fp(dwj - fv(j));
        }

        public void fw(long j) {
            this.lZt.gd(fv(j));
        }

        public boolean dtx() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lYI.a(this.lYZ, this.lZt.dwg());
            if (a.a(this.lZD)) {
                return false;
            }
            this.lZC = a;
            return true;
        }

        public long n(long j, boolean z) {
            return a(j, z, new boolean[this.lYH.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lZC.mDD;
            for (int i = 0; i < gVar.length; i++) {
                this.lZw[i] = !z && this.lZC.a(this.lZD, i);
            }
            a(this.lZv);
            long a = this.lZt.a(gVar.dyC(), this.lZw, this.lZv, zArr, j);
            b(this.lZv);
            this.lZD = this.lZC;
            this.lZA = false;
            for (int i2 = 0; i2 < this.lZv.length; i2++) {
                if (this.lZv[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lZC.mDC[i2]);
                    if (this.lYZ[i2].getTrackType() != 5) {
                        this.lZA = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LI(i2) == null);
                }
            }
            this.lZa.a(this.lYH, this.lZC.mDB, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lZy.lZM != Long.MIN_VALUE) {
                    this.lcj.e(((com.google.android.exoplayer2.source.c) this.lZt).lZt);
                } else {
                    this.lcj.e(this.lZt);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYZ.length; i++) {
                if (this.lYZ[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYZ.length; i++) {
                if (this.lYZ[i].getTrackType() == 5 && this.lZC.mDC[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final long lZG;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lZG = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lZE;
        public final Object lZF;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lZE = lVar;
            this.timeline = xVar;
            this.lZF = obj;
        }
    }
}
