package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, l.a {
    private final l ldO;
    private final long msO;
    private final long msP;
    private final boolean msU;
    private final ArrayList<c> msV;
    private l.a msW;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.ldO = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.msO = j;
        this.msP = j2;
        this.msU = z;
        this.msV = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.msW = aVar;
        this.ldO.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        this.ldO.dwK();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.ldO.a(bVar, bVar2), this.msU);
        this.msV.add(cVar);
        cVar.R(this.msO, this.msP);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.msV.remove(kVar));
        this.ldO.e(((c) kVar).mbc);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.ldO.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.msW.a(this, new a(xVar, this.msO, this.msP), obj);
        int size = this.msV.size();
        for (int i = 0; i < size; i++) {
            this.msV.get(i).R(this.msO, this.msP);
        }
    }

    /* loaded from: classes6.dex */
    private static final class a extends j {
        private final long msO;
        private final long msP;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtZ() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dua() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.mbx : j2;
            if (a.mbx != -9223372036854775807L) {
                j2 = j2 > a.mbx ? a.mbx : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.mck);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dud() == 0);
            this.msO = j;
            this.msP = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.mbx = this.msP != -9223372036854775807L ? this.msP - this.msO : -9223372036854775807L;
            if (a.mcn != -9223372036854775807L) {
                a.mcn = Math.max(a.mcn, this.msO);
                a.mcn = this.msP == -9223372036854775807L ? a.mcn : Math.min(a.mcn, this.msP);
                a.mcn -= this.msO;
            }
            long fo = com.google.android.exoplayer2.b.fo(this.msO);
            if (a.mci != -9223372036854775807L) {
                a.mci += fo;
            }
            if (a.mcj != -9223372036854775807L) {
                a.mcj = fo + a.mcj;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.mbx = this.msP != -9223372036854775807L ? this.msP - this.msO : -9223372036854775807L;
            return a;
        }
    }
}
