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
    public static final com.google.android.exoplayer2.extractor.h mev = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mkr = v.QE("qt  ");
    private final int flags;
    private long lZB;
    private com.google.android.exoplayer2.extractor.g meB;
    private int meC;
    private final com.google.android.exoplayer2.util.l meK;
    private final com.google.android.exoplayer2.util.l meL;
    private int mfQ;
    private int mfR;
    private final com.google.android.exoplayer2.util.l mjq;
    private final Stack<a.C0674a> mjs;
    private int mju;
    private long mjv;
    private int mjw;
    private com.google.android.exoplayer2.util.l mjx;
    private a[] mks;
    private boolean mkt;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.mjq = new com.google.android.exoplayer2.util.l(16);
        this.mjs = new Stack<>();
        this.meK = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGZ);
        this.meL = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meB = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mjs.clear();
        this.mjw = 0;
        this.mfR = 0;
        this.mfQ = 0;
        if (j == 0) {
            dvc();
        } else if (this.mks != null) {
            fP(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meC) {
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
    public boolean duO() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZB;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mks;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mku;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            long j3 = mVar.mdQ[fQ];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dvc() {
        this.meC = 0;
        this.mjw = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.mjw == 0) {
            if (!fVar.d(this.mjq.data, 0, 8, true)) {
                return false;
            }
            this.mjw = 8;
            this.mjq.setPosition(0);
            this.mjv = this.mjq.readUnsignedInt();
            this.mju = this.mjq.readInt();
        }
        if (this.mjv == 1) {
            fVar.readFully(this.mjq.data, 8, 8);
            this.mjw += 8;
            this.mjv = this.mjq.dzE();
        } else if (this.mjv == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.mjs.isEmpty()) {
                length = this.mjs.peek().endPosition;
            }
            if (length != -1) {
                this.mjv = (length - fVar.getPosition()) + this.mjw;
            }
        }
        if (this.mjv < this.mjw) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JO(this.mju)) {
            long position = (fVar.getPosition() + this.mjv) - this.mjw;
            this.mjs.add(new a.C0674a(this.mju, position));
            if (this.mjv == this.mjw) {
                fO(position);
            } else {
                dvc();
            }
        } else if (JN(this.mju)) {
            com.google.android.exoplayer2.util.a.checkState(this.mjw == 8);
            com.google.android.exoplayer2.util.a.checkState(this.mjv <= 2147483647L);
            this.mjx = new com.google.android.exoplayer2.util.l((int) this.mjv);
            System.arraycopy(this.mjq.data, 0, this.mjx.data, 0, 8);
            this.meC = 1;
        } else {
            this.mjx = null;
            this.meC = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.mjv - this.mjw;
        long position = fVar.getPosition() + j;
        if (this.mjx != null) {
            fVar.readFully(this.mjx.data, this.mjw, (int) j);
            if (this.mju == com.google.android.exoplayer2.extractor.c.a.mgQ) {
                this.mkt = y(this.mjx);
                z = false;
            } else if (this.mjs.isEmpty()) {
                z = false;
            } else {
                this.mjs.peek().a(new a.b(this.mju, this.mjx));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.Jv((int) j);
            z = false;
        } else {
            kVar.fNZ = j + fVar.getPosition();
            z = true;
        }
        fO(position);
        return z && this.meC != 2;
    }

    private void fO(long j) throws ParserException {
        while (!this.mjs.isEmpty() && this.mjs.peek().endPosition == j) {
            a.C0674a pop = this.mjs.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mhr) {
                f(pop);
                this.mjs.clear();
                this.meC = 2;
            } else if (!this.mjs.isEmpty()) {
                this.mjs.peek().a(pop);
            }
        }
        if (this.meC != 2) {
            dvc();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mkr) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dzr() > 0) {
            if (lVar.readInt() == mkr) {
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
        a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mis);
        if (JL == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JL, this.mkt);
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
            if (i2 < c0674a.miI.size()) {
                a.C0674a c0674a2 = c0674a.miI.get(i2);
                if (c0674a2.type != com.google.android.exoplayer2.extractor.c.a.mht) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhs), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mkt);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0674a2.JM(com.google.android.exoplayer2.extractor.c.a.mhu).JM(com.google.android.exoplayer2.extractor.c.a.mhv).JM(com.google.android.exoplayer2.extractor.c.a.mhw), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.meB.dK(i2, a3.type));
                            Format IV = a3.lZw.IV(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.duT()) {
                                    IV = IV.dF(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IV = IV.b(metadata);
                                }
                            }
                            aVar.mgF.h(IV);
                            j4 = Math.max(j4, a3.lZB);
                            arrayList.add(aVar);
                            j2 = a4.mdQ[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lZB = j4;
                this.mks = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.meB.duS();
                this.meB.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dve = dve();
        if (dve == -1) {
            return -1;
        }
        a aVar = this.mks[dve];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mgF;
        int i2 = aVar.mjb;
        long j = aVar.mku.mdQ[i2];
        int i3 = aVar.mku.mdP[i2];
        if (aVar.mjI.mky == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mfR;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fNZ = j;
            return 1;
        }
        fVar.Jv((int) position);
        if (aVar.mjI.meM != 0) {
            byte[] bArr = this.meL.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mjI.meM;
            int i5 = 4 - aVar.mjI.meM;
            while (this.mfR < i3) {
                if (this.mfQ == 0) {
                    fVar.readFully(this.meL.data, i5, i4);
                    this.meL.setPosition(0);
                    this.mfQ = this.meL.dzC();
                    this.meK.setPosition(0);
                    mVar.a(this.meK, 4);
                    this.mfR += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mfQ, false);
                    this.mfR += a2;
                    this.mfQ -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mfR < i3) {
                int a3 = mVar.a(fVar, i3 - this.mfR, false);
                this.mfR += a3;
                this.mfQ -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mku.mkX[i2], aVar.mku.mjf[i2], i, 0, null);
        aVar.mjb++;
        this.mfR = 0;
        this.mfQ = 0;
        return 0;
    }

    private int dve() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mks.length; i2++) {
            a aVar = this.mks[i2];
            int i3 = aVar.mjb;
            if (i3 != aVar.mku.sampleCount) {
                long j2 = aVar.mku.mdQ[i3];
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
        for (a aVar : this.mks) {
            m mVar = aVar.mku;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            aVar.mjb = fQ;
        }
    }

    private static boolean JN(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhH || i == com.google.android.exoplayer2.extractor.c.a.mhs || i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mic || i == com.google.android.exoplayer2.extractor.c.a.mie || i == com.google.android.exoplayer2.extractor.c.a.mif || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mig || i == com.google.android.exoplayer2.extractor.c.a.mih || i == com.google.android.exoplayer2.extractor.c.a.mii || i == com.google.android.exoplayer2.extractor.c.a.mij || i == com.google.android.exoplayer2.extractor.c.a.mik || i == com.google.android.exoplayer2.extractor.c.a.mhE || i == com.google.android.exoplayer2.extractor.c.a.mgQ || i == com.google.android.exoplayer2.extractor.c.a.mis;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhr || i == com.google.android.exoplayer2.extractor.c.a.mht || i == com.google.android.exoplayer2.extractor.c.a.mhu || i == com.google.android.exoplayer2.extractor.c.a.mhv || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mgF;
        public final j mjI;
        public int mjb;
        public final m mku;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mjI = jVar;
            this.mku = mVar;
            this.mgF = mVar2;
        }
    }
}
