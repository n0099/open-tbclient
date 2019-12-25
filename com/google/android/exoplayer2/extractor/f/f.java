package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class f implements h {
    private Format lUU;
    private long lYY;
    private final String language;
    private com.google.android.exoplayer2.extractor.m mah;
    private final com.google.android.exoplayer2.util.l mhU = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mhW;
    private long mhY;
    private String mig;
    private int mim;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mhU.data[0] = Byte.MAX_VALUE;
        this.mhU.data[1] = -2;
        this.mhU.data[2] = Byte.MIN_VALUE;
        this.mhU.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.state = 0;
        this.mhW = 0;
        this.mim = 0;
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mhW = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mhU.data, 15)) {
                        break;
                    } else {
                        dsP();
                        this.mhU.setPosition(0);
                        this.mah.a(this.mhU, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dwV(), this.sampleSize - this.mhW);
                    this.mah.a(lVar, min);
                    this.mhW = min + this.mhW;
                    if (this.mhW != this.sampleSize) {
                        break;
                    } else {
                        this.mah.a(this.lYY, 1, this.sampleSize, 0, null);
                        this.lYY += this.mhY;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dwV(), i - this.mhW);
        lVar.D(bArr, this.mhW, min);
        this.mhW = min + this.mhW;
        return this.mhW == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dwV() > 0) {
            this.mim <<= 8;
            this.mim |= lVar.readUnsignedByte();
            if (this.mim == 2147385345) {
                this.mim = 0;
                return true;
            }
        }
        return false;
    }

    private void dsP() {
        byte[] bArr = this.mhU.data;
        if (this.lUU == null) {
            this.lUU = com.google.android.exoplayer2.audio.f.a(bArr, this.mig, this.language, null);
            this.mah.h(this.lUU);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.ao(bArr);
        this.mhY = (int) ((com.google.android.exoplayer2.audio.f.an(bArr) * TimeUtils.NANOS_PER_MS) / this.lUU.sampleRate);
    }
}
