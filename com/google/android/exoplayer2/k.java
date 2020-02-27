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
    private boolean lYA;
    private boolean lYB;
    private q lYG;
    private final t[] lYM;
    private final n lYN;
    private final com.google.android.exoplayer2.util.q lYO;
    private final HandlerThread lYP;
    private final g lYQ;
    private final o lYR;
    private s lYS;
    private com.google.android.exoplayer2.util.h lYT;
    private s[] lYU;
    private boolean lYV;
    private int lYW;
    private int lYX;
    private long lYY;
    private int lYZ;
    private final s[] lYu;
    private final com.google.android.exoplayer2.b.h lYv;
    private final Handler lYx;
    private int lZa;
    private c lZb;
    private long lZc;
    private a lZd;
    private a lZe;
    private a lZf;
    private final x.b lbE;
    private final x.a lbF;
    private com.google.android.exoplayer2.source.l lbV;
    private boolean released;
    private int state = 1;
    private p lYH = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lYu = sVarArr;
        this.lYv = hVar;
        this.lYN = nVar;
        this.lYA = z;
        this.dU = i;
        this.lYB = z2;
        this.lYx = handler;
        this.lYQ = gVar;
        this.lYM = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lYM[i2] = sVarArr[i2].dsE();
        }
        this.lYO = new com.google.android.exoplayer2.util.q();
        this.lYU = new s[0];
        this.lbE = new x.b();
        this.lbF = new x.a();
        this.lYR = new o();
        hVar.a(this);
        this.lYG = q.lZH;
        this.lYP = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lYP.start();
        this.handler = new Handler(this.lYP.getLooper(), this);
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
        this.lYW++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lYW;
            this.lYW = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lYX <= i) {
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
                    dti();
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
                    dtj();
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
                    dtk();
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
            this.lYx.obtainMessage(7, e).sendToTarget();
            dtj();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lYx.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            dtj();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lYx.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            dtj();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lYx.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lYx.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lYZ++;
        vC(true);
        this.lYN.onPrepared();
        if (z) {
            this.lYH = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lYH = new p(null, null, this.lYH.lZE, this.lYH.lZF, this.lYH.lZA);
        }
        this.lbV = lVar;
        lVar.a(this.lYQ, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vA(boolean z) throws ExoPlaybackException {
        this.lYV = false;
        this.lYA = z;
        if (!z) {
            dtg();
            dth();
        } else if (this.state == 3) {
            dtf();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IU(int i) throws ExoPlaybackException {
        this.dU = i;
        this.lYR.setRepeatMode(i);
        dte();
    }

    private void vB(boolean z) throws ExoPlaybackException {
        this.lYB = z;
        this.lYR.vz(z);
        dte();
    }

    private void dte() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lZf != null ? this.lZf : this.lZd;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lYH.timeline.a(aVar.lZl.lZx.periodIndex, this.lbF, this.lbE, this.dU, this.lYB);
                while (aVar.lZo != null && !aVar.lZl.lZC) {
                    aVar = aVar.lZo;
                }
                if (a2 == -1 || aVar.lZo == null || aVar.lZo.lZl.lZx.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lZo;
            }
            int i = this.lZd.index;
            int i2 = this.lZe != null ? this.lZe.index : -1;
            if (aVar.lZo != null) {
                a(aVar.lZo);
                aVar.lZo = null;
            }
            aVar.lZl = this.lYR.a(aVar.lZl);
            if (!(i <= aVar.index)) {
                this.lZd = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lZf != null) {
                l.b bVar = this.lZf.lZl.lZx;
                long a3 = a(bVar, this.lYH.lZF);
                if (a3 != this.lYH.lZF) {
                    this.lYH = this.lYH.b(bVar, a3, this.lYH.lZA);
                    this.lYx.obtainMessage(4, 3, 0, this.lYH).sendToTarget();
                }
            }
        }
    }

    private void dtf() throws ExoPlaybackException {
        this.lYV = false;
        this.lYO.start();
        for (s sVar : this.lYU) {
            sVar.start();
        }
    }

    private void dtg() throws ExoPlaybackException {
        this.lYO.stop();
        for (s sVar : this.lYU) {
            a(sVar);
        }
    }

    private void dth() throws ExoPlaybackException {
        if (this.lZf != null) {
            long dwe = this.lZf.lZg.dwe();
            if (dwe != -9223372036854775807L) {
                fs(dwe);
                this.lYH = this.lYH.b(this.lYH.lZE, dwe, this.lYH.lZA);
                this.lYx.obtainMessage(4, 3, 0, this.lYH).sendToTarget();
            } else {
                if (this.lYS == null || this.lYS.avP() || (!this.lYS.isReady() && c(this.lYS))) {
                    this.lZc = this.lYO.duj();
                } else {
                    this.lZc = this.lYT.duj();
                    this.lYO.gv(this.lZc);
                }
                dwe = this.lZf.fv(this.lZc);
            }
            this.lYH.lZF = dwe;
            this.lYY = SystemClock.elapsedRealtime() * 1000;
            long dwf = this.lYU.length == 0 ? Long.MIN_VALUE : this.lZf.lZg.dwf();
            p pVar = this.lYH;
            if (dwf == Long.MIN_VALUE) {
                dwf = this.lZf.lZl.lZB;
            }
            pVar.lZG = dwf;
        }
    }

    private void dti() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean ft;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dto();
        if (this.lZf == null) {
            dtl();
            L(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        dth();
        this.lZf.lZg.gb(this.lYH.lZF);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lYU) {
            sVar.M(this.lZc, this.lYY);
            z2 = z2 && sVar.avP();
            boolean z3 = sVar.isReady() || sVar.avP() || c(sVar);
            if (!z3) {
                sVar.dsK();
            }
            z = z && z3;
        }
        if (!z) {
            dtl();
        }
        if (this.lYT != null) {
            q dsT = this.lYT.dsT();
            if (!dsT.equals(this.lYG)) {
                this.lYG = dsT;
                this.lYO.d(dsT);
                this.lYx.obtainMessage(6, dsT).sendToTarget();
            }
        }
        long j = this.lZf.lZl.lZB;
        if (z2 && ((j == -9223372036854775807L || j <= this.lYH.lZF) && this.lZf.lZl.lZD)) {
            setState(4);
            dtg();
        } else if (this.state == 2) {
            if (this.lYU.length > 0) {
                ft = z && this.lZd.f(this.lYV, this.lZc);
            } else {
                ft = ft(j);
            }
            if (ft) {
                setState(3);
                if (this.lYA) {
                    dtf();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lYU.length > 0 ? z : ft(j))) {
                this.lYV = this.lYA;
                setState(2);
                dtg();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lYU) {
                sVar2.dsK();
            }
        }
        if ((this.lYA && this.state == 3) || this.state == 2) {
            L(elapsedRealtime, 10L);
        } else if (this.lYU.length != 0 && this.state != 4) {
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
        x xVar = this.lYH.timeline;
        if (xVar == null) {
            this.lZa++;
            this.lZb = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYB), this.lbE).mar;
            this.lYH = this.lYH.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lYx.obtainMessage(3, 1, 0, this.lYH.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vC(false);
            return;
        }
        boolean z2 = cVar.lZt == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b B = this.lYR.B(intValue, longValue);
        if (B.dws()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (B.equals(this.lYH.lZE) && j / 1000 == this.lYH.lZF / 1000) {
                return;
            }
            long a2 = a(B, j);
            boolean z3 = z | (j != a2);
            this.lYH = this.lYH.b(B, a2, longValue);
            this.lYx.obtainMessage(3, z3 ? 1 : 0, 0, this.lYH).sendToTarget();
        } finally {
            this.lYH = this.lYH.b(B, j, longValue);
            this.lYx.obtainMessage(3, z ? 1 : 0, 0, this.lYH).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        dtg();
        this.lYV = false;
        setState(2);
        if (this.lZf == null) {
            if (this.lZd != null) {
                this.lZd.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lZf; aVar2 != null; aVar2 = aVar2.lZo) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lZf != aVar || this.lZf != this.lZe) {
            for (s sVar : this.lYU) {
                b(sVar);
            }
            this.lYU = new s[0];
            this.lZf = null;
        }
        if (aVar != null) {
            aVar.lZo = null;
            this.lZd = aVar;
            this.lZe = aVar;
            b(aVar);
            if (this.lZf.lZn) {
                j = this.lZf.lZg.gc(j);
            }
            fs(j);
            dtq();
        } else {
            this.lZd = null;
            this.lZe = null;
            this.lZf = null;
            fs(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lZl.lZx) && aVar.lZm) {
            this.lYH.timeline.a(aVar.lZl.lZx.periodIndex, this.lbF);
            int fB = this.lbF.fB(j);
            if (fB == -1 || this.lbF.IZ(fB) == aVar.lZl.lZz) {
                return true;
            }
        }
        return false;
    }

    private void fs(long j) throws ExoPlaybackException {
        this.lZc = this.lZf == null ? 60000000 + j : this.lZf.fu(j);
        this.lYO.gv(this.lZc);
        for (s sVar : this.lYU) {
            sVar.fl(this.lZc);
        }
    }

    private void c(q qVar) {
        if (this.lYT != null) {
            qVar = this.lYT.d(qVar);
        }
        this.lYO.d(qVar);
        this.lYG = qVar;
        this.lYx.obtainMessage(6, qVar).sendToTarget();
    }

    private void dtj() {
        vC(true);
        this.lYN.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vC(true);
        this.lYN.dsO();
        setState(1);
        this.lYP.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vC(boolean z) {
        this.handler.removeMessages(2);
        this.lYV = false;
        this.lYO.stop();
        this.lZc = 60000000L;
        for (s sVar : this.lYU) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lYU = new s[0];
        a(this.lZf != null ? this.lZf : this.lZd);
        this.lZd = null;
        this.lZe = null;
        this.lZf = null;
        setIsLoading(false);
        if (z) {
            if (this.lbV != null) {
                this.lbV.releaseSource();
                this.lbV = null;
            }
            this.lYR.a((x) null);
            this.lYH = this.lYH.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lYs.k(bVar.messageType, bVar.lYt);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lYX++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lYX++;
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
        if (sVar == this.lYS) {
            this.lYT = null;
            this.lYS = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void dtk() throws ExoPlaybackException {
        if (this.lZf != null) {
            boolean z = true;
            for (a aVar = this.lZf; aVar != null && aVar.lZm; aVar = aVar.lZo) {
                if (!aVar.dtu()) {
                    if (aVar == this.lZe) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lZe != this.lZf;
                        a(this.lZf.lZo);
                        this.lZf.lZo = null;
                        this.lZd = this.lZf;
                        this.lZe = this.lZf;
                        boolean[] zArr = new boolean[this.lYu.length];
                        long a2 = this.lZf.a(this.lYH.lZF, z2, zArr);
                        if (this.state != 4 && a2 != this.lYH.lZF) {
                            this.lYH = this.lYH.b(this.lYH.lZE, a2, this.lYH.lZA);
                            this.lYx.obtainMessage(4, 3, 0, this.lYH).sendToTarget();
                            fs(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lYu.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lYu.length; i2++) {
                            s sVar = this.lYu[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lZf.lZi[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dsG()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fl(this.lZc);
                                }
                            }
                        }
                        this.lYx.obtainMessage(2, aVar.lZp).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lZd = aVar;
                        for (a aVar2 = this.lZd.lZo; aVar2 != null; aVar2 = aVar2.lZo) {
                            aVar2.release();
                        }
                        this.lZd.lZo = null;
                        if (this.lZd.lZm) {
                            this.lZd.n(Math.max(this.lZd.lZl.lZy, this.lZd.fv(this.lZc)), false);
                        }
                    }
                    if (this.state != 4) {
                        dtq();
                        dth();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean ft(long j) {
        return j == -9223372036854775807L || this.lYH.lZF < j || (this.lZf.lZo != null && (this.lZf.lZo.lZm || this.lZf.lZo.lZl.lZx.dws()));
    }

    private void dtl() throws IOException {
        if (this.lZd == null || this.lZd.lZm) {
            return;
        }
        if (this.lZe == null || this.lZe.lZo == this.lZd) {
            for (s sVar : this.lYU) {
                if (!sVar.dsH()) {
                    return;
                }
            }
            this.lZd.lZg.dwc();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lZr == this.lbV) {
            x xVar = this.lYH.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lZs;
            this.lYR.a(xVar2);
            this.lYH = this.lYH.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lYZ;
                this.lYZ = 0;
                if (this.lZa > 0) {
                    Pair<Integer, Long> b2 = b(this.lZb);
                    int i2 = this.lZa;
                    this.lZa = 0;
                    this.lZb = null;
                    if (b2 == null) {
                        dD(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b B = this.lYR.B(intValue, longValue);
                    this.lYH = this.lYH.b(B, B.dws() ? 0L : longValue, longValue);
                    dE(i, i2);
                    return;
                } else if (this.lYH.lZy == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dD(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vE(this.lYB), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b B2 = this.lYR.B(intValue2, longValue2);
                    this.lYH = this.lYH.b(B2, B2.dws() ? 0L : longValue2, longValue2);
                    dE(i, 0);
                    return;
                } else {
                    dE(i, 0);
                    return;
                }
            }
            int i3 = this.lYH.lZE.periodIndex;
            a aVar = this.lZf != null ? this.lZf : this.lZd;
            if (aVar == null && i3 >= xVar.dtA()) {
                dtn();
                return;
            }
            int bw = xVar2.bw(aVar == null ? xVar.a(i3, this.lbF, true).lZh : aVar.lZh);
            if (bw == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dtm();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.lbF).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.lbF, true);
                if (aVar != null) {
                    Object obj2 = this.lbF.lZh;
                    aVar.lZl = aVar.lZl.IX(-1);
                    a aVar2 = aVar;
                    while (aVar2.lZo != null) {
                        aVar2 = aVar2.lZo;
                        if (aVar2.lZh.equals(obj2)) {
                            aVar2.lZl = this.lYR.a(aVar2.lZl, intValue3);
                        } else {
                            aVar2.lZl = aVar2.lZl.IX(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lYH = this.lYH.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dtn();
                return;
            }
            if (bw != i3) {
                this.lYH = this.lYH.IY(bw);
            }
            if (this.lYH.lZE.dws()) {
                l.b B3 = this.lYR.B(bw, this.lYH.lZA);
                if (!B3.dws() || B3.mse != this.lYH.lZE.mse) {
                    this.lYH = this.lYH.b(B3, a(B3, this.lYH.lZA), B3.dws() ? this.lYH.lZA : -9223372036854775807L);
                    dtn();
                    return;
                }
            }
            if (aVar == null) {
                dtn();
                return;
            }
            a a3 = a(aVar, bw);
            int i4 = bw;
            while (a3.lZo != null) {
                a aVar3 = a3.lZo;
                i4 = xVar2.a(i4, this.lbF, this.lbE, this.dU, this.lYB);
                if (i4 != -1 && aVar3.lZh.equals(xVar2.a(i4, this.lbF, true).lZh)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lZe != null && this.lZe.index < aVar3.index)) {
                        this.lYH = this.lYH.b(this.lZf.lZl.lZx, a(this.lZf.lZl.lZx, this.lYH.lZF), this.lYH.lZA);
                    } else {
                        this.lZd = a3;
                        this.lZd.lZo = null;
                        a(aVar3);
                    }
                    dtn();
                }
            }
            dtn();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lZl = this.lYR.a(aVar.lZl, i);
            if (aVar.lZl.lZC || aVar.lZo == null) {
                break;
            }
            aVar = aVar.lZo;
        }
        return aVar;
    }

    private void dtm() {
        dD(0, 0);
    }

    private void dD(int i, int i2) {
        x xVar = this.lYH.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vE(this.lYB), this.lbE).mar;
        this.lYH = this.lYH.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lYH.g(i3, 0L, -9223372036854775807L));
        vC(false);
    }

    private void dtn() {
        dE(0, 0);
    }

    private void dE(int i, int i2) {
        a(i, i2, this.lYH);
    }

    private void a(int i, int i2, p pVar) {
        this.lYx.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dtA = xVar.dtA();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dtA && i3 == -1) {
            int a2 = xVar.a(i4, this.lbF, this.lbE, this.dU, this.lYB);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bw(xVar.a(a2, this.lbF, true).lZh);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lYH.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.lbE, this.lbF, cVar.windowIndex, cVar.lZt);
            if (xVar == xVar2) {
                return a2;
            }
            int bw = xVar.bw(xVar2.a(((Integer) a2.first).intValue(), this.lbF, true).lZh);
            if (bw != -1) {
                return Pair.create(Integer.valueOf(bw), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.lbF).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lZt);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.lbE, this.lbF, i, j);
    }

    private void dto() throws ExoPlaybackException, IOException {
        if (this.lYH.timeline == null) {
            this.lbV.dwk();
            return;
        }
        dtp();
        if (this.lZd == null || this.lZd.dts()) {
            setIsLoading(false);
        } else if (this.lZd != null && !this.isLoading) {
            dtq();
        }
        if (this.lZf != null) {
            while (this.lYA && this.lZf != this.lZe && this.lZc >= this.lZf.lZo.lZk) {
                this.lZf.release();
                b(this.lZf.lZo);
                this.lYH = this.lYH.b(this.lZf.lZl.lZx, this.lZf.lZl.lZy, this.lZf.lZl.lZA);
                dth();
                this.lYx.obtainMessage(4, 0, 0, this.lYH).sendToTarget();
            }
            if (this.lZe.lZl.lZD) {
                for (int i = 0; i < this.lYu.length; i++) {
                    s sVar = this.lYu[i];
                    com.google.android.exoplayer2.source.p pVar = this.lZe.lZi[i];
                    if (pVar != null && sVar.dsG() == pVar && sVar.dsH()) {
                        sVar.dsI();
                    }
                }
            } else if (this.lZe.lZo != null && this.lZe.lZo.lZm) {
                for (int i2 = 0; i2 < this.lYu.length; i2++) {
                    s sVar2 = this.lYu[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lZe.lZi[i2];
                    if (sVar2.dsG() == pVar2) {
                        if (pVar2 != null && !sVar2.dsH()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lZe.lZp;
                this.lZe = this.lZe.lZo;
                com.google.android.exoplayer2.b.i iVar2 = this.lZe.lZp;
                boolean z = this.lZe.lZg.dwe() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lYu.length; i3++) {
                    s sVar3 = this.lYu[i3];
                    if (iVar.mDn[i3]) {
                        if (z) {
                            sVar3.dsI();
                        } else if (!sVar3.dsJ()) {
                            com.google.android.exoplayer2.b.f LI = iVar2.mDo.LI(i3);
                            boolean z2 = iVar2.mDn[i3];
                            boolean z3 = this.lYM[i3].getTrackType() == 5;
                            u uVar = iVar.mDq[i3];
                            u uVar2 = iVar2.mDq[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LI), this.lZe.lZi[i3], this.lZe.dtr());
                            } else {
                                sVar3.dsI();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dtp() throws IOException {
        o.a a2;
        if (this.lZd == null) {
            a2 = this.lYR.a(this.lYH);
        } else if (!this.lZd.lZl.lZD && this.lZd.dts() && this.lZd.lZl.lZB != -9223372036854775807L) {
            if (this.lZf == null || this.lZd.index - this.lZf.index != 100) {
                a2 = this.lYR.a(this.lZd.lZl, this.lZd.dtr(), this.lZc);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.lbV.dwk();
            return;
        }
        a aVar = new a(this.lYu, this.lYM, this.lZd == null ? 60000000L : this.lZd.dtr() + this.lZd.lZl.lZB, this.lYv, this.lYN, this.lbV, this.lYH.timeline.a(a2.lZx.periodIndex, this.lbF, true).lZh, this.lZd == null ? 0 : this.lZd.index + 1, a2);
        if (this.lZd != null) {
            this.lZd.lZo = aVar;
        }
        this.lZd = aVar;
        this.lZd.lZg.a(this, a2.lZy);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lZd != null && this.lZd.lZg == kVar) {
            this.lZd.dtt();
            if (this.lZf == null) {
                this.lZe = this.lZd;
                fs(this.lZe.lZl.lZy);
                b(this.lZe);
            }
            dtq();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lZd != null && this.lZd.lZg == kVar) {
            dtq();
        }
    }

    private void dtq() {
        boolean fp = this.lZd.fp(this.lZc);
        setIsLoading(fp);
        if (fp) {
            this.lZd.fw(this.lZc);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lZo;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lZf != aVar) {
            boolean[] zArr = new boolean[this.lYu.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lYu.length; i2++) {
                s sVar = this.lYu[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lZp.mDn[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lZp.mDn[i2] || (sVar.dsJ() && sVar.dsG() == this.lZf.lZi[i2]))) {
                    b(sVar);
                }
            }
            this.lZf = aVar;
            this.lYx.obtainMessage(2, aVar.lZp).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lYU = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lYu.length; i3++) {
            if (this.lZf.lZp.mDn[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lYu[i];
        this.lYU[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lZf.lZp.mDq[i];
            Format[] a2 = a(this.lZf.lZp.mDo.LI(i));
            boolean z3 = this.lYA && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lZf.lZi[i], this.lZc, z2, this.lZf.dtr());
            com.google.android.exoplayer2.util.h dsF = sVar.dsF();
            if (dsF != null) {
                if (this.lYT != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lYT = dsF;
                this.lYS = sVar;
                this.lYT.d(this.lYG);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lZe.lZo != null && this.lZe.lZo.lZm && sVar.dsH();
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
        private final t[] lYM;
        private final n lYN;
        private final s[] lYu;
        private final com.google.android.exoplayer2.b.h lYv;
        public final com.google.android.exoplayer2.source.k lZg;
        public final Object lZh;
        public final com.google.android.exoplayer2.source.p[] lZi;
        public final boolean[] lZj;
        public final long lZk;
        public o.a lZl;
        public boolean lZm;
        public boolean lZn;
        public a lZo;
        public com.google.android.exoplayer2.b.i lZp;
        private com.google.android.exoplayer2.b.i lZq;
        private final com.google.android.exoplayer2.source.l lbV;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lYu = sVarArr;
            this.lYM = tVarArr;
            this.lZk = j;
            this.lYv = hVar;
            this.lYN = nVar;
            this.lbV = lVar;
            this.lZh = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lZl = aVar;
            this.lZi = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lZj = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lZx, nVar.dsP());
            if (aVar.lZz != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.R(0L, aVar.lZz);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lZg = cVar;
        }

        public long fu(long j) {
            return dtr() + j;
        }

        public long fv(long j) {
            return j - dtr();
        }

        public long dtr() {
            return this.index == 0 ? this.lZk : this.lZk - this.lZl.lZy;
        }

        public boolean dts() {
            return this.lZm && (!this.lZn || this.lZg.dwf() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long dwf = !this.lZm ? this.lZl.lZy : this.lZg.dwf();
            if (dwf == Long.MIN_VALUE) {
                if (this.lZl.lZD) {
                    return true;
                }
                dwf = this.lZl.lZB;
            }
            return this.lYN.m(dwf - fv(j), z);
        }

        public void dtt() throws ExoPlaybackException {
            this.lZm = true;
            dtu();
            this.lZl = this.lZl.fy(n(this.lZl.lZy, false));
        }

        public boolean fp(long j) {
            long dwg = !this.lZm ? 0L : this.lZg.dwg();
            if (dwg == Long.MIN_VALUE) {
                return false;
            }
            return this.lYN.fp(dwg - fv(j));
        }

        public void fw(long j) {
            this.lZg.gd(fv(j));
        }

        public boolean dtu() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lYv.a(this.lYM, this.lZg.dwd());
            if (a.a(this.lZq)) {
                return false;
            }
            this.lZp = a;
            return true;
        }

        public long n(long j, boolean z) {
            return a(j, z, new boolean[this.lYu.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lZp.mDo;
            for (int i = 0; i < gVar.length; i++) {
                this.lZj[i] = !z && this.lZp.a(this.lZq, i);
            }
            a(this.lZi);
            long a = this.lZg.a(gVar.dyz(), this.lZj, this.lZi, zArr, j);
            b(this.lZi);
            this.lZq = this.lZp;
            this.lZn = false;
            for (int i2 = 0; i2 < this.lZi.length; i2++) {
                if (this.lZi[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lZp.mDn[i2]);
                    if (this.lYM[i2].getTrackType() != 5) {
                        this.lZn = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LI(i2) == null);
                }
            }
            this.lYN.a(this.lYu, this.lZp.mDm, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lZl.lZz != Long.MIN_VALUE) {
                    this.lbV.e(((com.google.android.exoplayer2.source.c) this.lZg).lZg);
                } else {
                    this.lbV.e(this.lZg);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYM.length; i++) {
                if (this.lYM[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYM.length; i++) {
                if (this.lYM[i].getTrackType() == 5 && this.lZp.mDn[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final long lZt;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lZt = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lZr;
        public final Object lZs;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lZr = lVar;
            this.timeline = xVar;
            this.lZs = obj;
        }
    }
}
