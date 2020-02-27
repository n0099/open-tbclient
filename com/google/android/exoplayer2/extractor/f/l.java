package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m meJ;
    private int mfJ;
    private boolean mmP;
    private long mmR;
    private final com.google.android.exoplayer2.util.l mnU = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.mmP = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.meJ = gVar.dK(dVar.dvD(), 4);
        this.meJ.h(Format.a(dVar.dvE(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mmP = true;
            this.mmR = j;
            this.sampleSize = 0;
            this.mfJ = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.mmP) {
            int dzr = lVar.dzr();
            if (this.mfJ < 10) {
                int min = Math.min(dzr, 10 - this.mfJ);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mnU.data, this.mfJ, min);
                if (min + this.mfJ == 10) {
                    this.mnU.setPosition(0);
                    if (73 != this.mnU.readUnsignedByte() || 68 != this.mnU.readUnsignedByte() || 51 != this.mnU.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.mmP = false;
                        return;
                    }
                    this.mnU.skipBytes(3);
                    this.sampleSize = this.mnU.dzB() + 10;
                }
            }
            int min2 = Math.min(dzr, this.sampleSize - this.mfJ);
            this.meJ.a(lVar, min2);
            this.mfJ = min2 + this.mfJ;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
        if (this.mmP && this.sampleSize != 0 && this.mfJ == this.sampleSize) {
            this.meJ.a(this.mmR, 1, this.sampleSize, 0, null);
            this.mmP = false;
        }
    }
}
