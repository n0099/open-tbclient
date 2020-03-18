package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class k implements h {
    private com.google.android.exoplayer2.extractor.m mgC;
    private boolean mgm;
    private String moA;
    private long moR;
    private final t moY;
    private a mpE;
    private long totalBytesWritten;
    private final boolean[] moO = new boolean[3];
    private final o mpF = new o(32, 128);
    private final o mpb = new o(33, 128);
    private final o mpc = new o(34, 128);
    private final o mpG = new o(39, 128);
    private final o mpH = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mpf = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.moY = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        com.google.android.exoplayer2.util.j.b(this.moO);
        this.mpF.reset();
        this.mpb.reset();
        this.mpc.reset();
        this.mpG.reset();
        this.mpH.reset();
        this.mpE.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moA = dVar.dwe();
        this.mgC = gVar.dL(dVar.dwd(), 2);
        this.mpE = new a(this.mgC);
        this.moY.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        this.moR = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzR() > 0) {
            int position = lVar.getPosition();
            int dzS = lVar.dzS();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dzR();
            this.mgC.a(lVar, lVar.dzR());
            while (position < dzS) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzS, this.moO);
                if (a2 == dzS) {
                    v(bArr, position, dzS);
                    return;
                }
                int H = com.google.android.exoplayer2.util.j.H(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    v(bArr, position, a2);
                }
                int i2 = dzS - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.moR);
                b(j, i2, H, this.moR);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.mgm) {
            this.mpE.b(j, i, i2, j2);
        } else {
            this.mpF.Kf(i2);
            this.mpb.Kf(i2);
            this.mpc.Kf(i2);
        }
        this.mpG.Kf(i2);
        this.mpH.Kf(i2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (this.mgm) {
            this.mpE.x(bArr, i, i2);
        } else {
            this.mpF.w(bArr, i, i2);
            this.mpb.w(bArr, i, i2);
            this.mpc.w(bArr, i, i2);
        }
        this.mpG.w(bArr, i, i2);
        this.mpH.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.mgm) {
            this.mpE.B(j, i);
        } else {
            this.mpF.Kg(i2);
            this.mpb.Kg(i2);
            this.mpc.Kg(i2);
            if (this.mpF.aW() && this.mpb.aW() && this.mpc.aW()) {
                this.mgC.h(a(this.moA, this.mpF, this.mpb, this.mpc));
                this.mgm = true;
            }
        }
        if (this.mpG.Kg(i2)) {
            this.mpf.I(this.mpG.mqf, com.google.android.exoplayer2.util.j.F(this.mpG.mqf, this.mpG.mqg));
            this.mpf.skipBytes(5);
            this.moY.a(j2, this.mpf);
        }
        if (this.mpH.Kg(i2)) {
            this.mpf.I(this.mpH.mqf, com.google.android.exoplayer2.util.j.F(this.mpH.mqf, this.mpH.mqg));
            this.mpf.skipBytes(5);
            this.moY.a(j2, this.mpf);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mqg + oVar2.mqg + oVar3.mqg];
        System.arraycopy(oVar.mqf, 0, bArr, 0, oVar.mqg);
        System.arraycopy(oVar2.mqf, 0, bArr, oVar.mqg, oVar2.mqg);
        System.arraycopy(oVar3.mqf, 0, bArr, oVar.mqg + oVar2.mqg, oVar3.mqg);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.mqf, 0, oVar2.mqg);
        mVar.Ka(44);
        int readBits = mVar.readBits(3);
        mVar.dzP();
        mVar.Ka(88);
        mVar.Ka(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dvL()) {
                i += 89;
            }
            if (mVar.dvL()) {
                i += 8;
            }
        }
        mVar.Ka(i);
        if (readBits > 0) {
            mVar.Ka((8 - readBits) * 2);
        }
        mVar.dAi();
        int dAi = mVar.dAi();
        if (dAi == 3) {
            mVar.dzP();
        }
        int dAi2 = mVar.dAi();
        int dAi3 = mVar.dAi();
        if (mVar.dvL()) {
            int dAi4 = mVar.dAi();
            int dAi5 = mVar.dAi();
            int dAi6 = mVar.dAi();
            int dAi7 = mVar.dAi();
            dAi2 -= ((dAi == 1 || dAi == 2) ? 2 : 1) * (dAi4 + dAi5);
            dAi3 -= (dAi == 1 ? 2 : 1) * (dAi6 + dAi7);
        }
        mVar.dAi();
        mVar.dAi();
        int dAi8 = mVar.dAi();
        for (int i3 = mVar.dvL() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dAi();
            mVar.dAi();
            mVar.dAi();
        }
        mVar.dAi();
        mVar.dAi();
        mVar.dAi();
        mVar.dAi();
        mVar.dAi();
        mVar.dAi();
        if (mVar.dvL() && mVar.dvL()) {
            a(mVar);
        }
        mVar.Ka(2);
        if (mVar.dvL()) {
            mVar.Ka(8);
            mVar.dAi();
            mVar.dAi();
            mVar.dzP();
        }
        b(mVar);
        if (mVar.dvL()) {
            for (int i4 = 0; i4 < mVar.dAi(); i4++) {
                mVar.Ka(dAi8 + 4 + 1);
            }
        }
        mVar.Ka(2);
        float f2 = 1.0f;
        if (mVar.dvL() && mVar.dvL()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mJh.length) {
                f = com.google.android.exoplayer2.util.j.mJh[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dAi2, dAi3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dAi2, dAi3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dvL()) {
                    mVar.dAi();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dAj();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dAj();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dAi = mVar.dAi();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dAi) {
            boolean dvL = i != 0 ? mVar.dvL() : z;
            if (dvL) {
                mVar.dzP();
                mVar.dAi();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dvL()) {
                        mVar.dzP();
                    }
                }
            } else {
                int dAi2 = mVar.dAi();
                int dAi3 = mVar.dAi();
                i2 = dAi2 + dAi3;
                for (int i4 = 0; i4 < dAi2; i4++) {
                    mVar.dAi();
                    mVar.dzP();
                }
                for (int i5 = 0; i5 < dAi3; i5++) {
                    mVar.dAi();
                    mVar.dzP();
                }
            }
            i++;
            z = dvL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m mgC;
        private long moL;
        private long moS;
        private boolean moT;
        private boolean mpI;
        private int mpJ;
        private boolean mpK;
        private boolean mpL;
        private boolean mpM;
        private boolean mpN;
        private long mpk;
        private long mpl;
        private boolean mpo;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.mgC = mVar;
        }

        public void reset() {
            this.mpK = false;
            this.mpL = false;
            this.mpM = false;
            this.mpo = false;
            this.mpN = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mpL = false;
            this.mpM = false;
            this.mpl = j2;
            this.mpJ = 0;
            this.mpk = j;
            if (i2 >= 32) {
                if (!this.mpN && this.mpo) {
                    Kc(i);
                    this.mpo = false;
                }
                if (i2 <= 34) {
                    this.mpM = !this.mpN;
                    this.mpN = true;
                }
            }
            this.mpI = i2 >= 16 && i2 <= 21;
            if (this.mpI || i2 <= 9) {
                z = true;
            }
            this.mpK = z;
        }

        public void x(byte[] bArr, int i, int i2) {
            if (this.mpK) {
                int i3 = (i + 2) - this.mpJ;
                if (i3 < i2) {
                    this.mpL = (bArr[i3] & 128) != 0;
                    this.mpK = false;
                    return;
                }
                this.mpJ += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mpN && this.mpL) {
                this.moT = this.mpI;
                this.mpN = false;
            } else if (this.mpM || this.mpL) {
                if (this.mpo) {
                    Kc(((int) (j - this.mpk)) + i);
                }
                this.moS = this.mpk;
                this.moL = this.mpl;
                this.mpo = true;
                this.moT = this.mpI;
            }
        }

        private void Kc(int i) {
            this.mgC.a(this.moL, this.moT ? 1 : 0, (int) (this.mpk - this.moS), i, null);
        }
    }
}
