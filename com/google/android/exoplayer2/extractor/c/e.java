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
    public static final com.google.android.exoplayer2.extractor.h mex = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duT() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int mji = v.QE(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] mjj = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lZD;
    private com.google.android.exoplayer2.extractor.g meD;
    private int meE;
    private final com.google.android.exoplayer2.util.l meM;
    private int mfS;
    private int mfT;
    private long mjA;
    private int mjB;
    private long mjC;
    private b mjD;
    private boolean mjE;
    private com.google.android.exoplayer2.extractor.m mjF;
    private com.google.android.exoplayer2.extractor.m[] mjG;
    private boolean mjH;
    private final j mjk;
    private final DrmInitData mjl;
    private final SparseArray<b> mjm;
    private final com.google.android.exoplayer2.util.l mjn;
    private final com.google.android.exoplayer2.util.l mjo;
    private final com.google.android.exoplayer2.util.l mjp;
    private final com.google.android.exoplayer2.util.l mjq;
    private final s mjr;
    private final com.google.android.exoplayer2.util.l mjs;
    private final byte[] mjt;
    private final Stack<a.C0674a> mju;
    private final LinkedList<a> mjv;
    private int mjw;
    private long mjx;
    private int mjy;
    private com.google.android.exoplayer2.util.l mjz;
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
        this.mjr = sVar;
        this.mjk = jVar;
        this.mjl = drmInitData;
        this.mjs = new com.google.android.exoplayer2.util.l(16);
        this.meM = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mHb);
        this.mjn = new com.google.android.exoplayer2.util.l(5);
        this.mjo = new com.google.android.exoplayer2.util.l();
        this.mjp = new com.google.android.exoplayer2.util.l(1);
        this.mjq = new com.google.android.exoplayer2.util.l();
        this.mjt = new byte[16];
        this.mju = new Stack<>();
        this.mjv = new LinkedList<>();
        this.mjm = new SparseArray<>();
        this.lZD = -9223372036854775807L;
        this.mjC = -9223372036854775807L;
        dve();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.meD = gVar;
        if (this.mjk != null) {
            b bVar = new b(gVar.dK(0, this.mjk.type));
            bVar.a(this.mjk, new c(0, 0, 0, 0));
            this.mjm.put(0, bVar);
            dvf();
            this.meD.duU();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.mjm.size();
        for (int i = 0; i < size; i++) {
            this.mjm.valueAt(i).reset();
        }
        this.mjv.clear();
        this.mjB = 0;
        this.mju.clear();
        dve();
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
        long position = fVar.getPosition() - this.mjy;
        if (this.mjw == com.google.android.exoplayer2.extractor.c.a.mhC) {
            int size = this.mjm.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.mjm.valueAt(i).mjJ;
                lVar.mkI = position;
                lVar.mkK = position;
                lVar.mkJ = position;
            }
        }
        if (this.mjw == com.google.android.exoplayer2.extractor.c.a.mgZ) {
            this.mjD = null;
            this.mjA = this.mjx + position;
            if (!this.mjH) {
                this.meD.a(new l.a(this.lZD));
                this.mjH = true;
            }
            this.meE = 2;
            return true;
        }
        if (JO(this.mjw)) {
            long position2 = (fVar.getPosition() + this.mjx) - 8;
            this.mju.add(new a.C0674a(this.mjw, position2));
            if (this.mjx == this.mjy) {
                fO(position2);
            } else {
                dve();
            }
        } else if (JN(this.mjw)) {
            if (this.mjy != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.mjx > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.mjz = new com.google.android.exoplayer2.util.l((int) this.mjx);
            System.arraycopy(this.mjs.data, 0, this.mjz.data, 0, 8);
            this.meE = 1;
        } else if (this.mjx > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.mjz = null;
            this.meE = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.mjx) - this.mjy;
        if (this.mjz != null) {
            fVar.readFully(this.mjz.data, 8, i);
            a(new a.b(this.mjw, this.mjz), fVar.getPosition());
        } else {
            fVar.Jv(i);
        }
        fO(fVar.getPosition());
    }

    private void fO(long j) throws ParserException {
        while (!this.mju.isEmpty() && this.mju.peek().endPosition == j) {
            c(this.mju.pop());
        }
        dve();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.mju.isEmpty()) {
            this.mju.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhs) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.miL, j);
            this.mjC = ((Long) c.first).longValue();
            this.meD.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.mjH = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.miA) {
            q(bVar.miL);
        }
    }

    private void c(a.C0674a c0674a) throws ParserException {
        if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mht) {
            d(c0674a);
        } else if (c0674a.type == com.google.android.exoplayer2.extractor.c.a.mhC) {
            e(c0674a);
        } else if (!this.mju.isEmpty()) {
            this.mju.peek().a(c0674a);
        }
    }

    private void d(a.C0674a c0674a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.mjk == null, "Unexpected moov box.");
        DrmInitData fa = this.mjl != null ? this.mjl : fa(c0674a.miJ);
        a.C0674a JM = c0674a.JM(com.google.android.exoplayer2.extractor.c.a.mhE);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JM.miJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JM.miJ.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhq) {
                Pair<Integer, c> r = r(bVar.miL);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhF) {
                j = s(bVar.miL);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0674a.miK.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0674a c0674a2 = c0674a.miK.get(i3);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mhv) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0674a2, c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhu), j, fa, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.mjm.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.meD.dK(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.mjm.put(jVar.id, bVar2);
                this.lZD = Math.max(this.lZD, jVar.lZD);
                i++;
            }
            dvf();
            this.meD.duU();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.mjm.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.mjm.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0674a c0674a) throws ParserException {
        a(c0674a, this.mjm, this.flags, this.mjt);
        DrmInitData fa = this.mjl != null ? null : fa(c0674a.miJ);
        if (fa != null) {
            int size = this.mjm.size();
            for (int i = 0; i < size; i++) {
                this.mjm.valueAt(i).d(fa);
            }
        }
    }

    private void dvf() {
        if ((this.flags & 4) != 0 && this.mjF == null) {
            this.mjF = this.meD.dK(this.mjm.size(), 4);
            this.mjF.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.mjG == null) {
            com.google.android.exoplayer2.extractor.m dK = this.meD.dK(this.mjm.size() + 1, 3);
            dK.h(Format.a(null, "application/cea-608", 0, null));
            this.mjG = new com.google.android.exoplayer2.extractor.m[]{dK};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.mjF != null) {
            lVar.setPosition(12);
            lVar.dzH();
            lVar.dzH();
            long i = v.i(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dzt = lVar.dzt();
            this.mjF.a(lVar, dzt);
            if (this.mjC != -9223372036854775807L) {
                this.mjF.a(i + this.mjC, 1, dzt, 0, null);
                return;
            }
            this.mjv.addLast(new a(i, dzt));
            this.mjB += dzt;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dzE() - 1, lVar.dzE(), lVar.dzE(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dzG();
    }

    private static void a(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0674a.miK.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0674a c0674a2 = c0674a.miK.get(i2);
            if (c0674a2.type == com.google.android.exoplayer2.extractor.c.a.mhD) {
                b(c0674a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0674a c0674a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhp).miL, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mjJ;
            long j = lVar.mkY;
            a2.reset();
            if (c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mho) != null && (i & 2) == 0) {
                j = t(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mho).miL);
            }
            a(c0674a, a2, j, i);
            k JQ = a2.mjK.JQ(lVar.mkH.mjf);
            a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhU);
            if (JL != null) {
                a(JQ, JL.miL, lVar);
            }
            a.b JL2 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhV);
            if (JL2 != null) {
                a(JL2.miL, lVar);
            }
            a.b JL3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhZ);
            if (JL3 != null) {
                b(JL3.miL, lVar);
            }
            a.b JL4 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhW);
            a.b JL5 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhX);
            if (JL4 != null && JL5 != null) {
                a(JL4.miL, JL5.miL, JQ != null ? JQ.schemeType : null, lVar);
            }
            int size = c0674a.miJ.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0674a.miJ.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhY) {
                    a(bVar.miL, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0674a c0674a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0674a.miJ;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mhr) {
                com.google.android.exoplayer2.util.l lVar = bVar2.miL;
                lVar.setPosition(12);
                int dzE = lVar.dzE();
                if (dzE > 0) {
                    i2 = dzE + i5;
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
        bVar.mjO = 0;
        bVar.mjN = 0;
        bVar.mjM = 0;
        bVar.mjJ.dL(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mhr) {
                i7 = a(bVar, i8, j, i, bVar3.miL, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mkF;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dzE = lVar.dzE();
        if (dzE != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzE + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mkT;
            int i3 = 0;
            i = 0;
            while (i3 < dzE) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dzE) + 0;
            Arrays.fill(lVar2.mkT, 0, dzE, z);
        }
        lVar2.JR(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JJ(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dzE = lVar.dzE();
        if (dzE != 1) {
            throw new ParserException("Unexpected saio entry count: " + dzE);
        }
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(readInt);
        lVar2.mkK = (JI == 0 ? lVar.readUnsignedInt() : lVar.dzG()) + lVar2.mkK;
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
            long dzG = lVar.dzG();
            bVar.mjJ.mkJ = dzG;
            bVar.mjJ.mkK = dzG;
        }
        c cVar = bVar.mjL;
        bVar.mjJ.mkH = new c((JJ & 2) != 0 ? lVar.dzE() - 1 : cVar.mjf, (JJ & 8) != 0 ? lVar.dzE() : cVar.duration, (JJ & 16) != 0 ? lVar.dzE() : cVar.size, (JJ & 32) != 0 ? lVar.dzE() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) == 1 ? lVar.dzG() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JJ = com.google.android.exoplayer2.extractor.c.a.JJ(lVar.readInt());
        j jVar = bVar.mjK;
        l lVar2 = bVar.mjJ;
        c cVar = lVar2.mkH;
        lVar2.mkN[i] = lVar.dzE();
        lVar2.mkM[i] = lVar2.mkJ;
        if ((JJ & 1) != 0) {
            long[] jArr = lVar2.mkM;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JJ & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dzE();
        }
        boolean z2 = (JJ & 256) != 0;
        boolean z3 = (JJ & 512) != 0;
        boolean z4 = (JJ & 1024) != 0;
        boolean z5 = (JJ & 2048) != 0;
        if (jVar.mkB == null || jVar.mkB.length != 1 || jVar.mkB[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.i(jVar.mkC[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mkO;
        int[] iArr2 = lVar2.mkP;
        long[] jArr2 = lVar2.mkQ;
        boolean[] zArr = lVar2.mkR;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mkN[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mkY;
        }
        long j4 = j;
        while (i3 < i5) {
            int dzE = z2 ? lVar.dzE() : cVar.duration;
            int dzE2 = z3 ? lVar.dzE() : cVar.size;
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
            iArr[i3] = dzE2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dzE;
            i3++;
        }
        lVar2.mkY = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.G(bArr, 0, 16);
        if (Arrays.equals(bArr, mjj)) {
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
        int dzE = lVar.dzE();
        if (dzE != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dzE + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mkT, 0, dzE, z);
        lVar2.JR(lVar.dzt());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == mji) {
            if (com.google.android.exoplayer2.extractor.c.a.JI(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == mji) {
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
                    lVar3.mkS = true;
                    lVar3.mkU = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dzG;
        long j2;
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JI == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dzG = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dzG2 = lVar.dzG();
            dzG = lVar.dzG() + j;
            j2 = dzG2;
        }
        long i = v.i(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dzG;
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
        int size = this.mjm.size();
        int i = 0;
        while (i < size) {
            l lVar = this.mjm.valueAt(i).mjJ;
            if (!lVar.mkX || lVar.mkK >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mkK;
                bVar = this.mjm.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.meE = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jv(position);
        bVar2.mjJ.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.meE == 3) {
            if (this.mjD == null) {
                b f = f(this.mjm);
                if (f == null) {
                    int position = (int) (this.mjA - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jv(position);
                    dve();
                    return false;
                }
                int position2 = (int) (f.mjJ.mkM[f.mjO] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jv(position2);
                this.mjD = f;
            }
            this.sampleSize = this.mjD.mjJ.mkO[this.mjD.mjM];
            if (this.mjD.mjJ.mkS) {
                this.mfT = a(this.mjD);
                this.sampleSize += this.mfT;
            } else {
                this.mfT = 0;
            }
            if (this.mjD.mjK.mkA == 1) {
                this.sampleSize -= 8;
                fVar.Jv(8);
            }
            this.meE = 4;
            this.mfS = 0;
        }
        l lVar = this.mjD.mjJ;
        j jVar = this.mjD.mjK;
        com.google.android.exoplayer2.extractor.m mVar = this.mjD.meL;
        int i2 = this.mjD.mjM;
        if (jVar.meO != 0) {
            byte[] bArr = this.mjn.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.meO + 1;
            int i4 = 4 - jVar.meO;
            while (this.mfT < this.sampleSize) {
                if (this.mfS == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.mjn.setPosition(0);
                    this.mfS = this.mjn.dzE() - 1;
                    this.meM.setPosition(0);
                    mVar.a(this.meM, 4);
                    mVar.a(this.mjn, 1);
                    this.mjE = this.mjG != null && com.google.android.exoplayer2.util.j.a(jVar.lZy.sampleMimeType, bArr[4]);
                    this.mfT += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.mjE) {
                        this.mjo.reset(this.mfS);
                        fVar.readFully(this.mjo.data, 0, this.mfS);
                        mVar.a(this.mjo, this.mfS);
                        int i5 = this.mfS;
                        int F = com.google.android.exoplayer2.util.j.F(this.mjo.data, this.mjo.dzu());
                        this.mjo.setPosition("video/hevc".equals(jVar.lZy.sampleMimeType) ? 1 : 0);
                        this.mjo.setLimit(F);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JS(i2) * 1000, this.mjo, this.mjG);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mfS, false);
                    }
                    this.mfT += a2;
                    this.mfS -= a2;
                }
            }
        } else {
            while (this.mfT < this.sampleSize) {
                this.mfT = mVar.a(fVar, this.sampleSize - this.mfT, false) + this.mfT;
            }
        }
        long JS = lVar.JS(i2) * 1000;
        if (this.mjr != null) {
            JS = this.mjr.gJ(JS);
        }
        int i6 = lVar.mkR[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mkS) {
            i = 1073741824 | i6;
            aVar = (lVar.mkU != null ? lVar.mkU : jVar.JQ(lVar.mkH.mjf)).mgb;
        } else {
            i = i6;
        }
        mVar.a(JS, i, this.sampleSize, 0, aVar);
        while (!this.mjv.isEmpty()) {
            a removeFirst = this.mjv.removeFirst();
            this.mjB -= removeFirst.size;
            this.mjF.a(removeFirst.mjI + JS, 1, removeFirst.size, this.mjB, null);
        }
        this.mjD.mjM++;
        this.mjD.mjN++;
        if (this.mjD.mjN == lVar.mkN[this.mjD.mjO]) {
            this.mjD.mjO++;
            this.mjD.mjN = 0;
            this.mjD = null;
        }
        this.meE = 3;
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
            if (valueAt.mjO == valueAt.mjJ.mkL) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mjJ.mkM[valueAt.mjO];
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
        l lVar2 = bVar.mjJ;
        k JQ = lVar2.mkU != null ? lVar2.mkU : bVar.mjK.JQ(lVar2.mkH.mjf);
        if (JQ.mkF != 0) {
            lVar = lVar2.mkW;
            length = JQ.mkF;
        } else {
            byte[] bArr = JQ.mkG;
            this.mjq.I(bArr, bArr.length);
            lVar = this.mjq;
            length = bArr.length;
        }
        boolean z = lVar2.mkT[bVar.mjM];
        this.mjp.data[0] = (byte) ((z ? 128 : 0) | length);
        this.mjp.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.meL;
        mVar.a(this.mjp, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mkW;
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
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhM) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.miL.data;
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
        return i == com.google.android.exoplayer2.extractor.c.a.mhK || i == com.google.android.exoplayer2.extractor.c.a.mhJ || i == com.google.android.exoplayer2.extractor.c.a.mhu || i == com.google.android.exoplayer2.extractor.c.a.mhs || i == com.google.android.exoplayer2.extractor.c.a.mhL || i == com.google.android.exoplayer2.extractor.c.a.mho || i == com.google.android.exoplayer2.extractor.c.a.mhp || i == com.google.android.exoplayer2.extractor.c.a.mhG || i == com.google.android.exoplayer2.extractor.c.a.mhq || i == com.google.android.exoplayer2.extractor.c.a.mhr || i == com.google.android.exoplayer2.extractor.c.a.mhM || i == com.google.android.exoplayer2.extractor.c.a.mhU || i == com.google.android.exoplayer2.extractor.c.a.mhV || i == com.google.android.exoplayer2.extractor.c.a.mhZ || i == com.google.android.exoplayer2.extractor.c.a.mhY || i == com.google.android.exoplayer2.extractor.c.a.mhW || i == com.google.android.exoplayer2.extractor.c.a.mhX || i == com.google.android.exoplayer2.extractor.c.a.mhI || i == com.google.android.exoplayer2.extractor.c.a.mhF || i == com.google.android.exoplayer2.extractor.c.a.miA;
    }

    private static boolean JO(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mht || i == com.google.android.exoplayer2.extractor.c.a.mhv || i == com.google.android.exoplayer2.extractor.c.a.mhw || i == com.google.android.exoplayer2.extractor.c.a.mhx || i == com.google.android.exoplayer2.extractor.c.a.mhy || i == com.google.android.exoplayer2.extractor.c.a.mhC || i == com.google.android.exoplayer2.extractor.c.a.mhD || i == com.google.android.exoplayer2.extractor.c.a.mhE || i == com.google.android.exoplayer2.extractor.c.a.mhH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long mjI;
        public final int size;

        public a(long j, int i) {
            this.mjI = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m meL;
        public final l mjJ = new l();
        public j mjK;
        public c mjL;
        public int mjM;
        public int mjN;
        public int mjO;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.meL = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mjK = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mjL = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.meL.h(jVar.lZy);
            reset();
        }

        public void reset() {
            this.mjJ.reset();
            this.mjM = 0;
            this.mjO = 0;
            this.mjN = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JQ = this.mjK.JQ(this.mjJ.mkH.mjf);
            this.meL.h(this.mjK.lZy.a(drmInitData.Pq(JQ != null ? JQ.schemeType : null)));
        }
    }
}
