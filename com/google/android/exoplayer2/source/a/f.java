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
    private final int mrC;
    long mrZ;
    private long msa;
    boolean msc;
    private final int[] mtI;
    private final boolean[] mtJ;
    private final T mtK;
    private final q.a<f<T>> mtL;
    private final b.a mtM;
    private final o mtQ;
    private final o[] mtR;
    private final b mtS;
    private Format mtT;
    private final int mty;
    private final Loader mrI = new Loader("Loader:ChunkSampleStream");
    private final e mtN = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> mtO = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> mtP = Collections.unmodifiableList(this.mtO);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.mty = i;
        this.mtI = iArr;
        this.mtK = t;
        this.mtL = aVar;
        this.mtM = aVar2;
        this.mrC = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.mtR = new o[length];
        this.mtJ = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.mtQ = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.mtQ;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.mtR[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mtS = new b(iArr2, oVarArr);
        this.msa = j;
        this.mrZ = j;
    }

    public void gm(long j) {
        for (int i = 0; i < this.mtR.length; i++) {
            this.mtR[i].c(j, true, this.mtJ[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.mtR.length; i2++) {
            if (this.mtI[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.mtJ[i2] ? false : true);
                this.mtJ[i2] = true;
                this.mtR[i2].rewind();
                this.mtR[i2].a(j, true, true);
                return new a(this, this.mtR[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dwP() {
        return this.mtK;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwi() {
        if (this.msc) {
            return Long.MIN_VALUE;
        }
        if (dwt()) {
            return this.msa;
        }
        long j = this.mrZ;
        com.google.android.exoplayer2.source.a.a last = this.mtO.getLast();
        if (!last.dwS()) {
            last = this.mtO.size() > 1 ? this.mtO.get(this.mtO.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.mtw) : j, this.mtQ.dws());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gn(long j) {
        boolean z;
        o[] oVarArr;
        this.mrZ = j;
        if (!dwt()) {
            if (this.mtQ.a(j, true, j < dwj()) != -1) {
                z = true;
                if (!z) {
                    KT(this.mtQ.dwx());
                    this.mtQ.dwF();
                    for (o oVar : this.mtR) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.msa = j;
                this.msc = false;
                this.mtO.clear();
                if (this.mrI.isLoading()) {
                    this.mrI.cNB();
                    return;
                }
                this.mtQ.reset();
                for (o oVar2 : this.mtR) {
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
        if (!this.mrI.a(this)) {
            this.mtQ.dwG();
            for (o oVar : this.mtR) {
                oVar.dwG();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwo() {
        this.mtQ.reset();
        for (o oVar : this.mtR) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.msc || (!dwt() && this.mtQ.dwz());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwm() throws IOException {
        this.mrI.dwm();
        if (!this.mrI.isLoading()) {
            this.mtK.dwm();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwt()) {
            return -3;
        }
        KT(this.mtQ.dwx());
        int a2 = this.mtQ.a(mVar, eVar, z, this.msc, this.mrZ);
        if (a2 == -4) {
            this.mtQ.dwF();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int ge(long j) {
        int i = 0;
        if (!dwt()) {
            if (this.msc && j > this.mtQ.dws()) {
                i = this.mtQ.dwB();
            } else {
                int a2 = this.mtQ.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.mtQ.dwF();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.mtK.b(cVar);
        this.mtM.c(cVar.dataSpec, cVar.type, this.mty, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, cVar.dwM());
        this.mtL.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.mtM.d(cVar.dataSpec, cVar.type, this.mty, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, cVar.dwM());
        if (!z) {
            this.mtQ.reset();
            for (o oVar : this.mtR) {
                oVar.reset();
            }
            this.mtL.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dwM = cVar.dwM();
        boolean a2 = a(cVar);
        boolean z = (dwM != 0 && a2 && dwQ()) ? false : true;
        boolean z2 = false;
        if (this.mtK.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.mtO.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.mtQ.KL(removeLast.KS(0));
                    for (int i = 0; i < this.mtR.length; i++) {
                        this.mtR[i].KL(removeLast.KS(i + 1));
                    }
                    if (this.mtO.isEmpty()) {
                        this.msa = this.mrZ;
                    }
                }
            }
        }
        this.mtM.b(cVar.dataSpec, cVar.type, this.mty, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, dwM, iOException, z2);
        if (z2) {
            this.mtL.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.msc || this.mrI.isLoading()) {
            return false;
        }
        if (dwt()) {
            aVar = null;
            j2 = this.msa;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.mtO.getLast();
            j2 = last.mtw;
            aVar = last;
        }
        this.mtK.a(aVar, j, j2, this.mtN);
        boolean z = this.mtN.mtH;
        c cVar = this.mtN.mtG;
        this.mtN.clear();
        if (z) {
            this.msa = -9223372036854775807L;
            this.msc = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.msa = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.mtS);
                this.mtO.add(aVar2);
            }
            this.mtM.b(cVar.dataSpec, cVar.type, this.mty, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, this.mrI.a(cVar, this, this.mrC));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwj() {
        if (dwt()) {
            return this.msa;
        }
        if (this.msc) {
            return Long.MIN_VALUE;
        }
        return this.mtO.getLast().mtw;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dwQ() {
        com.google.android.exoplayer2.source.a.a last = this.mtO.getLast();
        if (this.mtQ.dwx() > last.KS(0)) {
            return true;
        }
        for (int i = 0; i < this.mtR.length; i++) {
            if (this.mtR[i].dwx() > last.KS(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dwt() {
        return this.msa != -9223372036854775807L;
    }

    private void KT(int i) {
        if (!this.mtO.isEmpty()) {
            while (this.mtO.size() > 1 && this.mtO.get(1).KS(0) <= i) {
                this.mtO.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.mtO.getFirst();
            Format format = first.mts;
            if (!format.equals(this.mtT)) {
                this.mtM.b(this.mty, format, first.mtt, first.mtu, first.mtv);
            }
            this.mtT = format;
        }
    }

    /* loaded from: classes6.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mtU;
        private final o mtV;

        public a(f<T> fVar, o oVar, int i) {
            this.mtU = fVar;
            this.mtV = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.msc || (!f.this.dwt() && this.mtV.dwz());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            if (f.this.msc && j > this.mtV.dws()) {
                return this.mtV.dwB();
            }
            int a = this.mtV.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwm() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dwt()) {
                return -3;
            }
            return this.mtV.a(mVar, eVar, z, f.this.msc, f.this.mrZ);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.mtJ[this.index]);
            f.this.mtJ[this.index] = false;
        }
    }
}
