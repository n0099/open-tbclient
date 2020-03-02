package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class k implements h {
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mev;
    private String mmI;
    private long mmZ;
    private a mnM;
    private final t mng;
    private long totalBytesWritten;
    private final boolean[] mmW = new boolean[3];
    private final o mnN = new o(32, 128);
    private final o mnj = new o(33, 128);
    private final o mnk = new o(34, 128);
    private final o mnO = new o(39, 128);
    private final o mnP = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mnn = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.mng = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        com.google.android.exoplayer2.util.j.b(this.mmW);
        this.mnN.reset();
        this.mnj.reset();
        this.mnk.reset();
        this.mnO.reset();
        this.mnP.reset();
        this.mnM.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmI = dVar.dvG();
        this.meL = gVar.dK(dVar.dvF(), 2);
        this.mnM = new a(this.meL);
        this.mng.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmZ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzt() > 0) {
            int position = lVar.getPosition();
            int dzu = lVar.dzu();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dzt();
            this.meL.a(lVar, lVar.dzt());
            while (position < dzu) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzu, this.mmW);
                if (a2 == dzu) {
                    v(bArr, position, dzu);
                    return;
                }
                int H = com.google.android.exoplayer2.util.j.H(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    v(bArr, position, a2);
                }
                int i2 = dzu - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.mmZ);
                b(j, i2, H, this.mmZ);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.mev) {
            this.mnM.b(j, i, i2, j2);
        } else {
            this.mnN.JZ(i2);
            this.mnj.JZ(i2);
            this.mnk.JZ(i2);
        }
        this.mnO.JZ(i2);
        this.mnP.JZ(i2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (this.mev) {
            this.mnM.x(bArr, i, i2);
        } else {
            this.mnN.w(bArr, i, i2);
            this.mnj.w(bArr, i, i2);
            this.mnk.w(bArr, i, i2);
        }
        this.mnO.w(bArr, i, i2);
        this.mnP.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.mev) {
            this.mnM.B(j, i);
        } else {
            this.mnN.Ka(i2);
            this.mnj.Ka(i2);
            this.mnk.Ka(i2);
            if (this.mnN.aW() && this.mnj.aW() && this.mnk.aW()) {
                this.meL.h(a(this.mmI, this.mnN, this.mnj, this.mnk));
                this.mev = true;
            }
        }
        if (this.mnO.Ka(i2)) {
            this.mnn.I(this.mnO.moo, com.google.android.exoplayer2.util.j.F(this.mnO.moo, this.mnO.mop));
            this.mnn.skipBytes(5);
            this.mng.a(j2, this.mnn);
        }
        if (this.mnP.Ka(i2)) {
            this.mnn.I(this.mnP.moo, com.google.android.exoplayer2.util.j.F(this.mnP.moo, this.mnP.mop));
            this.mnn.skipBytes(5);
            this.mng.a(j2, this.mnn);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mop + oVar2.mop + oVar3.mop];
        System.arraycopy(oVar.moo, 0, bArr, 0, oVar.mop);
        System.arraycopy(oVar2.moo, 0, bArr, oVar.mop, oVar2.mop);
        System.arraycopy(oVar3.moo, 0, bArr, oVar.mop + oVar2.mop, oVar3.mop);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.moo, 0, oVar2.mop);
        mVar.JU(44);
        int readBits = mVar.readBits(3);
        mVar.dzr();
        mVar.JU(88);
        mVar.JU(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dvn()) {
                i += 89;
            }
            if (mVar.dvn()) {
                i += 8;
            }
        }
        mVar.JU(i);
        if (readBits > 0) {
            mVar.JU((8 - readBits) * 2);
        }
        mVar.dzK();
        int dzK = mVar.dzK();
        if (dzK == 3) {
            mVar.dzr();
        }
        int dzK2 = mVar.dzK();
        int dzK3 = mVar.dzK();
        if (mVar.dvn()) {
            int dzK4 = mVar.dzK();
            int dzK5 = mVar.dzK();
            int dzK6 = mVar.dzK();
            int dzK7 = mVar.dzK();
            dzK2 -= ((dzK == 1 || dzK == 2) ? 2 : 1) * (dzK4 + dzK5);
            dzK3 -= (dzK == 1 ? 2 : 1) * (dzK6 + dzK7);
        }
        mVar.dzK();
        mVar.dzK();
        int dzK8 = mVar.dzK();
        for (int i3 = mVar.dvn() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dzK();
            mVar.dzK();
            mVar.dzK();
        }
        mVar.dzK();
        mVar.dzK();
        mVar.dzK();
        mVar.dzK();
        mVar.dzK();
        mVar.dzK();
        if (mVar.dvn() && mVar.dvn()) {
            a(mVar);
        }
        mVar.JU(2);
        if (mVar.dvn()) {
            mVar.JU(8);
            mVar.dzK();
            mVar.dzK();
            mVar.dzr();
        }
        b(mVar);
        if (mVar.dvn()) {
            for (int i4 = 0; i4 < mVar.dzK(); i4++) {
                mVar.JU(dzK8 + 4 + 1);
            }
        }
        mVar.JU(2);
        float f2 = 1.0f;
        if (mVar.dvn() && mVar.dvn()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mHm.length) {
                f = com.google.android.exoplayer2.util.j.mHm[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dzK2, dzK3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dzK2, dzK3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dvn()) {
                    mVar.dzK();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dzL();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dzL();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dzK = mVar.dzK();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dzK) {
            boolean dvn = i != 0 ? mVar.dvn() : z;
            if (dvn) {
                mVar.dzr();
                mVar.dzK();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dvn()) {
                        mVar.dzr();
                    }
                }
            } else {
                int dzK2 = mVar.dzK();
                int dzK3 = mVar.dzK();
                i2 = dzK2 + dzK3;
                for (int i4 = 0; i4 < dzK2; i4++) {
                    mVar.dzK();
                    mVar.dzr();
                }
                for (int i5 = 0; i5 < dzK3; i5++) {
                    mVar.dzK();
                    mVar.dzr();
                }
            }
            i++;
            z = dvn;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m meL;
        private long mmT;
        private boolean mnQ;
        private int mnR;
        private boolean mnS;
        private boolean mnT;
        private boolean mnU;
        private boolean mnV;
        private long mna;
        private boolean mnb;
        private long mns;
        private long mnt;
        private boolean mnw;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.meL = mVar;
        }

        public void reset() {
            this.mnS = false;
            this.mnT = false;
            this.mnU = false;
            this.mnw = false;
            this.mnV = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mnT = false;
            this.mnU = false;
            this.mnt = j2;
            this.mnR = 0;
            this.mns = j;
            if (i2 >= 32) {
                if (!this.mnV && this.mnw) {
                    JW(i);
                    this.mnw = false;
                }
                if (i2 <= 34) {
                    this.mnU = !this.mnV;
                    this.mnV = true;
                }
            }
            this.mnQ = i2 >= 16 && i2 <= 21;
            if (this.mnQ || i2 <= 9) {
                z = true;
            }
            this.mnS = z;
        }

        public void x(byte[] bArr, int i, int i2) {
            if (this.mnS) {
                int i3 = (i + 2) - this.mnR;
                if (i3 < i2) {
                    this.mnT = (bArr[i3] & 128) != 0;
                    this.mnS = false;
                    return;
                }
                this.mnR += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mnV && this.mnT) {
                this.mnb = this.mnQ;
                this.mnV = false;
            } else if (this.mnU || this.mnT) {
                if (this.mnw) {
                    JW(((int) (j - this.mns)) + i);
                }
                this.mna = this.mns;
                this.mmT = this.mnt;
                this.mnw = true;
                this.mnb = this.mnQ;
            }
        }

        private void JW(int i) {
            this.meL.a(this.mmT, this.mnb ? 1 : 0, (int) (this.mns - this.mna), i, null);
        }
    }
}
