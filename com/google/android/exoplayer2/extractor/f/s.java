package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class s implements w {
    private int mmz;
    private final r moD;
    private final com.google.android.exoplayer2.util.l moE = new com.google.android.exoplayer2.util.l(32);
    private int moF;
    private boolean moG;
    private boolean moH;

    public s(r rVar) {
        this.moD = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.moD.a(sVar, gVar, dVar);
        this.moH = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void czd() {
        this.moH = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.moH) {
            if (z) {
                this.moH = false;
                lVar.setPosition(readUnsignedByte);
                this.mmz = 0;
            } else {
                return;
            }
        }
        while (lVar.dzt() > 0) {
            if (this.mmz < 3) {
                if (this.mmz == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.moH = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dzt(), 3 - this.mmz);
                lVar.G(this.moE.data, this.mmz, min);
                this.mmz = min + this.mmz;
                if (this.mmz == 3) {
                    this.moE.reset(3);
                    this.moE.skipBytes(1);
                    int readUnsignedByte3 = this.moE.readUnsignedByte();
                    int readUnsignedByte4 = this.moE.readUnsignedByte();
                    this.moG = (readUnsignedByte3 & 128) != 0;
                    this.moF = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.moE.capacity() < this.moF) {
                        byte[] bArr = this.moE.data;
                        this.moE.reset(Math.min(4098, Math.max(this.moF, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.moE.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dzt(), this.moF - this.mmz);
                lVar.G(this.moE.data, this.mmz, min2);
                this.mmz = min2 + this.mmz;
                if (this.mmz != this.moF) {
                    continue;
                } else {
                    if (this.moG) {
                        if (com.google.android.exoplayer2.util.v.e(this.moE.data, 0, this.moF, -1) != 0) {
                            this.moH = true;
                            return;
                        }
                        this.moE.reset(this.moF - 4);
                    } else {
                        this.moE.reset(this.moF);
                    }
                    this.moD.I(this.moE);
                    this.mmz = 0;
                }
            }
        }
    }
}
