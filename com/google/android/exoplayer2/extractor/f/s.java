package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
/* loaded from: classes5.dex */
public final class s implements w {
    private int mlM;
    private final r mnP;
    private final com.google.android.exoplayer2.util.l mnQ = new com.google.android.exoplayer2.util.l(32);
    private int mnR;
    private boolean mnS;
    private boolean mnT;

    public s(r rVar) {
        this.mnP = rVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        this.mnP.a(sVar, gVar, dVar);
        this.mnT = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void cxF() {
        this.mnT = true;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w
    public void a(com.google.android.exoplayer2.util.l lVar, boolean z) {
        int readUnsignedByte = z ? lVar.readUnsignedByte() + lVar.getPosition() : -1;
        if (this.mnT) {
            if (z) {
                this.mnT = false;
                lVar.setPosition(readUnsignedByte);
                this.mlM = 0;
            } else {
                return;
            }
        }
        while (lVar.dyf() > 0) {
            if (this.mlM < 3) {
                if (this.mlM == 0) {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (readUnsignedByte2 == 255) {
                        this.mnT = true;
                        return;
                    }
                }
                int min = Math.min(lVar.dyf(), 3 - this.mlM);
                lVar.C(this.mnQ.data, this.mlM, min);
                this.mlM = min + this.mlM;
                if (this.mlM == 3) {
                    this.mnQ.reset(3);
                    this.mnQ.skipBytes(1);
                    int readUnsignedByte3 = this.mnQ.readUnsignedByte();
                    int readUnsignedByte4 = this.mnQ.readUnsignedByte();
                    this.mnS = (readUnsignedByte3 & 128) != 0;
                    this.mnR = (((readUnsignedByte3 & 15) << 8) | readUnsignedByte4) + 3;
                    if (this.mnQ.capacity() < this.mnR) {
                        byte[] bArr = this.mnQ.data;
                        this.mnQ.reset(Math.min(4098, Math.max(this.mnR, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.mnQ.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.dyf(), this.mnR - this.mlM);
                lVar.C(this.mnQ.data, this.mlM, min2);
                this.mlM = min2 + this.mlM;
                if (this.mlM != this.mnR) {
                    continue;
                } else {
                    if (this.mnS) {
                        if (com.google.android.exoplayer2.util.v.e(this.mnQ.data, 0, this.mnR, -1) != 0) {
                            this.mnT = true;
                            return;
                        }
                        this.mnQ.reset(this.mnR - 4);
                    } else {
                        this.mnQ.reset(this.mnR);
                    }
                    this.mnP.I(this.mnQ);
                    this.mlM = 0;
                }
            }
        }
    }
}
