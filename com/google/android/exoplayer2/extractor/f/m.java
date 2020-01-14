package com.google.android.exoplayer2.extractor.f;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class m implements h {
    private int channelCount;
    private Format lYQ;
    private final String language;
    private int mam;
    private long mcV;
    private com.google.android.exoplayer2.extractor.m med;
    private int mlR;
    private long mlT;
    private String mma;
    private final com.google.android.exoplayer2.util.l mnp = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mnq = new com.google.android.exoplayer2.util.k(this.mnp.data);
    private int mnr;
    private boolean mns;
    private int mnt;
    private int mnu;
    private int mnv;
    private int mnw;
    private boolean mnx;
    private long mny;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.state = 0;
        this.mns = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.med = gVar.dH(dVar.dus(), 1);
        this.mma = dVar.dut();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcV = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dyh() > 0) {
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
                        this.mnr = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mnr & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mnp.data.length) {
                        JT(this.sampleSize);
                    }
                    this.mlR = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dyh(), this.sampleSize - this.mlR);
                    lVar.C(this.mnq.data, this.mlR, min);
                    this.mlR = min + this.mlR;
                    if (this.mlR != this.sampleSize) {
                        break;
                    } else {
                        this.mnq.setPosition(0);
                        b(this.mnq);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dua()) {
            this.mns = true;
            c(kVar);
        } else if (!this.mns) {
            return;
        }
        if (this.mnu == 0) {
            if (this.mnv != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mnx) {
                kVar.JP((int) this.mny);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dua;
        this.mnt = kVar.readBits(1);
        this.mnu = this.mnt == 1 ? kVar.readBits(1) : 0;
        if (this.mnu == 0) {
            if (this.mnt == 1) {
                g(kVar);
            }
            if (!kVar.dua()) {
                throw new ParserException();
            }
            this.mnv = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mnt == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.B(bArr, 0, e);
                Format a = Format.a(this.mma, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.mam, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lYQ)) {
                    this.lYQ = a;
                    this.mlT = 1024000000 / a.sampleRate;
                    this.med.h(a);
                }
            } else {
                kVar.JP(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mnx = kVar.dua();
            this.mny = 0L;
            if (this.mnx) {
                if (this.mnt == 1) {
                    this.mny = g(kVar);
                } else {
                    do {
                        dua = kVar.dua();
                        this.mny = (this.mny << 8) + kVar.readBits(8);
                    } while (dua);
                }
            }
            if (kVar.dua()) {
                kVar.JP(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.mnw = kVar.readBits(3);
        switch (this.mnw) {
            case 0:
                kVar.JP(8);
                return;
            case 1:
                kVar.JP(9);
                return;
            case 2:
            default:
                return;
            case 3:
            case 4:
            case 5:
                kVar.JP(6);
                return;
            case 6:
            case 7:
                kVar.JP(1);
                return;
        }
    }

    private int e(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int dyd = kVar.dyd();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.mam = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dyd - kVar.dyd();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.mnw == 0) {
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
            this.mnp.setPosition(position >> 3);
        } else {
            kVar.B(this.mnp.data, 0, i * 8);
            this.mnp.setPosition(0);
        }
        this.med.a(this.mnp, i);
        this.med.a(this.mcV, 1, i, 0, null);
        this.mcV += this.mlT;
    }

    private void JT(int i) {
        this.mnp.reset(i);
        this.mnq.aw(this.mnp.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
