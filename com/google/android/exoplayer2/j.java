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
    private final s[] lXO;
    private final com.google.android.exoplayer2.b.h lXP;
    private final com.google.android.exoplayer2.b.g lXQ;
    private final Handler lXR;
    private final k lXS;
    private boolean lXT;
    private boolean lXU;
    private boolean lXV;
    private int lXW;
    private int lXX;
    private com.google.android.exoplayer2.source.u lXY;
    private com.google.android.exoplayer2.b.g lXZ;
    private q lYa;
    private p lYb;
    private int lYc;
    private int lYd;
    private long lYe;
    private final x.b laY;
    private final x.a laZ;
    private int lac;
    private final CopyOnWriteArraySet<r.b> lbi;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHh + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lXO = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lXP = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lXU = false;
        this.dT = 0;
        this.lXV = false;
        this.lac = 1;
        this.lbi = new CopyOnWriteArraySet<>();
        this.lXQ = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.laY = new x.b();
        this.laZ = new x.a();
        this.lXY = com.google.android.exoplayer2.source.u.msu;
        this.lXZ = this.lXQ;
        this.lYa = q.lZb;
        this.lXR = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lYb = new p(x.lZx, null, 0, 0L);
        this.lXS = new k(sVarArr, hVar, nVar, this.lXU, this.dT, this.lXV, this.lXR, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lbi.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lbi.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cYz() {
        return this.lac;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lYc = drJ();
            this.lYd = drI();
            this.lYe = getCurrentPosition();
        } else {
            this.lYc = 0;
            this.lYd = 0;
            this.lYe = 0L;
        }
        if (z2) {
            if (!this.lYb.timeline.isEmpty() || this.lYb.lYM != null) {
                this.lYb = this.lYb.b(x.lZx, null);
                Iterator<r.b> it = this.lbi.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lYb.timeline, this.lYb.lYM);
                }
            }
            if (this.lXT) {
                this.lXT = false;
                this.lXY = com.google.android.exoplayer2.source.u.msu;
                this.lXZ = this.lXQ;
                this.lXP.by(null);
                Iterator<r.b> it2 = this.lbi.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lXY, this.lXZ);
                }
            }
        }
        this.lXX++;
        this.lXS.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vu(boolean z) {
        if (this.lXU != z) {
            this.lXU = z;
            this.lXS.vu(z);
            Iterator<r.b> it = this.lbi.iterator();
            while (it.hasNext()) {
                it.next().z(z, this.lac);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drF() {
        return this.lXU;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dT != i) {
            this.dT = i;
            this.lXS.setRepeatMode(i);
            Iterator<r.b> it = this.lbi.iterator();
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
        if (this.lXV != z) {
            this.lXV = z;
            this.lXS.vv(z);
            Iterator<r.b> it = this.lbi.iterator();
            while (it.hasNext()) {
                it.next().ua(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drG() {
        return this.lXV;
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        x xVar = this.lYb.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dsn())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (drN()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lXW == 0) {
                Iterator<r.b> it = this.lbi.iterator();
                while (it.hasNext()) {
                    it.next().cYR();
                }
                return;
            }
            return;
        }
        this.lXW++;
        this.lYc = i;
        if (xVar.isEmpty()) {
            this.lYe = j == -9223372036854775807L ? 0L : j;
            this.lYd = 0;
        } else {
            xVar.a(i, this.laY);
            long dsv = j == -9223372036854775807L ? this.laY.dsv() : b.fq(j);
            int i2 = this.laY.lZJ;
            long dsw = this.laY.dsw() + dsv;
            long dsq = xVar.a(i2, this.laZ).dsq();
            while (dsq != -9223372036854775807L && dsw >= dsq && i2 < this.laY.lZK) {
                dsw -= dsq;
                i2++;
                dsq = xVar.a(i2, this.laZ).dsq();
            }
            this.lYe = b.fp(dsv);
            this.lYd = i2;
        }
        this.lXS.a(xVar, i, b.fq(j));
        Iterator<r.b> it2 = this.lbi.iterator();
        while (it2.hasNext()) {
            it2.next().EO(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lZb;
        }
        this.lXS.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q drH() {
        return this.lYa;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lXS.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHh + "] [" + l.dsj() + "]");
        this.lXS.release();
        this.lXR.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lXS.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lXS.b(bVarArr);
    }

    public int drI() {
        return drR() ? this.lYd : this.lYb.lYY.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int drJ() {
        return drR() ? this.lYc : this.lYb.timeline.a(this.lYb.lYY.periodIndex, this.laZ).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int drK() {
        x xVar = this.lYb.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(drJ(), this.dT, this.lXV);
    }

    @Override // com.google.android.exoplayer2.r
    public int drL() {
        x xVar = this.lYb.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(drJ(), this.dT, this.lXV);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lYb.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (drN()) {
            l.b bVar = this.lYb.lYY;
            xVar.a(bVar.periodIndex, this.laZ);
            return b.fp(this.laZ.dE(bVar.mrx, bVar.mry));
        }
        return xVar.a(drJ(), this.laY).dsp();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return drR() ? this.lYe : ft(this.lYb.lYZ);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return drR() ? this.lYe : ft(this.lYb.lZa);
    }

    @Override // com.google.android.exoplayer2.r
    public int drM() {
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
    public boolean drN() {
        return !drR() && this.lYb.lYY.dvi();
    }

    @Override // com.google.android.exoplayer2.r
    public long drO() {
        if (drN()) {
            this.lYb.timeline.a(this.lYb.lYY.periodIndex, this.laZ);
            return this.laZ.dsr() + b.fp(this.lYb.lYU);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IO(int i) {
        return this.lXO[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g drP() {
        return this.lXZ;
    }

    @Override // com.google.android.exoplayer2.r
    public x drQ() {
        return this.lYb.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.lac = message.arg1;
                Iterator<r.b> it = this.lbi.iterator();
                while (it.hasNext()) {
                    it.next().z(this.lXU, this.lac);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.lbi.iterator();
                while (it2.hasNext()) {
                    it2.next().tZ(this.isLoading);
                }
                return;
            case 2:
                if (this.lXX == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lXT = true;
                    this.lXY = iVar.mCF;
                    this.lXZ = iVar.mCH;
                    this.lXP.by(iVar.mCI);
                    Iterator<r.b> it3 = this.lbi.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lXY, this.lXZ);
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
                if (!this.lYa.equals(qVar)) {
                    this.lYa = qVar;
                    Iterator<r.b> it4 = this.lbi.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.lbi.iterator();
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
        this.lXX -= i;
        this.lXW -= i2;
        if (this.lXX == 0 && this.lXW == 0) {
            boolean z2 = (this.lYb.timeline == pVar.timeline && this.lYb.lYM == pVar.lYM) ? false : true;
            this.lYb = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lYd = 0;
                this.lYc = 0;
                this.lYe = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.lbi.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lYM);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.lbi.iterator();
                while (it2.hasNext()) {
                    it2.next().EO(i3);
                }
            }
        }
        if (this.lXW == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.lbi.iterator();
            while (it3.hasNext()) {
                it3.next().cYR();
            }
        }
    }

    private long ft(long j) {
        long fp = b.fp(j);
        if (!this.lYb.lYY.dvi()) {
            this.lYb.timeline.a(this.lYb.lYY.periodIndex, this.laZ);
            return fp + this.laZ.dsr();
        }
        return fp;
    }

    private boolean drR() {
        return this.lYb.timeline.isEmpty() || this.lXW > 0 || this.lXX > 0;
    }
}
