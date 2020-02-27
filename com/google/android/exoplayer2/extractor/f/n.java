package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mdB;
    private com.google.android.exoplayer2.extractor.m meJ;
    private boolean met;
    private String mmG;
    private long mmT;
    private final com.google.android.exoplayer2.util.l mof;
    private final com.google.android.exoplayer2.extractor.j mog;
    private int moh;
    private boolean moi;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mof = new com.google.android.exoplayer2.util.l(4);
        this.mof.data[0] = -1;
        this.mog = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.state = 0;
        this.moh = 0;
        this.moi = false;
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
    public void dvn() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzs = lVar.dzs();
        for (int i = position; i < dzs; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.moi && (bArr[i] & 224) == 224;
            this.moi = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.moi = false;
                this.mof.data[1] = bArr[i];
                this.moh = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dzs);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzr(), 4 - this.moh);
        lVar.G(this.mof.data, this.moh, min);
        this.moh = min + this.moh;
        if (this.moh >= 4) {
            this.mof.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mof.readInt(), this.mog)) {
                this.moh = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mog.frameSize;
            if (!this.met) {
                this.mmT = (TimeUtils.NANOS_PER_MS * this.mog.samplesPerFrame) / this.mog.sampleRate;
                this.meJ.h(Format.a(this.mmG, this.mog.mimeType, null, -1, 4096, this.mog.channels, this.mog.sampleRate, null, null, 0, this.language));
                this.met = true;
            }
            this.mof.setPosition(0);
            this.meJ.a(this.mof, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzr(), this.frameSize - this.moh);
        this.meJ.a(lVar, min);
        this.moh = min + this.moh;
        if (this.moh >= this.frameSize) {
            this.meJ.a(this.mdB, 1, this.frameSize, 0, null);
            this.mdB += this.mmT;
            this.moh = 0;
            this.state = 0;
        }
    }
}
