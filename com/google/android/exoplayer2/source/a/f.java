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
/* loaded from: classes4.dex */
public class f<T extends g> implements p, q, Loader.a<c>, Loader.d {
    private final int mmP;
    long mnm;
    private long mnn;
    boolean mnp;
    private final int moK;
    private final int[] moU;
    private final boolean[] moV;
    private final T moW;
    private final q.a<f<T>> moX;
    private final b.a moY;
    private final o mpc;
    private final o[] mpd;
    private final b mpe;
    private Format mpf;
    private final Loader mmV = new Loader("Loader:ChunkSampleStream");
    private final e moZ = new e();
    private final LinkedList<com.google.android.exoplayer2.source.a.a> mpa = new LinkedList<>();
    private final List<com.google.android.exoplayer2.source.a.a> mpb = Collections.unmodifiableList(this.mpa);

    public f(int i, int[] iArr, T t, q.a<f<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j, int i2, b.a aVar2) {
        this.moK = i;
        this.moU = iArr;
        this.moW = t;
        this.moX = aVar;
        this.moY = aVar2;
        this.mmP = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.mpd = new o[length];
        this.moV = new boolean[length];
        int[] iArr2 = new int[length + 1];
        o[] oVarArr = new o[length + 1];
        this.mpc = new o(bVar);
        iArr2[0] = i;
        oVarArr[0] = this.mpc;
        for (int i3 = 0; i3 < length; i3++) {
            o oVar = new o(bVar);
            this.mpd[i3] = oVar;
            oVarArr[i3 + 1] = oVar;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mpe = new b(iArr2, oVarArr);
        this.mnn = j;
        this.mnm = j;
    }

    public void gj(long j) {
        for (int i = 0; i < this.mpd.length; i++) {
            this.mpd[i].c(j, true, this.moV[i]);
        }
    }

    public f<T>.a C(long j, int i) {
        for (int i2 = 0; i2 < this.mpd.length; i2++) {
            if (this.moU[i2] == i) {
                com.google.android.exoplayer2.util.a.checkState(this.moV[i2] ? false : true);
                this.moV[i2] = true;
                this.mpd[i2].rewind();
                this.mpd[i2].a(j, true, true);
                return new a(this, this.mpd[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T dup() {
        return this.moW;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dtI() {
        if (this.mnp) {
            return Long.MIN_VALUE;
        }
        if (dtT()) {
            return this.mnn;
        }
        long j = this.mnm;
        com.google.android.exoplayer2.source.a.a last = this.mpa.getLast();
        if (!last.dus()) {
            last = this.mpa.size() > 1 ? this.mpa.get(this.mpa.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.moJ) : j, this.mpc.dtS());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gk(long j) {
        boolean z;
        o[] oVarArr;
        this.mnm = j;
        if (!dtT()) {
            if (this.mpc.a(j, true, j < dtJ()) != -1) {
                z = true;
                if (!z) {
                    KF(this.mpc.dtX());
                    this.mpc.duf();
                    for (o oVar : this.mpd) {
                        oVar.rewind();
                        oVar.c(j, true, false);
                    }
                    return;
                }
                this.mnn = j;
                this.mnp = false;
                this.mpa.clear();
                if (this.mmV.isLoading()) {
                    this.mmV.cKW();
                    return;
                }
                this.mpc.reset();
                for (o oVar2 : this.mpd) {
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
        if (!this.mmV.a(this)) {
            this.mpc.dug();
            for (o oVar : this.mpd) {
                oVar.dug();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dtO() {
        this.mpc.reset();
        for (o oVar : this.mpd) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mnp || (!dtT() && this.mpc.dtZ());
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dtM() throws IOException {
        this.mmV.dtM();
        if (!this.mmV.isLoading()) {
            this.moW.dtM();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dtT()) {
            return -3;
        }
        KF(this.mpc.dtX());
        int a2 = this.mpc.a(mVar, eVar, z, this.mnp, this.mnm);
        if (a2 == -4) {
            this.mpc.duf();
            return a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gb(long j) {
        int i = 0;
        if (!dtT()) {
            if (this.mnp && j > this.mpc.dtS()) {
                i = this.mpc.dub();
            } else {
                int a2 = this.mpc.a(j, true, true);
                if (a2 != -1) {
                    i = a2;
                }
            }
            if (i > 0) {
                this.mpc.duf();
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2) {
        this.moW.b(cVar);
        this.moY.c(cVar.dataSpec, cVar.type, this.moK, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, cVar.dum());
        this.moX.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.moY.d(cVar.dataSpec, cVar.type, this.moK, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, cVar.dum());
        if (!z) {
            this.mpc.reset();
            for (o oVar : this.mpd) {
                oVar.reset();
            }
            this.moX.a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        long dum = cVar.dum();
        boolean a2 = a(cVar);
        boolean z = (dum != 0 && a2 && duq()) ? false : true;
        boolean z2 = false;
        if (this.moW.a(cVar, z, iOException)) {
            if (!z) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                z2 = true;
                if (a2) {
                    com.google.android.exoplayer2.source.a.a removeLast = this.mpa.removeLast();
                    com.google.android.exoplayer2.util.a.checkState(removeLast == cVar);
                    this.mpc.Kx(removeLast.KE(0));
                    for (int i = 0; i < this.mpd.length; i++) {
                        this.mpd[i].Kx(removeLast.KE(i + 1));
                    }
                    if (this.mpa.isEmpty()) {
                        this.mnn = this.mnm;
                    }
                }
            }
        }
        this.moY.b(cVar.dataSpec, cVar.type, this.moK, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, dum, iOException, z2);
        if (z2) {
            this.moX.a(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        long j2;
        com.google.android.exoplayer2.source.a.a aVar;
        if (this.mnp || this.mmV.isLoading()) {
            return false;
        }
        if (dtT()) {
            aVar = null;
            j2 = this.mnn;
        } else {
            com.google.android.exoplayer2.source.a.a last = this.mpa.getLast();
            j2 = last.moJ;
            aVar = last;
        }
        this.moW.a(aVar, j, j2, this.moZ);
        boolean z = this.moZ.moT;
        c cVar = this.moZ.moS;
        this.moZ.clear();
        if (z) {
            this.mnn = -9223372036854775807L;
            this.mnp = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.mnn = -9223372036854775807L;
                com.google.android.exoplayer2.source.a.a aVar2 = (com.google.android.exoplayer2.source.a.a) cVar;
                aVar2.a(this.mpe);
                this.mpa.add(aVar2);
            }
            this.moY.b(cVar.dataSpec, cVar.type, this.moK, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, this.mmV.a(cVar, this, this.mmP));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dtJ() {
        if (dtT()) {
            return this.mnn;
        }
        if (this.mnp) {
            return Long.MIN_VALUE;
        }
        return this.mpa.getLast().moJ;
    }

    private boolean a(c cVar) {
        return cVar instanceof com.google.android.exoplayer2.source.a.a;
    }

    private boolean duq() {
        com.google.android.exoplayer2.source.a.a last = this.mpa.getLast();
        if (this.mpc.dtX() > last.KE(0)) {
            return true;
        }
        for (int i = 0; i < this.mpd.length; i++) {
            if (this.mpd[i].dtX() > last.KE(i + 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dtT() {
        return this.mnn != -9223372036854775807L;
    }

    private void KF(int i) {
        if (!this.mpa.isEmpty()) {
            while (this.mpa.size() > 1 && this.mpa.get(1).KE(0) <= i) {
                this.mpa.removeFirst();
            }
            com.google.android.exoplayer2.source.a.a first = this.mpa.getFirst();
            Format format = first.moF;
            if (!format.equals(this.mpf)) {
                this.moY.b(this.moK, format, first.moG, first.moH, first.moI);
            }
            this.mpf = format;
        }
    }

    /* loaded from: classes4.dex */
    public final class a implements p {
        private final int index;
        public final f<T> mpg;
        private final o mph;

        public a(f<T> fVar, o oVar, int i) {
            this.mpg = fVar;
            this.mph = oVar;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return f.this.mnp || (!f.this.dtT() && this.mph.dtZ());
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gb(long j) {
            if (f.this.mnp && j > this.mph.dtS()) {
                return this.mph.dub();
            }
            int a = this.mph.a(j, true, true);
            if (a == -1) {
                return 0;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dtM() throws IOException {
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (f.this.dtT()) {
                return -3;
            }
            return this.mph.a(mVar, eVar, z, f.this.mnp, f.this.mnm);
        }

        public void release() {
            com.google.android.exoplayer2.util.a.checkState(f.this.moV[this.index]);
            f.this.moV[this.index] = false;
        }
    }
}
