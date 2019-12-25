package com.google.android.exoplayer2.extractor.f;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes4.dex */
public final class m implements h {
    private int channelCount;
    private Format lUU;
    private int lWr;
    private long lYY;
    private final String language;
    private com.google.android.exoplayer2.extractor.m mah;
    private int mhW;
    private long mhY;
    private String mig;
    private int mjA;
    private int mjB;
    private int mjC;
    private int mjD;
    private boolean mjE;
    private long mjF;
    private final com.google.android.exoplayer2.util.l mjw = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mjx = new com.google.android.exoplayer2.util.k(this.mjw.data);
    private int mjy;
    private boolean mjz;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.state = 0;
        this.mjz = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mah = gVar.dJ(dVar.dtf(), 1);
        this.mig = dVar.dtg();
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
                    if (lVar.readUnsignedByte() != 86) {
                        break;
                    } else {
                        this.state = 1;
                        break;
                    }
                case 1:
                    int readUnsignedByte = lVar.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.mjy = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mjy & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mjw.data.length) {
                        JK(this.sampleSize);
                    }
                    this.mhW = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dwV(), this.sampleSize - this.mhW);
                    lVar.D(this.mjx.data, this.mhW, min);
                    this.mhW = min + this.mhW;
                    if (this.mhW != this.sampleSize) {
                        break;
                    } else {
                        this.mjx.setPosition(0);
                        b(this.mjx);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dsM()) {
            this.mjz = true;
            c(kVar);
        } else if (!this.mjz) {
            return;
        }
        if (this.mjB == 0) {
            if (this.mjC != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mjE) {
                kVar.JG((int) this.mjF);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dsM;
        this.mjA = kVar.readBits(1);
        this.mjB = this.mjA == 1 ? kVar.readBits(1) : 0;
        if (this.mjB == 0) {
            if (this.mjA == 1) {
                g(kVar);
            }
            if (!kVar.dsM()) {
                throw new ParserException();
            }
            this.mjC = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mjA == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.C(bArr, 0, e);
                Format a = Format.a(this.mig, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.lWr, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lUU)) {
                    this.lUU = a;
                    this.mhY = 1024000000 / a.sampleRate;
                    this.mah.h(a);
                }
            } else {
                kVar.JG(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mjE = kVar.dsM();
            this.mjF = 0L;
            if (this.mjE) {
                if (this.mjA == 1) {
                    this.mjF = g(kVar);
                } else {
                    do {
                        dsM = kVar.dsM();
                        this.mjF = (this.mjF << 8) + kVar.readBits(8);
                    } while (dsM);
                }
            }
            if (kVar.dsM()) {
                kVar.JG(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.mjD = kVar.readBits(3);
        switch (this.mjD) {
            case 0:
                kVar.JG(8);
                return;
            case 1:
                kVar.JG(9);
                return;
            case 2:
            default:
                return;
            case 3:
            case 4:
            case 5:
                kVar.JG(6);
                return;
            case 6:
            case 7:
                kVar.JG(1);
                return;
        }
    }

    private int e(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int dwR = kVar.dwR();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.lWr = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dwR - kVar.dwR();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.mjD == 0) {
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
            this.mjw.setPosition(position >> 3);
        } else {
            kVar.C(this.mjw.data, 0, i * 8);
            this.mjw.setPosition(0);
        }
        this.mah.a(this.mjw, i);
        this.mah.a(this.lYY, 1, i, 0, null);
        this.lYY += this.mhY;
    }

    private void JK(int i) {
        this.mjw.reset(i);
        this.mjx.ax(this.mjw.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
