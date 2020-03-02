package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mdD;
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mev;
    private String mmI;
    private long mmV;
    private final com.google.android.exoplayer2.util.l moh;
    private final com.google.android.exoplayer2.extractor.j moi;
    private int moj;
    private boolean mok;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.moh = new com.google.android.exoplayer2.util.l(4);
        this.moh.data[0] = -1;
        this.moi = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.state = 0;
        this.moj = 0;
        this.mok = false;
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
    public void dvp() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzu = lVar.dzu();
        for (int i = position; i < dzu; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mok && (bArr[i] & 224) == 224;
            this.mok = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mok = false;
                this.moh.data[1] = bArr[i];
                this.moj = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dzu);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzt(), 4 - this.moj);
        lVar.G(this.moh.data, this.moj, min);
        this.moj = min + this.moj;
        if (this.moj >= 4) {
            this.moh.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.moh.readInt(), this.moi)) {
                this.moj = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.moi.frameSize;
            if (!this.mev) {
                this.mmV = (TimeUtils.NANOS_PER_MS * this.moi.samplesPerFrame) / this.moi.sampleRate;
                this.meL.h(Format.a(this.mmI, this.moi.mimeType, null, -1, 4096, this.moi.channels, this.moi.sampleRate, null, null, 0, this.language));
                this.mev = true;
            }
            this.moh.setPosition(0);
            this.meL.a(this.moh, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzt(), this.frameSize - this.moj);
        this.meL.a(lVar, min);
        this.moj = min + this.moj;
        if (this.moj >= this.frameSize) {
            this.meL.a(this.mdD, 1, this.frameSize, 0, null);
            this.mdD += this.mmV;
            this.moj = 0;
            this.state = 0;
        }
    }
}
