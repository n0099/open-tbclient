package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m meL;
    private com.google.android.exoplayer2.util.s mjr;
    private boolean moI;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjr = sVar;
        dVar.dvE();
        this.meL = gVar.dK(dVar.dvF(), 4);
        this.meL.h(Format.a(dVar.dvG(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.moI) {
            if (this.mjr.dzR() != -9223372036854775807L) {
                this.meL.h(Format.i(null, "application/x-scte35", this.mjr.dzR()));
                this.moI = true;
            } else {
                return;
            }
        }
        int dzt = lVar.dzt();
        this.meL.a(lVar, dzt);
        this.meL.a(this.mjr.dzQ(), 1, dzt, 0, null);
    }
}
