package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mcQ;
    private boolean mdI;
    private com.google.android.exoplayer2.extractor.m mdY;
    private String mlV;
    private long mmi;
    private final com.google.android.exoplayer2.util.l mnu;
    private final com.google.android.exoplayer2.extractor.j mnv;
    private int mnw;
    private boolean mnx;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mnu = new com.google.android.exoplayer2.util.l(4);
        this.mnu.data[0] = -1;
        this.mnv = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.state = 0;
        this.mnw = 0;
        this.mnx = false;
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
    public void dua() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dyg = lVar.dyg();
        for (int i = position; i < dyg; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mnx && (bArr[i] & 224) == 224;
            this.mnx = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mnx = false;
                this.mnu.data[1] = bArr[i];
                this.mnw = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dyg);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyf(), 4 - this.mnw);
        lVar.C(this.mnu.data, this.mnw, min);
        this.mnw = min + this.mnw;
        if (this.mnw >= 4) {
            this.mnu.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mnu.readInt(), this.mnv)) {
                this.mnw = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mnv.frameSize;
            if (!this.mdI) {
                this.mmi = (TimeUtils.NANOS_PER_MS * this.mnv.samplesPerFrame) / this.mnv.sampleRate;
                this.mdY.h(Format.a(this.mlV, this.mnv.mimeType, null, -1, 4096, this.mnv.channels, this.mnv.sampleRate, null, null, 0, this.language));
                this.mdI = true;
            }
            this.mnu.setPosition(0);
            this.mdY.a(this.mnu, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyf(), this.frameSize - this.mnw);
        this.mdY.a(lVar, min);
        this.mnw = min + this.mnw;
        if (this.mnw >= this.frameSize) {
            this.mdY.a(this.mcQ, 1, this.frameSize, 0, null);
            this.mcQ += this.mmi;
            this.mnw = 0;
            this.state = 0;
        }
    }
}
