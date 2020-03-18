package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class b implements e, l {
    public static final h mgo = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dvr() {
            return new e[]{new b()};
        }
    };
    private static final int mgp = v.QE("FLV");
    public int Xu;
    private d mgA;
    private c mgB;
    private g mgu;
    private int mgw;
    public int mgx;
    public long mgy;
    private a mgz;
    private final com.google.android.exoplayer2.util.l mgq = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l mgr = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l mgs = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l mgt = new com.google.android.exoplayer2.util.l();
    private int mgv = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mgq.data, 0, 3);
        this.mgq.setPosition(0);
        if (this.mgq.dzV() != mgp) {
            return false;
        }
        fVar.s(this.mgq.data, 0, 2);
        this.mgq.setPosition(0);
        if ((this.mgq.readUnsignedShort() & 250) == 0) {
            fVar.s(this.mgq.data, 0, 4);
            this.mgq.setPosition(0);
            int readInt = this.mgq.readInt();
            fVar.dvp();
            fVar.JC(readInt);
            fVar.s(this.mgq.data, 0, 4);
            this.mgq.setPosition(0);
            return this.mgq.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mgu = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mgv = 1;
        this.mgw = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mgv) {
                case 1:
                    if (b(fVar)) {
                        break;
                    } else {
                        return -1;
                    }
                case 2:
                    c(fVar);
                    break;
                case 3:
                    if (d(fVar)) {
                        break;
                    } else {
                        return -1;
                    }
                case 4:
                    if (!e(fVar)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.mgr.data, 0, 9, true)) {
            this.mgr.setPosition(0);
            this.mgr.skipBytes(4);
            int readUnsignedByte = this.mgr.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.mgz == null) {
                this.mgz = new a(this.mgu.dL(8, 1));
            }
            if (z2 && this.mgA == null) {
                this.mgA = new d(this.mgu.dL(9, 2));
            }
            if (this.mgB == null) {
                this.mgB = new c(null);
            }
            this.mgu.dvs();
            this.mgu.a(this);
            this.mgw = (this.mgr.readInt() - 9) + 4;
            this.mgv = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.JB(this.mgw);
        this.mgw = 0;
        this.mgv = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.mgs.data, 0, 11, true)) {
            this.mgs.setPosition(0);
            this.Xu = this.mgs.readUnsignedByte();
            this.mgx = this.mgs.dzV();
            this.mgy = this.mgs.dzV();
            this.mgy = ((this.mgs.readUnsignedByte() << 24) | this.mgy) * 1000;
            this.mgs.skipBytes(3);
            this.mgv = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.Xu == 8 && this.mgz != null) {
            this.mgz.b(f(fVar), this.mgy);
        } else if (this.Xu == 9 && this.mgA != null) {
            this.mgA.b(f(fVar), this.mgy);
        } else if (this.Xu == 18 && this.mgB != null) {
            this.mgB.b(f(fVar), this.mgy);
        } else {
            fVar.JB(this.mgx);
            z = false;
        }
        this.mgw = 4;
        this.mgv = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.mgx > this.mgt.capacity()) {
            this.mgt.I(new byte[Math.max(this.mgt.capacity() * 2, this.mgx)], 0);
        } else {
            this.mgt.setPosition(0);
        }
        this.mgt.setLimit(this.mgx);
        fVar.readFully(this.mgt.data, 0, this.mgx);
        return this.mgt;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mgB.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        return 0L;
    }
}
