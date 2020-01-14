package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class k implements h {
    private boolean mdN;
    private com.google.android.exoplayer2.extractor.m med;
    private String mma;
    private long mmr;
    private final t mmy;
    private a mne;
    private long totalBytesWritten;
    private final boolean[] mmo = new boolean[3];
    private final o mnf = new o(32, 128);
    private final o mmB = new o(33, 128);
    private final o mmC = new o(34, 128);
    private final o mng = new o(39, 128);
    private final o mnh = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mmF = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.mmy = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        com.google.android.exoplayer2.util.j.b(this.mmo);
        this.mnf.reset();
        this.mmB.reset();
        this.mmC.reset();
        this.mng.reset();
        this.mnh.reset();
        this.mne.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mma = dVar.dut();
        this.med = gVar.dH(dVar.dus(), 2);
        this.mne = new a(this.med);
        this.mmy.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmr = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyh() > 0) {
            int position = lVar.getPosition();
            int dyi = lVar.dyi();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dyh();
            this.med.a(lVar, lVar.dyh());
            while (position < dyi) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyi, this.mmo);
                if (a2 == dyi) {
                    r(bArr, position, dyi);
                    return;
                }
                int F = com.google.android.exoplayer2.util.j.F(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    r(bArr, position, a2);
                }
                int i2 = dyi - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.mmr);
                b(j, i2, F, this.mmr);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.mdN) {
            this.mne.b(j, i, i2, j2);
        } else {
            this.mnf.JU(i2);
            this.mmB.JU(i2);
            this.mmC.JU(i2);
        }
        this.mng.JU(i2);
        this.mnh.JU(i2);
    }

    private void r(byte[] bArr, int i, int i2) {
        if (this.mdN) {
            this.mne.t(bArr, i, i2);
        } else {
            this.mnf.s(bArr, i, i2);
            this.mmB.s(bArr, i, i2);
            this.mmC.s(bArr, i, i2);
        }
        this.mng.s(bArr, i, i2);
        this.mnh.s(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.mdN) {
            this.mne.B(j, i);
        } else {
            this.mnf.JV(i2);
            this.mmB.JV(i2);
            this.mmC.JV(i2);
            if (this.mnf.aW() && this.mmB.aW() && this.mmC.aW()) {
                this.med.h(a(this.mma, this.mnf, this.mmB, this.mmC));
                this.mdN = true;
            }
        }
        if (this.mng.JV(i2)) {
            this.mmF.G(this.mng.mnF, com.google.android.exoplayer2.util.j.D(this.mng.mnF, this.mng.mnG));
            this.mmF.skipBytes(5);
            this.mmy.a(j2, this.mmF);
        }
        if (this.mnh.JV(i2)) {
            this.mmF.G(this.mnh.mnF, com.google.android.exoplayer2.util.j.D(this.mnh.mnF, this.mnh.mnG));
            this.mmF.skipBytes(5);
            this.mmy.a(j2, this.mmF);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mnG + oVar2.mnG + oVar3.mnG];
        System.arraycopy(oVar.mnF, 0, bArr, 0, oVar.mnG);
        System.arraycopy(oVar2.mnF, 0, bArr, oVar.mnG, oVar2.mnG);
        System.arraycopy(oVar3.mnF, 0, bArr, oVar.mnG + oVar2.mnG, oVar3.mnG);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.mnF, 0, oVar2.mnG);
        mVar.JP(44);
        int readBits = mVar.readBits(3);
        mVar.dyf();
        mVar.JP(88);
        mVar.JP(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dua()) {
                i += 89;
            }
            if (mVar.dua()) {
                i += 8;
            }
        }
        mVar.JP(i);
        if (readBits > 0) {
            mVar.JP((8 - readBits) * 2);
        }
        mVar.dyy();
        int dyy = mVar.dyy();
        if (dyy == 3) {
            mVar.dyf();
        }
        int dyy2 = mVar.dyy();
        int dyy3 = mVar.dyy();
        if (mVar.dua()) {
            int dyy4 = mVar.dyy();
            int dyy5 = mVar.dyy();
            int dyy6 = mVar.dyy();
            int dyy7 = mVar.dyy();
            dyy2 -= ((dyy == 1 || dyy == 2) ? 2 : 1) * (dyy4 + dyy5);
            dyy3 -= (dyy == 1 ? 2 : 1) * (dyy6 + dyy7);
        }
        mVar.dyy();
        mVar.dyy();
        int dyy8 = mVar.dyy();
        for (int i3 = mVar.dua() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dyy();
            mVar.dyy();
            mVar.dyy();
        }
        mVar.dyy();
        mVar.dyy();
        mVar.dyy();
        mVar.dyy();
        mVar.dyy();
        mVar.dyy();
        if (mVar.dua() && mVar.dua()) {
            a(mVar);
        }
        mVar.JP(2);
        if (mVar.dua()) {
            mVar.JP(8);
            mVar.dyy();
            mVar.dyy();
            mVar.dyf();
        }
        b(mVar);
        if (mVar.dua()) {
            for (int i4 = 0; i4 < mVar.dyy(); i4++) {
                mVar.JP(dyy8 + 4 + 1);
            }
        }
        mVar.JP(2);
        float f2 = 1.0f;
        if (mVar.dua() && mVar.dua()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mGF.length) {
                f = com.google.android.exoplayer2.util.j.mGF[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dyy2, dyy3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dyy2, dyy3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dua()) {
                    mVar.dyy();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dyz();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dyz();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dyy = mVar.dyy();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dyy) {
            boolean dua = i != 0 ? mVar.dua() : z;
            if (dua) {
                mVar.dyf();
                mVar.dyy();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dua()) {
                        mVar.dyf();
                    }
                }
            } else {
                int dyy2 = mVar.dyy();
                int dyy3 = mVar.dyy();
                i2 = dyy2 + dyy3;
                for (int i4 = 0; i4 < dyy2; i4++) {
                    mVar.dyy();
                    mVar.dyf();
                }
                for (int i5 = 0; i5 < dyy3; i5++) {
                    mVar.dyy();
                    mVar.dyf();
                }
            }
            i++;
            z = dua;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m med;
        private long mmK;
        private long mmL;
        private boolean mmO;
        private long mml;
        private long mms;
        private boolean mmt;
        private boolean mni;
        private int mnj;
        private boolean mnk;
        private boolean mnl;
        private boolean mnm;
        private boolean mnn;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.med = mVar;
        }

        public void reset() {
            this.mnk = false;
            this.mnl = false;
            this.mnm = false;
            this.mmO = false;
            this.mnn = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mnl = false;
            this.mnm = false;
            this.mmL = j2;
            this.mnj = 0;
            this.mmK = j;
            if (i2 >= 32) {
                if (!this.mnn && this.mmO) {
                    JR(i);
                    this.mmO = false;
                }
                if (i2 <= 34) {
                    this.mnm = !this.mnn;
                    this.mnn = true;
                }
            }
            this.mni = i2 >= 16 && i2 <= 21;
            if (this.mni || i2 <= 9) {
                z = true;
            }
            this.mnk = z;
        }

        public void t(byte[] bArr, int i, int i2) {
            if (this.mnk) {
                int i3 = (i + 2) - this.mnj;
                if (i3 < i2) {
                    this.mnl = (bArr[i3] & 128) != 0;
                    this.mnk = false;
                    return;
                }
                this.mnj += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mnn && this.mnl) {
                this.mmt = this.mni;
                this.mnn = false;
            } else if (this.mnm || this.mnl) {
                if (this.mmO) {
                    JR(((int) (j - this.mmK)) + i);
                }
                this.mms = this.mmK;
                this.mml = this.mmL;
                this.mmO = true;
                this.mmt = this.mni;
            }
        }

        private void JR(int i) {
            this.med.a(this.mml, this.mmt ? 1 : 0, (int) (this.mmK - this.mms), i, null);
        }
    }
}
