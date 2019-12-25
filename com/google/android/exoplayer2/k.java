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
/* loaded from: classes4.dex */
public final class k implements Handler.Callback, h.a, k.a, l.a {
    private int dU;
    private final Handler handler;
    private boolean isLoading;
    private com.google.android.exoplayer2.source.l kXK;
    private final x.b kXt;
    private final x.a kXu;
    private final s[] lTS;
    private final com.google.android.exoplayer2.b.h lTT;
    private final Handler lTV;
    private boolean lTY;
    private boolean lTZ;
    private long lUA;
    private a lUB;
    private a lUC;
    private a lUD;
    private q lUe;
    private final t[] lUk;
    private final n lUl;
    private final com.google.android.exoplayer2.util.q lUm;
    private final HandlerThread lUn;
    private final g lUo;
    private final o lUp;
    private s lUq;
    private com.google.android.exoplayer2.util.h lUr;
    private s[] lUs;
    private boolean lUt;
    private int lUu;
    private int lUv;
    private long lUw;
    private int lUx;
    private int lUy;
    private c lUz;
    private boolean released;
    private int state = 1;
    private p lUf = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.lTS = sVarArr;
        this.lTT = hVar;
        this.lUl = nVar;
        this.lTY = z;
        this.dU = i;
        this.lTZ = z2;
        this.lTV = handler;
        this.lUo = gVar;
        this.lUk = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.lUk[i2] = sVarArr[i2].dqe();
        }
        this.lUm = new com.google.android.exoplayer2.util.q();
        this.lUs = new s[0];
        this.kXt = new x.b();
        this.kXu = new x.a();
        this.lUp = new o();
        hVar.a(this);
        this.lUe = q.lVf;
        this.lUn = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.lUn.start();
        this.handler = new Handler(this.lUn.getLooper(), this);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
    }

    public void vi(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(12, i, 0).sendToTarget();
    }

    public void vj(boolean z) {
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
        this.lUu++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.lUu;
            this.lUu = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.lUv <= i) {
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
                    vk(message.arg1 != 0);
                    z = true;
                    break;
                case 2:
                    dqI();
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
                    dqJ();
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
                    dqK();
                    z = true;
                    break;
                case 11:
                    c((g.b[]) message.obj);
                    z = true;
                    break;
                case 12:
                    IG(message.arg1);
                    z = true;
                    break;
                case 13:
                    vl(message.arg1 != 0);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.lTV.obtainMessage(7, e).sendToTarget();
            dqJ();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.lTV.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            dqJ();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.lTV.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            dqJ();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.lTV.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.lTV.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.lUx++;
        vm(true);
        this.lUl.onPrepared();
        if (z) {
            this.lUf = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.lUf = new p(null, null, this.lUf.lVc, this.lUf.lVd, this.lUf.lUY);
        }
        this.kXK = lVar;
        lVar.a(this.lUo, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vk(boolean z) throws ExoPlaybackException {
        this.lUt = false;
        this.lTY = z;
        if (!z) {
            dqG();
            dqH();
        } else if (this.state == 3) {
            dqF();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void IG(int i) throws ExoPlaybackException {
        this.dU = i;
        this.lUp.setRepeatMode(i);
        dqE();
    }

    private void vl(boolean z) throws ExoPlaybackException {
        this.lTZ = z;
        this.lUp.vj(z);
        dqE();
    }

    private void dqE() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.lUD != null ? this.lUD : this.lUB;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.lUf.timeline.a(aVar.lUJ.lUV.periodIndex, this.kXu, this.kXt, this.dU, this.lTZ);
                while (aVar.lUM != null && !aVar.lUJ.lVa) {
                    aVar = aVar.lUM;
                }
                if (a2 == -1 || aVar.lUM == null || aVar.lUM.lUJ.lUV.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.lUM;
            }
            int i = this.lUB.index;
            int i2 = this.lUC != null ? this.lUC.index : -1;
            if (aVar.lUM != null) {
                a(aVar.lUM);
                aVar.lUM = null;
            }
            aVar.lUJ = this.lUp.a(aVar.lUJ);
            if (!(i <= aVar.index)) {
                this.lUB = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.lUD != null) {
                l.b bVar = this.lUD.lUJ.lUV;
                long a3 = a(bVar, this.lUf.lVd);
                if (a3 != this.lUf.lVd) {
                    this.lUf = this.lUf.b(bVar, a3, this.lUf.lUY);
                    this.lTV.obtainMessage(4, 3, 0, this.lUf).sendToTarget();
                }
            }
        }
    }

    private void dqF() throws ExoPlaybackException {
        this.lUt = false;
        this.lUm.start();
        for (s sVar : this.lUs) {
            sVar.start();
        }
    }

    private void dqG() throws ExoPlaybackException {
        this.lUm.stop();
        for (s sVar : this.lUs) {
            a(sVar);
        }
    }

    private void dqH() throws ExoPlaybackException {
        if (this.lUD != null) {
            long dtH = this.lUD.lUE.dtH();
            if (dtH != -9223372036854775807L) {
                fp(dtH);
                this.lUf = this.lUf.b(this.lUf.lVc, dtH, this.lUf.lUY);
                this.lTV.obtainMessage(4, 3, 0, this.lUf).sendToTarget();
            } else {
                if (this.lUq == null || this.lUq.ati() || (!this.lUq.isReady() && c(this.lUq))) {
                    this.lUA = this.lUm.drK();
                } else {
                    this.lUA = this.lUr.drK();
                    this.lUm.gs(this.lUA);
                }
                dtH = this.lUD.fs(this.lUA);
            }
            this.lUf.lVd = dtH;
            this.lUw = SystemClock.elapsedRealtime() * 1000;
            long dtI = this.lUs.length == 0 ? Long.MIN_VALUE : this.lUD.lUE.dtI();
            p pVar = this.lUf;
            if (dtI == Long.MIN_VALUE) {
                dtI = this.lUD.lUJ.lUZ;
            }
            pVar.lVe = dtI;
        }
    }

    private void dqI() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean fq;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dqO();
        if (this.lUD == null) {
            dqL();
            M(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        dqH();
        this.lUD.lUE.fY(this.lUf.lVd);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.lUs) {
            sVar.N(this.lUA, this.lUw);
            z2 = z2 && sVar.ati();
            boolean z3 = sVar.isReady() || sVar.ati() || c(sVar);
            if (!z3) {
                sVar.dqk();
            }
            z = z && z3;
        }
        if (!z) {
            dqL();
        }
        if (this.lUr != null) {
            q dqt = this.lUr.dqt();
            if (!dqt.equals(this.lUe)) {
                this.lUe = dqt;
                this.lUm.d(dqt);
                this.lTV.obtainMessage(6, dqt).sendToTarget();
            }
        }
        long j = this.lUD.lUJ.lUZ;
        if (z2 && ((j == -9223372036854775807L || j <= this.lUf.lVd) && this.lUD.lUJ.lVb)) {
            setState(4);
            dqG();
        } else if (this.state == 2) {
            if (this.lUs.length > 0) {
                fq = z && this.lUB.f(this.lUt, this.lUA);
            } else {
                fq = fq(j);
            }
            if (fq) {
                setState(3);
                if (this.lTY) {
                    dqF();
                }
            }
        } else if (this.state == 3) {
            if (!(this.lUs.length > 0 ? z : fq(j))) {
                this.lUt = this.lTY;
                setState(2);
                dqG();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.lUs) {
                sVar2.dqk();
            }
        }
        if ((this.lTY && this.state == 3) || this.state == 2) {
            M(elapsedRealtime, 10L);
        } else if (this.lUs.length != 0 && this.state != 4) {
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
        x xVar = this.lUf.timeline;
        if (xVar == null) {
            this.lUy++;
            this.lUz = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vo(this.lTZ), this.kXt).lVP;
            this.lUf = this.lUf.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.lTV.obtainMessage(3, 1, 0, this.lUf.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vm(false);
            return;
        }
        boolean z2 = cVar.lUR == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b C = this.lUp.C(intValue, longValue);
        if (C.dtV()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (C.equals(this.lUf.lVc) && j / 1000 == this.lUf.lVd / 1000) {
                return;
            }
            long a2 = a(C, j);
            boolean z3 = z | (j != a2);
            this.lUf = this.lUf.b(C, a2, longValue);
            this.lTV.obtainMessage(3, z3 ? 1 : 0, 0, this.lUf).sendToTarget();
        } finally {
            this.lUf = this.lUf.b(C, j, longValue);
            this.lTV.obtainMessage(3, z ? 1 : 0, 0, this.lUf).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        dqG();
        this.lUt = false;
        setState(2);
        if (this.lUD == null) {
            if (this.lUB != null) {
                this.lUB.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.lUD; aVar2 != null; aVar2 = aVar2.lUM) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.lUD != aVar || this.lUD != this.lUC) {
            for (s sVar : this.lUs) {
                b(sVar);
            }
            this.lUs = new s[0];
            this.lUD = null;
        }
        if (aVar != null) {
            aVar.lUM = null;
            this.lUB = aVar;
            this.lUC = aVar;
            b(aVar);
            if (this.lUD.lUL) {
                j = this.lUD.lUE.fZ(j);
            }
            fp(j);
            dqQ();
        } else {
            this.lUB = null;
            this.lUC = null;
            this.lUD = null;
            fp(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.lUJ.lUV) && aVar.lUK) {
            this.lUf.timeline.a(aVar.lUJ.lUV.periodIndex, this.kXu);
            int fy = this.kXu.fy(j);
            if (fy == -1 || this.kXu.IL(fy) == aVar.lUJ.lUX) {
                return true;
            }
        }
        return false;
    }

    private void fp(long j) throws ExoPlaybackException {
        this.lUA = this.lUD == null ? 60000000 + j : this.lUD.fr(j);
        this.lUm.gs(this.lUA);
        for (s sVar : this.lUs) {
            sVar.fi(this.lUA);
        }
    }

    private void c(q qVar) {
        if (this.lUr != null) {
            qVar = this.lUr.d(qVar);
        }
        this.lUm.d(qVar);
        this.lUe = qVar;
        this.lTV.obtainMessage(6, qVar).sendToTarget();
    }

    private void dqJ() {
        vm(true);
        this.lUl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vm(true);
        this.lUl.dqo();
        setState(1);
        this.lUn.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vm(boolean z) {
        this.handler.removeMessages(2);
        this.lUt = false;
        this.lUm.stop();
        this.lUA = 60000000L;
        for (s sVar : this.lUs) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.lUs = new s[0];
        a(this.lUD != null ? this.lUD : this.lUB);
        this.lUB = null;
        this.lUC = null;
        this.lUD = null;
        setIsLoading(false);
        if (z) {
            if (this.kXK != null) {
                this.kXK.releaseSource();
                this.kXK = null;
            }
            this.lUp.a((x) null);
            this.lUf = this.lUf.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.lTQ.k(bVar.messageType, bVar.lTR);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.lUv++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.lUv++;
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
        if (sVar == this.lUq) {
            this.lUr = null;
            this.lUq = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void dqK() throws ExoPlaybackException {
        if (this.lUD != null) {
            boolean z = true;
            for (a aVar = this.lUD; aVar != null && aVar.lUK; aVar = aVar.lUM) {
                if (!aVar.dqU()) {
                    if (aVar == this.lUC) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.lUC != this.lUD;
                        a(this.lUD.lUM);
                        this.lUD.lUM = null;
                        this.lUB = this.lUD;
                        this.lUC = this.lUD;
                        boolean[] zArr = new boolean[this.lTS.length];
                        long a2 = this.lUD.a(this.lUf.lVd, z2, zArr);
                        if (this.state != 4 && a2 != this.lUf.lVd) {
                            this.lUf = this.lUf.b(this.lUf.lVc, a2, this.lUf.lUY);
                            this.lTV.obtainMessage(4, 3, 0, this.lUf).sendToTarget();
                            fp(a2);
                        }
                        boolean[] zArr2 = new boolean[this.lTS.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.lTS.length; i2++) {
                            s sVar = this.lTS[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.lUD.lUG[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dqg()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fi(this.lUA);
                                }
                            }
                        }
                        this.lTV.obtainMessage(2, aVar.lUN).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.lUB = aVar;
                        for (a aVar2 = this.lUB.lUM; aVar2 != null; aVar2 = aVar2.lUM) {
                            aVar2.release();
                        }
                        this.lUB.lUM = null;
                        if (this.lUB.lUK) {
                            this.lUB.l(Math.max(this.lUB.lUJ.lUW, this.lUB.fs(this.lUA)), false);
                        }
                    }
                    if (this.state != 4) {
                        dqQ();
                        dqH();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean fq(long j) {
        return j == -9223372036854775807L || this.lUf.lVd < j || (this.lUD.lUM != null && (this.lUD.lUM.lUK || this.lUD.lUM.lUJ.lUV.dtV()));
    }

    private void dqL() throws IOException {
        if (this.lUB == null || this.lUB.lUK) {
            return;
        }
        if (this.lUC == null || this.lUC.lUM == this.lUB) {
            for (s sVar : this.lUs) {
                if (!sVar.dqh()) {
                    return;
                }
            }
            this.lUB.lUE.dtF();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.lUP == this.kXK) {
            x xVar = this.lUf.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.lUQ;
            this.lUp.a(xVar2);
            this.lUf = this.lUf.b(xVar2, obj);
            if (xVar == null) {
                int i = this.lUx;
                this.lUx = 0;
                if (this.lUy > 0) {
                    Pair<Integer, Long> b2 = b(this.lUz);
                    int i2 = this.lUy;
                    this.lUy = 0;
                    this.lUz = null;
                    if (b2 == null) {
                        dC(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b C = this.lUp.C(intValue, longValue);
                    this.lUf = this.lUf.b(C, C.dtV() ? 0L : longValue, longValue);
                    dD(i, i2);
                    return;
                } else if (this.lUf.lUW == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dC(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vo(this.lTZ), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b C2 = this.lUp.C(intValue2, longValue2);
                    this.lUf = this.lUf.b(C2, C2.dtV() ? 0L : longValue2, longValue2);
                    dD(i, 0);
                    return;
                } else {
                    dD(i, 0);
                    return;
                }
            }
            int i3 = this.lUf.lVc.periodIndex;
            a aVar = this.lUD != null ? this.lUD : this.lUB;
            if (aVar == null && i3 >= xVar.dra()) {
                dqN();
                return;
            }
            int bt = xVar2.bt(aVar == null ? xVar.a(i3, this.kXu, true).lUF : aVar.lUF);
            if (bt == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dqM();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.kXu).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.kXu, true);
                if (aVar != null) {
                    Object obj2 = this.kXu.lUF;
                    aVar.lUJ = aVar.lUJ.IJ(-1);
                    a aVar2 = aVar;
                    while (aVar2.lUM != null) {
                        aVar2 = aVar2.lUM;
                        if (aVar2.lUF.equals(obj2)) {
                            aVar2.lUJ = this.lUp.a(aVar2.lUJ, intValue3);
                        } else {
                            aVar2.lUJ = aVar2.lUJ.IJ(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.lUf = this.lUf.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dqN();
                return;
            }
            if (bt != i3) {
                this.lUf = this.lUf.IK(bt);
            }
            if (this.lUf.lVc.dtV()) {
                l.b C3 = this.lUp.C(bt, this.lUf.lUY);
                if (!C3.dtV() || C3.mnE != this.lUf.lVc.mnE) {
                    this.lUf = this.lUf.b(C3, a(C3, this.lUf.lUY), C3.dtV() ? this.lUf.lUY : -9223372036854775807L);
                    dqN();
                    return;
                }
            }
            if (aVar == null) {
                dqN();
                return;
            }
            a a3 = a(aVar, bt);
            int i4 = bt;
            while (a3.lUM != null) {
                a aVar3 = a3.lUM;
                i4 = xVar2.a(i4, this.kXu, this.kXt, this.dU, this.lTZ);
                if (i4 != -1 && aVar3.lUF.equals(xVar2.a(i4, this.kXu, true).lUF)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.lUC != null && this.lUC.index < aVar3.index)) {
                        this.lUf = this.lUf.b(this.lUD.lUJ.lUV, a(this.lUD.lUJ.lUV, this.lUf.lVd), this.lUf.lUY);
                    } else {
                        this.lUB = a3;
                        this.lUB.lUM = null;
                        a(aVar3);
                    }
                    dqN();
                }
            }
            dqN();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.lUJ = this.lUp.a(aVar.lUJ, i);
            if (aVar.lUJ.lVa || aVar.lUM == null) {
                break;
            }
            aVar = aVar.lUM;
        }
        return aVar;
    }

    private void dqM() {
        dC(0, 0);
    }

    private void dC(int i, int i2) {
        x xVar = this.lUf.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vo(this.lTZ), this.kXt).lVP;
        this.lUf = this.lUf.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.lUf.g(i3, 0L, -9223372036854775807L));
        vm(false);
    }

    private void dqN() {
        dD(0, 0);
    }

    private void dD(int i, int i2) {
        a(i, i2, this.lUf);
    }

    private void a(int i, int i2, p pVar) {
        this.lTV.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dra = xVar.dra();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dra && i3 == -1) {
            int a2 = xVar.a(i4, this.kXu, this.kXt, this.dU, this.lTZ);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bt(xVar.a(a2, this.kXu, true).lUF);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.lUf.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.kXt, this.kXu, cVar.windowIndex, cVar.lUR);
            if (xVar == xVar2) {
                return a2;
            }
            int bt = xVar.bt(xVar2.a(((Integer) a2.first).intValue(), this.kXu, true).lUF);
            if (bt != -1) {
                return Pair.create(Integer.valueOf(bt), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.kXu).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.lUR);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.kXt, this.kXu, i, j);
    }

    private void dqO() throws ExoPlaybackException, IOException {
        if (this.lUf.timeline == null) {
            this.kXK.dtN();
            return;
        }
        dqP();
        if (this.lUB == null || this.lUB.dqS()) {
            setIsLoading(false);
        } else if (this.lUB != null && !this.isLoading) {
            dqQ();
        }
        if (this.lUD != null) {
            while (this.lTY && this.lUD != this.lUC && this.lUA >= this.lUD.lUM.lUI) {
                this.lUD.release();
                b(this.lUD.lUM);
                this.lUf = this.lUf.b(this.lUD.lUJ.lUV, this.lUD.lUJ.lUW, this.lUD.lUJ.lUY);
                dqH();
                this.lTV.obtainMessage(4, 0, 0, this.lUf).sendToTarget();
            }
            if (this.lUC.lUJ.lVb) {
                for (int i = 0; i < this.lTS.length; i++) {
                    s sVar = this.lTS[i];
                    com.google.android.exoplayer2.source.p pVar = this.lUC.lUG[i];
                    if (pVar != null && sVar.dqg() == pVar && sVar.dqh()) {
                        sVar.dqi();
                    }
                }
            } else if (this.lUC.lUM != null && this.lUC.lUM.lUK) {
                for (int i2 = 0; i2 < this.lTS.length; i2++) {
                    s sVar2 = this.lTS[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.lUC.lUG[i2];
                    if (sVar2.dqg() == pVar2) {
                        if (pVar2 != null && !sVar2.dqh()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.lUC.lUN;
                this.lUC = this.lUC.lUM;
                com.google.android.exoplayer2.b.i iVar2 = this.lUC.lUN;
                boolean z = this.lUC.lUE.dtH() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.lTS.length; i3++) {
                    s sVar3 = this.lTS[i3];
                    if (iVar.myL[i3]) {
                        if (z) {
                            sVar3.dqi();
                        } else if (!sVar3.dqj()) {
                            com.google.android.exoplayer2.b.f Lu = iVar2.myM.Lu(i3);
                            boolean z2 = iVar2.myL[i3];
                            boolean z3 = this.lUk[i3].getTrackType() == 5;
                            u uVar = iVar.myO[i3];
                            u uVar2 = iVar2.myO[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(Lu), this.lUC.lUG[i3], this.lUC.dqR());
                            } else {
                                sVar3.dqi();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dqP() throws IOException {
        o.a a2;
        if (this.lUB == null) {
            a2 = this.lUp.a(this.lUf);
        } else if (!this.lUB.lUJ.lVb && this.lUB.dqS() && this.lUB.lUJ.lUZ != -9223372036854775807L) {
            if (this.lUD == null || this.lUB.index - this.lUD.index != 100) {
                a2 = this.lUp.a(this.lUB.lUJ, this.lUB.dqR(), this.lUA);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.kXK.dtN();
            return;
        }
        a aVar = new a(this.lTS, this.lUk, this.lUB == null ? 60000000L : this.lUB.dqR() + this.lUB.lUJ.lUZ, this.lTT, this.lUl, this.kXK, this.lUf.timeline.a(a2.lUV.periodIndex, this.kXu, true).lUF, this.lUB == null ? 0 : this.lUB.index + 1, a2);
        if (this.lUB != null) {
            this.lUB.lUM = aVar;
        }
        this.lUB = aVar;
        this.lUB.lUE.a(this, a2.lUW);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.lUB != null && this.lUB.lUE == kVar) {
            this.lUB.dqT();
            if (this.lUD == null) {
                this.lUC = this.lUB;
                fp(this.lUC.lUJ.lUW);
                b(this.lUC);
            }
            dqQ();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.lUB != null && this.lUB.lUE == kVar) {
            dqQ();
        }
    }

    private void dqQ() {
        boolean fm = this.lUB.fm(this.lUA);
        setIsLoading(fm);
        if (fm) {
            this.lUB.ft(this.lUA);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.lUM;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.lUD != aVar) {
            boolean[] zArr = new boolean[this.lTS.length];
            int i = 0;
            for (int i2 = 0; i2 < this.lTS.length; i2++) {
                s sVar = this.lTS[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.lUN.myL[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.lUN.myL[i2] || (sVar.dqj() && sVar.dqg() == this.lUD.lUG[i2]))) {
                    b(sVar);
                }
            }
            this.lUD = aVar;
            this.lTV.obtainMessage(2, aVar.lUN).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.lUs = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lTS.length; i3++) {
            if (this.lUD.lUN.myL[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.lTS[i];
        this.lUs[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.lUD.lUN.myO[i];
            Format[] a2 = a(this.lUD.lUN.myM.Lu(i));
            boolean z3 = this.lTY && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.lUD.lUG[i], this.lUA, z2, this.lUD.dqR());
            com.google.android.exoplayer2.util.h dqf = sVar.dqf();
            if (dqf != null) {
                if (this.lUr != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.lUr = dqf;
                this.lUq = sVar;
                this.lUr.d(this.lUe);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.lUC.lUM != null && this.lUC.lUM.lUK && sVar.dqh();
    }

    @NonNull
    private static Format[] a(com.google.android.exoplayer2.b.f fVar) {
        int length = fVar != null ? fVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = fVar.KC(i);
        }
        return formatArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final int index;
        private final com.google.android.exoplayer2.source.l kXK;
        private final s[] lTS;
        private final com.google.android.exoplayer2.b.h lTT;
        public final com.google.android.exoplayer2.source.k lUE;
        public final Object lUF;
        public final com.google.android.exoplayer2.source.p[] lUG;
        public final boolean[] lUH;
        public final long lUI;
        public o.a lUJ;
        public boolean lUK;
        public boolean lUL;
        public a lUM;
        public com.google.android.exoplayer2.b.i lUN;
        private com.google.android.exoplayer2.b.i lUO;
        private final t[] lUk;
        private final n lUl;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.lTS = sVarArr;
            this.lUk = tVarArr;
            this.lUI = j;
            this.lTT = hVar;
            this.lUl = nVar;
            this.kXK = lVar;
            this.lUF = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.lUJ = aVar;
            this.lUG = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.lUH = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.lUV, nVar.dqp());
            if (aVar.lUX != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.S(0L, aVar.lUX);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.lUE = cVar;
        }

        public long fr(long j) {
            return dqR() + j;
        }

        public long fs(long j) {
            return j - dqR();
        }

        public long dqR() {
            return this.index == 0 ? this.lUI : this.lUI - this.lUJ.lUW;
        }

        public boolean dqS() {
            return this.lUK && (!this.lUL || this.lUE.dtI() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long dtI = !this.lUK ? this.lUJ.lUW : this.lUE.dtI();
            if (dtI == Long.MIN_VALUE) {
                if (this.lUJ.lVb) {
                    return true;
                }
                dtI = this.lUJ.lUZ;
            }
            return this.lUl.k(dtI - fs(j), z);
        }

        public void dqT() throws ExoPlaybackException {
            this.lUK = true;
            dqU();
            this.lUJ = this.lUJ.fv(l(this.lUJ.lUW, false));
        }

        public boolean fm(long j) {
            long dtJ = !this.lUK ? 0L : this.lUE.dtJ();
            if (dtJ == Long.MIN_VALUE) {
                return false;
            }
            return this.lUl.fm(dtJ - fs(j));
        }

        public void ft(long j) {
            this.lUE.ga(fs(j));
        }

        public boolean dqU() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.lTT.a(this.lUk, this.lUE.dtG());
            if (a.a(this.lUO)) {
                return false;
            }
            this.lUN = a;
            return true;
        }

        public long l(long j, boolean z) {
            return a(j, z, new boolean[this.lTS.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.lUN.myM;
            for (int i = 0; i < gVar.length; i++) {
                this.lUH[i] = !z && this.lUN.a(this.lUO, i);
            }
            a(this.lUG);
            long a = this.lUE.a(gVar.dwc(), this.lUH, this.lUG, zArr, j);
            b(this.lUG);
            this.lUO = this.lUN;
            this.lUL = false;
            for (int i2 = 0; i2 < this.lUG.length; i2++) {
                if (this.lUG[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.lUN.myL[i2]);
                    if (this.lUk[i2].getTrackType() != 5) {
                        this.lUL = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.Lu(i2) == null);
                }
            }
            this.lUl.a(this.lTS, this.lUN.myK, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.lUJ.lUX != Long.MIN_VALUE) {
                    this.kXK.e(((com.google.android.exoplayer2.source.c) this.lUE).lUE);
                } else {
                    this.kXK.e(this.lUE);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lUk.length; i++) {
                if (this.lUk[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.lUk.length; i++) {
                if (this.lUk[i].getTrackType() == 5 && this.lUN.myL[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {
        public final long lUR;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.lUR = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l lUP;
        public final Object lUQ;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.lUP = lVar;
            this.timeline = xVar;
            this.lUQ = obj;
        }
    }
}
