package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes6.dex */
public final class e implements n {
    private final com.google.android.exoplayer2.upstream.h lYk;
    private final long lYl;
    private final long lYm;
    private final long lYn;
    private final long lYo;
    private final PriorityTaskManager lYp;
    private int lYq;
    private boolean lci;

    public e() {
        this(new com.google.android.exoplayer2.upstream.h(true, 65536));
    }

    public e(com.google.android.exoplayer2.upstream.h hVar) {
        this(hVar, BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, 30000, 2500L, 5000L);
    }

    public e(com.google.android.exoplayer2.upstream.h hVar, int i, int i2, long j, long j2) {
        this(hVar, i, i2, j, j2, null);
    }

    public e(com.google.android.exoplayer2.upstream.h hVar, int i, int i2, long j, long j2, PriorityTaskManager priorityTaskManager) {
        this.lYk = hVar;
        this.lYl = i * 1000;
        this.lYm = i2 * 1000;
        this.lYn = j * 1000;
        this.lYo = j2 * 1000;
        this.lYp = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lYq = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LI(i) != null) {
                this.lYq += com.google.android.exoplayer2.util.v.Mb(sVarArr[i].getTrackType());
            }
        }
        this.lYk.LR(this.lYq);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void dsQ() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b dsR() {
        return this.lYk;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean m(long j, boolean z) {
        long j2 = z ? this.lYo : this.lYn;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fp(long j) {
        boolean z = true;
        int fq = fq(j);
        boolean z2 = this.lYk.dyY() >= this.lYq;
        boolean z3 = this.lci;
        if (fq != 2 && (fq != 1 || !this.lci || z2)) {
            z = false;
        }
        this.lci = z;
        if (this.lYp != null && this.lci != z3) {
            if (this.lci) {
                this.lYp.add(0);
            } else {
                this.lYp.remove(0);
            }
        }
        return this.lci;
    }

    private int fq(long j) {
        if (j > this.lYm) {
            return 0;
        }
        return j < this.lYl ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lYq = 0;
        if (this.lYp != null && this.lci) {
            this.lYp.remove(0);
        }
        this.lci = false;
        if (z) {
            this.lYk.reset();
        }
    }
}
