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
/* loaded from: classes4.dex */
final class j implements g {
    private int dU;
    private boolean isLoading;
    private int kWy;
    private final CopyOnWriteArraySet<r.b> kXD;
    private final x.b kXt;
    private final x.a kXu;
    private final s[] lTS;
    private final com.google.android.exoplayer2.b.h lTT;
    private final com.google.android.exoplayer2.b.g lTU;
    private final Handler lTV;
    private final k lTW;
    private boolean lTX;
    private boolean lTY;
    private boolean lTZ;
    private int lUa;
    private int lUb;
    private com.google.android.exoplayer2.source.u lUc;
    private com.google.android.exoplayer2.b.g lUd;
    private q lUe;
    private p lUf;
    private int lUg;
    private int lUh;
    private long lUi;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mDm + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.lTS = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.lTT = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.lTY = false;
        this.dU = 0;
        this.lTZ = false;
        this.kWy = 1;
        this.kXD = new CopyOnWriteArraySet<>();
        this.lTU = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.kXt = new x.b();
        this.kXu = new x.a();
        this.lUc = com.google.android.exoplayer2.source.u.moA;
        this.lUd = this.lTU;
        this.lUe = q.lVf;
        this.lTV = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.lUf = new p(x.lVD, null, 0, 0L);
        this.lTW = new k(sVarArr, hVar, nVar, this.lTY, this.dU, this.lTZ, this.lTV, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.kXD.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.kXD.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cXu() {
        return this.kWy;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.lUg = dqv();
            this.lUh = dqu();
            this.lUi = getCurrentPosition();
        } else {
            this.lUg = 0;
            this.lUh = 0;
            this.lUi = 0L;
        }
        if (z2) {
            if (!this.lUf.timeline.isEmpty() || this.lUf.lUQ != null) {
                this.lUf = this.lUf.b(x.lVD, null);
                Iterator<r.b> it = this.kXD.iterator();
                while (it.hasNext()) {
                    it.next().a(this.lUf.timeline, this.lUf.lUQ);
                }
            }
            if (this.lTX) {
                this.lTX = false;
                this.lUc = com.google.android.exoplayer2.source.u.moA;
                this.lUd = this.lTU;
                this.lTT.bx(null);
                Iterator<r.b> it2 = this.kXD.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.lUc, this.lUd);
                }
            }
        }
        this.lUb++;
        this.lTW.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vi(boolean z) {
        if (this.lTY != z) {
            this.lTY = z;
            this.lTW.vi(z);
            Iterator<r.b> it = this.kXD.iterator();
            while (it.hasNext()) {
                it.next().y(z, this.kWy);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dqr() {
        return this.lTY;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dU != i) {
            this.dU = i;
            this.lTW.setRepeatMode(i);
            Iterator<r.b> it = this.kXD.iterator();
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
    public void vj(boolean z) {
        if (this.lTZ != z) {
            this.lTZ = z;
            this.lTW.vj(z);
            Iterator<r.b> it = this.kXD.iterator();
            while (it.hasNext()) {
                it.next().tO(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dqs() {
        return this.lTZ;
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        x xVar = this.lUf.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dqZ())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (dqz()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.lUa == 0) {
                Iterator<r.b> it = this.kXD.iterator();
                while (it.hasNext()) {
                    it.next().cXM();
                }
                return;
            }
            return;
        }
        this.lUa++;
        this.lUg = i;
        if (xVar.isEmpty()) {
            this.lUi = j == -9223372036854775807L ? 0L : j;
            this.lUh = 0;
        } else {
            xVar.a(i, this.kXt);
            long drh = j == -9223372036854775807L ? this.kXt.drh() : b.fl(j);
            int i2 = this.kXt.lVP;
            long dri = this.kXt.dri() + drh;
            long drc = xVar.a(i2, this.kXu).drc();
            while (drc != -9223372036854775807L && dri >= drc && i2 < this.kXt.lVQ) {
                dri -= drc;
                i2++;
                drc = xVar.a(i2, this.kXu).drc();
            }
            this.lUi = b.fk(drh);
            this.lUh = i2;
        }
        this.lTW.a(xVar, i, b.fl(j));
        Iterator<r.b> it2 = this.kXD.iterator();
        while (it2.hasNext()) {
            it2.next().EJ(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.lVf;
        }
        this.lTW.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dqt() {
        return this.lUe;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lTW.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mDm + "] [" + l.dqV() + "]");
        this.lTW.release();
        this.lTV.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lTW.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lTW.b(bVarArr);
    }

    public int dqu() {
        return dqD() ? this.lUh : this.lUf.lVc.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dqv() {
        return dqD() ? this.lUg : this.lUf.timeline.a(this.lUf.lVc.periodIndex, this.kXu).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dqw() {
        x xVar = this.lUf.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(dqv(), this.dU, this.lTZ);
    }

    @Override // com.google.android.exoplayer2.r
    public int dqx() {
        x xVar = this.lUf.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(dqv(), this.dU, this.lTZ);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.lUf.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (dqz()) {
            l.b bVar = this.lUf.lVc;
            xVar.a(bVar.periodIndex, this.kXu);
            return b.fk(this.kXu.dG(bVar.mnD, bVar.mnE));
        }
        return xVar.a(dqv(), this.kXt).drb();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return dqD() ? this.lUi : fo(this.lUf.lVd);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return dqD() ? this.lUi : fo(this.lUf.lVe);
    }

    @Override // com.google.android.exoplayer2.r
    public int dqy() {
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
    public boolean dqz() {
        return !dqD() && this.lUf.lVc.dtV();
    }

    @Override // com.google.android.exoplayer2.r
    public long dqA() {
        if (dqz()) {
            this.lUf.timeline.a(this.lUf.lVc.periodIndex, this.kXu);
            return this.kXu.drd() + b.fk(this.lUf.lUY);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IF(int i) {
        return this.lTS[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dqB() {
        return this.lUd;
    }

    @Override // com.google.android.exoplayer2.r
    public x dqC() {
        return this.lUf.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.kWy = message.arg1;
                Iterator<r.b> it = this.kXD.iterator();
                while (it.hasNext()) {
                    it.next().y(this.lTY, this.kWy);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.kXD.iterator();
                while (it2.hasNext()) {
                    it2.next().tN(this.isLoading);
                }
                return;
            case 2:
                if (this.lUb == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.lTX = true;
                    this.lUc = iVar.myK;
                    this.lUd = iVar.myM;
                    this.lTT.bx(iVar.myN);
                    Iterator<r.b> it3 = this.kXD.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.lUc, this.lUd);
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
                if (!this.lUe.equals(qVar)) {
                    this.lUe = qVar;
                    Iterator<r.b> it4 = this.kXD.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.kXD.iterator();
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
        this.lUb -= i;
        this.lUa -= i2;
        if (this.lUb == 0 && this.lUa == 0) {
            boolean z2 = (this.lUf.timeline == pVar.timeline && this.lUf.lUQ == pVar.lUQ) ? false : true;
            this.lUf = pVar;
            if (pVar.timeline.isEmpty()) {
                this.lUh = 0;
                this.lUg = 0;
                this.lUi = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.kXD.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.lUQ);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.kXD.iterator();
                while (it2.hasNext()) {
                    it2.next().EJ(i3);
                }
            }
        }
        if (this.lUa == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.kXD.iterator();
            while (it3.hasNext()) {
                it3.next().cXM();
            }
        }
    }

    private long fo(long j) {
        long fk = b.fk(j);
        if (!this.lUf.lVc.dtV()) {
            this.lUf.timeline.a(this.lUf.lVc.periodIndex, this.kXu);
            return fk + this.kXu.drd();
        }
        return fk;
    }

    private boolean dqD() {
        return this.lUf.timeline.isEmpty() || this.lUa > 0 || this.lUb > 0;
    }
}
