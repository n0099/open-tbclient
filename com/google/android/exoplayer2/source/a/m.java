package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class m extends a {
    private final int lXq;
    private volatile boolean mrm;
    private final Format msL;
    private volatile int mtf;
    private volatile boolean mtg;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lXq = i3;
        this.msL = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvF() {
        return this.mtg;
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
        try {
            long a = this.mdo.a(this.dataSpec.gH(this.mtf));
            if (a != -1) {
                a += this.mtf;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdo, this.mtf, a);
            b dvx = dvx();
            dvx.gm(0L);
            com.google.android.exoplayer2.extractor.m dH = dvx.dH(0, this.lXq);
            dH.h(this.msL);
            for (int i = 0; i != -1; i = dH.a(bVar, Integer.MAX_VALUE, true)) {
                this.mtf = i + this.mtf;
            }
            dH.a(this.msC, 1, this.mtf, 0, null);
            v.a(this.mdo);
            this.mtg = true;
        } catch (Throwable th) {
            v.a(this.mdo);
            throw th;
        }
    }
}
