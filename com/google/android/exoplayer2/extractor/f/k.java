package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes4.dex */
public final class k implements h {
    private boolean lZQ;
    private com.google.android.exoplayer2.extractor.m mah;
    private final t miF;
    private String mig;
    private long miy;
    private a mjl;
    private long totalBytesWritten;
    private final boolean[] miv = new boolean[3];
    private final o mjm = new o(32, 128);
    private final o miI = new o(33, 128);
    private final o miJ = new o(34, 128);
    private final o mjn = new o(39, 128);
    private final o mjo = new o(40, 128);
    private final com.google.android.exoplayer2.util.l miM = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.miF = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        com.google.android.exoplayer2.util.j.b(this.miv);
        this.mjm.reset();
        this.miI.reset();
        this.miJ.reset();
        this.mjn.reset();
        this.mjo.reset();
        this.mjl.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mig = dVar.dtg();
        this.mah = gVar.dJ(dVar.dtf(), 2);
        this.mjl = new a(this.mah);
        this.miF.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.miy = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dwV() > 0) {
            int position = lVar.getPosition();
            int dwW = lVar.dwW();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dwV();
            this.mah.a(lVar, lVar.dwV());
            while (position < dwW) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dwW, this.miv);
                if (a2 == dwW) {
                    s(bArr, position, dwW);
                    return;
                }
                int F = com.google.android.exoplayer2.util.j.F(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    s(bArr, position, a2);
                }
                int i2 = dwW - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.miy);
                b(j, i2, F, this.miy);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.lZQ) {
            this.mjl.b(j, i, i2, j2);
        } else {
            this.mjm.JL(i2);
            this.miI.JL(i2);
            this.miJ.JL(i2);
        }
        this.mjn.JL(i2);
        this.mjo.JL(i2);
    }

    private void s(byte[] bArr, int i, int i2) {
        if (this.lZQ) {
            this.mjl.u(bArr, i, i2);
        } else {
            this.mjm.t(bArr, i, i2);
            this.miI.t(bArr, i, i2);
            this.miJ.t(bArr, i, i2);
        }
        this.mjn.t(bArr, i, i2);
        this.mjo.t(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.lZQ) {
            this.mjl.B(j, i);
        } else {
            this.mjm.JM(i2);
            this.miI.JM(i2);
            this.miJ.JM(i2);
            if (this.mjm.aW() && this.miI.aW() && this.miJ.aW()) {
                this.mah.h(a(this.mig, this.mjm, this.miI, this.miJ));
                this.lZQ = true;
            }
        }
        if (this.mjn.JM(i2)) {
            this.miM.G(this.mjn.mjM, com.google.android.exoplayer2.util.j.D(this.mjn.mjM, this.mjn.mjN));
            this.miM.skipBytes(5);
            this.miF.a(j2, this.miM);
        }
        if (this.mjo.JM(i2)) {
            this.miM.G(this.mjo.mjM, com.google.android.exoplayer2.util.j.D(this.mjo.mjM, this.mjo.mjN));
            this.miM.skipBytes(5);
            this.miF.a(j2, this.miM);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mjN + oVar2.mjN + oVar3.mjN];
        System.arraycopy(oVar.mjM, 0, bArr, 0, oVar.mjN);
        System.arraycopy(oVar2.mjM, 0, bArr, oVar.mjN, oVar2.mjN);
        System.arraycopy(oVar3.mjM, 0, bArr, oVar.mjN + oVar2.mjN, oVar3.mjN);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.mjM, 0, oVar2.mjN);
        mVar.JG(44);
        int readBits = mVar.readBits(3);
        mVar.dwT();
        mVar.JG(88);
        mVar.JG(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dsM()) {
                i += 89;
            }
            if (mVar.dsM()) {
                i += 8;
            }
        }
        mVar.JG(i);
        if (readBits > 0) {
            mVar.JG((8 - readBits) * 2);
        }
        mVar.dxm();
        int dxm = mVar.dxm();
        if (dxm == 3) {
            mVar.dwT();
        }
        int dxm2 = mVar.dxm();
        int dxm3 = mVar.dxm();
        if (mVar.dsM()) {
            int dxm4 = mVar.dxm();
            int dxm5 = mVar.dxm();
            int dxm6 = mVar.dxm();
            int dxm7 = mVar.dxm();
            dxm2 -= ((dxm == 1 || dxm == 2) ? 2 : 1) * (dxm4 + dxm5);
            dxm3 -= (dxm == 1 ? 2 : 1) * (dxm6 + dxm7);
        }
        mVar.dxm();
        mVar.dxm();
        int dxm8 = mVar.dxm();
        for (int i3 = mVar.dsM() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dxm();
            mVar.dxm();
            mVar.dxm();
        }
        mVar.dxm();
        mVar.dxm();
        mVar.dxm();
        mVar.dxm();
        mVar.dxm();
        mVar.dxm();
        if (mVar.dsM() && mVar.dsM()) {
            a(mVar);
        }
        mVar.JG(2);
        if (mVar.dsM()) {
            mVar.JG(8);
            mVar.dxm();
            mVar.dxm();
            mVar.dwT();
        }
        b(mVar);
        if (mVar.dsM()) {
            for (int i4 = 0; i4 < mVar.dxm(); i4++) {
                mVar.JG(dxm8 + 4 + 1);
            }
        }
        mVar.JG(2);
        float f2 = 1.0f;
        if (mVar.dsM() && mVar.dsM()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mCJ.length) {
                f = com.google.android.exoplayer2.util.j.mCJ[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dxm2, dxm3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dxm2, dxm3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dsM()) {
                    mVar.dxm();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dxn();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dxn();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dxm = mVar.dxm();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dxm) {
            boolean dsM = i != 0 ? mVar.dsM() : z;
            if (dsM) {
                mVar.dwT();
                mVar.dxm();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dsM()) {
                        mVar.dwT();
                    }
                }
            } else {
                int dxm2 = mVar.dxm();
                int dxm3 = mVar.dxm();
                i2 = dxm2 + dxm3;
                for (int i4 = 0; i4 < dxm2; i4++) {
                    mVar.dxm();
                    mVar.dwT();
                }
                for (int i5 = 0; i5 < dxm3; i5++) {
                    mVar.dxm();
                    mVar.dwT();
                }
            }
            i++;
            z = dsM;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m mah;
        private boolean miA;
        private long miR;
        private long miS;
        private boolean miV;
        private long mis;
        private long miz;
        private boolean mjp;
        private int mjq;
        private boolean mjr;
        private boolean mjs;
        private boolean mjt;
        private boolean mju;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.mah = mVar;
        }

        public void reset() {
            this.mjr = false;
            this.mjs = false;
            this.mjt = false;
            this.miV = false;
            this.mju = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mjs = false;
            this.mjt = false;
            this.miS = j2;
            this.mjq = 0;
            this.miR = j;
            if (i2 >= 32) {
                if (!this.mju && this.miV) {
                    JI(i);
                    this.miV = false;
                }
                if (i2 <= 34) {
                    this.mjt = !this.mju;
                    this.mju = true;
                }
            }
            this.mjp = i2 >= 16 && i2 <= 21;
            if (this.mjp || i2 <= 9) {
                z = true;
            }
            this.mjr = z;
        }

        public void u(byte[] bArr, int i, int i2) {
            if (this.mjr) {
                int i3 = (i + 2) - this.mjq;
                if (i3 < i2) {
                    this.mjs = (bArr[i3] & 128) != 0;
                    this.mjr = false;
                    return;
                }
                this.mjq += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mju && this.mjs) {
                this.miA = this.mjp;
                this.mju = false;
            } else if (this.mjt || this.mjs) {
                if (this.miV) {
                    JI(((int) (j - this.miR)) + i);
                }
                this.miz = this.miR;
                this.mis = this.miS;
                this.miV = true;
                this.miA = this.mjp;
            }
        }

        private void JI(int i) {
            this.mah.a(this.mis, this.miA ? 1 : 0, (int) (this.miR - this.miz), i, null);
        }
    }
}
