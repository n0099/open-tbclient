package com.google.android.exoplayer2.extractor.f;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class m implements h {
    private int channelCount;
    private final String language;
    private Format mbs;
    private int mcN;
    private long mfu;
    private com.google.android.exoplayer2.extractor.m mgC;
    private String moA;
    private int mor;
    private long mot;
    private final com.google.android.exoplayer2.util.l mpP = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mpQ = new com.google.android.exoplayer2.util.k(this.mpP.data);
    private int mpR;
    private boolean mpS;
    private int mpT;
    private int mpU;
    private int mpV;
    private int mpW;
    private boolean mpX;
    private long mpY;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.state = 0;
        this.mpS = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.mgC = gVar.dL(dVar.dwd(), 1);
        this.moA = dVar.dwe();
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
                    if (lVar.readUnsignedByte() != 86) {
                        break;
                    } else {
                        this.state = 1;
                        break;
                    }
                case 1:
                    int readUnsignedByte = lVar.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.mpR = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mpR & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mpP.data.length) {
                        Ke(this.sampleSize);
                    }
                    this.mor = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dzR(), this.sampleSize - this.mor);
                    lVar.G(this.mpQ.data, this.mor, min);
                    this.mor = min + this.mor;
                    if (this.mor != this.sampleSize) {
                        break;
                    } else {
                        this.mpQ.setPosition(0);
                        b(this.mpQ);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dvL()) {
            this.mpS = true;
            c(kVar);
        } else if (!this.mpS) {
            return;
        }
        if (this.mpU == 0) {
            if (this.mpV != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mpX) {
                kVar.Ka((int) this.mpY);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dvL;
        this.mpT = kVar.readBits(1);
        this.mpU = this.mpT == 1 ? kVar.readBits(1) : 0;
        if (this.mpU == 0) {
            if (this.mpT == 1) {
                g(kVar);
            }
            if (!kVar.dvL()) {
                throw new ParserException();
            }
            this.mpV = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mpT == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.F(bArr, 0, e);
                Format a = Format.a(this.moA, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.mcN, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.mbs)) {
                    this.mbs = a;
                    this.mot = 1024000000 / a.sampleRate;
                    this.mgC.h(a);
                }
            } else {
                kVar.Ka(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mpX = kVar.dvL();
            this.mpY = 0L;
            if (this.mpX) {
                if (this.mpT == 1) {
                    this.mpY = g(kVar);
                } else {
                    do {
                        dvL = kVar.dvL();
                        this.mpY = (this.mpY << 8) + kVar.readBits(8);
                    } while (dvL);
                }
            }
            if (kVar.dvL()) {
                kVar.Ka(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.mpW = kVar.readBits(3);
        switch (this.mpW) {
            case 0:
                kVar.Ka(8);
                return;
            case 1:
                kVar.Ka(9);
                return;
            case 2:
            default:
                return;
            case 3:
            case 4:
            case 5:
                kVar.Ka(6);
                return;
            case 6:
            case 7:
                kVar.Ka(1);
                return;
        }
    }

    private int e(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int dzN = kVar.dzN();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.mcN = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dzN - kVar.dzN();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.mpW == 0) {
            do {
                readBits = kVar.readBits(8);
                i += readBits;
            } while (readBits == 255);
            return i;
        }
        throw new ParserException();
    }

    private void a(com.google.android.exoplayer2.util.k kVar, int i) {
        int position = kVar.getPosition();
        if ((position & 7) == 0) {
            this.mpP.setPosition(position >> 3);
        } else {
            kVar.F(this.mpP.data, 0, i * 8);
            this.mpP.setPosition(0);
        }
        this.mgC.a(this.mpP, i);
        this.mgC.a(this.mfu, 1, i, 0, null);
        this.mfu += this.mot;
    }

    private void Ke(int i) {
        this.mpP.reset(i);
        this.mpQ.aB(this.mpP.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
