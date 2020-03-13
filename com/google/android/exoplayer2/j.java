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
/* loaded from: classes6.dex */
final class j implements g {
    private int dU;
    private boolean isLoading;
    private final s[] lYH;
    private final com.google.android.exoplayer2.b.h lYI;
    private final com.google.android.exoplayer2.b.g lYJ;
    private final Handler lYK;
    private final k lYL;
    private boolean lYM;
    private boolean lYN;
    private boolean lYO;
    private int lYP;
    private int lYQ;
    private com.google.android.exoplayer2.source.u lYR;
    private com.google.android.exoplayer2.b.g lYS;
    private q lYT;
    private p lYU;
    private int lYV;
    private int lYW;
    private long lYX;
    private int laX;
    private final x.b lbS;
    private final x.a lbT;
    private final CopyOnWriteArraySet<r.b> lcc;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHZ + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lYH = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lYI = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lYN = false;
        this.dU = 0;
        this.lYO = false;
        this.laX = 1;
        this.lcc = new CopyOnWriteArraySet<>();
        this.lYJ = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.lbS = new x.b();
        this.lbT = new x.a();
        this.lYR = com.google.android.exoplayer2.source.u.mtn;
        this.lYS = this.lYJ;
        this.lYT = q.lZU;
        this.lYK = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lYU = new p(x.mas, null, 0, 0L);
        this.lYL = new k(sVarArr, hVar, nVar, this.lYN, this.dU, this.lYO, this.lYK, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lcc.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lcc.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZQ() {
        return this.laX;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lYV = dsY();
            this.lYW = dsX();
            this.lYX = getCurrentPosition();
        } else {
            this.lYV = 0;
            this.lYW = 0;
            this.lYX = 0L;
        }
        if (z2) {
            if (!this.lYU.timeline.isEmpty() || this.lYU.lZF != null) {
                this.lYU = this.lYU.b(x.mas, null);
                Iterator<r.b> it = this.lcc.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lYU.timeline, this.lYU.lZF);
                }
            }
            if (this.lYM) {
                this.lYM = false;
                this.lYR = com.google.android.exoplayer2.source.u.mtn;
                this.lYS = this.lYJ;
                this.lYI.bA(null);
                Iterator<r.b> it2 = this.lcc.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lYR, this.lYS);
                }
            }
        }
        this.lYQ++;
        this.lYL.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        if (this.lYN != z) {
            this.lYN = z;
            this.lYL.vy(z);
            Iterator<r.b> it = this.lcc.iterator();
            while (it.hasNext()) {
                it.next().A(z, this.laX);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsU() {
        return this.lYN;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dU != i) {
            this.dU = i;
            this.lYL.setRepeatMode(i);
            Iterator<r.b> it = this.lcc.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.dU;
    }

    @Override // com.google.android.exoplayer2.r
    public void vz(boolean z) {
        if (this.lYO != z) {
            this.lYO = z;
            this.lYL.vz(z);
            Iterator<r.b> it = this.lcc.iterator();
            while (it.hasNext()) {
                it.next().ue(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsV() {
        return this.lYO;
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        x xVar = this.lYU.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dtC())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (dtc()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lYP == 0) {
                Iterator<r.b> it = this.lcc.iterator();
                while (it.hasNext()) {
                    it.next().dai();
                }
                return;
            }
            return;
        }
        this.lYP++;
        this.lYV = i;
        if (xVar.isEmpty()) {
            this.lYX = j == -9223372036854775807L ? 0L : j;
            this.lYW = 0;
        } else {
            xVar.a(i, this.lbS);
            long dtJ = j == -9223372036854775807L ? this.lbS.dtJ() : b.fo(j);
            int i2 = this.lbS.maF;
            long dtK = this.lbS.dtK() + dtJ;
            long durationUs = xVar.a(i2, this.lbT).getDurationUs();
            while (durationUs != -9223372036854775807L && dtK >= durationUs && i2 < this.lbS.maG) {
                dtK -= durationUs;
                i2++;
                durationUs = xVar.a(i2, this.lbT).getDurationUs();
            }
            this.lYX = b.fn(dtJ);
            this.lYW = i2;
        }
        this.lYL.a(xVar, i, b.fo(j));
        Iterator<r.b> it2 = this.lcc.iterator();
        while (it2.hasNext()) {
            it2.next().ET(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lZU;
        }
        this.lYL.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsW() {
        return this.lYT;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYL.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHZ + "] [" + l.dty() + "]");
        this.lYL.release();
        this.lYK.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYL.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYL.b(bVarArr);
    }

    public int dsX() {
        return dtg() ? this.lYW : this.lYU.lZR.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
        return dtg() ? this.lYV : this.lYU.timeline.a(this.lYU.lZR.periodIndex, this.lbT).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsZ() {
        x xVar = this.lYU.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(dsY(), this.dU, this.lYO);
    }

    @Override // com.google.android.exoplayer2.r
    public int dta() {
        x xVar = this.lYU.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(dsY(), this.dU, this.lYO);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lYU.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (dtc()) {
            l.b bVar = this.lYU.lZR;
            xVar.a(bVar.periodIndex, this.lbT);
            return b.fn(this.lbT.dH(bVar.msr, bVar.mss));
        }
        return xVar.a(dsY(), this.lbS).dtE();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return dtg() ? this.lYX : fr(this.lYU.lZS);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return dtg() ? this.lYX : fr(this.lYU.lZT);
    }

    @Override // com.google.android.exoplayer2.r
    public int dtb() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration != 0) {
            return com.google.android.exoplayer2.util.v.am((int) ((bufferedPosition * 100) / duration), 0, 100);
        }
        return 100;
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtc() {
        return !dtg() && this.lYU.lZR.dwv();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtd() {
        if (dtc()) {
            this.lYU.timeline.a(this.lYU.lZR.periodIndex, this.lbT);
            return this.lbT.dtF() + b.fn(this.lYU.lZN);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lYH[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dte() {
        return this.lYS;
    }

    @Override // com.google.android.exoplayer2.r
    public x dtf() {
        return this.lYU.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.laX = message.arg1;
                Iterator<r.b> it = this.lcc.iterator();
                while (it.hasNext()) {
                    it.next().A(this.lYN, this.laX);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.lcc.iterator();
                while (it2.hasNext()) {
                    it2.next().ud(this.isLoading);
                }
                return;
            case 2:
                if (this.lYQ == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lYM = true;
                    this.lYR = iVar.mDB;
                    this.lYS = iVar.mDD;
                    this.lYI.bA(iVar.mDE);
                    Iterator<r.b> it3 = this.lcc.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lYR, this.lYS);
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
                if (!this.lYT.equals(qVar)) {
                    this.lYT = qVar;
                    Iterator<r.b> it4 = this.lcc.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.lcc.iterator();
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
        this.lYQ -= i;
        this.lYP -= i2;
        if (this.lYQ == 0 && this.lYP == 0) {
            boolean z2 = (this.lYU.timeline == pVar.timeline && this.lYU.lZF == pVar.lZF) ? false : true;
            this.lYU = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lYW = 0;
                this.lYV = 0;
                this.lYX = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.lcc.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lZF);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.lcc.iterator();
                while (it2.hasNext()) {
                    it2.next().ET(i3);
                }
            }
        }
        if (this.lYP == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.lcc.iterator();
            while (it3.hasNext()) {
                it3.next().dai();
            }
        }
    }

    private long fr(long j) {
        long fn = b.fn(j);
        if (!this.lYU.lZR.dwv()) {
            this.lYU.timeline.a(this.lYU.lZR.periodIndex, this.lbT);
            return fn + this.lbT.dtF();
        }
        return fn;
    }

    private boolean dtg() {
        return this.lYU.timeline.isEmpty() || this.lYP > 0 || this.lYQ > 0;
    }
}
