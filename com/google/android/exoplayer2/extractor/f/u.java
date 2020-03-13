package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class u implements r {
    private com.google.android.exoplayer2.extractor.m meW;
    private com.google.android.exoplayer2.util.s mjC;
    private boolean moT;

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjC = sVar;
        dVar.dvF();
        this.meW = gVar.dK(dVar.dvG(), 4);
        this.meW.h(Format.a(dVar.dvH(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.r
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (!this.moT) {
            if (this.mjC.dzS() != -9223372036854775807L) {
                this.meW.h(Format.i(null, "application/x-scte35", this.mjC.dzS()));
                this.moT = true;
            } else {
                return;
            }
        }
        int dzu = lVar.dzu();
        this.meW.a(lVar, dzu);
        this.meW.a(this.mjC.dzR(), 1, dzu, 0, null);
    }
}
