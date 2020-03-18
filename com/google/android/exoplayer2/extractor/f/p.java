package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class p implements w {
    private long mfu;
    private com.google.android.exoplayer2.util.s mli;
    private int mor;
    private final h mqh;
    private boolean mqj;
    private boolean mqk;
    private boolean mql;
    private int mqm;
    private boolean mqn;
    private int payloadSize;
    private final com.google.android.exoplayer2.util.k mqi = new com.google.android.exoplayer2.util.k(new byte[10]);
    private int state = 0;

    public p(h hVar) {
        this.mqh = hVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mli = sVar;
        this.mqh.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public final void czx() {
        this.state = 0;
        this.mor = 0;
        this.mql = false;
        this.mqh.czx();
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
                    this.mqh.dvN();
                    break;
            }
            setState(1);
        }
        while (lVar.dzR() > 0) {
            switch (this.state) {
                case 0:
                    lVar.skipBytes(lVar.dzR());
                    break;
                case 1:
                    if (!a(lVar, this.mqi.data, 9)) {
                        break;
                    } else {
                        setState(dvX() ? 2 : 0);
                        break;
                    }
                case 2:
                    if (a(lVar, this.mqi.data, Math.min(10, this.mqm)) && a(lVar, (byte[]) null, this.mqm)) {
                        dvY();
                        this.mqh.p(this.mfu, this.mqn);
                        setState(3);
                        break;
                    }
                    break;
                case 3:
                    int dzR = lVar.dzR();
                    int i = this.payloadSize == -1 ? 0 : dzR - this.payloadSize;
                    if (i > 0) {
                        dzR -= i;
                        lVar.setLimit(lVar.getPosition() + dzR);
                    }
                    this.mqh.I(lVar);
                    if (this.payloadSize == -1) {
                        break;
                    } else {
                        this.payloadSize -= dzR;
                        if (this.payloadSize != 0) {
                            break;
                        } else {
                            this.mqh.dvN();
                            setState(1);
                            break;
                        }
                    }
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.mor = 0;
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dzR(), i - this.mor);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(min);
        } else {
            lVar.G(bArr, this.mor, min);
        }
        this.mor = min + this.mor;
        return this.mor == i;
    }

    private boolean dvX() {
        this.mqi.setPosition(0);
        int readBits = this.mqi.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.mqi.Ka(8);
        int readBits2 = this.mqi.readBits(16);
        this.mqi.Ka(5);
        this.mqn = this.mqi.dvL();
        this.mqi.Ka(2);
        this.mqj = this.mqi.dvL();
        this.mqk = this.mqi.dvL();
        this.mqi.Ka(6);
        this.mqm = this.mqi.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.mqm;
        }
        return true;
    }

    private void dvY() {
        this.mqi.setPosition(0);
        this.mfu = -9223372036854775807L;
        if (this.mqj) {
            this.mqi.Ka(4);
            this.mqi.Ka(1);
            long readBits = (this.mqi.readBits(3) << 30) | (this.mqi.readBits(15) << 15);
            this.mqi.Ka(1);
            long readBits2 = readBits | this.mqi.readBits(15);
            this.mqi.Ka(1);
            if (!this.mql && this.mqk) {
                this.mqi.Ka(4);
                this.mqi.Ka(1);
                long readBits3 = (this.mqi.readBits(3) << 30) | (this.mqi.readBits(15) << 15);
                this.mqi.Ka(1);
                long readBits4 = readBits3 | this.mqi.readBits(15);
                this.mqi.Ka(1);
                this.mli.gJ(readBits4);
                this.mql = true;
            }
            this.mfu = this.mli.gJ(readBits2);
        }
    }
}
