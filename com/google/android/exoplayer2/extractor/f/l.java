package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m mgC;
    private int mhC;
    private boolean moJ;
    private long moL;
    private final com.google.android.exoplayer2.util.l mpO = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.moJ = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.mgC = gVar.dL(dVar.dwd(), 4);
        this.mgC.h(Format.a(dVar.dwe(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        if (z) {
            this.moJ = true;
            this.moL = j;
            this.sampleSize = 0;
            this.mhC = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.moJ) {
            int dzR = lVar.dzR();
            if (this.mhC < 10) {
                int min = Math.min(dzR, 10 - this.mhC);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mpO.data, this.mhC, min);
                if (min + this.mhC == 10) {
                    this.mpO.setPosition(0);
                    if (73 != this.mpO.readUnsignedByte() || 68 != this.mpO.readUnsignedByte() || 51 != this.mpO.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.moJ = false;
                        return;
                    }
                    this.mpO.skipBytes(3);
                    this.sampleSize = this.mpO.dAb() + 10;
                }
            }
            int min2 = Math.min(dzR, this.sampleSize - this.mhC);
            this.mgC.a(lVar, min2);
            this.mhC = min2 + this.mhC;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
        if (this.moJ && this.sampleSize != 0 && this.mhC == this.sampleSize) {
            this.mgC.a(this.moL, 1, this.sampleSize, 0, null);
            this.moJ = false;
        }
    }
}
