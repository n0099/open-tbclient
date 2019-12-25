package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class p implements w {
    private long lYY;
    private com.google.android.exoplayer2.util.s meN;
    private int mhW;
    private final h mjO;
    private boolean mjQ;
    private boolean mjR;
    private boolean mjS;
    private int mjT;
    private boolean mjU;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mjP = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.mjO = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.meN = sVar;
        this.mjO.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void cwy() {
        this.state = 0;
        this.mhW = 0;
        this.mjS = false;
        this.mjO.cwy();
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
                    this.mjO.dsO();
                    break;
            }
            setState(1);
        }
        while (lVar.dwV() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dwV());
                    break;
                case 1:
                    if (!a(lVar, this.mjP.data, 9)) {
                        break;
                    } else {
                        setState(dsY() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mjP.data, Math.min(10, this.mjT)) && a(lVar, (byte[]) null, this.mjT)) {
                        dsZ();
                        this.mjO.m(this.lYY, this.mjU);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dwV = lVar.dwV();
                    int i = this.payloadSize == -1 ? 0 : dwV - this.payloadSize;
                    if (i > 0) {
                        dwV -= i;
                        lVar.setLimit(lVar.getPosition() + dwV);
                    }
                    this.mjO.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dwV;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.mjO.dsO();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mhW = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dwV(), i - this.mhW);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.D(bArr, this.mhW, min);
        }
        this.mhW = min + this.mhW;
        return this.mhW == i;
    }

    private boolean dsY() {
        this.mjP.setPosition(0);
        int readBits = this.mjP.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mjP.JG(8);
        int readBits2 = this.mjP.readBits(16);
        this.mjP.JG(5);
        this.mjU = this.mjP.dsM();
        this.mjP.JG(2);
        this.mjQ = this.mjP.dsM();
        this.mjR = this.mjP.dsM();
        this.mjP.JG(6);
        this.mjT = this.mjP.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mjT;
        }
        return true;
    }

    private void dsZ() {
        this.mjP.setPosition(0);
        this.lYY = -9223372036854775807L;
        if (this.mjQ) {
            this.mjP.JG(4);
            this.mjP.JG(1);
            long readBits = (this.mjP.readBits(3) << 30) | (this.mjP.readBits(15) << 15);
            this.mjP.JG(1);
            long readBits2 = readBits | this.mjP.readBits(15);
            this.mjP.JG(1);
            if (!this.mjS && this.mjR) {
                this.mjP.JG(4);
                this.mjP.JG(1);
                long readBits3 = (this.mjP.readBits(3) << 30) | (this.mjP.readBits(15) << 15);
                this.mjP.JG(1);
                long readBits4 = readBits3 | this.mjP.readBits(15);
                this.mjP.JG(1);
                this.meN.gF(readBits4);
                this.mjS = true;
            }
            this.lYY = this.meN.gF(readBits2);
        }
    }
}
