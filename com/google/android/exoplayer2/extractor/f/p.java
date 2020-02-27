package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class p implements w {
    private long mdB;
    private com.google.android.exoplayer2.util.s mjp;
    private int mmx;
    private final h moo;
    private boolean moq;
    private boolean mor;
    private boolean mos;
    private int mot;
    private boolean mou;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mop = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.moo = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjp = sVar;
        this.moo.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void czb() {
        this.state = 0;
        this.mmx = 0;
        this.mos = false;
        this.moo.czb();
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
                    this.moo.dvn();
                    break;
            }
            setState(1);
        }
        while (lVar.dzr() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dzr());
                    break;
                case 1:
                    if (!a(lVar, this.mop.data, 9)) {
                        break;
                    } else {
                        setState(dvx() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mop.data, Math.min(10, this.mot)) && a(lVar, (byte[]) null, this.mot)) {
                        dvy();
                        this.moo.o(this.mdB, this.mou);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dzr = lVar.dzr();
                    int i = this.payloadSize == -1 ? 0 : dzr - this.payloadSize;
                    if (i > 0) {
                        dzr -= i;
                        lVar.setLimit(lVar.getPosition() + dzr);
                    }
                    this.moo.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dzr;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.moo.dvn();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mmx = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzr(), i - this.mmx);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.G(bArr, this.mmx, min);
        }
        this.mmx = min + this.mmx;
        return this.mmx == i;
    }

    private boolean dvx() {
        this.mop.setPosition(0);
        int readBits = this.mop.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mop.JU(8);
        int readBits2 = this.mop.readBits(16);
        this.mop.JU(5);
        this.mou = this.mop.dvl();
        this.mop.JU(2);
        this.moq = this.mop.dvl();
        this.mor = this.mop.dvl();
        this.mop.JU(6);
        this.mot = this.mop.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mot;
        }
        return true;
    }

    private void dvy() {
        this.mop.setPosition(0);
        this.mdB = -9223372036854775807L;
        if (this.moq) {
            this.mop.JU(4);
            this.mop.JU(1);
            long readBits = (this.mop.readBits(3) << 30) | (this.mop.readBits(15) << 15);
            this.mop.JU(1);
            long readBits2 = readBits | this.mop.readBits(15);
            this.mop.JU(1);
            if (!this.mos && this.mor) {
                this.mop.JU(4);
                this.mop.JU(1);
                long readBits3 = (this.mop.readBits(3) << 30) | (this.mop.readBits(15) << 15);
                this.mop.JU(1);
                long readBits4 = readBits3 | this.mop.readBits(15);
                this.mop.JU(1);
                this.mjp.gI(readBits4);
                this.mos = true;
            }
            this.mdB = this.mjp.gI(readBits2);
        }
    }
}
