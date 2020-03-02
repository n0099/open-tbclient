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
    private Format lZy;
    private final String language;
    private int maW;
    private long mdD;
    private com.google.android.exoplayer2.extractor.m meL;
    private long mmB;
    private String mmI;
    private int mmz;
    private final com.google.android.exoplayer2.util.l mnX = new com.google.android.exoplayer2.util.l(1024);
    private final com.google.android.exoplayer2.util.k mnY = new com.google.android.exoplayer2.util.k(this.mnX.data);
    private int mnZ;
    private boolean moa;
    private int mob;
    private int moc;
    private int mod;
    private int moe;
    private boolean mof;
    private long mog;
    private int sampleSize;
    private int state;

    public m(@Nullable String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.state = 0;
        this.moa = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.meL = gVar.dK(dVar.dvF(), 1);
        this.mmI = dVar.dvG();
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
                    if (lVar.readUnsignedByte() != 86) {
                        break;
                    } else {
                        this.state = 1;
                        break;
                    }
                case 1:
                    int readUnsignedByte = lVar.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.mnZ = readUnsignedByte;
                        this.state = 2;
                        break;
                    } else if (readUnsignedByte == 86) {
                        break;
                    } else {
                        this.state = 0;
                        break;
                    }
                case 2:
                    this.sampleSize = ((this.mnZ & (-225)) << 8) | lVar.readUnsignedByte();
                    if (this.sampleSize > this.mnX.data.length) {
                        JY(this.sampleSize);
                    }
                    this.mmz = 0;
                    this.state = 3;
                    break;
                case 3:
                    int min = Math.min(lVar.dzt(), this.sampleSize - this.mmz);
                    lVar.G(this.mnY.data, this.mmz, min);
                    this.mmz = min + this.mmz;
                    if (this.mmz != this.sampleSize) {
                        break;
                    } else {
                        this.mnY.setPosition(0);
                        b(this.mnY);
                        this.state = 0;
                        break;
                    }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
    }

    private void b(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        if (!kVar.dvn()) {
            this.moa = true;
            c(kVar);
        } else if (!this.moa) {
            return;
        }
        if (this.moc == 0) {
            if (this.mod != 0) {
                throw new ParserException();
            }
            a(kVar, f(kVar));
            if (this.mof) {
                kVar.JU((int) this.mog);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void c(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        boolean dvn;
        this.mob = kVar.readBits(1);
        this.moc = this.mob == 1 ? kVar.readBits(1) : 0;
        if (this.moc == 0) {
            if (this.mob == 1) {
                g(kVar);
            }
            if (!kVar.dvn()) {
                throw new ParserException();
            }
            this.mod = kVar.readBits(6);
            int readBits = kVar.readBits(4);
            int readBits2 = kVar.readBits(3);
            if (readBits != 0 || readBits2 != 0) {
                throw new ParserException();
            }
            if (this.mob == 0) {
                int position = kVar.getPosition();
                int e = e(kVar);
                kVar.setPosition(position);
                byte[] bArr = new byte[(e + 7) / 8];
                kVar.F(bArr, 0, e);
                Format a = Format.a(this.mmI, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.maW, Collections.singletonList(bArr), null, 0, this.language);
                if (!a.equals(this.lZy)) {
                    this.lZy = a;
                    this.mmB = 1024000000 / a.sampleRate;
                    this.meL.h(a);
                }
            } else {
                kVar.JU(((int) g(kVar)) - e(kVar));
            }
            d(kVar);
            this.mof = kVar.dvn();
            this.mog = 0L;
            if (this.mof) {
                if (this.mob == 1) {
                    this.mog = g(kVar);
                } else {
                    do {
                        dvn = kVar.dvn();
                        this.mog = (this.mog << 8) + kVar.readBits(8);
                    } while (dvn);
                }
            }
            if (kVar.dvn()) {
                kVar.JU(8);
                return;
            }
            return;
        }
        throw new ParserException();
    }

    private void d(com.google.android.exoplayer2.util.k kVar) {
        this.moe = kVar.readBits(3);
        switch (this.moe) {
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
        int dzp = kVar.dzp();
        Pair<Integer, Integer> a = com.google.android.exoplayer2.util.c.a(kVar, true);
        this.maW = ((Integer) a.first).intValue();
        this.channelCount = ((Integer) a.second).intValue();
        return dzp - kVar.dzp();
    }

    private int f(com.google.android.exoplayer2.util.k kVar) throws ParserException {
        int readBits;
        int i = 0;
        if (this.moe == 0) {
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
            this.mnX.setPosition(position >> 3);
        } else {
            kVar.F(this.mnX.data, 0, i * 8);
            this.mnX.setPosition(0);
        }
        this.meL.a(this.mnX, i);
        this.meL.a(this.mdD, 1, i, 0, null);
        this.mdD += this.mmB;
    }

    private void JY(int i) {
        this.mnX.reset(i);
        this.mnY.aB(this.mnX.data);
    }

    private static long g(com.google.android.exoplayer2.util.k kVar) {
        return kVar.readBits((kVar.readBits(2) + 1) * 8);
    }
}
