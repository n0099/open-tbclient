package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class k implements h {
    private boolean meG;
    private com.google.android.exoplayer2.extractor.m meW;
    private String mmT;
    private a mnX;
    private long mnk;
    private final t mnr;
    private long totalBytesWritten;
    private final boolean[] mnh = new boolean[3];
    private final o mnY = new o(32, 128);
    private final o mnu = new o(33, 128);
    private final o mnv = new o(34, 128);
    private final o mnZ = new o(39, 128);
    private final o moa = new o(40, 128);
    private final com.google.android.exoplayer2.util.l mny = new com.google.android.exoplayer2.util.l();

    public k(t tVar) {
        this.mnr = tVar;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        com.google.android.exoplayer2.util.j.b(this.mnh);
        this.mnY.reset();
        this.mnu.reset();
        this.mnv.reset();
        this.mnZ.reset();
        this.moa.reset();
        this.mnX.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmT = dVar.dvH();
        this.meW = gVar.dK(dVar.dvG(), 2);
        this.mnX = new a(this.meW);
        this.mnr.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mnk = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        while (lVar.dzu() > 0) {
            int position = lVar.getPosition();
            int dzv = lVar.dzv();
            byte[] bArr = lVar.data;
            this.totalBytesWritten += lVar.dzu();
            this.meW.a(lVar, lVar.dzu());
            while (position < dzv) {
                int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzv, this.mnh);
                if (a2 == dzv) {
                    v(bArr, position, dzv);
                    return;
                }
                int H = com.google.android.exoplayer2.util.j.H(bArr, a2);
                int i = a2 - position;
                if (i > 0) {
                    v(bArr, position, a2);
                }
                int i2 = dzv - a2;
                long j = this.totalBytesWritten - i2;
                a(j, i2, i < 0 ? -i : 0, this.mnk);
                b(j, i2, H, this.mnk);
                position = a2 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.meG) {
            this.mnX.b(j, i, i2, j2);
        } else {
            this.mnY.JZ(i2);
            this.mnu.JZ(i2);
            this.mnv.JZ(i2);
        }
        this.mnZ.JZ(i2);
        this.moa.JZ(i2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (this.meG) {
            this.mnX.x(bArr, i, i2);
        } else {
            this.mnY.w(bArr, i, i2);
            this.mnu.w(bArr, i, i2);
            this.mnv.w(bArr, i, i2);
        }
        this.mnZ.w(bArr, i, i2);
        this.moa.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.meG) {
            this.mnX.B(j, i);
        } else {
            this.mnY.Ka(i2);
            this.mnu.Ka(i2);
            this.mnv.Ka(i2);
            if (this.mnY.aW() && this.mnu.aW() && this.mnv.aW()) {
                this.meW.h(a(this.mmT, this.mnY, this.mnu, this.mnv));
                this.meG = true;
            }
        }
        if (this.mnZ.Ka(i2)) {
            this.mny.I(this.mnZ.moz, com.google.android.exoplayer2.util.j.F(this.mnZ.moz, this.mnZ.moA));
            this.mny.skipBytes(5);
            this.mnr.a(j2, this.mny);
        }
        if (this.moa.Ka(i2)) {
            this.mny.I(this.moa.moz, com.google.android.exoplayer2.util.j.F(this.moa.moz, this.moa.moA));
            this.mny.skipBytes(5);
            this.mnr.a(j2, this.mny);
        }
    }

    private static Format a(String str, o oVar, o oVar2, o oVar3) {
        float f;
        byte[] bArr = new byte[oVar.moA + oVar2.moA + oVar3.moA];
        System.arraycopy(oVar.moz, 0, bArr, 0, oVar.moA);
        System.arraycopy(oVar2.moz, 0, bArr, oVar.moA, oVar2.moA);
        System.arraycopy(oVar3.moz, 0, bArr, oVar.moA + oVar2.moA, oVar3.moA);
        com.google.android.exoplayer2.util.m mVar = new com.google.android.exoplayer2.util.m(oVar2.moz, 0, oVar2.moA);
        mVar.JU(44);
        int readBits = mVar.readBits(3);
        mVar.dzs();
        mVar.JU(88);
        mVar.JU(8);
        int i = 0;
        for (int i2 = 0; i2 < readBits; i2++) {
            if (mVar.dvo()) {
                i += 89;
            }
            if (mVar.dvo()) {
                i += 8;
            }
        }
        mVar.JU(i);
        if (readBits > 0) {
            mVar.JU((8 - readBits) * 2);
        }
        mVar.dzL();
        int dzL = mVar.dzL();
        if (dzL == 3) {
            mVar.dzs();
        }
        int dzL2 = mVar.dzL();
        int dzL3 = mVar.dzL();
        if (mVar.dvo()) {
            int dzL4 = mVar.dzL();
            int dzL5 = mVar.dzL();
            int dzL6 = mVar.dzL();
            int dzL7 = mVar.dzL();
            dzL2 -= ((dzL == 1 || dzL == 2) ? 2 : 1) * (dzL4 + dzL5);
            dzL3 -= (dzL == 1 ? 2 : 1) * (dzL6 + dzL7);
        }
        mVar.dzL();
        mVar.dzL();
        int dzL8 = mVar.dzL();
        for (int i3 = mVar.dvo() ? 0 : readBits; i3 <= readBits; i3++) {
            mVar.dzL();
            mVar.dzL();
            mVar.dzL();
        }
        mVar.dzL();
        mVar.dzL();
        mVar.dzL();
        mVar.dzL();
        mVar.dzL();
        mVar.dzL();
        if (mVar.dvo() && mVar.dvo()) {
            a(mVar);
        }
        mVar.JU(2);
        if (mVar.dvo()) {
            mVar.JU(8);
            mVar.dzL();
            mVar.dzL();
            mVar.dzs();
        }
        b(mVar);
        if (mVar.dvo()) {
            for (int i4 = 0; i4 < mVar.dzL(); i4++) {
                mVar.JU(dzL8 + 4 + 1);
            }
        }
        mVar.JU(2);
        float f2 = 1.0f;
        if (mVar.dvo() && mVar.dvo()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < com.google.android.exoplayer2.util.j.mHx.length) {
                f = com.google.android.exoplayer2.util.j.mHx[readBits2];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, dzL2, dzL3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, dzL2, dzL3, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.util.m mVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (!mVar.dvo()) {
                    mVar.dzL();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mVar.dzM();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        mVar.dzM();
                    }
                }
            }
            i++;
        }
    }

    private static void b(com.google.android.exoplayer2.util.m mVar) {
        int dzL = mVar.dzL();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < dzL) {
            boolean dvo = i != 0 ? mVar.dvo() : z;
            if (dvo) {
                mVar.dzs();
                mVar.dzL();
                for (int i3 = 0; i3 <= i2; i3++) {
                    if (mVar.dvo()) {
                        mVar.dzs();
                    }
                }
            } else {
                int dzL2 = mVar.dzL();
                int dzL3 = mVar.dzL();
                i2 = dzL2 + dzL3;
                for (int i4 = 0; i4 < dzL2; i4++) {
                    mVar.dzL();
                    mVar.dzs();
                }
                for (int i5 = 0; i5 < dzL3; i5++) {
                    mVar.dzL();
                    mVar.dzs();
                }
            }
            i++;
            z = dvo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private final com.google.android.exoplayer2.extractor.m meW;
        private long mnD;
        private long mnE;
        private boolean mnH;
        private long mne;
        private long mnl;
        private boolean mnm;
        private boolean mob;
        private int moc;
        private boolean mod;
        private boolean moe;
        private boolean mof;
        private boolean mog;

        public a(com.google.android.exoplayer2.extractor.m mVar) {
            this.meW = mVar;
        }

        public void reset() {
            this.mod = false;
            this.moe = false;
            this.mof = false;
            this.mnH = false;
            this.mog = false;
        }

        public void b(long j, int i, int i2, long j2) {
            boolean z = false;
            this.moe = false;
            this.mof = false;
            this.mnE = j2;
            this.moc = 0;
            this.mnD = j;
            if (i2 >= 32) {
                if (!this.mog && this.mnH) {
                    JW(i);
                    this.mnH = false;
                }
                if (i2 <= 34) {
                    this.mof = !this.mog;
                    this.mog = true;
                }
            }
            this.mob = i2 >= 16 && i2 <= 21;
            if (this.mob || i2 <= 9) {
                z = true;
            }
            this.mod = z;
        }

        public void x(byte[] bArr, int i, int i2) {
            if (this.mod) {
                int i3 = (i + 2) - this.moc;
                if (i3 < i2) {
                    this.moe = (bArr[i3] & 128) != 0;
                    this.mod = false;
                    return;
                }
                this.moc += i2 - i;
            }
        }

        public void B(long j, int i) {
            if (this.mog && this.moe) {
                this.mnm = this.mob;
                this.mog = false;
            } else if (this.mof || this.moe) {
                if (this.mnH) {
                    JW(((int) (j - this.mnD)) + i);
                }
                this.mnl = this.mnD;
                this.mne = this.mnE;
                this.mnH = true;
                this.mnm = this.mob;
            }
        }

        private void JW(int i) {
            this.meW.a(this.mne, this.mnm ? 1 : 0, (int) (this.mnD - this.mnl), i, null);
        }
    }
}
