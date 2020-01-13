package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class k extends c {
    private volatile boolean mrh;
    private final d msZ;
    private volatile int mta;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.msZ = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dvx() {
        return this.mta;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrh = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dvf() {
        return this.mrh;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gH = this.dataSpec.gH(this.mta);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdj, gH.mFc, this.mdj.a(gH));
            if (this.mta == 0) {
                this.msZ.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.msZ.mrl;
            int i = 0;
            while (i == 0 && !this.mrh) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mta = (int) (bVar.getPosition() - this.dataSpec.mFc);
        } finally {
            v.a(this.mdj);
        }
    }
}
