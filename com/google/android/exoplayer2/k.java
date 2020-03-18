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
    private int dT;
    private final Handler handler;
    private boolean isLoading;
    private com.google.android.exoplayer2.source.l ldO;
    private final x.b ldx;
    private final x.a ldy;
    private q maC;
    private final t[] maI;
    private final n maJ;
    private final com.google.android.exoplayer2.util.q maK;
    private final HandlerThread maL;
    private final g maM;
    private final o maN;
    private s maO;
    private com.google.android.exoplayer2.util.h maP;
    private s[] maQ;
    private boolean maR;
    private int maS;
    private int maT;
    private long maU;
    private int maV;
    private int maW;
    private c maX;
    private long maY;
    private a maZ;
    private final s[] mao;
    private final com.google.android.exoplayer2.b.h maq;
    private final Handler mas;
    private boolean mav;
    private boolean maw;
    private a mba;
    private a mbb;
    private boolean released;
    private int state = 1;
    private p maD = new p(null, null, 0, -9223372036854775807L);

    public k(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar, boolean z, int i, boolean z2, Handler handler, g gVar) {
        this.mao = sVarArr;
        this.maq = hVar;
        this.maJ = nVar;
        this.mav = z;
        this.dT = i;
        this.maw = z2;
        this.mas = handler;
        this.maM = gVar;
        this.maI = new t[sVarArr.length];
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            sVarArr[i2].setIndex(i2);
            this.maI[i2] = sVarArr[i2].dte();
        }
        this.maK = new com.google.android.exoplayer2.util.q();
        this.maQ = new s[0];
        this.ldx = new x.b();
        this.ldy = new x.a();
        this.maN = new o();
        hVar.a(this);
        this.maC = q.mbD;
        this.maL = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.maL.start();
        this.handler = new Handler(this.maL.getLooper(), this);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
    }

    public void vF(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(12, i, 0).sendToTarget();
    }

    public void vG(boolean z) {
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
        this.maS++;
        this.handler.obtainMessage(11, bVarArr).sendToTarget();
    }

    public synchronized void b(g.b... bVarArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.maS;
            this.maS = i + 1;
            this.handler.obtainMessage(11, bVarArr).sendToTarget();
            boolean z = false;
            while (this.maT <= i) {
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
                    vH(message.arg1 != 0);
                    z = true;
                    break;
                case 2:
                    dtI();
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
                    dtJ();
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
                    dtK();
                    z = true;
                    break;
                case 11:
                    c((g.b[]) message.obj);
                    z = true;
                    break;
                case 12:
                    Ja(message.arg1);
                    z = true;
                    break;
                case 13:
                    vI(message.arg1 != 0);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.mas.obtainMessage(7, e).sendToTarget();
            dtJ();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.mas.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
            dtJ();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.mas.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            dtJ();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.mas.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.mas.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.l lVar, boolean z) {
        this.maV++;
        vJ(true);
        this.maJ.onPrepared();
        if (z) {
            this.maD = new p(null, null, 0, -9223372036854775807L);
        } else {
            this.maD = new p(null, null, this.maD.mbA, this.maD.mbB, this.maD.mbw);
        }
        this.ldO = lVar;
        lVar.a(this.maM, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void vH(boolean z) throws ExoPlaybackException {
        this.maR = false;
        this.mav = z;
        if (!z) {
            dtG();
            dtH();
        } else if (this.state == 3) {
            dtF();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void Ja(int i) throws ExoPlaybackException {
        this.dT = i;
        this.maN.setRepeatMode(i);
        dtE();
    }

    private void vI(boolean z) throws ExoPlaybackException {
        this.maw = z;
        this.maN.vG(z);
        dtE();
    }

    private void dtE() throws ExoPlaybackException {
        a aVar;
        a aVar2 = this.mbb != null ? this.mbb : this.maZ;
        if (aVar2 != null) {
            while (true) {
                aVar = aVar2;
                int a2 = this.maD.timeline.a(aVar.mbh.mbt.periodIndex, this.ldy, this.ldx, this.dT, this.maw);
                while (aVar.mbk != null && !aVar.mbh.mby) {
                    aVar = aVar.mbk;
                }
                if (a2 == -1 || aVar.mbk == null || aVar.mbk.mbh.mbt.periodIndex != a2) {
                    break;
                }
                aVar2 = aVar.mbk;
            }
            int i = this.maZ.index;
            int i2 = this.mba != null ? this.mba.index : -1;
            if (aVar.mbk != null) {
                a(aVar.mbk);
                aVar.mbk = null;
            }
            aVar.mbh = this.maN.a(aVar.mbh);
            if (!(i <= aVar.index)) {
                this.maZ = aVar;
            }
            if (!(i2 != -1 && i2 <= aVar.index) && this.mbb != null) {
                l.b bVar = this.mbb.mbh.mbt;
                long a3 = a(bVar, this.maD.mbB);
                if (a3 != this.maD.mbB) {
                    this.maD = this.maD.b(bVar, a3, this.maD.mbw);
                    this.mas.obtainMessage(4, 3, 0, this.maD).sendToTarget();
                }
            }
        }
    }

    private void dtF() throws ExoPlaybackException {
        this.maR = false;
        this.maK.start();
        for (s sVar : this.maQ) {
            sVar.start();
        }
    }

    private void dtG() throws ExoPlaybackException {
        this.maK.stop();
        for (s sVar : this.maQ) {
            a(sVar);
        }
    }

    private void dtH() throws ExoPlaybackException {
        if (this.mbb != null) {
            long dwE = this.mbb.mbc.dwE();
            if (dwE != -9223372036854775807L) {
                ft(dwE);
                this.maD = this.maD.b(this.maD.mbA, dwE, this.maD.mbw);
                this.mas.obtainMessage(4, 3, 0, this.maD).sendToTarget();
            } else {
                if (this.maO == null || this.maO.avU() || (!this.maO.isReady() && c(this.maO))) {
                    this.maY = this.maK.duJ();
                } else {
                    this.maY = this.maP.duJ();
                    this.maK.gw(this.maY);
                }
                dwE = this.mbb.fw(this.maY);
            }
            this.maD.mbB = dwE;
            this.maU = SystemClock.elapsedRealtime() * 1000;
            long dwF = this.maQ.length == 0 ? Long.MIN_VALUE : this.mbb.mbc.dwF();
            p pVar = this.maD;
            if (dwF == Long.MIN_VALUE) {
                dwF = this.mbb.mbh.mbx;
            }
            pVar.mbC = dwF;
        }
    }

    private void dtI() throws ExoPlaybackException, IOException {
        s[] sVarArr;
        boolean fu;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dtO();
        if (this.mbb == null) {
            dtL();
            L(elapsedRealtime, 10L);
            return;
        }
        com.google.android.exoplayer2.util.t.beginSection("doSomeWork");
        dtH();
        this.mbb.mbc.gc(this.maD.mbB);
        boolean z = true;
        boolean z2 = true;
        for (s sVar : this.maQ) {
            sVar.M(this.maY, this.maU);
            z2 = z2 && sVar.avU();
            boolean z3 = sVar.isReady() || sVar.avU() || c(sVar);
            if (!z3) {
                sVar.dtk();
            }
            z = z && z3;
        }
        if (!z) {
            dtL();
        }
        if (this.maP != null) {
            q dtt = this.maP.dtt();
            if (!dtt.equals(this.maC)) {
                this.maC = dtt;
                this.maK.d(dtt);
                this.mas.obtainMessage(6, dtt).sendToTarget();
            }
        }
        long j = this.mbb.mbh.mbx;
        if (z2 && ((j == -9223372036854775807L || j <= this.maD.mbB) && this.mbb.mbh.mbz)) {
            setState(4);
            dtG();
        } else if (this.state == 2) {
            if (this.maQ.length > 0) {
                fu = z && this.maZ.f(this.maR, this.maY);
            } else {
                fu = fu(j);
            }
            if (fu) {
                setState(3);
                if (this.mav) {
                    dtF();
                }
            }
        } else if (this.state == 3) {
            if (!(this.maQ.length > 0 ? z : fu(j))) {
                this.maR = this.mav;
                setState(2);
                dtG();
            }
        }
        if (this.state == 2) {
            for (s sVar2 : this.maQ) {
                sVar2.dtk();
            }
        }
        if ((this.mav && this.state == 3) || this.state == 2) {
            L(elapsedRealtime, 10L);
        } else if (this.maQ.length != 0 && this.state != 4) {
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
        x xVar = this.maD.timeline;
        if (xVar == null) {
            this.maW++;
            this.maX = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            int i = xVar.isEmpty() ? 0 : xVar.a(xVar.vL(this.maw), this.ldx).mcl;
            this.maD = this.maD.g(i, -9223372036854775807L, -9223372036854775807L);
            setState(4);
            this.mas.obtainMessage(3, 1, 0, this.maD.g(i, 0L, -9223372036854775807L)).sendToTarget();
            vJ(false);
            return;
        }
        boolean z2 = cVar.mbp == -9223372036854775807L;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        l.b B = this.maN.B(intValue, longValue);
        if (B.dwS()) {
            j = 0;
            z = true;
        } else {
            z = z2;
            j = longValue;
        }
        try {
            if (B.equals(this.maD.mbA) && j / 1000 == this.maD.mbB / 1000) {
                return;
            }
            long a2 = a(B, j);
            boolean z3 = z | (j != a2);
            this.maD = this.maD.b(B, a2, longValue);
            this.mas.obtainMessage(3, z3 ? 1 : 0, 0, this.maD).sendToTarget();
        } finally {
            this.maD = this.maD.b(B, j, longValue);
            this.mas.obtainMessage(3, z ? 1 : 0, 0, this.maD).sendToTarget();
        }
    }

    private long a(l.b bVar, long j) throws ExoPlaybackException {
        a aVar;
        dtG();
        this.maR = false;
        setState(2);
        if (this.mbb == null) {
            if (this.maZ != null) {
                this.maZ.release();
                aVar = null;
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
            for (a aVar2 = this.mbb; aVar2 != null; aVar2 = aVar2.mbk) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
            }
        }
        if (this.mbb != aVar || this.mbb != this.mba) {
            for (s sVar : this.maQ) {
                b(sVar);
            }
            this.maQ = new s[0];
            this.mbb = null;
        }
        if (aVar != null) {
            aVar.mbk = null;
            this.maZ = aVar;
            this.mba = aVar;
            b(aVar);
            if (this.mbb.mbj) {
                j = this.mbb.mbc.gd(j);
            }
            ft(j);
            dtQ();
        } else {
            this.maZ = null;
            this.mba = null;
            this.mbb = null;
            ft(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean a(l.b bVar, long j, a aVar) {
        if (bVar.equals(aVar.mbh.mbt) && aVar.mbi) {
            this.maD.timeline.a(aVar.mbh.mbt.periodIndex, this.ldy);
            int fC = this.ldy.fC(j);
            if (fC == -1 || this.ldy.Jf(fC) == aVar.mbh.mbv) {
                return true;
            }
        }
        return false;
    }

    private void ft(long j) throws ExoPlaybackException {
        this.maY = this.mbb == null ? 60000000 + j : this.mbb.fv(j);
        this.maK.gw(this.maY);
        for (s sVar : this.maQ) {
            sVar.fm(this.maY);
        }
    }

    private void c(q qVar) {
        if (this.maP != null) {
            qVar = this.maP.d(qVar);
        }
        this.maK.d(qVar);
        this.maC = qVar;
        this.mas.obtainMessage(6, qVar).sendToTarget();
    }

    private void dtJ() {
        vJ(true);
        this.maJ.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        vJ(true);
        this.maJ.dto();
        setState(1);
        this.maL.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void vJ(boolean z) {
        this.handler.removeMessages(2);
        this.maR = false;
        this.maK.stop();
        this.maY = 60000000L;
        for (s sVar : this.maQ) {
            try {
                b(sVar);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.maQ = new s[0];
        a(this.mbb != null ? this.mbb : this.maZ);
        this.maZ = null;
        this.mba = null;
        this.mbb = null;
        setIsLoading(false);
        if (z) {
            if (this.ldO != null) {
                this.ldO.releaseSource();
                this.ldO = null;
            }
            this.maN.a((x) null);
            this.maD = this.maD.b(null, null);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void c(g.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (g.b bVar : bVarArr) {
                bVar.mam.k(bVar.messageType, bVar.man);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.maT++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.maT++;
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
        if (sVar == this.maO) {
            this.maP = null;
            this.maO = null;
        }
        a(sVar);
        sVar.disable();
    }

    private void dtK() throws ExoPlaybackException {
        if (this.mbb != null) {
            boolean z = true;
            for (a aVar = this.mbb; aVar != null && aVar.mbi; aVar = aVar.mbk) {
                if (!aVar.dtU()) {
                    if (aVar == this.mba) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.mba != this.mbb;
                        a(this.mbb.mbk);
                        this.mbb.mbk = null;
                        this.maZ = this.mbb;
                        this.mba = this.mbb;
                        boolean[] zArr = new boolean[this.mao.length];
                        long a2 = this.mbb.a(this.maD.mbB, z2, zArr);
                        if (this.state != 4 && a2 != this.maD.mbB) {
                            this.maD = this.maD.b(this.maD.mbA, a2, this.maD.mbw);
                            this.mas.obtainMessage(4, 3, 0, this.maD).sendToTarget();
                            ft(a2);
                        }
                        boolean[] zArr2 = new boolean[this.mao.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.mao.length; i2++) {
                            s sVar = this.mao[i2];
                            zArr2[i2] = sVar.getState() != 0;
                            com.google.android.exoplayer2.source.p pVar = this.mbb.mbe[i2];
                            if (pVar != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (pVar != sVar.dtg()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.fm(this.maY);
                                }
                            }
                        }
                        this.mas.obtainMessage(2, aVar.mbl).sendToTarget();
                        a(zArr2, i);
                    } else {
                        this.maZ = aVar;
                        for (a aVar2 = this.maZ.mbk; aVar2 != null; aVar2 = aVar2.mbk) {
                            aVar2.release();
                        }
                        this.maZ.mbk = null;
                        if (this.maZ.mbi) {
                            this.maZ.o(Math.max(this.maZ.mbh.mbu, this.maZ.fw(this.maY)), false);
                        }
                    }
                    if (this.state != 4) {
                        dtQ();
                        dtH();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean fu(long j) {
        return j == -9223372036854775807L || this.maD.mbB < j || (this.mbb.mbk != null && (this.mbb.mbk.mbi || this.mbb.mbk.mbh.mbt.dwS()));
    }

    private void dtL() throws IOException {
        if (this.maZ == null || this.maZ.mbi) {
            return;
        }
        if (this.mba == null || this.mba.mbk == this.maZ) {
            for (s sVar : this.maQ) {
                if (!sVar.dth()) {
                    return;
                }
            }
            this.maZ.mbc.dwC();
        }
    }

    private void a(b bVar) throws ExoPlaybackException {
        if (bVar.mbn == this.ldO) {
            x xVar = this.maD.timeline;
            x xVar2 = bVar.timeline;
            Object obj = bVar.mbo;
            this.maN.a(xVar2);
            this.maD = this.maD.b(xVar2, obj);
            if (xVar == null) {
                int i = this.maV;
                this.maV = 0;
                if (this.maW > 0) {
                    Pair<Integer, Long> b2 = b(this.maX);
                    int i2 = this.maW;
                    this.maW = 0;
                    this.maX = null;
                    if (b2 == null) {
                        dE(i, i2);
                        return;
                    }
                    int intValue = ((Integer) b2.first).intValue();
                    long longValue = ((Long) b2.second).longValue();
                    l.b B = this.maN.B(intValue, longValue);
                    this.maD = this.maD.b(B, B.dwS() ? 0L : longValue, longValue);
                    dF(i, i2);
                    return;
                } else if (this.maD.mbu == -9223372036854775807L) {
                    if (xVar2.isEmpty()) {
                        dE(i, 0);
                        return;
                    }
                    Pair<Integer, Long> b3 = b(xVar2, xVar2.vL(this.maw), -9223372036854775807L);
                    int intValue2 = ((Integer) b3.first).intValue();
                    long longValue2 = ((Long) b3.second).longValue();
                    l.b B2 = this.maN.B(intValue2, longValue2);
                    this.maD = this.maD.b(B2, B2.dwS() ? 0L : longValue2, longValue2);
                    dF(i, 0);
                    return;
                } else {
                    dF(i, 0);
                    return;
                }
            }
            int i3 = this.maD.mbA.periodIndex;
            a aVar = this.mbb != null ? this.mbb : this.maZ;
            if (aVar == null && i3 >= xVar.dua()) {
                dtN();
                return;
            }
            int bw = xVar2.bw(aVar == null ? xVar.a(i3, this.ldy, true).mbd : aVar.mbd);
            if (bw == -1) {
                int a2 = a(i3, xVar, xVar2);
                if (a2 == -1) {
                    dtM();
                    return;
                }
                Pair<Integer, Long> b4 = b(xVar2, xVar2.a(a2, this.ldy).windowIndex, -9223372036854775807L);
                int intValue3 = ((Integer) b4.first).intValue();
                long longValue3 = ((Long) b4.second).longValue();
                xVar2.a(intValue3, this.ldy, true);
                if (aVar != null) {
                    Object obj2 = this.ldy.mbd;
                    aVar.mbh = aVar.mbh.Jd(-1);
                    a aVar2 = aVar;
                    while (aVar2.mbk != null) {
                        aVar2 = aVar2.mbk;
                        if (aVar2.mbd.equals(obj2)) {
                            aVar2.mbh = this.maN.a(aVar2.mbh, intValue3);
                        } else {
                            aVar2.mbh = aVar2.mbh.Jd(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.maD = this.maD.b(bVar2, a(bVar2, longValue3), -9223372036854775807L);
                dtN();
                return;
            }
            if (bw != i3) {
                this.maD = this.maD.Je(bw);
            }
            if (this.maD.mbA.dwS()) {
                l.b B3 = this.maN.B(bw, this.maD.mbw);
                if (!B3.dwS() || B3.mtZ != this.maD.mbA.mtZ) {
                    this.maD = this.maD.b(B3, a(B3, this.maD.mbw), B3.dwS() ? this.maD.mbw : -9223372036854775807L);
                    dtN();
                    return;
                }
            }
            if (aVar == null) {
                dtN();
                return;
            }
            a a3 = a(aVar, bw);
            int i4 = bw;
            while (a3.mbk != null) {
                a aVar3 = a3.mbk;
                i4 = xVar2.a(i4, this.ldy, this.ldx, this.dT, this.maw);
                if (i4 != -1 && aVar3.mbd.equals(xVar2.a(i4, this.ldy, true).mbd)) {
                    a3 = a(aVar3, i4);
                } else {
                    if (!(this.mba != null && this.mba.index < aVar3.index)) {
                        this.maD = this.maD.b(this.mbb.mbh.mbt, a(this.mbb.mbh.mbt, this.maD.mbB), this.maD.mbw);
                    } else {
                        this.maZ = a3;
                        this.maZ.mbk = null;
                        a(aVar3);
                    }
                    dtN();
                }
            }
            dtN();
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.mbh = this.maN.a(aVar.mbh, i);
            if (aVar.mbh.mby || aVar.mbk == null) {
                break;
            }
            aVar = aVar.mbk;
        }
        return aVar;
    }

    private void dtM() {
        dE(0, 0);
    }

    private void dE(int i, int i2) {
        x xVar = this.maD.timeline;
        int i3 = xVar.isEmpty() ? 0 : xVar.a(xVar.vL(this.maw), this.ldx).mcl;
        this.maD = this.maD.g(i3, -9223372036854775807L, -9223372036854775807L);
        setState(4);
        a(i, i2, this.maD.g(i3, 0L, -9223372036854775807L));
        vJ(false);
    }

    private void dtN() {
        dF(0, 0);
    }

    private void dF(int i, int i2) {
        a(i, i2, this.maD);
    }

    private void a(int i, int i2, p pVar) {
        this.mas.obtainMessage(5, i, i2, pVar).sendToTarget();
    }

    private int a(int i, x xVar, x xVar2) {
        int dua = xVar.dua();
        int i2 = 0;
        int i3 = -1;
        int i4 = i;
        while (i2 < dua && i3 == -1) {
            int a2 = xVar.a(i4, this.ldy, this.ldx, this.dT, this.maw);
            if (a2 == -1) {
                break;
            }
            i2++;
            i3 = xVar2.bw(xVar.a(a2, this.ldy, true).mbd);
            i4 = a2;
        }
        return i3;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = this.maD.timeline;
        x xVar2 = cVar.timeline;
        if (xVar2.isEmpty()) {
            xVar2 = xVar;
        }
        try {
            Pair<Integer, Long> a2 = xVar2.a(this.ldx, this.ldy, cVar.windowIndex, cVar.mbp);
            if (xVar == xVar2) {
                return a2;
            }
            int bw = xVar.bw(xVar2.a(((Integer) a2.first).intValue(), this.ldy, true).mbd);
            if (bw != -1) {
                return Pair.create(Integer.valueOf(bw), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), xVar2, xVar);
            if (a3 != -1) {
                return b(xVar, xVar.a(a3, this.ldy).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(xVar, cVar.windowIndex, cVar.mbp);
        }
    }

    private Pair<Integer, Long> b(x xVar, int i, long j) {
        return xVar.a(this.ldx, this.ldy, i, j);
    }

    private void dtO() throws ExoPlaybackException, IOException {
        if (this.maD.timeline == null) {
            this.ldO.dwK();
            return;
        }
        dtP();
        if (this.maZ == null || this.maZ.dtS()) {
            setIsLoading(false);
        } else if (this.maZ != null && !this.isLoading) {
            dtQ();
        }
        if (this.mbb != null) {
            while (this.mav && this.mbb != this.mba && this.maY >= this.mbb.mbk.mbg) {
                this.mbb.release();
                b(this.mbb.mbk);
                this.maD = this.maD.b(this.mbb.mbh.mbt, this.mbb.mbh.mbu, this.mbb.mbh.mbw);
                dtH();
                this.mas.obtainMessage(4, 0, 0, this.maD).sendToTarget();
            }
            if (this.mba.mbh.mbz) {
                for (int i = 0; i < this.mao.length; i++) {
                    s sVar = this.mao[i];
                    com.google.android.exoplayer2.source.p pVar = this.mba.mbe[i];
                    if (pVar != null && sVar.dtg() == pVar && sVar.dth()) {
                        sVar.dti();
                    }
                }
            } else if (this.mba.mbk != null && this.mba.mbk.mbi) {
                for (int i2 = 0; i2 < this.mao.length; i2++) {
                    s sVar2 = this.mao[i2];
                    com.google.android.exoplayer2.source.p pVar2 = this.mba.mbe[i2];
                    if (sVar2.dtg() == pVar2) {
                        if (pVar2 != null && !sVar2.dth()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.google.android.exoplayer2.b.i iVar = this.mba.mbl;
                this.mba = this.mba.mbk;
                com.google.android.exoplayer2.b.i iVar2 = this.mba.mbl;
                boolean z = this.mba.mbc.dwE() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.mao.length; i3++) {
                    s sVar3 = this.mao[i3];
                    if (iVar.mFj[i3]) {
                        if (z) {
                            sVar3.dti();
                        } else if (!sVar3.dtj()) {
                            com.google.android.exoplayer2.b.f LO = iVar2.mFk.LO(i3);
                            boolean z2 = iVar2.mFj[i3];
                            boolean z3 = this.maI[i3].getTrackType() == 5;
                            u uVar = iVar.mFm[i3];
                            u uVar2 = iVar2.mFm[i3];
                            if (z2 && uVar2.equals(uVar) && !z3) {
                                sVar3.a(a(LO), this.mba.mbe[i3], this.mba.dtR());
                            } else {
                                sVar3.dti();
                            }
                        }
                    }
                }
            }
        }
    }

    private void dtP() throws IOException {
        o.a a2;
        if (this.maZ == null) {
            a2 = this.maN.a(this.maD);
        } else if (!this.maZ.mbh.mbz && this.maZ.dtS() && this.maZ.mbh.mbx != -9223372036854775807L) {
            if (this.mbb == null || this.maZ.index - this.mbb.index != 100) {
                a2 = this.maN.a(this.maZ.mbh, this.maZ.dtR(), this.maY);
            } else {
                return;
            }
        } else {
            return;
        }
        if (a2 == null) {
            this.ldO.dwK();
            return;
        }
        a aVar = new a(this.mao, this.maI, this.maZ == null ? 60000000L : this.maZ.dtR() + this.maZ.mbh.mbx, this.maq, this.maJ, this.ldO, this.maD.timeline.a(a2.mbt.periodIndex, this.ldy, true).mbd, this.maZ == null ? 0 : this.maZ.index + 1, a2);
        if (this.maZ != null) {
            this.maZ.mbk = aVar;
        }
        this.maZ = aVar;
        this.maZ.mbc.a(this, a2.mbu);
        setIsLoading(true);
    }

    private void c(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.maZ != null && this.maZ.mbc == kVar) {
            this.maZ.dtT();
            if (this.mbb == null) {
                this.mba = this.maZ;
                ft(this.mba.mbh.mbu);
                b(this.mba);
            }
            dtQ();
        }
    }

    private void d(com.google.android.exoplayer2.source.k kVar) {
        if (this.maZ != null && this.maZ.mbc == kVar) {
            dtQ();
        }
    }

    private void dtQ() {
        boolean fq = this.maZ.fq(this.maY);
        setIsLoading(fq);
        if (fq) {
            this.maZ.fx(this.maY);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.mbk;
        }
    }

    private void b(a aVar) throws ExoPlaybackException {
        if (this.mbb != aVar) {
            boolean[] zArr = new boolean[this.mao.length];
            int i = 0;
            for (int i2 = 0; i2 < this.mao.length; i2++) {
                s sVar = this.mao[i2];
                zArr[i2] = sVar.getState() != 0;
                if (aVar.mbl.mFj[i2]) {
                    i++;
                }
                if (zArr[i2] && (!aVar.mbl.mFj[i2] || (sVar.dtj() && sVar.dtg() == this.mbb.mbe[i2]))) {
                    b(sVar);
                }
            }
            this.mbb = aVar;
            this.mas.obtainMessage(2, aVar.mbl).sendToTarget();
            a(zArr, i);
        }
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.maQ = new s[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.mao.length; i3++) {
            if (this.mbb.mbl.mFj[i3]) {
                c(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void c(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2 = true;
        s sVar = this.mao[i];
        this.maQ[i2] = sVar;
        if (sVar.getState() == 0) {
            u uVar = this.mbb.mbl.mFm[i];
            Format[] a2 = a(this.mbb.mbl.mFk.LO(i));
            boolean z3 = this.mav && this.state == 3;
            if (z || !z3) {
                z2 = false;
            }
            sVar.a(uVar, a2, this.mbb.mbe[i], this.maY, z2, this.mbb.dtR());
            com.google.android.exoplayer2.util.h dtf = sVar.dtf();
            if (dtf != null) {
                if (this.maP != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.maP = dtf;
                this.maO = sVar;
                this.maP.d(this.maC);
            }
            if (z3) {
                sVar.start();
            }
        }
    }

    private boolean c(s sVar) {
        return this.mba.mbk != null && this.mba.mbk.mbi && sVar.dth();
    }

    @NonNull
    private static Format[] a(com.google.android.exoplayer2.b.f fVar) {
        int length = fVar != null ? fVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = fVar.KW(i);
        }
        return formatArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int index;
        private final com.google.android.exoplayer2.source.l ldO;
        private final t[] maI;
        private final n maJ;
        private final s[] mao;
        private final com.google.android.exoplayer2.b.h maq;
        public final com.google.android.exoplayer2.source.k mbc;
        public final Object mbd;
        public final com.google.android.exoplayer2.source.p[] mbe;
        public final boolean[] mbf;
        public final long mbg;
        public o.a mbh;
        public boolean mbi;
        public boolean mbj;
        public a mbk;
        public com.google.android.exoplayer2.b.i mbl;
        private com.google.android.exoplayer2.b.i mbm;

        public a(s[] sVarArr, t[] tVarArr, long j, com.google.android.exoplayer2.b.h hVar, n nVar, com.google.android.exoplayer2.source.l lVar, Object obj, int i, o.a aVar) {
            com.google.android.exoplayer2.source.c cVar;
            this.mao = sVarArr;
            this.maI = tVarArr;
            this.mbg = j;
            this.maq = hVar;
            this.maJ = nVar;
            this.ldO = lVar;
            this.mbd = com.google.android.exoplayer2.util.a.checkNotNull(obj);
            this.index = i;
            this.mbh = aVar;
            this.mbe = new com.google.android.exoplayer2.source.p[sVarArr.length];
            this.mbf = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.k a = lVar.a(aVar.mbt, nVar.dtp());
            if (aVar.mbv != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar2 = new com.google.android.exoplayer2.source.c(a, true);
                cVar2.R(0L, aVar.mbv);
                cVar = cVar2;
            } else {
                cVar = a;
            }
            this.mbc = cVar;
        }

        public long fv(long j) {
            return dtR() + j;
        }

        public long fw(long j) {
            return j - dtR();
        }

        public long dtR() {
            return this.index == 0 ? this.mbg : this.mbg - this.mbh.mbu;
        }

        public boolean dtS() {
            return this.mbi && (!this.mbj || this.mbc.dwF() == Long.MIN_VALUE);
        }

        public boolean f(boolean z, long j) {
            long dwF = !this.mbi ? this.mbh.mbu : this.mbc.dwF();
            if (dwF == Long.MIN_VALUE) {
                if (this.mbh.mbz) {
                    return true;
                }
                dwF = this.mbh.mbx;
            }
            return this.maJ.n(dwF - fw(j), z);
        }

        public void dtT() throws ExoPlaybackException {
            this.mbi = true;
            dtU();
            this.mbh = this.mbh.fz(o(this.mbh.mbu, false));
        }

        public boolean fq(long j) {
            long dwG = !this.mbi ? 0L : this.mbc.dwG();
            if (dwG == Long.MIN_VALUE) {
                return false;
            }
            return this.maJ.fq(dwG - fw(j));
        }

        public void fx(long j) {
            this.mbc.ge(fw(j));
        }

        public boolean dtU() throws ExoPlaybackException {
            com.google.android.exoplayer2.b.i a = this.maq.a(this.maI, this.mbc.dwD());
            if (a.a(this.mbm)) {
                return false;
            }
            this.mbl = a;
            return true;
        }

        public long o(long j, boolean z) {
            return a(j, z, new boolean[this.mao.length]);
        }

        public long a(long j, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.b.g gVar = this.mbl.mFk;
            for (int i = 0; i < gVar.length; i++) {
                this.mbf[i] = !z && this.mbl.a(this.mbm, i);
            }
            a(this.mbe);
            long a = this.mbc.a(gVar.dyZ(), this.mbf, this.mbe, zArr, j);
            b(this.mbe);
            this.mbm = this.mbl;
            this.mbj = false;
            for (int i2 = 0; i2 < this.mbe.length; i2++) {
                if (this.mbe[i2] != null) {
                    com.google.android.exoplayer2.util.a.checkState(this.mbl.mFj[i2]);
                    if (this.maI[i2].getTrackType() != 5) {
                        this.mbj = true;
                    }
                } else {
                    com.google.android.exoplayer2.util.a.checkState(gVar.LO(i2) == null);
                }
            }
            this.maJ.a(this.mao, this.mbl.mFi, gVar);
            return a;
        }

        public void release() {
            try {
                if (this.mbh.mbv != Long.MIN_VALUE) {
                    this.ldO.e(((com.google.android.exoplayer2.source.c) this.mbc).mbc);
                } else {
                    this.ldO.e(this.mbc);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        private void a(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.maI.length; i++) {
                if (this.maI[i].getTrackType() == 5) {
                    pVarArr[i] = null;
                }
            }
        }

        private void b(com.google.android.exoplayer2.source.p[] pVarArr) {
            for (int i = 0; i < this.maI.length; i++) {
                if (this.maI[i].getTrackType() == 5 && this.mbl.mFj[i]) {
                    pVarArr[i] = new com.google.android.exoplayer2.source.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final long mbp;
        public final x timeline;
        public final int windowIndex;

        public c(x xVar, int i, long j) {
            this.timeline = xVar;
            this.windowIndex = i;
            this.mbp = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.source.l mbn;
        public final Object mbo;
        public final x timeline;

        public b(com.google.android.exoplayer2.source.l lVar, x xVar, Object obj) {
            this.mbn = lVar;
            this.timeline = xVar;
            this.mbo = obj;
        }
    }
}
