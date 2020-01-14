package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class f implements h {
    private Format lYQ;
    private final String language;
    private long mcV;
    private com.google.android.exoplayer2.extractor.m med;
    private final com.google.android.exoplayer2.util.l mlP = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mlR;
    private long mlT;
    private String mma;
    private int mmg;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mlP.data[0] = Byte.MAX_VALUE;
        this.mlP.data[1] = -2;
        this.mlP.data[2] = Byte.MIN_VALUE;
        this.mlP.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.state = 0;
        this.mlR = 0;
        this.mmg = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mma = dVar.dut();
        this.med = gVar.dH(dVar.dus(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcV = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyh() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mlR = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mlP.data, 15)) {
                        break;
                    } else {
                        dud();
                        this.mlP.setPosition(0);
                        this.med.a(this.mlP, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dyh(), this.sampleSize - this.mlR);
                    this.med.a(lVar, min);
                    this.mlR = min + this.mlR;
                    if (this.mlR != this.sampleSize) {
                        break;
                    } else {
                        this.med.a(this.mcV, 1, this.sampleSize, 0, null);
                        this.mcV += this.mlT;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyh(), i - this.mlR);
        lVar.C(bArr, this.mlR, min);
        this.mlR = min + this.mlR;
        return this.mlR == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyh() > 0) {
            this.mmg <<= 8;
            this.mmg |= lVar.readUnsignedByte();
            if (this.mmg == 2147385345) {
                this.mmg = 0;
                return true;
            }
        }
        return false;
    }

    private void dud() {
        byte[] bArr = this.mlP.data;
        if (this.lYQ == null) {
            this.lYQ = com.google.android.exoplayer2.audio.f.a(bArr, this.mma, this.language, null);
            this.med.h(this.lYQ);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.an(bArr);
        this.mlT = (int) ((com.google.android.exoplayer2.audio.f.am(bArr) * TimeUtils.NANOS_PER_MS) / this.lYQ.sampleRate);
    }
}
