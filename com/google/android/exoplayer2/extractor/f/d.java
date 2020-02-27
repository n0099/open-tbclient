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
    private static final byte[] mmC = {73, 68, 51};
    private int WQ;
    private final String language;
    private long mdB;
    private com.google.android.exoplayer2.extractor.m meJ;
    private boolean met;
    private final boolean mmD;
    private final com.google.android.exoplayer2.util.k mmE;
    private final com.google.android.exoplayer2.util.l mmF;
    private String mmG;
    private com.google.android.exoplayer2.extractor.m mmH;
    private boolean mmI;
    private com.google.android.exoplayer2.extractor.m mmJ;
    private long mmK;
    private int mmx;
    private long mmz;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mmE = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mmF = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mmC, 10));
        dvp();
        this.mmD = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        dvp();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmG = dVar.dvE();
        this.meJ = gVar.dK(dVar.dvD(), 1);
        if (this.mmD) {
            dVar.dvC();
            this.mmH = gVar.dK(dVar.dvD(), 4);
            this.mmH.h(Format.a(dVar.dvE(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mmH = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdB = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dzr() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mmF.data, 10)) {
                        break;
                    } else {
                        dvs();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mmE.data, this.mmI ? 7 : 5)) {
                        break;
                    } else {
                        dvt();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
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

    private void dvp() {
        this.state = 0;
        this.mmx = 0;
        this.WQ = 256;
    }

    private void dvq() {
        this.state = 1;
        this.mmx = mmC.length;
        this.sampleSize = 0;
        this.mmF.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mmx = i;
        this.mmJ = mVar;
        this.mmK = j;
        this.sampleSize = i2;
    }

    private void dvr() {
        this.state = 2;
        this.mmx = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzs = lVar.dzs();
        while (position < dzs) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.WQ == 512 && i2 >= 240 && i2 != 255) {
                this.mmI = (i2 & 1) == 0;
                dvr();
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
                    dvq();
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

    private void dvs() {
        this.mmH.a(this.mmF, 10);
        this.mmF.setPosition(6);
        a(this.mmH, 0L, 10, this.mmF.dzB() + 10);
    }

    private void dvt() throws ParserException {
        int i = 2;
        this.mmE.setPosition(0);
        if (!this.met) {
            int readBits = this.mmE.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mmE.readBits(4);
            this.mmE.JU(1);
            byte[] ak = com.google.android.exoplayer2.util.c.ak(i, readBits2, this.mmE.readBits(3));
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(ak);
            Format a = Format.a(this.mmG, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(ak), null, 0, this.language);
            this.mmz = 1024000000 / a.sampleRate;
            this.meJ.h(a);
            this.met = true;
        } else {
            this.mmE.JU(10);
        }
        this.mmE.JU(4);
        int readBits3 = (this.mmE.readBits(13) - 2) - 5;
        if (this.mmI) {
            readBits3 -= 2;
        }
        a(this.meJ, this.mmz, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzr(), this.sampleSize - this.mmx);
        this.mmJ.a(lVar, min);
        this.mmx = min + this.mmx;
        if (this.mmx == this.sampleSize) {
            this.mmJ.a(this.mdB, 1, this.sampleSize, 0, null);
            this.mdB += this.mmK;
            dvp();
        }
    }
}
