package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m mdY;
    private com.google.android.exoplayer2.util.s miE;
    private boolean mnU;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.miE = sVar;
        dVar.dup();
        this.mdY = gVar.dH(dVar.duq(), 4);
        this.mdY.h(Format.a(dVar.dur(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.mnU) {
            if (this.miE.dyD() != -9223372036854775807L) {
                this.mdY.h(Format.i(null, "application/x-scte35", this.miE.dyD()));
                this.mnU = true;
            } else {
                return;
            }
        }
        int dyf = lVar.dyf();
        this.mdY.a(lVar, dyf);
        this.mdY.a(this.miE.dyC(), 1, dyf, 0, null);
    }
}
