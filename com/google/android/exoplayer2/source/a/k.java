package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class k extends c {
    private volatile boolean msf;
    private final d mtY;
    private volatile int mtZ;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mtY = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dwM() {
        return this.mtZ;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.msf = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwu() {
        return this.msf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtZ);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.meh, gF.mGb, this.meh.a(gF));
            if (this.mtZ == 0) {
                this.mtY.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtY.msk;
            int i = 0;
            while (i == 0 && !this.msf) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtZ = (int) (bVar.getPosition() - this.dataSpec.mGb);
        } finally {
            v.a(this.meh);
        }
    }
}
