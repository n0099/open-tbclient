package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m mgC;
    private com.google.android.exoplayer2.util.s mli;
    private boolean mqz;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mli = sVar;
        dVar.dwc();
        this.mgC = gVar.dL(dVar.dwd(), 4);
        this.mgC.h(Format.a(dVar.dwe(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.mqz) {
            if (this.mli.dAp() != -9223372036854775807L) {
                this.mgC.h(Format.i(null, "application/x-scte35", this.mli.dAp()));
                this.mqz = true;
            } else {
                return;
            }
        }
        int dzR = lVar.dzR();
        this.mgC.a(lVar, dzR);
        this.mgC.a(this.mli.dAo(), 1, dzR, 0, null);
    }
}
