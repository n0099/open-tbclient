package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class d implements l, l.a {
    private final l lbp;
    private final long mqo;
    private final long mqp;
    private final boolean mqu;
    private final ArrayList<c> mqv;
    private l.a mqw;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.lbp = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mqo = j;
        this.mqp = j2;
        this.mqu = z;
        this.mqv = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqw = aVar;
        this.lbp.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        this.lbp.dva();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.lbp.a(bVar, bVar2), this.mqu);
        this.mqv.add(cVar);
        cVar.S(this.mqo, this.mqp);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mqv.remove(kVar));
        this.lbp.e(((c) kVar).lYA);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lbp.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mqw.a(this, new a(xVar, this.mqo, this.mqp), obj);
        int size = this.mqv.size();
        for (int i = 0; i < size; i++) {
            this.mqv.get(i).S(this.mqo, this.mqp);
        }
    }

    /* loaded from: classes5.dex */
    private static final class a extends j {
        private final long mqo;
        private final long mqp;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dsn() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dso() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lYV : j2;
            if (a.lYV != -9223372036854775807L) {
                j2 = j2 > a.lYV ? a.lYV : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.lZI);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dss() == 0);
            this.mqo = j;
            this.mqp = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lYV = this.mqp != -9223372036854775807L ? this.mqp - this.mqo : -9223372036854775807L;
            if (a.lZL != -9223372036854775807L) {
                a.lZL = Math.max(a.lZL, this.mqo);
                a.lZL = this.mqp == -9223372036854775807L ? a.lZL : Math.min(a.lZL, this.mqp);
                a.lZL -= this.mqo;
            }
            long fp = com.google.android.exoplayer2.b.fp(this.mqo);
            if (a.lZG != -9223372036854775807L) {
                a.lZG += fp;
            }
            if (a.lZH != -9223372036854775807L) {
                a.lZH = fp + a.lZH;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lYV = this.mqp != -9223372036854775807L ? this.mqp - this.mqo : -9223372036854775807L;
            return a;
        }
    }
}
