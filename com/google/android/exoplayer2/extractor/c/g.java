package com.google.android.exoplayer2.extractor.c;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.c.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class g implements com.google.android.exoplayer2.extractor.e, com.google.android.exoplayer2.extractor.l {
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mmk = v.QE("qt  ");
    private final int flags;
    private long mbx;
    private final com.google.android.exoplayer2.util.l mgD;
    private final com.google.android.exoplayer2.util.l mgE;
    private com.google.android.exoplayer2.extractor.g mgu;
    private int mgv;
    private int mhJ;
    private int mhK;
    private final com.google.android.exoplayer2.util.l mlj;
    private final Stack<a.C0675a> mll;
    private int mln;
    private long mlo;
    private int mlp;
    private com.google.android.exoplayer2.util.l mlq;
    private a[] mml;
    private boolean mmm;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.mlj = new com.google.android.exoplayer2.util.l(16);
        this.mll = new Stack<>();
        this.mgD = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mIW);
        this.mgE = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mgu = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mll.clear();
        this.mlp = 0;
        this.mhK = 0;
        this.mhJ = 0;
        if (j == 0) {
            dvC();
        } else if (this.mml != null) {
            fQ(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mgv) {
                case 0:
                    if (n(fVar)) {
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (!b(fVar, kVar)) {
                        break;
                    } else {
                        return 1;
                    }
                case 2:
                    return c(fVar, kVar);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mbx;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mml;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mmn;
            int fR = mVar.fR(j);
            if (fR == -1) {
                fR = mVar.fS(j);
            }
            long j3 = mVar.mfJ[fR];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dvC() {
        this.mgv = 0;
        this.mlp = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.mlp == 0) {
            if (!fVar.d(this.mlj.data, 0, 8, true)) {
                return false;
            }
            this.mlp = 8;
            this.mlj.setPosition(0);
            this.mlo = this.mlj.readUnsignedInt();
            this.mln = this.mlj.readInt();
        }
        if (this.mlo == 1) {
            fVar.readFully(this.mlj.data, 8, 8);
            this.mlp += 8;
            this.mlo = this.mlj.dAe();
        } else if (this.mlo == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.mll.isEmpty()) {
                length = this.mll.peek().endPosition;
            }
            if (length != -1) {
                this.mlo = (length - fVar.getPosition()) + this.mlp;
            }
        }
        if (this.mlo < this.mlp) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JU(this.mln)) {
            long position = (fVar.getPosition() + this.mlo) - this.mlp;
            this.mll.add(new a.C0675a(this.mln, position));
            if (this.mlo == this.mlp) {
                fP(position);
            } else {
                dvC();
            }
        } else if (JT(this.mln)) {
            com.google.android.exoplayer2.util.a.checkState(this.mlp == 8);
            com.google.android.exoplayer2.util.a.checkState(this.mlo <= 2147483647L);
            this.mlq = new com.google.android.exoplayer2.util.l((int) this.mlo);
            System.arraycopy(this.mlj.data, 0, this.mlq.data, 0, 8);
            this.mgv = 1;
        } else {
            this.mlq = null;
            this.mgv = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.mlo - this.mlp;
        long position = fVar.getPosition() + j;
        if (this.mlq != null) {
            fVar.readFully(this.mlq.data, this.mlp, (int) j);
            if (this.mln == com.google.android.exoplayer2.extractor.c.a.miL) {
                this.mmm = y(this.mlq);
                z = false;
            } else if (this.mll.isEmpty()) {
                z = false;
            } else {
                this.mll.peek().a(new a.b(this.mln, this.mlq));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.JB((int) j);
            z = false;
        } else {
            kVar.fOW = j + fVar.getPosition();
            z = true;
        }
        fP(position);
        return z && this.mgv != 2;
    }

    private void fP(long j) throws ParserException {
        while (!this.mll.isEmpty() && this.mll.peek().endPosition == j) {
            a.C0675a pop = this.mll.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mjm) {
                f(pop);
                this.mll.clear();
                this.mgv = 2;
            } else if (!this.mll.isEmpty()) {
                this.mll.peek().a(pop);
            }
        }
        if (this.mgv != 2) {
            dvC();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mmk) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dzR() > 0) {
            if (lVar.readInt() == mmk) {
                return true;
            }
        }
        return false;
    }

    private void f(a.C0675a c0675a) throws ParserException {
        Metadata metadata;
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        com.google.android.exoplayer2.extractor.i iVar = new com.google.android.exoplayer2.extractor.i();
        a.b JR = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mkl);
        if (JR == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JR, this.mmm);
            if (a2 != null) {
                iVar.c(a2);
            }
            metadata = a2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            long j3 = j2;
            long j4 = j;
            if (i2 < c0675a.mkB.size()) {
                a.C0675a c0675a2 = c0675a.mkB.get(i2);
                if (c0675a2.type != com.google.android.exoplayer2.extractor.c.a.mjo) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0675a2, c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjn), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mmm);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0675a2.JS(com.google.android.exoplayer2.extractor.c.a.mjp).JS(com.google.android.exoplayer2.extractor.c.a.mjq).JS(com.google.android.exoplayer2.extractor.c.a.mjr), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.mgu.dL(i2, a3.type));
                            Format Jb = a3.mbs.Jb(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.dvt()) {
                                    Jb = Jb.dG(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    Jb = Jb.b(metadata);
                                }
                            }
                            aVar.miA.h(Jb);
                            j4 = Math.max(j4, a3.mbx);
                            arrayList.add(aVar);
                            j2 = a4.mfJ[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.mbx = j4;
                this.mml = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.mgu.dvs();
                this.mgu.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dvE = dvE();
        if (dvE == -1) {
            return -1;
        }
        a aVar = this.mml[dvE];
        com.google.android.exoplayer2.extractor.m mVar = aVar.miA;
        int i2 = aVar.mkU;
        long j = aVar.mmn.mfJ[i2];
        int i3 = aVar.mmn.mfI[i2];
        if (aVar.mlB.mmr == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mhK;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fOW = j;
            return 1;
        }
        fVar.JB((int) position);
        if (aVar.mlB.mgF != 0) {
            byte[] bArr = this.mgE.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mlB.mgF;
            int i5 = 4 - aVar.mlB.mgF;
            while (this.mhK < i3) {
                if (this.mhJ == 0) {
                    fVar.readFully(this.mgE.data, i5, i4);
                    this.mgE.setPosition(0);
                    this.mhJ = this.mgE.dAc();
                    this.mgD.setPosition(0);
                    mVar.a(this.mgD, 4);
                    this.mhK += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mhJ, false);
                    this.mhK += a2;
                    this.mhJ -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mhK < i3) {
                int a3 = mVar.a(fVar, i3 - this.mhK, false);
                this.mhK += a3;
                this.mhJ -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mmn.mmQ[i2], aVar.mmn.mkY[i2], i, 0, null);
        aVar.mkU++;
        this.mhK = 0;
        this.mhJ = 0;
        return 0;
    }

    private int dvE() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mml.length; i2++) {
            a aVar = this.mml[i2];
            int i3 = aVar.mkU;
            if (i3 != aVar.mmn.sampleCount) {
                long j2 = aVar.mmn.mfJ[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private void fQ(long j) {
        a[] aVarArr;
        for (a aVar : this.mml) {
            m mVar = aVar.mmn;
            int fR = mVar.fR(j);
            if (fR == -1) {
                fR = mVar.fS(j);
            }
            aVar.mkU = fR;
        }
    }

    private static boolean JT(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mjC || i == com.google.android.exoplayer2.extractor.c.a.mjn || i == com.google.android.exoplayer2.extractor.c.a.mjD || i == com.google.android.exoplayer2.extractor.c.a.mjE || i == com.google.android.exoplayer2.extractor.c.a.mjX || i == com.google.android.exoplayer2.extractor.c.a.mjY || i == com.google.android.exoplayer2.extractor.c.a.mjZ || i == com.google.android.exoplayer2.extractor.c.a.mjB || i == com.google.android.exoplayer2.extractor.c.a.mka || i == com.google.android.exoplayer2.extractor.c.a.mkb || i == com.google.android.exoplayer2.extractor.c.a.mkc || i == com.google.android.exoplayer2.extractor.c.a.mkd || i == com.google.android.exoplayer2.extractor.c.a.mke || i == com.google.android.exoplayer2.extractor.c.a.mjz || i == com.google.android.exoplayer2.extractor.c.a.miL || i == com.google.android.exoplayer2.extractor.c.a.mkl;
    }

    private static boolean JU(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mjm || i == com.google.android.exoplayer2.extractor.c.a.mjo || i == com.google.android.exoplayer2.extractor.c.a.mjp || i == com.google.android.exoplayer2.extractor.c.a.mjq || i == com.google.android.exoplayer2.extractor.c.a.mjr || i == com.google.android.exoplayer2.extractor.c.a.mjA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m miA;
        public int mkU;
        public final j mlB;
        public final m mmn;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mlB = jVar;
            this.mmn = mVar;
            this.miA = mVar2;
        }
    }
}
