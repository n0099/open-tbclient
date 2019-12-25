package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class d implements l, l.a {
    private final l kXK;
    private final boolean mmA;
    private final ArrayList<c> mmB;
    private l.a mmC;
    private final long mmu;
    private final long mmv;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.kXK = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mmu = j;
        this.mmv = j2;
        this.mmA = z;
        this.mmB = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mmC = aVar;
        this.kXK.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        this.kXK.dtN();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.kXK.a(bVar, bVar2), this.mmA);
        this.mmB.add(cVar);
        cVar.S(this.mmu, this.mmv);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mmB.remove(kVar));
        this.kXK.e(((c) kVar).lUE);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.kXK.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mmC.a(this, new a(xVar, this.mmu, this.mmv), obj);
        int size = this.mmB.size();
        for (int i = 0; i < size; i++) {
            this.mmB.get(i).S(this.mmu, this.mmv);
        }
    }

    /* loaded from: classes4.dex */
    private static final class a extends j {
        private final long mmu;
        private final long mmv;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dqZ() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dra() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lUZ : j2;
            if (a.lUZ != -9223372036854775807L) {
                j2 = j2 > a.lUZ ? a.lUZ : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.lVO);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dre() == 0);
            this.mmu = j;
            this.mmv = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lUZ = this.mmv != -9223372036854775807L ? this.mmv - this.mmu : -9223372036854775807L;
            if (a.lVR != -9223372036854775807L) {
                a.lVR = Math.max(a.lVR, this.mmu);
                a.lVR = this.mmv == -9223372036854775807L ? a.lVR : Math.min(a.lVR, this.mmv);
                a.lVR -= this.mmu;
            }
            long fk = com.google.android.exoplayer2.b.fk(this.mmu);
            if (a.lVM != -9223372036854775807L) {
                a.lVM += fk;
            }
            if (a.lVN != -9223372036854775807L) {
                a.lVN = fk + a.lVN;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lUZ = this.mmv != -9223372036854775807L ? this.mmv - this.mmu : -9223372036854775807L;
            return a;
        }
    }
}
