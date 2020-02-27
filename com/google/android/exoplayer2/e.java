package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes6.dex */
public final class e implements n {
    private final com.google.android.exoplayer2.upstream.h lYi;
    private final long lYj;
    private final long lYk;
    private final long lYl;
    private final long lYm;
    private final PriorityTaskManager lYn;
    private int lYo;
    private boolean lcg;

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
        this.lYi = hVar;
        this.lYj = i * 1000;
        this.lYk = i2 * 1000;
        this.lYl = j * 1000;
        this.lYm = j2 * 1000;
        this.lYn = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lYo = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LI(i) != null) {
                this.lYo += com.google.android.exoplayer2.util.v.Mb(sVarArr[i].getTrackType());
            }
        }
        this.lYi.LR(this.lYo);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void dsO() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b dsP() {
        return this.lYi;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean m(long j, boolean z) {
        long j2 = z ? this.lYm : this.lYl;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fp(long j) {
        boolean z = true;
        int fq = fq(j);
        boolean z2 = this.lYi.dyW() >= this.lYo;
        boolean z3 = this.lcg;
        if (fq != 2 && (fq != 1 || !this.lcg || z2)) {
            z = false;
        }
        this.lcg = z;
        if (this.lYn != null && this.lcg != z3) {
            if (this.lcg) {
                this.lYn.add(0);
            } else {
                this.lYn.remove(0);
            }
        }
        return this.lcg;
    }

    private int fq(long j) {
        if (j > this.lYk) {
            return 0;
        }
        return j < this.lYj ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lYo = 0;
        if (this.lYn != null && this.lcg) {
            this.lYn.remove(0);
        }
        this.lcg = false;
        if (z) {
            this.lYi.reset();
        }
    }
}
