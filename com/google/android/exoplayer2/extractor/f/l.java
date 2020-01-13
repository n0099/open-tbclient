package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m mdY;
    private int meY;
    private boolean mme;
    private long mmg;
    private final com.google.android.exoplayer2.util.l mnj = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.mme = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mdY = gVar.dH(dVar.duq(), 4);
        this.mdY.h(Format.a(dVar.dur(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.mme = true;
            this.mmg = j;
            this.sampleSize = 0;
            this.meY = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.mme) {
            int dyf = lVar.dyf();
            if (this.meY < 10) {
                int min = Math.min(dyf, 10 - this.meY);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mnj.data, this.meY, min);
                if (min + this.meY == 10) {
                    this.mnj.setPosition(0);
                    if (73 != this.mnj.readUnsignedByte() || 68 != this.mnj.readUnsignedByte() || 51 != this.mnj.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.mme = false;
                        return;
                    }
                    this.mnj.skipBytes(3);
                    this.sampleSize = this.mnj.dyp() + 10;
                }
            }
            int min2 = Math.min(dyf, this.sampleSize - this.meY);
            this.mdY.a(lVar, min2);
            this.meY = min2 + this.meY;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
        if (this.mme && this.sampleSize != 0 && this.meY == this.sampleSize) {
            this.mdY.a(this.mmg, 1, this.sampleSize, 0, null);
            this.mme = false;
        }
    }
}
