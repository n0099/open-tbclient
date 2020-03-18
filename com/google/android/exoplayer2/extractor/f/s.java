package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes6.dex */
public final class s implements w {
    private int mor;
    private final r mqu;
    private final com.google.android.exoplayer2.util.l mqv = new com.google.android.exoplayer2.util.l(32);
    private int mqw;
    private boolean mqx;
    private boolean mqy;

    public s(r rVar) {
        this.mqu = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mqu.a(sVar, gVar, dVar);
        this.mqy = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void czx() {
        this.mqy = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.mqy) {
            if (z) {
                this.mqy = false;
                lVar.setPosition(readUnsignedByte);
                this.mor = 0;
            } else {
                return;
            }
        }
        while (lVar.dzR() > 0) {
            if (this.mor < 3) {
                if (this.mor == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.mqy = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dzR(), 3 - this.mor);
                lVar.G(this.mqv.data, this.mor, min);
                this.mor = min + this.mor;
                if (this.mor == 3) {
                    this.mqv.reset(3);
                    this.mqv.skipBytes(1);
                    int readUnsignedByte3 = this.mqv.readUnsignedByte();
                    int readUnsignedByte4 = this.mqv.readUnsignedByte();
                    this.mqx = (readUnsignedByte3 & 128) != 0;
                    this.mqw = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.mqv.capacity() < this.mqw) {
                        byte[] bArr = this.mqv.data;
                        this.mqv.reset(Math.min(4098, Math.max(this.mqw, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.mqv.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dzR(), this.mqw - this.mor);
                lVar.G(this.mqv.data, this.mor, min2);
                this.mor = min2 + this.mor;
                if (this.mor != this.mqw) {
                    continue;
                } else {
                    if (this.mqx) {
                        if (com.google.android.exoplayer2.util.v.e(this.mqv.data, 0, this.mqw, -1) != 0) {
                            this.mqy = true;
                            return;
                        }
                        this.mqv.reset(this.mqw - 4);
                    } else {
                        this.mqv.reset(this.mqw);
                    }
                    this.mqu.I(this.mqv);
                    this.mor = 0;
                }
            }
        }
    }
}
