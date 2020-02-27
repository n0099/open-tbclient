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
    private Format lZw;
    private final String language;
    private int maU;
    private long mdB;
    private com.google.android.exoplayer2.extractor.m meJ;
    private String mmG;
    private int mmx;
    private long mmz;
    private final com.google.android.exoplayer2.util.l mnV = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mnW = new com.google.android.exoplayer2.util.k(this.mnV.data);
    private int mnX;
    private boolean mnY;
    private int mnZ;
    private int moa;
    private int mob;
    private int moc;
    private boolean mod;
    private long moe;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.state = 0;
        this.mnY = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.meJ = gVar.dK(dVar.dvD(), 1);
        this.mmG = dVar.dvE();
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
                    if (lVar.readUnsignedByte() != 86) {
                        break;
                    } else {
                        this.state = 1;
                        break;
                    }
                case 1:
                    int readUnsignedByte = lVar.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.mnX = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mnX & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mnV.data.length) {
                        JY(this.sampleSize);
                    }
                    this.mmx = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dzr(), this.sampleSize - this.mmx);
                    lVar.G(this.mnW.data, this.mmx, min);
                    this.mmx = min + this.mmx;
                    if (this.mmx != this.sampleSize) {
                        break;
                    } else {
                        this.mnW.setPosition(0);
                        b(this.mnW);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dvl()) {
            this.mnY = true;
            c(kVar);
        } else if (!this.mnY) {
            return;
        }
        if (this.moa == 0) {
            if (this.mob != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mod) {
                kVar.JU((int) this.moe);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dvl;
        this.mnZ = kVar.readBits(1);
        this.moa = this.mnZ == 1 ? kVar.readBits(1) : 0;
        if (this.moa == 0) {
            if (this.mnZ == 1) {
                g(kVar);
            }
            if (!kVar.dvl()) {
                throw new ParserException();
            }
            this.mob = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mnZ == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.F(bArr, 0, e);
                Format a = Format.a(this.mmG, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.maU, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lZw)) {
                    this.lZw = a;
                    this.mmz = 1024000000 / a.sampleRate;
                    this.meJ.h(a);
                }
            } else {
                kVar.JU(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mod = kVar.dvl();
            this.moe = 0L;
            if (this.mod) {
                if (this.mnZ == 1) {
                    this.moe = g(kVar);
                } else {
                    do {
                        dvl = kVar.dvl();
                        this.moe = (this.moe << 8) + kVar.readBits(8);
                    } while (dvl);
                }
            }
            if (kVar.dvl()) {
                kVar.JU(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.moc = kVar.readBits(3);
        switch (this.moc) {
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
        int dzn = kVar.dzn();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.maU = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dzn - kVar.dzn();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.moc == 0) {
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
            this.mnV.setPosition(position >> 3);
        } else {
            kVar.F(this.mnV.data, 0, i * 8);
            this.mnV.setPosition(0);
        }
        this.meJ.a(this.mnV, i);
        this.meJ.a(this.mdB, 1, i, 0, null);
        this.mdB += this.mmz;
    }

    private void JY(int i) {
        this.mnV.reset(i);
        this.mnW.aB(this.mnV.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
