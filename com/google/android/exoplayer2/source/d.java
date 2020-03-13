package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, l.a {
    private final l lcj;
    private final long mrh;
    private final long mri;
    private final boolean mrn;
    private final ArrayList<c> mro;
    private l.a mrp;

    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
    }

    public d(l lVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        this.lcj = (l) com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        this.mrh = j;
        this.mri = j2;
        this.mrn = z;
        this.mro = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrp = aVar;
        this.lcj.a(gVar, false, this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        this.lcj.dwn();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        c cVar = new c(this.lcj.a(bVar, bVar2), this.mrn);
        this.mro.add(cVar);
        cVar.R(this.mrh, this.mri);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mro.remove(kVar));
        this.lcj.e(((c) kVar).lZt);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lcj.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.l.a
    public void a(l lVar, x xVar, Object obj) {
        this.mrp.a(this, new a(xVar, this.mrh, this.mri), obj);
        int size = this.mro.size();
        for (int i = 0; i < size; i++) {
            this.mro.get(i).R(this.mrh, this.mri);
        }
    }

    /* loaded from: classes6.dex */
    private static final class a extends j {
        private final long mrh;
        private final long mri;

        public a(x xVar, long j, long j2) {
            super(xVar);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtC() == 1);
            com.google.android.exoplayer2.util.a.checkArgument(xVar.dtD() == 1);
            x.b a = xVar.a(0, new x.b(), false);
            com.google.android.exoplayer2.util.a.checkArgument(!a.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? a.lZO : j2;
            if (a.lZO != -9223372036854775807L) {
                j2 = j2 > a.lZO ? a.lZO : j2;
                com.google.android.exoplayer2.util.a.checkArgument(j == 0 || a.maE);
                com.google.android.exoplayer2.util.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.util.a.checkArgument(xVar.a(0, new x.a()).dtG() == 0);
            this.mrh = j;
            this.mri = j2;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            x.b a = this.timeline.a(0, bVar, z, j);
            a.lZO = this.mri != -9223372036854775807L ? this.mri - this.mrh : -9223372036854775807L;
            if (a.maH != -9223372036854775807L) {
                a.maH = Math.max(a.maH, this.mrh);
                a.maH = this.mri == -9223372036854775807L ? a.maH : Math.min(a.maH, this.mri);
                a.maH -= this.mrh;
            }
            long fn = com.google.android.exoplayer2.b.fn(this.mrh);
            if (a.maC != -9223372036854775807L) {
                a.maC += fn;
            }
            if (a.maD != -9223372036854775807L) {
                a.maD = fn + a.maD;
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            x.a a = this.timeline.a(0, aVar, z);
            a.lZO = this.mri != -9223372036854775807L ? this.mri - this.mrh : -9223372036854775807L;
            return a;
        }
    }
}
