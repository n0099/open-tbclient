package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i extends a {
    private volatile boolean mrm;
    private final long msh;
    private final int mtd;
    private final d mte;
    private volatile int mtf;
    private volatile boolean mtg;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mtd = i3;
        this.msh = j3;
        this.mte = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dvE() {
        return this.mth + this.mtd;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvF() {
        return this.mtg;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dvz() {
        return this.mtf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mrm = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dvh() {
        return this.mrm;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gH = this.dataSpec.gH(this.mtf);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdo, gH.mFi, this.mdo.a(gH));
            if (this.mtf == 0) {
                b dvx = dvx();
                dvx.gm(this.msh);
                this.mte.a(dvx);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mte.mrq;
            int i = 0;
            while (i == 0 && !this.mrm) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtf = (int) (bVar.getPosition() - this.dataSpec.mFi);
            v.a(this.mdo);
            this.mtg = true;
        } catch (Throwable th) {
            v.a(this.mdo);
            throw th;
        }
    }
}
