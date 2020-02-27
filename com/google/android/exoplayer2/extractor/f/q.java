package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mev = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s mjp;
    private com.google.android.exoplayer2.extractor.g mln;
    private final SparseArray<a> mov;
    private final com.google.android.exoplayer2.util.l mow;
    private boolean mox;
    private boolean moy;
    private boolean moz;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.mjp = sVar;
        this.mow = new com.google.android.exoplayer2.util.l(4096);
        this.mov = new SparseArray<>();
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
        this.mln = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mjp.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mov.size()) {
                this.mov.valueAt(i2).czb();
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
        if (fVar.e(this.mow.data, 0, 4, true)) {
            this.mow.setPosition(0);
            int readInt = this.mow.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.s(this.mow.data, 0, 10);
                    this.mow.setPosition(9);
                    fVar.Jv((this.mow.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.s(this.mow.data, 0, 2);
                    this.mow.setPosition(0);
                    fVar.Jv(this.mow.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.Jv(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mov.get(i);
                    if (!this.mox) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.moy && i == 189) {
                                hVar = new b();
                                this.moy = true;
                            } else if (!this.moy && (i & 224) == 192) {
                                hVar = new n();
                                this.moy = true;
                            } else if (!this.moz && (i & 240) == 224) {
                                hVar = new i();
                                this.moz = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mln, new w.d(i, 256));
                                aVar = new a(hVar, this.mjp);
                                this.mov.put(i, aVar);
                            }
                        }
                        if ((this.moy && this.moz) || fVar.getPosition() > 1048576) {
                            this.mox = true;
                            this.mln.duS();
                        }
                    }
                    fVar.s(this.mow.data, 0, 2);
                    this.mow.setPosition(0);
                    int readUnsignedShort = this.mow.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.Jv(readUnsignedShort);
                    } else {
                        this.mow.reset(readUnsignedShort);
                        fVar.readFully(this.mow.data, 0, readUnsignedShort);
                        this.mow.setPosition(6);
                        aVar.I(this.mow);
                        this.mow.setLimit(this.mow.capacity());
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
        private long mdB;
        private final com.google.android.exoplayer2.util.s mjp;
        private final h moA;
        private final com.google.android.exoplayer2.util.k mop = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean moq;
        private boolean mor;
        private boolean mos;
        private int mot;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.moA = hVar;
            this.mjp = sVar;
        }

        public void czb() {
            this.mos = false;
            this.moA.czb();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.G(this.mop.data, 0, 3);
            this.mop.setPosition(0);
            dvo();
            lVar.G(this.mop.data, 0, this.mot);
            this.mop.setPosition(0);
            dvy();
            this.moA.o(this.mdB, true);
            this.moA.I(lVar);
            this.moA.dvn();
        }

        private void dvo() {
            this.mop.JU(8);
            this.moq = this.mop.dvl();
            this.mor = this.mop.dvl();
            this.mop.JU(6);
            this.mot = this.mop.readBits(8);
        }

        private void dvy() {
            this.mdB = 0L;
            if (this.moq) {
                this.mop.JU(4);
                this.mop.JU(1);
                long readBits = (this.mop.readBits(3) << 30) | (this.mop.readBits(15) << 15);
                this.mop.JU(1);
                long readBits2 = readBits | this.mop.readBits(15);
                this.mop.JU(1);
                if (!this.mos && this.mor) {
                    this.mop.JU(4);
                    this.mop.JU(1);
                    long readBits3 = (this.mop.readBits(3) << 30) | (this.mop.readBits(15) << 15);
                    this.mop.JU(1);
                    long readBits4 = readBits3 | this.mop.readBits(15);
                    this.mop.JU(1);
                    this.mjp.gI(readBits4);
                    this.mos = true;
                }
                this.mdB = this.mjp.gI(readBits2);
            }
        }
    }
}
