package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.g;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class f<T extends g> implements p, q, Loader.a<c>, Loader.d {
    long mrM;
    private long mrN;
    boolean mrP;
    private final int mrp;
    private final Loader mrv = new Loader("Loader:ChunkSampleStream");
    private final e mtA = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> mtB = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> mtC = Collections.unmodifiableList(this.mtB);
    private final o mtD;
    private final o[] mtE;
    private final b mtF;
    private Format mtG;
    private final int mtk;
    private final int[] mtu;
    private final boolean[] mtv;
    private final T mtw;
    private final q.a<f<T>> mty;
    private final b.a mtz;

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.mtk = i;
        this.mtu = iArr;
        this.mtw = t;
        this.mty = aVar;
        this.mtz = aVar2;
        this.mrp = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.mtE = new o[length];
        this.mtv = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.mtD = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.mtD;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.mtE[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mtF = new b(iArr2, oVarArr);
        this.mrN = j;
        this.mrM = j;
    }

    public void gm(long j) {
        for (int i = 0; i < this.mtE.length; i++) {
            this.mtE[i].c(j, true, this.mtv[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.mtE.length; i2++) {
            if (this.mtu[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.mtv[i2] ? false : true);
                this.mtv[i2] = true;
                this.mtE[i2].rewind();
                this.mtE[i2].a(j, true, true);
                return new a(this, this.mtE[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dwM() {
        return this.mtw;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwf() {
        if (this.mrP) {
            return Long.MIN_VALUE;
        }
        if (dwq()) {
            return this.mrN;
        }
        long j = this.mrM;
        com.google.android.exoplayer2.source.a.a last = this.mtB.getLast();
        if (!last.dwP()) {
            last = this.mtB.size() > 1 ? this.mtB.get(this.mtB.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.mtj) : j, this.mtD.dwp());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gn(long j) {
        boolean z;
        o[] oVarArr;
        this.mrM = j;
        if (!dwq()) {
            if (this.mtD.a(j, true, j < dwg()) != -1) {
                z = true;
                if (!z) {
                    KT(this.mtD.dwu());
                    this.mtD.dwC();
                    for (o oVar : this.mtE) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mrN = j;
                this.mrP = false;
                this.mtB.clear();
                if (this.mrv.isLoading()) {
                    this.mrv.cNy();
                    return;
                }
                this.mtD.reset();
                for (o oVar2 : this.mtE) {
                    oVar2.reset();
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public void release() {
        if (!this.mrv.a(this)) {
            this.mtD.dwD();
            for (o oVar : this.mtE) {
                oVar.dwD();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwl() {
        this.mtD.reset();
        for (o oVar : this.mtE) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mrP || (!dwq() && this.mtD.dww());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwj() throws IOException {
        this.mrv.dwj();
        if (!this.mrv.isLoading()) {
            this.mtw.dwj();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwq()) {
            return -3;
        }
        KT(this.mtD.dwu());
        int a2 = this.mtD.a(mVar, eVar, z, this.mrP, this.mrM);
        if (a2 == -4) {
            this.mtD.dwC();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int ge(long j) {
        int i = 0;
        if (!dwq()) {
            if (this.mrP && j > this.mtD.dwp()) {
                i = this.mtD.dwy();
            } else {
                int a2 = this.mtD.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.mtD.dwC();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.mtw.b(cVar);
        this.mtz.c(cVar.dataSpec, cVar.type, this.mtk, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, cVar.dwJ());
        this.mty.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.mtz.d(cVar.dataSpec, cVar.type, this.mtk, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, cVar.dwJ());
        if (!z) {
            this.mtD.reset();
            for (o oVar : this.mtE) {
                oVar.reset();
            }
            this.mty.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dwJ = cVar.dwJ();
        boolean a2 = a(cVar);
        boolean z = (dwJ != 0 && a2 && dwN()) ? false : true;
        boolean z2 = false;
        if (this.mtw.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.mtB.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.mtD.KL(removeLast.KS(0));
                    for (int i = 0; i < this.mtE.length; i++) {
                        this.mtE[i].KL(removeLast.KS(i + 1));
                    }
                    if (this.mtB.isEmpty()) {
                        this.mrN = this.mrM;
                    }
                }
            }
        }
        this.mtz.b(cVar.dataSpec, cVar.type, this.mtk, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, dwJ, iOException, z2);
        if (z2) {
            this.mty.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mrP || this.mrv.isLoading()) {
            return false;
        }
        if (dwq()) {
            aVar = null;
            j2 = this.mrN;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.mtB.getLast();
            j2 = last.mtj;
            aVar = last;
        }
        this.mtw.a(aVar, j, j2, this.mtA);
        boolean z = this.mtA.mtt;
        c cVar = this.mtA.mts;
        this.mtA.clear();
        if (z) {
            this.mrN = -9223372036854775807L;
            this.mrP = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mrN = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.mtF);
                this.mtB.add(aVar2);
            }
            this.mtz.b(cVar.dataSpec, cVar.type, this.mtk, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, this.mrv.a(cVar, this, this.mrp));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwg() {
        if (dwq()) {
            return this.mrN;
        }
        if (this.mrP) {
            return Long.MIN_VALUE;
        }
        return this.mtB.getLast().mtj;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dwN() {
        com.google.android.exoplayer2.source.a.a last = this.mtB.getLast();
        if (this.mtD.dwu() > last.KS(0)) {
            return true;
        }
        for (int i = 0; i < this.mtE.length; i++) {
            if (this.mtE[i].dwu() > last.KS(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dwq() {
        return this.mrN != -9223372036854775807L;
    }

    private void KT(int i) {
        if (!this.mtB.isEmpty()) {
            while (this.mtB.size() > 1 && this.mtB.get(1).KS(0) <= i) {
                this.mtB.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.mtB.getFirst();
            Format format = first.mtf;
            if (!format.equals(this.mtG)) {
                this.mtz.b(this.mtk, format, first.mtg, first.mth, first.mti);
            }
            this.mtG = format;
        }
    }

    /* loaded from: classes6.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mtH;
        private final o mtI;

        public a(f<T> fVar, o oVar, int i) {
            this.mtH = fVar;
            this.mtI = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mrP || (!f.this.dwq() && this.mtI.dww());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            if (f.this.mrP && j > this.mtI.dwp()) {
                return this.mtI.dwy();
            }
            int a = this.mtI.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwj() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dwq()) {
                return -3;
            }
            return this.mtI.a(mVar, eVar, z, f.this.mrP, f.this.mrM);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.mtv[this.index]);
            f.this.mtv[this.index] = false;
        }
    }
}
