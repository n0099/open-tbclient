package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m mah;
    private int mbj;
    private boolean miq;
    private long mis;
    private final com.google.android.exoplayer2.util.l mjv = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.miq = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mah = gVar.dJ(dVar.dtf(), 4);
        this.mah.h(Format.a(dVar.dtg(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.miq = true;
            this.mis = j;
            this.sampleSize = 0;
            this.mbj = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.miq) {
            int dwV = lVar.dwV();
            if (this.mbj < 10) {
                int min = Math.min(dwV, 10 - this.mbj);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mjv.data, this.mbj, min);
                if (min + this.mbj == 10) {
                    this.mjv.setPosition(0);
                    if (73 != this.mjv.readUnsignedByte() || 68 != this.mjv.readUnsignedByte() || 51 != this.mjv.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.miq = false;
                        return;
                    }
                    this.mjv.skipBytes(3);
                    this.sampleSize = this.mjv.dxf() + 10;
                }
            }
            int min2 = Math.min(dwV, this.sampleSize - this.mbj);
            this.mah.a(lVar, min2);
            this.mbj = min2 + this.mbj;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
        if (this.miq && this.sampleSize != 0 && this.mbj == this.sampleSize) {
            this.mah.a(this.mis, 1, this.sampleSize, 0, null);
            this.miq = false;
        }
    }
}
