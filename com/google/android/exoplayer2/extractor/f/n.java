package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mfu;
    private com.google.android.exoplayer2.extractor.m mgC;
    private boolean mgm;
    private String moA;
    private long moN;
    private final com.google.android.exoplayer2.util.l mpZ;
    private final com.google.android.exoplayer2.extractor.j mqa;
    private int mqb;
    private boolean mqc;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mpZ = new com.google.android.exoplayer2.util.l(4);
        this.mpZ.data[0] = -1;
        this.mqa = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.state = 0;
        this.mqb = 0;
        this.mqc = false;
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
    public void dvN() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzS = lVar.dzS();
        for (int i = position; i < dzS; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mqc && (bArr[i] & 224) == 224;
            this.mqc = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mqc = false;
                this.mpZ.data[1] = bArr[i];
                this.mqb = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dzS);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzR(), 4 - this.mqb);
        lVar.G(this.mpZ.data, this.mqb, min);
        this.mqb = min + this.mqb;
        if (this.mqb >= 4) {
            this.mpZ.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mpZ.readInt(), this.mqa)) {
                this.mqb = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mqa.frameSize;
            if (!this.mgm) {
                this.moN = (TimeUtils.NANOS_PER_MS * this.mqa.samplesPerFrame) / this.mqa.sampleRate;
                this.mgC.h(Format.a(this.moA, this.mqa.mimeType, null, -1, 4096, this.mqa.channels, this.mqa.sampleRate, null, null, 0, this.language));
                this.mgm = true;
            }
            this.mpZ.setPosition(0);
            this.mgC.a(this.mpZ, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzR(), this.frameSize - this.mqb);
        this.mgC.a(lVar, min);
        this.mqb = min + this.mqb;
        if (this.mqb >= this.frameSize) {
            this.mgC.a(this.mfu, 1, this.frameSize, 0, null);
            this.mfu += this.moN;
            this.mqb = 0;
            this.state = 0;
        }
    }
}
