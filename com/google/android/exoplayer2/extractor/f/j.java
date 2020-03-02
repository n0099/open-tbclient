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
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mev;
    private String mmI;
    private long mmZ;
    private final t mng;
    private final boolean mnh;
    private final boolean mni;
    private a mnm;
    private long totalBytesWritten;
    private final boolean[] mmW = new boolean[3];
    private final o mnj = new o(7, 128);
    private final o mnk = new o(8, 128);
    private final o mnl = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mnn = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.mng = tVar;
        this.mnh = z;
        this.mni = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        com.google.android.exoplayer2.util.j.b(this.mmW);
        this.mnj.reset();
        this.mnk.reset();
        this.mnl.reset();
        this.mnm.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmI = dVar.dvG();
        this.meL = gVar.dK(dVar.dvF(), 2);
        this.mnm = new a(this.meL, this.mnh, this.mni);
        this.mng.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmZ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dzu = lVar.dzu();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzt();
        this.meL.a(lVar, lVar.dzt());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzu, this.mmW);
            if (a2 == dzu) {
                v(bArr, position, dzu);
                return;
            }
            int G = com.google.android.exoplayer2.util.j.G(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                v(bArr, position, a2);
            }
            int i2 = dzu - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.mmZ);
            b(j, G, this.mmZ);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
    }

    private void b(long j, int i, long j2) {
        if (!this.mev || this.mnm.dvx()) {
            this.mnj.JZ(i);
            this.mnk.JZ(i);
        }
        this.mnl.JZ(i);
        this.mnm.b(j, i, j2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (!this.mev || this.mnm.dvx()) {
            this.mnj.w(bArr, i, i2);
            this.mnk.w(bArr, i, i2);
        }
        this.mnl.w(bArr, i, i2);
        this.mnm.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.mev || this.mnm.dvx()) {
            this.mnj.Ka(i2);
            this.mnk.Ka(i2);
            if (!this.mev) {
                if (this.mnj.aW() && this.mnk.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mnj.moo, this.mnj.mop));
                    arrayList.add(Arrays.copyOf(this.mnk.moo, this.mnk.mop));
                    j.b C = com.google.android.exoplayer2.util.j.C(this.mnj.moo, 3, this.mnj.mop);
                    j.a D = com.google.android.exoplayer2.util.j.D(this.mnk.moo, 3, this.mnk.mop);
                    this.meL.h(Format.a(this.mmI, "video/avc", (String) null, -1, -1, C.width, C.height, -1.0f, arrayList, -1, C.mHr, (DrmInitData) null));
                    this.mev = true;
                    this.mnm.a(C);
                    this.mnm.a(D);
                    this.mnj.reset();
                    this.mnk.reset();
                }
            } else if (this.mnj.aW()) {
                this.mnm.a(com.google.android.exoplayer2.util.j.C(this.mnj.moo, 3, this.mnj.mop));
                this.mnj.reset();
            } else if (this.mnk.aW()) {
                this.mnm.a(com.google.android.exoplayer2.util.j.D(this.mnk.moo, 3, this.mnk.mop));
                this.mnk.reset();
            }
        }
        if (this.mnl.Ka(i2)) {
            this.mnn.I(this.mnl.moo, com.google.android.exoplayer2.util.j.F(this.mnl.moo, this.mnl.mop));
            this.mnn.setPosition(4);
            this.mng.a(j2, this.mnn);
        }
        this.mnm.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m meL;
        private long mmT;
        private long mna;
        private boolean mnb;
        private boolean mne;
        private final boolean mnh;
        private final boolean mni;
        private int mnr;
        private long mns;
        private long mnt;
        private boolean mnw;
        private final SparseArray<j.b> mno = new SparseArray<>();
        private final SparseArray<j.a> mnp = new SparseArray<>();
        private C0677a mnu = new C0677a();
        private C0677a mnv = new C0677a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mnq = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.meL = mVar;
            this.mnh = z;
            this.mni = z2;
            reset();
        }

        public boolean dvx() {
            return this.mni;
        }

        public void a(j.b bVar) {
            this.mno.append(bVar.mHp, bVar);
        }

        public void a(j.a aVar) {
            this.mnp.append(aVar.mnC, aVar);
        }

        public void reset() {
            this.mne = false;
            this.mnw = false;
            this.mnv.clear();
        }

        public void b(long j, int i, long j2) {
            this.mnr = i;
            this.mnt = j2;
            this.mns = j;
            if (!this.mnh || this.mnr != 1) {
                if (!this.mni) {
                    return;
                }
                if (this.mnr != 5 && this.mnr != 1 && this.mnr != 2) {
                    return;
                }
            }
            C0677a c0677a = this.mnu;
            this.mnu = this.mnv;
            this.mnv = c0677a;
            this.mnv.clear();
            this.bufferLength = 0;
            this.mne = true;
        }

        public void w(byte[] bArr, int i, int i2) {
            if (this.mne) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mnq.H(this.buffer, 0, this.bufferLength);
                if (this.mnq.LW(8)) {
                    this.mnq.dzr();
                    int readBits = this.mnq.readBits(2);
                    this.mnq.JU(5);
                    if (this.mnq.dzJ()) {
                        this.mnq.dzK();
                        if (this.mnq.dzJ()) {
                            int dzK = this.mnq.dzK();
                            if (!this.mni) {
                                this.mne = false;
                                this.mnv.JX(dzK);
                            } else if (this.mnq.dzJ()) {
                                int dzK2 = this.mnq.dzK();
                                if (this.mnp.indexOfKey(dzK2) < 0) {
                                    this.mne = false;
                                    return;
                                }
                                j.a aVar = this.mnp.get(dzK2);
                                j.b bVar = this.mno.get(aVar.mHp);
                                if (bVar.mHs) {
                                    if (this.mnq.LW(2)) {
                                        this.mnq.JU(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mnq.LW(bVar.mHu)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mnq.readBits(bVar.mHu);
                                    if (!bVar.mHt) {
                                        if (this.mnq.LW(1)) {
                                            z = this.mnq.dvn();
                                            if (z) {
                                                if (this.mnq.LW(1)) {
                                                    z3 = this.mnq.dvn();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mnr == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mnq.dzJ()) {
                                            i4 = this.mnq.dzK();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mHv == 0) {
                                        if (this.mnq.LW(bVar.mHw)) {
                                            i5 = this.mnq.readBits(bVar.mHw);
                                            if (aVar.mHq && !z) {
                                                if (this.mnq.dzJ()) {
                                                    i6 = this.mnq.dzL();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mHv == 1 && !bVar.mHx) {
                                        if (this.mnq.dzJ()) {
                                            i7 = this.mnq.dzL();
                                            if (aVar.mHq && !z) {
                                                if (this.mnq.dzJ()) {
                                                    i8 = this.mnq.dzL();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mnv.a(bVar, readBits, dzK, readBits2, dzK2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.mne = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mnr == 9 || (this.mni && this.mnv.a(this.mnu))) {
                if (this.mnw) {
                    JW(((int) (j - this.mns)) + i);
                }
                this.mna = this.mns;
                this.mmT = this.mnt;
                this.mnb = false;
                this.mnw = true;
            }
            boolean z2 = this.mnb;
            if (this.mnr == 5 || (this.mnh && this.mnr == 1 && this.mnv.dvy())) {
                z = true;
            }
            this.mnb = z | z2;
        }

        private void JW(int i) {
            this.meL.a(this.mmT, this.mnb ? 1 : 0, (int) (this.mns - this.mna), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0677a {
            private int frameNum;
            private int mnA;
            private int mnB;
            private int mnC;
            private boolean mnD;
            private boolean mnE;
            private boolean mnF;
            private boolean mnG;
            private int mnH;
            private int mnI;
            private int mnJ;
            private int mnK;
            private int mnL;
            private boolean mnx;
            private boolean mny;
            private j.b mnz;

            private C0677a() {
            }

            public void clear() {
                this.mny = false;
                this.mnx = false;
            }

            public void JX(int i) {
                this.mnB = i;
                this.mny = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mnz = bVar;
                this.mnA = i;
                this.mnB = i2;
                this.frameNum = i3;
                this.mnC = i4;
                this.mnD = z;
                this.mnE = z2;
                this.mnF = z3;
                this.mnG = z4;
                this.mnH = i5;
                this.mnI = i6;
                this.mnJ = i7;
                this.mnK = i8;
                this.mnL = i9;
                this.mnx = true;
                this.mny = true;
            }

            public boolean dvy() {
                return this.mny && (this.mnB == 7 || this.mnB == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0677a c0677a) {
                if (this.mnx) {
                    if (!c0677a.mnx || this.frameNum != c0677a.frameNum || this.mnC != c0677a.mnC || this.mnD != c0677a.mnD) {
                        return true;
                    }
                    if (this.mnE && c0677a.mnE && this.mnF != c0677a.mnF) {
                        return true;
                    }
                    if (this.mnA != c0677a.mnA && (this.mnA == 0 || c0677a.mnA == 0)) {
                        return true;
                    }
                    if (this.mnz.mHv == 0 && c0677a.mnz.mHv == 0 && (this.mnI != c0677a.mnI || this.mnJ != c0677a.mnJ)) {
                        return true;
                    }
                    if ((this.mnz.mHv == 1 && c0677a.mnz.mHv == 1 && (this.mnK != c0677a.mnK || this.mnL != c0677a.mnL)) || this.mnG != c0677a.mnG) {
                        return true;
                    }
                    if (this.mnG && c0677a.mnG && this.mnH != c0677a.mnH) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
