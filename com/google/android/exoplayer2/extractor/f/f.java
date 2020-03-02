package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class f implements h {
    private Format lZy;
    private final String language;
    private long mdD;
    private com.google.android.exoplayer2.extractor.m meL;
    private long mmB;
    private String mmI;
    private int mmO;
    private final com.google.android.exoplayer2.util.l mmx = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mmz;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mmx.data[0] = Byte.MAX_VALUE;
        this.mmx.data[1] = -2;
        this.mmx.data[2] = Byte.MIN_VALUE;
        this.mmx.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.state = 0;
        this.mmz = 0;
        this.mmO = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmI = dVar.dvG();
        this.meL = gVar.dK(dVar.dvF(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdD = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzt() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mmz = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmx.data, 15)) {
                        break;
                    } else {
                        dvq();
                        this.mmx.setPosition(0);
                        this.meL.a(this.mmx, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzt(), this.sampleSize - this.mmz);
                    this.meL.a(lVar, min);
                    this.mmz = min + this.mmz;
                    if (this.mmz != this.sampleSize) {
                        break;
                    } else {
                        this.meL.a(this.mdD, 1, this.sampleSize, 0, null);
                        this.mdD += this.mmB;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzt(), i - this.mmz);
        lVar.G(bArr, this.mmz, min);
        this.mmz = min + this.mmz;
        return this.mmz == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzt() > 0) {
            this.mmO <<= 8;
            this.mmO |= lVar.readUnsignedByte();
            if (this.mmO == 2147385345) {
                this.mmO = 0;
                return true;
            }
        }
        return false;
    }

    private void dvq() {
        byte[] bArr = this.mmx.data;
        if (this.lZy == null) {
            this.lZy = com.google.android.exoplayer2.audio.f.a(bArr, this.mmI, this.language, null);
            this.meL.h(this.lZy);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.as(bArr);
        this.mmB = (int) ((com.google.android.exoplayer2.audio.f.ar(bArr) * TimeUtils.NANOS_PER_MS) / this.lZy.sampleRate);
    }
}
