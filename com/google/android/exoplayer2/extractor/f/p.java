package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class p implements w {
    private long mcQ;
    private com.google.android.exoplayer2.util.s miE;
    private int mlM;
    private final h mnC;
    private boolean mnE;
    private boolean mnF;
    private boolean mnG;
    private int mnH;
    private boolean mnI;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mnD = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.mnC = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.miE = sVar;
        this.mnC.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void cxF() {
        this.state = 0;
        this.mlM = 0;
        this.mnG = false;
        this.mnC.cxF();
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
                    this.mnC.dua();
                    break;
            }
            setState(1);
        }
        while (lVar.dyf() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dyf());
                    break;
                case 1:
                    if (!a(lVar, this.mnD.data, 9)) {
                        break;
                    } else {
                        setState(duk() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mnD.data, Math.min(10, this.mnH)) && a(lVar, (byte[]) null, this.mnH)) {
                        dul();
                        this.mnC.m(this.mcQ, this.mnI);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dyf = lVar.dyf();
                    int i = this.payloadSize == -1 ? 0 : dyf - this.payloadSize;
                    if (i > 0) {
                        dyf -= i;
                        lVar.setLimit(lVar.getPosition() + dyf);
                    }
                    this.mnC.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dyf;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.mnC.dua();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mlM = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyf(), i - this.mlM);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.C(bArr, this.mlM, min);
        }
        this.mlM = min + this.mlM;
        return this.mlM == i;
    }

    private boolean duk() {
        this.mnD.setPosition(0);
        int readBits = this.mnD.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mnD.JP(8);
        int readBits2 = this.mnD.readBits(16);
        this.mnD.JP(5);
        this.mnI = this.mnD.dtY();
        this.mnD.JP(2);
        this.mnE = this.mnD.dtY();
        this.mnF = this.mnD.dtY();
        this.mnD.JP(6);
        this.mnH = this.mnD.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mnH;
        }
        return true;
    }

    private void dul() {
        this.mnD.setPosition(0);
        this.mcQ = -9223372036854775807L;
        if (this.mnE) {
            this.mnD.JP(4);
            this.mnD.JP(1);
            long readBits = (this.mnD.readBits(3) << 30) | (this.mnD.readBits(15) << 15);
            this.mnD.JP(1);
            long readBits2 = readBits | this.mnD.readBits(15);
            this.mnD.JP(1);
            if (!this.mnG && this.mnF) {
                this.mnD.JP(4);
                this.mnD.JP(1);
                long readBits3 = (this.mnD.readBits(3) << 30) | (this.mnD.readBits(15) << 15);
                this.mnD.JP(1);
                long readBits4 = readBits3 | this.mnD.readBits(15);
                this.mnD.JP(1);
                this.miE.gK(readBits4);
                this.mnG = true;
            }
            this.mcQ = this.miE.gK(readBits2);
        }
    }
}
