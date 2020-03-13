package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h meI = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s mjC;
    private com.google.android.exoplayer2.extractor.g mlA;
    private final SparseArray<a> moI;
    private final com.google.android.exoplayer2.util.l moJ;
    private boolean moK;
    private boolean moL;
    private boolean moM;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.mjC = sVar;
        this.moJ = new com.google.android.exoplayer2.util.l(4096);
        this.moI = new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        fVar.s(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            fVar.Jw(bArr[13] & 7);
            fVar.s(bArr, 0, 3);
            return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mlA = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mjC.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.moI.size()) {
                this.moI.valueAt(i2).cze();
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
        if (fVar.e(this.moJ.data, 0, 4, true)) {
            this.moJ.setPosition(0);
            int readInt = this.moJ.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.s(this.moJ.data, 0, 10);
                    this.moJ.setPosition(9);
                    fVar.Jv((this.moJ.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.s(this.moJ.data, 0, 2);
                    this.moJ.setPosition(0);
                    fVar.Jv(this.moJ.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jv(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.moI.get(i);
                    if (!this.moK) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.moL && i == 189) {
                                hVar = new b();
                                this.moL = true;
                            } else if (!this.moL && (i & 224) == 192) {
                                hVar = new n();
                                this.moL = true;
                            } else if (!this.moM && (i & 240) == 224) {
                                hVar = new i();
                                this.moM = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mlA, new w.d(i, 256));
                                aVar = new a(hVar, this.mjC);
                                this.moI.put(i, aVar);
                            }
                        }
                        if ((this.moL && this.moM) || fVar.getPosition() > 1048576) {
                            this.moK = true;
                            this.mlA.duV();
                        }
                    }
                    fVar.s(this.moJ.data, 0, 2);
                    this.moJ.setPosition(0);
                    int readUnsignedShort = this.moJ.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jv(readUnsignedShort);
                    } else {
                        this.moJ.reset(readUnsignedShort);
                        fVar.readFully(this.moJ.data, 0, readUnsignedShort);
                        this.moJ.setPosition(6);
                        aVar.I(this.moJ);
                        this.moJ.setLimit(this.moJ.capacity());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    /* loaded from: classes6.dex */
    private static final class a {
        private long mdO;
        private final com.google.android.exoplayer2.util.s mjC;
        private final com.google.android.exoplayer2.util.k moC = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean moD;
        private boolean moE;
        private boolean moF;
        private int moG;
        private final h moN;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.moN = hVar;
            this.mjC = sVar;
        }

        public void cze() {
            this.moF = false;
            this.moN.cze();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.G(this.moC.data, 0, 3);
            this.moC.setPosition(0);
            dvr();
            lVar.G(this.moC.data, 0, this.moG);
            this.moC.setPosition(0);
            dvB();
            this.moN.o(this.mdO, true);
            this.moN.I(lVar);
            this.moN.dvq();
        }

        private void dvr() {
            this.moC.JU(8);
            this.moD = this.moC.dvo();
            this.moE = this.moC.dvo();
            this.moC.JU(6);
            this.moG = this.moC.readBits(8);
        }

        private void dvB() {
            this.mdO = 0L;
            if (this.moD) {
                this.moC.JU(4);
                this.moC.JU(1);
                long readBits = (this.moC.readBits(3) << 30) | (this.moC.readBits(15) << 15);
                this.moC.JU(1);
                long readBits2 = readBits | this.moC.readBits(15);
                this.moC.JU(1);
                if (!this.moF && this.moE) {
                    this.moC.JU(4);
                    this.moC.JU(1);
                    long readBits3 = (this.moC.readBits(3) << 30) | (this.moC.readBits(15) << 15);
                    this.moC.JU(1);
                    long readBits4 = readBits3 | this.moC.readBits(15);
                    this.moC.JU(1);
                    this.mjC.gI(readBits4);
                    this.moF = true;
                }
                this.mdO = this.mjC.gI(readBits2);
            }
        }
    }
}
