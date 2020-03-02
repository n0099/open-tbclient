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
    private static final byte[] mmE = {73, 68, 51};
    private int WQ;
    private final String language;
    private long mdD;
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mev;
    private long mmB;
    private final boolean mmF;
    private final com.google.android.exoplayer2.util.k mmG;
    private final com.google.android.exoplayer2.util.l mmH;
    private String mmI;
    private com.google.android.exoplayer2.extractor.m mmJ;
    private boolean mmK;
    private com.google.android.exoplayer2.extractor.m mmL;
    private long mmM;
    private int mmz;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mmG = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mmH = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mmE, 10));
        dvr();
        this.mmF = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        dvr();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmI = dVar.dvG();
        this.meL = gVar.dK(dVar.dvF(), 1);
        if (this.mmF) {
            dVar.dvE();
            this.mmJ = gVar.dK(dVar.dvF(), 4);
            this.mmJ.h(Format.a(dVar.dvG(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mmJ = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mdD = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dzt() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mmH.data, 10)) {
                        break;
                    } else {
                        dvu();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mmG.data, this.mmK ? 7 : 5)) {
                        break;
                    } else {
                        dvv();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
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

    private void dvr() {
        this.state = 0;
        this.mmz = 0;
        this.WQ = 256;
    }

    private void dvs() {
        this.state = 1;
        this.mmz = mmE.length;
        this.sampleSize = 0;
        this.mmH.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mmz = i;
        this.mmL = mVar;
        this.mmM = j;
        this.sampleSize = i2;
    }

    private void dvt() {
        this.state = 2;
        this.mmz = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzu = lVar.dzu();
        while (position < dzu) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.WQ == 512 && i2 >= 240 && i2 != 255) {
                this.mmK = (i2 & 1) == 0;
                dvt();
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
                    dvs();
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

    private void dvu() {
        this.mmJ.a(this.mmH, 10);
        this.mmH.setPosition(6);
        a(this.mmJ, 0L, 10, this.mmH.dzD() + 10);
    }

    private void dvv() throws ParserException {
        int i = 2;
        this.mmG.setPosition(0);
        if (!this.mev) {
            int readBits = this.mmG.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mmG.readBits(4);
            this.mmG.JU(1);
            byte[] ak = com.google.android.exoplayer2.util.c.ak(i, readBits2, this.mmG.readBits(3));
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(ak);
            Format a = Format.a(this.mmI, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(ak), null, 0, this.language);
            this.mmB = 1024000000 / a.sampleRate;
            this.meL.h(a);
            this.mev = true;
        } else {
            this.mmG.JU(10);
        }
        this.mmG.JU(4);
        int readBits3 = (this.mmG.readBits(13) - 2) - 5;
        if (this.mmK) {
            readBits3 -= 2;
        }
        a(this.meL, this.mmB, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzt(), this.sampleSize - this.mmz);
        this.mmL.a(lVar, min);
        this.mmz = min + this.mmz;
        if (this.mmz == this.sampleSize) {
            this.mmL.a(this.mdD, 1, this.sampleSize, 0, null);
            this.mdD += this.mmM;
            dvr();
        }
    }
}
