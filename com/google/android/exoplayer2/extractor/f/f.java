package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class f implements h {
    private final String language;
    private Format mbs;
    private long mfu;
    private com.google.android.exoplayer2.extractor.m mgC;
    private String moA;
    private int moG;
    private final com.google.android.exoplayer2.util.l mop = new com.google.android.exoplayer2.util.l(new byte[15]);
    private int mor;
    private long mot;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.mop.data[0] = Byte.MAX_VALUE;
        this.mop.data[1] = -2;
        this.mop.data[2] = Byte.MIN_VALUE;
        this.mop.data[3] = 1;
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.state = 0;
        this.mor = 0;
        this.moG = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moA = dVar.dwe();
        this.mgC = gVar.dL(dVar.dwd(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        this.mfu = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzR() > 0) {
            switch (this.state) {
                case 0:
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.mor = 4;
                        this.state = 1;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mop.data, 15)) {
                        break;
                    } else {
                        dvO();
                        this.mop.setPosition(0);
                        this.mgC.a(this.mop, 15);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzR(), this.sampleSize - this.mor);
                    this.mgC.a(lVar, min);
                    this.mor = min + this.mor;
                    if (this.mor != this.sampleSize) {
                        break;
                    } else {
                        this.mgC.a(this.mfu, 1, this.sampleSize, 0, null);
                        this.mfu += this.mot;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzR(), i - this.mor);
        lVar.G(bArr, this.mor, min);
        this.mor = min + this.mor;
        return this.mor == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzR() > 0) {
            this.moG <<= 8;
            this.moG |= lVar.readUnsignedByte();
            if (this.moG == 2147385345) {
                this.moG = 0;
                return true;
            }
        }
        return false;
    }

    private void dvO() {
        byte[] bArr = this.mop.data;
        if (this.mbs == null) {
            this.mbs = com.google.android.exoplayer2.audio.f.a(bArr, this.moA, this.language, null);
            this.mgC.h(this.mbs);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.f.as(bArr);
        this.mot = (int) ((com.google.android.exoplayer2.audio.f.ar(bArr) * TimeUtils.NANOS_PER_MS) / this.mbs.sampleRate);
    }
}
