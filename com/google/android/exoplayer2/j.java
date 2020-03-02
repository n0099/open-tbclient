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
    private final k lYA;
    private boolean lYB;
    private boolean lYC;
    private boolean lYD;
    private int lYE;
    private int lYF;
    private com.google.android.exoplayer2.source.u lYG;
    private com.google.android.exoplayer2.b.g lYH;
    private q lYI;
    private p lYJ;
    private int lYK;
    private int lYL;
    private long lYM;
    private final s[] lYw;
    private final com.google.android.exoplayer2.b.h lYx;
    private final com.google.android.exoplayer2.b.g lYy;
    private final Handler lYz;
    private int laL;
    private final x.b lbG;
    private final x.a lbH;
    private final CopyOnWriteArraySet<r.b> lbQ;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHO + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lYw = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lYx = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lYC = false;
        this.dU = 0;
        this.lYD = false;
        this.laL = 1;
        this.lbQ = new CopyOnWriteArraySet<>();
        this.lYy = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.lbG = new x.b();
        this.lbH = new x.a();
        this.lYG = com.google.android.exoplayer2.source.u.mtc;
        this.lYH = this.lYy;
        this.lYI = q.lZJ;
        this.lYz = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lYJ = new p(x.mag, null, 0, 0L);
        this.lYA = new k(sVarArr, hVar, nVar, this.lYC, this.dU, this.lYD, this.lYz, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lbQ.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lbQ.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZP() {
        return this.laL;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lYK = dsX();
            this.lYL = dsW();
            this.lYM = getCurrentPosition();
        } else {
            this.lYK = 0;
            this.lYL = 0;
            this.lYM = 0L;
        }
        if (z2) {
            if (!this.lYJ.timeline.isEmpty() || this.lYJ.lZu != null) {
                this.lYJ = this.lYJ.b(x.mag, null);
                Iterator<r.b> it = this.lbQ.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lYJ.timeline, this.lYJ.lZu);
                }
            }
            if (this.lYB) {
                this.lYB = false;
                this.lYG = com.google.android.exoplayer2.source.u.mtc;
                this.lYH = this.lYy;
                this.lYx.bA(null);
                Iterator<r.b> it2 = this.lbQ.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lYG, this.lYH);
                }
            }
        }
        this.lYF++;
        this.lYA.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        if (this.lYC != z) {
            this.lYC = z;
            this.lYA.vy(z);
            Iterator<r.b> it = this.lbQ.iterator();
            while (it.hasNext()) {
                it.next().A(z, this.laL);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsT() {
        return this.lYC;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dU != i) {
            this.dU = i;
            this.lYA.setRepeatMode(i);
            Iterator<r.b> it = this.lbQ.iterator();
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
        if (this.lYD != z) {
            this.lYD = z;
            this.lYA.vz(z);
            Iterator<r.b> it = this.lbQ.iterator();
            while (it.hasNext()) {
                it.next().ue(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsU() {
        return this.lYD;
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        x xVar = this.lYJ.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dtB())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (dtb()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lYE == 0) {
                Iterator<r.b> it = this.lbQ.iterator();
                while (it.hasNext()) {
                    it.next().dah();
                }
                return;
            }
            return;
        }
        this.lYE++;
        this.lYK = i;
        if (xVar.isEmpty()) {
            this.lYM = j == -9223372036854775807L ? 0L : j;
            this.lYL = 0;
        } else {
            xVar.a(i, this.lbG);
            long dtI = j == -9223372036854775807L ? this.lbG.dtI() : b.fo(j);
            int i2 = this.lbG.mat;
            long dtJ = this.lbG.dtJ() + dtI;
            long durationUs = xVar.a(i2, this.lbH).getDurationUs();
            while (durationUs != -9223372036854775807L && dtJ >= durationUs && i2 < this.lbG.mau) {
                dtJ -= durationUs;
                i2++;
                durationUs = xVar.a(i2, this.lbH).getDurationUs();
            }
            this.lYM = b.fn(dtI);
            this.lYL = i2;
        }
        this.lYA.a(xVar, i, b.fo(j));
        Iterator<r.b> it2 = this.lbQ.iterator();
        while (it2.hasNext()) {
            it2.next().ET(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lZJ;
        }
        this.lYA.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsV() {
        return this.lYI;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYA.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHO + "] [" + l.dtx() + "]");
        this.lYA.release();
        this.lYz.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYA.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYA.b(bVarArr);
    }

    public int dsW() {
        return dtf() ? this.lYL : this.lYJ.lZG.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsX() {
        return dtf() ? this.lYK : this.lYJ.timeline.a(this.lYJ.lZG.periodIndex, this.lbH).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
        x xVar = this.lYJ.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(dsX(), this.dU, this.lYD);
    }

    @Override // com.google.android.exoplayer2.r
    public int dsZ() {
        x xVar = this.lYJ.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(dsX(), this.dU, this.lYD);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lYJ.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (dtb()) {
            l.b bVar = this.lYJ.lZG;
            xVar.a(bVar.periodIndex, this.lbH);
            return b.fn(this.lbH.dH(bVar.msf, bVar.msh));
        }
        return xVar.a(dsX(), this.lbG).dtD();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return dtf() ? this.lYM : fr(this.lYJ.lZH);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return dtf() ? this.lYM : fr(this.lYJ.lZI);
    }

    @Override // com.google.android.exoplayer2.r
    public int dta() {
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
    public boolean dtb() {
        return !dtf() && this.lYJ.lZG.dwu();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtc() {
        if (dtb()) {
            this.lYJ.timeline.a(this.lYJ.lZG.periodIndex, this.lbH);
            return this.lbH.dtE() + b.fn(this.lYJ.lZC);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lYw[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtd() {
        return this.lYH;
    }

    @Override // com.google.android.exoplayer2.r
    public x dte() {
        return this.lYJ.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.laL = message.arg1;
                Iterator<r.b> it = this.lbQ.iterator();
                while (it.hasNext()) {
                    it.next().A(this.lYC, this.laL);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.lbQ.iterator();
                while (it2.hasNext()) {
                    it2.next().ud(this.isLoading);
                }
                return;
            case 2:
                if (this.lYF == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lYB = true;
                    this.lYG = iVar.mDo;
                    this.lYH = iVar.mDq;
                    this.lYx.bA(iVar.mDr);
                    Iterator<r.b> it3 = this.lbQ.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lYG, this.lYH);
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
                if (!this.lYI.equals(qVar)) {
                    this.lYI = qVar;
                    Iterator<r.b> it4 = this.lbQ.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.lbQ.iterator();
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
        this.lYF -= i;
        this.lYE -= i2;
        if (this.lYF == 0 && this.lYE == 0) {
            boolean z2 = (this.lYJ.timeline == pVar.timeline && this.lYJ.lZu == pVar.lZu) ? false : true;
            this.lYJ = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lYL = 0;
                this.lYK = 0;
                this.lYM = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.lbQ.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lZu);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.lbQ.iterator();
                while (it2.hasNext()) {
                    it2.next().ET(i3);
                }
            }
        }
        if (this.lYE == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.lbQ.iterator();
            while (it3.hasNext()) {
                it3.next().dah();
            }
        }
    }

    private long fr(long j) {
        long fn = b.fn(j);
        if (!this.lYJ.lZG.dwu()) {
            this.lYJ.timeline.a(this.lYJ.lZG.periodIndex, this.lbH);
            return fn + this.lbH.dtE();
        }
        return fn;
    }

    private boolean dtf() {
        return this.lYJ.timeline.isEmpty() || this.lYE > 0 || this.lYF > 0;
    }
}
