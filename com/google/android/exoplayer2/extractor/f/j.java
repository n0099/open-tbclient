package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.util.j;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class j implements h {
    private boolean lZQ;
    private com.google.android.exoplayer2.extractor.m mah;
    private final t miF;
    private final boolean miG;
    private final boolean miH;
    private a miL;
    private String mig;
    private long miy;
    private long totalBytesWritten;
    private final boolean[] miv = new boolean[3];
    private final o miI = new o(7, 128);
    private final o miJ = new o(8, 128);
    private final o miK = new o(6, 128);
    private final com.google.android.exoplayer2.util.l miM = new com.google.android.exoplayer2.util.l();

    public j(t tVar, boolean z, boolean z2) {
        this.miF = tVar;
        this.miG = z;
        this.miH = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        com.google.android.exoplayer2.util.j.b(this.miv);
        this.miI.reset();
        this.miJ.reset();
        this.miK.reset();
        this.miL.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mig = dVar.dtg();
        this.mah = gVar.dJ(dVar.dtf(), 2);
        this.miL = new a(this.mah, this.miG, this.miH);
        this.miF.a(gVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.miy = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        int position = lVar.getPosition();
        int dwW = lVar.dwW();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dwV();
        this.mah.a(lVar, lVar.dwV());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dwW, this.miv);
            if (a2 == dwW) {
                s(bArr, position, dwW);
                return;
            }
            int E = com.google.android.exoplayer2.util.j.E(bArr, a2);
            int i = a2 - position;
            if (i > 0) {
                s(bArr, position, a2);
            }
            int i2 = dwW - a2;
            long j = this.totalBytesWritten - i2;
            a(j, i2, i < 0 ? -i : 0, this.miy);
            a(j, E, this.miy);
            position = a2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
    }

    private void a(long j, int i, long j2) {
        if (!this.lZQ || this.miL.dsW()) {
            this.miI.JL(i);
            this.miJ.JL(i);
        }
        this.miK.JL(i);
        this.miL.a(j, i, j2);
    }

    private void s(byte[] bArr, int i, int i2) {
        if (!this.lZQ || this.miL.dsW()) {
            this.miI.t(bArr, i, i2);
            this.miJ.t(bArr, i, i2);
        }
        this.miK.t(bArr, i, i2);
        this.miL.t(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.lZQ || this.miL.dsW()) {
            this.miI.JM(i2);
            this.miJ.JM(i2);
            if (!this.lZQ) {
                if (this.miI.aW() && this.miJ.aW()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.miI.mjM, this.miI.mjN));
                    arrayList.add(Arrays.copyOf(this.miJ.mjM, this.miJ.mjN));
                    j.b z = com.google.android.exoplayer2.util.j.z(this.miI.mjM, 3, this.miI.mjN);
                    j.a A = com.google.android.exoplayer2.util.j.A(this.miJ.mjM, 3, this.miJ.mjN);
                    this.mah.h(Format.a(this.mig, "video/avc", (String) null, -1, -1, z.width, z.height, -1.0f, arrayList, -1, z.mCO, (DrmInitData) null));
                    this.lZQ = true;
                    this.miL.a(z);
                    this.miL.a(A);
                    this.miI.reset();
                    this.miJ.reset();
                }
            } else if (this.miI.aW()) {
                this.miL.a(com.google.android.exoplayer2.util.j.z(this.miI.mjM, 3, this.miI.mjN));
                this.miI.reset();
            } else if (this.miJ.aW()) {
                this.miL.a(com.google.android.exoplayer2.util.j.A(this.miJ.mjM, 3, this.miJ.mjN));
                this.miJ.reset();
            }
        }
        if (this.miK.JM(i2)) {
            this.miM.G(this.miK.mjM, com.google.android.exoplayer2.util.j.D(this.miK.mjM, this.miK.mjN));
            this.miM.setPosition(4);
            this.miF.a(j2, this.miM);
        }
        this.miL.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        private int bufferLength;
        private final com.google.android.exoplayer2.extractor.m mah;
        private boolean miA;
        private boolean miD;
        private final boolean miG;
        private final boolean miH;
        private int miQ;
        private long miR;
        private long miS;
        private boolean miV;
        private long mis;
        private long miz;
        private final SparseArray<j.b> miN = new SparseArray<>();
        private final SparseArray<j.a> miO = new SparseArray<>();
        private C0663a miT = new C0663a();
        private C0663a miU = new C0663a();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.m miP = new com.google.android.exoplayer2.util.m(this.buffer, 0, 0);

        public a(com.google.android.exoplayer2.extractor.m mVar, boolean z, boolean z2) {
            this.mah = mVar;
            this.miG = z;
            this.miH = z2;
            reset();
        }

        public boolean dsW() {
            return this.miH;
        }

        public void a(j.b bVar) {
            this.miN.append(bVar.mCM, bVar);
        }

        public void a(j.a aVar) {
            this.miO.append(aVar.mjb, aVar);
        }

        public void reset() {
            this.miD = false;
            this.miV = false;
            this.miU.clear();
        }

        public void a(long j, int i, long j2) {
            this.miQ = i;
            this.miS = j2;
            this.miR = j;
            if (!this.miG || this.miQ != 1) {
                if (!this.miH) {
                    return;
                }
                if (this.miQ != 5 && this.miQ != 1 && this.miQ != 2) {
                    return;
                }
            }
            C0663a c0663a = this.miT;
            this.miT = this.miU;
            this.miU = c0663a;
            this.miU.clear();
            this.bufferLength = 0;
            this.miD = true;
        }

        public void t(byte[] bArr, int i, int i2) {
            if (this.miD) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bufferLength + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i3);
                this.bufferLength = i3 + this.bufferLength;
                this.miP.E(this.buffer, 0, this.bufferLength);
                if (this.miP.LI(8)) {
                    this.miP.dwT();
                    int readBits = this.miP.readBits(2);
                    this.miP.JG(5);
                    if (this.miP.dxl()) {
                        this.miP.dxm();
                        if (this.miP.dxl()) {
                            int dxm = this.miP.dxm();
                            if (!this.miH) {
                                this.miD = false;
                                this.miU.JJ(dxm);
                            } else if (this.miP.dxl()) {
                                int dxm2 = this.miP.dxm();
                                if (this.miO.indexOfKey(dxm2) < 0) {
                                    this.miD = false;
                                    return;
                                }
                                j.a aVar = this.miO.get(dxm2);
                                j.b bVar = this.miN.get(aVar.mCM);
                                if (bVar.mCP) {
                                    if (this.miP.LI(2)) {
                                        this.miP.JG(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.miP.LI(bVar.mCR)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int readBits2 = this.miP.readBits(bVar.mCR);
                                    if (!bVar.mCQ) {
                                        if (this.miP.LI(1)) {
                                            z = this.miP.dsM();
                                            if (z) {
                                                if (this.miP.LI(1)) {
                                                    z3 = this.miP.dsM();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    boolean z4 = this.miQ == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.miP.dxl()) {
                                            i4 = this.miP.dxm();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.mCS == 0) {
                                        if (this.miP.LI(bVar.mCT)) {
                                            i5 = this.miP.readBits(bVar.mCT);
                                            if (aVar.mCN && !z) {
                                                if (this.miP.dxl()) {
                                                    i6 = this.miP.dxn();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (bVar.mCS == 1 && !bVar.mCU) {
                                        if (this.miP.dxl()) {
                                            i7 = this.miP.dxn();
                                            if (aVar.mCN && !z) {
                                                if (this.miP.dxl()) {
                                                    i8 = this.miP.dxn();
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.miU.a(bVar, readBits, dxm, readBits2, dxm2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.miD = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void B(long j, int i) {
            boolean z = false;
            if (this.miQ == 9 || (this.miH && this.miU.a(this.miT))) {
                if (this.miV) {
                    JI(((int) (j - this.miR)) + i);
                }
                this.miz = this.miR;
                this.mis = this.miS;
                this.miA = false;
                this.miV = true;
            }
            boolean z2 = this.miA;
            if (this.miQ == 5 || (this.miG && this.miQ == 1 && this.miU.dsX())) {
                z = true;
            }
            this.miA = z | z2;
        }

        private void JI(int i) {
            this.mah.a(this.mis, this.miA ? 1 : 0, (int) (this.miR - this.miz), i, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.extractor.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0663a {
            private int frameNum;
            private boolean miW;
            private boolean miX;
            private j.b miY;
            private int miZ;
            private int mja;
            private int mjb;
            private boolean mjc;
            private boolean mjd;
            private boolean mje;
            private boolean mjf;
            private int mjg;
            private int mjh;
            private int mji;
            private int mjj;
            private int mjk;

            private C0663a() {
            }

            public void clear() {
                this.miX = false;
                this.miW = false;
            }

            public void JJ(int i) {
                this.mja = i;
                this.miX = true;
            }

            public void a(j.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.miY = bVar;
                this.miZ = i;
                this.mja = i2;
                this.frameNum = i3;
                this.mjb = i4;
                this.mjc = z;
                this.mjd = z2;
                this.mje = z3;
                this.mjf = z4;
                this.mjg = i5;
                this.mjh = i6;
                this.mji = i7;
                this.mjj = i8;
                this.mjk = i9;
                this.miW = true;
                this.miX = true;
            }

            public boolean dsX() {
                return this.miX && (this.mja == 7 || this.mja == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0663a c0663a) {
                if (this.miW) {
                    if (!c0663a.miW || this.frameNum != c0663a.frameNum || this.mjb != c0663a.mjb || this.mjc != c0663a.mjc) {
                        return true;
                    }
                    if (this.mjd && c0663a.mjd && this.mje != c0663a.mje) {
                        return true;
                    }
                    if (this.miZ != c0663a.miZ && (this.miZ == 0 || c0663a.miZ == 0)) {
                        return true;
                    }
                    if (this.miY.mCS == 0 && c0663a.miY.mCS == 0 && (this.mjh != c0663a.mjh || this.mji != c0663a.mji)) {
                        return true;
                    }
                    if ((this.miY.mCS == 1 && c0663a.miY.mCS == 1 && (this.mjj != c0663a.mjj || this.mjk != c0663a.mjk)) || this.mjf != c0663a.mjf) {
                        return true;
                    }
                    if (this.mjf && c0663a.mjf && this.mjg != c0663a.mjg) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
