package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s miE;
    private com.google.android.exoplayer2.extractor.g mkC;
    private final SparseArray<a> mnJ;
    private final com.google.android.exoplayer2.util.l mnK;
    private boolean mnL;
    private boolean mnM;
    private boolean mnN;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.miE = sVar;
        this.mnK = new com.google.android.exoplayer2.util.l(4096);
        this.mnJ = new SparseArray<>();
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
        this.mkC = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.miE.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mnJ.size()) {
                this.mnJ.valueAt(i2).cxF();
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
        if (fVar.e(this.mnK.data, 0, 4, true)) {
            this.mnK.setPosition(0);
            int readInt = this.mnK.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.o(this.mnK.data, 0, 10);
                    this.mnK.setPosition(9);
                    fVar.Jq((this.mnK.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.o(this.mnK.data, 0, 2);
                    this.mnK.setPosition(0);
                    fVar.Jq(this.mnK.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jq(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mnJ.get(i);
                    if (!this.mnL) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.mnM && i == 189) {
                                hVar = new b();
                                this.mnM = true;
                            } else if (!this.mnM && (i & 224) == 192) {
                                hVar = new n();
                                this.mnM = true;
                            } else if (!this.mnN && (i & 240) == 224) {
                                hVar = new i();
                                this.mnN = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mkC, new w.d(i, 256));
                                aVar = new a(hVar, this.miE);
                                this.mnJ.put(i, aVar);
                            }
                        }
                        if ((this.mnM && this.mnN) || fVar.getPosition() > 1048576) {
                            this.mnL = true;
                            this.mkC.dtF();
                        }
                    }
                    fVar.o(this.mnK.data, 0, 2);
                    this.mnK.setPosition(0);
                    int readUnsignedShort = this.mnK.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jq(readUnsignedShort);
                    } else {
                        this.mnK.reset(readUnsignedShort);
                        fVar.readFully(this.mnK.data, 0, readUnsignedShort);
                        this.mnK.setPosition(6);
                        aVar.I(this.mnK);
                        this.mnK.setLimit(this.mnK.capacity());
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
        private long mcQ;
        private final com.google.android.exoplayer2.util.s miE;
        private final com.google.android.exoplayer2.util.k mnD = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean mnE;
        private boolean mnF;
        private boolean mnG;
        private int mnH;
        private final h mnO;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.mnO = hVar;
            this.miE = sVar;
        }

        public void cxF() {
            this.mnG = false;
            this.mnO.cxF();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.C(this.mnD.data, 0, 3);
            this.mnD.setPosition(0);
            dub();
            lVar.C(this.mnD.data, 0, this.mnH);
            this.mnD.setPosition(0);
            dul();
            this.mnO.m(this.mcQ, true);
            this.mnO.I(lVar);
            this.mnO.dua();
        }

        private void dub() {
            this.mnD.JP(8);
            this.mnE = this.mnD.dtY();
            this.mnF = this.mnD.dtY();
            this.mnD.JP(6);
            this.mnH = this.mnD.readBits(8);
        }

        private void dul() {
            this.mcQ = 0L;
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
}
