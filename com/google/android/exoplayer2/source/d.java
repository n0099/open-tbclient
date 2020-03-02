package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, l.a {
    private final l lbX;
    private final long mqW;
    private final long mqX;
    private final boolean mrc;
    private final ArrayList<c> mrd;
    private l.a mre;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.lbX = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mqW = j;
        this.mqX = j2;
        this.mrc = z;
        this.mrd = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mre = aVar;
        this.lbX.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        this.lbX.dwm();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.lbX.a(bVar, bVar2), this.mrc);
        this.mrd.add(cVar);
        cVar.R(this.mqW, this.mqX);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mrd.remove(kVar));
        this.lbX.e(((c) kVar).lZi);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lbX.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mre.a(this, new a(xVar, this.mqW, this.mqX), obj);
        int size = this.mrd.size();
        for (int i = 0; i < size; i++) {
            this.mrd.get(i).R(this.mqW, this.mqX);
        }
    }

    /* loaded from: classes6.dex */
    private static final class a extends j {
        private final long mqW;
        private final long mqX;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtB() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtC() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lZD : j2;
            if (a.lZD != -9223372036854775807L) {
                j2 = j2 > a.lZD ? a.lZD : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.mas);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dtF() == 0);
            this.mqW = j;
            this.mqX = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lZD = this.mqX != -9223372036854775807L ? this.mqX - this.mqW : -9223372036854775807L;
            if (a.mav != -9223372036854775807L) {
                a.mav = Math.max(a.mav, this.mqW);
                a.mav = this.mqX == -9223372036854775807L ? a.mav : Math.min(a.mav, this.mqX);
                a.mav -= this.mqW;
            }
            long fn = com.google.android.exoplayer2.b.fn(this.mqW);
            if (a.maq != -9223372036854775807L) {
                a.maq += fn;
            }
            if (a.mar != -9223372036854775807L) {
                a.mar = fn + a.mar;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lZD = this.mqX != -9223372036854775807L ? this.mqX - this.mqW : -9223372036854775807L;
            return a;
        }
    }
}
