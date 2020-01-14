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
    private final s[] lXO;
    private final com.google.android.exoplayer2.b.h lXP;
    private final Handler lXR;
    private boolean lXU;
    private boolean lXV;
    private q lYa;
    private final t[] lYg;
    private final n lYh;
    private final com.google.android.exoplayer2.util.q lYi;
    private final HandlerThread lYj;
    private final g lYk;
    private final o lYl;
    private s lYm;
    private com.google.android.exoplayer2.util.h lYn;
    private s[] lYo;
    private boolean lYp;
    private int lYq;
    private int lYr;
    private long lYs;
    private int lYt;
    private int lYu;
    private c lYv;
    private long lYw;
    private a lYx;
    private a lYy;
    private a lYz;
    private final x.b laY;
    private final x.a laZ;
    private com.google.android.exoplayer2.source.l lbp;
    private boolean released;
    private int state = 1;
    private p lYb = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lXO = sVarArr;
        this.lXP = hVar;
        this.lYh = nVar;
        this.lXU = z;
        this.dT = i;
        this.lXV = z2;
        this.lXR = handler;
        this.lYk = gVar;
        this.lYg = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lYg[i2] = sVarArr[i2].drs();
        }
        this.lYi = new com.google.android.exoplayer2.util.q();
        this.lYo = new s[0];
        this.laY = new x.b();
        this.laZ = new x.a();
        this.lYl = new o();
        hVar.a(this);
        this.lYa = q.lZb;
        this.lYj = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lYj.start();
        this.handler = new Handler(this.lYj.getLooper(), this);
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
        this.lYq++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lYq;
            this.lYq = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lYr <= i) {
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
                    drW();
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
                    drX();
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
                    drY();
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
            this.lXR.obtainMessage(7, e).sendToTarget();
            drX();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lXR.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            drX();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lXR.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            drX();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lXR.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lXR.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lYt++;
        vy(true);
        this.lYh.onPrepared();
        if (z) {
            this.lYb = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lYb = new p(null, null, this.lYb.lYY, this.lYb.lYZ, this.lYb.lYU);
        }
        this.lbp = lVar;
        lVar.a(this.lYk, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vw(boolean z) throws ExoPlaybackException {
        this.lYp = false;
        this.lXU = z;
        if (!z) {
            drU();
            drV();
        } else if (this.state == 3) {
            drT();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IP(int i) throws ExoPlaybackException {
        this.dT = i;
        this.lYl.setRepeatMode(i);
        drS();
    }

    private void vx(boolean z) throws ExoPlaybackException {
        this.lXV = z;
        this.lYl.vv(z);
        drS();
    }

    private void drS() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lYz != null ? this.lYz : this.lYx;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lYb.timeline.a(aVar.lYF.lYR.periodIndex, this.laZ, this.laY, this.dT, this.lXV);
                while (aVar.lYI != null && !aVar.lYF.lYW) {
                    aVar = aVar.lYI;
                }
                if (a2 == -1 || aVar.lYI == null || aVar.lYI.lYF.lYR.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lYI;
            }
            int i = this.lYx.index;
            int i2 = this.lYy != null ? this.lYy.index : -1;
            if (aVar.lYI != null) {
                a(aVar.lYI);
                aVar.lYI = null;
            }
            aVar.lYF = this.lYl.a(aVar.lYF);
            if (!(i <= aVar.index)) {
                this.lYx = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lYz != null) {
                l.b bVar = this.lYz.lYF.lYR;
                long a3 = a(bVar, this.lYb.lYZ);
                if (a3 != this.lYb.lYZ) {
                    this.lYb = this.lYb.b(bVar, a3, this.lYb.lYU);
                    this.lXR.obtainMessage(4, 3, 0, this.lYb).sendToTarget();
                }
            }
        }
    }

    private void drT() throws ExoPlaybackException {
        this.lYp = false;
        this.lYi.start();
        for (s sVar : this.lYo) {
            sVar.start();
        }
    }

    private void drU() throws ExoPlaybackException {
        this.lYi.stop();
        for (s sVar : this.lYo) {
            a(sVar);
        }
    }

    private void drV() throws ExoPlaybackException {
        if (this.lYz != null) {
            long duU = this.lYz.lYA.duU();
            if (duU != -9223372036854775807L) {
                fu(duU);
                this.lYb = this.lYb.b(this.lYb.lYY, duU, this.lYb.lYU);
                this.lXR.obtainMessage(4, 3, 0, this.lYb).sendToTarget();
            } else {
                if (this.lYm == null || this.lYm.atB() || (!this.lYm.isReady() && c(this.lYm))) {
                    this.lYw = this.lYi.dsY();
                } else {
                    this.lYw = this.lYn.dsY();
                    this.lYi.gx(this.lYw);
                }
                duU = this.lYz.fx(this.lYw);
            }
            this.lYb.lYZ = duU;
            this.lYs = SystemClock.elapsedRealtime() * 1000;
            long duV = this.lYo.length == 0 ? Long.MIN_VALUE : this.lYz.lYA.duV();
            p pVar = this.lYb;
            if (duV == Long.MIN_VALUE) {
                duV = this.lYz.lYF.lYV;
            }
            pVar.lZa = duV;
        }
    }

    private void drW() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean fv;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dsc();
        if (this.lYz == null) {
            drZ();
            M(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        drV();
        this.lYz.lYA.gd(this.lYb.lYZ);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lYo) {
            sVar.N(this.lYw, this.lYs);
            z2 = z2 && sVar.atB();
            boolean z3 = sVar.isReady() || sVar.atB() || c(sVar);
            if (!z3) {
                sVar.dry();
            }
            z = z && z3;
        }
        if (!z) {
            drZ();
        }
        if (this.lYn != null) {
            q drH = this.lYn.drH();
            if (!drH.equals(this.lYa)) {
                this.lYa = drH;
                this.lYi.d(drH);
                this.lXR.obtainMessage(6, drH).sendToTarget();
            }
        }
        long j = this.lYz.lYF.lYV;
        if (z2 && ((j == -9223372036854775807L || j <= this.lYb.lYZ) && this.lYz.lYF.lYX)) {
            setState(4);
            drU();
        } else if (this.state == 2) {
            if (this.lYo.length > 0) {
                fv = z && this.lYx.f(this.lYp, this.lYw);
            } else {
                fv = fv(j);
            }
            if (fv) {
                setState(3);
                if (this.lXU) {
                    drT();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lYo.length > 0 ? z : fv(j))) {
                this.lYp = this.lXU;
                setState(2);
                drU();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lYo) {
                sVar2.dry();
            }
        }
        if ((this.lXU && this.state == 3) || this.state == 2) {
            M(elapsedRealtime, 10L);
        } else if (this.lYo.length != 0 && this.state != 4) {
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
        x xVar = this.lYb.timeline;
        if (xVar == null) {
            this.lYu++;
            this.lYv = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vA(this.lXV), this.laY).lZJ;
            this.lYb = this.lYb.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lXR.obtainMessage(3, 1, 0, this.lYb.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vy(false);
            return;
        }
        boolean z2 = cVar.lYN == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b C = this.lYl.C(intValue, longValue);
        if (C.dvi()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (C.equals(this.lYb.lYY) && j / 1000 == this.lYb.lYZ / 1000) {
                return;
            }
            long a2 = a(C, j);
            boolean z3 = z | (j != a2);
            this.lYb = this.lYb.b(C, a2, longValue);
            this.lXR.obtainMessage(3, z3 ? 1 : 0, 0, this.lYb).sendToTarget();
        } finally {
            this.lYb = this.lYb.b(C, j, longValue);
            this.lXR.obtainMessage(3, z ? 1 : 0, 0, this.lYb).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        drU();
        this.lYp = false;
        setState(2);
        if (this.lYz == null) {
            if (this.lYx != null) {
                this.lYx.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lYz; aVar2 != null; aVar2 = aVar2.lYI) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lYz != aVar || this.lYz != this.lYy) {
            for (s sVar : this.lYo) {
                b(sVar);
            }
            this.lYo = new s[0];
            this.lYz = null;
        }
        if (aVar != null) {
            aVar.lYI = null;
            this.lYx = aVar;
            this.lYy = aVar;
            b(aVar);
            if (this.lYz.lYH) {
                j = this.lYz.lYA.ge(j);
            }
            fu(j);
            dse();
        } else {
            this.lYx = null;
            this.lYy = null;
            this.lYz = null;
            fu(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lYF.lYR) && aVar.lYG) {
            this.lYb.timeline.a(aVar.lYF.lYR.periodIndex, this.laZ);
            int fD = this.laZ.fD(j);
            if (fD == -1 || this.laZ.IU(fD) == aVar.lYF.lYT) {
                return true;
            }
        }
        return false;
    }

    private void fu(long j) throws ExoPlaybackException {
        this.lYw = this.lYz == null ? 60000000 + j : this.lYz.fw(j);
        this.lYi.gx(this.lYw);
        for (s sVar : this.lYo) {
            sVar.fn(this.lYw);
        }
    }

    private void c(q qVar) {
        if (this.lYn != null) {
            qVar = this.lYn.d(qVar);
        }
        this.lYi.d(qVar);
        this.lYa = qVar;
        this.lXR.obtainMessage(6, qVar).sendToTarget();
    }

    private void drX() {
        vy(true);
        this.lYh.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vy(true);
        this.lYh.drC();
        setState(1);
        this.lYj.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vy(boolean z) {
        this.handler.removeMessages(2);
        this.lYp = false;
        this.lYi.stop();
        this.lYw = 60000000L;
        for (s sVar : this.lYo) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lYo = new s[0];
        a(this.lYz != null ? this.lYz : this.lYx);
        this.lYx = null;
        this.lYy = null;
        this.lYz = null;
        setIsLoading(false);
        if (z) {
            if (this.lbp != null) {
                this.lbp.releaseSource();
                this.lbp = null;
            }
            this.lYl.a((x) null);
            this.lYb = this.lYb.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lXM.k(bVar.messageType, bVar.lXN);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lYr++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lYr++;
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
        if (sVar == this.lYm) {
            this.lYn = null;
            this.lYm = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void drY() throws ExoPlaybackException {
        if (this.lYz != null) {
            boolean z = true;
            for (a aVar = this.lYz; aVar != null && aVar.lYG; aVar = aVar.lYI) {
                if (!aVar.dsi()) {
                    if (aVar == this.lYy) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lYy != this.lYz;
                        a(this.lYz.lYI);
                        this.lYz.lYI = null;
                        this.lYx = this.lYz;
                        this.lYy = this.lYz;
                        boolean[] zArr = new boolean[this.lXO.length];
                        long a2 = this.lYz.a(this.lYb.lYZ, z2, zArr);
                        if (this.state != 4 && a2 != this.lYb.lYZ) {
                            this.lYb = this.lYb.b(this.lYb.lYY, a2, this.lYb.lYU);
                            this.lXR.obtainMessage(4, 3, 0, this.lYb).sendToTarget();
                            fu(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lXO.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lXO.length; i2++) {
                            s sVar = this.lXO[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lYz.lYC[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dru()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fn(this.lYw);
                                }
                            }
                        }
                        this.lXR.obtainMessage(2, aVar.lYJ).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lYx = aVar;
                        for (a aVar2 = this.lYx.lYI; aVar2 != null; aVar2 = aVar2.lYI) {
                            aVar2.release();
                        }
                        this.lYx.lYI = null;
                        if (this.lYx.lYG) {
                            this.lYx.l(Math.max(this.lYx.lYF.lYS, this.lYx.fx(this.lYw)), false);
                        }
                    }
                    if (this.state != 4) {
                        dse();
                        drV();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean fv(long j) {
        return j == -9223372036854775807L || this.lYb.lYZ < j || (this.lYz.lYI != null && (this.lYz.lYI.lYG || this.lYz.lYI.lYF.lYR.dvi()));
    }

    private void drZ() throws IOException {
        if (this.lYx == null || this.lYx.lYG) {
            return;
        }
        if (this.lYy == null || this.lYy.lYI == this.lYx) {
            for (s sVar : this.lYo) {
                if (!sVar.drv()) {
                    return;
                }
            }
            this.lYx.lYA.duS();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lYL == this.lbp) {
            x xVar = this.lYb.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lYM;
            this.lYl.a(xVar2);
            this.lYb = this.lYb.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lYt;
                this.lYt = 0;
                if (this.lYu > 0) {
                    Pair<Integer, Long> b2 = b(this.lYv);
                    int i2 = this.lYu;
                    this.lYu = 0;
                    this.lYv = null;
                    if (b2 == null) {
                        dA(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b C = this.lYl.C(intValue, longValue);
                    this.lYb = this.lYb.b(C, C.dvi() ? 0L : longValue, longValue);
                    dB(i, i2);
                    return;
                } else if (this.lYb.lYS == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dA(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vA(this.lXV), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b C2 = this.lYl.C(intValue2, longValue2);
                    this.lYb = this.lYb.b(C2, C2.dvi() ? 0L : longValue2, longValue2);
                    dB(i, 0);
                    return;
                } else {
                    dB(i, 0);
                    return;
                }
            }
            int i3 = this.lYb.lYY.periodIndex;
            a aVar = this.lYz != null ? this.lYz : this.lYx;
            if (aVar == null && i3 >= xVar.dso()) {
                dsb();
                return;
            }
            int bu = xVar2.bu(aVar == null ? xVar.a(i3, this.laZ, true).lYB : aVar.lYB);
            if (bu == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dsa();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.laZ).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.laZ, true);
                if (aVar != null) {
                    Object obj2 = this.laZ.lYB;
                    aVar.lYF = aVar.lYF.IS(-1);
                    a aVar2 = aVar;
                    while (aVar2.lYI != null) {
                        aVar2 = aVar2.lYI;
                        if (aVar2.lYB.equals(obj2)) {
                            aVar2.lYF = this.lYl.a(aVar2.lYF, intValue3);
                        } else {
                            aVar2.lYF = aVar2.lYF.IS(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lYb = this.lYb.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dsb();
                return;
            }
            if (bu != i3) {
                this.lYb = this.lYb.IT(bu);
            }
            if (this.lYb.lYY.dvi()) {
                l.b C3 = this.lYl.C(bu, this.lYb.lYU);
                if (!C3.dvi() || C3.mry != this.lYb.lYY.mry) {
                    this.lYb = this.lYb.b(C3, a(C3, this.lYb.lYU), C3.dvi() ? this.lYb.lYU : -9223372036854775807L);
                    dsb();
                    return;
                }
            }
            if (aVar == null) {
                dsb();
                return;
            }
            a a3 = a(aVar, bu);
            int i4 = bu;
            while (a3.lYI != null) {
                a aVar3 = a3.lYI;
                i4 = xVar2.a(i4, this.laZ, this.laY, this.dT, this.lXV);
                if (i4 != -1 && aVar3.lYB.equals(xVar2.a(i4, this.laZ, true).lYB)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lYy != null && this.lYy.index < aVar3.index)) {
                        this.lYb = this.lYb.b(this.lYz.lYF.lYR, a(this.lYz.lYF.lYR, this.lYb.lYZ), this.lYb.lYU);
                    } else {
                        this.lYx = a3;
                        this.lYx.lYI = null;
                        a(aVar3);
                    }
                    dsb();
                }
            }
            dsb();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lYF = this.lYl.a(aVar.lYF, i);
            if (aVar.lYF.lYW || aVar.lYI == null) {
                break;
            }
            aVar = aVar.lYI;
        }
        return aVar;
    }

    private void dsa() {
        dA(0, 0);
    }

    private void dA(int i, int i2) {
        x xVar = this.lYb.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vA(this.lXV), this.laY).lZJ;
        this.lYb = this.lYb.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lYb.g(i3, 0L, -9223372036854775807L));
        vy(false);
    }

    private void dsb() {
        dB(0, 0);
    }

    private void dB(int i, int i2) {
        a(i, i2, this.lYb);
    }

    private void a(int i, int i2, p pVar) {
        this.lXR.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dso = xVar.dso();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dso && i3 == -1) {
            int a2 = xVar.a(i4, this.laZ, this.laY, this.dT, this.lXV);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bu(xVar.a(a2, this.laZ, true).lYB);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lYb.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.laY, this.laZ, cVar.windowIndex, cVar.lYN);
            if (xVar == xVar2) {
                return a2;
            }
            int bu = xVar.bu(xVar2.a(((Integer) a2.first).intValue(), this.laZ, true).lYB);
            if (bu != -1) {
                return Pair.create(Integer.valueOf(bu), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.laZ).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lYN);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.laY, this.laZ, i, j);
    }

    private void dsc() throws ExoPlaybackException, IOException {
        if (this.lYb.timeline == null) {
            this.lbp.dva();
            return;
        }
        dsd();
        if (this.lYx == null || this.lYx.dsg()) {
            setIsLoading(false);
        } else if (this.lYx != null && !this.isLoading) {
            dse();
        }
        if (this.lYz != null) {
            while (this.lXU && this.lYz != this.lYy && this.lYw >= this.lYz.lYI.lYE) {
                this.lYz.release();
                b(this.lYz.lYI);
                this.lYb = this.lYb.b(this.lYz.lYF.lYR, this.lYz.lYF.lYS, this.lYz.lYF.lYU);
                drV();
                this.lXR.obtainMessage(4, 0, 0, this.lYb).sendToTarget();
            }
            if (this.lYy.lYF.lYX) {
                for (int i = 0; i < this.lXO.length; i++) {
                    s sVar = this.lXO[i];
                    com.google.android.exoplayer2.source.p pVar = this.lYy.lYC[i];
                    if (pVar != null && sVar.dru() == pVar && sVar.drv()) {
                        sVar.drw();
                    }
                }
            } else if (this.lYy.lYI != null && this.lYy.lYI.lYG) {
                for (int i2 = 0; i2 < this.lXO.length; i2++) {
                    s sVar2 = this.lXO[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lYy.lYC[i2];
                    if (sVar2.dru() == pVar2) {
                        if (pVar2 != null && !sVar2.drv()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lYy.lYJ;
                this.lYy = this.lYy.lYI;
                com.google.android.exoplayer2.b.i iVar2 = this.lYy.lYJ;
                boolean z = this.lYy.lYA.duU() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lXO.length; i3++) {
                    s sVar3 = this.lXO[i3];
                    if (iVar.mCG[i3]) {
                        if (z) {
                            sVar3.drw();
                        } else if (!sVar3.drx()) {
                            com.google.android.exoplayer2.b.f LD = iVar2.mCH.LD(i3);
                            boolean z2 = iVar2.mCG[i3];
                            boolean z3 = this.lYg[i3].getTrackType() == 5;
                            u uVar = iVar.mCJ[i3];
                            u uVar2 = iVar2.mCJ[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LD), this.lYy.lYC[i3], this.lYy.dsf());
                            } else {
                                sVar3.drw();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dsd() throws IOException {
        o.a a2;
        if (this.lYx == null) {
            a2 = this.lYl.a(this.lYb);
        } else if (!this.lYx.lYF.lYX && this.lYx.dsg() && this.lYx.lYF.lYV != -9223372036854775807L) {
            if (this.lYz == null || this.lYx.index - this.lYz.index != 100) {
                a2 = this.lYl.a(this.lYx.lYF, this.lYx.dsf(), this.lYw);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.lbp.dva();
            return;
        }
        a aVar = new a(this.lXO, this.lYg, this.lYx == null ? 60000000L : this.lYx.dsf() + this.lYx.lYF.lYV, this.lXP, this.lYh, this.lbp, this.lYb.timeline.a(a2.lYR.periodIndex, this.laZ, true).lYB, this.lYx == null ? 0 : this.lYx.index + 1, a2);
        if (this.lYx != null) {
            this.lYx.lYI = aVar;
        }
        this.lYx = aVar;
        this.lYx.lYA.a(this, a2.lYS);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lYx != null && this.lYx.lYA == kVar) {
            this.lYx.dsh();
            if (this.lYz == null) {
                this.lYy = this.lYx;
                fu(this.lYy.lYF.lYS);
                b(this.lYy);
            }
            dse();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lYx != null && this.lYx.lYA == kVar) {
            dse();
        }
    }

    private void dse() {
        boolean fr = this.lYx.fr(this.lYw);
        setIsLoading(fr);
        if (fr) {
            this.lYx.fy(this.lYw);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lYI;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lYz != aVar) {
            boolean[] zArr = new boolean[this.lXO.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lXO.length; i2++) {
                s sVar = this.lXO[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lYJ.mCG[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lYJ.mCG[i2] || (sVar.drx() && sVar.dru() == this.lYz.lYC[i2]))) {
                    b(sVar);
                }
            }
            this.lYz = aVar;
            this.lXR.obtainMessage(2, aVar.lYJ).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lYo = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lXO.length; i3++) {
            if (this.lYz.lYJ.mCG[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lXO[i];
        this.lYo[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lYz.lYJ.mCJ[i];
            Format[] a2 = a(this.lYz.lYJ.mCH.LD(i));
            boolean z3 = this.lXU && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lYz.lYC[i], this.lYw, z2, this.lYz.dsf());
            com.google.android.exoplayer2.util.h drt = sVar.drt();
            if (drt != null) {
                if (this.lYn != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lYn = drt;
                this.lYm = sVar;
                this.lYn.d(this.lYa);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lYy.lYI != null && this.lYy.lYI.lYG && sVar.drv();
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
        private final s[] lXO;
        private final com.google.android.exoplayer2.b.h lXP;
        public final com.google.android.exoplayer2.source.k lYA;
        public final Object lYB;
        public final com.google.android.exoplayer2.source.p[] lYC;
        public final boolean[] lYD;
        public final long lYE;
        public o.a lYF;
        public boolean lYG;
        public boolean lYH;
        public a lYI;
        public com.google.android.exoplayer2.b.i lYJ;
        private com.google.android.exoplayer2.b.i lYK;
        private final t[] lYg;
        private final n lYh;
        private final com.google.android.exoplayer2.source.l lbp;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lXO = sVarArr;
            this.lYg = tVarArr;
            this.lYE = j;
            this.lXP = hVar;
            this.lYh = nVar;
            this.lbp = lVar;
            this.lYB = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lYF = aVar;
            this.lYC = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lYD = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lYR, nVar.drD());
            if (aVar.lYT != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.S(0L, aVar.lYT);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lYA = cVar;
        }

        public long fw(long j) {
            return dsf() + j;
        }

        public long fx(long j) {
            return j - dsf();
        }

        public long dsf() {
            return this.index == 0 ? this.lYE : this.lYE - this.lYF.lYS;
        }

        public boolean dsg() {
            return this.lYG && (!this.lYH || this.lYA.duV() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long duV = !this.lYG ? this.lYF.lYS : this.lYA.duV();
            if (duV == Long.MIN_VALUE) {
                if (this.lYF.lYX) {
                    return true;
                }
                duV = this.lYF.lYV;
            }
            return this.lYh.k(duV - fx(j), z);
        }

        public void dsh() throws ExoPlaybackException {
            this.lYG = true;
            dsi();
            this.lYF = this.lYF.fA(l(this.lYF.lYS, false));
        }

        public boolean fr(long j) {
            long duW = !this.lYG ? 0L : this.lYA.duW();
            if (duW == Long.MIN_VALUE) {
                return false;
            }
            return this.lYh.fr(duW - fx(j));
        }

        public void fy(long j) {
            this.lYA.gf(fx(j));
        }

        public boolean dsi() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lXP.a(this.lYg, this.lYA.duT());
            if (a.a(this.lYK)) {
                return false;
            }
            this.lYJ = a;
            return true;
        }

        public long l(long j, boolean z) {
            return a(j, z, new boolean[this.lXO.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lYJ.mCH;
            for (int i = 0; i < gVar.length; i++) {
                this.lYD[i] = !z && this.lYJ.a(this.lYK, i);
            }
            a(this.lYC);
            long a = this.lYA.a(gVar.dxp(), this.lYD, this.lYC, zArr, j);
            b(this.lYC);
            this.lYK = this.lYJ;
            this.lYH = false;
            for (int i2 = 0; i2 < this.lYC.length; i2++) {
                if (this.lYC[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lYJ.mCG[i2]);
                    if (this.lYg[i2].getTrackType() != 5) {
                        this.lYH = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LD(i2) == null);
                }
            }
            this.lYh.a(this.lXO, this.lYJ.mCF, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lYF.lYT != Long.MIN_VALUE) {
                    this.lbp.e(((com.google.android.exoplayer2.source.c) this.lYA).lYA);
                } else {
                    this.lbp.e(this.lYA);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYg.length; i++) {
                if (this.lYg[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lYg.length; i++) {
                if (this.lYg[i].getTrackType() == 5 && this.lYJ.mCG[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        public final long lYN;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lYN = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lYL;
        public final Object lYM;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lYL = lVar;
            this.timeline = xVar;
            this.lYM = obj;
        }
    }
}
