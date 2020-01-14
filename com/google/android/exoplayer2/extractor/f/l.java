package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class l implements h {
    private com.google.android.exoplayer2.extractor.m med;
    private int mfd;
    private boolean mmj;
    private long mml;
    private final com.google.android.exoplayer2.util.l mno = new com.google.android.exoplayer2.util.l(10);
    private int sampleSize;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.mmj = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.med = gVar.dH(dVar.dus(), 4);
        this.med.h(Format.a(dVar.dut(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.mmj = true;
            this.mml = j;
            this.sampleSize = 0;
            this.mfd = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        if (this.mmj) {
            int dyh = lVar.dyh();
            if (this.mfd < 10) {
                int min = Math.min(dyh, 10 - this.mfd);
                System.arraycopy(lVar.data, lVar.getPosition(), this.mno.data, this.mfd, min);
                if (min + this.mfd == 10) {
                    this.mno.setPosition(0);
                    if (73 != this.mno.readUnsignedByte() || 68 != this.mno.readUnsignedByte() || 51 != this.mno.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.mmj = false;
                        return;
                    }
                    this.mno.skipBytes(3);
                    this.sampleSize = this.mno.dyr() + 10;
                }
            }
            int min2 = Math.min(dyh, this.sampleSize - this.mfd);
            this.med.a(lVar, min2);
            this.mfd = min2 + this.mfd;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
        if (this.mmj && this.sampleSize != 0 && this.mfd == this.sampleSize) {
            this.med.a(this.mml, 1, this.sampleSize, 0, null);
            this.mmj = false;
        }
    }
}
