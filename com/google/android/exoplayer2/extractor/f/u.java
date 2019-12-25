package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m mah;
    private com.google.android.exoplayer2.util.s meN;
    private boolean mkg;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.meN = sVar;
        dVar.dte();
        this.mah = gVar.dJ(dVar.dtf(), 4);
        this.mah.h(Format.a(dVar.dtg(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.mkg) {
            if (this.meN.dxt() != -9223372036854775807L) {
                this.mah.h(Format.h(null, "application/x-scte35", this.meN.dxt()));
                this.mkg = true;
            } else {
                return;
            }
        }
        int dwV = lVar.dwV();
        this.mah.a(lVar, dwV);
        this.mah.a(this.meN.dxs(), 1, dwV, 0, null);
    }
}
