package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes5.dex */
public final class e implements n {
    private final com.google.android.exoplayer2.upstream.h lXC;
    private final long lXD;
    private final long lXE;
    private final long lXF;
    private final long lXG;
    private final PriorityTaskManager lXH;
    private int lXI;
    private boolean lbA;

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
        this.lXC = hVar;
        this.lXD = i * 1000;
        this.lXE = i2 * 1000;
        this.lXF = j * 1000;
        this.lXG = j2 * 1000;
        this.lXH = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lXI = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LD(i) != null) {
                this.lXI += com.google.android.exoplayer2.util.v.LW(sVarArr[i].getTrackType());
            }
        }
        this.lXC.LM(this.lXI);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void drC() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b drD() {
        return this.lXC;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean k(long j, boolean z) {
        long j2 = z ? this.lXG : this.lXF;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fr(long j) {
        boolean z = true;
        int fs = fs(j);
        boolean z2 = this.lXC.dxM() >= this.lXI;
        boolean z3 = this.lbA;
        if (fs != 2 && (fs != 1 || !this.lbA || z2)) {
            z = false;
        }
        this.lbA = z;
        if (this.lXH != null && this.lbA != z3) {
            if (this.lbA) {
                this.lXH.add(0);
            } else {
                this.lXH.remove(0);
            }
        }
        return this.lbA;
    }

    private int fs(long j) {
        if (j > this.lXE) {
            return 0;
        }
        return j < this.lXD ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lXI = 0;
        if (this.lXH != null && this.lbA) {
            this.lXH.remove(0);
        }
        this.lbA = false;
        if (z) {
            this.lXC.reset();
        }
    }
}
