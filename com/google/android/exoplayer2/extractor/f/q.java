package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s miJ;
    private com.google.android.exoplayer2.extractor.g mkH;
    private final SparseArray<a> mnO;
    private final com.google.android.exoplayer2.util.l mnP;
    private boolean mnQ;
    private boolean mnR;
    private boolean mnS;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.miJ = sVar;
        this.mnP = new com.google.android.exoplayer2.util.l(4096);
        this.mnO = new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        fVar.o(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            fVar.Jr(bArr[13] & 7);
            fVar.o(bArr, 0, 3);
            return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mkH = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.miJ.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mnO.size()) {
                this.mnO.valueAt(i2).cxH();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        if (fVar.e(this.mnP.data, 0, 4, true)) {
            this.mnP.setPosition(0);
            int readInt = this.mnP.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.o(this.mnP.data, 0, 10);
                    this.mnP.setPosition(9);
                    fVar.Jq((this.mnP.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.o(this.mnP.data, 0, 2);
                    this.mnP.setPosition(0);
                    fVar.Jq(this.mnP.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jq(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mnO.get(i);
                    if (!this.mnQ) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.mnR && i == 189) {
                                hVar = new b();
                                this.mnR = true;
                            } else if (!this.mnR && (i & 224) == 192) {
                                hVar = new n();
                                this.mnR = true;
                            } else if (!this.mnS && (i & 240) == 224) {
                                hVar = new i();
                                this.mnS = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mkH, new w.d(i, 256));
                                aVar = new a(hVar, this.miJ);
                                this.mnO.put(i, aVar);
                            }
                        }
                        if ((this.mnR && this.mnS) || fVar.getPosition() > 1048576) {
                            this.mnQ = true;
                            this.mkH.dtH();
                        }
                    }
                    fVar.o(this.mnP.data, 0, 2);
                    this.mnP.setPosition(0);
                    int readUnsignedShort = this.mnP.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jq(readUnsignedShort);
                    } else {
                        this.mnP.reset(readUnsignedShort);
                        fVar.readFully(this.mnP.data, 0, readUnsignedShort);
                        this.mnP.setPosition(6);
                        aVar.I(this.mnP);
                        this.mnP.setLimit(this.mnP.capacity());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    /* loaded from: classes5.dex */
    private static final class a {
        private long mcV;
        private final com.google.android.exoplayer2.util.s miJ;
        private final com.google.android.exoplayer2.util.k mnI = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean mnJ;
        private boolean mnK;
        private boolean mnL;
        private int mnM;
        private final h mnT;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.mnT = hVar;
            this.miJ = sVar;
        }

        public void cxH() {
            this.mnL = false;
            this.mnT.cxH();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.C(this.mnI.data, 0, 3);
            this.mnI.setPosition(0);
            dud();
            lVar.C(this.mnI.data, 0, this.mnM);
            this.mnI.setPosition(0);
            dun();
            this.mnT.m(this.mcV, true);
            this.mnT.I(lVar);
            this.mnT.duc();
        }

        private void dud() {
            this.mnI.JP(8);
            this.mnJ = this.mnI.dua();
            this.mnK = this.mnI.dua();
            this.mnI.JP(6);
            this.mnM = this.mnI.readBits(8);
        }

        private void dun() {
            this.mcV = 0L;
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
}
