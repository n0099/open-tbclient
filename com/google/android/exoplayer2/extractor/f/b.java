package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class b implements h {
    private Format lZw;
    private final String language;
    private long mdB;
    private com.google.android.exoplayer2.extractor.m meJ;
    private final com.google.android.exoplayer2.util.k mmu;
    private final com.google.android.exoplayer2.util.l mmv;
    private String mmw;
    private int mmx;
    private boolean mmy;
    private long mmz;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mmu = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mmv = new com.google.android.exoplayer2.util.l(this.mmu.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.state = 0;
        this.mmx = 0;
        this.mmy = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmw = dVar.dvE();
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.mmv.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mmv.data[1] = 119;
                        this.mmx = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmv.data, 8)) {
                        break;
                    } else {
                        dvo();
                        this.mmv.setPosition(0);
                        this.meJ.a(this.mmv, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzr(), this.sampleSize - this.mmx);
                    this.meJ.a(lVar, min);
                    this.mmx = min + this.mmx;
                    if (this.mmx != this.sampleSize) {
                        break;
                    } else {
                        this.meJ.a(this.mdB, 1, this.sampleSize, 0, null);
                        this.mdB += this.mmz;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzr(), i - this.mmx);
        lVar.G(bArr, this.mmx, min);
        this.mmx = min + this.mmx;
        return this.mmx == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzr() > 0) {
            if (!this.mmy) {
                this.mmy = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mmy = false;
                    return true;
                }
                this.mmy = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dvo() {
        this.mmu.setPosition(0);
        a.C0670a a = com.google.android.exoplayer2.audio.a.a(this.mmu);
        if (this.lZw == null || a.channelCount != this.lZw.channelCount || a.sampleRate != this.lZw.sampleRate || a.mimeType != this.lZw.sampleMimeType) {
            this.lZw = Format.a(this.mmw, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.meJ.h(this.lZw);
        }
        this.sampleSize = a.frameSize;
        this.mmz = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lZw.sampleRate;
    }
}
