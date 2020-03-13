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
    public static final com.google.android.exoplayer2.extractor.h meI = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int mjt = v.QF(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] mju = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lZO;
    private com.google.android.exoplayer2.extractor.g meO;
    private int meP;
    private final com.google.android.exoplayer2.util.l meX;
    private int mgd;
    private int mge;
    private final com.google.android.exoplayer2.util.l mjA;
    private final com.google.android.exoplayer2.util.l mjB;
    private final s mjC;
    private final com.google.android.exoplayer2.util.l mjD;
    private final byte[] mjE;
    private final Stack<a.C0674a> mjF;
    private final LinkedList<a> mjG;
    private int mjH;
    private long mjI;
    private int mjJ;
    private com.google.android.exoplayer2.util.l mjK;
    private long mjL;
    private int mjM;
    private long mjN;
    private b mjO;
    private boolean mjP;
    private com.google.android.exoplayer2.extractor.m mjQ;
    private com.google.android.exoplayer2.extractor.m[] mjR;
    private boolean mjS;
    private final j mjv;
    private final DrmInitData mjw;
    private final SparseArray<b> mjx;
    private final com.google.android.exoplayer2.util.l mjy;
    private final com.google.android.exoplayer2.util.l mjz;
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
        this.mjC = sVar;
        this.mjv = jVar;
        this.mjw = drmInitData;
        this.mjD = new com.google.android.exoplayer2.util.l(16);
        this.meX = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mHm);
        this.mjy = new com.google.android.exoplayer2.util.l(5);
        this.mjz = new com.google.android.exoplayer2.util.l();
        this.mjA = new com.google.android.exoplayer2.util.l(1);
        this.mjB = new com.google.android.exoplayer2.util.l();
        this.mjE = new byte[16];
        this.mjF = new Stack<>();
        this.mjG = new LinkedList<>();
        this.mjx = new SparseArray<>();
        this.lZO = -9223372036854775807L;
        this.mjN = -9223372036854775807L;
        dvf();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meO = gVar;
        if (this.mjv != null) {
            b bVar = new b(gVar.dK(0, this.mjv.type));
            bVar.a(this.mjv, new c(0, 0, 0, 0));
            this.mjx.put(0, bVar);
            dvg();
            this.meO.duV();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.mjx.size();
        for (int i = 0; i < size; i++) {
            this.mjx.valueAt(i).reset();
        }
        this.mjG.clear();
        this.mjM = 0;
        this.mjF.clear();
        dvf();
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
        long position = fVar.getPosition() - this.mjJ;
        if (this.mjH == com.google.android.exoplayer2.extractor.c.a.mhN) {
            int size = this.mjx.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.mjx.valueAt(i).mjU;
                lVar.mkT = position;
                lVar.mkV = position;
                lVar.mkU = position;
            }
        }
        if (this.mjH == com.google.android.exoplayer2.extractor.c.a.mhk) {
            this.mjO = null;
            this.mjL = this.mjI + position;
            if (!this.mjS) {
                this.meO.a(new l.a(this.lZO));
                this.mjS = true;
            }
            this.meP = 2;
            return true;
        }
        if (JO(this.mjH)) {
            long position2 = (fVar.getPosition() + this.mjI) - 8;
            this.mjF.add(new a.C0674a(this.mjH, position2));
            if (this.mjI == this.mjJ) {
                fO(position2);
            } else {
                dvf();
            }
        } else if (JN(this.mjH)) {
            if (this.mjJ != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.mjI > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.mjK = new com.google.android.exoplayer2.util.l((int) this.mjI);
            System.arraycopy(this.mjD.data, 0, this.mjK.data, 0, 8);
            this.meP = 1;
        } else if (this.mjI > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.mjK = null;
            this.meP = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.mjI) - this.mjJ;
        if (this.mjK != null) {
            fVar.readFully(this.mjK.data, 8, i);
            a(new a.b(this.mjH, this.mjK), fVar.getPosition());
        } else {
            fVar.Jv(i);
        }
        fO(fVar.getPosition());
    }

    private void fO(long j) throws ParserException {
        while (!this.mjF.isEmpty() && this.mjF.peek().endPosition == j) {
            c(this.mjF.pop());
        }
        dvf();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.mjF.isEmpty()) {
            this.mjF.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhD) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.miW, j);
            this.mjN = ((Long) c.first).longValue();
            this.meO.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.mjS = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.miL) {
            q(bVar.miW);
        }
    }

    private void c(a.C0674a c0674a) throws ParserException {
        if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mhE) {
            d(c0674a);
        } else if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mhN) {
            e(c0674a);
        } else if (!this.mjF.isEmpty()) {
            this.mjF.peek().a(c0674a);
        }
    }

    private void d(a.C0674a c0674a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.mjv == null, "Unexpected moov box.");
        DrmInitData fa = this.mjw != null ? this.mjw : fa(c0674a.miU);
        a.C0674a JM = c0674a.JM(com.google.android.exoplayer2.extractor.c.a.mhP);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JM.miU.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JM.miU.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhB) {
                Pair<Integer, c> r = r(bVar.miW);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhQ) {
                j = s(bVar.miW);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0674a.miV.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0674a c0674a2 = c0674a.miV.get(i3);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mhG) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhF), j, fa, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.mjx.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.meO.dK(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.mjx.put(jVar.id, bVar2);
                this.lZO = Math.max(this.lZO, jVar.lZO);
                i++;
            }
            dvg();
            this.meO.duV();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.mjx.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.mjx.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0674a c0674a) throws ParserException {
        a(c0674a, this.mjx, this.flags, this.mjE);
        DrmInitData fa = this.mjw != null ? null : fa(c0674a.miU);
        if (fa != null) {
            int size = this.mjx.size();
            for (int i = 0; i < size; i++) {
                this.mjx.valueAt(i).d(fa);
            }
        }
    }

    private void dvg() {
        if ((this.flags & 4) != 0 && this.mjQ == null) {
            this.mjQ = this.meO.dK(this.mjx.size(), 4);
            this.mjQ.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.mjR == null) {
            com.google.android.exoplayer2.extractor.m dK = this.meO.dK(this.mjx.size() + 1, 3);
            dK.h(Format.a(null, "application/cea-608", 0, null));
            this.mjR = new com.google.android.exoplayer2.extractor.m[]{dK};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.mjQ != null) {
            lVar.setPosition(12);
            lVar.dzI();
            lVar.dzI();
            long i = v.i(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dzu = lVar.dzu();
            this.mjQ.a(lVar, dzu);
            if (this.mjN != -9223372036854775807L) {
                this.mjQ.a(i + this.mjN, 1, dzu, 0, null);
                return;
            }
            this.mjG.addLast(new a(i, dzu));
            this.mjM += dzu;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dzF() - 1, lVar.dzF(), lVar.dzF(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dzH();
    }

    private static void a(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0674a.miV.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0674a c0674a2 = c0674a.miV.get(i2);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mhO) {
                b(c0674a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhA).miW, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mjU;
            long j = lVar.mlj;
            a2.reset();
            if (c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhz) != null && (i & 2) == 0) {
                j = t(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhz).miW);
            }
            a(c0674a, a2, j, i);
            k JQ = a2.mjV.JQ(lVar.mkS.mjq);
            a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mig);
            if (JL != null) {
                a(JQ, JL.miW, lVar);
            }
            a.b JL2 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mih);
            if (JL2 != null) {
                a(JL2.miW, lVar);
            }
            a.b JL3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mil);
            if (JL3 != null) {
                b(JL3.miW, lVar);
            }
            a.b JL4 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mii);
            a.b JL5 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mij);
            if (JL4 != null && JL5 != null) {
                a(JL4.miW, JL5.miW, JQ != null ? JQ.schemeType : null, lVar);
            }
            int size = c0674a.miU.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0674a.miU.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mik) {
                    a(bVar.miW, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0674a c0674a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0674a.miU;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mhC) {
                com.google.android.exoplayer2.util.l lVar = bVar2.miW;
                lVar.setPosition(12);
                int dzF = lVar.dzF();
                if (dzF > 0) {
                    i2 = dzF + i5;
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
        bVar.mjZ = 0;
        bVar.mjY = 0;
        bVar.mjX = 0;
        bVar.mjU.dL(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mhC) {
                i7 = a(bVar, i8, j, i, bVar3.miW, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mkQ;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dzF = lVar.dzF();
        if (dzF != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzF + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mle;
            int i3 = 0;
            i = 0;
            while (i3 < dzF) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dzF) + 0;
            Arrays.fill(lVar2.mle, 0, dzF, z);
        }
        lVar2.JR(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dzF = lVar.dzF();
        if (dzF != 1) {
            throw new ParserException("Unexpected saio entry count: " + dzF);
        }
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(readInt);
        lVar2.mkV = (JI == 0 ? lVar.readUnsignedInt() : lVar.dzH()) + lVar2.mkV;
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
            long dzH = lVar.dzH();
            bVar.mjU.mkU = dzH;
            bVar.mjU.mkV = dzH;
        }
        c cVar = bVar.mjW;
        bVar.mjU.mkS = new c((JJ & 2) != 0 ? lVar.dzF() - 1 : cVar.mjq, (JJ & 8) != 0 ? lVar.dzF() : cVar.duration, (JJ & 16) != 0 ? lVar.dzF() : cVar.size, (JJ & 32) != 0 ? lVar.dzF() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 1 ? lVar.dzH() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JJ = com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt());
        j jVar = bVar.mjV;
        l lVar2 = bVar.mjU;
        c cVar = lVar2.mkS;
        lVar2.mkY[i] = lVar.dzF();
        lVar2.mkX[i] = lVar2.mkU;
        if ((JJ & 1) != 0) {
            long[] jArr = lVar2.mkX;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JJ & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dzF();
        }
        boolean z2 = (JJ & 256) != 0;
        boolean z3 = (JJ & 512) != 0;
        boolean z4 = (JJ & 1024) != 0;
        boolean z5 = (JJ & 2048) != 0;
        if (jVar.mkM == null || jVar.mkM.length != 1 || jVar.mkM[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.i(jVar.mkN[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mkZ;
        int[] iArr2 = lVar2.mla;
        long[] jArr2 = lVar2.mlb;
        boolean[] zArr = lVar2.mlc;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mkY[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mlj;
        }
        long j4 = j;
        while (i3 < i5) {
            int dzF = z2 ? lVar.dzF() : cVar.duration;
            int dzF2 = z3 ? lVar.dzF() : cVar.size;
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
            iArr[i3] = dzF2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dzF;
            i3++;
        }
        lVar2.mlj = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.G(bArr, 0, 16);
        if (Arrays.equals(bArr, mju)) {
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
        int dzF = lVar.dzF();
        if (dzF != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzF + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mle, 0, dzF, z);
        lVar2.JR(lVar.dzu());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == mjt) {
            if (com.google.android.exoplayer2.extractor.c.a.JI(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == mjt) {
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
                    lVar3.mld = true;
                    lVar3.mlf = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dzH;
        long j2;
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JI == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dzH = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dzH2 = lVar.dzH();
            dzH = lVar.dzH() + j;
            j2 = dzH2;
        }
        long i = v.i(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dzH;
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
        int size = this.mjx.size();
        int i = 0;
        while (i < size) {
            l lVar = this.mjx.valueAt(i).mjU;
            if (!lVar.mli || lVar.mkV >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mkV;
                bVar = this.mjx.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.meP = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jv(position);
        bVar2.mjU.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.meP == 3) {
            if (this.mjO == null) {
                b f = f(this.mjx);
                if (f == null) {
                    int position = (int) (this.mjL - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jv(position);
                    dvf();
                    return false;
                }
                int position2 = (int) (f.mjU.mkX[f.mjZ] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jv(position2);
                this.mjO = f;
            }
            this.sampleSize = this.mjO.mjU.mkZ[this.mjO.mjX];
            if (this.mjO.mjU.mld) {
                this.mge = a(this.mjO);
                this.sampleSize += this.mge;
            } else {
                this.mge = 0;
            }
            if (this.mjO.mjV.mkL == 1) {
                this.sampleSize -= 8;
                fVar.Jv(8);
            }
            this.meP = 4;
            this.mgd = 0;
        }
        l lVar = this.mjO.mjU;
        j jVar = this.mjO.mjV;
        com.google.android.exoplayer2.extractor.m mVar = this.mjO.meW;
        int i2 = this.mjO.mjX;
        if (jVar.meZ != 0) {
            byte[] bArr = this.mjy.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.meZ + 1;
            int i4 = 4 - jVar.meZ;
            while (this.mge < this.sampleSize) {
                if (this.mgd == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.mjy.setPosition(0);
                    this.mgd = this.mjy.dzF() - 1;
                    this.meX.setPosition(0);
                    mVar.a(this.meX, 4);
                    mVar.a(this.mjy, 1);
                    this.mjP = this.mjR != null && com.google.android.exoplayer2.util.j.a(jVar.lZJ.sampleMimeType, bArr[4]);
                    this.mge += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.mjP) {
                        this.mjz.reset(this.mgd);
                        fVar.readFully(this.mjz.data, 0, this.mgd);
                        mVar.a(this.mjz, this.mgd);
                        int i5 = this.mgd;
                        int F = com.google.android.exoplayer2.util.j.F(this.mjz.data, this.mjz.dzv());
                        this.mjz.setPosition("video/hevc".equals(jVar.lZJ.sampleMimeType) ? 1 : 0);
                        this.mjz.setLimit(F);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JS(i2) * 1000, this.mjz, this.mjR);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mgd, false);
                    }
                    this.mge += a2;
                    this.mgd -= a2;
                }
            }
        } else {
            while (this.mge < this.sampleSize) {
                this.mge = mVar.a(fVar, this.sampleSize - this.mge, false) + this.mge;
            }
        }
        long JS = lVar.JS(i2) * 1000;
        if (this.mjC != null) {
            JS = this.mjC.gJ(JS);
        }
        int i6 = lVar.mlc[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mld) {
            i = 1073741824 | i6;
            aVar = (lVar.mlf != null ? lVar.mlf : jVar.JQ(lVar.mkS.mjq)).mgm;
        } else {
            i = i6;
        }
        mVar.a(JS, i, this.sampleSize, 0, aVar);
        while (!this.mjG.isEmpty()) {
            a removeFirst = this.mjG.removeFirst();
            this.mjM -= removeFirst.size;
            this.mjQ.a(removeFirst.mjT + JS, 1, removeFirst.size, this.mjM, null);
        }
        this.mjO.mjX++;
        this.mjO.mjY++;
        if (this.mjO.mjY == lVar.mkY[this.mjO.mjZ]) {
            this.mjO.mjZ++;
            this.mjO.mjY = 0;
            this.mjO = null;
        }
        this.meP = 3;
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
            if (valueAt.mjZ == valueAt.mjU.mkW) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mjU.mkX[valueAt.mjZ];
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
        l lVar2 = bVar.mjU;
        k JQ = lVar2.mlf != null ? lVar2.mlf : bVar.mjV.JQ(lVar2.mkS.mjq);
        if (JQ.mkQ != 0) {
            lVar = lVar2.mlh;
            length = JQ.mkQ;
        } else {
            byte[] bArr = JQ.mkR;
            this.mjB.I(bArr, bArr.length);
            lVar = this.mjB;
            length = bArr.length;
        }
        boolean z = lVar2.mle[bVar.mjX];
        this.mjA.data[0] = (byte) ((z ? 128 : 0) | length);
        this.mjA.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.meW;
        mVar.a(this.mjA, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mlh;
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
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhX) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.miW.data;
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
        return i == com.google.android.exoplayer2.extractor.c.a.mhV || i == com.google.android.exoplayer2.extractor.c.a.mhU || i == com.google.android.exoplayer2.extractor.c.a.mhF || i == com.google.android.exoplayer2.extractor.c.a.mhD || i == com.google.android.exoplayer2.extractor.c.a.mhW || i == com.google.android.exoplayer2.extractor.c.a.mhz || i == com.google.android.exoplayer2.extractor.c.a.mhA || i == com.google.android.exoplayer2.extractor.c.a.mhR || i == com.google.android.exoplayer2.extractor.c.a.mhB || i == com.google.android.exoplayer2.extractor.c.a.mhC || i == com.google.android.exoplayer2.extractor.c.a.mhX || i == com.google.android.exoplayer2.extractor.c.a.mig || i == com.google.android.exoplayer2.extractor.c.a.mih || i == com.google.android.exoplayer2.extractor.c.a.mil || i == com.google.android.exoplayer2.extractor.c.a.mik || i == com.google.android.exoplayer2.extractor.c.a.mii || i == com.google.android.exoplayer2.extractor.c.a.mij || i == com.google.android.exoplayer2.extractor.c.a.mhT || i == com.google.android.exoplayer2.extractor.c.a.mhQ || i == com.google.android.exoplayer2.extractor.c.a.miL;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mhE || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mhH || i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mhN || i == com.google.android.exoplayer2.extractor.c.a.mhO || i == com.google.android.exoplayer2.extractor.c.a.mhP || i == com.google.android.exoplayer2.extractor.c.a.mhS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long mjT;
        public final int size;

        public a(long j, int i) {
            this.mjT = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m meW;
        public final l mjU = new l();
        public j mjV;
        public c mjW;
        public int mjX;
        public int mjY;
        public int mjZ;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.meW = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mjV = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mjW = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.meW.h(jVar.lZJ);
            reset();
        }

        public void reset() {
            this.mjU.reset();
            this.mjX = 0;
            this.mjZ = 0;
            this.mjY = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JQ = this.mjV.JQ(this.mjU.mkS.mjq);
            this.meW.h(this.mjV.lZJ.a(drmInitData.Pr(JQ != null ? JQ.schemeType : null)));
        }
    }
}
