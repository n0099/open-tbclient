package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m meW;
    private int mfW;
    private boolean mnc;
    private long mne;
    private final com.google.android.exoplayer2.util.l moh = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.mnc = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.meW = gVar.dK(dVar.dvG(), 4);
        this.meW.h(Format.a(dVar.dvH(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mnc = true;
            this.mne = j;
            this.sampleSize = 0;
            this.mfW = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.mnc) {
            int dzu = lVar.dzu();
            if (this.mfW < 10) {
                int min = Math.min(dzu, 10 - this.mfW);
                System.arraycopy(lVar.data, lVar.getPosition(), this.moh.data, this.mfW, min);
                if (min + this.mfW == 10) {
                    this.moh.setPosition(0);
                    if (73 != this.moh.readUnsignedByte() || 68 != this.moh.readUnsignedByte() || 51 != this.moh.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.mnc = false;
                        return;
                    }
                    this.moh.skipBytes(3);
                    this.sampleSize = this.moh.dzE() + 10;
                }
            }
            int min2 = Math.min(dzu, this.sampleSize - this.mfW);
            this.meW.a(lVar, min2);
            this.mfW = min2 + this.mfW;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
        if (this.mnc && this.sampleSize != 0 && this.mfW == this.sampleSize) {
            this.meW.a(this.mne, 1, this.sampleSize, 0, null);
            this.mnc = false;
        }
    }
}
