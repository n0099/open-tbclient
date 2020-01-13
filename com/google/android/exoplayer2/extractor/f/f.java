package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class f implements h {
    private Format lYL;
    private final String language;
    private long mcQ;
    private com.google.android.exoplayer2.extractor.m mdY;
    private final com.google.android.exoplayer2.util.l mlK = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mlM;
    private long mlO;
    private String mlV;
    private int mmb;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mlK.data[0] = Byte.MAX_VALUE;
        this.mlK.data[1] = -2;
        this.mlK.data[2] = Byte.MIN_VALUE;
        this.mlK.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.state = 0;
        this.mlM = 0;
        this.mmb = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlV = dVar.dur();
        this.mdY = gVar.dH(dVar.duq(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcQ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyf() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mlM = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mlK.data, 15)) {
                        break;
                    } else {
                        dub();
                        this.mlK.setPosition(0);
                        this.mdY.a(this.mlK, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dyf(), this.sampleSize - this.mlM);
                    this.mdY.a(lVar, min);
                    this.mlM = min + this.mlM;
                    if (this.mlM != this.sampleSize) {
                        break;
                    } else {
                        this.mdY.a(this.mcQ, 1, this.sampleSize, 0, null);
                        this.mcQ += this.mlO;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyf(), i - this.mlM);
        lVar.C(bArr, this.mlM, min);
        this.mlM = min + this.mlM;
        return this.mlM == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyf() > 0) {
            this.mmb <<= 8;
            this.mmb |= lVar.readUnsignedByte();
            if (this.mmb == 2147385345) {
                this.mmb = 0;
                return true;
            }
        }
        return false;
    }

    private void dub() {
        byte[] bArr = this.mlK.data;
        if (this.lYL == null) {
            this.lYL = com.google.android.exoplayer2.audio.f.a(bArr, this.mlV, this.language, null);
            this.mdY.h(this.lYL);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.an(bArr);
        this.mlO = (int) ((com.google.android.exoplayer2.audio.f.am(bArr) * TimeUtils.NANOS_PER_MS) / this.lYL.sampleRate);
    }
}
