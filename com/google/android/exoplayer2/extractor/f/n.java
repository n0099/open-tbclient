package com.google.android.exoplayer2.extractor.f;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class n implements h {
    private int frameSize;
    private final String language;
    private long mdO;
    private boolean meG;
    private com.google.android.exoplayer2.extractor.m meW;
    private String mmT;
    private long mng;
    private final com.google.android.exoplayer2.util.l mot;
    private final com.google.android.exoplayer2.extractor.j mou;
    private int mov;
    private boolean mow;
    private int state;

    public n() {
        this(null);
    }

    public n(String str) {
        this.state = 0;
        this.mot = new com.google.android.exoplayer2.util.l(4);
        this.mot.data[0] = -1;
        this.mou = new com.google.android.exoplayer2.extractor.j();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.state = 0;
        this.mov = 0;
        this.mow = false;
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
    public void dvq() {
    }

    private void M(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        for (int i = position; i < dzv; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.mow && (bArr[i] & 224) == 224;
            this.mow = z;
            if (z2) {
                lVar.setPosition(i + 1);
                this.mow = false;
                this.mot.data[1] = bArr[i];
                this.mov = 2;
                this.state = 1;
                return;
            }
        }
        lVar.setPosition(dzv);
    }

    private void N(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzu(), 4 - this.mov);
        lVar.G(this.mot.data, this.mov, min);
        this.mov = min + this.mov;
        if (this.mov >= 4) {
            this.mot.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.j.a(this.mot.readInt(), this.mou)) {
                this.mov = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.mou.frameSize;
            if (!this.meG) {
                this.mng = (TimeUtils.NANOS_PER_MS * this.mou.samplesPerFrame) / this.mou.sampleRate;
                this.meW.h(Format.a(this.mmT, this.mou.mimeType, null, -1, 4096, this.mou.channels, this.mou.sampleRate, null, null, 0, this.language));
                this.meG = true;
            }
            this.mot.setPosition(0);
            this.meW.a(this.mot, 4);
            this.state = 2;
        }
    }

    private void O(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzu(), this.frameSize - this.mov);
        this.meW.a(lVar, min);
        this.mov = min + this.mov;
        if (this.mov >= this.frameSize) {
            this.meW.a(this.mdO, 1, this.frameSize, 0, null);
            this.mdO += this.mng;
            this.mov = 0;
            this.state = 0;
        }
    }
}
