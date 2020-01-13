package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class k implements h {
    private boolean mdI;
    private com.google.android.exoplayer2.extractor.m mdY;
    private String mlV;
    private a mmZ;
    private long mmm;
    private final t mmt;
    private long totalBytesWritten;
    private final boolean[] mmj = new boolean[3];
    private final o mna = new o(32, 128);
    private final o mmw = new o(33, 128);
    private final o mmx = new o(34, 128);
    private final o mnb = new o(39, 128);
    private final o mnc = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mmA = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.mmt = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        com.google.android.exoplayer2.util.j.b(this.mmj);
        this.mna.reset();
        this.mmw.reset();
        this.mmx.reset();
        this.mnb.reset();
        this.mnc.reset();
        this.mmZ.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlV = dVar.dur();
        this.mdY = gVar.dH(dVar.duq(), 2);
        this.mmZ = new a(this.mdY);
        this.mmt.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmm = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dyf() > 0) {
            int position = lVar.getPosition();
            int dyg = lVar.dyg();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dyf();
            this.mdY.a(lVar, lVar.dyf());
            while (position < dyg) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyg, this.mmj);
                if (a2 == dyg) {
                    r(bArr, position, dyg);
                    return;
                }
                int F = com.google.android.exoplayer2.util.j.F(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    r(bArr, position, a2);
                }
                int i2 = dyg - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.mmm);
                b(j, i2, F, this.mmm);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.mdI) {
            this.mmZ.b(j, i, i2, j2);
        } else {
            this.mna.JU(i2);
            this.mmw.JU(i2);
            this.mmx.JU(i2);
        }
        this.mnb.JU(i2);
        this.mnc.JU(i2);
    }

    private void r(byte[] bArr, int i, int i2) {
        if (this.mdI) {
            this.mmZ.t(bArr, i, i2);
        } else {
            this.mna.s(bArr, i, i2);
            this.mmw.s(bArr, i, i2);
            this.mmx.s(bArr, i, i2);
        }
        this.mnb.s(bArr, i, i2);
        this.mnc.s(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.mdI) {
            this.mmZ.B(j, i);
        } else {
            this.mna.JV(i2);
            this.mmw.JV(i2);
            this.mmx.JV(i2);
            if (this.mna.aW() && this.mmw.aW() && this.mmx.aW()) {
                this.mdY.h(a(this.mlV, this.mna, this.mmw, this.mmx));
                this.mdI = true;
            }
        }
        if (this.mnb.JV(i2)) {
            this.mmA.G(this.mnb.mnA, com.google.android.exoplayer2.util.j.D(this.mnb.mnA, this.mnb.mnB));
            this.mmA.skipBytes(5);
            this.mmt.a(j2, this.mmA);
        }
        if (this.mnc.JV(i2)) {
            this.mmA.G(this.mnc.mnA, com.google.android.exoplayer2.util.j.D(this.mnc.mnA, this.mnc.mnB));
            this.mmA.skipBytes(5);
            this.mmt.a(j2, this.mmA);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.mnB + oVar2.mnB + oVar3.mnB];
        System.arraycopy(oVar.mnA, 0, bArr, 0, oVar.mnB);
        System.arraycopy(oVar2.mnA, 0, bArr, oVar.mnB, oVar2.mnB);
        System.arraycopy(oVar3.mnA, 0, bArr, oVar.mnB + oVar2.mnB, oVar3.mnB);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.mnA, 0, oVar2.mnB);
        mVar.JP(44);
        int readBits = mVar.readBits(3);
        mVar.dyd();
        mVar.JP(88);
        mVar.JP(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dtY()) {
                i += 89;
            }
            if (mVar.dtY()) {
                i += 8;
            }
        }
        mVar.JP(i);
        if (readBits > 0) {
            mVar.JP((8 - readBits) * 2);
        }
        mVar.dyw();
        int dyw = mVar.dyw();
        if (dyw == 3) {
            mVar.dyd();
        }
        int dyw2 = mVar.dyw();
        int dyw3 = mVar.dyw();
        if (mVar.dtY()) {
            int dyw4 = mVar.dyw();
            int dyw5 = mVar.dyw();
            int dyw6 = mVar.dyw();
            int dyw7 = mVar.dyw();
            dyw2 -= ((dyw == 1 || dyw == 2) ? 2 : 1) * (dyw4 + dyw5);
            dyw3 -= (dyw == 1 ? 2 : 1) * (dyw6 + dyw7);
        }
        mVar.dyw();
        mVar.dyw();
        int dyw8 = mVar.dyw();
        for (int i3 = mVar.dtY() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dyw();
            mVar.dyw();
            mVar.dyw();
        }
        mVar.dyw();
        mVar.dyw();
        mVar.dyw();
        mVar.dyw();
        mVar.dyw();
        mVar.dyw();
        if (mVar.dtY() && mVar.dtY()) {
            a(mVar);
        }
        mVar.JP(2);
        if (mVar.dtY()) {
            mVar.JP(8);
            mVar.dyw();
            mVar.dyw();
            mVar.dyd();
        }
        b(mVar);
        if (mVar.dtY()) {
            for (int i4 = 0; i4 < mVar.dyw(); i4++) {
                mVar.JP(dyw8 + 4 + 1);
            }
        }
        mVar.JP(2);
        float f2 = 1.0f;
        if (mVar.dtY() && mVar.dtY()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mGA.length) {
                f = com.google.android.exoplayer2.util.j.mGA[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dyw2, dyw3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dyw2, dyw3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dtY()) {
                    mVar.dyw();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dyx();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dyx();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dyw = mVar.dyw();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dyw) {
            boolean dtY = i != 0 ? mVar.dtY() : z;
            if (dtY) {
                mVar.dyd();
                mVar.dyw();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dtY()) {
                        mVar.dyd();
                    }
                }
            } else {
                int dyw2 = mVar.dyw();
                int dyw3 = mVar.dyw();
                i2 = dyw2 + dyw3;
                for (int i4 = 0; i4 < dyw2; i4++) {
                    mVar.dyw();
                    mVar.dyd();
                }
                for (int i5 = 0; i5 < dyw3; i5++) {
                    mVar.dyw();
                    mVar.dyd();
                }
            }
            i++;
            z = dtY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m mdY;
        private long mmF;
        private long mmG;
        private boolean mmJ;
        private long mmg;
        private long mmn;
        private boolean mmo;
        private boolean mnd;
        private int mne;
        private boolean mnf;
        private boolean mng;
        private boolean mnh;
        private boolean mni;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.mdY = mVar;
        }

        public void reset() {
            this.mnf = false;
            this.mng = false;
            this.mnh = false;
            this.mmJ = false;
            this.mni = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.mng = false;
            this.mnh = false;
            this.mmG = j2;
            this.mne = 0;
            this.mmF = j;
            if (i2 >= 32) {
                if (!this.mni && this.mmJ) {
                    JR(i);
                    this.mmJ = false;
                }
                if (i2 <= 34) {
                    this.mnh = !this.mni;
                    this.mni = true;
                }
            }
            this.mnd = i2 >= 16 && i2 <= 21;
            if (this.mnd || i2 <= 9) {
                z = true;
            }
            this.mnf = z;
        }

        public void t(byte[] bArr, int i, int i2) {
            if (this.mnf) {
                int i3 = (i + 2) - this.mne;
                if (i3 < i2) {
                    this.mng = (bArr[i3] & 128) != 0;
                    this.mnf = false;
                    return;
                }
                this.mne += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mni && this.mng) {
                this.mmo = this.mnd;
                this.mni = false;
            } else if (this.mnh || this.mng) {
                if (this.mmJ) {
                    JR(((int) (j - this.mmF)) + i);
                }
                this.mmn = this.mmF;
                this.mmg = this.mmG;
                this.mmJ = true;
                this.mmo = this.mnd;
            }
        }

        private void JR(int i) {
            this.mdY.a(this.mmg, this.mmo ? 1 : 0, (int) (this.mmF - this.mmn), i, null);
        }
    }
}
