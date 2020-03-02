package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mex = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duT() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s mjr;
    private com.google.android.exoplayer2.extractor.g mlp;
    private boolean moA;
    private boolean moB;
    private final SparseArray<a> mox;
    private final com.google.android.exoplayer2.util.l moy;
    private boolean moz;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.mjr = sVar;
        this.moy = new com.google.android.exoplayer2.util.l(4096);
        this.mox = new SparseArray<>();
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
        this.mlp = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mjr.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mox.size()) {
                this.mox.valueAt(i2).czd();
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
        if (fVar.e(this.moy.data, 0, 4, true)) {
            this.moy.setPosition(0);
            int readInt = this.moy.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.s(this.moy.data, 0, 10);
                    this.moy.setPosition(9);
                    fVar.Jv((this.moy.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.s(this.moy.data, 0, 2);
                    this.moy.setPosition(0);
                    fVar.Jv(this.moy.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jv(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mox.get(i);
                    if (!this.moz) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.moA && i == 189) {
                                hVar = new b();
                                this.moA = true;
                            } else if (!this.moA && (i & 224) == 192) {
                                hVar = new n();
                                this.moA = true;
                            } else if (!this.moB && (i & 240) == 224) {
                                hVar = new i();
                                this.moB = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mlp, new w.d(i, 256));
                                aVar = new a(hVar, this.mjr);
                                this.mox.put(i, aVar);
                            }
                        }
                        if ((this.moA && this.moB) || fVar.getPosition() > 1048576) {
                            this.moz = true;
                            this.mlp.duU();
                        }
                    }
                    fVar.s(this.moy.data, 0, 2);
                    this.moy.setPosition(0);
                    int readUnsignedShort = this.moy.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jv(readUnsignedShort);
                    } else {
                        this.moy.reset(readUnsignedShort);
                        fVar.readFully(this.moy.data, 0, readUnsignedShort);
                        this.moy.setPosition(6);
                        aVar.I(this.moy);
                        this.moy.setLimit(this.moy.capacity());
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
        private long mdD;
        private final com.google.android.exoplayer2.util.s mjr;
        private final h moC;
        private final com.google.android.exoplayer2.util.k mor = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean mos;
        private boolean mot;
        private boolean mou;
        private int mov;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.moC = hVar;
            this.mjr = sVar;
        }

        public void czd() {
            this.mou = false;
            this.moC.czd();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.G(this.mor.data, 0, 3);
            this.mor.setPosition(0);
            dvq();
            lVar.G(this.mor.data, 0, this.mov);
            this.mor.setPosition(0);
            dvA();
            this.moC.o(this.mdD, true);
            this.moC.I(lVar);
            this.moC.dvp();
        }

        private void dvq() {
            this.mor.JU(8);
            this.mos = this.mor.dvn();
            this.mot = this.mor.dvn();
            this.mor.JU(6);
            this.mov = this.mor.readBits(8);
        }

        private void dvA() {
            this.mdD = 0L;
            if (this.mos) {
                this.mor.JU(4);
                this.mor.JU(1);
                long readBits = (this.mor.readBits(3) << 30) | (this.mor.readBits(15) << 15);
                this.mor.JU(1);
                long readBits2 = readBits | this.mor.readBits(15);
                this.mor.JU(1);
                if (!this.mou && this.mot) {
                    this.mor.JU(4);
                    this.mor.JU(1);
                    long readBits3 = (this.mor.readBits(3) << 30) | (this.mor.readBits(15) << 15);
                    this.mor.JU(1);
                    long readBits4 = readBits3 | this.mor.readBits(15);
                    this.mor.JU(1);
                    this.mjr.gI(readBits4);
                    this.mou = true;
                }
                this.mdD = this.mjr.gI(readBits2);
            }
        }
    }
}
