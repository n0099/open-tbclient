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
    long mtH;
    private long mtI;
    boolean mtK;
    private final int mtj;
    private final int mve;
    private final int[] mvo;
    private final boolean[] mvp;
    private final T mvq;
    private final q.a<f<T>> mvr;
    private final b.a mvs;
    private final o mvw;
    private final o[] mvx;
    private final b mvy;
    private Format mvz;
    private final Loader mtp = new Loader("Loader:ChunkSampleStream");
    private final e mvt = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> mvu = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> mvv = Collections.unmodifiableList(this.mvu);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.mve = i;
        this.mvo = iArr;
        this.mvq = t;
        this.mvr = aVar;
        this.mvs = aVar2;
        this.mtj = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.mvx = new o[length];
        this.mvp = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.mvw = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.mvw;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.mvx[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mvy = new b(iArr2, oVarArr);
        this.mtI = j;
        this.mtH = j;
    }

    public void gn(long j) {
        for (int i = 0; i < this.mvx.length; i++) {
            this.mvx[i].c(j, true, this.mvp[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.mvx.length; i2++) {
            if (this.mvo[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.mvp[i2] ? false : true);
                this.mvp[i2] = true;
                this.mvx[i2].rewind();
                this.mvx[i2].a(j, true, true);
                return new a(this, this.mvx[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dxm() {
        return this.mvq;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwF() {
        if (this.mtK) {
            return Long.MIN_VALUE;
        }
        if (dwQ()) {
            return this.mtI;
        }
        long j = this.mtH;
        com.google.android.exoplayer2.source.a.a last = this.mvu.getLast();
        if (!last.dxp()) {
            last = this.mvu.size() > 1 ? this.mvu.get(this.mvu.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.mvd) : j, this.mvw.dwP());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void go(long j) {
        boolean z;
        o[] oVarArr;
        this.mtH = j;
        if (!dwQ()) {
            if (this.mvw.a(j, true, j < dwG()) != -1) {
                z = true;
                if (!z) {
                    KZ(this.mvw.dwU());
                    this.mvw.dxc();
                    for (o oVar : this.mvx) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mtI = j;
                this.mtK = false;
                this.mvu.clear();
                if (this.mtp.isLoading()) {
                    this.mtp.cNV();
                    return;
                }
                this.mvw.reset();
                for (o oVar2 : this.mvx) {
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
        if (!this.mtp.a(this)) {
            this.mvw.dxd();
            for (o oVar : this.mvx) {
                oVar.dxd();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwL() {
        this.mvw.reset();
        for (o oVar : this.mvx) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mtK || (!dwQ() && this.mvw.dwW());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwJ() throws IOException {
        this.mtp.dwJ();
        if (!this.mtp.isLoading()) {
            this.mvq.dwJ();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwQ()) {
            return -3;
        }
        KZ(this.mvw.dwU());
        int a2 = this.mvw.a(mVar, eVar, z, this.mtK, this.mtH);
        if (a2 == -4) {
            this.mvw.dxc();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gf(long j) {
        int i = 0;
        if (!dwQ()) {
            if (this.mtK && j > this.mvw.dwP()) {
                i = this.mvw.dwY();
            } else {
                int a2 = this.mvw.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.mvw.dxc();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.mvq.b(cVar);
        this.mvs.c(cVar.dataSpec, cVar.type, this.mve, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, cVar.dxj());
        this.mvr.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.mvs.d(cVar.dataSpec, cVar.type, this.mve, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, cVar.dxj());
        if (!z) {
            this.mvw.reset();
            for (o oVar : this.mvx) {
                oVar.reset();
            }
            this.mvr.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dxj = cVar.dxj();
        boolean a2 = a(cVar);
        boolean z = (dxj != 0 && a2 && dxn()) ? false : true;
        boolean z2 = false;
        if (this.mvq.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.mvu.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.mvw.KR(removeLast.KY(0));
                    for (int i = 0; i < this.mvx.length; i++) {
                        this.mvx[i].KR(removeLast.KY(i + 1));
                    }
                    if (this.mvu.isEmpty()) {
                        this.mtI = this.mtH;
                    }
                }
            }
        }
        this.mvs.b(cVar.dataSpec, cVar.type, this.mve, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, dxj, iOException, z2);
        if (z2) {
            this.mvr.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mtK || this.mtp.isLoading()) {
            return false;
        }
        if (dwQ()) {
            aVar = null;
            j2 = this.mtI;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.mvu.getLast();
            j2 = last.mvd;
            aVar = last;
        }
        this.mvq.a(aVar, j, j2, this.mvt);
        boolean z = this.mvt.mvn;
        c cVar = this.mvt.mvm;
        this.mvt.clear();
        if (z) {
            this.mtI = -9223372036854775807L;
            this.mtK = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mtI = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.mvy);
                this.mvu.add(aVar2);
            }
            this.mvs.b(cVar.dataSpec, cVar.type, this.mve, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, this.mtp.a(cVar, this, this.mtj));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwG() {
        if (dwQ()) {
            return this.mtI;
        }
        if (this.mtK) {
            return Long.MIN_VALUE;
        }
        return this.mvu.getLast().mvd;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean dxn() {
        com.google.android.exoplayer2.source.a.a last = this.mvu.getLast();
        if (this.mvw.dwU() > last.KY(0)) {
            return true;
        }
        for (int i = 0; i < this.mvx.length; i++) {
            if (this.mvx[i].dwU() > last.KY(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dwQ() {
        return this.mtI != -9223372036854775807L;
    }

    private void KZ(int i) {
        if (!this.mvu.isEmpty()) {
            while (this.mvu.size() > 1 && this.mvu.get(1).KY(0) <= i) {
                this.mvu.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.mvu.getFirst();
            Format format = first.muZ;
            if (!format.equals(this.mvz)) {
                this.mvs.b(this.mve, format, first.mva, first.mvb, first.mvc);
            }
            this.mvz = format;
        }
    }

    /* loaded from: classes6.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mvA;
        private final o mvB;

        public a(f<T> fVar, o oVar, int i) {
            this.mvA = fVar;
            this.mvB = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mtK || (!f.this.dwQ() && this.mvB.dwW());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gf(long j) {
            if (f.this.mtK && j > this.mvB.dwP()) {
                return this.mvB.dwY();
            }
            int a = this.mvB.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwJ() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dwQ()) {
                return -3;
            }
            return this.mvB.a(mVar, eVar, z, f.this.mtK, f.this.mtH);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.mvp[this.index]);
            f.this.mvp[this.index] = false;
        }
    }
}
