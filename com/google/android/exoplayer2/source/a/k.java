package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class k extends c {
    private volatile boolean mrU;
    private final d mtN;
    private volatile int mtO;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mtN = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dwL() {
        return this.mtO;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrU = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwt() {
        return this.mrU;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtO);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdW, gF.mFQ, this.mdW.a(gF));
            if (this.mtO == 0) {
                this.mtN.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtN.mrY;
            int i = 0;
            while (i == 0 && !this.mrU) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtO = (int) (bVar.getPosition() - this.dataSpec.mFQ);
        } finally {
            v.a(this.mdW);
        }
    }
}
