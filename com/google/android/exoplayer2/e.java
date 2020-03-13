package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes6.dex */
public final class e implements n {
    private final PriorityTaskManager lYA;
    private int lYB;
    private final com.google.android.exoplayer2.upstream.h lYv;
    private final long lYw;
    private final long lYx;
    private final long lYy;
    private final long lYz;
    private boolean lcv;

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
        this.lYv = hVar;
        this.lYw = i * 1000;
        this.lYx = i2 * 1000;
        this.lYy = j * 1000;
        this.lYz = j2 * 1000;
        this.lYA = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lYB = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LI(i) != null) {
                this.lYB += com.google.android.exoplayer2.util.v.Mb(sVarArr[i].getTrackType());
            }
        }
        this.lYv.LR(this.lYB);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void dsR() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b dsS() {
        return this.lYv;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean m(long j, boolean z) {
        long j2 = z ? this.lYz : this.lYy;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fp(long j) {
        boolean z = true;
        int fq = fq(j);
        boolean z2 = this.lYv.dyZ() >= this.lYB;
        boolean z3 = this.lcv;
        if (fq != 2 && (fq != 1 || !this.lcv || z2)) {
            z = false;
        }
        this.lcv = z;
        if (this.lYA != null && this.lcv != z3) {
            if (this.lcv) {
                this.lYA.add(0);
            } else {
                this.lYA.remove(0);
            }
        }
        return this.lcv;
    }

    private int fq(long j) {
        if (j > this.lYx) {
            return 0;
        }
        return j < this.lYw ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lYB = 0;
        if (this.lYA != null && this.lcv) {
            this.lYA.remove(0);
        }
        this.lcv = false;
        if (z) {
            this.lYv.reset();
        }
    }
}
