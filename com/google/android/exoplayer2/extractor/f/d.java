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
    private static final byte[] mow = {73, 68, 51};
    private int Xa;
    private final String language;
    private long mfu;
    private com.google.android.exoplayer2.extractor.m mgC;
    private boolean mgm;
    private String moA;
    private com.google.android.exoplayer2.extractor.m moB;
    private boolean moC;
    private com.google.android.exoplayer2.extractor.m moD;
    private long moE;
    private int mor;
    private long mot;
    private final boolean mox;
    private final com.google.android.exoplayer2.util.k moy;
    private final com.google.android.exoplayer2.util.l moz;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.moy = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.moz = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mow, 10));
        dvP();
        this.mox = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        dvP();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moA = dVar.dwe();
        this.mgC = gVar.dL(dVar.dwd(), 1);
        if (this.mox) {
            dVar.dwc();
            this.moB = gVar.dL(dVar.dwd(), 4);
            this.moB.h(Format.a(dVar.dwe(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.moB = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        this.mfu = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dzR() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.moz.data, 10)) {
                        break;
                    } else {
                        dvS();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.moy.data, this.moC ? 7 : 5)) {
                        break;
                    } else {
                        dvT();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
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

    private void dvP() {
        this.state = 0;
        this.mor = 0;
        this.Xa = 256;
    }

    private void dvQ() {
        this.state = 1;
        this.mor = mow.length;
        this.sampleSize = 0;
        this.moz.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mor = i;
        this.moD = mVar;
        this.moE = j;
        this.sampleSize = i2;
    }

    private void dvR() {
        this.state = 2;
        this.mor = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dzS = lVar.dzS();
        while (position < dzS) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.Xa == 512 && i2 >= 240 && i2 != 255) {
                this.moC = (i2 & 1) == 0;
                dvR();
                lVar.setPosition(i);
                return;
            }
            switch (i2 | this.Xa) {
                case 329:
                    this.Xa = 768;
                    position = i;
                    break;
                case 511:
                    this.Xa = 512;
                    position = i;
                    break;
                case 836:
                    this.Xa = 1024;
                    position = i;
                    break;
                case 1075:
                    dvQ();
                    lVar.setPosition(i);
                    return;
                default:
                    if (this.Xa == 256) {
                        position = i;
                        break;
                    } else {
                        this.Xa = 256;
                        position = i - 1;
                        break;
                    }
            }
        }
        lVar.setPosition(position);
    }

    private void dvS() {
        this.moB.a(this.moz, 10);
        this.moz.setPosition(6);
        a(this.moB, 0L, 10, this.moz.dAb() + 10);
    }

    private void dvT() throws ParserException {
        int i = 2;
        this.moy.setPosition(0);
        if (!this.mgm) {
            int readBits = this.moy.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.moy.readBits(4);
            this.moy.Ka(1);
            byte[] ak = com.google.android.exoplayer2.util.c.ak(i, readBits2, this.moy.readBits(3));
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(ak);
            Format a = Format.a(this.moA, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(ak), null, 0, this.language);
            this.mot = 1024000000 / a.sampleRate;
            this.mgC.h(a);
            this.mgm = true;
        } else {
            this.moy.Ka(10);
        }
        this.moy.Ka(4);
        int readBits3 = (this.moy.readBits(13) - 2) - 5;
        if (this.moC) {
            readBits3 -= 2;
        }
        a(this.mgC, this.mot, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dzR(), this.sampleSize - this.mor);
        this.moD.a(lVar, min);
        this.mor = min + this.mor;
        if (this.mor == this.sampleSize) {
            this.moD.a(this.mfu, 1, this.sampleSize, 0, null);
            this.mfu += this.moE;
            dvP();
        }
    }
}
