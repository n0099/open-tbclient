package com.google.android.exoplayer2.extractor.f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class q implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.q.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new q()};
        }
    };
    private final com.google.android.exoplayer2.util.s mli;
    private com.google.android.exoplayer2.extractor.g mng;
    private final SparseArray<a> mqo;
    private final com.google.android.exoplayer2.util.l mqp;
    private boolean mqq;
    private boolean mqr;
    private boolean mqs;

    public q() {
        this(new com.google.android.exoplayer2.util.s(0L));
    }

    public q(com.google.android.exoplayer2.util.s sVar) {
        this.mli = sVar;
        this.mqp = new com.google.android.exoplayer2.util.l(4096);
        this.mqo = new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        fVar.s(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            fVar.JC(bArr[13] & 7);
            fVar.s(bArr, 0, 3);
            return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mng = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mli.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mqo.size()) {
                this.mqo.valueAt(i2).czx();
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
        if (fVar.e(this.mqp.data, 0, 4, true)) {
            this.mqp.setPosition(0);
            int readInt = this.mqp.readInt();
            if (readInt != 441) {
                if (readInt == 442) {
                    fVar.s(this.mqp.data, 0, 10);
                    this.mqp.setPosition(9);
                    fVar.JB((this.mqp.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    fVar.s(this.mqp.data, 0, 2);
                    this.mqp.setPosition(0);
                    fVar.JB(this.mqp.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.JB(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    a aVar = this.mqo.get(i);
                    if (!this.mqq) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.mqr && i == 189) {
                                hVar = new b();
                                this.mqr = true;
                            } else if (!this.mqr && (i & 224) == 192) {
                                hVar = new n();
                                this.mqr = true;
                            } else if (!this.mqs && (i & 240) == 224) {
                                hVar = new i();
                                this.mqs = true;
                            }
                            if (hVar != null) {
                                hVar.a(this.mng, new w.d(i, 256));
                                aVar = new a(hVar, this.mli);
                                this.mqo.put(i, aVar);
                            }
                        }
                        if ((this.mqr && this.mqs) || fVar.getPosition() > 1048576) {
                            this.mqq = true;
                            this.mng.dvs();
                        }
                    }
                    fVar.s(this.mqp.data, 0, 2);
                    this.mqp.setPosition(0);
                    int readUnsignedShort = this.mqp.readUnsignedShort() + 6;
                    if (aVar == null) {
                        fVar.JB(readUnsignedShort);
                    } else {
                        this.mqp.reset(readUnsignedShort);
                        fVar.readFully(this.mqp.data, 0, readUnsignedShort);
                        this.mqp.setPosition(6);
                        aVar.I(this.mqp);
                        this.mqp.setLimit(this.mqp.capacity());
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
        private long mfu;
        private final com.google.android.exoplayer2.util.s mli;
        private final com.google.android.exoplayer2.util.k mqi = new com.google.android.exoplayer2.util.k(new byte[64]);
        private boolean mqj;
        private boolean mqk;
        private boolean mql;
        private int mqm;
        private final h mqt;

        public a(h hVar, com.google.android.exoplayer2.util.s sVar) {
            this.mqt = hVar;
            this.mli = sVar;
        }

        public void czx() {
            this.mql = false;
            this.mqt.czx();
        }

        public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            lVar.G(this.mqi.data, 0, 3);
            this.mqi.setPosition(0);
            dvO();
            lVar.G(this.mqi.data, 0, this.mqm);
            this.mqi.setPosition(0);
            dvY();
            this.mqt.p(this.mfu, true);
            this.mqt.I(lVar);
            this.mqt.dvN();
        }

        private void dvO() {
            this.mqi.Ka(8);
            this.mqj = this.mqi.dvL();
            this.mqk = this.mqi.dvL();
            this.mqi.Ka(6);
            this.mqm = this.mqi.readBits(8);
        }

        private void dvY() {
            this.mfu = 0L;
            if (this.mqj) {
                this.mqi.Ka(4);
                this.mqi.Ka(1);
                long readBits = (this.mqi.readBits(3) << 30) | (this.mqi.readBits(15) << 15);
                this.mqi.Ka(1);
                long readBits2 = readBits | this.mqi.readBits(15);
                this.mqi.Ka(1);
                if (!this.mql && this.mqk) {
                    this.mqi.Ka(4);
                    this.mqi.Ka(1);
                    long readBits3 = (this.mqi.readBits(3) << 30) | (this.mqi.readBits(15) << 15);
                    this.mqi.Ka(1);
                    long readBits4 = readBits3 | this.mqi.readBits(15);
                    this.mqi.Ka(1);
                    this.mli.gJ(readBits4);
                    this.mql = true;
                }
                this.mfu = this.mli.gJ(readBits2);
            }
        }
    }
}
