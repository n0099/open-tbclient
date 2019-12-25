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
/* loaded from: classes4.dex */
public final class g implements com.google.android.exoplayer2.extractor.e, com.google.android.exoplayer2.extractor.l {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mfP = v.Qg("qt  ");
    private final int flags;
    private long lUZ;
    private com.google.android.exoplayer2.extractor.g lZY;
    private int lZZ;
    private final com.google.android.exoplayer2.util.l mai;
    private final com.google.android.exoplayer2.util.l maj;
    private int mbq;
    private int mbr;
    private final com.google.android.exoplayer2.util.l meO;
    private final Stack<a.C0660a> meQ;
    private int meS;
    private long meT;
    private int meU;
    private com.google.android.exoplayer2.util.l meV;
    private a[] mfQ;
    private boolean mfR;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.meO = new com.google.android.exoplayer2.util.l(16);
        this.meQ = new Stack<>();
        this.mai = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mCx);
        this.maj = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.lZY = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.meQ.clear();
        this.meU = 0;
        this.mbr = 0;
        this.mbq = 0;
        if (j == 0) {
            dsD();
        } else if (this.mfQ != null) {
            fM(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.lZZ) {
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
    public boolean dsp() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.lUZ;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mfQ;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mfS;
            int fN = mVar.fN(j);
            if (fN == -1) {
                fN = mVar.fO(j);
            }
            long j3 = mVar.lZn[fN];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dsD() {
        this.lZZ = 0;
        this.meU = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.meU == 0) {
            if (!fVar.d(this.meO.data, 0, 8, true)) {
                return false;
            }
            this.meU = 8;
            this.meO.setPosition(0);
            this.meT = this.meO.readUnsignedInt();
            this.meS = this.meO.readInt();
        }
        if (this.meT == 1) {
            fVar.readFully(this.meO.data, 8, 8);
            this.meU += 8;
            this.meT = this.meO.dxi();
        } else if (this.meT == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.meQ.isEmpty()) {
                length = this.meQ.peek().endPosition;
            }
            if (length != -1) {
                this.meT = (length - fVar.getPosition()) + this.meU;
            }
        }
        if (this.meT < this.meU) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JA(this.meS)) {
            long position = (fVar.getPosition() + this.meT) - this.meU;
            this.meQ.add(new a.C0660a(this.meS, position));
            if (this.meT == this.meU) {
                fL(position);
            } else {
                dsD();
            }
        } else if (Jz(this.meS)) {
            com.google.android.exoplayer2.util.a.checkState(this.meU == 8);
            com.google.android.exoplayer2.util.a.checkState(this.meT <= 2147483647L);
            this.meV = new com.google.android.exoplayer2.util.l((int) this.meT);
            System.arraycopy(this.meO.data, 0, this.meV.data, 0, 8);
            this.lZZ = 1;
        } else {
            this.meV = null;
            this.lZZ = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.meT - this.meU;
        long position = fVar.getPosition() + j;
        if (this.meV != null) {
            fVar.readFully(this.meV.data, this.meU, (int) j);
            if (this.meS == com.google.android.exoplayer2.extractor.c.a.mcq) {
                this.mfR = y(this.meV);
                z = false;
            } else if (this.meQ.isEmpty()) {
                z = false;
            } else {
                this.meQ.peek().a(new a.b(this.meS, this.meV));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.Jh((int) j);
            z = false;
        } else {
            kVar.fIt = j + fVar.getPosition();
            z = true;
        }
        fL(position);
        return z && this.lZZ != 2;
    }

    private void fL(long j) throws ParserException {
        while (!this.meQ.isEmpty() && this.meQ.peek().endPosition == j) {
            a.C0660a pop = this.meQ.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mcR) {
                f(pop);
                this.meQ.clear();
                this.lZZ = 2;
            } else if (!this.meQ.isEmpty()) {
                this.meQ.peek().a(pop);
            }
        }
        if (this.lZZ != 2) {
            dsD();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mfP) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dwV() > 0) {
            if (lVar.readInt() == mfP) {
                return true;
            }
        }
        return false;
    }

    private void f(a.C0660a c0660a) throws ParserException {
        Metadata metadata;
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        com.google.android.exoplayer2.extractor.i iVar = new com.google.android.exoplayer2.extractor.i();
        a.b Jx = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdQ);
        if (Jx == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(Jx, this.mfR);
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
            if (i2 < c0660a.meg.size()) {
                a.C0660a c0660a2 = c0660a.meg.get(i2);
                if (c0660a2.type != com.google.android.exoplayer2.extractor.c.a.mcT) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0660a2, c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mcS), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mfR);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0660a2.Jy(com.google.android.exoplayer2.extractor.c.a.mcU).Jy(com.google.android.exoplayer2.extractor.c.a.mcV).Jy(com.google.android.exoplayer2.extractor.c.a.mcW), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.lZY.dJ(i2, a3.type));
                            Format IH = a3.lUU.IH(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.dsu()) {
                                    IH = IH.dE(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IH = IH.b(metadata);
                                }
                            }
                            aVar.mcf.h(IH);
                            j4 = Math.max(j4, a3.lUZ);
                            arrayList.add(aVar);
                            j2 = a4.lZn[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lUZ = j4;
                this.mfQ = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.lZY.dst();
                this.lZY.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dsF = dsF();
        if (dsF == -1) {
            return -1;
        }
        a aVar = this.mfQ[dsF];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mcf;
        int i2 = aVar.mez;
        long j = aVar.mfS.lZn[i2];
        int i3 = aVar.mfS.lZm[i2];
        if (aVar.mfg.mfW == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mbr;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fIt = j;
            return 1;
        }
        fVar.Jh((int) position);
        if (aVar.mfg.mak != 0) {
            byte[] bArr = this.maj.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mfg.mak;
            int i5 = 4 - aVar.mfg.mak;
            while (this.mbr < i3) {
                if (this.mbq == 0) {
                    fVar.readFully(this.maj.data, i5, i4);
                    this.maj.setPosition(0);
                    this.mbq = this.maj.dxg();
                    this.mai.setPosition(0);
                    mVar.a(this.mai, 4);
                    this.mbr += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mbq, false);
                    this.mbr += a2;
                    this.mbq -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mbr < i3) {
                int a3 = mVar.a(fVar, i3 - this.mbr, false);
                this.mbr += a3;
                this.mbq -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mfS.mgv[i2], aVar.mfS.meD[i2], i, 0, null);
        aVar.mez++;
        this.mbr = 0;
        this.mbq = 0;
        return 0;
    }

    private int dsF() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mfQ.length; i2++) {
            a aVar = this.mfQ[i2];
            int i3 = aVar.mez;
            if (i3 != aVar.mfS.sampleCount) {
                long j2 = aVar.mfS.lZn[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private void fM(long j) {
        a[] aVarArr;
        for (a aVar : this.mfQ) {
            m mVar = aVar.mfS;
            int fN = mVar.fN(j);
            if (fN == -1) {
                fN = mVar.fO(j);
            }
            aVar.mez = fN;
        }
    }

    private static boolean Jz(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mdh || i == com.google.android.exoplayer2.extractor.c.a.mcS || i == com.google.android.exoplayer2.extractor.c.a.mdi || i == com.google.android.exoplayer2.extractor.c.a.mdj || i == com.google.android.exoplayer2.extractor.c.a.mdC || i == com.google.android.exoplayer2.extractor.c.a.mdD || i == com.google.android.exoplayer2.extractor.c.a.mdE || i == com.google.android.exoplayer2.extractor.c.a.mdg || i == com.google.android.exoplayer2.extractor.c.a.mdF || i == com.google.android.exoplayer2.extractor.c.a.mdG || i == com.google.android.exoplayer2.extractor.c.a.mdH || i == com.google.android.exoplayer2.extractor.c.a.mdI || i == com.google.android.exoplayer2.extractor.c.a.mdJ || i == com.google.android.exoplayer2.extractor.c.a.mde || i == com.google.android.exoplayer2.extractor.c.a.mcq || i == com.google.android.exoplayer2.extractor.c.a.mdQ;
    }

    private static boolean JA(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mcR || i == com.google.android.exoplayer2.extractor.c.a.mcT || i == com.google.android.exoplayer2.extractor.c.a.mcU || i == com.google.android.exoplayer2.extractor.c.a.mcV || i == com.google.android.exoplayer2.extractor.c.a.mcW || i == com.google.android.exoplayer2.extractor.c.a.mdf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mcf;
        public int mez;
        public final m mfS;
        public final j mfg;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mfg = jVar;
            this.mfS = mVar;
            this.mcf = mVar2;
        }
    }
}
