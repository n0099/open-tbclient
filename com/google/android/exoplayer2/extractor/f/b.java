package com.google.android.exoplayer2.extractor.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class b implements h {
    private Format lYQ;
    private final String language;
    private long mcV;
    private com.google.android.exoplayer2.extractor.m med;
    private final com.google.android.exoplayer2.util.k mlO;
    private final com.google.android.exoplayer2.util.l mlP;
    private String mlQ;
    private int mlR;
    private boolean mlS;
    private long mlT;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.mlO = new com.google.android.exoplayer2.util.k(new byte[8]);
        this.mlP = new com.google.android.exoplayer2.util.l(this.mlO.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.state = 0;
        this.mlR = 0;
        this.mlS = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mlQ = dVar.dut();
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
                    if (!J(lVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.mlP.data[0] = Constants.GZIP_CAST_TYPE;
                        this.mlP.data[1] = 119;
                        this.mlR = 2;
                        break;
                    }
                case 1:
                    if (!a(lVar, this.mlP.data, 8)) {
                        break;
                    } else {
                        dud();
                        this.mlP.setPosition(0);
                        this.med.a(this.mlP, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(lVar.dyh(), this.sampleSize - this.mlR);
                    this.med.a(lVar, min);
                    this.mlR = min + this.mlR;
                    if (this.mlR != this.sampleSize) {
                        break;
                    } else {
                        this.med.a(this.mcV, 1, this.sampleSize, 0, null);
                        this.mcV += this.mlT;
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyh(), i - this.mlR);
        lVar.C(bArr, this.mlR, min);
        this.mlR = min + this.mlR;
        return this.mlR == i;
    }

    private boolean J(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyh() > 0) {
            if (!this.mlS) {
                this.mlS = lVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.mlS = false;
                    return true;
                }
                this.mlS = readUnsignedByte == 11;
            }
        }
        return false;
    }

    private void dud() {
        this.mlO.setPosition(0);
        a.C0662a a = com.google.android.exoplayer2.audio.a.a(this.mlO);
        if (this.lYQ == null || a.channelCount != this.lYQ.channelCount || a.sampleRate != this.lYQ.sampleRate || a.mimeType != this.lYQ.sampleMimeType) {
            this.lYQ = Format.a(this.mlQ, a.mimeType, null, -1, -1, a.channelCount, a.sampleRate, null, null, 0, this.language);
            this.med.h(this.lYQ);
        }
        this.sampleSize = a.frameSize;
        this.mlT = (TimeUtils.NANOS_PER_MS * a.sampleCount) / this.lYQ.sampleRate;
    }
}
