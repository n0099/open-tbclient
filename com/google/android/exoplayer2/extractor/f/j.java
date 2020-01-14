package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.util.j;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class j implements h {
    private boolean mdN;
    private com.google.android.exoplayer2.extractor.m med;
    private final boolean mmA;
    private a mmE;
    private String mma;
    private long mmr;
    private final t mmy;
    private final boolean mmz;
    private long totalBytesWritten;
    private final boolean[] mmo = new boolean[3];
    private final o mmB = new o(7, 128);
    private final o mmC = new o(8, 128);
    private final o mmD = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mmF = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.mmy = tVar;
        this.mmz = z;
        this.mmA = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        com.google.android.exoplayer2.util.j.b(this.mmo);
        this.mmB.reset();
        this.mmC.reset();
        this.mmD.reset();
        this.mmE.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mma = dVar.dut();
        this.med = gVar.dH(dVar.dus(), 2);
        this.mmE = new a(this.med, this.mmz, this.mmA);
        this.mmy.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmr = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dyi = lVar.dyi();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dyh();
        this.med.a(lVar, lVar.dyh());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyi, this.mmo);
            if (a2 == dyi) {
                r(bArr, position, dyi);
                return;
            }
            int E = com.google.android.exoplayer2.util.j.E(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                r(bArr, position, a2);
            }
            int i2 = dyi - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.mmr);
            b(j, E, this.mmr);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private void b(long j, int i, long j2) {
        if (!this.mdN || this.mmE.duk()) {
            this.mmB.JU(i);
            this.mmC.JU(i);
        }
        this.mmD.JU(i);
        this.mmE.b(j, i, j2);
    }

    private void r(byte[] bArr, int i, int i2) {
        if (!this.mdN || this.mmE.duk()) {
            this.mmB.s(bArr, i, i2);
            this.mmC.s(bArr, i, i2);
        }
        this.mmD.s(bArr, i, i2);
        this.mmE.s(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.mdN || this.mmE.duk()) {
            this.mmB.JV(i2);
            this.mmC.JV(i2);
            if (!this.mdN) {
                if (this.mmB.aW() && this.mmC.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mmB.mnF, this.mmB.mnG));
                    arrayList.add(Arrays.copyOf(this.mmC.mnF, this.mmC.mnG));
                    j.b y = com.google.android.exoplayer2.util.j.y(this.mmB.mnF, 3, this.mmB.mnG);
                    j.a z = com.google.android.exoplayer2.util.j.z(this.mmC.mnF, 3, this.mmC.mnG);
                    this.med.h(Format.a(this.mma, "video/avc", (String) null, -1, -1, y.width, y.height, -1.0f, arrayList, -1, y.mGK, (DrmInitData) null));
                    this.mdN = true;
                    this.mmE.a(y);
                    this.mmE.a(z);
                    this.mmB.reset();
                    this.mmC.reset();
                }
            } else if (this.mmB.aW()) {
                this.mmE.a(com.google.android.exoplayer2.util.j.y(this.mmB.mnF, 3, this.mmB.mnG));
                this.mmB.reset();
            } else if (this.mmC.aW()) {
                this.mmE.a(com.google.android.exoplayer2.util.j.z(this.mmC.mnF, 3, this.mmC.mnG));
                this.mmC.reset();
            }
        }
        if (this.mmD.JV(i2)) {
            this.mmF.G(this.mmD.mnF, com.google.android.exoplayer2.util.j.D(this.mmD.mnF, this.mmD.mnG));
            this.mmF.setPosition(4);
            this.mmy.a(j2, this.mmF);
        }
        this.mmE.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m med;
        private final boolean mmA;
        private int mmJ;
        private long mmK;
        private long mmL;
        private boolean mmO;
        private long mml;
        private long mms;
        private boolean mmt;
        private boolean mmw;
        private final boolean mmz;
        private final SparseArray<j.b> mmG = new SparseArray<>();
        private final SparseArray<j.a> mmH = new SparseArray<>();
        private C0669a mmM = new C0669a();
        private C0669a mmN = new C0669a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mmI = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.med = mVar;
            this.mmz = z;
            this.mmA = z2;
            reset();
        }

        public boolean duk() {
            return this.mmA;
        }

        public void a(j.b bVar) {
            this.mmG.append(bVar.mGI, bVar);
        }

        public void a(j.a aVar) {
            this.mmH.append(aVar.mmU, aVar);
        }

        public void reset() {
            this.mmw = false;
            this.mmO = false;
            this.mmN.clear();
        }

        public void b(long j, int i, long j2) {
            this.mmJ = i;
            this.mmL = j2;
            this.mmK = j;
            if (!this.mmz || this.mmJ != 1) {
                if (!this.mmA) {
                    return;
                }
                if (this.mmJ != 5 && this.mmJ != 1 && this.mmJ != 2) {
                    return;
                }
            }
            C0669a c0669a = this.mmM;
            this.mmM = this.mmN;
            this.mmN = c0669a;
            this.mmN.clear();
            this.bufferLength = 0;
            this.mmw = true;
        }

        public void s(byte[] bArr, int i, int i2) {
            if (this.mmw) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mmI.D(this.buffer, 0, this.bufferLength);
                if (this.mmI.LR(8)) {
                    this.mmI.dyf();
                    int readBits = this.mmI.readBits(2);
                    this.mmI.JP(5);
                    if (this.mmI.dyx()) {
                        this.mmI.dyy();
                        if (this.mmI.dyx()) {
                            int dyy = this.mmI.dyy();
                            if (!this.mmA) {
                                this.mmw = false;
                                this.mmN.JS(dyy);
                            } else if (this.mmI.dyx()) {
                                int dyy2 = this.mmI.dyy();
                                if (this.mmH.indexOfKey(dyy2) < 0) {
                                    this.mmw = false;
                                    return;
                                }
                                j.a aVar = this.mmH.get(dyy2);
                                j.b bVar = this.mmG.get(aVar.mGI);
                                if (bVar.mGL) {
                                    if (this.mmI.LR(2)) {
                                        this.mmI.JP(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mmI.LR(bVar.mGN)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mmI.readBits(bVar.mGN);
                                    if (!bVar.mGM) {
                                        if (this.mmI.LR(1)) {
                                            z = this.mmI.dua();
                                            if (z) {
                                                if (this.mmI.LR(1)) {
                                                    z3 = this.mmI.dua();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mmJ == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mmI.dyx()) {
                                            i4 = this.mmI.dyy();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mGO == 0) {
                                        if (this.mmI.LR(bVar.mGP)) {
                                            i5 = this.mmI.readBits(bVar.mGP);
                                            if (aVar.mGJ && !z) {
                                                if (this.mmI.dyx()) {
                                                    i6 = this.mmI.dyz();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mGO == 1 && !bVar.mGQ) {
                                        if (this.mmI.dyx()) {
                                            i7 = this.mmI.dyz();
                                            if (aVar.mGJ && !z) {
                                                if (this.mmI.dyx()) {
                                                    i8 = this.mmI.dyz();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mmN.a(bVar, readBits, dyy, readBits2, dyy2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.mmw = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mmJ == 9 || (this.mmA && this.mmN.a(this.mmM))) {
                if (this.mmO) {
                    JR(((int) (j - this.mmK)) + i);
                }
                this.mms = this.mmK;
                this.mml = this.mmL;
                this.mmt = false;
                this.mmO = true;
            }
            boolean z2 = this.mmt;
            if (this.mmJ == 5 || (this.mmz && this.mmJ == 1 && this.mmN.dul())) {
                z = true;
            }
            this.mmt = z | z2;
        }

        private void JR(int i) {
            this.med.a(this.mml, this.mmt ? 1 : 0, (int) (this.mmK - this.mms), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0669a {
            private int frameNum;
            private boolean mmP;
            private boolean mmQ;
            private j.b mmR;
            private int mmS;
            private int mmT;
            private int mmU;
            private boolean mmV;
            private boolean mmW;
            private boolean mmX;
            private boolean mmY;
            private int mmZ;
            private int mna;
            private int mnb;
            private int mnc;
            private int mnd;

            private C0669a() {
            }

            public void clear() {
                this.mmQ = false;
                this.mmP = false;
            }

            public void JS(int i) {
                this.mmT = i;
                this.mmQ = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mmR = bVar;
                this.mmS = i;
                this.mmT = i2;
                this.frameNum = i3;
                this.mmU = i4;
                this.mmV = z;
                this.mmW = z2;
                this.mmX = z3;
                this.mmY = z4;
                this.mmZ = i5;
                this.mna = i6;
                this.mnb = i7;
                this.mnc = i8;
                this.mnd = i9;
                this.mmP = true;
                this.mmQ = true;
            }

            public boolean dul() {
                return this.mmQ && (this.mmT == 7 || this.mmT == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0669a c0669a) {
                if (this.mmP) {
                    if (!c0669a.mmP || this.frameNum != c0669a.frameNum || this.mmU != c0669a.mmU || this.mmV != c0669a.mmV) {
                        return true;
                    }
                    if (this.mmW && c0669a.mmW && this.mmX != c0669a.mmX) {
                        return true;
                    }
                    if (this.mmS != c0669a.mmS && (this.mmS == 0 || c0669a.mmS == 0)) {
                        return true;
                    }
                    if (this.mmR.mGO == 0 && c0669a.mmR.mGO == 0 && (this.mna != c0669a.mna || this.mnb != c0669a.mnb)) {
                        return true;
                    }
                    if ((this.mmR.mGO == 1 && c0669a.mmR.mGO == 1 && (this.mnc != c0669a.mnc || this.mnd != c0669a.mnd)) || this.mmY != c0669a.mmY) {
                        return true;
                    }
                    if (this.mmY && c0669a.mmY && this.mmZ != c0669a.mmZ) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
