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
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int mkZ = v.QE(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] mla = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long mbx;
    private final com.google.android.exoplayer2.util.l mgD;
    private com.google.android.exoplayer2.extractor.g mgu;
    private int mgv;
    private int mhJ;
    private int mhK;
    private final j mlb;
    private final DrmInitData mlc;
    private final SparseArray<b> mld;
    private final com.google.android.exoplayer2.util.l mle;
    private final com.google.android.exoplayer2.util.l mlf;
    private final com.google.android.exoplayer2.util.l mlg;
    private final com.google.android.exoplayer2.util.l mlh;
    private final s mli;
    private final com.google.android.exoplayer2.util.l mlj;
    private final byte[] mlk;
    private final Stack<a.C0675a> mll;
    private final LinkedList<a> mlm;
    private int mln;
    private long mlo;
    private int mlp;
    private com.google.android.exoplayer2.util.l mlq;
    private long mlr;
    private int mls;
    private long mlt;
    private b mlu;
    private boolean mlv;
    private com.google.android.exoplayer2.extractor.m mlw;
    private com.google.android.exoplayer2.extractor.m[] mlx;
    private boolean mly;
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
        this.mli = sVar;
        this.mlb = jVar;
        this.mlc = drmInitData;
        this.mlj = new com.google.android.exoplayer2.util.l(16);
        this.mgD = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mIW);
        this.mle = new com.google.android.exoplayer2.util.l(5);
        this.mlf = new com.google.android.exoplayer2.util.l();
        this.mlg = new com.google.android.exoplayer2.util.l(1);
        this.mlh = new com.google.android.exoplayer2.util.l();
        this.mlk = new byte[16];
        this.mll = new Stack<>();
        this.mlm = new LinkedList<>();
        this.mld = new SparseArray<>();
        this.mbx = -9223372036854775807L;
        this.mlt = -9223372036854775807L;
        dvC();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mgu = gVar;
        if (this.mlb != null) {
            b bVar = new b(gVar.dL(0, this.mlb.type));
            bVar.a(this.mlb, new c(0, 0, 0, 0));
            this.mld.put(0, bVar);
            dvD();
            this.mgu.dvs();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.mld.size();
        for (int i = 0; i < size; i++) {
            this.mld.valueAt(i).reset();
        }
        this.mlm.clear();
        this.mls = 0;
        this.mll.clear();
        dvC();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mgv) {
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

    private void dvC() {
        this.mgv = 0;
        this.mlp = 0;
    }

    private boolean n(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.mlp == 0) {
            if (!fVar.d(this.mlj.data, 0, 8, true)) {
                return false;
            }
            this.mlp = 8;
            this.mlj.setPosition(0);
            this.mlo = this.mlj.readUnsignedInt();
            this.mln = this.mlj.readInt();
        }
        if (this.mlo == 1) {
            fVar.readFully(this.mlj.data, 8, 8);
            this.mlp += 8;
            this.mlo = this.mlj.dAe();
        } else if (this.mlo == 0) {
            long length = fVar.getLength();
            if (length == -1 && !this.mll.isEmpty()) {
                length = this.mll.peek().endPosition;
            }
            if (length != -1) {
                this.mlo = (length - fVar.getPosition()) + this.mlp;
            }
        }
        if (this.mlo < this.mlp) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        long position = fVar.getPosition() - this.mlp;
        if (this.mln == com.google.android.exoplayer2.extractor.c.a.mjv) {
            int size = this.mld.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.mld.valueAt(i).mlA;
                lVar.mmz = position;
                lVar.mmB = position;
                lVar.mmA = position;
            }
        }
        if (this.mln == com.google.android.exoplayer2.extractor.c.a.miS) {
            this.mlu = null;
            this.mlr = this.mlo + position;
            if (!this.mly) {
                this.mgu.a(new l.a(this.mbx));
                this.mly = true;
            }
            this.mgv = 2;
            return true;
        }
        if (JU(this.mln)) {
            long position2 = (fVar.getPosition() + this.mlo) - 8;
            this.mll.add(new a.C0675a(this.mln, position2));
            if (this.mlo == this.mlp) {
                fP(position2);
            } else {
                dvC();
            }
        } else if (JT(this.mln)) {
            if (this.mlp != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.mlo > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.mlq = new com.google.android.exoplayer2.util.l((int) this.mlo);
            System.arraycopy(this.mlj.data, 0, this.mlq.data, 0, 8);
            this.mgv = 1;
        } else if (this.mlo > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.mlq = null;
            this.mgv = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.mlo) - this.mlp;
        if (this.mlq != null) {
            fVar.readFully(this.mlq.data, 8, i);
            a(new a.b(this.mln, this.mlq), fVar.getPosition());
        } else {
            fVar.JB(i);
        }
        fP(fVar.getPosition());
    }

    private void fP(long j) throws ParserException {
        while (!this.mll.isEmpty() && this.mll.peek().endPosition == j) {
            c(this.mll.pop());
        }
        dvC();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.mll.isEmpty()) {
            this.mll.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mjl) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.mkC, j);
            this.mlt = ((Long) c.first).longValue();
            this.mgu.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.mly = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mkr) {
            q(bVar.mkC);
        }
    }

    private void c(a.C0675a c0675a) throws ParserException {
        if (c0675a.type == com.google.android.exoplayer2.extractor.c.a.mjm) {
            d(c0675a);
        } else if (c0675a.type == com.google.android.exoplayer2.extractor.c.a.mjv) {
            e(c0675a);
        } else if (!this.mll.isEmpty()) {
            this.mll.peek().a(c0675a);
        }
    }

    private void d(a.C0675a c0675a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.mlb == null, "Unexpected moov box.");
        DrmInitData fa = this.mlc != null ? this.mlc : fa(c0675a.mkA);
        a.C0675a JS = c0675a.JS(com.google.android.exoplayer2.extractor.c.a.mjx);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JS.mkA.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JS.mkA.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mjj) {
                Pair<Integer, c> r = r(bVar.mkC);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mjy) {
                j = s(bVar.mkC);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0675a.mkB.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0675a c0675a2 = c0675a.mkB.get(i3);
            if (c0675a2.type == com.google.android.exoplayer2.extractor.c.a.mjo) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0675a2, c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjn), j, fa, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.mld.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.mgu.dL(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.mld.put(jVar.id, bVar2);
                this.mbx = Math.max(this.mbx, jVar.mbx);
                i++;
            }
            dvD();
            this.mgu.dvs();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.mld.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.mld.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0675a c0675a) throws ParserException {
        a(c0675a, this.mld, this.flags, this.mlk);
        DrmInitData fa = this.mlc != null ? null : fa(c0675a.mkA);
        if (fa != null) {
            int size = this.mld.size();
            for (int i = 0; i < size; i++) {
                this.mld.valueAt(i).d(fa);
            }
        }
    }

    private void dvD() {
        if ((this.flags & 4) != 0 && this.mlw == null) {
            this.mlw = this.mgu.dL(this.mld.size(), 4);
            this.mlw.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.mlx == null) {
            com.google.android.exoplayer2.extractor.m dL = this.mgu.dL(this.mld.size() + 1, 3);
            dL.h(Format.a(null, "application/cea-608", 0, null));
            this.mlx = new com.google.android.exoplayer2.extractor.m[]{dL};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.mlw != null) {
            lVar.setPosition(12);
            lVar.dAf();
            lVar.dAf();
            long i = v.i(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dzR = lVar.dzR();
            this.mlw.a(lVar, dzR);
            if (this.mlt != -9223372036854775807L) {
                this.mlw.a(i + this.mlt, 1, dzR, 0, null);
                return;
            }
            this.mlm.addLast(new a(i, dzR));
            this.mls += dzR;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dAc() - 1, lVar.dAc(), lVar.dAc(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JO(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dAe();
    }

    private static void a(a.C0675a c0675a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0675a.mkB.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0675a c0675a2 = c0675a.mkB.get(i2);
            if (c0675a2.type == com.google.android.exoplayer2.extractor.c.a.mjw) {
                b(c0675a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0675a c0675a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mji).mkC, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mlA;
            long j = lVar.mmP;
            a2.reset();
            if (c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjh) != null && (i & 2) == 0) {
                j = t(c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjh).mkC);
            }
            a(c0675a, a2, j, i);
            k JW = a2.mlB.JW(lVar.mmy.mkW);
            a.b JR = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjN);
            if (JR != null) {
                a(JW, JR.mkC, lVar);
            }
            a.b JR2 = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjO);
            if (JR2 != null) {
                a(JR2.mkC, lVar);
            }
            a.b JR3 = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjS);
            if (JR3 != null) {
                b(JR3.mkC, lVar);
            }
            a.b JR4 = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjP);
            a.b JR5 = c0675a.JR(com.google.android.exoplayer2.extractor.c.a.mjQ);
            if (JR4 != null && JR5 != null) {
                a(JR4.mkC, JR5.mkC, JW != null ? JW.schemeType : null, lVar);
            }
            int size = c0675a.mkA.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0675a.mkA.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mjR) {
                    a(bVar.mkC, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0675a c0675a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0675a.mkA;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mjk) {
                com.google.android.exoplayer2.util.l lVar = bVar2.mkC;
                lVar.setPosition(12);
                int dAc = lVar.dAc();
                if (dAc > 0) {
                    i2 = dAc + i5;
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
        bVar.mlF = 0;
        bVar.mlE = 0;
        bVar.mlD = 0;
        bVar.mlA.dM(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mjk) {
                i7 = a(bVar, i8, j, i, bVar3.mkC, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mmw;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JP(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dAc = lVar.dAc();
        if (dAc != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dAc + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mmK;
            int i3 = 0;
            i = 0;
            while (i3 < dAc) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dAc) + 0;
            Arrays.fill(lVar2.mmK, 0, dAc, z);
        }
        lVar2.JX(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JP(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dAc = lVar.dAc();
        if (dAc != 1) {
            throw new ParserException("Unexpected saio entry count: " + dAc);
        }
        int JO = com.google.android.exoplayer2.extractor.c.a.JO(readInt);
        lVar2.mmB = (JO == 0 ? lVar.readUnsignedInt() : lVar.dAe()) + lVar2.mmB;
    }

    private static b a(com.google.android.exoplayer2.util.l lVar, SparseArray<b> sparseArray, int i) {
        lVar.setPosition(8);
        int JP = com.google.android.exoplayer2.extractor.c.a.JP(lVar.readInt());
        int readInt = lVar.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        b bVar = sparseArray.get(readInt);
        if (bVar == null) {
            return null;
        }
        if ((JP & 1) != 0) {
            long dAe = lVar.dAe();
            bVar.mlA.mmA = dAe;
            bVar.mlA.mmB = dAe;
        }
        c cVar = bVar.mlC;
        bVar.mlA.mmy = new c((JP & 2) != 0 ? lVar.dAc() - 1 : cVar.mkW, (JP & 8) != 0 ? lVar.dAc() : cVar.duration, (JP & 16) != 0 ? lVar.dAc() : cVar.size, (JP & 32) != 0 ? lVar.dAc() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JO(lVar.readInt()) == 1 ? lVar.dAe() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JP = com.google.android.exoplayer2.extractor.c.a.JP(lVar.readInt());
        j jVar = bVar.mlB;
        l lVar2 = bVar.mlA;
        c cVar = lVar2.mmy;
        lVar2.mmE[i] = lVar.dAc();
        lVar2.mmD[i] = lVar2.mmA;
        if ((JP & 1) != 0) {
            long[] jArr = lVar2.mmD;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JP & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dAc();
        }
        boolean z2 = (JP & 256) != 0;
        boolean z3 = (JP & 512) != 0;
        boolean z4 = (JP & 1024) != 0;
        boolean z5 = (JP & 2048) != 0;
        if (jVar.mms == null || jVar.mms.length != 1 || jVar.mms[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.i(jVar.mmt[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mmF;
        int[] iArr2 = lVar2.mmG;
        long[] jArr2 = lVar2.mmH;
        boolean[] zArr = lVar2.mmI;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mmE[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mmP;
        }
        long j4 = j;
        while (i3 < i5) {
            int dAc = z2 ? lVar.dAc() : cVar.duration;
            int dAc2 = z3 ? lVar.dAc() : cVar.size;
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
            iArr[i3] = dAc2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dAc;
            i3++;
        }
        lVar2.mmP = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.G(bArr, 0, 16);
        if (Arrays.equals(bArr, mla)) {
            a(lVar, 16, lVar2);
        }
    }

    private static void b(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        a(lVar, 0, lVar2);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, l lVar2) throws ParserException {
        lVar.setPosition(i + 8);
        int JP = com.google.android.exoplayer2.extractor.c.a.JP(lVar.readInt());
        if ((JP & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (JP & 2) != 0;
        int dAc = lVar.dAc();
        if (dAc != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dAc + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mmK, 0, dAc, z);
        lVar2.JX(lVar.dzR());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == mkZ) {
            if (com.google.android.exoplayer2.extractor.c.a.JO(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == mkZ) {
                int JO = com.google.android.exoplayer2.extractor.c.a.JO(readInt2);
                if (JO == 1) {
                    if (lVar2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (JO >= 2) {
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
                    lVar3.mmJ = true;
                    lVar3.mmL = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dAe;
        long j2;
        lVar.setPosition(8);
        int JO = com.google.android.exoplayer2.extractor.c.a.JO(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JO == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dAe = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dAe2 = lVar.dAe();
            dAe = lVar.dAe() + j;
            j2 = dAe2;
        }
        long i = v.i(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dAe;
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
        int size = this.mld.size();
        int i = 0;
        while (i < size) {
            l lVar = this.mld.valueAt(i).mlA;
            if (!lVar.mmO || lVar.mmB >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mmB;
                bVar = this.mld.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.mgv = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.JB(position);
        bVar2.mlA.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.mgv == 3) {
            if (this.mlu == null) {
                b f = f(this.mld);
                if (f == null) {
                    int position = (int) (this.mlr - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.JB(position);
                    dvC();
                    return false;
                }
                int position2 = (int) (f.mlA.mmD[f.mlF] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.JB(position2);
                this.mlu = f;
            }
            this.sampleSize = this.mlu.mlA.mmF[this.mlu.mlD];
            if (this.mlu.mlA.mmJ) {
                this.mhK = a(this.mlu);
                this.sampleSize += this.mhK;
            } else {
                this.mhK = 0;
            }
            if (this.mlu.mlB.mmr == 1) {
                this.sampleSize -= 8;
                fVar.JB(8);
            }
            this.mgv = 4;
            this.mhJ = 0;
        }
        l lVar = this.mlu.mlA;
        j jVar = this.mlu.mlB;
        com.google.android.exoplayer2.extractor.m mVar = this.mlu.mgC;
        int i2 = this.mlu.mlD;
        if (jVar.mgF != 0) {
            byte[] bArr = this.mle.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.mgF + 1;
            int i4 = 4 - jVar.mgF;
            while (this.mhK < this.sampleSize) {
                if (this.mhJ == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.mle.setPosition(0);
                    this.mhJ = this.mle.dAc() - 1;
                    this.mgD.setPosition(0);
                    mVar.a(this.mgD, 4);
                    mVar.a(this.mle, 1);
                    this.mlv = this.mlx != null && com.google.android.exoplayer2.util.j.a(jVar.mbs.sampleMimeType, bArr[4]);
                    this.mhK += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.mlv) {
                        this.mlf.reset(this.mhJ);
                        fVar.readFully(this.mlf.data, 0, this.mhJ);
                        mVar.a(this.mlf, this.mhJ);
                        int i5 = this.mhJ;
                        int F = com.google.android.exoplayer2.util.j.F(this.mlf.data, this.mlf.dzS());
                        this.mlf.setPosition("video/hevc".equals(jVar.mbs.sampleMimeType) ? 1 : 0);
                        this.mlf.setLimit(F);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JY(i2) * 1000, this.mlf, this.mlx);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mhJ, false);
                    }
                    this.mhK += a2;
                    this.mhJ -= a2;
                }
            }
        } else {
            while (this.mhK < this.sampleSize) {
                this.mhK = mVar.a(fVar, this.sampleSize - this.mhK, false) + this.mhK;
            }
        }
        long JY = lVar.JY(i2) * 1000;
        if (this.mli != null) {
            JY = this.mli.gK(JY);
        }
        int i6 = lVar.mmI[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mmJ) {
            i = 1073741824 | i6;
            aVar = (lVar.mmL != null ? lVar.mmL : jVar.JW(lVar.mmy.mkW)).mhS;
        } else {
            i = i6;
        }
        mVar.a(JY, i, this.sampleSize, 0, aVar);
        while (!this.mlm.isEmpty()) {
            a removeFirst = this.mlm.removeFirst();
            this.mls -= removeFirst.size;
            this.mlw.a(removeFirst.mlz + JY, 1, removeFirst.size, this.mls, null);
        }
        this.mlu.mlD++;
        this.mlu.mlE++;
        if (this.mlu.mlE == lVar.mmE[this.mlu.mlF]) {
            this.mlu.mlF++;
            this.mlu.mlE = 0;
            this.mlu = null;
        }
        this.mgv = 3;
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
            if (valueAt.mlF == valueAt.mlA.mmC) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mlA.mmD[valueAt.mlF];
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
        l lVar2 = bVar.mlA;
        k JW = lVar2.mmL != null ? lVar2.mmL : bVar.mlB.JW(lVar2.mmy.mkW);
        if (JW.mmw != 0) {
            lVar = lVar2.mmN;
            length = JW.mmw;
        } else {
            byte[] bArr = JW.mmx;
            this.mlh.I(bArr, bArr.length);
            lVar = this.mlh;
            length = bArr.length;
        }
        boolean z = lVar2.mmK[bVar.mlD];
        this.mlg.data[0] = (byte) ((z ? 128 : 0) | length);
        this.mlg.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.mgC;
        mVar.a(this.mlg, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mmN;
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
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mjF) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.mkC.data;
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

    private static boolean JT(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mjD || i == com.google.android.exoplayer2.extractor.c.a.mjC || i == com.google.android.exoplayer2.extractor.c.a.mjn || i == com.google.android.exoplayer2.extractor.c.a.mjl || i == com.google.android.exoplayer2.extractor.c.a.mjE || i == com.google.android.exoplayer2.extractor.c.a.mjh || i == com.google.android.exoplayer2.extractor.c.a.mji || i == com.google.android.exoplayer2.extractor.c.a.mjz || i == com.google.android.exoplayer2.extractor.c.a.mjj || i == com.google.android.exoplayer2.extractor.c.a.mjk || i == com.google.android.exoplayer2.extractor.c.a.mjF || i == com.google.android.exoplayer2.extractor.c.a.mjN || i == com.google.android.exoplayer2.extractor.c.a.mjO || i == com.google.android.exoplayer2.extractor.c.a.mjS || i == com.google.android.exoplayer2.extractor.c.a.mjR || i == com.google.android.exoplayer2.extractor.c.a.mjP || i == com.google.android.exoplayer2.extractor.c.a.mjQ || i == com.google.android.exoplayer2.extractor.c.a.mjB || i == com.google.android.exoplayer2.extractor.c.a.mjy || i == com.google.android.exoplayer2.extractor.c.a.mkr;
    }

    private static boolean JU(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mjm || i == com.google.android.exoplayer2.extractor.c.a.mjo || i == com.google.android.exoplayer2.extractor.c.a.mjp || i == com.google.android.exoplayer2.extractor.c.a.mjq || i == com.google.android.exoplayer2.extractor.c.a.mjr || i == com.google.android.exoplayer2.extractor.c.a.mjv || i == com.google.android.exoplayer2.extractor.c.a.mjw || i == com.google.android.exoplayer2.extractor.c.a.mjx || i == com.google.android.exoplayer2.extractor.c.a.mjA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long mlz;
        public final int size;

        public a(long j, int i) {
            this.mlz = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m mgC;
        public final l mlA = new l();
        public j mlB;
        public c mlC;
        public int mlD;
        public int mlE;
        public int mlF;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.mgC = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mlB = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mlC = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.mgC.h(jVar.mbs);
            reset();
        }

        public void reset() {
            this.mlA.reset();
            this.mlD = 0;
            this.mlF = 0;
            this.mlE = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JW = this.mlB.JW(this.mlA.mmy.mkW);
            this.mgC.h(this.mlB.mbs.a(drmInitData.Pq(JW != null ? JW.schemeType : null)));
        }
    }
}
