package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i extends a {
    private volatile boolean mrh;
    private final int msY;
    private final d msZ;
    private final long msb;
    private volatile int mta;
    private volatile boolean mtb;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.msY = i3;
        this.msb = j3;
        this.msZ = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dvC() {
        return this.mtc + this.msY;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvD() {
        return this.mtb;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dvx() {
        return this.mta;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mrh = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dvf() {
        return this.mrh;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gH = this.dataSpec.gH(this.mta);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdj, gH.mFc, this.mdj.a(gH));
            if (this.mta == 0) {
                b dvv = dvv();
                dvv.gm(this.msb);
                this.msZ.a(dvv);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.msZ.mrl;
            int i = 0;
            while (i == 0 && !this.mrh) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mta = (int) (bVar.getPosition() - this.dataSpec.mFc);
            v.a(this.mdj);
            this.mtb = true;
        } catch (Throwable th) {
            v.a(this.mdj);
            throw th;
        }
    }
}
