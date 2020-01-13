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
    private Format lYL;
    private final String language;
    private int mah;
    private long mcQ;
    private com.google.android.exoplayer2.extractor.m mdY;
    private int mlM;
    private long mlO;
    private String mlV;
    private final com.google.android.exoplayer2.util.l mnk = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mnl = new com.google.android.exoplayer2.util.k(this.mnk.data);
    private int mnm;
    private boolean mnn;
    private int mno;
    private int mnp;
    private int mnq;
    private int mnr;
    private boolean mns;
    private long mnt;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.state = 0;
        this.mnn = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mdY = gVar.dH(dVar.duq(), 1);
        this.mlV = dVar.dur();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcQ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dyf() > 0) {
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
                        this.mnm = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mnm & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mnk.data.length) {
                        JT(this.sampleSize);
                    }
                    this.mlM = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dyf(), this.sampleSize - this.mlM);
                    lVar.C(this.mnl.data, this.mlM, min);
                    this.mlM = min + this.mlM;
                    if (this.mlM != this.sampleSize) {
                        break;
                    } else {
                        this.mnl.setPosition(0);
                        b(this.mnl);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dtY()) {
            this.mnn = true;
            c(kVar);
        } else if (!this.mnn) {
            return;
        }
        if (this.mnp == 0) {
            if (this.mnq != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mns) {
                kVar.JP((int) this.mnt);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dtY;
        this.mno = kVar.readBits(1);
        this.mnp = this.mno == 1 ? kVar.readBits(1) : 0;
        if (this.mnp == 0) {
            if (this.mno == 1) {
                g(kVar);
            }
            if (!kVar.dtY()) {
                throw new ParserException();
            }
            this.mnq = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mno == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.B(bArr, 0, e);
                Format a = Format.a(this.mlV, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.mah, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lYL)) {
                    this.lYL = a;
                    this.mlO = 1024000000 / a.sampleRate;
                    this.mdY.h(a);
                }
            } else {
                kVar.JP(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mns = kVar.dtY();
            this.mnt = 0L;
            if (this.mns) {
                if (this.mno == 1) {
                    this.mnt = g(kVar);
                } else {
                    do {
                        dtY = kVar.dtY();
                        this.mnt = (this.mnt << 8) + kVar.readBits(8);
                    } while (dtY);
                }
            }
            if (kVar.dtY()) {
                kVar.JP(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.mnr = kVar.readBits(3);
        switch (this.mnr) {
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
        int dyb = kVar.dyb();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.mah = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dyb - kVar.dyb();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.mnr == 0) {
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
            this.mnk.setPosition(position >> 3);
        } else {
            kVar.B(this.mnk.data, 0, i * 8);
            this.mnk.setPosition(0);
        }
        this.mdY.a(this.mnk, i);
        this.mdY.a(this.mcQ, 1, i, 0, null);
        this.mcQ += this.mlO;
    }

    private void JT(int i) {
        this.mnk.reset(i);
        this.mnl.aw(this.mnk.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
