package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m meJ;
    private com.google.android.exoplayer2.util.s mjp;
    private boolean moG;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjp = sVar;
        dVar.dvC();
        this.meJ = gVar.dK(dVar.dvD(), 4);
        this.meJ.h(Format.a(dVar.dvE(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.moG) {
            if (this.mjp.dzP() != -9223372036854775807L) {
                this.meJ.h(Format.i(null, "application/x-scte35", this.mjp.dzP()));
                this.moG = true;
            } else {
                return;
            }
        }
        int dzr = lVar.dzr();
        this.meJ.a(lVar, dzr);
        this.meJ.a(this.mjp.dzO(), 1, dzr, 0, null);
    }
}
