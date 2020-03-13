package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class m extends a {
    private final int lYj;
    private volatile boolean msf;
    private final Format mtF;
    private volatile int mtZ;
    private volatile boolean mua;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lYj = i3;
        this.mtF = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwS() {
        return this.mua;
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
        try {
            long a = this.meh.a(this.dataSpec.gF(this.mtZ));
            if (a != -1) {
                a += this.mtZ;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.meh, this.mtZ, a);
            b dwK = dwK();
            dwK.gk(0L);
            com.google.android.exoplayer2.extractor.m dK = dwK.dK(0, this.lYj);
            dK.h(this.mtF);
            for (int i = 0; i != -1; i = dK.a(bVar, Integer.MAX_VALUE, true)) {
                this.mtZ = i + this.mtZ;
            }
            dK.a(this.mtv, 1, this.mtZ, 0, null);
            v.a(this.meh);
            this.mua = true;
        } catch (Throwable th) {
            v.a(this.meh);
            throw th;
        }
    }
}
