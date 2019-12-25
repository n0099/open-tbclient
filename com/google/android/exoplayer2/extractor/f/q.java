package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s meN;
    private com.google.android.exoplayer2.extractor.g mgL;
    private final SparseArray<a> mjV;
    private final com.google.android.exoplayer2.util.l mjW;
    private boolean mjX;
    private boolean mjY;
    private boolean mjZ;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.meN = sVar;
        this.mjW = new com.google.android.exoplayer2.util.l(4096);
        this.mjV = new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        fVar.p(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            fVar.Ji(bArr[13] & 7);
            fVar.p(bArr, 0, 3);
            return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mgL = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.meN.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mjV.size()) {
                this.mjV.valueAt(i2).cwy();
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
        if (fVar.e(this.mjW.data, 0, 4, true)) {
            this.mjW.setPosition(0);
            int readInt = this.mjW.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.p(this.mjW.data, 0, 10);
                    this.mjW.setPosition(9);
                    fVar.Jh((this.mjW.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.p(this.mjW.data, 0, 2);
                    this.mjW.setPosition(0);
                    fVar.Jh(this.mjW.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jh(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mjV.get(i);
                    if (!this.mjX) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.mjY && i == 189) {
                                hVar = new b();
                                this.mjY = true;
                            } else if (!this.mjY && (i & 224) == 192) {
                                hVar = new n();
                                this.mjY = true;
                            } else if (!this.mjZ && (i & 240) == 224) {
                                hVar = new i();
                                this.mjZ = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mgL, new w.d(i, 256));
                                aVar = new a(hVar, this.meN);
                                this.mjV.put(i, aVar);
                            }
                        }
                        if ((this.mjY && this.mjZ) || fVar.getPosition() > 1048576) {
                            this.mjX = true;
                            this.mgL.dst();
                        }
                    }
                    fVar.p(this.mjW.data, 0, 2);
                    this.mjW.setPosition(0);
                    int readUnsignedShort = this.mjW.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jh(readUnsignedShort);
                    } else {
                        this.mjW.reset(readUnsignedShort);
                        fVar.readFully(this.mjW.data, 0, readUnsignedShort);
                        this.mjW.setPosition(6);
                        aVar.I(this.mjW);
                        this.mjW.setLimit(this.mjW.capacity());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    /* loaded from: classes4.dex */
    private static final class a {
        private long lYY;
        private final com.google.android.exoplayer2.util.s meN;
        private final com.google.android.exoplayer2.util.k mjP = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean mjQ;
        private boolean mjR;
        private boolean mjS;
        private int mjT;
        private final h mka;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.mka = hVar;
            this.meN = sVar;
        }

        public void cwy() {
            this.mjS = false;
            this.mka.cwy();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.D(this.mjP.data, 0, 3);
            this.mjP.setPosition(0);
            dsP();
            lVar.D(this.mjP.data, 0, this.mjT);
            this.mjP.setPosition(0);
            dsZ();
            this.mka.m(this.lYY, true);
            this.mka.I(lVar);
            this.mka.dsO();
        }

        private void dsP() {
            this.mjP.JG(8);
            this.mjQ = this.mjP.dsM();
            this.mjR = this.mjP.dsM();
            this.mjP.JG(6);
            this.mjT = this.mjP.readBits(8);
        }

        private void dsZ() {
            this.lYY = 0L;
            if (this.mjQ) {
                this.mjP.JG(4);
                this.mjP.JG(1);
                long readBits = (this.mjP.readBits(3) << 30) | (this.mjP.readBits(15) << 15);
                this.mjP.JG(1);
                long readBits2 = readBits | this.mjP.readBits(15);
                this.mjP.JG(1);
                if (!this.mjS && this.mjR) {
                    this.mjP.JG(4);
                    this.mjP.JG(1);
                    long readBits3 = (this.mjP.readBits(3) << 30) | (this.mjP.readBits(15) << 15);
                    this.mjP.JG(1);
                    long readBits4 = readBits3 | this.mjP.readBits(15);
                    this.mjP.JG(1);
                    this.meN.gF(readBits4);
                    this.mjS = true;
                }
                this.lYY = this.meN.gF(readBits2);
            }
        }
    }
}
