package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class f implements h {
    private Format lZw;
    private final String language;
    private long mdB;
    private com.google.android.exoplayer2.extractor.m meJ;
    private String mmG;
    private int mmM;
    private final com.google.android.exoplayer2.util.l mmv = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mmx;
    private long mmz;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mmv.data[0] = Byte.MAX_VALUE;
        this.mmv.data[1] = -2;
        this.mmv.data[2] = Byte.MIN_VALUE;
        this.mmv.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.state = 0;
        this.mmx = 0;
        this.mmM = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmG = dVar.dvE();
        this.meJ = gVar.dK(dVar.dvD(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdB = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzr() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mmx = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmv.data, 15)) {
                        break;
                    } else {
                        dvo();
                        this.mmv.setPosition(0);
                        this.meJ.a(this.mmv, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzr(), this.sampleSize - this.mmx);
                    this.meJ.a(lVar, min);
                    this.mmx = min + this.mmx;
                    if (this.mmx != this.sampleSize) {
                        break;
                    } else {
                        this.meJ.a(this.mdB, 1, this.sampleSize, 0, null);
                        this.mdB += this.mmz;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzr(), i - this.mmx);
        lVar.G(bArr, this.mmx, min);
        this.mmx = min + this.mmx;
        return this.mmx == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzr() > 0) {
            this.mmM <<= 8;
            this.mmM |= lVar.readUnsignedByte();
            if (this.mmM == 2147385345) {
                this.mmM = 0;
                return true;
            }
        }
        return false;
    }

    private void dvo() {
        byte[] bArr = this.mmv.data;
        if (this.lZw == null) {
            this.lZw = com.google.android.exoplayer2.audio.f.a(bArr, this.mmG, this.language, null);
            this.meJ.h(this.lZw);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.as(bArr);
        this.mmz = (int) ((com.google.android.exoplayer2.audio.f.ar(bArr) * TimeUtils.NANOS_PER_MS) / this.lZw.sampleRate);
    }
}
