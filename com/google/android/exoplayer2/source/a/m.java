package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class m extends a {
    private final int lXl;
    private volatile boolean mrh;
    private final Format msG;
    private volatile int mta;
    private volatile boolean mtb;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lXl = i3;
        this.msG = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvD() {
        return this.mtb;
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
        try {
            long a = this.mdj.a(this.dataSpec.gH(this.mta));
            if (a != -1) {
                a += this.mta;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdj, this.mta, a);
            b dvv = dvv();
            dvv.gm(0L);
            com.google.android.exoplayer2.extractor.m dH = dvv.dH(0, this.lXl);
            dH.h(this.msG);
            for (int i = 0; i != -1; i = dH.a(bVar, Integer.MAX_VALUE, true)) {
                this.mta = i + this.mta;
            }
            dH.a(this.msx, 1, this.mta, 0, null);
            v.a(this.mdj);
            this.mtb = true;
        } catch (Throwable th) {
            v.a(this.mdj);
            throw th;
        }
    }
}
