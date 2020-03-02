package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m meL;
    private int mfL;
    private boolean mmR;
    private long mmT;
    private final com.google.android.exoplayer2.util.l mnW = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.mmR = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.meL = gVar.dK(dVar.dvF(), 4);
        this.meL.h(Format.a(dVar.dvG(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mmR = true;
            this.mmT = j;
            this.sampleSize = 0;
            this.mfL = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.mmR) {
            int dzt = lVar.dzt();
            if (this.mfL < 10) {
                int min = Math.min(dzt, 10 - this.mfL);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mnW.data, this.mfL, min);
                if (min + this.mfL == 10) {
                    this.mnW.setPosition(0);
                    if (73 != this.mnW.readUnsignedByte() || 68 != this.mnW.readUnsignedByte() || 51 != this.mnW.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.mmR = false;
                        return;
                    }
                    this.mnW.skipBytes(3);
                    this.sampleSize = this.mnW.dzD() + 10;
                }
            }
            int min2 = Math.min(dzt, this.sampleSize - this.mfL);
            this.meL.a(lVar, min2);
            this.mfL = min2 + this.mfL;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
        if (this.mmR && this.sampleSize != 0 && this.mfL == this.sampleSize) {
            this.meL.a(this.mmT, 1, this.sampleSize, 0, null);
            this.mmR = false;
        }
    }
}
