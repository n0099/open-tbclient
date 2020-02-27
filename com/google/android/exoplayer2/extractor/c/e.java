package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.c.a;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.v;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.CencSampleEncryptionInformationGroupEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class e implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mev = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int mjg = v.QE(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] mjh = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lZB;
    private com.google.android.exoplayer2.extractor.g meB;
    private int meC;
    private final com.google.android.exoplayer2.util.l meK;
    private int mfQ;
    private int mfR;
    private long mjA;
    private b mjB;
    private boolean mjC;
    private com.google.android.exoplayer2.extractor.m mjD;
    private com.google.android.exoplayer2.extractor.m[] mjE;
    private boolean mjF;
    private final j mji;
    private final DrmInitData mjj;
    private final SparseArray<b> mjk;
    private final com.google.android.exoplayer2.util.l mjl;
    private final com.google.android.exoplayer2.util.l mjm;
    private final com.google.android.exoplayer2.util.l mjn;
    private final com.google.android.exoplayer2.util.l mjo;
    private final s mjp;
    private final com.google.android.exoplayer2.util.l mjq;
    private final byte[] mjr;
    private final Stack<a.C0674a> mjs;
    private final LinkedList<a> mjt;
    private int mju;
    private long mjv;
    private int mjw;
    private com.google.android.exoplayer2.util.l mjx;
    private long mjy;
    private int mjz;
    private int sampleSize;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, null);
    }

    public e(int i, s sVar) {
        this(i, sVar, null, null);
    }

    public e(int i, s sVar, j jVar, DrmInitData drmInitData) {
        this.flags = (jVar != null ? 16 : 0) | i;
        this.mjp = sVar;
        this.mji = jVar;
        this.mjj = drmInitData;
        this.mjq = new com.google.android.exoplayer2.util.l(16);
        this.meK = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGZ);
        this.mjl = new com.google.android.exoplayer2.util.l(5);
        this.mjm = new com.google.android.exoplayer2.util.l();
        this.mjn = new com.google.android.exoplayer2.util.l(1);
        this.mjo = new com.google.android.exoplayer2.util.l();
        this.mjr = new byte[16];
        this.mjs = new Stack<>();
        this.mjt = new LinkedList<>();
        this.mjk = new SparseArray<>();
        this.lZB = -9223372036854775807L;
        this.mjA = -9223372036854775807L;
        dvc();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meB = gVar;
        if (this.mji != null) {
            b bVar = new b(gVar.dK(0, this.mji.type));
            bVar.a(this.mji, new c(0, 0, 0, 0));
            this.mjk.put(0, bVar);
            dvd();
            this.meB.duS();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.mjk.size();
        for (int i = 0; i < size; i++) {
            this.mjk.valueAt(i).reset();
        }
        this.mjt.clear();
        this.mjz = 0;
        this.mjs.clear();
        dvc();
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
                    o(fVar);
                    break;
                case 2:
                    p(fVar);
                    break;
                default:
                    if (!q(fVar)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
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
        long position = fVar.getPosition() - this.mjw;
        if (this.mju == com.google.android.exoplayer2.extractor.c.a.mhA) {
            int size = this.mjk.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.mjk.valueAt(i).mjH;
                lVar.mkG = position;
                lVar.mkI = position;
                lVar.mkH = position;
            }
        }
        if (this.mju == com.google.android.exoplayer2.extractor.c.a.mgX) {
            this.mjB = null;
            this.mjy = this.mjv + position;
            if (!this.mjF) {
                this.meB.a(new l.a(this.lZB));
                this.mjF = true;
            }
            this.meC = 2;
            return true;
        }
        if (JO(this.mju)) {
            long position2 = (fVar.getPosition() + this.mjv) - 8;
            this.mjs.add(new a.C0674a(this.mju, position2));
            if (this.mjv == this.mjw) {
                fO(position2);
            } else {
                dvc();
            }
        } else if (JN(this.mju)) {
            if (this.mjw != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.mjv > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.mjx = new com.google.android.exoplayer2.util.l((int) this.mjv);
            System.arraycopy(this.mjq.data, 0, this.mjx.data, 0, 8);
            this.meC = 1;
        } else if (this.mjv > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.mjx = null;
            this.meC = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.mjv) - this.mjw;
        if (this.mjx != null) {
            fVar.readFully(this.mjx.data, 8, i);
            a(new a.b(this.mju, this.mjx), fVar.getPosition());
        } else {
            fVar.Jv(i);
        }
        fO(fVar.getPosition());
    }

    private void fO(long j) throws ParserException {
        while (!this.mjs.isEmpty() && this.mjs.peek().endPosition == j) {
            c(this.mjs.pop());
        }
        dvc();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.mjs.isEmpty()) {
            this.mjs.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhq) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.miJ, j);
            this.mjA = ((Long) c.first).longValue();
            this.meB.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.mjF = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.miy) {
            q(bVar.miJ);
        }
    }

    private void c(a.C0674a c0674a) throws ParserException {
        if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mhr) {
            d(c0674a);
        } else if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mhA) {
            e(c0674a);
        } else if (!this.mjs.isEmpty()) {
            this.mjs.peek().a(c0674a);
        }
    }

    private void d(a.C0674a c0674a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.mji == null, "Unexpected moov box.");
        DrmInitData fa = this.mjj != null ? this.mjj : fa(c0674a.miH);
        a.C0674a JM = c0674a.JM(com.google.android.exoplayer2.extractor.c.a.mhC);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JM.miH.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JM.miH.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mho) {
                Pair<Integer, c> r = r(bVar.miJ);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhD) {
                j = s(bVar.miJ);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0674a.miI.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0674a c0674a2 = c0674a.miI.get(i3);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mht) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhs), j, fa, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.mjk.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.meB.dK(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.mjk.put(jVar.id, bVar2);
                this.lZB = Math.max(this.lZB, jVar.lZB);
                i++;
            }
            dvd();
            this.meB.duS();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.mjk.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.mjk.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0674a c0674a) throws ParserException {
        a(c0674a, this.mjk, this.flags, this.mjr);
        DrmInitData fa = this.mjj != null ? null : fa(c0674a.miH);
        if (fa != null) {
            int size = this.mjk.size();
            for (int i = 0; i < size; i++) {
                this.mjk.valueAt(i).d(fa);
            }
        }
    }

    private void dvd() {
        if ((this.flags & 4) != 0 && this.mjD == null) {
            this.mjD = this.meB.dK(this.mjk.size(), 4);
            this.mjD.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.mjE == null) {
            com.google.android.exoplayer2.extractor.m dK = this.meB.dK(this.mjk.size() + 1, 3);
            dK.h(Format.a(null, "application/cea-608", 0, null));
            this.mjE = new com.google.android.exoplayer2.extractor.m[]{dK};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.mjD != null) {
            lVar.setPosition(12);
            lVar.dzF();
            lVar.dzF();
            long i = v.i(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dzr = lVar.dzr();
            this.mjD.a(lVar, dzr);
            if (this.mjA != -9223372036854775807L) {
                this.mjD.a(i + this.mjA, 1, dzr, 0, null);
                return;
            }
            this.mjt.addLast(new a(i, dzr));
            this.mjz += dzr;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dzC() - 1, lVar.dzC(), lVar.dzC(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dzE();
    }

    private static void a(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0674a.miI.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0674a c0674a2 = c0674a.miI.get(i2);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mhB) {
                b(c0674a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhn).miJ, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mjH;
            long j = lVar.mkW;
            a2.reset();
            if (c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhm) != null && (i & 2) == 0) {
                j = t(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhm).miJ);
            }
            a(c0674a, a2, j, i);
            k JQ = a2.mjI.JQ(lVar.mkF.mjd);
            a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhS);
            if (JL != null) {
                a(JQ, JL.miJ, lVar);
            }
            a.b JL2 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhT);
            if (JL2 != null) {
                a(JL2.miJ, lVar);
            }
            a.b JL3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhX);
            if (JL3 != null) {
                b(JL3.miJ, lVar);
            }
            a.b JL4 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhU);
            a.b JL5 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhV);
            if (JL4 != null && JL5 != null) {
                a(JL4.miJ, JL5.miJ, JQ != null ? JQ.schemeType : null, lVar);
            }
            int size = c0674a.miH.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0674a.miH.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhW) {
                    a(bVar.miJ, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0674a c0674a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0674a.miH;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mhp) {
                com.google.android.exoplayer2.util.l lVar = bVar2.miJ;
                lVar.setPosition(12);
                int dzC = lVar.dzC();
                if (dzC > 0) {
                    i2 = dzC + i5;
                    i3 = i6 + 1;
                    i4++;
                    i6 = i3;
                    i5 = i2;
                }
            }
            i2 = i5;
            i3 = i6;
            i4++;
            i6 = i3;
            i5 = i2;
        }
        bVar.mjM = 0;
        bVar.mjL = 0;
        bVar.mjK = 0;
        bVar.mjH.dL(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mhp) {
                i7 = a(bVar, i8, j, i, bVar3.miJ, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mkD;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dzC = lVar.dzC();
        if (dzC != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzC + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mkR;
            int i3 = 0;
            i = 0;
            while (i3 < dzC) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dzC) + 0;
            Arrays.fill(lVar2.mkR, 0, dzC, z);
        }
        lVar2.JR(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dzC = lVar.dzC();
        if (dzC != 1) {
            throw new ParserException("Unexpected saio entry count: " + dzC);
        }
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(readInt);
        lVar2.mkI = (JI == 0 ? lVar.readUnsignedInt() : lVar.dzE()) + lVar2.mkI;
    }

    private static b a(com.google.android.exoplayer2.util.l lVar, SparseArray<b> sparseArray, int i) {
        lVar.setPosition(8);
        int JJ = com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt());
        int readInt = lVar.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        b bVar = sparseArray.get(readInt);
        if (bVar == null) {
            return null;
        }
        if ((JJ & 1) != 0) {
            long dzE = lVar.dzE();
            bVar.mjH.mkH = dzE;
            bVar.mjH.mkI = dzE;
        }
        c cVar = bVar.mjJ;
        bVar.mjH.mkF = new c((JJ & 2) != 0 ? lVar.dzC() - 1 : cVar.mjd, (JJ & 8) != 0 ? lVar.dzC() : cVar.duration, (JJ & 16) != 0 ? lVar.dzC() : cVar.size, (JJ & 32) != 0 ? lVar.dzC() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 1 ? lVar.dzE() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JJ = com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt());
        j jVar = bVar.mjI;
        l lVar2 = bVar.mjH;
        c cVar = lVar2.mkF;
        lVar2.mkL[i] = lVar.dzC();
        lVar2.mkK[i] = lVar2.mkH;
        if ((JJ & 1) != 0) {
            long[] jArr = lVar2.mkK;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JJ & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dzC();
        }
        boolean z2 = (JJ & 256) != 0;
        boolean z3 = (JJ & 512) != 0;
        boolean z4 = (JJ & 1024) != 0;
        boolean z5 = (JJ & 2048) != 0;
        if (jVar.mkz == null || jVar.mkz.length != 1 || jVar.mkz[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.i(jVar.mkA[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mkM;
        int[] iArr2 = lVar2.mkN;
        long[] jArr2 = lVar2.mkO;
        boolean[] zArr = lVar2.mkP;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mkL[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mkW;
        }
        long j4 = j;
        while (i3 < i5) {
            int dzC = z2 ? lVar.dzC() : cVar.duration;
            int dzC2 = z3 ? lVar.dzC() : cVar.size;
            if (i3 == 0 && z) {
                readInt = i4;
            } else {
                readInt = z4 ? lVar.readInt() : cVar.flags;
            }
            if (z5) {
                iArr2[i3] = (int) ((lVar.readInt() * 1000) / j3);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = v.i(j4, 1000L, j3) - j2;
            iArr[i3] = dzC2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dzC;
            i3++;
        }
        lVar2.mkW = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.G(bArr, 0, 16);
        if (Arrays.equals(bArr, mjh)) {
            a(lVar, 16, lVar2);
        }
    }

    private static void b(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        a(lVar, 0, lVar2);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, l lVar2) throws ParserException {
        lVar.setPosition(i + 8);
        int JJ = com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt());
        if ((JJ & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (JJ & 2) != 0;
        int dzC = lVar.dzC();
        if (dzC != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzC + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mkR, 0, dzC, z);
        lVar2.JR(lVar.dzr());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == mjg) {
            if (com.google.android.exoplayer2.extractor.c.a.JI(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == mjg) {
                int JI = com.google.android.exoplayer2.extractor.c.a.JI(readInt2);
                if (JI == 1) {
                    if (lVar2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (JI >= 2) {
                    lVar2.skipBytes(4);
                }
                if (lVar2.readUnsignedInt() != 1) {
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                lVar2.skipBytes(1);
                int readUnsignedByte = lVar2.readUnsignedByte();
                int i = (readUnsignedByte & 240) >> 4;
                int i2 = readUnsignedByte & 15;
                boolean z = lVar2.readUnsignedByte() == 1;
                if (z) {
                    int readUnsignedByte2 = lVar2.readUnsignedByte();
                    byte[] bArr = new byte[16];
                    lVar2.G(bArr, 0, bArr.length);
                    byte[] bArr2 = null;
                    if (z && readUnsignedByte2 == 0) {
                        int readUnsignedByte3 = lVar2.readUnsignedByte();
                        bArr2 = new byte[readUnsignedByte3];
                        lVar2.G(bArr2, 0, readUnsignedByte3);
                    }
                    lVar3.mkQ = true;
                    lVar3.mkS = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dzE;
        long j2;
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JI == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dzE = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dzE2 = lVar.dzE();
            dzE = lVar.dzE() + j;
            j2 = dzE2;
        }
        long i = v.i(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dzE;
        int i2 = 0;
        long j4 = j2;
        long j5 = i;
        while (i2 < readUnsignedShort) {
            int readInt = lVar.readInt();
            if ((Integer.MIN_VALUE & readInt) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long readUnsignedInt3 = lVar.readUnsignedInt();
            iArr[i2] = readInt & Integer.MAX_VALUE;
            jArr[i2] = j3;
            jArr3[i2] = j5;
            long j6 = j4 + readUnsignedInt3;
            long i3 = v.i(j6, TimeUtils.NANOS_PER_MS, readUnsignedInt);
            jArr2[i2] = i3 - jArr3[i2];
            lVar.skipBytes(4);
            j3 += iArr[i2];
            i2++;
            j4 = j6;
            j5 = i3;
        }
        return Pair.create(Long.valueOf(i), new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3));
    }

    private void p(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        long j;
        b bVar;
        b bVar2 = null;
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        int size = this.mjk.size();
        int i = 0;
        while (i < size) {
            l lVar = this.mjk.valueAt(i).mjH;
            if (!lVar.mkV || lVar.mkI >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mkI;
                bVar = this.mjk.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.meC = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jv(position);
        bVar2.mjH.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.meC == 3) {
            if (this.mjB == null) {
                b f = f(this.mjk);
                if (f == null) {
                    int position = (int) (this.mjy - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jv(position);
                    dvc();
                    return false;
                }
                int position2 = (int) (f.mjH.mkK[f.mjM] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jv(position2);
                this.mjB = f;
            }
            this.sampleSize = this.mjB.mjH.mkM[this.mjB.mjK];
            if (this.mjB.mjH.mkQ) {
                this.mfR = a(this.mjB);
                this.sampleSize += this.mfR;
            } else {
                this.mfR = 0;
            }
            if (this.mjB.mjI.mky == 1) {
                this.sampleSize -= 8;
                fVar.Jv(8);
            }
            this.meC = 4;
            this.mfQ = 0;
        }
        l lVar = this.mjB.mjH;
        j jVar = this.mjB.mjI;
        com.google.android.exoplayer2.extractor.m mVar = this.mjB.meJ;
        int i2 = this.mjB.mjK;
        if (jVar.meM != 0) {
            byte[] bArr = this.mjl.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.meM + 1;
            int i4 = 4 - jVar.meM;
            while (this.mfR < this.sampleSize) {
                if (this.mfQ == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.mjl.setPosition(0);
                    this.mfQ = this.mjl.dzC() - 1;
                    this.meK.setPosition(0);
                    mVar.a(this.meK, 4);
                    mVar.a(this.mjl, 1);
                    this.mjC = this.mjE != null && com.google.android.exoplayer2.util.j.a(jVar.lZw.sampleMimeType, bArr[4]);
                    this.mfR += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.mjC) {
                        this.mjm.reset(this.mfQ);
                        fVar.readFully(this.mjm.data, 0, this.mfQ);
                        mVar.a(this.mjm, this.mfQ);
                        int i5 = this.mfQ;
                        int F = com.google.android.exoplayer2.util.j.F(this.mjm.data, this.mjm.dzs());
                        this.mjm.setPosition("video/hevc".equals(jVar.lZw.sampleMimeType) ? 1 : 0);
                        this.mjm.setLimit(F);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JS(i2) * 1000, this.mjm, this.mjE);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mfQ, false);
                    }
                    this.mfR += a2;
                    this.mfQ -= a2;
                }
            }
        } else {
            while (this.mfR < this.sampleSize) {
                this.mfR = mVar.a(fVar, this.sampleSize - this.mfR, false) + this.mfR;
            }
        }
        long JS = lVar.JS(i2) * 1000;
        if (this.mjp != null) {
            JS = this.mjp.gJ(JS);
        }
        int i6 = lVar.mkP[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mkQ) {
            i = 1073741824 | i6;
            aVar = (lVar.mkS != null ? lVar.mkS : jVar.JQ(lVar.mkF.mjd)).mfZ;
        } else {
            i = i6;
        }
        mVar.a(JS, i, this.sampleSize, 0, aVar);
        while (!this.mjt.isEmpty()) {
            a removeFirst = this.mjt.removeFirst();
            this.mjz -= removeFirst.size;
            this.mjD.a(removeFirst.mjG + JS, 1, removeFirst.size, this.mjz, null);
        }
        this.mjB.mjK++;
        this.mjB.mjL++;
        if (this.mjB.mjL == lVar.mkL[this.mjB.mjM]) {
            this.mjB.mjM++;
            this.mjB.mjL = 0;
            this.mjB = null;
        }
        this.meC = 3;
        return true;
    }

    private static b f(SparseArray<b> sparseArray) {
        b bVar;
        long j;
        b bVar2 = null;
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            b valueAt = sparseArray.valueAt(i);
            if (valueAt.mjM == valueAt.mjH.mkJ) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mjH.mkK[valueAt.mjM];
                if (j4 < j2) {
                    bVar = valueAt;
                    j = j4;
                } else {
                    long j5 = j2;
                    bVar = bVar2;
                    j = j5;
                }
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        return bVar2;
    }

    private int a(b bVar) {
        com.google.android.exoplayer2.util.l lVar;
        int length;
        l lVar2 = bVar.mjH;
        k JQ = lVar2.mkS != null ? lVar2.mkS : bVar.mjI.JQ(lVar2.mkF.mjd);
        if (JQ.mkD != 0) {
            lVar = lVar2.mkU;
            length = JQ.mkD;
        } else {
            byte[] bArr = JQ.mkE;
            this.mjo.I(bArr, bArr.length);
            lVar = this.mjo;
            length = bArr.length;
        }
        boolean z = lVar2.mkR[bVar.mjK];
        this.mjn.data[0] = (byte) ((z ? 128 : 0) | length);
        this.mjn.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.meJ;
        mVar.a(this.mjn, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mkU;
        int readUnsignedShort = lVar3.readUnsignedShort();
        lVar3.skipBytes(-2);
        int i = (readUnsignedShort * 6) + 2;
        mVar.a(lVar3, i);
        return length + 1 + i;
    }

    private static DrmInitData fa(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            a.b bVar = list.get(i);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhK) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.miJ.data;
                UUID au = h.au(bArr);
                if (au == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(au, MimeType.Video.MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static boolean JN(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mhH || i == com.google.android.exoplayer2.extractor.c.a.mhs || i == com.google.android.exoplayer2.extractor.c.a.mhq || i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mhm || i == com.google.android.exoplayer2.extractor.c.a.mhn || i == com.google.android.exoplayer2.extractor.c.a.mhE || i == com.google.android.exoplayer2.extractor.c.a.mho || i == com.google.android.exoplayer2.extractor.c.a.mhp || i == com.google.android.exoplayer2.extractor.c.a.mhK || i == com.google.android.exoplayer2.extractor.c.a.mhS || i == com.google.android.exoplayer2.extractor.c.a.mhT || i == com.google.android.exoplayer2.extractor.c.a.mhX || i == com.google.android.exoplayer2.extractor.c.a.mhW || i == com.google.android.exoplayer2.extractor.c.a.mhU || i == com.google.android.exoplayer2.extractor.c.a.mhV || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mhD || i == com.google.android.exoplayer2.extractor.c.a.miy;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhr || i == com.google.android.exoplayer2.extractor.c.a.mht || i == com.google.android.exoplayer2.extractor.c.a.mhu || i == com.google.android.exoplayer2.extractor.c.a.mhv || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhA || i == com.google.android.exoplayer2.extractor.c.a.mhB || i == com.google.android.exoplayer2.extractor.c.a.mhC || i == com.google.android.exoplayer2.extractor.c.a.mhF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long mjG;
        public final int size;

        public a(long j, int i) {
            this.mjG = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m meJ;
        public final l mjH = new l();
        public j mjI;
        public c mjJ;
        public int mjK;
        public int mjL;
        public int mjM;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.meJ = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mjI = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mjJ = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.meJ.h(jVar.lZw);
            reset();
        }

        public void reset() {
            this.mjH.reset();
            this.mjK = 0;
            this.mjM = 0;
            this.mjL = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JQ = this.mjI.JQ(this.mjH.mkF.mjd);
            this.meJ.h(this.mjI.lZw.a(drmInitData.Pq(JQ != null ? JQ.schemeType : null)));
        }
    }
}
