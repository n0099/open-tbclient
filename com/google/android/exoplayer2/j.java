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
    private boolean lYA;
    private boolean lYB;
    private int lYC;
    private int lYD;
    private com.google.android.exoplayer2.source.u lYE;
    private com.google.android.exoplayer2.b.g lYF;
    private q lYG;
    private p lYH;
    private int lYI;
    private int lYJ;
    private long lYK;
    private final s[] lYu;
    private final com.google.android.exoplayer2.b.h lYv;
    private final com.google.android.exoplayer2.b.g lYw;
    private final Handler lYx;
    private final k lYy;
    private boolean lYz;
    private int laJ;
    private final x.b lbE;
    private final x.a lbF;
    private final CopyOnWriteArraySet<r.b> lbO;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHM + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lYu = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lYv = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lYA = false;
        this.dU = 0;
        this.lYB = false;
        this.laJ = 1;
        this.lbO = new CopyOnWriteArraySet<>();
        this.lYw = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.lbE = new x.b();
        this.lbF = new x.a();
        this.lYE = com.google.android.exoplayer2.source.u.mta;
        this.lYF = this.lYw;
        this.lYG = q.lZH;
        this.lYx = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lYH = new p(x.mae, null, 0, 0L);
        this.lYy = new k(sVarArr, hVar, nVar, this.lYA, this.dU, this.lYB, this.lYx, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lbO.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lbO.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZN() {
        return this.laJ;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lYI = dsV();
            this.lYJ = dsU();
            this.lYK = getCurrentPosition();
        } else {
            this.lYI = 0;
            this.lYJ = 0;
            this.lYK = 0L;
        }
        if (z2) {
            if (!this.lYH.timeline.isEmpty() || this.lYH.lZs != null) {
                this.lYH = this.lYH.b(x.mae, null);
                Iterator<r.b> it = this.lbO.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lYH.timeline, this.lYH.lZs);
                }
            }
            if (this.lYz) {
                this.lYz = false;
                this.lYE = com.google.android.exoplayer2.source.u.mta;
                this.lYF = this.lYw;
                this.lYv.bA(null);
                Iterator<r.b> it2 = this.lbO.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lYE, this.lYF);
                }
            }
        }
        this.lYD++;
        this.lYy.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        if (this.lYA != z) {
            this.lYA = z;
            this.lYy.vy(z);
            Iterator<r.b> it = this.lbO.iterator();
            while (it.hasNext()) {
                it.next().A(z, this.laJ);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsR() {
        return this.lYA;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dU != i) {
            this.dU = i;
            this.lYy.setRepeatMode(i);
            Iterator<r.b> it = this.lbO.iterator();
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
        if (this.lYB != z) {
            this.lYB = z;
            this.lYy.vz(z);
            Iterator<r.b> it = this.lbO.iterator();
            while (it.hasNext()) {
                it.next().ue(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsS() {
        return this.lYB;
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        x xVar = this.lYH.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dtz())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (dsZ()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lYC == 0) {
                Iterator<r.b> it = this.lbO.iterator();
                while (it.hasNext()) {
                    it.next().daf();
                }
                return;
            }
            return;
        }
        this.lYC++;
        this.lYI = i;
        if (xVar.isEmpty()) {
            this.lYK = j == -9223372036854775807L ? 0L : j;
            this.lYJ = 0;
        } else {
            xVar.a(i, this.lbE);
            long dtG = j == -9223372036854775807L ? this.lbE.dtG() : b.fo(j);
            int i2 = this.lbE.mar;
            long dtH = this.lbE.dtH() + dtG;
            long durationUs = xVar.a(i2, this.lbF).getDurationUs();
            while (durationUs != -9223372036854775807L && dtH >= durationUs && i2 < this.lbE.mas) {
                dtH -= durationUs;
                i2++;
                durationUs = xVar.a(i2, this.lbF).getDurationUs();
            }
            this.lYK = b.fn(dtG);
            this.lYJ = i2;
        }
        this.lYy.a(xVar, i, b.fo(j));
        Iterator<r.b> it2 = this.lbO.iterator();
        while (it2.hasNext()) {
            it2.next().ET(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lZH;
        }
        this.lYy.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsT() {
        return this.lYG;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYy.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mHM + "] [" + l.dtv() + "]");
        this.lYy.release();
        this.lYx.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYy.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYy.b(bVarArr);
    }

    public int dsU() {
        return dtd() ? this.lYJ : this.lYH.lZE.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsV() {
        return dtd() ? this.lYI : this.lYH.timeline.a(this.lYH.lZE.periodIndex, this.lbF).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dsW() {
        x xVar = this.lYH.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(dsV(), this.dU, this.lYB);
    }

    @Override // com.google.android.exoplayer2.r
    public int dsX() {
        x xVar = this.lYH.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(dsV(), this.dU, this.lYB);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lYH.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (dsZ()) {
            l.b bVar = this.lYH.lZE;
            xVar.a(bVar.periodIndex, this.lbF);
            return b.fn(this.lbF.dH(bVar.msd, bVar.mse));
        }
        return xVar.a(dsV(), this.lbE).dtB();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return dtd() ? this.lYK : fr(this.lYH.lZF);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return dtd() ? this.lYK : fr(this.lYH.lZG);
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
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
    public boolean dsZ() {
        return !dtd() && this.lYH.lZE.dws();
    }

    @Override // com.google.android.exoplayer2.r
    public long dta() {
        if (dsZ()) {
            this.lYH.timeline.a(this.lYH.lZE.periodIndex, this.lbF);
            return this.lbF.dtC() + b.fn(this.lYH.lZA);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lYu[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtb() {
        return this.lYF;
    }

    @Override // com.google.android.exoplayer2.r
    public x dtc() {
        return this.lYH.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.laJ = message.arg1;
                Iterator<r.b> it = this.lbO.iterator();
                while (it.hasNext()) {
                    it.next().A(this.lYA, this.laJ);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.lbO.iterator();
                while (it2.hasNext()) {
                    it2.next().ud(this.isLoading);
                }
                return;
            case 2:
                if (this.lYD == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lYz = true;
                    this.lYE = iVar.mDm;
                    this.lYF = iVar.mDo;
                    this.lYv.bA(iVar.mDp);
                    Iterator<r.b> it3 = this.lbO.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lYE, this.lYF);
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
                if (!this.lYG.equals(qVar)) {
                    this.lYG = qVar;
                    Iterator<r.b> it4 = this.lbO.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.lbO.iterator();
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
        this.lYD -= i;
        this.lYC -= i2;
        if (this.lYD == 0 && this.lYC == 0) {
            boolean z2 = (this.lYH.timeline == pVar.timeline && this.lYH.lZs == pVar.lZs) ? false : true;
            this.lYH = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lYJ = 0;
                this.lYI = 0;
                this.lYK = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.lbO.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lZs);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.lbO.iterator();
                while (it2.hasNext()) {
                    it2.next().ET(i3);
                }
            }
        }
        if (this.lYC == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.lbO.iterator();
            while (it3.hasNext()) {
                it3.next().daf();
            }
        }
    }

    private long fr(long j) {
        long fn = b.fn(j);
        if (!this.lYH.lZE.dws()) {
            this.lYH.timeline.a(this.lYH.lZE.periodIndex, this.lbF);
            return fn + this.lbF.dtC();
        }
        return fn;
    }

    private boolean dtd() {
        return this.lYH.timeline.isEmpty() || this.lYC > 0 || this.lYD > 0;
    }
}
