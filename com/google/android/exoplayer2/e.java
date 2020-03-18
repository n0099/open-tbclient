package com.google.android.exoplayer2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes6.dex */
public final class e implements n {
    private boolean ldZ;
    private final com.google.android.exoplayer2.upstream.h mab;
    private final long mad;
    private final long mae;
    private final long maf;
    private final long mag;
    private final PriorityTaskManager mah;
    private int mai;

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
        this.mab = hVar;
        this.mad = i * 1000;
        this.mae = i2 * 1000;
        this.maf = j * 1000;
        this.mag = j2 * 1000;
        this.mah = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.n
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.n
    public void a(s[] sVarArr, com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        this.mai = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.LO(i) != null) {
                this.mai += com.google.android.exoplayer2.util.v.Mh(sVarArr[i].getTrackType());
            }
        }
        this.mab.LX(this.mai);
    }

    @Override // com.google.android.exoplayer2.n
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public void dto() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.n
    public com.google.android.exoplayer2.upstream.b dtp() {
        return this.mab;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean n(long j, boolean z) {
        long j2 = z ? this.mag : this.maf;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean fq(long j) {
        boolean z = true;
        int fr = fr(j);
        boolean z2 = this.mab.dzw() >= this.mai;
        boolean z3 = this.ldZ;
        if (fr != 2 && (fr != 1 || !this.ldZ || z2)) {
            z = false;
        }
        this.ldZ = z;
        if (this.mah != null && this.ldZ != z3) {
            if (this.ldZ) {
                this.mah.add(0);
            } else {
                this.mah.remove(0);
            }
        }
        return this.ldZ;
    }

    private int fr(long j) {
        if (j > this.mae) {
            return 0;
        }
        return j < this.mad ? 2 : 1;
    }

    private void reset(boolean z) {
        this.mai = 0;
        if (this.mah != null && this.ldZ) {
            this.mah.remove(0);
        }
        this.ldZ = false;
        if (z) {
            this.mab.reset();
        }
    }
}
