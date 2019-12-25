package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes4.dex */
public final class d implements h {
    private static final byte[] mib = {73, 68, 51};
    private int UT;
    private long lYY;
    private boolean lZQ;
    private final String language;
    private com.google.android.exoplayer2.extractor.m mah;
    private int mhW;
    private long mhY;
    private final boolean mic;
    private final com.google.android.exoplayer2.util.k mie;
    private final com.google.android.exoplayer2.util.l mif;
    private String mig;
    private com.google.android.exoplayer2.extractor.m mih;
    private boolean mii;
    private com.google.android.exoplayer2.extractor.m mij;
    private long mik;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mie = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mif = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mib, 10));
        dsQ();
        this.mic = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        dsQ();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mig = dVar.dtg();
        this.mah = gVar.dJ(dVar.dtf(), 1);
        if (this.mic) {
            dVar.dte();
            this.mih = gVar.dJ(dVar.dtf(), 4);
            this.mih.h(Format.a(dVar.dtg(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mih = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.lYY = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dwV() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mif.data, 10)) {
                        break;
                    } else {
                        dsT();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mie.data, this.mii ? 7 : 5)) {
                        break;
                    } else {
                        dsU();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dwV(), i - this.mhW);
        lVar.D(bArr, this.mhW, min);
        this.mhW = min + this.mhW;
        return this.mhW == i;
    }

    private void dsQ() {
        this.state = 0;
        this.mhW = 0;
        this.UT = 256;
    }

    private void dsR() {
        this.state = 1;
        this.mhW = mib.length;
        this.sampleSize = 0;
        this.mif.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mhW = i;
        this.mij = mVar;
        this.mik = j;
        this.sampleSize = i2;
    }

    private void dsS() {
        this.state = 2;
        this.mhW = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dwW = lVar.dwW();
        while (position < dwW) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.UT == 512 && i2 >= 240 && i2 != 255) {
                this.mii = (i2 & 1) == 0;
                dsS();
                lVar.setPosition(i);
                return;
            }
            switch (i2 | this.UT) {
                case 329:
                    this.UT = 768;
                    position = i;
                    break;
                case 511:
                    this.UT = 512;
                    position = i;
                    break;
                case 836:
                    this.UT = 1024;
                    position = i;
                    break;
                case 1075:
                    dsR();
                    lVar.setPosition(i);
                    return;
                default:
                    if (this.UT == 256) {
                        position = i;
                        break;
                    } else {
                        this.UT = 256;
                        position = i - 1;
                        break;
                    }
            }
        }
        lVar.setPosition(position);
    }

    private void dsT() {
        this.mih.a(this.mif, 10);
        this.mif.setPosition(6);
        a(this.mih, 0L, 10, this.mif.dxf() + 10);
    }

    private void dsU() throws ParserException {
        int i = 2;
        this.mie.setPosition(0);
        if (!this.lZQ) {
            int readBits = this.mie.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mie.readBits(4);
            this.mie.JG(1);
            byte[] aj = com.google.android.exoplayer2.util.c.aj(i, readBits2, this.mie.readBits(3));
            Pair<Integer, Integer> av = com.google.android.exoplayer2.util.c.av(aj);
            Format a = Format.a(this.mig, "audio/mp4a-latm", null, -1, -1, ((Integer) av.second).intValue(), ((Integer) av.first).intValue(), Collections.singletonList(aj), null, 0, this.language);
            this.mhY = 1024000000 / a.sampleRate;
            this.mah.h(a);
            this.lZQ = true;
        } else {
            this.mie.JG(10);
        }
        this.mie.JG(4);
        int readBits3 = (this.mie.readBits(13) - 2) - 5;
        if (this.mii) {
            readBits3 -= 2;
        }
        a(this.mah, this.mhY, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dwV(), this.sampleSize - this.mhW);
        this.mij.a(lVar, min);
        this.mhW = min + this.mhW;
        if (this.mhW == this.sampleSize) {
            this.mij.a(this.lYY, 1, this.sampleSize, 0, null);
            this.lYY += this.mik;
            dsQ();
        }
    }
}
