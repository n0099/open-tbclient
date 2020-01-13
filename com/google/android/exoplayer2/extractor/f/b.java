package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class b implements h {
    private Format lYL;
    private final String language;
    private long mcQ;
    private com.google.android.exoplayer2.extractor.m mdY;
    private final com.google.android.exoplayer2.util.k mlJ;
    private final com.google.android.exoplayer2.util.l mlK;
    private String mlL;
    private int mlM;
    private boolean mlN;
    private long mlO;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mlJ = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mlK = new com.google.android.exoplayer2.util.l(this.mlJ.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.state = 0;
        this.mlM = 0;
        this.mlN = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlL = dVar.dur();
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.mlK.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mlK.data[1] = 119;
                        this.mlM = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mlK.data, 8)) {
                        break;
                    } else {
                        dub();
                        this.mlK.setPosition(0);
                        this.mdY.a(this.mlK, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dyf(), this.sampleSize - this.mlM);
                    this.mdY.a(lVar, min);
                    this.mlM = min + this.mlM;
                    if (this.mlM != this.sampleSize) {
                        break;
                    } else {
                        this.mdY.a(this.mcQ, 1, this.sampleSize, 0, null);
                        this.mcQ += this.mlO;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyf(), i - this.mlM);
        lVar.C(bArr, this.mlM, min);
        this.mlM = min + this.mlM;
        return this.mlM == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyf() > 0) {
            if (!this.mlN) {
                this.mlN = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mlN = false;
                    return true;
                }
                this.mlN = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dub() {
        this.mlJ.setPosition(0);
        a.C0662a a = com.google.android.exoplayer2.audio.a.a(this.mlJ);
        if (this.lYL == null || a.channelCount != this.lYL.channelCount || a.sampleRate != this.lYL.sampleRate || a.mimeType != this.lYL.sampleMimeType) {
            this.lYL = Format.a(this.mlL, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.mdY.h(this.lYL);
        }
        this.sampleSize = a.frameSize;
        this.mlO = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lYL.sampleRate;
    }
}
