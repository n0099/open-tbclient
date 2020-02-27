package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, l.a {
    private final l lbV;
    private final long mqU;
    private final long mqV;
    private final boolean mra;
    private final ArrayList<c> mrb;
    private l.a mrc;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.lbV = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mqU = j;
        this.mqV = j2;
        this.mra = z;
        this.mrb = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrc = aVar;
        this.lbV.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        this.lbV.dwk();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.lbV.a(bVar, bVar2), this.mra);
        this.mrb.add(cVar);
        cVar.R(this.mqU, this.mqV);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mrb.remove(kVar));
        this.lbV.e(((c) kVar).lZg);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lbV.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mrc.a(this, new a(xVar, this.mqU, this.mqV), obj);
        int size = this.mrb.size();
        for (int i = 0; i < size; i++) {
            this.mrb.get(i).R(this.mqU, this.mqV);
        }
    }

    /* loaded from: classes6.dex */
    private static final class a extends j {
        private final long mqU;
        private final long mqV;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtz() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtA() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lZB : j2;
            if (a.lZB != -9223372036854775807L) {
                j2 = j2 > a.lZB ? a.lZB : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.maq);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dtD() == 0);
            this.mqU = j;
            this.mqV = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lZB = this.mqV != -9223372036854775807L ? this.mqV - this.mqU : -9223372036854775807L;
            if (a.mat != -9223372036854775807L) {
                a.mat = Math.max(a.mat, this.mqU);
                a.mat = this.mqV == -9223372036854775807L ? a.mat : Math.min(a.mat, this.mqV);
                a.mat -= this.mqU;
            }
            long fn = com.google.android.exoplayer2.b.fn(this.mqU);
            if (a.man != -9223372036854775807L) {
                a.man += fn;
            }
            if (a.mao != -9223372036854775807L) {
                a.mao = fn + a.mao;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lZB = this.mqV != -9223372036854775807L ? this.mqV - this.mqU : -9223372036854775807L;
            return a;
        }
    }
}
