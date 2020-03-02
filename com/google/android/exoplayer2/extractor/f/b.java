package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class b implements h {
    private Format lZy;
    private final String language;
    private long mdD;
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mmA;
    private long mmB;
    private final com.google.android.exoplayer2.util.k mmw;
    private final com.google.android.exoplayer2.util.l mmx;
    private String mmy;
    private int mmz;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mmw = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mmx = new com.google.android.exoplayer2.util.l(this.mmw.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.state = 0;
        this.mmz = 0;
        this.mmA = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmy = dVar.dvG();
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.mmx.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mmx.data[1] = 119;
                        this.mmz = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmx.data, 8)) {
                        break;
                    } else {
                        dvq();
                        this.mmx.setPosition(0);
                        this.meL.a(this.mmx, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzt(), this.sampleSize - this.mmz);
                    this.meL.a(lVar, min);
                    this.mmz = min + this.mmz;
                    if (this.mmz != this.sampleSize) {
                        break;
                    } else {
                        this.meL.a(this.mdD, 1, this.sampleSize, 0, null);
                        this.mdD += this.mmB;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzt(), i - this.mmz);
        lVar.G(bArr, this.mmz, min);
        this.mmz = min + this.mmz;
        return this.mmz == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzt() > 0) {
            if (!this.mmA) {
                this.mmA = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mmA = false;
                    return true;
                }
                this.mmA = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dvq() {
        this.mmw.setPosition(0);
        a.C0670a a = com.google.android.exoplayer2.audio.a.a(this.mmw);
        if (this.lZy == null || a.channelCount != this.lZy.channelCount || a.sampleRate != this.lZy.sampleRate || a.mimeType != this.lZy.sampleMimeType) {
            this.lZy = Format.a(this.mmy, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.meL.h(this.lZy);
        }
        this.sampleSize = a.frameSize;
        this.mmB = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lZy.sampleRate;
    }
}
