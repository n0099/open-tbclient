package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class d implements l, l.a {
    private final l lbk;
    private final long mqj;
    private final long mqk;
    private final boolean mqp;
    private final ArrayList<c> mqq;
    private l.a mqr;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.lbk = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mqj = j;
        this.mqk = j2;
        this.mqp = z;
        this.mqq = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqr = aVar;
        this.lbk.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        this.lbk.duY();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.lbk.a(bVar, bVar2), this.mqp);
        this.mqq.add(cVar);
        cVar.S(this.mqj, this.mqk);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mqq.remove(kVar));
        this.lbk.e(((c) kVar).lYv);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lbk.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mqr.a(this, new a(xVar, this.mqj, this.mqk), obj);
        int size = this.mqq.size();
        for (int i = 0; i < size; i++) {
            this.mqq.get(i).S(this.mqj, this.mqk);
        }
    }

    /* loaded from: classes5.dex */
    private static final class a extends j {
        private final long mqj;
        private final long mqk;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dsl() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dsm() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lYQ : j2;
            if (a.lYQ != -9223372036854775807L) {
                j2 = j2 > a.lYQ ? a.lYQ : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.lZD);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dsq() == 0);
            this.mqj = j;
            this.mqk = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lYQ = this.mqk != -9223372036854775807L ? this.mqk - this.mqj : -9223372036854775807L;
            if (a.lZG != -9223372036854775807L) {
                a.lZG = Math.max(a.lZG, this.mqj);
                a.lZG = this.mqk == -9223372036854775807L ? a.lZG : Math.min(a.lZG, this.mqk);
                a.lZG -= this.mqj;
            }
            long fp = com.google.android.exoplayer2.b.fp(this.mqj);
            if (a.lZB != -9223372036854775807L) {
                a.lZB += fp;
            }
            if (a.lZC != -9223372036854775807L) {
                a.lZC = fp + a.lZC;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lYQ = this.mqk != -9223372036854775807L ? this.mqk - this.mqj : -9223372036854775807L;
            return a;
        }
    }
}
