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
/* loaded from: classes4.dex */
public final class e implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.c.e.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new e()};
        }
    };
    private static final int meE = v.Qg(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] meF = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long lUZ;
    private com.google.android.exoplayer2.extractor.g lZY;
    private int lZZ;
    private final com.google.android.exoplayer2.util.l mai;
    private int mbq;
    private int mbr;
    private final j meG;
    private final DrmInitData meH;
    private final SparseArray<b> meI;
    private final com.google.android.exoplayer2.util.l meJ;
    private final com.google.android.exoplayer2.util.l meK;
    private final com.google.android.exoplayer2.util.l meL;
    private final com.google.android.exoplayer2.util.l meM;
    private final s meN;
    private final com.google.android.exoplayer2.util.l meO;
    private final byte[] meP;
    private final Stack<a.C0660a> meQ;
    private final LinkedList<a> meR;
    private int meS;
    private long meT;
    private int meU;
    private com.google.android.exoplayer2.util.l meV;
    private long meW;
    private int meX;
    private long meY;
    private b meZ;
    private boolean mfa;
    private com.google.android.exoplayer2.extractor.m mfb;
    private com.google.android.exoplayer2.extractor.m[] mfc;
    private boolean mfd;
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
        this.meN = sVar;
        this.meG = jVar;
        this.meH = drmInitData;
        this.meO = new com.google.android.exoplayer2.util.l(16);
        this.mai = new com.google.android.exoplayer2.util.l(com.google.android.exoplayer2.util.j.mCx);
        this.meJ = new com.google.android.exoplayer2.util.l(5);
        this.meK = new com.google.android.exoplayer2.util.l();
        this.meL = new com.google.android.exoplayer2.util.l(1);
        this.meM = new com.google.android.exoplayer2.util.l();
        this.meP = new byte[16];
        this.meQ = new Stack<>();
        this.meR = new LinkedList<>();
        this.meI = new SparseArray<>();
        this.lUZ = -9223372036854775807L;
        this.meY = -9223372036854775807L;
        dsD();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return i.r(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.lZY = gVar;
        if (this.meG != null) {
            b bVar = new b(gVar.dJ(0, this.meG.type));
            bVar.a(this.meG, new c(0, 0, 0, 0));
            this.meI.put(0, bVar);
            dsE();
            this.lZY.dst();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.meI.size();
        for (int i = 0; i < size; i++) {
            this.meI.valueAt(i).reset();
        }
        this.meR.clear();
        this.meX = 0;
        this.meQ.clear();
        dsD();
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
        long position = fVar.getPosition() - this.meU;
        if (this.meS == com.google.android.exoplayer2.extractor.c.a.mda) {
            int size = this.meI.size();
            for (int i = 0; i < size; i++) {
                l lVar = this.meI.valueAt(i).mff;
                lVar.mge = position;
                lVar.mgg = position;
                lVar.mgf = position;
            }
        }
        if (this.meS == com.google.android.exoplayer2.extractor.c.a.mcx) {
            this.meZ = null;
            this.meW = this.meT + position;
            if (!this.mfd) {
                this.lZY.a(new l.a(this.lUZ));
                this.mfd = true;
            }
            this.lZZ = 2;
            return true;
        }
        if (JA(this.meS)) {
            long position2 = (fVar.getPosition() + this.meT) - 8;
            this.meQ.add(new a.C0660a(this.meS, position2));
            if (this.meT == this.meU) {
                fL(position2);
            } else {
                dsD();
            }
        } else if (Jz(this.meS)) {
            if (this.meU != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.meT > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.meV = new com.google.android.exoplayer2.util.l((int) this.meT);
            System.arraycopy(this.meO.data, 0, this.meV.data, 0, 8);
            this.lZZ = 1;
        } else if (this.meT > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.meV = null;
            this.lZZ = 1;
        }
        return true;
    }

    private void o(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i = ((int) this.meT) - this.meU;
        if (this.meV != null) {
            fVar.readFully(this.meV.data, 8, i);
            a(new a.b(this.meS, this.meV), fVar.getPosition());
        } else {
            fVar.Jh(i);
        }
        fL(fVar.getPosition());
    }

    private void fL(long j) throws ParserException {
        while (!this.meQ.isEmpty() && this.meQ.peek().endPosition == j) {
            c(this.meQ.pop());
        }
        dsD();
    }

    private void a(a.b bVar, long j) throws ParserException {
        if (!this.meQ.isEmpty()) {
            this.meQ.peek().a(bVar);
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mcQ) {
            Pair<Long, com.google.android.exoplayer2.extractor.a> c = c(bVar.meh, j);
            this.meY = ((Long) c.first).longValue();
            this.lZY.a((com.google.android.exoplayer2.extractor.l) c.second);
            this.mfd = true;
        } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mdW) {
            q(bVar.meh);
        }
    }

    private void c(a.C0660a c0660a) throws ParserException {
        if (c0660a.type == com.google.android.exoplayer2.extractor.c.a.mcR) {
            d(c0660a);
        } else if (c0660a.type == com.google.android.exoplayer2.extractor.c.a.mda) {
            e(c0660a);
        } else if (!this.meQ.isEmpty()) {
            this.meQ.peek().a(c0660a);
        }
    }

    private void d(a.C0660a c0660a) throws ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.a.d(this.meG == null, "Unexpected moov box.");
        DrmInitData ff = this.meH != null ? this.meH : ff(c0660a.mef);
        a.C0660a Jy = c0660a.Jy(com.google.android.exoplayer2.extractor.c.a.mdc);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = Jy.mef.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = Jy.mef.get(i2);
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mcO) {
                Pair<Integer, c> r = r(bVar.meh);
                sparseArray.put(((Integer) r.first).intValue(), r.second);
            } else if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mdd) {
                j = s(bVar.meh);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0660a.meg.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a.C0660a c0660a2 = c0660a.meg.get(i3);
            if (c0660a2.type == com.google.android.exoplayer2.extractor.c.a.mcT) {
                j a2 = com.google.android.exoplayer2.extractor.c.b.a(c0660a2, c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mcS), j, ff, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.meI.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.lZY.dJ(i, jVar.type));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.meI.put(jVar.id, bVar2);
                this.lUZ = Math.max(this.lUZ, jVar.lUZ);
                i++;
            }
            dsE();
            this.lZY.dst();
            return;
        }
        com.google.android.exoplayer2.util.a.checkState(this.meI.size() == size3);
        while (i < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i);
            this.meI.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i++;
        }
    }

    private void e(a.C0660a c0660a) throws ParserException {
        a(c0660a, this.meI, this.flags, this.meP);
        DrmInitData ff = this.meH != null ? null : ff(c0660a.mef);
        if (ff != null) {
            int size = this.meI.size();
            for (int i = 0; i < size; i++) {
                this.meI.valueAt(i).d(ff);
            }
        }
    }

    private void dsE() {
        if ((this.flags & 4) != 0 && this.mfb == null) {
            this.mfb = this.lZY.dJ(this.meI.size(), 4);
            this.mfb.h(Format.h(null, "application/x-emsg", Format.OFFSET_SAMPLE_RELATIVE));
        }
        if ((this.flags & 8) != 0 && this.mfc == null) {
            com.google.android.exoplayer2.extractor.m dJ = this.lZY.dJ(this.meI.size() + 1, 3);
            dJ.h(Format.a(null, "application/cea-608", 0, null));
            this.mfc = new com.google.android.exoplayer2.extractor.m[]{dJ};
        }
    }

    private void q(com.google.android.exoplayer2.util.l lVar) {
        if (this.mfb != null) {
            lVar.setPosition(12);
            lVar.dxj();
            lVar.dxj();
            long h = v.h(lVar.readUnsignedInt(), TimeUtils.NANOS_PER_MS, lVar.readUnsignedInt());
            lVar.setPosition(12);
            int dwV = lVar.dwV();
            this.mfb.a(lVar, dwV);
            if (this.meY != -9223372036854775807L) {
                this.mfb.a(h + this.meY, 1, dwV, 0, null);
                return;
            }
            this.meR.addLast(new a(h, dwV));
            this.meX += dwV;
        }
    }

    private static Pair<Integer, c> r(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(12);
        return Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.dxg() - 1, lVar.dxg(), lVar.dxg(), lVar.readInt()));
    }

    private static long s(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt()) == 0 ? lVar.readUnsignedInt() : lVar.dxi();
    }

    private static void a(a.C0660a c0660a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = c0660a.meg.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0660a c0660a2 = c0660a.meg.get(i2);
            if (c0660a2.type == com.google.android.exoplayer2.extractor.c.a.mdb) {
                b(c0660a2, sparseArray, i, bArr);
            }
        }
    }

    private static void b(a.C0660a c0660a, SparseArray<b> sparseArray, int i, byte[] bArr) throws ParserException {
        b a2 = a(c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mcN).meh, sparseArray, i);
        if (a2 != null) {
            l lVar = a2.mff;
            long j = lVar.mgu;
            a2.reset();
            if (c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mcM) != null && (i & 2) == 0) {
                j = t(c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mcM).meh);
            }
            a(c0660a, a2, j, i);
            k JC = a2.mfg.JC(lVar.mgd.meB);
            a.b Jx = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mds);
            if (Jx != null) {
                a(JC, Jx.meh, lVar);
            }
            a.b Jx2 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdt);
            if (Jx2 != null) {
                a(Jx2.meh, lVar);
            }
            a.b Jx3 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdx);
            if (Jx3 != null) {
                b(Jx3.meh, lVar);
            }
            a.b Jx4 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdu);
            a.b Jx5 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdv);
            if (Jx4 != null && Jx5 != null) {
                a(Jx4.meh, Jx5.meh, JC != null ? JC.schemeType : null, lVar);
            }
            int size = c0660a.mef.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = c0660a.mef.get(i2);
                if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mdw) {
                    a(bVar.meh, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0660a c0660a, b bVar, long j, int i) {
        int i2;
        int i3;
        List<a.b> list = c0660a.mef;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            a.b bVar2 = list.get(i4);
            if (bVar2.type == com.google.android.exoplayer2.extractor.c.a.mcP) {
                com.google.android.exoplayer2.util.l lVar = bVar2.meh;
                lVar.setPosition(12);
                int dxg = lVar.dxg();
                if (dxg > 0) {
                    i2 = dxg + i5;
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
        bVar.mfk = 0;
        bVar.mfj = 0;
        bVar.mfi = 0;
        bVar.mff.dK(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == com.google.android.exoplayer2.extractor.c.a.mcP) {
                i7 = a(bVar, i8, j, i, bVar3.meh, i7);
                i8++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        int i;
        int i2 = kVar.mgb;
        lVar.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.c.a.Jv(lVar.readInt()) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int dxg = lVar.dxg();
        if (dxg != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dxg + ", " + lVar2.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.mgp;
            int i3 = 0;
            i = 0;
            while (i3 < dxg) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * dxg) + 0;
            Arrays.fill(lVar2.mgp, 0, dxg, z);
        }
        lVar2.JD(i);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((com.google.android.exoplayer2.extractor.c.a.Jv(readInt) & 1) == 1) {
            lVar.skipBytes(8);
        }
        int dxg = lVar.dxg();
        if (dxg != 1) {
            throw new ParserException("Unexpected saio entry count: " + dxg);
        }
        int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(readInt);
        lVar2.mgg = (Ju == 0 ? lVar.readUnsignedInt() : lVar.dxi()) + lVar2.mgg;
    }

    private static b a(com.google.android.exoplayer2.util.l lVar, SparseArray<b> sparseArray, int i) {
        lVar.setPosition(8);
        int Jv = com.google.android.exoplayer2.extractor.c.a.Jv(lVar.readInt());
        int readInt = lVar.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        b bVar = sparseArray.get(readInt);
        if (bVar == null) {
            return null;
        }
        if ((Jv & 1) != 0) {
            long dxi = lVar.dxi();
            bVar.mff.mgf = dxi;
            bVar.mff.mgg = dxi;
        }
        c cVar = bVar.mfh;
        bVar.mff.mgd = new c((Jv & 2) != 0 ? lVar.dxg() - 1 : cVar.meB, (Jv & 8) != 0 ? lVar.dxg() : cVar.duration, (Jv & 16) != 0 ? lVar.dxg() : cVar.size, (Jv & 32) != 0 ? lVar.dxg() : cVar.flags);
        return bVar;
    }

    private static long t(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        return com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt()) == 1 ? lVar.dxi() : lVar.readUnsignedInt();
    }

    private static int a(b bVar, int i, long j, int i2, com.google.android.exoplayer2.util.l lVar, int i3) {
        long j2;
        int readInt;
        lVar.setPosition(8);
        int Jv = com.google.android.exoplayer2.extractor.c.a.Jv(lVar.readInt());
        j jVar = bVar.mfg;
        l lVar2 = bVar.mff;
        c cVar = lVar2.mgd;
        lVar2.mgj[i] = lVar.dxg();
        lVar2.mgi[i] = lVar2.mgf;
        if ((Jv & 1) != 0) {
            long[] jArr = lVar2.mgi;
            jArr[i] = jArr[i] + lVar.readInt();
        }
        boolean z = (Jv & 4) != 0;
        int i4 = cVar.flags;
        if (z) {
            i4 = lVar.dxg();
        }
        boolean z2 = (Jv & 256) != 0;
        boolean z3 = (Jv & 512) != 0;
        boolean z4 = (Jv & 1024) != 0;
        boolean z5 = (Jv & 2048) != 0;
        if (jVar.mfX == null || jVar.mfX.length != 1 || jVar.mfX[0] != 0) {
            j2 = 0;
        } else {
            j2 = v.h(jVar.mfY[0], 1000L, jVar.timescale);
        }
        int[] iArr = lVar2.mgk;
        int[] iArr2 = lVar2.mgl;
        long[] jArr2 = lVar2.mgm;
        boolean[] zArr = lVar2.mgn;
        boolean z6 = jVar.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar2.mgj[i];
        long j3 = jVar.timescale;
        if (i > 0) {
            j = lVar2.mgu;
        }
        long j4 = j;
        while (i3 < i5) {
            int dxg = z2 ? lVar.dxg() : cVar.duration;
            int dxg2 = z3 ? lVar.dxg() : cVar.size;
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
            iArr[i3] = dxg2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += dxg;
            i3++;
        }
        lVar2.mgu = j4;
        return i5;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, l lVar2, byte[] bArr) throws ParserException {
        lVar.setPosition(8);
        lVar.D(bArr, 0, 16);
        if (Arrays.equals(bArr, meF)) {
            a(lVar, 16, lVar2);
        }
    }

    private static void b(com.google.android.exoplayer2.util.l lVar, l lVar2) throws ParserException {
        a(lVar, 0, lVar2);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, l lVar2) throws ParserException {
        lVar.setPosition(i + 8);
        int Jv = com.google.android.exoplayer2.extractor.c.a.Jv(lVar.readInt());
        if ((Jv & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (Jv & 2) != 0;
        int dxg = lVar.dxg();
        if (dxg != lVar2.sampleCount) {
            throw new ParserException("Length mismatch: " + dxg + ", " + lVar2.sampleCount);
        }
        Arrays.fill(lVar2.mgp, 0, dxg, z);
        lVar2.JD(lVar.dwV());
        lVar2.z(lVar);
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, String str, l lVar3) throws ParserException {
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() == meE) {
            if (com.google.android.exoplayer2.extractor.c.a.Ju(readInt) == 1) {
                lVar.skipBytes(4);
            }
            if (lVar.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            lVar2.setPosition(8);
            int readInt2 = lVar2.readInt();
            if (lVar2.readInt() == meE) {
                int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(readInt2);
                if (Ju == 1) {
                    if (lVar2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (Ju >= 2) {
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
                    lVar2.D(bArr, 0, bArr.length);
                    byte[] bArr2 = null;
                    if (z && readUnsignedByte2 == 0) {
                        int readUnsignedByte3 = lVar2.readUnsignedByte();
                        bArr2 = new byte[readUnsignedByte3];
                        lVar2.D(bArr2, 0, readUnsignedByte3);
                    }
                    lVar3.mgo = true;
                    lVar3.mgq = new k(z, str, readUnsignedByte2, bArr, i, i2, bArr2);
                }
            }
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.extractor.a> c(com.google.android.exoplayer2.util.l lVar, long j) throws ParserException {
        long dxi;
        long j2;
        lVar.setPosition(8);
        int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt());
        lVar.skipBytes(4);
        long readUnsignedInt = lVar.readUnsignedInt();
        if (Ju == 0) {
            long readUnsignedInt2 = lVar.readUnsignedInt();
            dxi = lVar.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long dxi2 = lVar.dxi();
            dxi = lVar.dxi() + j;
            j2 = dxi2;
        }
        long h = v.h(j2, TimeUtils.NANOS_PER_MS, readUnsignedInt);
        lVar.skipBytes(2);
        int readUnsignedShort = lVar.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j3 = dxi;
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
        int size = this.meI.size();
        int i = 0;
        while (i < size) {
            l lVar = this.meI.valueAt(i).mff;
            if (!lVar.mgt || lVar.mgg >= j2) {
                j = j2;
                bVar = bVar2;
            } else {
                j = lVar.mgg;
                bVar = this.meI.valueAt(i);
            }
            i++;
            bVar2 = bVar;
            j2 = j;
        }
        if (bVar2 == null) {
            this.lZZ = 3;
            return;
        }
        int position = (int) (j2 - fVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        fVar.Jh(position);
        bVar2.mff.t(fVar);
    }

    private boolean q(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        int a2;
        if (this.lZZ == 3) {
            if (this.meZ == null) {
                b f = f(this.meI);
                if (f == null) {
                    int position = (int) (this.meW - fVar.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    fVar.Jh(position);
                    dsD();
                    return false;
                }
                int position2 = (int) (f.mff.mgi[f.mfk] - fVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                fVar.Jh(position2);
                this.meZ = f;
            }
            this.sampleSize = this.meZ.mff.mgk[this.meZ.mfi];
            if (this.meZ.mff.mgo) {
                this.mbr = a(this.meZ);
                this.sampleSize += this.mbr;
            } else {
                this.mbr = 0;
            }
            if (this.meZ.mfg.mfW == 1) {
                this.sampleSize -= 8;
                fVar.Jh(8);
            }
            this.lZZ = 4;
            this.mbq = 0;
        }
        l lVar = this.meZ.mff;
        j jVar = this.meZ.mfg;
        com.google.android.exoplayer2.extractor.m mVar = this.meZ.mah;
        int i2 = this.meZ.mfi;
        if (jVar.mak != 0) {
            byte[] bArr = this.meJ.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = jVar.mak + 1;
            int i4 = 4 - jVar.mak;
            while (this.mbr < this.sampleSize) {
                if (this.mbq == 0) {
                    fVar.readFully(bArr, i4, i3);
                    this.meJ.setPosition(0);
                    this.mbq = this.meJ.dxg() - 1;
                    this.mai.setPosition(0);
                    mVar.a(this.mai, 4);
                    mVar.a(this.meJ, 1);
                    this.mfa = this.mfc != null && com.google.android.exoplayer2.util.j.a(jVar.lUU.sampleMimeType, bArr[4]);
                    this.mbr += 5;
                    this.sampleSize += i4;
                } else {
                    if (this.mfa) {
                        this.meK.reset(this.mbq);
                        fVar.readFully(this.meK.data, 0, this.mbq);
                        mVar.a(this.meK, this.mbq);
                        int i5 = this.mbq;
                        int D = com.google.android.exoplayer2.util.j.D(this.meK.data, this.meK.dwW());
                        this.meK.setPosition("video/hevc".equals(jVar.lUU.sampleMimeType) ? 1 : 0);
                        this.meK.setLimit(D);
                        com.google.android.exoplayer2.text.a.g.a(lVar.JE(i2) * 1000, this.meK, this.mfc);
                        a2 = i5;
                    } else {
                        a2 = mVar.a(fVar, this.mbq, false);
                    }
                    this.mbr += a2;
                    this.mbq -= a2;
                }
            }
        } else {
            while (this.mbr < this.sampleSize) {
                this.mbr = mVar.a(fVar, this.sampleSize - this.mbr, false) + this.mbr;
            }
        }
        long JE = lVar.JE(i2) * 1000;
        if (this.meN != null) {
            JE = this.meN.gG(JE);
        }
        int i6 = lVar.mgn[i2] ? 1 : 0;
        m.a aVar = null;
        if (lVar.mgo) {
            i = 1073741824 | i6;
            aVar = (lVar.mgq != null ? lVar.mgq : jVar.JC(lVar.mgd.meB)).mbz;
        } else {
            i = i6;
        }
        mVar.a(JE, i, this.sampleSize, 0, aVar);
        while (!this.meR.isEmpty()) {
            a removeFirst = this.meR.removeFirst();
            this.meX -= removeFirst.size;
            this.mfb.a(removeFirst.mfe + JE, 1, removeFirst.size, this.meX, null);
        }
        this.meZ.mfi++;
        this.meZ.mfj++;
        if (this.meZ.mfj == lVar.mgj[this.meZ.mfk]) {
            this.meZ.mfk++;
            this.meZ.mfj = 0;
            this.meZ = null;
        }
        this.lZZ = 3;
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
            if (valueAt.mfk == valueAt.mff.mgh) {
                long j3 = j2;
                bVar = bVar2;
                j = j3;
            } else {
                long j4 = valueAt.mff.mgi[valueAt.mfk];
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
        l lVar2 = bVar.mff;
        k JC = lVar2.mgq != null ? lVar2.mgq : bVar.mfg.JC(lVar2.mgd.meB);
        if (JC.mgb != 0) {
            lVar = lVar2.mgs;
            length = JC.mgb;
        } else {
            byte[] bArr = JC.mgc;
            this.meM.G(bArr, bArr.length);
            lVar = this.meM;
            length = bArr.length;
        }
        boolean z = lVar2.mgp[bVar.mfi];
        this.meL.data[0] = (byte) ((z ? 128 : 0) | length);
        this.meL.setPosition(0);
        com.google.android.exoplayer2.extractor.m mVar = bVar.mah;
        mVar.a(this.meL, 1);
        mVar.a(lVar, length);
        if (!z) {
            return length + 1;
        }
        com.google.android.exoplayer2.util.l lVar3 = lVar2.mgs;
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
            if (bVar.type == com.google.android.exoplayer2.extractor.c.a.mdk) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.meh.data;
                UUID aq = h.aq(bArr);
                if (aq == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(aq, MimeType.Video.MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static boolean Jz(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mdi || i == com.google.android.exoplayer2.extractor.c.a.mdh || i == com.google.android.exoplayer2.extractor.c.a.mcS || i == com.google.android.exoplayer2.extractor.c.a.mcQ || i == com.google.android.exoplayer2.extractor.c.a.mdj || i == com.google.android.exoplayer2.extractor.c.a.mcM || i == com.google.android.exoplayer2.extractor.c.a.mcN || i == com.google.android.exoplayer2.extractor.c.a.mde || i == com.google.android.exoplayer2.extractor.c.a.mcO || i == com.google.android.exoplayer2.extractor.c.a.mcP || i == com.google.android.exoplayer2.extractor.c.a.mdk || i == com.google.android.exoplayer2.extractor.c.a.mds || i == com.google.android.exoplayer2.extractor.c.a.mdt || i == com.google.android.exoplayer2.extractor.c.a.mdx || i == com.google.android.exoplayer2.extractor.c.a.mdw || i == com.google.android.exoplayer2.extractor.c.a.mdu || i == com.google.android.exoplayer2.extractor.c.a.mdv || i == com.google.android.exoplayer2.extractor.c.a.mdg || i == com.google.android.exoplayer2.extractor.c.a.mdd || i == com.google.android.exoplayer2.extractor.c.a.mdW;
    }

    private static boolean JA(int i) {
        return i == com.google.android.exoplayer2.extractor.c.a.mcR || i == com.google.android.exoplayer2.extractor.c.a.mcT || i == com.google.android.exoplayer2.extractor.c.a.mcU || i == com.google.android.exoplayer2.extractor.c.a.mcV || i == com.google.android.exoplayer2.extractor.c.a.mcW || i == com.google.android.exoplayer2.extractor.c.a.mda || i == com.google.android.exoplayer2.extractor.c.a.mdb || i == com.google.android.exoplayer2.extractor.c.a.mdc || i == com.google.android.exoplayer2.extractor.c.a.mdf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final long mfe;
        public final int size;

        public a(long j, int i) {
            this.mfe = j;
            this.size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {
        public final com.google.android.exoplayer2.extractor.m mah;
        public final l mff = new l();
        public j mfg;
        public c mfh;
        public int mfi;
        public int mfj;
        public int mfk;

        public b(com.google.android.exoplayer2.extractor.m mVar) {
            this.mah = mVar;
        }

        public void a(j jVar, c cVar) {
            this.mfg = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
            this.mfh = (c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
            this.mah.h(jVar.lUU);
            reset();
        }

        public void reset() {
            this.mff.reset();
            this.mfi = 0;
            this.mfk = 0;
            this.mfj = 0;
        }

        public void d(DrmInitData drmInitData) {
            k JC = this.mfg.JC(this.mff.mgd.meB);
            this.mah.h(this.mfg.lUU.a(drmInitData.OS(JC != null ? JC.schemeType : null)));
        }
    }
}
