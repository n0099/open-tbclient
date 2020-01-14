package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m med;
    private com.google.android.exoplayer2.util.s miJ;
    private boolean mnZ;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.miJ = sVar;
        dVar.dur();
        this.med = gVar.dH(dVar.dus(), 4);
        this.med.h(Format.a(dVar.dut(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.mnZ) {
            if (this.miJ.dyF() != -9223372036854775807L) {
                this.med.h(Format.i(null, "application/x-scte35", this.miJ.dyF()));
                this.mnZ = true;
            } else {
                return;
            }
        }
        int dyh = lVar.dyh();
        this.med.a(lVar, dyh);
        this.med.a(this.miJ.dyE(), 1, dyh, 0, null);
    }
}
