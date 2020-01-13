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
    private boolean mdI;
    private com.google.android.exoplayer2.extractor.m mdY;
    private String mlV;
    private long mmm;
    private final t mmt;
    private final boolean mmu;
    private final boolean mmv;
    private a mmz;
    private long totalBytesWritten;
    private final boolean[] mmj = new boolean[3];
    private final o mmw = new o(7, 128);
    private final o mmx = new o(8, 128);
    private final o mmy = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mmA = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.mmt = tVar;
        this.mmu = z;
        this.mmv = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        com.google.android.exoplayer2.util.j.b(this.mmj);
        this.mmw.reset();
        this.mmx.reset();
        this.mmy.reset();
        this.mmz.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlV = dVar.dur();
        this.mdY = gVar.dH(dVar.duq(), 2);
        this.mmz = new a(this.mdY, this.mmu, this.mmv);
        this.mmt.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmm = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dyg = lVar.dyg();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dyf();
        this.mdY.a(lVar, lVar.dyf());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyg, this.mmj);
            if (a2 == dyg) {
                r(bArr, position, dyg);
                return;
            }
            int E = com.google.android.exoplayer2.util.j.E(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                r(bArr, position, a2);
            }
            int i2 = dyg - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.mmm);
            b(j, E, this.mmm);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private void b(long j, int i, long j2) {
        if (!this.mdI || this.mmz.dui()) {
            this.mmw.JU(i);
            this.mmx.JU(i);
        }
        this.mmy.JU(i);
        this.mmz.b(j, i, j2);
    }

    private void r(byte[] bArr, int i, int i2) {
        if (!this.mdI || this.mmz.dui()) {
            this.mmw.s(bArr, i, i2);
            this.mmx.s(bArr, i, i2);
        }
        this.mmy.s(bArr, i, i2);
        this.mmz.s(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.mdI || this.mmz.dui()) {
            this.mmw.JV(i2);
            this.mmx.JV(i2);
            if (!this.mdI) {
                if (this.mmw.aW() && this.mmx.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mmw.mnA, this.mmw.mnB));
                    arrayList.add(Arrays.copyOf(this.mmx.mnA, this.mmx.mnB));
                    j.b y = com.google.android.exoplayer2.util.j.y(this.mmw.mnA, 3, this.mmw.mnB);
                    j.a z = com.google.android.exoplayer2.util.j.z(this.mmx.mnA, 3, this.mmx.mnB);
                    this.mdY.h(Format.a(this.mlV, "video/avc", (String) null, -1, -1, y.width, y.height, -1.0f, arrayList, -1, y.mGF, (DrmInitData) null));
                    this.mdI = true;
                    this.mmz.a(y);
                    this.mmz.a(z);
                    this.mmw.reset();
                    this.mmx.reset();
                }
            } else if (this.mmw.aW()) {
                this.mmz.a(com.google.android.exoplayer2.util.j.y(this.mmw.mnA, 3, this.mmw.mnB));
                this.mmw.reset();
            } else if (this.mmx.aW()) {
                this.mmz.a(com.google.android.exoplayer2.util.j.z(this.mmx.mnA, 3, this.mmx.mnB));
                this.mmx.reset();
            }
        }
        if (this.mmy.JV(i2)) {
            this.mmA.G(this.mmy.mnA, com.google.android.exoplayer2.util.j.D(this.mmy.mnA, this.mmy.mnB));
            this.mmA.setPosition(4);
            this.mmt.a(j2, this.mmA);
        }
        this.mmz.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m mdY;
        private int mmE;
        private long mmF;
        private long mmG;
        private boolean mmJ;
        private long mmg;
        private long mmn;
        private boolean mmo;
        private boolean mmr;
        private final boolean mmu;
        private final boolean mmv;
        private final SparseArray<j.b> mmB = new SparseArray<>();
        private final SparseArray<j.a> mmC = new SparseArray<>();
        private C0669a mmH = new C0669a();
        private C0669a mmI = new C0669a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mmD = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.mdY = mVar;
            this.mmu = z;
            this.mmv = z2;
            reset();
        }

        public boolean dui() {
            return this.mmv;
        }

        public void a(j.b bVar) {
            this.mmB.append(bVar.mGD, bVar);
        }

        public void a(j.a aVar) {
            this.mmC.append(aVar.mmP, aVar);
        }

        public void reset() {
            this.mmr = false;
            this.mmJ = false;
            this.mmI.clear();
        }

        public void b(long j, int i, long j2) {
            this.mmE = i;
            this.mmG = j2;
            this.mmF = j;
            if (!this.mmu || this.mmE != 1) {
                if (!this.mmv) {
                    return;
                }
                if (this.mmE != 5 && this.mmE != 1 && this.mmE != 2) {
                    return;
                }
            }
            C0669a c0669a = this.mmH;
            this.mmH = this.mmI;
            this.mmI = c0669a;
            this.mmI.clear();
            this.bufferLength = 0;
            this.mmr = true;
        }

        public void s(byte[] bArr, int i, int i2) {
            if (this.mmr) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mmD.D(this.buffer, 0, this.bufferLength);
                if (this.mmD.LR(8)) {
                    this.mmD.dyd();
                    int readBits = this.mmD.readBits(2);
                    this.mmD.JP(5);
                    if (this.mmD.dyv()) {
                        this.mmD.dyw();
                        if (this.mmD.dyv()) {
                            int dyw = this.mmD.dyw();
                            if (!this.mmv) {
                                this.mmr = false;
                                this.mmI.JS(dyw);
                            } else if (this.mmD.dyv()) {
                                int dyw2 = this.mmD.dyw();
                                if (this.mmC.indexOfKey(dyw2) < 0) {
                                    this.mmr = false;
                                    return;
                                }
                                j.a aVar = this.mmC.get(dyw2);
                                j.b bVar = this.mmB.get(aVar.mGD);
                                if (bVar.mGG) {
                                    if (this.mmD.LR(2)) {
                                        this.mmD.JP(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mmD.LR(bVar.mGI)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mmD.readBits(bVar.mGI);
                                    if (!bVar.mGH) {
                                        if (this.mmD.LR(1)) {
                                            z = this.mmD.dtY();
                                            if (z) {
                                                if (this.mmD.LR(1)) {
                                                    z3 = this.mmD.dtY();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mmE == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mmD.dyv()) {
                                            i4 = this.mmD.dyw();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mGJ == 0) {
                                        if (this.mmD.LR(bVar.mGK)) {
                                            i5 = this.mmD.readBits(bVar.mGK);
                                            if (aVar.mGE && !z) {
                                                if (this.mmD.dyv()) {
                                                    i6 = this.mmD.dyx();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mGJ == 1 && !bVar.mGL) {
                                        if (this.mmD.dyv()) {
                                            i7 = this.mmD.dyx();
                                            if (aVar.mGE && !z) {
                                                if (this.mmD.dyv()) {
                                                    i8 = this.mmD.dyx();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mmI.a(bVar, readBits, dyw, readBits2, dyw2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.mmr = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mmE == 9 || (this.mmv && this.mmI.a(this.mmH))) {
                if (this.mmJ) {
                    JR(((int) (j - this.mmF)) + i);
                }
                this.mmn = this.mmF;
                this.mmg = this.mmG;
                this.mmo = false;
                this.mmJ = true;
            }
            boolean z2 = this.mmo;
            if (this.mmE == 5 || (this.mmu && this.mmE == 1 && this.mmI.duj())) {
                z = true;
            }
            this.mmo = z | z2;
        }

        private void JR(int i) {
            this.mdY.a(this.mmg, this.mmo ? 1 : 0, (int) (this.mmF - this.mmn), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0669a {
            private int frameNum;
            private boolean mmK;
            private boolean mmL;
            private j.b mmM;
            private int mmN;
            private int mmO;
            private int mmP;
            private boolean mmQ;
            private boolean mmR;
            private boolean mmS;
            private boolean mmT;
            private int mmU;
            private int mmV;
            private int mmW;
            private int mmX;
            private int mmY;

            private C0669a() {
            }

            public void clear() {
                this.mmL = false;
                this.mmK = false;
            }

            public void JS(int i) {
                this.mmO = i;
                this.mmL = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mmM = bVar;
                this.mmN = i;
                this.mmO = i2;
                this.frameNum = i3;
                this.mmP = i4;
                this.mmQ = z;
                this.mmR = z2;
                this.mmS = z3;
                this.mmT = z4;
                this.mmU = i5;
                this.mmV = i6;
                this.mmW = i7;
                this.mmX = i8;
                this.mmY = i9;
                this.mmK = true;
                this.mmL = true;
            }

            public boolean duj() {
                return this.mmL && (this.mmO == 7 || this.mmO == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0669a c0669a) {
                if (this.mmK) {
                    if (!c0669a.mmK || this.frameNum != c0669a.frameNum || this.mmP != c0669a.mmP || this.mmQ != c0669a.mmQ) {
                        return true;
                    }
                    if (this.mmR && c0669a.mmR && this.mmS != c0669a.mmS) {
                        return true;
                    }
                    if (this.mmN != c0669a.mmN && (this.mmN == 0 || c0669a.mmN == 0)) {
                        return true;
                    }
                    if (this.mmM.mGJ == 0 && c0669a.mmM.mGJ == 0 && (this.mmV != c0669a.mmV || this.mmW != c0669a.mmW)) {
                        return true;
                    }
                    if ((this.mmM.mGJ == 1 && c0669a.mmM.mGJ == 1 && (this.mmX != c0669a.mmX || this.mmY != c0669a.mmY)) || this.mmT != c0669a.mmT) {
                        return true;
                    }
                    if (this.mmT && c0669a.mmT && this.mmU != c0669a.mmU) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
