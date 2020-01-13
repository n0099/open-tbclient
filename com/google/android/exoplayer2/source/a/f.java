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
    private final int mqE;
    long mrb;
    private long mrc;
    boolean mre;
    private final int[] msJ;
    private final boolean[] msK;
    private final T msL;
    private final q.a<f<T>> msM;
    private final b.a msN;
    private final o msR;
    private final o[] msS;
    private final b msT;
    private Format msU;
    private final int msz;
    private final Loader mqK = new Loader("Loader:ChunkSampleStream");
    private final e msO = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> msP = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> msQ = Collections.unmodifiableList(this.msP);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.msz = i;
        this.msJ = iArr;
        this.msL = t;
        this.msM = aVar;
        this.msN = aVar2;
        this.mqE = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.msS = new o[length];
        this.msK = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.msR = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.msR;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.msS[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.msT = new b(iArr2, oVarArr);
        this.mrc = j;
        this.mrb = j;
    }

    public void go(long j) {
        for (int i = 0; i < this.msS.length; i++) {
            this.msS[i].c(j, true, this.msK[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.msS.length; i2++) {
            if (this.msJ[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.msK[i2] ? false : true);
                this.msK[i2] = true;
                this.msS[i2].rewind();
                this.msS[i2].a(j, true, true);
                return new a(this, this.msS[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dvA() {
        return this.msL;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duT() {
        if (this.mre) {
            return Long.MIN_VALUE;
        }
        if (dve()) {
            return this.mrc;
        }
        long j = this.mrb;
        com.google.android.exoplayer2.source.a.a last = this.msP.getLast();
        if (!last.dvD()) {
            last = this.msP.size() > 1 ? this.msP.get(this.msP.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.msy) : j, this.msR.dvd());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gp(long j) {
        boolean z;
        o[] oVarArr;
        this.mrb = j;
        if (!dve()) {
            if (this.msR.a(j, true, j < duU()) != -1) {
                z = true;
                if (!z) {
                    KO(this.msR.dvi());
                    this.msR.dvq();
                    for (o oVar : this.msS) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mrc = j;
                this.mre = false;
                this.msP.clear();
                if (this.mqK.isLoading()) {
                    this.mqK.cMb();
                    return;
                }
                this.msR.reset();
                for (o oVar2 : this.msS) {
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
        if (!this.mqK.a(this)) {
            this.msR.dvr();
            for (o oVar : this.msS) {
                oVar.dvr();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void duZ() {
        this.msR.reset();
        for (o oVar : this.msS) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mre || (!dve() && this.msR.dvk());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void duX() throws IOException {
        this.mqK.duX();
        if (!this.mqK.isLoading()) {
            this.msL.duX();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dve()) {
            return -3;
        }
        KO(this.msR.dvi());
        int a2 = this.msR.a(mVar, eVar, z, this.mre, this.mrb);
        if (a2 == -4) {
            this.msR.dvq();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gg(long j) {
        int i = 0;
        if (!dve()) {
            if (this.mre && j > this.msR.dvd()) {
                i = this.msR.dvm();
            } else {
                int a2 = this.msR.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.msR.dvq();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.msL.b(cVar);
        this.msN.c(cVar.dataSpec, cVar.type, this.msz, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, cVar.dvx());
        this.msM.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.msN.d(cVar.dataSpec, cVar.type, this.msz, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, cVar.dvx());
        if (!z) {
            this.msR.reset();
            for (o oVar : this.msS) {
                oVar.reset();
            }
            this.msM.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dvx = cVar.dvx();
        boolean a2 = a(cVar);
        boolean z = (dvx != 0 && a2 && dvB()) ? false : true;
        boolean z2 = false;
        if (this.msL.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.msP.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.msR.KG(removeLast.KN(0));
                    for (int i = 0; i < this.msS.length; i++) {
                        this.msS[i].KG(removeLast.KN(i + 1));
                    }
                    if (this.msP.isEmpty()) {
                        this.mrc = this.mrb;
                    }
                }
            }
        }
        this.msN.b(cVar.dataSpec, cVar.type, this.msz, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, dvx, iOException, z2);
        if (z2) {
            this.msM.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mre || this.mqK.isLoading()) {
            return false;
        }
        if (dve()) {
            aVar = null;
            j2 = this.mrc;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.msP.getLast();
            j2 = last.msy;
            aVar = last;
        }
        this.msL.a(aVar, j, j2, this.msO);
        boolean z = this.msO.msI;
        c cVar = this.msO.msH;
        this.msO.clear();
        if (z) {
            this.mrc = -9223372036854775807L;
            this.mre = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mrc = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.msT);
                this.msP.add(aVar2);
            }
            this.msN.b(cVar.dataSpec, cVar.type, this.msz, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, this.mqK.a(cVar, this, this.mqE));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duU() {
        if (dve()) {
            return this.mrc;
        }
        if (this.mre) {
            return Long.MIN_VALUE;
        }
        return this.msP.getLast().msy;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dvB() {
        com.google.android.exoplayer2.source.a.a last = this.msP.getLast();
        if (this.msR.dvi() > last.KN(0)) {
            return true;
        }
        for (int i = 0; i < this.msS.length; i++) {
            if (this.msS[i].dvi() > last.KN(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dve() {
        return this.mrc != -9223372036854775807L;
    }

    private void KO(int i) {
        if (!this.msP.isEmpty()) {
            while (this.msP.size() > 1 && this.msP.get(1).KN(0) <= i) {
                this.msP.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.msP.getFirst();
            Format format = first.msu;
            if (!format.equals(this.msU)) {
                this.msN.b(this.msz, format, first.msv, first.msw, first.msx);
            }
            this.msU = format;
        }
    }

    /* loaded from: classes5.dex */
    public final class a implements p {
        private final int index;
        public final f<T> msV;
        private final o msW;

        public a(f<T> fVar, o oVar, int i) {
            this.msV = fVar;
            this.msW = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mre || (!f.this.dve() && this.msW.dvk());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gg(long j) {
            if (f.this.mre && j > this.msW.dvd()) {
                return this.msW.dvm();
            }
            int a = this.msW.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void duX() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dve()) {
                return -3;
            }
            return this.msW.a(mVar, eVar, z, f.this.mre, f.this.mrb);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.msK[this.index]);
            f.this.msK[this.index] = false;
        }
    }
}
