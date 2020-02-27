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
    private com.google.android.exoplayer2.extractor.m meJ;
    private boolean met;
    private String mmG;
    private long mmX;
    private final t mne;
    private final boolean mnf;
    private final boolean mng;
    private a mnk;
    private long totalBytesWritten;
    private final boolean[] mmU = new boolean[3];
    private final o mnh = new o(7, 128);
    private final o mni = new o(8, 128);
    private final o mnj = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mnl = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.mne = tVar;
        this.mnf = z;
        this.mng = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        com.google.android.exoplayer2.util.j.b(this.mmU);
        this.mnh.reset();
        this.mni.reset();
        this.mnj.reset();
        this.mnk.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmG = dVar.dvE();
        this.meJ = gVar.dK(dVar.dvD(), 2);
        this.mnk = new a(this.meJ, this.mnf, this.mng);
        this.mne.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmX = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dzs = lVar.dzs();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzr();
        this.meJ.a(lVar, lVar.dzr());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzs, this.mmU);
            if (a2 == dzs) {
                v(bArr, position, dzs);
                return;
            }
            int G = com.google.android.exoplayer2.util.j.G(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                v(bArr, position, a2);
            }
            int i2 = dzs - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.mmX);
            b(j, G, this.mmX);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
    }

    private void b(long j, int i, long j2) {
        if (!this.met || this.mnk.dvv()) {
            this.mnh.JZ(i);
            this.mni.JZ(i);
        }
        this.mnj.JZ(i);
        this.mnk.b(j, i, j2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (!this.met || this.mnk.dvv()) {
            this.mnh.w(bArr, i, i2);
            this.mni.w(bArr, i, i2);
        }
        this.mnj.w(bArr, i, i2);
        this.mnk.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.met || this.mnk.dvv()) {
            this.mnh.Ka(i2);
            this.mni.Ka(i2);
            if (!this.met) {
                if (this.mnh.aW() && this.mni.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mnh.mol, this.mnh.mom));
                    arrayList.add(Arrays.copyOf(this.mni.mol, this.mni.mom));
                    j.b C = com.google.android.exoplayer2.util.j.C(this.mnh.mol, 3, this.mnh.mom);
                    j.a D = com.google.android.exoplayer2.util.j.D(this.mni.mol, 3, this.mni.mom);
                    this.meJ.h(Format.a(this.mmG, "video/avc", (String) null, -1, -1, C.width, C.height, -1.0f, arrayList, -1, C.mHp, (DrmInitData) null));
                    this.met = true;
                    this.mnk.a(C);
                    this.mnk.a(D);
                    this.mnh.reset();
                    this.mni.reset();
                }
            } else if (this.mnh.aW()) {
                this.mnk.a(com.google.android.exoplayer2.util.j.C(this.mnh.mol, 3, this.mnh.mom));
                this.mnh.reset();
            } else if (this.mni.aW()) {
                this.mnk.a(com.google.android.exoplayer2.util.j.D(this.mni.mol, 3, this.mni.mom));
                this.mni.reset();
            }
        }
        if (this.mnj.Ka(i2)) {
            this.mnl.I(this.mnj.mol, com.google.android.exoplayer2.util.j.F(this.mnj.mol, this.mnj.mom));
            this.mnl.setPosition(4);
            this.mne.a(j2, this.mnl);
        }
        this.mnk.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m meJ;
        private long mmR;
        private long mmY;
        private boolean mmZ;
        private boolean mnc;
        private final boolean mnf;
        private final boolean mng;
        private int mnp;
        private long mnq;
        private long mnr;
        private boolean mnu;
        private final SparseArray<j.b> mnm = new SparseArray<>();
        private final SparseArray<j.a> mnn = new SparseArray<>();
        private C0677a mns = new C0677a();
        private C0677a mnt = new C0677a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mno = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.meJ = mVar;
            this.mnf = z;
            this.mng = z2;
            reset();
        }

        public boolean dvv() {
            return this.mng;
        }

        public void a(j.b bVar) {
            this.mnm.append(bVar.mHn, bVar);
        }

        public void a(j.a aVar) {
            this.mnn.append(aVar.mnA, aVar);
        }

        public void reset() {
            this.mnc = false;
            this.mnu = false;
            this.mnt.clear();
        }

        public void b(long j, int i, long j2) {
            this.mnp = i;
            this.mnr = j2;
            this.mnq = j;
            if (!this.mnf || this.mnp != 1) {
                if (!this.mng) {
                    return;
                }
                if (this.mnp != 5 && this.mnp != 1 && this.mnp != 2) {
                    return;
                }
            }
            C0677a c0677a = this.mns;
            this.mns = this.mnt;
            this.mnt = c0677a;
            this.mnt.clear();
            this.bufferLength = 0;
            this.mnc = true;
        }

        public void w(byte[] bArr, int i, int i2) {
            if (this.mnc) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mno.H(this.buffer, 0, this.bufferLength);
                if (this.mno.LW(8)) {
                    this.mno.dzp();
                    int readBits = this.mno.readBits(2);
                    this.mno.JU(5);
                    if (this.mno.dzH()) {
                        this.mno.dzI();
                        if (this.mno.dzH()) {
                            int dzI = this.mno.dzI();
                            if (!this.mng) {
                                this.mnc = false;
                                this.mnt.JX(dzI);
                            } else if (this.mno.dzH()) {
                                int dzI2 = this.mno.dzI();
                                if (this.mnn.indexOfKey(dzI2) < 0) {
                                    this.mnc = false;
                                    return;
                                }
                                j.a aVar = this.mnn.get(dzI2);
                                j.b bVar = this.mnm.get(aVar.mHn);
                                if (bVar.mHq) {
                                    if (this.mno.LW(2)) {
                                        this.mno.JU(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mno.LW(bVar.mHs)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mno.readBits(bVar.mHs);
                                    if (!bVar.mHr) {
                                        if (this.mno.LW(1)) {
                                            z = this.mno.dvl();
                                            if (z) {
                                                if (this.mno.LW(1)) {
                                                    z3 = this.mno.dvl();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mnp == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mno.dzH()) {
                                            i4 = this.mno.dzI();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mHt == 0) {
                                        if (this.mno.LW(bVar.mHu)) {
                                            i5 = this.mno.readBits(bVar.mHu);
                                            if (aVar.mHo && !z) {
                                                if (this.mno.dzH()) {
                                                    i6 = this.mno.dzJ();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mHt == 1 && !bVar.mHv) {
                                        if (this.mno.dzH()) {
                                            i7 = this.mno.dzJ();
                                            if (aVar.mHo && !z) {
                                                if (this.mno.dzH()) {
                                                    i8 = this.mno.dzJ();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mnt.a(bVar, readBits, dzI, readBits2, dzI2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.mnc = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mnp == 9 || (this.mng && this.mnt.a(this.mns))) {
                if (this.mnu) {
                    JW(((int) (j - this.mnq)) + i);
                }
                this.mmY = this.mnq;
                this.mmR = this.mnr;
                this.mmZ = false;
                this.mnu = true;
            }
            boolean z2 = this.mmZ;
            if (this.mnp == 5 || (this.mnf && this.mnp == 1 && this.mnt.dvw())) {
                z = true;
            }
            this.mmZ = z | z2;
        }

        private void JW(int i) {
            this.meJ.a(this.mmR, this.mmZ ? 1 : 0, (int) (this.mnq - this.mmY), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0677a {
            private int frameNum;
            private int mnA;
            private boolean mnB;
            private boolean mnC;
            private boolean mnD;
            private boolean mnE;
            private int mnF;
            private int mnG;
            private int mnH;
            private int mnI;
            private int mnJ;
            private boolean mnv;
            private boolean mnw;
            private j.b mnx;
            private int mny;
            private int mnz;

            private C0677a() {
            }

            public void clear() {
                this.mnw = false;
                this.mnv = false;
            }

            public void JX(int i) {
                this.mnz = i;
                this.mnw = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mnx = bVar;
                this.mny = i;
                this.mnz = i2;
                this.frameNum = i3;
                this.mnA = i4;
                this.mnB = z;
                this.mnC = z2;
                this.mnD = z3;
                this.mnE = z4;
                this.mnF = i5;
                this.mnG = i6;
                this.mnH = i7;
                this.mnI = i8;
                this.mnJ = i9;
                this.mnv = true;
                this.mnw = true;
            }

            public boolean dvw() {
                return this.mnw && (this.mnz == 7 || this.mnz == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0677a c0677a) {
                if (this.mnv) {
                    if (!c0677a.mnv || this.frameNum != c0677a.frameNum || this.mnA != c0677a.mnA || this.mnB != c0677a.mnB) {
                        return true;
                    }
                    if (this.mnC && c0677a.mnC && this.mnD != c0677a.mnD) {
                        return true;
                    }
                    if (this.mny != c0677a.mny && (this.mny == 0 || c0677a.mny == 0)) {
                        return true;
                    }
                    if (this.mnx.mHt == 0 && c0677a.mnx.mHt == 0 && (this.mnG != c0677a.mnG || this.mnH != c0677a.mnH)) {
                        return true;
                    }
                    if ((this.mnx.mHt == 1 && c0677a.mnx.mHt == 1 && (this.mnI != c0677a.mnI || this.mnJ != c0677a.mnJ)) || this.mnE != c0677a.mnE) {
                        return true;
                    }
                    if (this.mnE && c0677a.mnE && this.mnF != c0677a.mnF) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
