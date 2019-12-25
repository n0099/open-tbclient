package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class n implements h {
    private int frameSize;
    private long lYY;
    private boolean lZQ;
    private final String language;
    private com.google.android.exoplayer2.extractor.m mah;
    private String mig;
    private long miu;
    private final com.google.android.exoplayer2.util.l mjG;
    private final com.google.android.exoplayer2.extractor.j mjH;
    private int mjI;
    private boolean mjJ;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mjG = new com.google.android.exoplayer2.util.l(4);
        this.mjG.data[0] = -1;
        this.mjH = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.state = 0;
        this.mjI = 0;
        this.mjJ = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mig = dVar.dtg();
        this.mah = gVar.dJ(dVar.dtf(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.lYY = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dwV() > 0) {
            switch (this.state) {
                case 0:
                    M(lVar);
                    break;
                case 1:
                    N(lVar);
                    break;
                case 2:
                    O(lVar);
                    break;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dwW = lVar.dwW();
        for (int i = position; i < dwW; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mjJ && (bArr[i] & 224) == 224;
            this.mjJ = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mjJ = false;
                this.mjG.data[1] = bArr[i];
                this.mjI = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dwW);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dwV(), 4 - this.mjI);
        lVar.D(this.mjG.data, this.mjI, min);
        this.mjI = min + this.mjI;
        if (this.mjI >= 4) {
            this.mjG.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mjG.readInt(), this.mjH)) {
                this.mjI = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mjH.frameSize;
            if (!this.lZQ) {
                this.miu = (TimeUtils.NANOS_PER_MS * this.mjH.samplesPerFrame) / this.mjH.sampleRate;
                this.mah.h(Format.a(this.mig, this.mjH.mimeType, null, -1, 4096, this.mjH.channels, this.mjH.sampleRate, null, null, 0, this.language));
                this.lZQ = true;
            }
            this.mjG.setPosition(0);
            this.mah.a(this.mjG, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dwV(), this.frameSize - this.mjI);
        this.mah.a(lVar, min);
        this.mjI = min + this.mjI;
        if (this.mjI >= this.frameSize) {
            this.mah.a(this.lYY, 1, this.frameSize, 0, null);
            this.lYY += this.miu;
            this.mjI = 0;
            this.state = 0;
        }
    }
}
