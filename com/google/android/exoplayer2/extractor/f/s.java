package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes4.dex */
public final class s implements w {
    private int mhW;
    private final r mkb;
    private final com.google.android.exoplayer2.util.l mkc = new com.google.android.exoplayer2.util.l(32);
    private int mkd;
    private boolean mke;
    private boolean mkf;

    public s(r rVar) {
        this.mkb = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mkb.a(sVar, gVar, dVar);
        this.mkf = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void cwy() {
        this.mkf = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.mkf) {
            if (z) {
                this.mkf = false;
                lVar.setPosition(readUnsignedByte);
                this.mhW = 0;
            } else {
                return;
            }
        }
        while (lVar.dwV() > 0) {
            if (this.mhW < 3) {
                if (this.mhW == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.mkf = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dwV(), 3 - this.mhW);
                lVar.D(this.mkc.data, this.mhW, min);
                this.mhW = min + this.mhW;
                if (this.mhW == 3) {
                    this.mkc.reset(3);
                    this.mkc.skipBytes(1);
                    int readUnsignedByte3 = this.mkc.readUnsignedByte();
                    int readUnsignedByte4 = this.mkc.readUnsignedByte();
                    this.mke = (readUnsignedByte3 & 128) != 0;
                    this.mkd = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.mkc.capacity() < this.mkd) {
                        byte[] bArr = this.mkc.data;
                        this.mkc.reset(Math.min(4098, Math.max(this.mkd, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.mkc.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dwV(), this.mkd - this.mhW);
                lVar.D(this.mkc.data, this.mhW, min2);
                this.mhW = min2 + this.mhW;
                if (this.mhW != this.mkd) {
                    continue;
                } else {
                    if (this.mke) {
                        if (com.google.android.exoplayer2.util.v.e(this.mkc.data, 0, this.mkd, -1) != 0) {
                            this.mkf = true;
                            return;
                        }
                        this.mkc.reset(this.mkd - 4);
                    } else {
                        this.mkc.reset(this.mkd);
                    }
                    this.mkb.I(this.mkc);
                    this.mhW = 0;
                }
            }
        }
    }
}
