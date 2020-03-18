package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class b implements h {
    private final String language;
    private Format mbs;
    private long mfu;
    private com.google.android.exoplayer2.extractor.m mgC;
    private final com.google.android.exoplayer2.util.k moo;
    private final com.google.android.exoplayer2.util.l mop;
    private String moq;
    private int mor;
    private boolean mos;
    private long mot;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.moo = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mop = new com.google.android.exoplayer2.util.l(this.moo.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.state = 0;
        this.mor = 0;
        this.mos = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moq = dVar.dwe();
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
                        this.state = 1;
                        this.mop.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mop.data[1] = 119;
                        this.mor = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mop.data, 8)) {
                        break;
                    } else {
                        dvO();
                        this.mop.setPosition(0);
                        this.mgC.a(this.mop, 8);
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
            if (!this.mos) {
                this.mos = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mos = false;
                    return true;
                }
                this.mos = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dvO() {
        this.moo.setPosition(0);
        a.C0671a a = com.google.android.exoplayer2.audio.a.a(this.moo);
        if (this.mbs == null || a.channelCount != this.mbs.channelCount || a.sampleRate != this.mbs.sampleRate || a.mimeType != this.mbs.sampleMimeType) {
            this.mbs = Format.a(this.moq, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.mgC.h(this.mbs);
        }
        this.sampleSize = a.frameSize;
        this.mot = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.mbs.sampleRate;
    }
}
