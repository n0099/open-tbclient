package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class p implements w {
    private long mcV;
    private com.google.android.exoplayer2.util.s miJ;
    private int mlR;
    private final h mnH;
    private boolean mnJ;
    private boolean mnK;
    private boolean mnL;
    private int mnM;
    private boolean mnN;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mnI = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.mnH = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.miJ = sVar;
        this.mnH.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void cxH() {
        this.state = 0;
        this.mlR = 0;
        this.mnL = false;
        this.mnH.cxH();
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
                    this.mnH.duc();
                    break;
            }
            setState(1);
        }
        while (lVar.dyh() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dyh());
                    break;
                case 1:
                    if (!a(lVar, this.mnI.data, 9)) {
                        break;
                    } else {
                        setState(dum() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mnI.data, Math.min(10, this.mnM)) && a(lVar, (byte[]) null, this.mnM)) {
                        dun();
                        this.mnH.m(this.mcV, this.mnN);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dyh = lVar.dyh();
                    int i = this.payloadSize == -1 ? 0 : dyh - this.payloadSize;
                    if (i > 0) {
                        dyh -= i;
                        lVar.setLimit(lVar.getPosition() + dyh);
                    }
                    this.mnH.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dyh;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.mnH.duc();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mlR = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyh(), i - this.mlR);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.C(bArr, this.mlR, min);
        }
        this.mlR = min + this.mlR;
        return this.mlR == i;
    }

    private boolean dum() {
        this.mnI.setPosition(0);
        int readBits = this.mnI.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mnI.JP(8);
        int readBits2 = this.mnI.readBits(16);
        this.mnI.JP(5);
        this.mnN = this.mnI.dua();
        this.mnI.JP(2);
        this.mnJ = this.mnI.dua();
        this.mnK = this.mnI.dua();
        this.mnI.JP(6);
        this.mnM = this.mnI.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mnM;
        }
        return true;
    }

    private void dun() {
        this.mnI.setPosition(0);
        this.mcV = -9223372036854775807L;
        if (this.mnJ) {
            this.mnI.JP(4);
            this.mnI.JP(1);
            long readBits = (this.mnI.readBits(3) << 30) | (this.mnI.readBits(15) << 15);
            this.mnI.JP(1);
            long readBits2 = readBits | this.mnI.readBits(15);
            this.mnI.JP(1);
            if (!this.mnL && this.mnK) {
                this.mnI.JP(4);
                this.mnI.JP(1);
                long readBits3 = (this.mnI.readBits(3) << 30) | (this.mnI.readBits(15) << 15);
                this.mnI.JP(1);
                long readBits4 = readBits3 | this.mnI.readBits(15);
                this.mnI.JP(1);
                this.miJ.gK(readBits4);
                this.mnL = true;
            }
            this.mcV = this.miJ.gK(readBits2);
        }
    }
}
