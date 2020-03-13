package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.util.j;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j implements h {
    private boolean meG;
    private com.google.android.exoplayer2.extractor.m meW;
    private String mmT;
    private long mnk;
    private final t mnr;
    private final boolean mns;
    private final boolean mnt;
    private a mnx;
    private long totalBytesWritten;
    private final boolean[] mnh = new boolean[3];
    private final o mnu = new o(7, 128);
    private final o mnv = new o(8, 128);
    private final o mnw = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mny = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.mnr = tVar;
        this.mns = z;
        this.mnt = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        com.google.android.exoplayer2.util.j.b(this.mnh);
        this.mnu.reset();
        this.mnv.reset();
        this.mnw.reset();
        this.mnx.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmT = dVar.dvH();
        this.meW = gVar.dK(dVar.dvG(), 2);
        this.mnx = new a(this.meW, this.mns, this.mnt);
        this.mnr.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mnk = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzu();
        this.meW.a(lVar, lVar.dzu());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzv, this.mnh);
            if (a2 == dzv) {
                v(bArr, position, dzv);
                return;
            }
            int G = com.google.android.exoplayer2.util.j.G(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                v(bArr, position, a2);
            }
            int i2 = dzv - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.mnk);
            b(j, G, this.mnk);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
    }

    private void b(long j, int i, long j2) {
        if (!this.meG || this.mnx.dvy()) {
            this.mnu.JZ(i);
            this.mnv.JZ(i);
        }
        this.mnw.JZ(i);
        this.mnx.b(j, i, j2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (!this.meG || this.mnx.dvy()) {
            this.mnu.w(bArr, i, i2);
            this.mnv.w(bArr, i, i2);
        }
        this.mnw.w(bArr, i, i2);
        this.mnx.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.meG || this.mnx.dvy()) {
            this.mnu.Ka(i2);
            this.mnv.Ka(i2);
            if (!this.meG) {
                if (this.mnu.aW() && this.mnv.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mnu.moz, this.mnu.moA));
                    arrayList.add(Arrays.copyOf(this.mnv.moz, this.mnv.moA));
                    j.b C = com.google.android.exoplayer2.util.j.C(this.mnu.moz, 3, this.mnu.moA);
                    j.a D = com.google.android.exoplayer2.util.j.D(this.mnv.moz, 3, this.mnv.moA);
                    this.meW.h(Format.a(this.mmT, "video/avc", (String) null, -1, -1, C.width, C.height, -1.0f, arrayList, -1, C.mHC, (DrmInitData) null));
                    this.meG = true;
                    this.mnx.a(C);
                    this.mnx.a(D);
                    this.mnu.reset();
                    this.mnv.reset();
                }
            } else if (this.mnu.aW()) {
                this.mnx.a(com.google.android.exoplayer2.util.j.C(this.mnu.moz, 3, this.mnu.moA));
                this.mnu.reset();
            } else if (this.mnv.aW()) {
                this.mnx.a(com.google.android.exoplayer2.util.j.D(this.mnv.moz, 3, this.mnv.moA));
                this.mnv.reset();
            }
        }
        if (this.mnw.Ka(i2)) {
            this.mny.I(this.mnw.moz, com.google.android.exoplayer2.util.j.F(this.mnw.moz, this.mnw.moA));
            this.mny.setPosition(4);
            this.mnr.a(j2, this.mny);
        }
        this.mnx.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m meW;
        private int mnC;
        private long mnD;
        private long mnE;
        private boolean mnH;
        private long mne;
        private long mnl;
        private boolean mnm;
        private boolean mnp;
        private final boolean mns;
        private final boolean mnt;
        private final SparseArray<j.b> mnz = new SparseArray<>();
        private final SparseArray<j.a> mnA = new SparseArray<>();
        private C0677a mnF = new C0677a();
        private C0677a mnG = new C0677a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mnB = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.meW = mVar;
            this.mns = z;
            this.mnt = z2;
            reset();
        }

        public boolean dvy() {
            return this.mnt;
        }

        public void a(j.b bVar) {
            this.mnz.append(bVar.mHA, bVar);
        }

        public void a(j.a aVar) {
            this.mnA.append(aVar.mnN, aVar);
        }

        public void reset() {
            this.mnp = false;
            this.mnH = false;
            this.mnG.clear();
        }

        public void b(long j, int i, long j2) {
            this.mnC = i;
            this.mnE = j2;
            this.mnD = j;
            if (!this.mns || this.mnC != 1) {
                if (!this.mnt) {
                    return;
                }
                if (this.mnC != 5 && this.mnC != 1 && this.mnC != 2) {
                    return;
                }
            }
            C0677a c0677a = this.mnF;
            this.mnF = this.mnG;
            this.mnG = c0677a;
            this.mnG.clear();
            this.bufferLength = 0;
            this.mnp = true;
        }

        public void w(byte[] bArr, int i, int i2) {
            if (this.mnp) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mnB.H(this.buffer, 0, this.bufferLength);
                if (this.mnB.LW(8)) {
                    this.mnB.dzs();
                    int readBits = this.mnB.readBits(2);
                    this.mnB.JU(5);
                    if (this.mnB.dzK()) {
                        this.mnB.dzL();
                        if (this.mnB.dzK()) {
                            int dzL = this.mnB.dzL();
                            if (!this.mnt) {
                                this.mnp = false;
                                this.mnG.JX(dzL);
                            } else if (this.mnB.dzK()) {
                                int dzL2 = this.mnB.dzL();
                                if (this.mnA.indexOfKey(dzL2) < 0) {
                                    this.mnp = false;
                                    return;
                                }
                                j.a aVar = this.mnA.get(dzL2);
                                j.b bVar = this.mnz.get(aVar.mHA);
                                if (bVar.mHD) {
                                    if (this.mnB.LW(2)) {
                                        this.mnB.JU(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mnB.LW(bVar.mHF)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mnB.readBits(bVar.mHF);
                                    if (!bVar.mHE) {
                                        if (this.mnB.LW(1)) {
                                            z = this.mnB.dvo();
                                            if (z) {
                                                if (this.mnB.LW(1)) {
                                                    z3 = this.mnB.dvo();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mnC == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mnB.dzK()) {
                                            i4 = this.mnB.dzL();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mHG == 0) {
                                        if (this.mnB.LW(bVar.mHH)) {
                                            i5 = this.mnB.readBits(bVar.mHH);
                                            if (aVar.mHB && !z) {
                                                if (this.mnB.dzK()) {
                                                    i6 = this.mnB.dzM();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mHG == 1 && !bVar.mHI) {
                                        if (this.mnB.dzK()) {
                                            i7 = this.mnB.dzM();
                                            if (aVar.mHB && !z) {
                                                if (this.mnB.dzK()) {
                                                    i8 = this.mnB.dzM();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mnG.a(bVar, readBits, dzL, readBits2, dzL2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.mnp = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mnC == 9 || (this.mnt && this.mnG.a(this.mnF))) {
                if (this.mnH) {
                    JW(((int) (j - this.mnD)) + i);
                }
                this.mnl = this.mnD;
                this.mne = this.mnE;
                this.mnm = false;
                this.mnH = true;
            }
            boolean z2 = this.mnm;
            if (this.mnC == 5 || (this.mns && this.mnC == 1 && this.mnG.dvz())) {
                z = true;
            }
            this.mnm = z | z2;
        }

        private void JW(int i) {
            this.meW.a(this.mne, this.mnm ? 1 : 0, (int) (this.mnD - this.mnl), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0677a {
            private int frameNum;
            private boolean mnI;
            private boolean mnJ;
            private j.b mnK;
            private int mnL;
            private int mnM;
            private int mnN;
            private boolean mnO;
            private boolean mnP;
            private boolean mnQ;
            private boolean mnR;
            private int mnS;
            private int mnT;
            private int mnU;
            private int mnV;
            private int mnW;

            private C0677a() {
            }

            public void clear() {
                this.mnJ = false;
                this.mnI = false;
            }

            public void JX(int i) {
                this.mnM = i;
                this.mnJ = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mnK = bVar;
                this.mnL = i;
                this.mnM = i2;
                this.frameNum = i3;
                this.mnN = i4;
                this.mnO = z;
                this.mnP = z2;
                this.mnQ = z3;
                this.mnR = z4;
                this.mnS = i5;
                this.mnT = i6;
                this.mnU = i7;
                this.mnV = i8;
                this.mnW = i9;
                this.mnI = true;
                this.mnJ = true;
            }

            public boolean dvz() {
                return this.mnJ && (this.mnM == 7 || this.mnM == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0677a c0677a) {
                if (this.mnI) {
                    if (!c0677a.mnI || this.frameNum != c0677a.frameNum || this.mnN != c0677a.mnN || this.mnO != c0677a.mnO) {
                        return true;
                    }
                    if (this.mnP && c0677a.mnP && this.mnQ != c0677a.mnQ) {
                        return true;
                    }
                    if (this.mnL != c0677a.mnL && (this.mnL == 0 || c0677a.mnL == 0)) {
                        return true;
                    }
                    if (this.mnK.mHG == 0 && c0677a.mnK.mHG == 0 && (this.mnT != c0677a.mnT || this.mnU != c0677a.mnU)) {
                        return true;
                    }
                    if ((this.mnK.mHG == 1 && c0677a.mnK.mHG == 1 && (this.mnV != c0677a.mnV || this.mnW != c0677a.mnW)) || this.mnR != c0677a.mnR) {
                        return true;
                    }
                    if (this.mnR && c0677a.mnR && this.mnS != c0677a.mnS) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
