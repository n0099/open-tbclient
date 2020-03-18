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
    private int dT;
    private boolean isLoading;
    private int lcC;
    private final CopyOnWriteArraySet<r.b> ldH;
    private final x.b ldx;
    private final x.a ldy;
    private com.google.android.exoplayer2.source.u maA;
    private com.google.android.exoplayer2.b.g maB;
    private q maC;
    private p maD;
    private int maE;
    private int maF;
    private long maG;
    private final s[] mao;
    private final com.google.android.exoplayer2.b.h maq;
    private final com.google.android.exoplayer2.b.g mar;
    private final Handler mas;
    private final k mat;
    private boolean mau;
    private boolean mav;
    private boolean maw;
    private int may;
    private int maz;

    @SuppressLint({"HandlerLeak"})
    public j(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mJJ + "]");
        com.google.android.exoplayer2.util.a.checkState(sVarArr.length > 0);
        this.mao = (s[]) com.google.android.exoplayer2.util.a.checkNotNull(sVarArr);
        this.maq = (com.google.android.exoplayer2.b.h) com.google.android.exoplayer2.util.a.checkNotNull(hVar);
        this.mav = false;
        this.dT = 0;
        this.maw = false;
        this.lcC = 1;
        this.ldH = new CopyOnWriteArraySet<>();
        this.mar = new com.google.android.exoplayer2.b.g(new com.google.android.exoplayer2.b.f[sVarArr.length]);
        this.ldx = new x.b();
        this.ldy = new x.a();
        this.maA = com.google.android.exoplayer2.source.u.muU;
        this.maB = this.mar;
        this.maC = q.mbD;
        this.mas = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                j.this.N(message);
            }
        };
        this.maD = new p(x.mbZ, null, 0, 0L);
        this.mat = new k(sVarArr, hVar, nVar, this.mav, this.dT, this.maw, this.mas, this);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.ldH.add(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.ldH.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int dan() {
        return this.lcC;
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        a(lVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.l lVar, boolean z, boolean z2) {
        if (!z) {
            this.maE = dtv();
            this.maF = dtu();
            this.maG = getCurrentPosition();
        } else {
            this.maE = 0;
            this.maF = 0;
            this.maG = 0L;
        }
        if (z2) {
            if (!this.maD.timeline.isEmpty() || this.maD.mbo != null) {
                this.maD = this.maD.b(x.mbZ, null);
                Iterator<r.b> it = this.ldH.iterator();
                while (it.hasNext()) {
                    it.next().a(this.maD.timeline, this.maD.mbo);
                }
            }
            if (this.mau) {
                this.mau = false;
                this.maA = com.google.android.exoplayer2.source.u.muU;
                this.maB = this.mar;
                this.maq.bA(null);
                Iterator<r.b> it2 = this.ldH.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.maA, this.maB);
                }
            }
        }
        this.maz++;
        this.mat.a(lVar, z);
    }

    @Override // com.google.android.exoplayer2.r
    public void vF(boolean z) {
        if (this.mav != z) {
            this.mav = z;
            this.mat.vF(z);
            Iterator<r.b> it = this.ldH.iterator();
            while (it.hasNext()) {
                it.next().A(z, this.lcC);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtr() {
        return this.mav;
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        if (this.dT != i) {
            this.dT = i;
            this.mat.setRepeatMode(i);
            Iterator<r.b> it = this.ldH.iterator();
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
    public void vG(boolean z) {
        if (this.maw != z) {
            this.maw = z;
            this.mat.vG(z);
            Iterator<r.b> it = this.ldH.iterator();
            while (it.hasNext()) {
                it.next().ul(z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dts() {
        return this.maw;
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        x xVar = this.maD.timeline;
        if (i < 0 || (!xVar.isEmpty() && i >= xVar.dtZ())) {
            throw new IllegalSeekPositionException(xVar, i, j);
        }
        if (dtz()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.may == 0) {
                Iterator<r.b> it = this.ldH.iterator();
                while (it.hasNext()) {
                    it.next().daF();
                }
                return;
            }
            return;
        }
        this.may++;
        this.maE = i;
        if (xVar.isEmpty()) {
            this.maG = j == -9223372036854775807L ? 0L : j;
            this.maF = 0;
        } else {
            xVar.a(i, this.ldx);
            long dug = j == -9223372036854775807L ? this.ldx.dug() : b.fp(j);
            int i2 = this.ldx.mcl;
            long duh = this.ldx.duh() + dug;
            long durationUs = xVar.a(i2, this.ldy).getDurationUs();
            while (durationUs != -9223372036854775807L && duh >= durationUs && i2 < this.ldx.mcm) {
                duh -= durationUs;
                i2++;
                durationUs = xVar.a(i2, this.ldy).getDurationUs();
            }
            this.maG = b.fo(dug);
            this.maF = i2;
        }
        this.mat.a(xVar, i, b.fp(j));
        Iterator<r.b> it2 = this.ldH.iterator();
        while (it2.hasNext()) {
            it2.next().Fa(1);
        }
    }

    @Override // com.google.android.exoplayer2.r
    public void b(@Nullable q qVar) {
        if (qVar == null) {
            qVar = q.mbD;
        }
        this.mat.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dtt() {
        return this.maC;
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.mat.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + com.google.android.exoplayer2.util.v.mJJ + "] [" + l.dtV() + "]");
        this.mat.release();
        this.mas.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.mat.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.mat.b(bVarArr);
    }

    public int dtu() {
        return dtD() ? this.maF : this.maD.mbA.periodIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dtv() {
        return dtD() ? this.maE : this.maD.timeline.a(this.maD.mbA.periodIndex, this.ldy).windowIndex;
    }

    @Override // com.google.android.exoplayer2.r
    public int dtw() {
        x xVar = this.maD.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.p(dtv(), this.dT, this.maw);
    }

    @Override // com.google.android.exoplayer2.r
    public int dtx() {
        x xVar = this.maD.timeline;
        if (xVar.isEmpty()) {
            return -1;
        }
        return xVar.q(dtv(), this.dT, this.maw);
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        x xVar = this.maD.timeline;
        if (xVar.isEmpty()) {
            return -9223372036854775807L;
        }
        if (dtz()) {
            l.b bVar = this.maD.mbA;
            xVar.a(bVar.periodIndex, this.ldy);
            return b.fo(this.ldy.dI(bVar.mtY, bVar.mtZ));
        }
        return xVar.a(dtv(), this.ldx).dub();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return dtD() ? this.maG : fs(this.maD.mbB);
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return dtD() ? this.maG : fs(this.maD.mbC);
    }

    @Override // com.google.android.exoplayer2.r
    public int dty() {
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
    public boolean dtz() {
        return !dtD() && this.maD.mbA.dwS();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtA() {
        if (dtz()) {
            this.maD.timeline.a(this.maD.mbA.periodIndex, this.ldy);
            return this.ldy.duc() + b.fo(this.maD.mbw);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int IZ(int i) {
        return this.mao[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtB() {
        return this.maB;
    }

    @Override // com.google.android.exoplayer2.r
    public x dtC() {
        return this.maD.timeline;
    }

    void N(Message message) {
        switch (message.what) {
            case 0:
                this.lcC = message.arg1;
                Iterator<r.b> it = this.ldH.iterator();
                while (it.hasNext()) {
                    it.next().A(this.mav, this.lcC);
                }
                return;
            case 1:
                this.isLoading = message.arg1 != 0;
                Iterator<r.b> it2 = this.ldH.iterator();
                while (it2.hasNext()) {
                    it2.next().uk(this.isLoading);
                }
                return;
            case 2:
                if (this.maz == 0) {
                    com.google.android.exoplayer2.b.i iVar = (com.google.android.exoplayer2.b.i) message.obj;
                    this.mau = true;
                    this.maA = iVar.mFi;
                    this.maB = iVar.mFk;
                    this.maq.bA(iVar.mFl);
                    Iterator<r.b> it3 = this.ldH.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.maA, this.maB);
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
                if (!this.maC.equals(qVar)) {
                    this.maC = qVar;
                    Iterator<r.b> it4 = this.ldH.iterator();
                    while (it4.hasNext()) {
                        it4.next().a(qVar);
                    }
                    return;
                }
                return;
            case 7:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<r.b> it5 = this.ldH.iterator();
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
        this.maz -= i;
        this.may -= i2;
        if (this.maz == 0 && this.may == 0) {
            boolean z2 = (this.maD.timeline == pVar.timeline && this.maD.mbo == pVar.mbo) ? false : true;
            this.maD = pVar;
            if (pVar.timeline.isEmpty()) {
                this.maF = 0;
                this.maE = 0;
                this.maG = 0L;
            }
            if (z2) {
                Iterator<r.b> it = this.ldH.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar.timeline, pVar.mbo);
                }
            }
            if (z) {
                Iterator<r.b> it2 = this.ldH.iterator();
                while (it2.hasNext()) {
                    it2.next().Fa(i3);
                }
            }
        }
        if (this.may == 0 && i2 > 0) {
            Iterator<r.b> it3 = this.ldH.iterator();
            while (it3.hasNext()) {
                it3.next().daF();
            }
        }
    }

    private long fs(long j) {
        long fo = b.fo(j);
        if (!this.maD.mbA.dwS()) {
            this.maD.timeline.a(this.maD.mbA.periodIndex, this.ldy);
            return fo + this.ldy.duc();
        }
        return fo;
    }

    private boolean dtD() {
        return this.maD.timeline.isEmpty() || this.may > 0 || this.maz > 0;
    }
}
