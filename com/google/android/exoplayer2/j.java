package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes5.dex */
final class j implements g {
    private int dT;
    private boolean isLoading;
    private int kZX;
    private final s[] lXJ;
    private final com.google.android.exoplayer2.b.h lXK;
    private final com.google.android.exoplayer2.b.g lXL;
    private final Handler lXM;
    private final k lXN;
    private boolean lXO;
    private boolean lXP;
    private boolean lXQ;
    private int lXR;
    private int lXS;
    private com.google.android.exoplayer2.source.u lXT;
    private com.google.android.exoplayer2.b.g lXU;
    private q lXV;
    private p lXW;
    private int lXX;
    private int lXY;
    private long lXZ;
    private final x.b laT;
    private final x.a laU;
    private final CopyOnWriteArraySet<r.b> lbd;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHc + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lXJ = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lXK = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lXP = false;
        this.dT = 0;
        this.lXQ = false;
        this.kZX = 1;
        this.lbd = new CopyOnWriteArraySet<>();
        this.lXL = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.laT = new x.b();
        this.laU = new x.a();
        this.lXT = com.google.android.exoplayer2.source.u.msp;
        this.lXU = this.lXL;
        this.lXV = q.lYW;
        this.lXM = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lXW = new p(x.lZs, null, 0, 0L);
        this.lXN = new k(sVarArr, hVar, nVar, this.lXP, this.dT, this.lXQ, this.lXM, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lbd.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lbd.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cYx() {
        return this.kZX;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lXX = drH();
            this.lXY = drG();
            this.lXZ = getCurrentPosition();
        } else {
            this.lXX = 0;
            this.lXY = 0;
            this.lXZ = 0L;
        }
        if (z2) {
            if (!this.lXW.timeline.isEmpty() || this.lXW.lYH != null) {
                this.lXW = this.lXW.b(x.lZs, null);
                Iterator<r.b> it = this.lbd.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lXW.timeline, this.lXW.lYH);
                }
            }
            if (this.lXO) {
                this.lXO = false;
                this.lXT = com.google.android.exoplayer2.source.u.msp;
                this.lXU = this.lXL;
                this.lXK.by(null);
                Iterator<r.b> it2 = this.lbd.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lXT, this.lXU);
                }
            }
        }
        this.lXS++;
        this.lXN.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vu(boolean z) {
        if (this.lXP != z) {
            this.lXP = z;
            this.lXN.vu(z);
            Iterator<r.b> it = this.lbd.iterator();
            while (it.hasNext()) {
                it.next().z(z, this.kZX);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drD() {
        return this.lXP;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dT != i) {
            this.dT = i;
            this.lXN.setRepeatMode(i);
            Iterator<r.b> it = this.lbd.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.dT;
    }

    @Override // com.google.android.exoplayer2.r
    public void vv(boolean z) {
        if (this.lXQ != z) {
            this.lXQ = z;
            this.lXN.vv(z);
            Iterator<r.b> it = this.lbd.iterator();
            while (it.hasNext()) {
                it.next().ua(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drE() {
        return this.lXQ;
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        x xVar = this.lXW.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dsl())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (drL()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lXR == 0) {
                Iterator<r.b> it = this.lbd.iterator();
                while (it.hasNext()) {
                    it.next().cYP();
                }
                return;
            }
            return;
        }
        this.lXR++;
        this.lXX = i;
        if (xVar.isEmpty()) {
            this.lXZ = j == -9223372036854775807L ? 0L : j;
            this.lXY = 0;
        } else {
            xVar.a(i, this.laT);
            long dst = j == -9223372036854775807L ? this.laT.dst() : b.fq(j);
            int i2 = this.laT.lZE;
            long dsu = this.laT.dsu() + dst;
            long dso = xVar.a(i2, this.laU).dso();
            while (dso != -9223372036854775807L && dsu >= dso && i2 < this.laT.lZF) {
                dsu -= dso;
                i2++;
                dso = xVar.a(i2, this.laU).dso();
            }
            this.lXZ = b.fp(dst);
            this.lXY = i2;
        }
        this.lXN.a(xVar, i, b.fq(j));
        Iterator<r.b> it2 = this.lbd.iterator();
        while (it2.hasNext()) {
            it2.next().EO(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lYW;
        }
        this.lXN.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q drF() {
        return this.lXV;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lXN.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHc + "] [" + l.dsh() + "]");
        this.lXN.release();
        this.lXM.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lXN.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lXN.b(bVarArr);
    }

    public int drG() {
        return drP() ? this.lXY : this.lXW.lYT.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int drH() {
        return drP() ? this.lXX : this.lXW.timeline.a(this.lXW.lYT.periodIndex, this.laU).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int drI() {
        x xVar = this.lXW.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(drH(), this.dT, this.lXQ);
    }

    @Override // com.google.android.exoplayer2.r
    public int drJ() {
        x xVar = this.lXW.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(drH(), this.dT, this.lXQ);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lXW.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (drL()) {
            l.b bVar = this.lXW.lYT;
            xVar.a(bVar.periodIndex, this.laU);
            return b.fp(this.laU.dE(bVar.mrs, bVar.mrt));
        }
        return xVar.a(drH(), this.laT).dsn();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return drP() ? this.lXZ : ft(this.lXW.lYU);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return drP() ? this.lXZ : ft(this.lXW.lYV);
    }

    @Override // com.google.android.exoplayer2.r
    public int drK() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration != 0) {
            return com.google.android.exoplayer2.util.v.al((int) ((bufferedPosition * 100) / duration), 0, 100);
        }
        return 100;
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drL() {
        return !drP() && this.lXW.lYT.dvg();
    }

    @Override // com.google.android.exoplayer2.r
    public long drM() {
        if (drL()) {
            this.lXW.timeline.a(this.lXW.lYT.periodIndex, this.laU);
            return this.laU.dsp() + b.fp(this.lXW.lYP);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IO(int i) {
        return this.lXJ[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g drN() {
        return this.lXU;
    }

    @Override // com.google.android.exoplayer2.r
    public x drO() {
        return this.lXW.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.kZX = message.arg1;
                Iterator<r.b> it = this.lbd.iterator();
                while (it.hasNext()) {
                    it.next().z(this.lXP, this.kZX);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.lbd.iterator();
                while (it2.hasNext()) {
                    it2.next().tZ(this.isLoading);
                }
                return;
            case 2:
                if (this.lXS == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lXO = true;
                    this.lXT = iVar.mCA;
                    this.lXU = iVar.mCC;
                    this.lXK.by(iVar.mCD);
                    Iterator<r.b> it3 = this.lbd.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lXT, this.lXU);
                    }
                    return;
                }
                return;
            case 3:
                a((p) message.obj, 0, 1, message.arg1 != 0, 2);
                return;
            case 4:
                a((p) message.obj, 0, 0, true, message.arg1);
                return;
            case 5:
                a((p) message.obj, message.arg1, message.arg2, false, 3);
                return;
            case 6:
                q qVar = (q) message.obj;
                if (!this.lXV.equals(qVar)) {
                    this.lXV = qVar;
                    Iterator<r.b> it4 = this.lbd.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.lbd.iterator();
                while (it5.hasNext()) {
                    it5.next().a(exoPlaybackException);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    private void a(p pVar, int i, int i2, boolean z, int i3) {
        com.google.android.exoplayer2.util.a.checkNotNull(pVar.timeline);
        this.lXS -= i;
        this.lXR -= i2;
        if (this.lXS == 0 && this.lXR == 0) {
            boolean z2 = (this.lXW.timeline == pVar.timeline && this.lXW.lYH == pVar.lYH) ? false : true;
            this.lXW = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lXY = 0;
                this.lXX = 0;
                this.lXZ = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.lbd.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lYH);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.lbd.iterator();
                while (it2.hasNext()) {
                    it2.next().EO(i3);
                }
            }
        }
        if (this.lXR == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.lbd.iterator();
            while (it3.hasNext()) {
                it3.next().cYP();
            }
        }
    }

    private long ft(long j) {
        long fp = b.fp(j);
        if (!this.lXW.lYT.dvg()) {
            this.lXW.timeline.a(this.lXW.lYT.periodIndex, this.laU);
            return fp + this.laU.dsp();
        }
        return fp;
    }

    private boolean drP() {
        return this.lXW.timeline.isEmpty() || this.lXR > 0 || this.lXS > 0;
    }
}
