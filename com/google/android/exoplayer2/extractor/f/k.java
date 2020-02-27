package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class k implements h {
    private com.google.android.exoplayer2.extractor.m meJ;
    private boolean met;
    private String mmG;
    private long mmX;
    private a mnK;
    private final t mne;
    private long totalBytesWritten;
    private final boolean[] mmU = new boolean[3];
    private final o mnL = new o(32, 128);
    private final o mnh = new o(33, 128);
    private final o mni = new o(34, 128);
    private final o mnM = new o(39, 128);
    private final o mnN = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mnl = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.mne = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        com.google.android.exoplayer2.util.j.b(this.mmU);
        this.mnL.reset();
        this.mnh.reset();
        this.mni.reset();
        this.mnM.reset();
        this.mnN.reset();
        this.mnK.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmG = dVar.dvE();
        this.meJ = gVar.dK(dVar.dvD(), 2);
        this.mnK = new a(this.meJ);
        this.mne.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmX = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzr() > 0) {
            int position = lVar.getPosition();
            int dzs = lVar.dzs();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dzr();
            this.meJ.a(lVar, lVar.dzr());
            while (position < dzs) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzs, this.mmU);
                if (a2 == dzs) {
                    v(bArr, position, dzs);
                    return;
                }
                int H = com.google.android.exoplayer2.util.j.H(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    v(bArr, position, a2);
                }
                int i2 = dzs - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.mmX);
                b(j, i2, H, this.mmX);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.met) {
            this.mnK.b(j, i, i2, j2);
        } else {
            this.mnL.JZ(i2);
            this.mnh.JZ(i2);
            this.mni.JZ(i2);
        }
        this.mnM.JZ(i2);
        this.mnN.JZ(i2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (this.met) {
            this.mnK.x(bArr, i, i2);
        } else {
            this.mnL.w(bArr, i, i2);
            this.mnh.w(bArr, i, i2);
            this.mni.w(bArr, i, i2);
        }
        this.mnM.w(bArr, i, i2);
        this.mnN.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.met) {
            this.mnK.B(j, i);
        } else {
            this.mnL.Ka(i2);
            this.mnh.Ka(i2);
            this.mni.Ka(i2);
            if (this.mnL.aW() && this.mnh.aW() && this.mni.aW()) {
                this.meJ.h(a(this.mmG, this.mnL, this.mnh, this.mni));
                this.met = true;
            }
        }
        if (this.mnM.Ka(i2)) {
            this.mnl.I(this.mnM.mol, com.google.android.exoplayer2.util.j.F(this.mnM.mol, this.mnM.mom));
            this.mnl.skipBytes(5);
            this.mne.a(j2, this.mnl);
        }
        if (this.mnN.Ka(i2)) {
            this.mnl.I(this.mnN.mol, com.google.android.exoplayer2.util.j.F(this.mnN.mol, this.mnN.mom));
            this.mnl.skipBytes(5);
            this.mne.a(j2, this.mnl);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mom + oVar2.mom + oVar3.mom];
        System.arraycopy(oVar.mol, 0, bArr, 0, oVar.mom);
        System.arraycopy(oVar2.mol, 0, bArr, oVar.mom, oVar2.mom);
        System.arraycopy(oVar3.mol, 0, bArr, oVar.mom + oVar2.mom, oVar3.mom);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.mol, 0, oVar2.mom);
        mVar.JU(44);
        int readBits = mVar.readBits(3);
        mVar.dzp();
        mVar.JU(88);
        mVar.JU(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dvl()) {
                i += 89;
            }
            if (mVar.dvl()) {
                i += 8;
            }
        }
        mVar.JU(i);
        if (readBits > 0) {
            mVar.JU((8 - readBits) * 2);
        }
        mVar.dzI();
        int dzI = mVar.dzI();
        if (dzI == 3) {
            mVar.dzp();
        }
        int dzI2 = mVar.dzI();
        int dzI3 = mVar.dzI();
        if (mVar.dvl()) {
            int dzI4 = mVar.dzI();
            int dzI5 = mVar.dzI();
            int dzI6 = mVar.dzI();
            int dzI7 = mVar.dzI();
            dzI2 -= ((dzI == 1 || dzI == 2) ? 2 : 1) * (dzI4 + dzI5);
            dzI3 -= (dzI == 1 ? 2 : 1) * (dzI6 + dzI7);
        }
        mVar.dzI();
        mVar.dzI();
        int dzI8 = mVar.dzI();
        for (int i3 = mVar.dvl() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dzI();
            mVar.dzI();
            mVar.dzI();
        }
        mVar.dzI();
        mVar.dzI();
        mVar.dzI();
        mVar.dzI();
        mVar.dzI();
        mVar.dzI();
        if (mVar.dvl() && mVar.dvl()) {
            a(mVar);
        }
        mVar.JU(2);
        if (mVar.dvl()) {
            mVar.JU(8);
            mVar.dzI();
            mVar.dzI();
            mVar.dzp();
        }
        b(mVar);
        if (mVar.dvl()) {
            for (int i4 = 0; i4 < mVar.dzI(); i4++) {
                mVar.JU(dzI8 + 4 + 1);
            }
        }
        mVar.JU(2);
        float f2 = 1.0f;
        if (mVar.dvl() && mVar.dvl()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mHk.length) {
                f = com.google.android.exoplayer2.util.j.mHk[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dzI2, dzI3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dzI2, dzI3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dvl()) {
                    mVar.dzI();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dzJ();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dzJ();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dzI = mVar.dzI();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dzI) {
            boolean dvl = i != 0 ? mVar.dvl() : z;
            if (dvl) {
                mVar.dzp();
                mVar.dzI();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dvl()) {
                        mVar.dzp();
                    }
                }
            } else {
                int dzI2 = mVar.dzI();
                int dzI3 = mVar.dzI();
                i2 = dzI2 + dzI3;
                for (int i4 = 0; i4 < dzI2; i4++) {
                    mVar.dzI();
                    mVar.dzp();
                }
                for (int i5 = 0; i5 < dzI3; i5++) {
                    mVar.dzI();
                    mVar.dzp();
                }
            }
            i++;
            z = dvl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m meJ;
        private long mmR;
        private long mmY;
        private boolean mmZ;
        private boolean mnO;
        private int mnP;
        private boolean mnQ;
        private boolean mnR;
        private boolean mnS;
        private boolean mnT;
        private long mnq;
        private long mnr;
        private boolean mnu;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.meJ = mVar;
        }

        public void reset() {
            this.mnQ = false;
            this.mnR = false;
            this.mnS = false;
            this.mnu = false;
            this.mnT = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mnR = false;
            this.mnS = false;
            this.mnr = j2;
            this.mnP = 0;
            this.mnq = j;
            if (i2 >= 32) {
                if (!this.mnT && this.mnu) {
                    JW(i);
                    this.mnu = false;
                }
                if (i2 <= 34) {
                    this.mnS = !this.mnT;
                    this.mnT = true;
                }
            }
            this.mnO = i2 >= 16 && i2 <= 21;
            if (this.mnO || i2 <= 9) {
                z = true;
            }
            this.mnQ = z;
        }

        public void x(byte[] bArr, int i, int i2) {
            if (this.mnQ) {
                int i3 = (i + 2) - this.mnP;
                if (i3 < i2) {
                    this.mnR = (bArr[i3] & 128) != 0;
                    this.mnQ = false;
                    return;
                }
                this.mnP += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mnT && this.mnR) {
                this.mmZ = this.mnO;
                this.mnT = false;
            } else if (this.mnS || this.mnR) {
                if (this.mnu) {
                    JW(((int) (j - this.mnq)) + i);
                }
                this.mmY = this.mnq;
                this.mmR = this.mnr;
                this.mnu = true;
                this.mmZ = this.mnO;
            }
        }

        private void JW(int i) {
            this.meJ.a(this.mmR, this.mmZ ? 1 : 0, (int) (this.mnq - this.mmY), i, null);
        }
    }
}
