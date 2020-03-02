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
    long mrO;
    private long mrP;
    boolean mrR;
    private final int mrr;
    private final q.a<f<T>> mtA;
    private final b.a mtB;
    private final o mtF;
    private final o[] mtG;
    private final b mtH;
    private Format mtI;
    private final int mtm;
    private final int[] mtw;
    private final boolean[] mty;
    private final T mtz;
    private final Loader mrx = new Loader("Loader:ChunkSampleStream");
    private final e mtC = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> mtD = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> mtE = Collections.unmodifiableList(this.mtD);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.mtm = i;
        this.mtw = iArr;
        this.mtz = t;
        this.mtA = aVar;
        this.mtB = aVar2;
        this.mrr = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.mtG = new o[length];
        this.mty = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.mtF = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.mtF;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.mtG[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mtH = new b(iArr2, oVarArr);
        this.mrP = j;
        this.mrO = j;
    }

    public void gm(long j) {
        for (int i = 0; i < this.mtG.length; i++) {
            this.mtG[i].c(j, true, this.mty[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.mtG.length; i2++) {
            if (this.mtw[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.mty[i2] ? false : true);
                this.mty[i2] = true;
                this.mtG[i2].rewind();
                this.mtG[i2].a(j, true, true);
                return new a(this, this.mtG[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dwO() {
        return this.mtz;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwh() {
        if (this.mrR) {
            return Long.MIN_VALUE;
        }
        if (dws()) {
            return this.mrP;
        }
        long j = this.mrO;
        com.google.android.exoplayer2.source.a.a last = this.mtD.getLast();
        if (!last.dwR()) {
            last = this.mtD.size() > 1 ? this.mtD.get(this.mtD.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.mtl) : j, this.mtF.dwr());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gn(long j) {
        boolean z;
        o[] oVarArr;
        this.mrO = j;
        if (!dws()) {
            if (this.mtF.a(j, true, j < dwi()) != -1) {
                z = true;
                if (!z) {
                    KT(this.mtF.dww());
                    this.mtF.dwE();
                    for (o oVar : this.mtG) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mrP = j;
                this.mrR = false;
                this.mtD.clear();
                if (this.mrx.isLoading()) {
                    this.mrx.cNA();
                    return;
                }
                this.mtF.reset();
                for (o oVar2 : this.mtG) {
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
        if (!this.mrx.a(this)) {
            this.mtF.dwF();
            for (o oVar : this.mtG) {
                oVar.dwF();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwn() {
        this.mtF.reset();
        for (o oVar : this.mtG) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mrR || (!dws() && this.mtF.dwy());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwl() throws IOException {
        this.mrx.dwl();
        if (!this.mrx.isLoading()) {
            this.mtz.dwl();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dws()) {
            return -3;
        }
        KT(this.mtF.dww());
        int a2 = this.mtF.a(mVar, eVar, z, this.mrR, this.mrO);
        if (a2 == -4) {
            this.mtF.dwE();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int ge(long j) {
        int i = 0;
        if (!dws()) {
            if (this.mrR && j > this.mtF.dwr()) {
                i = this.mtF.dwA();
            } else {
                int a2 = this.mtF.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.mtF.dwE();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.mtz.b(cVar);
        this.mtB.c(cVar.dataSpec, cVar.type, this.mtm, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, cVar.dwL());
        this.mtA.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.mtB.d(cVar.dataSpec, cVar.type, this.mtm, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, cVar.dwL());
        if (!z) {
            this.mtF.reset();
            for (o oVar : this.mtG) {
                oVar.reset();
            }
            this.mtA.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dwL = cVar.dwL();
        boolean a2 = a(cVar);
        boolean z = (dwL != 0 && a2 && dwP()) ? false : true;
        boolean z2 = false;
        if (this.mtz.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.mtD.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.mtF.KL(removeLast.KS(0));
                    for (int i = 0; i < this.mtG.length; i++) {
                        this.mtG[i].KL(removeLast.KS(i + 1));
                    }
                    if (this.mtD.isEmpty()) {
                        this.mrP = this.mrO;
                    }
                }
            }
        }
        this.mtB.b(cVar.dataSpec, cVar.type, this.mtm, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, dwL, iOException, z2);
        if (z2) {
            this.mtA.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mrR || this.mrx.isLoading()) {
            return false;
        }
        if (dws()) {
            aVar = null;
            j2 = this.mrP;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.mtD.getLast();
            j2 = last.mtl;
            aVar = last;
        }
        this.mtz.a(aVar, j, j2, this.mtC);
        boolean z = this.mtC.mtv;
        c cVar = this.mtC.mtu;
        this.mtC.clear();
        if (z) {
            this.mrP = -9223372036854775807L;
            this.mrR = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mrP = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.mtH);
                this.mtD.add(aVar2);
            }
            this.mtB.b(cVar.dataSpec, cVar.type, this.mtm, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, this.mrx.a(cVar, this, this.mrr));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwi() {
        if (dws()) {
            return this.mrP;
        }
        if (this.mrR) {
            return Long.MIN_VALUE;
        }
        return this.mtD.getLast().mtl;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dwP() {
        com.google.android.exoplayer2.source.a.a last = this.mtD.getLast();
        if (this.mtF.dww() > last.KS(0)) {
            return true;
        }
        for (int i = 0; i < this.mtG.length; i++) {
            if (this.mtG[i].dww() > last.KS(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dws() {
        return this.mrP != -9223372036854775807L;
    }

    private void KT(int i) {
        if (!this.mtD.isEmpty()) {
            while (this.mtD.size() > 1 && this.mtD.get(1).KS(0) <= i) {
                this.mtD.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.mtD.getFirst();
            Format format = first.mth;
            if (!format.equals(this.mtI)) {
                this.mtB.b(this.mtm, format, first.mti, first.mtj, first.mtk);
            }
            this.mtI = format;
        }
    }

    /* loaded from: classes6.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mtJ;
        private final o mtK;

        public a(f<T> fVar, o oVar, int i) {
            this.mtJ = fVar;
            this.mtK = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mrR || (!f.this.dws() && this.mtK.dwy());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            if (f.this.mrR && j > this.mtK.dwr()) {
                return this.mtK.dwA();
            }
            int a = this.mtK.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwl() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dws()) {
                return -3;
            }
            return this.mtK.a(mVar, eVar, z, f.this.mrR, f.this.mrO);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.mty[this.index]);
            f.this.mty[this.index] = false;
        }
    }
}
