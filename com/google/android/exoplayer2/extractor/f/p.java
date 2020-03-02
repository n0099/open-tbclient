package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class p implements w {
    private long mdD;
    private com.google.android.exoplayer2.util.s mjr;
    private int mmz;
    private final h moq;
    private boolean mos;
    private boolean mot;
    private boolean mou;
    private int mov;
    private boolean mow;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mor = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.moq = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjr = sVar;
        this.moq.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void czd() {
        this.state = 0;
        this.mmz = 0;
        this.mou = false;
        this.moq.czd();
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException {
        if (z) {
            switch (this.state) {
                case 2:
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                    break;
                case 3:
                    if (this.payloadSize != -1) {
                        Log.w("PesReader", "Unexpected start indicator: expected " + this.payloadSize + " more bytes");
                    }
                    this.moq.dvp();
                    break;
            }
            setState(1);
        }
        while (lVar.dzt() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dzt());
                    break;
                case 1:
                    if (!a(lVar, this.mor.data, 9)) {
                        break;
                    } else {
                        setState(dvz() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mor.data, Math.min(10, this.mov)) && a(lVar, (byte[]) null, this.mov)) {
                        dvA();
                        this.moq.o(this.mdD, this.mow);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dzt = lVar.dzt();
                    int i = this.payloadSize == -1 ? 0 : dzt - this.payloadSize;
                    if (i > 0) {
                        dzt -= i;
                        lVar.setLimit(lVar.getPosition() + dzt);
                    }
                    this.moq.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dzt;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.moq.dvp();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mmz = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzt(), i - this.mmz);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.G(bArr, this.mmz, min);
        }
        this.mmz = min + this.mmz;
        return this.mmz == i;
    }

    private boolean dvz() {
        this.mor.setPosition(0);
        int readBits = this.mor.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mor.JU(8);
        int readBits2 = this.mor.readBits(16);
        this.mor.JU(5);
        this.mow = this.mor.dvn();
        this.mor.JU(2);
        this.mos = this.mor.dvn();
        this.mot = this.mor.dvn();
        this.mor.JU(6);
        this.mov = this.mor.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mov;
        }
        return true;
    }

    private void dvA() {
        this.mor.setPosition(0);
        this.mdD = -9223372036854775807L;
        if (this.mos) {
            this.mor.JU(4);
            this.mor.JU(1);
            long readBits = (this.mor.readBits(3) << 30) | (this.mor.readBits(15) << 15);
            this.mor.JU(1);
            long readBits2 = readBits | this.mor.readBits(15);
            this.mor.JU(1);
            if (!this.mou && this.mot) {
                this.mor.JU(4);
                this.mor.JU(1);
                long readBits3 = (this.mor.readBits(3) << 30) | (this.mor.readBits(15) << 15);
                this.mor.JU(1);
                long readBits4 = readBits3 | this.mor.readBits(15);
                this.mor.JU(1);
                this.mjr.gI(readBits4);
                this.mou = true;
            }
            this.mdD = this.mjr.gI(readBits2);
        }
    }
}
