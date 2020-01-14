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
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.g.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new g()};
        }
    };
    private static final int mjL = v.Qr("qt  ");
    private final int flags;
    private long lYV;
    private com.google.android.exoplayer2.extractor.g mdV;
    private int mdW;
    private final com.google.android.exoplayer2.util.l mee;
    private final com.google.android.exoplayer2.util.l mef;
    private int mfk;
    private int mfl;
    private final com.google.android.exoplayer2.util.l miK;
    private final Stack<a.C0666a> miM;
    private int miO;
    private long miP;
    private int miQ;
    private com.google.android.exoplayer2.util.l miR;
    private a[] mjM;
    private boolean mjN;

    public g() {
        this(0);
    }

    public g(int i) {
        this.flags = i;
        this.miK = new com.google.android.exoplayer2.util.l(16);
        this.miM = new Stack<>();
        this.mee = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGt);
        this.mef = new com.google.android.exoplayer2.util.l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.s(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mdV = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.miM.clear();
        this.miQ = 0;
        this.mfl = 0;
        this.mfk = 0;
        if (j == 0) {
            dtR();
        } else if (this.mjM != null) {
            fR(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdW) {
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
    public boolean dtD() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.lYV;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        a[] aVarArr = this.mjM;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].mjO;
            int fS = mVar.fS(j);
            if (fS == -1) {
                fS = mVar.fT(j);
            }
            long j3 = mVar.mdk[fS];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void dtR() {
        this.mdW = 0;
        this.miQ = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.miQ == 0) {
            if (!fVar.d(this.miK.data, 0, 8, true)) {
                return false;
            }
            this.miQ = 8;
            this.miK.setPosition(0);
            this.miP = this.miK.readUnsignedInt();
            this.miO = this.miK.readInt();
        }
        if (this.miP == 1) {
            fVar.readFully(this.miK.data, 8, 8);
            this.miQ += 8;
            this.miP = this.miK.dyu();
        } else if (this.miP == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.miM.isEmpty()) {
                length = this.miM.peek().endPosition;
            }
            if (length != -1) {
                this.miP = (length - fVar.getPosition()) + this.miQ;
            }
        }
        if (this.miP < this.miQ) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (JJ(this.miO)) {
            long position = (fVar.getPosition() + this.miP) - this.miQ;
            this.miM.add(new a.C0666a(this.miO, position));
            if (this.miP == this.miQ) {
                fQ(position);
            } else {
                dtR();
            }
        } else if (JI(this.miO)) {
            com.google.android.exoplayer2.util.a.checkState(this.miQ == 8);
            com.google.android.exoplayer2.util.a.checkState(this.miP <= 2147483647L);
            this.miR = new com.google.android.exoplayer2.util.l((int) this.miP);
            System.arraycopy(this.miK.data, 0, this.miR.data, 0, 8);
            this.mdW = 1;
        } else {
            this.miR = null;
            this.mdW = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        boolean z;
        long j = this.miP - this.miQ;
        long position = fVar.getPosition() + j;
        if (this.miR != null) {
            fVar.readFully(this.miR.data, this.miQ, (int) j);
            if (this.miO == com.google.android.exoplayer2.extractor.c.a.mgk) {
                this.mjN = y(this.miR);
                z = false;
            } else if (this.miM.isEmpty()) {
                z = false;
            } else {
                this.miM.peek().a(new a.b(this.miO, this.miR));
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
        return z && this.mdW != 2;
    }

    private void fQ(long j) throws ParserException {
        while (!this.miM.isEmpty() && this.miM.peek().endPosition == j) {
            a.C0666a pop = this.miM.pop();
            if (pop.type == com.google.android.exoplayer2.extractor.c.a.mgL) {
                f(pop);
                this.miM.clear();
                this.mdW = 2;
            } else if (!this.miM.isEmpty()) {
                this.miM.peek().a(pop);
            }
        }
        if (this.mdW != 2) {
            dtR();
        }
    }

    private static boolean y(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        if (lVar.readInt() == mjL) {
            return true;
        }
        lVar.skipBytes(4);
        while (lVar.dyh() > 0) {
            if (lVar.readInt() == mjL) {
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
        a.b JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhK);
        if (JG == null) {
            metadata = null;
        } else {
            Metadata a2 = b.a(JG, this.mjN);
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
            if (i2 < c0666a.mia.size()) {
                a.C0666a c0666a2 = c0666a.mia.get(i2);
                if (c0666a2.type != com.google.android.exoplayer2.extractor.c.a.mgN) {
                    j2 = j3;
                } else {
                    j a3 = b.a(c0666a2, c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgM), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.mjN);
                    if (a3 == null) {
                        j2 = j3;
                    } else {
                        m a4 = b.a(a3, c0666a2.JH(com.google.android.exoplayer2.extractor.c.a.mgO).JH(com.google.android.exoplayer2.extractor.c.a.mgP).JH(com.google.android.exoplayer2.extractor.c.a.mgQ), iVar);
                        if (a4.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            a aVar = new a(a3, a4, this.mdV.dH(i2, a3.type));
                            Format IQ = a3.lYQ.IQ(a4.maximumSize + 30);
                            if (a3.type == 1) {
                                if (iVar.dtI()) {
                                    IQ = IQ.dC(iVar.encoderDelay, iVar.encoderPadding);
                                }
                                if (metadata != null) {
                                    IQ = IQ.b(metadata);
                                }
                            }
                            aVar.mfZ.h(IQ);
                            j4 = Math.max(j4, a3.lYV);
                            arrayList.add(aVar);
                            j2 = a4.mdk[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.lYV = j4;
                this.mjM = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.mdV.dtH();
                this.mdV.a(this);
                return;
            }
        }
    }

    private int c(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int i;
        int dtT = dtT();
        if (dtT == -1) {
            return -1;
        }
        a aVar = this.mjM[dtT];
        com.google.android.exoplayer2.extractor.m mVar = aVar.mfZ;
        int i2 = aVar.miv;
        long j = aVar.mjO.mdk[i2];
        int i3 = aVar.mjO.mdj[i2];
        if (aVar.mjc.mjS == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - fVar.getPosition()) + this.mfl;
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.fLD = j;
            return 1;
        }
        fVar.Jq((int) position);
        if (aVar.mjc.meg != 0) {
            byte[] bArr = this.mef.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = aVar.mjc.meg;
            int i5 = 4 - aVar.mjc.meg;
            while (this.mfl < i3) {
                if (this.mfk == 0) {
                    fVar.readFully(this.mef.data, i5, i4);
                    this.mef.setPosition(0);
                    this.mfk = this.mef.dys();
                    this.mee.setPosition(0);
                    mVar.a(this.mee, 4);
                    this.mfl += 4;
                    i3 += i5;
                } else {
                    int a2 = mVar.a(fVar, this.mfk, false);
                    this.mfl += a2;
                    this.mfk -= a2;
                }
            }
            i = i3;
        } else {
            while (this.mfl < i3) {
                int a3 = mVar.a(fVar, i3 - this.mfl, false);
                this.mfl += a3;
                this.mfk -= a3;
            }
            i = i3;
        }
        mVar.a(aVar.mjO.mkr[i2], aVar.mjO.miz[i2], i, 0, null);
        aVar.miv++;
        this.mfl = 0;
        this.mfk = 0;
        return 0;
    }

    private int dtT() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.mjM.length; i2++) {
            a aVar = this.mjM[i2];
            int i3 = aVar.miv;
            if (i3 != aVar.mjO.sampleCount) {
                long j2 = aVar.mjO.mdk[i3];
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
        for (a aVar : this.mjM) {
            m mVar = aVar.mjO;
            int fS = mVar.fS(j);
            if (fS == -1) {
                fS = mVar.fT(j);
            }
            aVar.miv = fS;
        }
    }

    private static boolean JI(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhb || i == com.google.android.exoplayer2.extractor.c.a.mgM || i == com.google.android.exoplayer2.extractor.c.a.mhc || i == com.google.android.exoplayer2.extractor.c.a.mhd || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhx || i == com.google.android.exoplayer2.extractor.c.a.mhy || i == com.google.android.exoplayer2.extractor.c.a.mha || i == com.google.android.exoplayer2.extractor.c.a.mhz || i == com.google.android.exoplayer2.extractor.c.a.mhA || i == com.google.android.exoplayer2.extractor.c.a.mhB || i == com.google.android.exoplayer2.extractor.c.a.mhC || i == com.google.android.exoplayer2.extractor.c.a.mhD || i == com.google.android.exoplayer2.extractor.c.a.mgY || i == com.google.android.exoplayer2.extractor.c.a.mgk || i == com.google.android.exoplayer2.extractor.c.a.mhK;
    }

    private static boolean JJ(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgL || i == com.google.android.exoplayer2.extractor.c.a.mgN || i == com.google.android.exoplayer2.extractor.c.a.mgO || i == com.google.android.exoplayer2.extractor.c.a.mgP || i == com.google.android.exoplayer2.extractor.c.a.mgQ || i == com.google.android.exoplayer2.extractor.c.a.mgZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final com.google.android.exoplayer2.extractor.m mfZ;
        public int miv;
        public final m mjO;
        public final j mjc;

        public a(j jVar, m mVar, com.google.android.exoplayer2.extractor.m mVar2) {
            this.mjc = jVar;
            this.mjO = mVar;
            this.mfZ = mVar2;
        }
    }
}
