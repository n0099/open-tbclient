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
    private Format lZJ;
    private final String language;
    private int mbh;
    private long mdO;
    private com.google.android.exoplayer2.extractor.m meW;
    private int mmK;
    private long mmM;
    private String mmT;
    private final com.google.android.exoplayer2.util.l moi = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k moj = new com.google.android.exoplayer2.util.k(this.moi.data);
    private int mok;
    private boolean mol;
    private int mom;
    private int moo;
    private int mop;
    private int moq;
    private boolean mor;
    private long mos;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.state = 0;
        this.mol = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.meW = gVar.dK(dVar.dvG(), 1);
        this.mmT = dVar.dvH();
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
                    if (lVar.readUnsignedByte() != 86) {
                        break;
                    } else {
                        this.state = 1;
                        break;
                    }
                case 1:
                    int readUnsignedByte = lVar.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.mok = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mok & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.moi.data.length) {
                        JY(this.sampleSize);
                    }
                    this.mmK = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dzu(), this.sampleSize - this.mmK);
                    lVar.G(this.moj.data, this.mmK, min);
                    this.mmK = min + this.mmK;
                    if (this.mmK != this.sampleSize) {
                        break;
                    } else {
                        this.moj.setPosition(0);
                        b(this.moj);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dvo()) {
            this.mol = true;
            c(kVar);
        } else if (!this.mol) {
            return;
        }
        if (this.moo == 0) {
            if (this.mop != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mor) {
                kVar.JU((int) this.mos);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dvo;
        this.mom = kVar.readBits(1);
        this.moo = this.mom == 1 ? kVar.readBits(1) : 0;
        if (this.moo == 0) {
            if (this.mom == 1) {
                g(kVar);
            }
            if (!kVar.dvo()) {
                throw new ParserException();
            }
            this.mop = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mom == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.F(bArr, 0, e);
                Format a = Format.a(this.mmT, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.mbh, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lZJ)) {
                    this.lZJ = a;
                    this.mmM = 1024000000 / a.sampleRate;
                    this.meW.h(a);
                }
            } else {
                kVar.JU(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mor = kVar.dvo();
            this.mos = 0L;
            if (this.mor) {
                if (this.mom == 1) {
                    this.mos = g(kVar);
                } else {
                    do {
                        dvo = kVar.dvo();
                        this.mos = (this.mos << 8) + kVar.readBits(8);
                    } while (dvo);
                }
            }
            if (kVar.dvo()) {
                kVar.JU(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.moq = kVar.readBits(3);
        switch (this.moq) {
            case 0:
                kVar.JU(8);
                return;
            case 1:
                kVar.JU(9);
                return;
            case 2:
            default:
                return;
            case 3:
            case 4:
            case 5:
                kVar.JU(6);
                return;
            case 6:
            case 7:
                kVar.JU(1);
                return;
        }
    }

    private int e(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int dzq = kVar.dzq();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.mbh = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dzq - kVar.dzq();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.moq == 0) {
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
            this.moi.setPosition(position >> 3);
        } else {
            kVar.F(this.moi.data, 0, i * 8);
            this.moi.setPosition(0);
        }
        this.meW.a(this.moi, i);
        this.meW.a(this.mdO, 1, i, 0, null);
        this.mdO += this.mmM;
    }

    private void JY(int i) {
        this.moi.reset(i);
        this.moj.aB(this.moi.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
