package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class b implements e, l {
    public static final h lZS = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dss() {
            return new e[]{new b()};
        }
    };
    private static final int lZT = v.Qg("FLV");
    public int Vo;
    private g lZY;
    private int maa;
    public int mab;
    public long mad;
    private a mae;
    private d maf;
    private c mag;
    private final com.google.android.exoplayer2.util.l lZU = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l lZV = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l lZW = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l lZX = new com.google.android.exoplayer2.util.l();
    private int lZZ = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.p(this.lZU.data, 0, 3);
        this.lZU.setPosition(0);
        if (this.lZU.dwZ() != lZT) {
            return false;
        }
        fVar.p(this.lZU.data, 0, 2);
        this.lZU.setPosition(0);
        if ((this.lZU.readUnsignedShort() & 250) == 0) {
            fVar.p(this.lZU.data, 0, 4);
            this.lZU.setPosition(0);
            int readInt = this.lZU.readInt();
            fVar.dsq();
            fVar.Ji(readInt);
            fVar.p(this.lZU.data, 0, 4);
            this.lZU.setPosition(0);
            return this.lZU.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.lZY = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.lZZ = 1;
        this.maa = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.lZZ) {
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
        if (fVar.d(this.lZV.data, 0, 9, true)) {
            this.lZV.setPosition(0);
            this.lZV.skipBytes(4);
            int readUnsignedByte = this.lZV.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.mae == null) {
                this.mae = new a(this.lZY.dJ(8, 1));
            }
            if (z2 && this.maf == null) {
                this.maf = new d(this.lZY.dJ(9, 2));
            }
            if (this.mag == null) {
                this.mag = new c(null);
            }
            this.lZY.dst();
            this.lZY.a(this);
            this.maa = (this.lZV.readInt() - 9) + 4;
            this.lZZ = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jh(this.maa);
        this.maa = 0;
        this.lZZ = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.lZW.data, 0, 11, true)) {
            this.lZW.setPosition(0);
            this.Vo = this.lZW.readUnsignedByte();
            this.mab = this.lZW.dwZ();
            this.mad = this.lZW.dwZ();
            this.mad = ((this.lZW.readUnsignedByte() << 24) | this.mad) * 1000;
            this.lZW.skipBytes(3);
            this.lZZ = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.Vo == 8 && this.mae != null) {
            this.mae.b(f(fVar), this.mad);
        } else if (this.Vo == 9 && this.maf != null) {
            this.maf.b(f(fVar), this.mad);
        } else if (this.Vo == 18 && this.mag != null) {
            this.mag.b(f(fVar), this.mad);
        } else {
            fVar.Jh(this.mab);
            z = false;
        }
        this.maa = 4;
        this.lZZ = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.mab > this.lZX.capacity()) {
            this.lZX.G(new byte[Math.max(this.lZX.capacity() * 2, this.mab)], 0);
        } else {
            this.lZX.setPosition(0);
        }
        this.lZX.setLimit(this.mab);
        fVar.readFully(this.lZX.data, 0, this.mab);
        return this.lZX;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.mag.drc();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        return 0L;
    }
}
