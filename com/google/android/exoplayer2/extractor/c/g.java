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
    public static final com.google.android.exoplayer2.extractor.h mex = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duT() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mkt = v.QE("qt  ");
    private final int flags;
    private long lZD;
    private com.google.android.exoplayer2.extractor.g meD;
    private int meE;
    private final com.google.android.exoplayer2.util.l meM;
    private final com.google.android.exoplayer2.util.l meN;
    private int mfS;
    private int mfT;
    private final com.google.android.exoplayer2.util.l mjs;
    private final Stack<a.C0674a> mju;
    private int mjw;
    private long mjx;
    private int mjy;
    private com.google.android.exoplayer2.util.l mjz;
    private a[] mku;
    private boolean mkv;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.mjs = new com.google.android.exoplayer2.util.l(16);
        this.mju = new Stack<>();
        this.meM = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mHb);
        this.meN = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meD = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mju.clear();
        this.mjy = 0;
        this.mfT = 0;
        this.mfS = 0;
        if (j == 0) {
            dve();
        } else if (this.mku != null) {
            fP(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meE) {
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
    public boolean duQ() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZD;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mku;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mkw;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            long j3 = mVar.mdS[fQ];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dve() {
        this.meE = 0;
        this.mjy = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.mjy == 0) {
            if (!fVar.d(this.mjs.data, 0, 8, true)) {
                return false;
            }
            this.mjy = 8;
            this.mjs.setPosition(0);
            this.mjx = this.mjs.readUnsignedInt();
            this.mjw = this.mjs.readInt();
        }
        if (this.mjx == 1) {
            fVar.readFully(this.mjs.data, 8, 8);
            this.mjy += 8;
            this.mjx = this.mjs.dzG();
        } else if (this.mjx == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.mju.isEmpty()) {
                length = this.mju.peek().endPosition;
            }
            if (length != -1) {
                this.mjx = (length - fVar.getPosition()) + this.mjy;
            }
        }
        if (this.mjx < this.mjy) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JO(this.mjw)) {
            long position = (fVar.getPosition() + this.mjx) - this.mjy;
            this.mju.add(new a.C0674a(this.mjw, position));
            if (this.mjx == this.mjy) {
                fO(position);
            } else {
                dve();
            }
        } else if (JN(this.mjw)) {
            com.google.android.exoplayer2.util.a.checkState(this.mjy == 8);
            com.google.android.exoplayer2.util.a.checkState(this.mjx <= 2147483647L);
            this.mjz = new com.google.android.exoplayer2.util.l((int) this.mjx);
            System.arraycopy(this.mjs.data, 0, this.mjz.data, 0, 8);
            this.meE = 1;
        } else {
            this.mjz = null;
            this.meE = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.mjx - this.mjy;
        long position = fVar.getPosition() + j;
        if (this.mjz != null) {
            fVar.readFully(this.mjz.data, this.mjy, (int) j);
            if (this.mjw == com.google.android.exoplayer2.extractor.c.a.mgS) {
                this.mkv = y(this.mjz);
                z = false;
            } else if (this.mju.isEmpty()) {
                z = false;
            } else {
                this.mju.peek().a(new a.b(this.mjw, this.mjz));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.Jv((int) j);
            z = false;
        } else {
            kVar.fOb = j + fVar.getPosition();
            z = true;
        }
        fO(position);
        return z && this.meE != 2;
    }

    private void fO(long j) throws ParserException {
        while (!this.mju.isEmpty() && this.mju.peek().endPosition == j) {
            a.C0674a pop = this.mju.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mht) {
                f(pop);
                this.mju.clear();
                this.meE = 2;
            } else if (!this.mju.isEmpty()) {
                this.mju.peek().a(pop);
            }
        }
        if (this.meE != 2) {
            dve();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mkt) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dzt() > 0) {
            if (lVar.readInt() == mkt) {
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
        a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.miu);
        if (JL == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JL, this.mkv);
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
            if (i2 < c0674a.miK.size()) {
                a.C0674a c0674a2 = c0674a.miK.get(i2);
                if (c0674a2.type != com.google.android.exoplayer2.extractor.c.a.mhv) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhu), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mkv);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0674a2.JM(com.google.android.exoplayer2.extractor.c.a.mhw).JM(com.google.android.exoplayer2.extractor.c.a.mhx).JM(com.google.android.exoplayer2.extractor.c.a.mhy), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.meD.dK(i2, a3.type));
                            Format IV = a3.lZy.IV(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.duV()) {
                                    IV = IV.dF(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IV = IV.b(metadata);
                                }
                            }
                            aVar.mgH.h(IV);
                            j4 = Math.max(j4, a3.lZD);
                            arrayList.add(aVar);
                            j2 = a4.mdS[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lZD = j4;
                this.mku = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.meD.duU();
                this.meD.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dvg = dvg();
        if (dvg == -1) {
            return -1;
        }
        a aVar = this.mku[dvg];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mgH;
        int i2 = aVar.mjd;
        long j = aVar.mkw.mdS[i2];
        int i3 = aVar.mkw.mdR[i2];
        if (aVar.mjK.mkA == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mfT;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fOb = j;
            return 1;
        }
        fVar.Jv((int) position);
        if (aVar.mjK.meO != 0) {
            byte[] bArr = this.meN.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mjK.meO;
            int i5 = 4 - aVar.mjK.meO;
            while (this.mfT < i3) {
                if (this.mfS == 0) {
                    fVar.readFully(this.meN.data, i5, i4);
                    this.meN.setPosition(0);
                    this.mfS = this.meN.dzE();
                    this.meM.setPosition(0);
                    mVar.a(this.meM, 4);
                    this.mfT += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mfS, false);
                    this.mfT += a2;
                    this.mfS -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mfT < i3) {
                int a3 = mVar.a(fVar, i3 - this.mfT, false);
                this.mfT += a3;
                this.mfS -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mkw.mkZ[i2], aVar.mkw.mjh[i2], i, 0, null);
        aVar.mjd++;
        this.mfT = 0;
        this.mfS = 0;
        return 0;
    }

    private int dvg() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mku.length; i2++) {
            a aVar = this.mku[i2];
            int i3 = aVar.mjd;
            if (i3 != aVar.mkw.sampleCount) {
                long j2 = aVar.mkw.mdS[i3];
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
        for (a aVar : this.mku) {
            m mVar = aVar.mkw;
            int fQ = mVar.fQ(j);
            if (fQ == -1) {
                fQ = mVar.fR(j);
            }
            aVar.mjd = fQ;
        }
    }

    private static boolean JN(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mhu || i == com.google.android.exoplayer2.extractor.c.a.mhK || i == com.google.android.exoplayer2.extractor.c.a.mhL || i == com.google.android.exoplayer2.extractor.c.a.mif || i == com.google.android.exoplayer2.extractor.c.a.mig || i == com.google.android.exoplayer2.extractor.c.a.mih || i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mii || i == com.google.android.exoplayer2.extractor.c.a.mij || i == com.google.android.exoplayer2.extractor.c.a.mik || i == com.google.android.exoplayer2.extractor.c.a.mil || i == com.google.android.exoplayer2.extractor.c.a.mim || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mgS || i == com.google.android.exoplayer2.extractor.c.a.miu;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mht || i == com.google.android.exoplayer2.extractor.c.a.mhv || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhx || i == com.google.android.exoplayer2.extractor.c.a.mhy || i == com.google.android.exoplayer2.extractor.c.a.mhH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mgH;
        public final j mjK;
        public int mjd;
        public final m mkw;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mjK = jVar;
            this.mkw = mVar;
            this.mgH = mVar2;
        }
    }
}
