package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes4.dex */
public final class e implements n {
    private boolean kXV;
    private final com.google.android.exoplayer2.upstream.h lTG;
    private final long lTH;
    private final long lTI;
    private final long lTJ;
    private final long lTK;
    private final PriorityTaskManager lTL;
    private int lTM;

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
        this.lTG = hVar;
        this.lTH = i * 1000;
        this.lTI = i2 * 1000;
        this.lTJ = j * 1000;
        this.lTK = j2 * 1000;
        this.lTL = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.lTM = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.Lu(i) != null) {
                this.lTM += com.google.android.exoplayer2.util.v.LN(sVarArr[i].getTrackType());
            }
        }
        this.lTG.LD(this.lTM);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void dqo() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b dqp() {
        return this.lTG;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean k(long j, boolean z) {
        long j2 = z ? this.lTK : this.lTJ;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fm(long j) {
        boolean z = true;
        int fn = fn(j);
        boolean z2 = this.lTG.dwz() >= this.lTM;
        boolean z3 = this.kXV;
        if (fn != 2 && (fn != 1 || !this.kXV || z2)) {
            z = false;
        }
        this.kXV = z;
        if (this.lTL != null && this.kXV != z3) {
            if (this.kXV) {
                this.lTL.add(0);
            } else {
                this.lTL.remove(0);
            }
        }
        return this.kXV;
    }

    private int fn(long j) {
        if (j > this.lTI) {
            return 0;
        }
        return j < this.lTH ? 2 : 1;
    }

    private void reset(boolean z) {
        this.lTM = 0;
        if (this.lTL != null && this.kXV) {
            this.lTL.remove(0);
        }
        this.kXV = false;
        if (z) {
            this.lTG.reset();
        }
    }
}
