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
/* loaded from: classes5.dex */
public final class e implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int miv = v.Qr(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] miw = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lYQ;
    private com.google.android.exoplayer2.extractor.g mdQ;
    private int mdR;
    private final com.google.android.exoplayer2.util.l mdZ;
    private int mff;
    private int mfg;
    private final com.google.android.exoplayer2.util.l miA;
    private final com.google.android.exoplayer2.util.l miB;
    private final com.google.android.exoplayer2.util.l miC;
    private final com.google.android.exoplayer2.util.l miD;
    private final s miE;
    private final com.google.android.exoplayer2.util.l miF;
    private final byte[] miG;
    private final Stack<a.C0666a> miH;
    private final LinkedList<a> miI;
    private int miJ;
    private long miK;
    private int miL;
    private com.google.android.exoplayer2.util.l miM;
    private long miN;
    private int miO;
    private long miP;
    private b miQ;
    private boolean miR;
    private com.google.android.exoplayer2.extractor.m miS;
    private com.google.android.exoplayer2.extractor.m[] miT;
    private boolean miU;
    private final j mix;
    private final DrmInitData miy;
    private final SparseArray<b> miz;
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
        this.miE = sVar;
        this.mix = jVar;
        this.miy = drmInitData;
        this.miF = new com.google.android.exoplayer2.util.l(16);
        this.mdZ = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGo);
        this.miA = new com.google.android.exoplayer2.util.l(5);
        this.miB = new com.google.android.exoplayer2.util.l();
        this.miC = new com.google.android.exoplayer2.util.l(1);
        this.miD = new com.google.android.exoplayer2.util.l();
        this.miG = new byte[16];
        this.miH = new Stack<>();
        this.miI = new LinkedList<>();
        this.miz = new SparseArray<>();
        this.lYQ = -9223372036854775807L;
        this.miP = -9223372036854775807L;
        dtP();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mdQ = gVar;
        if (this.mix != null) {
            b bVar = new b(gVar.dH(0, this.mix.type));
            bVar.a(this.mix, new c(0, 0, 0, 0));
            this.miz.put(0, bVar);
            dtQ();
            this.mdQ.dtF();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.miz.size();
        for (int i = 0; i < size; i++) {
            this.miz.valueAt(i).reset();
        }
        this.miI.clear();
        this.miO = 0;
        this.miH.clear();
        dtP();
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
        long position = fVar.getPosition() - this.miL;
        if (this.miJ == com.google.android.exoplayer2.extractor.c.a.mgP) {
            int size = this.miz.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.miz.valueAt(i).miW;
                lVar.mjV = position;
                lVar.mjX = position;
                lVar.mjW = position;
            }
        }
        if (this.miJ == com.google.android.exoplayer2.extractor.c.a.mgm) {
            this.miQ = null;
            this.miN = this.miK + position;
            if (!this.miU) {
                this.mdQ.a(new l.a(this.lYQ));
                this.miU = true;
            }
            this.mdR = 2;
            return true;
        }
        if (JJ(this.miJ)) {
            long position2 = (fVar.getPosition() + this.miK) - 8;
            this.miH.add(new a.C0666a(this.miJ, position2));
            if (this.miK == this.miL) {
                fQ(position2);
            } else {
                dtP();
            }
        } else if (JI(this.miJ)) {
            if (this.miL != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.miK > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.miM = new com.google.android.exoplayer2.util.l((int) this.miK);
            System.arraycopy(this.miF.data, 0, this.miM.data, 0, 8);
            this.mdR = 1;
        } else if (this.miK > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.miM = null;
            this.mdR = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.miK) - this.miL;
        if (this.miM != null) {
            fVar.readFully(this.miM.data, 8, i);
            a(new a.b(this.miJ, this.miM), fVar.getPosition());
        } else {
            fVar.Jq(i);
        }
        fQ(fVar.getPosition());
    }

    private void fQ(long j) throws ParserException {
        while (!this.miH.isEmpty() && this.miH.peek().endPosition == j) {
            c(this.miH.pop());
        }
        dtP();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.miH.isEmpty()) {
            this.miH.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgF) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.mhW, j);
            this.miP = ((Long) c.first).longValue();
            this.mdQ.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.miU = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhL) {
            q(bVar.mhW);
        }
    }

    private void c(a.C0666a c0666a) throws ParserException {
        if (c0666a.type == com.google.android.exoplayer2.extractor.c.a.mgG) {
            d(c0666a);
        } else if (c0666a.type == com.google.android.exoplayer2.extractor.c.a.mgP) {
            e(c0666a);
        } else if (!this.miH.isEmpty()) {
            this.miH.peek().a(c0666a);
        }
    }

    private void d(a.C0666a c0666a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.mix == null, "Unexpected moov box.");
        DrmInitData ff = this.miy != null ? this.miy : ff(c0666a.mhU);
        a.C0666a JH = c0666a.JH(com.google.android.exoplayer2.extractor.c.a.mgR);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JH.mhU.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JH.mhU.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgD) {
                Pair<Integer, c> r = r(bVar.mhW);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgS) {
                j = s(bVar.mhW);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0666a.mhV.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0666a c0666a2 = c0666a.mhV.get(i3);
            if (c0666a2.type == com.google.android.exoplayer2.extractor.c.a.mgI) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0666a2, c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgH), j, ff, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.miz.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.mdQ.dH(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.miz.put(jVar.id, bVar2);
                this.lYQ = Math.max(this.lYQ, jVar.lYQ);
                i++;
            }
            dtQ();
            this.mdQ.dtF();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.miz.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.miz.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0666a c0666a) throws ParserException {
        a(c0666a, this.miz, this.flags, this.miG);
        DrmInitData ff = this.miy != null ? null : ff(c0666a.mhU);
        if (ff != null) {
            int size = this.miz.size();
            for (int i = 0; i < size; i++) {
                this.miz.valueAt(i).d(ff);
            }
        }
    }

    private void dtQ() {
        if ((this.flags & 4) != 0 && this.miS == null) {
            this.miS = this.mdQ.dH(this.miz.size(), 4);
            this.miS.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.miT == null) {
            com.google.android.exoplayer2.extractor.m dH = this.mdQ.dH(this.miz.size() + 1, 3);
            dH.h(Format.a(null, "application/cea-608", 0, null));
            this.miT = new com.google.android.exoplayer2.extractor.m[]{dH};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.miS != null) {
            lVar.setPosition(12);
            lVar.dyt();
            lVar.dyt();
            long h = v.h(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dyf = lVar.dyf();
            this.miS.a(lVar, dyf);
            if (this.miP != -9223372036854775807L) {
                this.miS.a(h + this.miP, 1, dyf, 0, null);
                return;
            }
            this.miI.addLast(new a(h, dyf));
            this.miO += dyf;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dyq() - 1, lVar.dyq(), lVar.dyq(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dys();
    }

    private static void a(a.C0666a c0666a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0666a.mhV.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0666a c0666a2 = c0666a.mhV.get(i2);
            if (c0666a2.type == com.google.android.exoplayer2.extractor.c.a.mgQ) {
                b(c0666a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0666a c0666a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgC).mhW, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.miW;
            long j = lVar.mkl;
            a2.reset();
            if (c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgB) != null && (i & 2) == 0) {
                j = t(c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgB).mhW);
            }
            a(c0666a, a2, j, i);
            k JL = a2.miX.JL(lVar.mjU.mis);
            a.b JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhh);
            if (JG != null) {
                a(JL, JG.mhW, lVar);
            }
            a.b JG2 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhi);
            if (JG2 != null) {
                a(JG2.mhW, lVar);
            }
            a.b JG3 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhm);
            if (JG3 != null) {
                b(JG3.mhW, lVar);
            }
            a.b JG4 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhj);
            a.b JG5 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhk);
            if (JG4 != null && JG5 != null) {
                a(JG4.mhW, JG5.mhW, JL != null ? JL.schemeType : null, lVar);
            }
            int size = c0666a.mhU.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0666a.mhU.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhl) {
                    a(bVar.mhW, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0666a c0666a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0666a.mhU;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mgE) {
                com.google.android.exoplayer2.util.l lVar = bVar2.mhW;
                lVar.setPosition(12);
                int dyq = lVar.dyq();
                if (dyq > 0) {
                    i2 = dyq + i5;
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
        bVar.mjb = 0;
        bVar.mja = 0;
        bVar.miZ = 0;
        bVar.miW.dI(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mgE) {
                i7 = a(bVar, i8, j, i, bVar3.mhW, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mjS;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dyq = lVar.dyq();
        if (dyq != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dyq + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mkg;
            int i3 = 0;
            i = 0;
            while (i3 < dyq) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dyq) + 0;
            Arrays.fill(lVar2.mkg, 0, dyq, z);
        }
        lVar2.JM(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JE(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dyq = lVar.dyq();
        if (dyq != 1) {
            throw new ParserException("Unexpected saio entry count: " + dyq);
        }
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(readInt);
        lVar2.mjX = (JD == 0 ? lVar.readUnsignedInt() : lVar.dys()) + lVar2.mjX;
    }

    private static b a(com.google.android.exoplayer2.util.l lVar, SparseArray<b> sparseArray, int i) {
        lVar.setPosition(8);
        int JE = com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt());
        int readInt = lVar.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        b bVar = sparseArray.get(readInt);
        if (bVar == null) {
            return null;
        }
        if ((JE & 1) != 0) {
            long dys = lVar.dys();
            bVar.miW.mjW = dys;
            bVar.miW.mjX = dys;
        }
        c cVar = bVar.miY;
        bVar.miW.mjU = new c((JE & 2) != 0 ? lVar.dyq() - 1 : cVar.mis, (JE & 8) != 0 ? lVar.dyq() : cVar.duration, (JE & 16) != 0 ? lVar.dyq() : cVar.size, (JE & 32) != 0 ? lVar.dyq() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt()) == 1 ? lVar.dys() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JE = com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt());
        j jVar = bVar.miX;
        l lVar2 = bVar.miW;
        c cVar = lVar2.mjU;
        lVar2.mka[i] = lVar.dyq();
        lVar2.mjZ[i] = lVar2.mjW;
        if ((JE & 1) != 0) {
            long[] jArr = lVar2.mjZ;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JE & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dyq();
        }
        boolean z2 = (JE & 256) != 0;
        boolean z3 = (JE & 512) != 0;
        boolean z4 = (JE & 1024) != 0;
        boolean z5 = (JE & 2048) != 0;
        if (jVar.mjO == null || jVar.mjO.length != 1 || jVar.mjO[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.h(jVar.mjP[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mkb;
        int[] iArr2 = lVar2.mkc;
        long[] jArr2 = lVar2.mkd;
        boolean[] zArr = lVar2.mke;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mka[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mkl;
        }
        long j4 = j;
        while (i3 < i5) {
            int dyq = z2 ? lVar.dyq() : cVar.duration;
            int dyq2 = z3 ? lVar.dyq() : cVar.size;
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
            jArr2[i3] = v.h(j4, 1000L, j3) - j2;
            iArr[i3] = dyq2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dyq;
            i3++;
        }
        lVar2.mkl = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.C(bArr, 0, 16);
        if (Arrays.equals(bArr, miw)) {
            a(lVar, 16, lVar2);
        }
    }

    private static void b(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        a(lVar, 0, lVar2);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, l lVar2) throws ParserException {
        lVar.setPosition(i + 8);
        int JE = com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt());
        if ((JE & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (JE & 2) != 0;
        int dyq = lVar.dyq();
        if (dyq != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dyq + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mkg, 0, dyq, z);
        lVar2.JM(lVar.dyf());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == miv) {
            if (com.google.android.exoplayer2.extractor.c.a.JD(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == miv) {
                int JD = com.google.android.exoplayer2.extractor.c.a.JD(readInt2);
                if (JD == 1) {
                    if (lVar2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (JD >= 2) {
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
                    lVar2.C(bArr, 0, bArr.length);
                    byte[] bArr2 = null;
                    if (z && readUnsignedByte2 == 0) {
                        int readUnsignedByte3 = lVar2.readUnsignedByte();
                        bArr2 = new byte[readUnsignedByte3];
                        lVar2.C(bArr2, 0, readUnsignedByte3);
                    }
                    lVar3.mkf = true;
                    lVar3.mkh = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dys;
        long j2;
        lVar.setPosition(8);
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JD == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dys = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dys2 = lVar.dys();
            dys = lVar.dys() + j;
            j2 = dys2;
        }
        long h = v.h(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dys;
        int i = 0;
        long j4 = j2;
        long j5 = h;
        while (i < readUnsignedShort) {
            int readInt = lVar.readInt();
            if ((Integer.MIN_VALUE & readInt) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long readUnsignedInt3 = lVar.readUnsignedInt();
            iArr[i] = readInt & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j5;
            long j6 = j4 + readUnsignedInt3;
            long h2 = v.h(j6, TimeUtils.NANOS_PER_MS, readUnsignedInt);
            jArr2[i] = h2 - jArr3[i];
            lVar.skipBytes(4);
            j3 += iArr[i];
            i++;
            j4 = j6;
            j5 = h2;
        }
        return Pair.create(Long.valueOf(h), new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3));
    }

    private void p(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        long j;
        b bVar;
        b bVar2 = null;
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        int size = this.miz.size();
        int i = 0;
        while (i < size) {
            l lVar = this.miz.valueAt(i).miW;
            if (!lVar.mkk || lVar.mjX >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mjX;
                bVar = this.miz.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.mdR = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jq(position);
        bVar2.miW.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.mdR == 3) {
            if (this.miQ == null) {
                b f = f(this.miz);
                if (f == null) {
                    int position = (int) (this.miN - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jq(position);
                    dtP();
                    return false;
                }
                int position2 = (int) (f.miW.mjZ[f.mjb] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jq(position2);
                this.miQ = f;
            }
            this.sampleSize = this.miQ.miW.mkb[this.miQ.miZ];
            if (this.miQ.miW.mkf) {
                this.mfg = a(this.miQ);
                this.sampleSize += this.mfg;
            } else {
                this.mfg = 0;
            }
            if (this.miQ.miX.mjN == 1) {
                this.sampleSize -= 8;
                fVar.Jq(8);
            }
            this.mdR = 4;
            this.mff = 0;
        }
        l lVar = this.miQ.miW;
        j jVar = this.miQ.miX;
        com.google.android.exoplayer2.extractor.m mVar = this.miQ.mdY;
        int i2 = this.miQ.miZ;
        if (jVar.meb != 0) {
            byte[] bArr = this.miA.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.meb + 1;
            int i4 = 4 - jVar.meb;
            while (this.mfg < this.sampleSize) {
                if (this.mff == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.miA.setPosition(0);
                    this.mff = this.miA.dyq() - 1;
                    this.mdZ.setPosition(0);
                    mVar.a(this.mdZ, 4);
                    mVar.a(this.miA, 1);
                    this.miR = this.miT != null && com.google.android.exoplayer2.util.j.a(jVar.lYL.sampleMimeType, bArr[4]);
                    this.mfg += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.miR) {
                        this.miB.reset(this.mff);
                        fVar.readFully(this.miB.data, 0, this.mff);
                        mVar.a(this.miB, this.mff);
                        int i5 = this.mff;
                        int D = com.google.android.exoplayer2.util.j.D(this.miB.data, this.miB.dyg());
                        this.miB.setPosition("video/hevc".equals(jVar.lYL.sampleMimeType) ? 1 : 0);
                        this.miB.setLimit(D);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JN(i2) * 1000, this.miB, this.miT);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mff, false);
                    }
                    this.mfg += a2;
                    this.mff -= a2;
                }
            }
        } else {
            while (this.mfg < this.sampleSize) {
                this.mfg = mVar.a(fVar, this.sampleSize - this.mfg, false) + this.mfg;
            }
        }
        long JN = lVar.JN(i2) * 1000;
        if (this.miE != null) {
            JN = this.miE.gL(JN);
        }
        int i6 = lVar.mke[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mkf) {
            i = 1073741824 | i6;
            aVar = (lVar.mkh != null ? lVar.mkh : jVar.JL(lVar.mjU.mis)).mfo;
        } else {
            i = i6;
        }
        mVar.a(JN, i, this.sampleSize, 0, aVar);
        while (!this.miI.isEmpty()) {
            a removeFirst = this.miI.removeFirst();
            this.miO -= removeFirst.size;
            this.miS.a(removeFirst.miV + JN, 1, removeFirst.size, this.miO, null);
        }
        this.miQ.miZ++;
        this.miQ.mja++;
        if (this.miQ.mja == lVar.mka[this.miQ.mjb]) {
            this.miQ.mjb++;
            this.miQ.mja = 0;
            this.miQ = null;
        }
        this.mdR = 3;
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
            if (valueAt.mjb == valueAt.miW.mjY) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.miW.mjZ[valueAt.mjb];
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
        l lVar2 = bVar.miW;
        k JL = lVar2.mkh != null ? lVar2.mkh : bVar.miX.JL(lVar2.mjU.mis);
        if (JL.mjS != 0) {
            lVar = lVar2.mkj;
            length = JL.mjS;
        } else {
            byte[] bArr = JL.mjT;
            this.miD.G(bArr, bArr.length);
            lVar = this.miD;
            length = bArr.length;
        }
        boolean z = lVar2.mkg[bVar.miZ];
        this.miC.data[0] = (byte) ((z ? 128 : 0) | length);
        this.miC.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.mdY;
        mVar.a(this.miC, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mkj;
        int readUnsignedShort = lVar3.readUnsignedShort();
        lVar3.skipBytes(-2);
        int i = (readUnsignedShort * 6) + 2;
        mVar.a(lVar3, i);
        return length + 1 + i;
    }

    private static DrmInitData ff(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            a.b bVar = list.get(i);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgZ) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.mhW.data;
                UUID ap = h.ap(bArr);
                if (ap == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(ap, MimeType.Video.MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static boolean JI(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgX || i == com.google.android.exoplayer2.extractor.c.a.mgW || i == com.google.android.exoplayer2.extractor.c.a.mgH || i == com.google.android.exoplayer2.extractor.c.a.mgF || i == com.google.android.exoplayer2.extractor.c.a.mgY || i == com.google.android.exoplayer2.extractor.c.a.mgB || i == com.google.android.exoplayer2.extractor.c.a.mgC || i == com.google.android.exoplayer2.extractor.c.a.mgT || i == com.google.android.exoplayer2.extractor.c.a.mgD || i == com.google.android.exoplayer2.extractor.c.a.mgE || i == com.google.android.exoplayer2.extractor.c.a.mgZ || i == com.google.android.exoplayer2.extractor.c.a.mhh || i == com.google.android.exoplayer2.extractor.c.a.mhi || i == com.google.android.exoplayer2.extractor.c.a.mhm || i == com.google.android.exoplayer2.extractor.c.a.mhl || i == com.google.android.exoplayer2.extractor.c.a.mhj || i == com.google.android.exoplayer2.extractor.c.a.mhk || i == com.google.android.exoplayer2.extractor.c.a.mgV || i == com.google.android.exoplayer2.extractor.c.a.mgS || i == com.google.android.exoplayer2.extractor.c.a.mhL;
    }

    private static boolean JJ(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgG || i == com.google.android.exoplayer2.extractor.c.a.mgI || i == com.google.android.exoplayer2.extractor.c.a.mgJ || i == com.google.android.exoplayer2.extractor.c.a.mgK || i == com.google.android.exoplayer2.extractor.c.a.mgL || i == com.google.android.exoplayer2.extractor.c.a.mgP || i == com.google.android.exoplayer2.extractor.c.a.mgQ || i == com.google.android.exoplayer2.extractor.c.a.mgR || i == com.google.android.exoplayer2.extractor.c.a.mgU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final long miV;
        public final int size;

        public a(long j, int i) {
            this.miV = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m mdY;
        public final l miW = new l();
        public j miX;
        public c miY;
        public int miZ;
        public int mja;
        public int mjb;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.mdY = mVar;
        }

        public void a(j jVar, c cVar) {
            this.miX = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.miY = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.mdY.h(jVar.lYL);
            reset();
        }

        public void reset() {
            this.miW.reset();
            this.miZ = 0;
            this.mjb = 0;
            this.mja = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JL = this.miX.JL(this.miW.mjU.mis);
            this.mdY.h(this.miX.lYL.a(drmInitData.Pd(JL != null ? JL.schemeType : null)));
        }
    }
}
