package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class k extends c {
    private volatile boolean mns;
    private final d mpk;
    private volatile int mpl;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mpk = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dum() {
        return this.mpl;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mns = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dtU() {
        return this.mns;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gC = this.dataSpec.gC(this.mpl);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.lZr, gC.mBl, this.lZr.a(gC));
            if (this.mpl == 0) {
                this.mpk.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mpk.mnw;
            int i = 0;
            while (i == 0 && !this.mns) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mpl = (int) (bVar.getPosition() - this.dataSpec.mBl);
        } finally {
            v.a(this.lZr);
        }
    }
}
