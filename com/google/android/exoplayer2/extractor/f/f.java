package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class f implements h {
    private Format lZJ;
    private final String language;
    private long mdO;
    private com.google.android.exoplayer2.extractor.m meW;
    private final com.google.android.exoplayer2.util.l mmI = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mmK;
    private long mmM;
    private String mmT;
    private int mmZ;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mmI.data[0] = Byte.MAX_VALUE;
        this.mmI.data[1] = -2;
        this.mmI.data[2] = Byte.MIN_VALUE;
        this.mmI.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.state = 0;
        this.mmK = 0;
        this.mmZ = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmT = dVar.dvH();
        this.meW = gVar.dK(dVar.dvG(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdO = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzu() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mmK = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmI.data, 15)) {
                        break;
                    } else {
                        dvr();
                        this.mmI.setPosition(0);
                        this.meW.a(this.mmI, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzu(), this.sampleSize - this.mmK);
                    this.meW.a(lVar, min);
                    this.mmK = min + this.mmK;
                    if (this.mmK != this.sampleSize) {
                        break;
                    } else {
                        this.meW.a(this.mdO, 1, this.sampleSize, 0, null);
                        this.mdO += this.mmM;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzu(), i - this.mmK);
        lVar.G(bArr, this.mmK, min);
        this.mmK = min + this.mmK;
        return this.mmK == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzu() > 0) {
            this.mmZ <<= 8;
            this.mmZ |= lVar.readUnsignedByte();
            if (this.mmZ == 2147385345) {
                this.mmZ = 0;
                return true;
            }
        }
        return false;
    }

    private void dvr() {
        byte[] bArr = this.mmI.data;
        if (this.lZJ == null) {
            this.lZJ = com.google.android.exoplayer2.audio.f.a(bArr, this.mmT, this.language, null);
            this.meW.h(this.lZJ);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.as(bArr);
        this.mmM = (int) ((com.google.android.exoplayer2.audio.f.ar(bArr) * TimeUtils.NANOS_PER_MS) / this.lZJ.sampleRate);
    }
}
