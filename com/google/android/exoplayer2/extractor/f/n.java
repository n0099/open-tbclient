package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mcV;
    private boolean mdN;
    private com.google.android.exoplayer2.extractor.m med;
    private String mma;
    private long mmn;
    private final com.google.android.exoplayer2.extractor.j mnA;
    private int mnB;
    private boolean mnC;
    private final com.google.android.exoplayer2.util.l mnz;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mnz = new com.google.android.exoplayer2.util.l(4);
        this.mnz.data[0] = -1;
        this.mnA = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.state = 0;
        this.mnB = 0;
        this.mnC = false;
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
    public void duc() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dyi = lVar.dyi();
        for (int i = position; i < dyi; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mnC && (bArr[i] & 224) == 224;
            this.mnC = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mnC = false;
                this.mnz.data[1] = bArr[i];
                this.mnB = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dyi);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyh(), 4 - this.mnB);
        lVar.C(this.mnz.data, this.mnB, min);
        this.mnB = min + this.mnB;
        if (this.mnB >= 4) {
            this.mnz.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mnz.readInt(), this.mnA)) {
                this.mnB = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mnA.frameSize;
            if (!this.mdN) {
                this.mmn = (TimeUtils.NANOS_PER_MS * this.mnA.samplesPerFrame) / this.mnA.sampleRate;
                this.med.h(Format.a(this.mma, this.mnA.mimeType, null, -1, 4096, this.mnA.channels, this.mnA.sampleRate, null, null, 0, this.language));
                this.mdN = true;
            }
            this.mnz.setPosition(0);
            this.med.a(this.mnz, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyh(), this.frameSize - this.mnB);
        this.med.a(lVar, min);
        this.mnB = min + this.mnB;
        if (this.mnB >= this.frameSize) {
            this.med.a(this.mcV, 1, this.frameSize, 0, null);
            this.mcV += this.mmn;
            this.mnB = 0;
            this.state = 0;
        }
    }
}
