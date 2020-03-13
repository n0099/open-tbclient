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
    public static final com.google.android.exoplayer2.extractor.h meI = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mkE = v.QF("qt  ");
    private final int flags;
    private long lZO;
    private com.google.android.exoplayer2.extractor.g meO;
    private int meP;
    private final com.google.android.exoplayer2.util.l meX;
    private final com.google.android.exoplayer2.util.l meY;
    private int mgd;
    private int mge;
    private final com.google.android.exoplayer2.util.l mjD;
    private final Stack<a.C0674a> mjF;
    private int mjH;
    private long mjI;
    private int mjJ;
    private com.google.android.exoplayer2.util.l mjK;
    private a[] mkF;
    private boolean mkG;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.mjD = new com.google.android.exoplayer2.util.l(16);
        this.mjF = new Stack<>();
        this.meX = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mHm);
        this.meY = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meO = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mjF.clear();
        this.mjJ = 0;
        this.mge = 0;
        this.mgd = 0;
        if (j == 0) {
            dvf();
        } else if (this.mkF != null) {
            fP(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meP) {
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
    public boolean duR() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZO;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mkF;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mkH;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            long j3 = mVar.med[fQ];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dvf() {
        this.meP = 0;
        this.mjJ = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.mjJ == 0) {
            if (!fVar.d(this.mjD.data, 0, 8, true)) {
                return false;
            }
            this.mjJ = 8;
            this.mjD.setPosition(0);
            this.mjI = this.mjD.readUnsignedInt();
            this.mjH = this.mjD.readInt();
        }
        if (this.mjI == 1) {
            fVar.readFully(this.mjD.data, 8, 8);
            this.mjJ += 8;
            this.mjI = this.mjD.dzH();
        } else if (this.mjI == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.mjF.isEmpty()) {
                length = this.mjF.peek().endPosition;
            }
            if (length != -1) {
                this.mjI = (length - fVar.getPosition()) + this.mjJ;
            }
        }
        if (this.mjI < this.mjJ) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JO(this.mjH)) {
            long position = (fVar.getPosition() + this.mjI) - this.mjJ;
            this.mjF.add(new a.C0674a(this.mjH, position));
            if (this.mjI == this.mjJ) {
                fO(position);
            } else {
                dvf();
            }
        } else if (JN(this.mjH)) {
            com.google.android.exoplayer2.util.a.checkState(this.mjJ == 8);
            com.google.android.exoplayer2.util.a.checkState(this.mjI <= 2147483647L);
            this.mjK = new com.google.android.exoplayer2.util.l((int) this.mjI);
            System.arraycopy(this.mjD.data, 0, this.mjK.data, 0, 8);
            this.meP = 1;
        } else {
            this.mjK = null;
            this.meP = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.mjI - this.mjJ;
        long position = fVar.getPosition() + j;
        if (this.mjK != null) {
            fVar.readFully(this.mjK.data, this.mjJ, (int) j);
            if (this.mjH == com.google.android.exoplayer2.extractor.c.a.mhd) {
                this.mkG = y(this.mjK);
                z = false;
            } else if (this.mjF.isEmpty()) {
                z = false;
            } else {
                this.mjF.peek().a(new a.b(this.mjH, this.mjK));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.Jv((int) j);
            z = false;
        } else {
            kVar.fOo = j + fVar.getPosition();
            z = true;
        }
        fO(position);
        return z && this.meP != 2;
    }

    private void fO(long j) throws ParserException {
        while (!this.mjF.isEmpty() && this.mjF.peek().endPosition == j) {
            a.C0674a pop = this.mjF.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mhE) {
                f(pop);
                this.mjF.clear();
                this.meP = 2;
            } else if (!this.mjF.isEmpty()) {
                this.mjF.peek().a(pop);
            }
        }
        if (this.meP != 2) {
            dvf();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mkE) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dzu() > 0) {
            if (lVar.readInt() == mkE) {
                return true;
            }
        }
        return false;
    }

    private void f(a.C0674a c0674a) throws ParserException {
        Metadata metadata;
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        com.google.android.exoplayer2.extractor.i iVar = new com.google.android.exoplayer2.extractor.i();
        a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.miF);
        if (JL == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JL, this.mkG);
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
            if (i2 < c0674a.miV.size()) {
                a.C0674a c0674a2 = c0674a.miV.get(i2);
                if (c0674a2.type != com.google.android.exoplayer2.extractor.c.a.mhG) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhF), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mkG);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0674a2.JM(com.google.android.exoplayer2.extractor.c.a.mhH).JM(com.google.android.exoplayer2.extractor.c.a.mhI).JM(com.google.android.exoplayer2.extractor.c.a.mhJ), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.meO.dK(i2, a3.type));
                            Format IV = a3.lZJ.IV(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.duW()) {
                                    IV = IV.dF(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IV = IV.b(metadata);
                                }
                            }
                            aVar.mgS.h(IV);
                            j4 = Math.max(j4, a3.lZO);
                            arrayList.add(aVar);
                            j2 = a4.med[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lZO = j4;
                this.mkF = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.meO.duV();
                this.meO.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dvh = dvh();
        if (dvh == -1) {
            return -1;
        }
        a aVar = this.mkF[dvh];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mgS;
        int i2 = aVar.mjo;
        long j = aVar.mkH.med[i2];
        int i3 = aVar.mkH.mec[i2];
        if (aVar.mjV.mkL == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mge;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fOo = j;
            return 1;
        }
        fVar.Jv((int) position);
        if (aVar.mjV.meZ != 0) {
            byte[] bArr = this.meY.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mjV.meZ;
            int i5 = 4 - aVar.mjV.meZ;
            while (this.mge < i3) {
                if (this.mgd == 0) {
                    fVar.readFully(this.meY.data, i5, i4);
                    this.meY.setPosition(0);
                    this.mgd = this.meY.dzF();
                    this.meX.setPosition(0);
                    mVar.a(this.meX, 4);
                    this.mge += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mgd, false);
                    this.mge += a2;
                    this.mgd -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mge < i3) {
                int a3 = mVar.a(fVar, i3 - this.mge, false);
                this.mge += a3;
                this.mgd -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mkH.mlk[i2], aVar.mkH.mjs[i2], i, 0, null);
        aVar.mjo++;
        this.mge = 0;
        this.mgd = 0;
        return 0;
    }

    private int dvh() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mkF.length; i2++) {
            a aVar = this.mkF[i2];
            int i3 = aVar.mjo;
            if (i3 != aVar.mkH.sampleCount) {
                long j2 = aVar.mkH.med[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private void fP(long j) {
        a[] aVarArr;
        for (a aVar : this.mkF) {
            m mVar = aVar.mkH;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            aVar.mjo = fQ;
        }
    }

    private static boolean JN(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhU || i == com.google.android.exoplayer2.extractor.c.a.mhF || i == com.google.android.exoplayer2.extractor.c.a.mhV || i == com.google.android.exoplayer2.extractor.c.a.mhW || i == com.google.android.exoplayer2.extractor.c.a.mir || i == com.google.android.exoplayer2.extractor.c.a.mis || i == com.google.android.exoplayer2.extractor.c.a.mit || i == com.google.android.exoplayer2.extractor.c.a.mhT || i == com.google.android.exoplayer2.extractor.c.a.miu || i == com.google.android.exoplayer2.extractor.c.a.miv || i == com.google.android.exoplayer2.extractor.c.a.miw || i == com.google.android.exoplayer2.extractor.c.a.mix || i == com.google.android.exoplayer2.extractor.c.a.miy || i == com.google.android.exoplayer2.extractor.c.a.mhR || i == com.google.android.exoplayer2.extractor.c.a.mhd || i == com.google.android.exoplayer2.extractor.c.a.miF;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhE || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mhH || i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mhS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mgS;
        public final j mjV;
        public int mjo;
        public final m mkH;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mjV = jVar;
            this.mkH = mVar;
            this.mgS = mVar2;
        }
    }
}
