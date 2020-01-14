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
/* loaded from: classes5.dex */
public class f<T extends g> implements p, q, Loader.a<c>, Loader.d {
    private final int mqJ;
    long mrg;
    private long mrh;
    boolean mrj;
    private final int msE;
    private final int[] msO;
    private final boolean[] msP;
    private final T msQ;
    private final q.a<f<T>> msR;
    private final b.a msS;
    private final o msW;
    private final o[] msX;
    private final b msY;
    private Format msZ;
    private final Loader mqP = new Loader("Loader:ChunkSampleStream");
    private final e msT = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> msU = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> msV = Collections.unmodifiableList(this.msU);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.msE = i;
        this.msO = iArr;
        this.msQ = t;
        this.msR = aVar;
        this.msS = aVar2;
        this.mqJ = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.msX = new o[length];
        this.msP = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.msW = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.msW;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.msX[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.msY = new b(iArr2, oVarArr);
        this.mrh = j;
        this.mrg = j;
    }

    public void go(long j) {
        for (int i = 0; i < this.msX.length; i++) {
            this.msX[i].c(j, true, this.msP[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.msX.length; i2++) {
            if (this.msO[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.msP[i2] ? false : true);
                this.msP[i2] = true;
                this.msX[i2].rewind();
                this.msX[i2].a(j, true, true);
                return new a(this, this.msX[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dvC() {
        return this.msQ;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duV() {
        if (this.mrj) {
            return Long.MIN_VALUE;
        }
        if (dvg()) {
            return this.mrh;
        }
        long j = this.mrg;
        com.google.android.exoplayer2.source.a.a last = this.msU.getLast();
        if (!last.dvF()) {
            last = this.msU.size() > 1 ? this.msU.get(this.msU.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.msD) : j, this.msW.dvf());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gp(long j) {
        boolean z;
        o[] oVarArr;
        this.mrg = j;
        if (!dvg()) {
            if (this.msW.a(j, true, j < duW()) != -1) {
                z = true;
                if (!z) {
                    KO(this.msW.dvk());
                    this.msW.dvs();
                    for (o oVar : this.msX) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mrh = j;
                this.mrj = false;
                this.msU.clear();
                if (this.mqP.isLoading()) {
                    this.mqP.cMd();
                    return;
                }
                this.msW.reset();
                for (o oVar2 : this.msX) {
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
        if (!this.mqP.a(this)) {
            this.msW.dvt();
            for (o oVar : this.msX) {
                oVar.dvt();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dvb() {
        this.msW.reset();
        for (o oVar : this.msX) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mrj || (!dvg() && this.msW.dvm());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void duZ() throws IOException {
        this.mqP.duZ();
        if (!this.mqP.isLoading()) {
            this.msQ.duZ();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dvg()) {
            return -3;
        }
        KO(this.msW.dvk());
        int a2 = this.msW.a(mVar, eVar, z, this.mrj, this.mrg);
        if (a2 == -4) {
            this.msW.dvs();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gg(long j) {
        int i = 0;
        if (!dvg()) {
            if (this.mrj && j > this.msW.dvf()) {
                i = this.msW.dvo();
            } else {
                int a2 = this.msW.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.msW.dvs();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.msQ.b(cVar);
        this.msS.c(cVar.dataSpec, cVar.type, this.msE, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, cVar.dvz());
        this.msR.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.msS.d(cVar.dataSpec, cVar.type, this.msE, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, cVar.dvz());
        if (!z) {
            this.msW.reset();
            for (o oVar : this.msX) {
                oVar.reset();
            }
            this.msR.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dvz = cVar.dvz();
        boolean a2 = a(cVar);
        boolean z = (dvz != 0 && a2 && dvD()) ? false : true;
        boolean z2 = false;
        if (this.msQ.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.msU.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.msW.KG(removeLast.KN(0));
                    for (int i = 0; i < this.msX.length; i++) {
                        this.msX[i].KG(removeLast.KN(i + 1));
                    }
                    if (this.msU.isEmpty()) {
                        this.mrh = this.mrg;
                    }
                }
            }
        }
        this.msS.b(cVar.dataSpec, cVar.type, this.msE, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, dvz, iOException, z2);
        if (z2) {
            this.msR.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mrj || this.mqP.isLoading()) {
            return false;
        }
        if (dvg()) {
            aVar = null;
            j2 = this.mrh;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.msU.getLast();
            j2 = last.msD;
            aVar = last;
        }
        this.msQ.a(aVar, j, j2, this.msT);
        boolean z = this.msT.msN;
        c cVar = this.msT.msM;
        this.msT.clear();
        if (z) {
            this.mrh = -9223372036854775807L;
            this.mrj = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mrh = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.msY);
                this.msU.add(aVar2);
            }
            this.msS.b(cVar.dataSpec, cVar.type, this.msE, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, this.mqP.a(cVar, this, this.mqJ));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duW() {
        if (dvg()) {
            return this.mrh;
        }
        if (this.mrj) {
            return Long.MIN_VALUE;
        }
        return this.msU.getLast().msD;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dvD() {
        com.google.android.exoplayer2.source.a.a last = this.msU.getLast();
        if (this.msW.dvk() > last.KN(0)) {
            return true;
        }
        for (int i = 0; i < this.msX.length; i++) {
            if (this.msX[i].dvk() > last.KN(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dvg() {
        return this.mrh != -9223372036854775807L;
    }

    private void KO(int i) {
        if (!this.msU.isEmpty()) {
            while (this.msU.size() > 1 && this.msU.get(1).KN(0) <= i) {
                this.msU.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.msU.getFirst();
            Format format = first.msz;
            if (!format.equals(this.msZ)) {
                this.msS.b(this.msE, format, first.msA, first.msB, first.msC);
            }
            this.msZ = format;
        }
    }

    /* loaded from: classes5.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mta;
        private final o mtb;

        public a(f<T> fVar, o oVar, int i) {
            this.mta = fVar;
            this.mtb = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mrj || (!f.this.dvg() && this.mtb.dvm());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gg(long j) {
            if (f.this.mrj && j > this.mtb.dvf()) {
                return this.mtb.dvo();
            }
            int a = this.mtb.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void duZ() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dvg()) {
                return -3;
            }
            return this.mtb.a(mVar, eVar, z, f.this.mrj, f.this.mrg);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.msP[this.index]);
            f.this.msP[this.index] = false;
        }
    }
}
