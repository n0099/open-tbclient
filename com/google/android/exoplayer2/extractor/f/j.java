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
    private com.google.android.exoplayer2.extractor.m mgC;
    private boolean mgm;
    private String moA;
    private long moR;
    private final t moY;
    private final boolean moZ;
    private final boolean mpa;
    private a mpe;
    private long totalBytesWritten;
    private final boolean[] moO = new boolean[3];
    private final o mpb = new o(7, 128);
    private final o mpc = new o(8, 128);
    private final o mpd = new o(6, 128);
    private final com.google.android.exoplayer2.util.l mpf = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.moY = tVar;
        this.moZ = z;
        this.mpa = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        com.google.android.exoplayer2.util.j.b(this.moO);
        this.mpb.reset();
        this.mpc.reset();
        this.mpd.reset();
        this.mpe.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moA = dVar.dwe();
        this.mgC = gVar.dL(dVar.dwd(), 2);
        this.mpe = new a(this.mgC, this.moZ, this.mpa);
        this.moY.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        this.moR = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dzS = lVar.dzS();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzR();
        this.mgC.a(lVar, lVar.dzR());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzS, this.moO);
            if (a2 == dzS) {
                v(bArr, position, dzS);
                return;
            }
            int G = com.google.android.exoplayer2.util.j.G(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                v(bArr, position, a2);
            }
            int i2 = dzS - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.moR);
            b(j, G, this.moR);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
    }

    private void b(long j, int i, long j2) {
        if (!this.mgm || this.mpe.dvV()) {
            this.mpb.Kf(i);
            this.mpc.Kf(i);
        }
        this.mpd.Kf(i);
        this.mpe.b(j, i, j2);
    }

    private void v(byte[] bArr, int i, int i2) {
        if (!this.mgm || this.mpe.dvV()) {
            this.mpb.w(bArr, i, i2);
            this.mpc.w(bArr, i, i2);
        }
        this.mpd.w(bArr, i, i2);
        this.mpe.w(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.mgm || this.mpe.dvV()) {
            this.mpb.Kg(i2);
            this.mpc.Kg(i2);
            if (!this.mgm) {
                if (this.mpb.aW() && this.mpc.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.mpb.mqf, this.mpb.mqg));
                    arrayList.add(Arrays.copyOf(this.mpc.mqf, this.mpc.mqg));
                    j.b C = com.google.android.exoplayer2.util.j.C(this.mpb.mqf, 3, this.mpb.mqg);
                    j.a D = com.google.android.exoplayer2.util.j.D(this.mpc.mqf, 3, this.mpc.mqg);
                    this.mgC.h(Format.a(this.moA, "video/avc", (String) null, -1, -1, C.width, C.height, -1.0f, arrayList, -1, C.mJm, (DrmInitData) null));
                    this.mgm = true;
                    this.mpe.a(C);
                    this.mpe.a(D);
                    this.mpb.reset();
                    this.mpc.reset();
                }
            } else if (this.mpb.aW()) {
                this.mpe.a(com.google.android.exoplayer2.util.j.C(this.mpb.mqf, 3, this.mpb.mqg));
                this.mpb.reset();
            } else if (this.mpc.aW()) {
                this.mpe.a(com.google.android.exoplayer2.util.j.D(this.mpc.mqf, 3, this.mpc.mqg));
                this.mpc.reset();
            }
        }
        if (this.mpd.Kg(i2)) {
            this.mpf.I(this.mpd.mqf, com.google.android.exoplayer2.util.j.F(this.mpd.mqf, this.mpd.mqg));
            this.mpf.setPosition(4);
            this.moY.a(j2, this.mpf);
        }
        this.mpe.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m mgC;
        private long moL;
        private long moS;
        private boolean moT;
        private boolean moW;
        private final boolean moZ;
        private final boolean mpa;
        private int mpj;
        private long mpk;
        private long mpl;
        private boolean mpo;
        private final SparseArray<j.b> mpg = new SparseArray<>();
        private final SparseArray<j.a> mph = new SparseArray<>();
        private C0678a mpm = new C0678a();
        private C0678a mpn = new C0678a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m mpi = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.mgC = mVar;
            this.moZ = z;
            this.mpa = z2;
            reset();
        }

        public boolean dvV() {
            return this.mpa;
        }

        public void a(j.b bVar) {
            this.mpg.append(bVar.mJk, bVar);
        }

        public void a(j.a aVar) {
            this.mph.append(aVar.mpu, aVar);
        }

        public void reset() {
            this.moW = false;
            this.mpo = false;
            this.mpn.clear();
        }

        public void b(long j, int i, long j2) {
            this.mpj = i;
            this.mpl = j2;
            this.mpk = j;
            if (!this.moZ || this.mpj != 1) {
                if (!this.mpa) {
                    return;
                }
                if (this.mpj != 5 && this.mpj != 1 && this.mpj != 2) {
                    return;
                }
            }
            C0678a c0678a = this.mpm;
            this.mpm = this.mpn;
            this.mpn = c0678a;
            this.mpn.clear();
            this.bufferLength = 0;
            this.moW = true;
        }

        public void w(byte[] bArr, int i, int i2) {
            if (this.moW) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.mpi.H(this.buffer, 0, this.bufferLength);
                if (this.mpi.Mc(8)) {
                    this.mpi.dzP();
                    int readBits = this.mpi.readBits(2);
                    this.mpi.Ka(5);
                    if (this.mpi.dAh()) {
                        this.mpi.dAi();
                        if (this.mpi.dAh()) {
                            int dAi = this.mpi.dAi();
                            if (!this.mpa) {
                                this.moW = false;
                                this.mpn.Kd(dAi);
                            } else if (this.mpi.dAh()) {
                                int dAi2 = this.mpi.dAi();
                                if (this.mph.indexOfKey(dAi2) < 0) {
                                    this.moW = false;
                                    return;
                                }
                                j.a aVar = this.mph.get(dAi2);
                                j.b bVar = this.mpg.get(aVar.mJk);
                                if (bVar.mJn) {
                                    if (this.mpi.Mc(2)) {
                                        this.mpi.Ka(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.mpi.Mc(bVar.mJp)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.mpi.readBits(bVar.mJp);
                                    if (!bVar.mJo) {
                                        if (this.mpi.Mc(1)) {
                                            z = this.mpi.dvL();
                                            if (z) {
                                                if (this.mpi.Mc(1)) {
                                                    z3 = this.mpi.dvL();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.mpj == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.mpi.dAh()) {
                                            i4 = this.mpi.dAi();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mJq == 0) {
                                        if (this.mpi.Mc(bVar.mJr)) {
                                            i5 = this.mpi.readBits(bVar.mJr);
                                            if (aVar.mJl && !z) {
                                                if (this.mpi.dAh()) {
                                                    i6 = this.mpi.dAj();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mJq == 1 && !bVar.mJs) {
                                        if (this.mpi.dAh()) {
                                            i7 = this.mpi.dAj();
                                            if (aVar.mJl && !z) {
                                                if (this.mpi.dAh()) {
                                                    i8 = this.mpi.dAj();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.mpn.a(bVar, readBits, dAi, readBits2, dAi2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.moW = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.mpj == 9 || (this.mpa && this.mpn.a(this.mpm))) {
                if (this.mpo) {
                    Kc(((int) (j - this.mpk)) + i);
                }
                this.moS = this.mpk;
                this.moL = this.mpl;
                this.moT = false;
                this.mpo = true;
            }
            boolean z2 = this.moT;
            if (this.mpj == 5 || (this.moZ && this.mpj == 1 && this.mpn.dvW())) {
                z = true;
            }
            this.moT = z | z2;
        }

        private void Kc(int i) {
            this.mgC.a(this.moL, this.moT ? 1 : 0, (int) (this.mpk - this.moS), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0678a {
            private int frameNum;
            private int mpA;
            private int mpB;
            private int mpC;
            private int mpD;
            private boolean mpp;
            private boolean mpq;
            private j.b mpr;
            private int mps;
            private int mpt;
            private int mpu;
            private boolean mpv;
            private boolean mpw;
            private boolean mpx;
            private boolean mpy;
            private int mpz;

            private C0678a() {
            }

            public void clear() {
                this.mpq = false;
                this.mpp = false;
            }

            public void Kd(int i) {
                this.mpt = i;
                this.mpq = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.mpr = bVar;
                this.mps = i;
                this.mpt = i2;
                this.frameNum = i3;
                this.mpu = i4;
                this.mpv = z;
                this.mpw = z2;
                this.mpx = z3;
                this.mpy = z4;
                this.mpz = i5;
                this.mpA = i6;
                this.mpB = i7;
                this.mpC = i8;
                this.mpD = i9;
                this.mpp = true;
                this.mpq = true;
            }

            public boolean dvW() {
                return this.mpq && (this.mpt == 7 || this.mpt == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0678a c0678a) {
                if (this.mpp) {
                    if (!c0678a.mpp || this.frameNum != c0678a.frameNum || this.mpu != c0678a.mpu || this.mpv != c0678a.mpv) {
                        return true;
                    }
                    if (this.mpw && c0678a.mpw && this.mpx != c0678a.mpx) {
                        return true;
                    }
                    if (this.mps != c0678a.mps && (this.mps == 0 || c0678a.mps == 0)) {
                        return true;
                    }
                    if (this.mpr.mJq == 0 && c0678a.mpr.mJq == 0 && (this.mpA != c0678a.mpA || this.mpB != c0678a.mpB)) {
                        return true;
                    }
                    if ((this.mpr.mJq == 1 && c0678a.mpr.mJq == 1 && (this.mpC != c0678a.mpC || this.mpD != c0678a.mpD)) || this.mpy != c0678a.mpy) {
                        return true;
                    }
                    if (this.mpy && c0678a.mpy && this.mpz != c0678a.mpz) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
