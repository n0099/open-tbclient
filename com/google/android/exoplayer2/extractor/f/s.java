package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class s implements w {
    private int mlR;
    private final r mnU;
    private final com.google.android.exoplayer2.util.l mnV = new com.google.android.exoplayer2.util.l(32);
    private int mnW;
    private boolean mnX;
    private boolean mnY;

    public s(r rVar) {
        this.mnU = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mnU.a(sVar, gVar, dVar);
        this.mnY = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void cxH() {
        this.mnY = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.mnY) {
            if (z) {
                this.mnY = false;
                lVar.setPosition(readUnsignedByte);
                this.mlR = 0;
            } else {
                return;
            }
        }
        while (lVar.dyh() > 0) {
            if (this.mlR < 3) {
                if (this.mlR == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.mnY = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dyh(), 3 - this.mlR);
                lVar.C(this.mnV.data, this.mlR, min);
                this.mlR = min + this.mlR;
                if (this.mlR == 3) {
                    this.mnV.reset(3);
                    this.mnV.skipBytes(1);
                    int readUnsignedByte3 = this.mnV.readUnsignedByte();
                    int readUnsignedByte4 = this.mnV.readUnsignedByte();
                    this.mnX = (readUnsignedByte3 & 128) != 0;
                    this.mnW = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.mnV.capacity() < this.mnW) {
                        byte[] bArr = this.mnV.data;
                        this.mnV.reset(Math.min(4098, Math.max(this.mnW, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.mnV.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dyh(), this.mnW - this.mlR);
                lVar.C(this.mnV.data, this.mlR, min2);
                this.mlR = min2 + this.mlR;
                if (this.mlR != this.mnW) {
                    continue;
                } else {
                    if (this.mnX) {
                        if (com.google.android.exoplayer2.util.v.e(this.mnV.data, 0, this.mnW, -1) != 0) {
                            this.mnY = true;
                            return;
                        }
                        this.mnV.reset(this.mnW - 4);
                    } else {
                        this.mnV.reset(this.mnW);
                    }
                    this.mnU.I(this.mnV);
                    this.mlR = 0;
                }
            }
        }
    }
}
