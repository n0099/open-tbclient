package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class p implements w {
    private long mdO;
    private com.google.android.exoplayer2.util.s mjC;
    private int mmK;
    private final h moB;
    private boolean moD;
    private boolean moE;
    private boolean moF;
    private int moG;
    private boolean moH;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k moC = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.moB = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mjC = sVar;
        this.moB.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void cze() {
        this.state = 0;
        this.mmK = 0;
        this.moF = false;
        this.moB.cze();
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
                    this.moB.dvq();
                    break;
            }
            setState(1);
        }
        while (lVar.dzu() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dzu());
                    break;
                case 1:
                    if (!a(lVar, this.moC.data, 9)) {
                        break;
                    } else {
                        setState(dvA() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.moC.data, Math.min(10, this.moG)) && a(lVar, (byte[]) null, this.moG)) {
                        dvB();
                        this.moB.o(this.mdO, this.moH);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dzu = lVar.dzu();
                    int i = this.payloadSize == -1 ? 0 : dzu - this.payloadSize;
                    if (i > 0) {
                        dzu -= i;
                        lVar.setLimit(lVar.getPosition() + dzu);
                    }
                    this.moB.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dzu;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.moB.dvq();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mmK = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzu(), i - this.mmK);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.G(bArr, this.mmK, min);
        }
        this.mmK = min + this.mmK;
        return this.mmK == i;
    }

    private boolean dvA() {
        this.moC.setPosition(0);
        int readBits = this.moC.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.moC.JU(8);
        int readBits2 = this.moC.readBits(16);
        this.moC.JU(5);
        this.moH = this.moC.dvo();
        this.moC.JU(2);
        this.moD = this.moC.dvo();
        this.moE = this.moC.dvo();
        this.moC.JU(6);
        this.moG = this.moC.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.moG;
        }
        return true;
    }

    private void dvB() {
        this.moC.setPosition(0);
        this.mdO = -9223372036854775807L;
        if (this.moD) {
            this.moC.JU(4);
            this.moC.JU(1);
            long readBits = (this.moC.readBits(3) << 30) | (this.moC.readBits(15) << 15);
            this.moC.JU(1);
            long readBits2 = readBits | this.moC.readBits(15);
            this.moC.JU(1);
            if (!this.moF && this.moE) {
                this.moC.JU(4);
                this.moC.JU(1);
                long readBits3 = (this.moC.readBits(3) << 30) | (this.moC.readBits(15) << 15);
                this.moC.JU(1);
                long readBits4 = readBits3 | this.moC.readBits(15);
                this.moC.JU(1);
                this.mjC.gI(readBits4);
                this.moF = true;
            }
            this.mdO = this.mjC.gI(readBits2);
        }
    }
}
