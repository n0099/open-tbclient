package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class s implements w {
    private int mmx;
    private final r moB;
    private final com.google.android.exoplayer2.util.l moC = new com.google.android.exoplayer2.util.l(32);
    private int moD;
    private boolean moE;
    private boolean moF;

    public s(r rVar) {
        this.moB = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.moB.a(sVar, gVar, dVar);
        this.moF = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void czb() {
        this.moF = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.moF) {
            if (z) {
                this.moF = false;
                lVar.setPosition(readUnsignedByte);
                this.mmx = 0;
            } else {
                return;
            }
        }
        while (lVar.dzr() > 0) {
            if (this.mmx < 3) {
                if (this.mmx == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.moF = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dzr(), 3 - this.mmx);
                lVar.G(this.moC.data, this.mmx, min);
                this.mmx = min + this.mmx;
                if (this.mmx == 3) {
                    this.moC.reset(3);
                    this.moC.skipBytes(1);
                    int readUnsignedByte3 = this.moC.readUnsignedByte();
                    int readUnsignedByte4 = this.moC.readUnsignedByte();
                    this.moE = (readUnsignedByte3 & 128) != 0;
                    this.moD = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.moC.capacity() < this.moD) {
                        byte[] bArr = this.moC.data;
                        this.moC.reset(Math.min(4098, Math.max(this.moD, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.moC.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dzr(), this.moD - this.mmx);
                lVar.G(this.moC.data, this.mmx, min2);
                this.mmx = min2 + this.mmx;
                if (this.mmx != this.moD) {
                    continue;
                } else {
                    if (this.moE) {
                        if (com.google.android.exoplayer2.util.v.e(this.moC.data, 0, this.moD, -1) != 0) {
                            this.moF = true;
                            return;
                        }
                        this.moC.reset(this.moD - 4);
                    } else {
                        this.moC.reset(this.moD);
                    }
                    this.moB.I(this.moC);
                    this.mmx = 0;
                }
            }
        }
    }
}
