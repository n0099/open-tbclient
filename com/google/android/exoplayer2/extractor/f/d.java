package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class d implements h {
    private static final byte[] mmP = {73, 68, 51};
    private int WQ;
    private final String language;
    private long mdO;
    private boolean meG;
    private com.google.android.exoplayer2.extractor.m meW;
    private int mmK;
    private long mmM;
    private final boolean mmQ;
    private final com.google.android.exoplayer2.util.k mmR;
    private final com.google.android.exoplayer2.util.l mmS;
    private String mmT;
    private com.google.android.exoplayer2.extractor.m mmU;
    private boolean mmV;
    private com.google.android.exoplayer2.extractor.m mmW;
    private long mmX;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mmR = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mmS = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mmP, 10));
        dvs();
        this.mmQ = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        dvs();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmT = dVar.dvH();
        this.meW = gVar.dK(dVar.dvG(), 1);
        if (this.mmQ) {
            dVar.dvF();
            this.mmU = gVar.dK(dVar.dvG(), 4);
            this.mmU.h(Format.a(dVar.dvH(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mmU = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdO = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dzu() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mmS.data, 10)) {
                        break;
                    } else {
                        dvv();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mmR.data, this.mmV ? 7 : 5)) {
                        break;
                    } else {
                        dvw();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
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

    private void dvs() {
        this.state = 0;
        this.mmK = 0;
        this.WQ = 256;
    }

    private void dvt() {
        this.state = 1;
        this.mmK = mmP.length;
        this.sampleSize = 0;
        this.mmS.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mmK = i;
        this.mmW = mVar;
        this.mmX = j;
        this.sampleSize = i2;
    }

    private void dvu() {
        this.state = 2;
        this.mmK = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        while (position < dzv) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.WQ == 512 && i2 >= 240 && i2 != 255) {
                this.mmV = (i2 & 1) == 0;
                dvu();
                lVar.setPosition(i);
                return;
            }
            switch (i2 | this.WQ) {
                case 329:
                    this.WQ = 768;
                    position = i;
                    break;
                case 511:
                    this.WQ = 512;
                    position = i;
                    break;
                case 836:
                    this.WQ = 1024;
                    position = i;
                    break;
                case 1075:
                    dvt();
                    lVar.setPosition(i);
                    return;
                default:
                    if (this.WQ == 256) {
                        position = i;
                        break;
                    } else {
                        this.WQ = 256;
                        position = i - 1;
                        break;
                    }
            }
        }
        lVar.setPosition(position);
    }

    private void dvv() {
        this.mmU.a(this.mmS, 10);
        this.mmS.setPosition(6);
        a(this.mmU, 0L, 10, this.mmS.dzE() + 10);
    }

    private void dvw() throws ParserException {
        int i = 2;
        this.mmR.setPosition(0);
        if (!this.meG) {
            int readBits = this.mmR.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mmR.readBits(4);
            this.mmR.JU(1);
            byte[] ak = com.google.android.exoplayer2.util.c.ak(i, readBits2, this.mmR.readBits(3));
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(ak);
            Format a = Format.a(this.mmT, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(ak), null, 0, this.language);
            this.mmM = 1024000000 / a.sampleRate;
            this.meW.h(a);
            this.meG = true;
        } else {
            this.mmR.JU(10);
        }
        this.mmR.JU(4);
        int readBits3 = (this.mmR.readBits(13) - 2) - 5;
        if (this.mmV) {
            readBits3 -= 2;
        }
        a(this.meW, this.mmM, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzu(), this.sampleSize - this.mmK);
        this.mmW.a(lVar, min);
        this.mmK = min + this.mmK;
        if (this.mmK == this.sampleSize) {
            this.mmW.a(this.mdO, 1, this.sampleSize, 0, null);
            this.mdO += this.mmX;
            dvs();
        }
    }
}
