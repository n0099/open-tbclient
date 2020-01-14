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
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int miA = v.Qr(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] miB = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lYV;
    private com.google.android.exoplayer2.extractor.g mdV;
    private int mdW;
    private final com.google.android.exoplayer2.util.l mee;
    private int mfk;
    private int mfl;
    private final j miC;
    private final DrmInitData miD;
    private final SparseArray<b> miE;
    private final com.google.android.exoplayer2.util.l miF;
    private final com.google.android.exoplayer2.util.l miG;
    private final com.google.android.exoplayer2.util.l miH;
    private final com.google.android.exoplayer2.util.l miI;
    private final s miJ;
    private final com.google.android.exoplayer2.util.l miK;
    private final byte[] miL;
    private final Stack<a.C0666a> miM;
    private final LinkedList<a> miN;
    private int miO;
    private long miP;
    private int miQ;
    private com.google.android.exoplayer2.util.l miR;
    private long miS;
    private int miT;
    private long miU;
    private b miV;
    private boolean miW;
    private com.google.android.exoplayer2.extractor.m miX;
    private com.google.android.exoplayer2.extractor.m[] miY;
    private boolean miZ;
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
        this.miJ = sVar;
        this.miC = jVar;
        this.miD = drmInitData;
        this.miK = new com.google.android.exoplayer2.util.l(16);
        this.mee = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mGt);
        this.miF = new com.google.android.exoplayer2.util.l(5);
        this.miG = new com.google.android.exoplayer2.util.l();
        this.miH = new com.google.android.exoplayer2.util.l(1);
        this.miI = new com.google.android.exoplayer2.util.l();
        this.miL = new byte[16];
        this.miM = new Stack<>();
        this.miN = new LinkedList<>();
        this.miE = new SparseArray<>();
        this.lYV = -9223372036854775807L;
        this.miU = -9223372036854775807L;
        dtR();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mdV = gVar;
        if (this.miC != null) {
            b bVar = new b(gVar.dH(0, this.miC.type));
            bVar.a(this.miC, new c(0, 0, 0, 0));
            this.miE.put(0, bVar);
            dtS();
            this.mdV.dtH();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.miE.size();
        for (int i = 0; i < size; i++) {
            this.miE.valueAt(i).reset();
        }
        this.miN.clear();
        this.miT = 0;
        this.miM.clear();
        dtR();
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
        long position = fVar.getPosition() - this.miQ;
        if (this.miO == com.google.android.exoplayer2.extractor.c.a.mgU) {
            int size = this.miE.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.miE.valueAt(i).mjb;
                lVar.mka = position;
                lVar.mkc = position;
                lVar.mkb = position;
            }
        }
        if (this.miO == com.google.android.exoplayer2.extractor.c.a.mgr) {
            this.miV = null;
            this.miS = this.miP + position;
            if (!this.miZ) {
                this.mdV.a(new l.a(this.lYV));
                this.miZ = true;
            }
            this.mdW = 2;
            return true;
        }
        if (JJ(this.miO)) {
            long position2 = (fVar.getPosition() + this.miP) - 8;
            this.miM.add(new a.C0666a(this.miO, position2));
            if (this.miP == this.miQ) {
                fQ(position2);
            } else {
                dtR();
            }
        } else if (JI(this.miO)) {
            if (this.miQ != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.miP > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.miR = new com.google.android.exoplayer2.util.l((int) this.miP);
            System.arraycopy(this.miK.data, 0, this.miR.data, 0, 8);
            this.mdW = 1;
        } else if (this.miP > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.miR = null;
            this.mdW = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.miP) - this.miQ;
        if (this.miR != null) {
            fVar.readFully(this.miR.data, 8, i);
            a(new a.b(this.miO, this.miR), fVar.getPosition());
        } else {
            fVar.Jq(i);
        }
        fQ(fVar.getPosition());
    }

    private void fQ(long j) throws ParserException {
        while (!this.miM.isEmpty() && this.miM.peek().endPosition == j) {
            c(this.miM.pop());
        }
        dtR();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.miM.isEmpty()) {
            this.miM.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgK) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.mib, j);
            this.miU = ((Long) c.first).longValue();
            this.mdV.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.miZ = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhQ) {
            q(bVar.mib);
        }
    }

    private void c(a.C0666a c0666a) throws ParserException {
        if (c0666a.type == com.google.android.exoplayer2.extractor.c.a.mgL) {
            d(c0666a);
        } else if (c0666a.type == com.google.android.exoplayer2.extractor.c.a.mgU) {
            e(c0666a);
        } else if (!this.miM.isEmpty()) {
            this.miM.peek().a(c0666a);
        }
    }

    private void d(a.C0666a c0666a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.miC == null, "Unexpected moov box.");
        DrmInitData ff = this.miD != null ? this.miD : ff(c0666a.mhZ);
        a.C0666a JH = c0666a.JH(com.google.android.exoplayer2.extractor.c.a.mgW);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = JH.mhZ.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = JH.mhZ.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgI) {
                Pair<Integer, c> r = r(bVar.mib);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mgX) {
                j = s(bVar.mib);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0666a.mia.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0666a c0666a2 = c0666a.mia.get(i3);
            if (c0666a2.type == com.google.android.exoplayer2.extractor.c.a.mgN) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0666a2, c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgM), j, ff, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.miE.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.mdV.dH(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.miE.put(jVar.id, bVar2);
                this.lYV = Math.max(this.lYV, jVar.lYV);
                i++;
            }
            dtS();
            this.mdV.dtH();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.miE.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.miE.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0666a c0666a) throws ParserException {
        a(c0666a, this.miE, this.flags, this.miL);
        DrmInitData ff = this.miD != null ? null : ff(c0666a.mhZ);
        if (ff != null) {
            int size = this.miE.size();
            for (int i = 0; i < size; i++) {
                this.miE.valueAt(i).d(ff);
            }
        }
    }

    private void dtS() {
        if ((this.flags & 4) != 0 && this.miX == null) {
            this.miX = this.mdV.dH(this.miE.size(), 4);
            this.miX.h(Format.i(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.miY == null) {
            com.google.android.exoplayer2.extractor.m dH = this.mdV.dH(this.miE.size() + 1, 3);
            dH.h(Format.a(null, "application/cea-608", 0, null));
            this.miY = new com.google.android.exoplayer2.extractor.m[]{dH};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.miX != null) {
            lVar.setPosition(12);
            lVar.dyv();
            lVar.dyv();
            long h = v.h(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dyh = lVar.dyh();
            this.miX.a(lVar, dyh);
            if (this.miU != -9223372036854775807L) {
                this.miX.a(h + this.miU, 1, dyh, 0, null);
                return;
            }
            this.miN.addLast(new a(h, dyh));
            this.miT += dyh;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dys() - 1, lVar.dys(), lVar.dys(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dyu();
    }

    private static void a(a.C0666a c0666a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0666a.mia.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0666a c0666a2 = c0666a.mia.get(i2);
            if (c0666a2.type == com.google.android.exoplayer2.extractor.c.a.mgV) {
                b(c0666a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0666a c0666a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgH).mib, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mjb;
            long j = lVar.mkq;
            a2.reset();
            if (c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgG) != null && (i & 2) == 0) {
                j = t(c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgG).mib);
            }
            a(c0666a, a2, j, i);
            k JL = a2.mjc.JL(lVar.mjZ.mix);
            a.b JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhm);
            if (JG != null) {
                a(JL, JG.mib, lVar);
            }
            a.b JG2 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhn);
            if (JG2 != null) {
                a(JG2.mib, lVar);
            }
            a.b JG3 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhr);
            if (JG3 != null) {
                b(JG3.mib, lVar);
            }
            a.b JG4 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mho);
            a.b JG5 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhp);
            if (JG4 != null && JG5 != null) {
                a(JG4.mib, JG5.mib, JL != null ? JL.schemeType : null, lVar);
            }
            int size = c0666a.mhZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0666a.mhZ.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhq) {
                    a(bVar.mib, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0666a c0666a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0666a.mhZ;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mgJ) {
                com.google.android.exoplayer2.util.l lVar = bVar2.mib;
                lVar.setPosition(12);
                int dys = lVar.dys();
                if (dys > 0) {
                    i2 = dys + i5;
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
        bVar.mjg = 0;
        bVar.mjf = 0;
        bVar.mje = 0;
        bVar.mjb.dI(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mgJ) {
                i7 = a(bVar, i8, j, i, bVar3.mib, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mjX;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dys = lVar.dys();
        if (dys != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dys + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mkl;
            int i3 = 0;
            i = 0;
            while (i3 < dys) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dys) + 0;
            Arrays.fill(lVar2.mkl, 0, dys, z);
        }
        lVar2.JM(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.JE(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dys = lVar.dys();
        if (dys != 1) {
            throw new ParserException("Unexpected saio entry count: " + dys);
        }
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(readInt);
        lVar2.mkc = (JD == 0 ? lVar.readUnsignedInt() : lVar.dyu()) + lVar2.mkc;
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
            long dyu = lVar.dyu();
            bVar.mjb.mkb = dyu;
            bVar.mjb.mkc = dyu;
        }
        c cVar = bVar.mjd;
        bVar.mjb.mjZ = new c((JE & 2) != 0 ? lVar.dys() - 1 : cVar.mix, (JE & 8) != 0 ? lVar.dys() : cVar.duration, (JE & 16) != 0 ? lVar.dys() : cVar.size, (JE & 32) != 0 ? lVar.dys() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt()) == 1 ? lVar.dyu() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int JE = com.google.android.exoplayer2.extractor.c.a.JE(lVar.readInt());
        j jVar = bVar.mjc;
        l lVar2 = bVar.mjb;
        c cVar = lVar2.mjZ;
        lVar2.mkf[i] = lVar.dys();
        lVar2.mke[i] = lVar2.mkb;
        if ((JE & 1) != 0) {
            long[] jArr = lVar2.mke;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (JE & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dys();
        }
        boolean z2 = (JE & 256) != 0;
        boolean z3 = (JE & 512) != 0;
        boolean z4 = (JE & 1024) != 0;
        boolean z5 = (JE & 2048) != 0;
        if (jVar.mjT == null || jVar.mjT.length != 1 || jVar.mjT[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.h(jVar.mjU[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mkg;
        int[] iArr2 = lVar2.mkh;
        long[] jArr2 = lVar2.mki;
        boolean[] zArr = lVar2.mkj;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mkf[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mkq;
        }
        long j4 = j;
        while (i3 < i5) {
            int dys = z2 ? lVar.dys() : cVar.duration;
            int dys2 = z3 ? lVar.dys() : cVar.size;
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
            iArr[i3] = dys2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dys;
            i3++;
        }
        lVar2.mkq = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.C(bArr, 0, 16);
        if (Arrays.equals(bArr, miB)) {
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
        int dys = lVar.dys();
        if (dys != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dys + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mkl, 0, dys, z);
        lVar2.JM(lVar.dyh());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == miA) {
            if (com.google.android.exoplayer2.extractor.c.a.JD(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == miA) {
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
                    lVar3.mkk = true;
                    lVar3.mkm = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dyu;
        long j2;
        lVar.setPosition(8);
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (JD == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dyu = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dyu2 = lVar.dyu();
            dyu = lVar.dyu() + j;
            j2 = dyu2;
        }
        long h = v.h(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dyu;
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
        int size = this.miE.size();
        int i = 0;
        while (i < size) {
            l lVar = this.miE.valueAt(i).mjb;
            if (!lVar.mkp || lVar.mkc >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mkc;
                bVar = this.miE.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.mdW = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jq(position);
        bVar2.mjb.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.mdW == 3) {
            if (this.miV == null) {
                b f = f(this.miE);
                if (f == null) {
                    int position = (int) (this.miS - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jq(position);
                    dtR();
                    return false;
                }
                int position2 = (int) (f.mjb.mke[f.mjg] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jq(position2);
                this.miV = f;
            }
            this.sampleSize = this.miV.mjb.mkg[this.miV.mje];
            if (this.miV.mjb.mkk) {
                this.mfl = a(this.miV);
                this.sampleSize += this.mfl;
            } else {
                this.mfl = 0;
            }
            if (this.miV.mjc.mjS == 1) {
                this.sampleSize -= 8;
                fVar.Jq(8);
            }
            this.mdW = 4;
            this.mfk = 0;
        }
        l lVar = this.miV.mjb;
        j jVar = this.miV.mjc;
        com.google.android.exoplayer2.extractor.m mVar = this.miV.med;
        int i2 = this.miV.mje;
        if (jVar.meg != 0) {
            byte[] bArr = this.miF.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.meg + 1;
            int i4 = 4 - jVar.meg;
            while (this.mfl < this.sampleSize) {
                if (this.mfk == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.miF.setPosition(0);
                    this.mfk = this.miF.dys() - 1;
                    this.mee.setPosition(0);
                    mVar.a(this.mee, 4);
                    mVar.a(this.miF, 1);
                    this.miW = this.miY != null && com.google.android.exoplayer2.util.j.a(jVar.lYQ.sampleMimeType, bArr[4]);
                    this.mfl += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.miW) {
                        this.miG.reset(this.mfk);
                        fVar.readFully(this.miG.data, 0, this.mfk);
                        mVar.a(this.miG, this.mfk);
                        int i5 = this.mfk;
                        int D = com.google.android.exoplayer2.util.j.D(this.miG.data, this.miG.dyi());
                        this.miG.setPosition("video/hevc".equals(jVar.lYQ.sampleMimeType) ? 1 : 0);
                        this.miG.setLimit(D);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JN(i2) * 1000, this.miG, this.miY);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mfk, false);
                    }
                    this.mfl += a2;
                    this.mfk -= a2;
                }
            }
        } else {
            while (this.mfl < this.sampleSize) {
                this.mfl = mVar.a(fVar, this.sampleSize - this.mfl, false) + this.mfl;
            }
        }
        long JN = lVar.JN(i2) * 1000;
        if (this.miJ != null) {
            JN = this.miJ.gL(JN);
        }
        int i6 = lVar.mkj[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mkk) {
            i = 1073741824 | i6;
            aVar = (lVar.mkm != null ? lVar.mkm : jVar.JL(lVar.mjZ.mix)).mft;
        } else {
            i = i6;
        }
        mVar.a(JN, i, this.sampleSize, 0, aVar);
        while (!this.miN.isEmpty()) {
            a removeFirst = this.miN.removeFirst();
            this.miT -= removeFirst.size;
            this.miX.a(removeFirst.mja + JN, 1, removeFirst.size, this.miT, null);
        }
        this.miV.mje++;
        this.miV.mjf++;
        if (this.miV.mjf == lVar.mkf[this.miV.mjg]) {
            this.miV.mjg++;
            this.miV.mjf = 0;
            this.miV = null;
        }
        this.mdW = 3;
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
            if (valueAt.mjg == valueAt.mjb.mkd) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mjb.mke[valueAt.mjg];
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
        l lVar2 = bVar.mjb;
        k JL = lVar2.mkm != null ? lVar2.mkm : bVar.mjc.JL(lVar2.mjZ.mix);
        if (JL.mjX != 0) {
            lVar = lVar2.mko;
            length = JL.mjX;
        } else {
            byte[] bArr = JL.mjY;
            this.miI.G(bArr, bArr.length);
            lVar = this.miI;
            length = bArr.length;
        }
        boolean z = lVar2.mkl[bVar.mje];
        this.miH.data[0] = (byte) ((z ? 128 : 0) | length);
        this.miH.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.med;
        mVar.a(this.miH, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mko;
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
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mhe) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.mib.data;
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
        return i == com.google.android.exoplayer2.extractor.c.a.mhc || i == com.google.android.exoplayer2.extractor.c.a.mhb || i == com.google.android.exoplayer2.extractor.c.a.mgM || i == com.google.android.exoplayer2.extractor.c.a.mgK || i == com.google.android.exoplayer2.extractor.c.a.mhd || i == com.google.android.exoplayer2.extractor.c.a.mgG || i == com.google.android.exoplayer2.extractor.c.a.mgH || i == com.google.android.exoplayer2.extractor.c.a.mgY || i == com.google.android.exoplayer2.extractor.c.a.mgI || i == com.google.android.exoplayer2.extractor.c.a.mgJ || i == com.google.android.exoplayer2.extractor.c.a.mhe || i == com.google.android.exoplayer2.extractor.c.a.mhm || i == com.google.android.exoplayer2.extractor.c.a.mhn || i == com.google.android.exoplayer2.extractor.c.a.mhr || i == com.google.android.exoplayer2.extractor.c.a.mhq || i == com.google.android.exoplayer2.extractor.c.a.mho || i == com.google.android.exoplayer2.extractor.c.a.mhp || i == com.google.android.exoplayer2.extractor.c.a.mha || i == com.google.android.exoplayer2.extractor.c.a.mgX || i == com.google.android.exoplayer2.extractor.c.a.mhQ;
    }

    private static boolean JJ(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mgL || i == com.google.android.exoplayer2.extractor.c.a.mgN || i == com.google.android.exoplayer2.extractor.c.a.mgO || i == com.google.android.exoplayer2.extractor.c.a.mgP || i == com.google.android.exoplayer2.extractor.c.a.mgQ || i == com.google.android.exoplayer2.extractor.c.a.mgU || i == com.google.android.exoplayer2.extractor.c.a.mgV || i == com.google.android.exoplayer2.extractor.c.a.mgW || i == com.google.android.exoplayer2.extractor.c.a.mgZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final long mja;
        public final int size;

        public a(long j, int i) {
            this.mja = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m med;
        public final l mjb = new l();
        public j mjc;
        public c mjd;
        public int mje;
        public int mjf;
        public int mjg;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.med = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mjc = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mjd = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.med.h(jVar.lYQ);
            reset();
        }

        public void reset() {
            this.mjb.reset();
            this.mje = 0;
            this.mjg = 0;
            this.mjf = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JL = this.mjc.JL(this.mjb.mjZ.mix);
            this.med.h(this.mjc.lYQ.a(drmInitData.Pd(JL != null ? JL.schemeType : null)));
        }
    }
}
