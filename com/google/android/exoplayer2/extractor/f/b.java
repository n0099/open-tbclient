package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class b implements h {
    private Format lUU;
    private long lYY;
    private final String language;
    private com.google.android.exoplayer2.extractor.m mah;
    private final com.google.android.exoplayer2.util.k mhT;
    private final com.google.android.exoplayer2.util.l mhU;
    private String mhV;
    private int mhW;
    private boolean mhX;
    private long mhY;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mhT = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mhU = new com.google.android.exoplayer2.util.l(this.mhT.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.state = 0;
        this.mhW = 0;
        this.mhX = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mhV = dVar.dtg();
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
                        this.state = 1;
                        this.mhU.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mhU.data[1] = 119;
                        this.mhW = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mhU.data, 8)) {
                        break;
                    } else {
                        dsP();
                        this.mhU.setPosition(0);
                        this.mah.a(this.mhU, 8);
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
            if (!this.mhX) {
                this.mhX = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mhX = false;
                    return true;
                }
                this.mhX = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dsP() {
        this.mhT.setPosition(0);
        a.C0656a a = com.google.android.exoplayer2.audio.a.a(this.mhT);
        if (this.lUU == null || a.channelCount != this.lUU.channelCount || a.sampleRate != this.lUU.sampleRate || a.mimeType != this.lUU.sampleMimeType) {
            this.lUU = Format.a(this.mhV, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.mah.h(this.lUU);
        }
        this.sampleSize = a.frameSize;
        this.mhY = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lUU.sampleRate;
    }
}
