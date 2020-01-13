package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes5.dex */
public final class e implements n {
    private final long lXA;
    private final long lXB;
    private final PriorityTaskManager lXC;
    private int lXD;
    private final com.google.android.exoplayer2.upstream.h lXx;
    private final long lXy;
    private final long lXz;
    private boolean lbv;

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
        this.lXx = hVar;
        this.lXy = i * 1000;
        this.lXz = i2 * 1000;
        this.lXA = j * 1000;
        this.lXB = j2 * 1000;
        this.lXC = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lXD = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LD(i) != null) {
                this.lXD += com.google.android.exoplayer2.util.v.LW(sVarArr[i].getTrackType());
            }
        }
        this.lXx.LM(this.lXD);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void drA() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b drB() {
        return this.lXx;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean k(long j, boolean z) {
        long j2 = z ? this.lXB : this.lXA;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fr(long j) {
        boolean z = true;
        int fs = fs(j);
        boolean z2 = this.lXx.dxK() >= this.lXD;
        boolean z3 = this.lbv;
        if (fs != 2 && (fs != 1 || !this.lbv || z2)) {
            z = false;
        }
        this.lbv = z;
        if (this.lXC != null && this.lbv != z3) {
            if (this.lbv) {
                this.lXC.add(0);
            } else {
                this.lXC.remove(0);
            }
        }
        return this.lbv;
    }

    private int fs(long j) {
        if (j > this.lXz) {
            return 0;
        }
        return j < this.lXy ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lXD = 0;
        if (this.lXC != null && this.lbv) {
            this.lXC.remove(0);
        }
        this.lbv = false;
        if (z) {
            this.lXx.reset();
        }
    }
}
