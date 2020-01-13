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
/* loaded from: classes5.dex */
public final class g implements com.google.android.exoplayer2.extractor.e, com.google.android.exoplayer2.extractor.l {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mjG = v.Qr("qt  ");
    private final int flags;
    private long lYQ;
    private com.google.android.exoplayer2.extractor.g mdQ;
    private int mdR;
    private final com.google.android.exoplayer2.util.l mdZ;
    private final com.google.android.exoplayer2.util.l mea;
    private int mff;
    private int mfg;
    private final com.google.android.exoplayer2.util.l miF;
    private final Stack<a.C0666a> miH;
    private int miJ;
    private long miK;
    private int miL;
    private com.google.android.exoplayer2.util.l miM;
    private a[] mjH;
    private boolean mjI;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.miF = new com.google.android.exoplayer2.util.l(16);
        this.miH = new Stack<>();
        this.mdZ = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGo);
        this.mea = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mdQ = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.miH.clear();
        this.miL = 0;
        this.mfg = 0;
        this.mff = 0;
        if (j == 0) {
            dtP();
        } else if (this.mjH != null) {
            fR(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdR) {
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
    public boolean dtB() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.lYQ;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mjH;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mjJ;
            int fS = mVar.fS(j);
            if (fS == -1) {
                fS = mVar.fT(j);
            }
            long j3 = mVar.mdf[fS];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dtP() {
        this.mdR = 0;
        this.miL = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.miL == 0) {
            if (!fVar.d(this.miF.data, 0, 8, true)) {
                return false;
            }
            this.miL = 8;
            this.miF.setPosition(0);
            this.miK = this.miF.readUnsignedInt();
            this.miJ = this.miF.readInt();
        }
        if (this.miK == 1) {
            fVar.readFully(this.miF.data, 8, 8);
            this.miL += 8;
            this.miK = this.miF.dys();
        } else if (this.miK == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.miH.isEmpty()) {
                length = this.miH.peek().endPosition;
            }
            if (length != -1) {
                this.miK = (length - fVar.getPosition()) + this.miL;
            }
        }
        if (this.miK < this.miL) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JJ(this.miJ)) {
            long position = (fVar.getPosition() + this.miK) - this.miL;
            this.miH.add(new a.C0666a(this.miJ, position));
            if (this.miK == this.miL) {
                fQ(position);
            } else {
                dtP();
            }
        } else if (JI(this.miJ)) {
            com.google.android.exoplayer2.util.a.checkState(this.miL == 8);
            com.google.android.exoplayer2.util.a.checkState(this.miK <= 2147483647L);
            this.miM = new com.google.android.exoplayer2.util.l((int) this.miK);
            System.arraycopy(this.miF.data, 0, this.miM.data, 0, 8);
            this.mdR = 1;
        } else {
            this.miM = null;
            this.mdR = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.miK - this.miL;
        long position = fVar.getPosition() + j;
        if (this.miM != null) {
            fVar.readFully(this.miM.data, this.miL, (int) j);
            if (this.miJ == com.google.android.exoplayer2.extractor.c.a.mgf) {
                this.mjI = y(this.miM);
                z = false;
            } else if (this.miH.isEmpty()) {
                z = false;
            } else {
                this.miH.peek().a(new a.b(this.miJ, this.miM));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.Jq((int) j);
            z = false;
        } else {
            kVar.fLD = j + fVar.getPosition();
            z = true;
        }
        fQ(position);
        return z && this.mdR != 2;
    }

    private void fQ(long j) throws ParserException {
        while (!this.miH.isEmpty() && this.miH.peek().endPosition == j) {
            a.C0666a pop = this.miH.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mgG) {
                f(pop);
                this.miH.clear();
                this.mdR = 2;
            } else if (!this.miH.isEmpty()) {
                this.miH.peek().a(pop);
            }
        }
        if (this.mdR != 2) {
            dtP();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mjG) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dyf() > 0) {
            if (lVar.readInt() == mjG) {
                return true;
            }
        }
        return false;
    }

    private void f(a.C0666a c0666a) throws ParserException {
        Metadata metadata;
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        com.google.android.exoplayer2.extractor.i iVar = new com.google.android.exoplayer2.extractor.i();
        a.b JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhF);
        if (JG == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JG, this.mjI);
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
            if (i2 < c0666a.mhV.size()) {
                a.C0666a c0666a2 = c0666a.mhV.get(i2);
                if (c0666a2.type != com.google.android.exoplayer2.extractor.c.a.mgI) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0666a2, c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgH), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mjI);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0666a2.JH(com.google.android.exoplayer2.extractor.c.a.mgJ).JH(com.google.android.exoplayer2.extractor.c.a.mgK).JH(com.google.android.exoplayer2.extractor.c.a.mgL), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.mdQ.dH(i2, a3.type));
                            Format IQ = a3.lYL.IQ(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.dtG()) {
                                    IQ = IQ.dC(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IQ = IQ.b(metadata);
                                }
                            }
                            aVar.mfU.h(IQ);
                            j4 = Math.max(j4, a3.lYQ);
                            arrayList.add(aVar);
                            j2 = a4.mdf[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lYQ = j4;
                this.mjH = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.mdQ.dtF();
                this.mdQ.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dtR = dtR();
        if (dtR == -1) {
            return -1;
        }
        a aVar = this.mjH[dtR];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mfU;
        int i2 = aVar.miq;
        long j = aVar.mjJ.mdf[i2];
        int i3 = aVar.mjJ.mde[i2];
        if (aVar.miX.mjN == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mfg;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fLD = j;
            return 1;
        }
        fVar.Jq((int) position);
        if (aVar.miX.meb != 0) {
            byte[] bArr = this.mea.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.miX.meb;
            int i5 = 4 - aVar.miX.meb;
            while (this.mfg < i3) {
                if (this.mff == 0) {
                    fVar.readFully(this.mea.data, i5, i4);
                    this.mea.setPosition(0);
                    this.mff = this.mea.dyq();
                    this.mdZ.setPosition(0);
                    mVar.a(this.mdZ, 4);
                    this.mfg += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mff, false);
                    this.mfg += a2;
                    this.mff -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mfg < i3) {
                int a3 = mVar.a(fVar, i3 - this.mfg, false);
                this.mfg += a3;
                this.mff -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mjJ.mkm[i2], aVar.mjJ.miu[i2], i, 0, null);
        aVar.miq++;
        this.mfg = 0;
        this.mff = 0;
        return 0;
    }

    private int dtR() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mjH.length; i2++) {
            a aVar = this.mjH[i2];
            int i3 = aVar.miq;
            if (i3 != aVar.mjJ.sampleCount) {
                long j2 = aVar.mjJ.mdf[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private void fR(long j) {
        a[] aVarArr;
        for (a aVar : this.mjH) {
            m mVar = aVar.mjJ;
            int fS = mVar.fS(j);
            if (fS == -1) {
                fS = mVar.fT(j);
            }
            aVar.miq = fS;
        }
    }

    private static boolean JI(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgW || i == com.google.android.exoplayer2.extractor.c.a.mgH || i == com.google.android.exoplayer2.extractor.c.a.mgX || i == com.google.android.exoplayer2.extractor.c.a.mgY || i == com.google.android.exoplayer2.extractor.c.a.mhr || i == com.google.android.exoplayer2.extractor.c.a.mhs || i == com.google.android.exoplayer2.extractor.c.a.mht || i == com.google.android.exoplayer2.extractor.c.a.mgV || i == com.google.android.exoplayer2.extractor.c.a.mhu || i == com.google.android.exoplayer2.extractor.c.a.mhv || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhx || i == com.google.android.exoplayer2.extractor.c.a.mhy || i == com.google.android.exoplayer2.extractor.c.a.mgT || i == com.google.android.exoplayer2.extractor.c.a.mgf || i == com.google.android.exoplayer2.extractor.c.a.mhF;
    }

    private static boolean JJ(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgG || i == com.google.android.exoplayer2.extractor.c.a.mgI || i == com.google.android.exoplayer2.extractor.c.a.mgJ || i == com.google.android.exoplayer2.extractor.c.a.mgK || i == com.google.android.exoplayer2.extractor.c.a.mgL || i == com.google.android.exoplayer2.extractor.c.a.mgU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mfU;
        public final j miX;
        public int miq;
        public final m mjJ;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.miX = jVar;
            this.mjJ = mVar;
            this.mfU = mVar2;
        }
    }
}
