package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class b implements h {
    private Format lZJ;
    private final String language;
    private long mdO;
    private com.google.android.exoplayer2.extractor.m meW;
    private final com.google.android.exoplayer2.util.k mmH;
    private final com.google.android.exoplayer2.util.l mmI;
    private String mmJ;
    private int mmK;
    private boolean mmL;
    private long mmM;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mmH = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mmI = new com.google.android.exoplayer2.util.l(this.mmH.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.state = 0;
        this.mmK = 0;
        this.mmL = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmJ = dVar.dvH();
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.mmI.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mmI.data[1] = 119;
                        this.mmK = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mmI.data, 8)) {
                        break;
                    } else {
                        dvr();
                        this.mmI.setPosition(0);
                        this.meW.a(this.mmI, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dzu(), this.sampleSize - this.mmK);
                    this.meW.a(lVar, min);
                    this.mmK = min + this.mmK;
                    if (this.mmK != this.sampleSize) {
                        break;
                    } else {
                        this.meW.a(this.mdO, 1, this.sampleSize, 0, null);
                        this.mdO += this.mmM;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzu(), i - this.mmK);
        lVar.G(bArr, this.mmK, min);
        this.mmK = min + this.mmK;
        return this.mmK == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzu() > 0) {
            if (!this.mmL) {
                this.mmL = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mmL = false;
                    return true;
                }
                this.mmL = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dvr() {
        this.mmH.setPosition(0);
        a.C0670a a = com.google.android.exoplayer2.audio.a.a(this.mmH);
        if (this.lZJ == null || a.channelCount != this.lZJ.channelCount || a.sampleRate != this.lZJ.sampleRate || a.mimeType != this.lZJ.sampleMimeType) {
            this.lZJ = Format.a(this.mmJ, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.meW.h(this.lZJ);
        }
        this.sampleSize = a.frameSize;
        this.mmM = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lZJ.sampleRate;
    }
}
