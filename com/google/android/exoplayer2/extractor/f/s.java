package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class s implements w {
    private int mmK;
    private final r moO;
    private final com.google.android.exoplayer2.util.l moP = new com.google.android.exoplayer2.util.l(32);
    private int moQ;
    private boolean moR;
    private boolean moS;

    public s(r rVar) {
        this.moO = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.moO.a(sVar, gVar, dVar);
        this.moS = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void cze() {
        this.moS = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.moS) {
            if (z) {
                this.moS = false;
                lVar.setPosition(readUnsignedByte);
                this.mmK = 0;
            } else {
                return;
            }
        }
        while (lVar.dzu() > 0) {
            if (this.mmK < 3) {
                if (this.mmK == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.moS = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dzu(), 3 - this.mmK);
                lVar.G(this.moP.data, this.mmK, min);
                this.mmK = min + this.mmK;
                if (this.mmK == 3) {
                    this.moP.reset(3);
                    this.moP.skipBytes(1);
                    int readUnsignedByte3 = this.moP.readUnsignedByte();
                    int readUnsignedByte4 = this.moP.readUnsignedByte();
                    this.moR = (readUnsignedByte3 & 128) != 0;
                    this.moQ = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.moP.capacity() < this.moQ) {
                        byte[] bArr = this.moP.data;
                        this.moP.reset(Math.min(4098, Math.max(this.moQ, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.moP.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dzu(), this.moQ - this.mmK);
                lVar.G(this.moP.data, this.mmK, min2);
                this.mmK = min2 + this.mmK;
                if (this.mmK != this.moQ) {
                    continue;
                } else {
                    if (this.moR) {
                        if (com.google.android.exoplayer2.util.v.e(this.moP.data, 0, this.moQ, -1) != 0) {
                            this.moS = true;
                            return;
                        }
                        this.moP.reset(this.moQ - 4);
                    } else {
                        this.moP.reset(this.moQ);
                    }
                    this.moO.I(this.moP);
                    this.mmK = 0;
                }
            }
        }
    }
}
