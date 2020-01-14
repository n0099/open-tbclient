package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class k extends c {
    private volatile boolean mrm;
    private final d mte;
    private volatile int mtf;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mte = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dvz() {
        return this.mtf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrm = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dvh() {
        return this.mrm;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gH = this.dataSpec.gH(this.mtf);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdo, gH.mFi, this.mdo.a(gH));
            if (this.mtf == 0) {
                this.mte.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mte.mrq;
            int i = 0;
            while (i == 0 && !this.mrm) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtf = (int) (bVar.getPosition() - this.dataSpec.mFi);
        } finally {
            v.a(this.mdo);
        }
    }
}
