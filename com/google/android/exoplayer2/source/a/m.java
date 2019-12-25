package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class m extends a {
    private final int lTu;
    private volatile boolean mns;
    private final Format moR;
    private volatile int mpl;
    private volatile boolean mpm;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lTu = i3;
        this.moR = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dus() {
        return this.mpm;
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
        try {
            long a = this.lZr.a(this.dataSpec.gC(this.mpl));
            if (a != -1) {
                a += this.mpl;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.lZr, this.mpl, a);
            b duk = duk();
            duk.gh(0L);
            com.google.android.exoplayer2.extractor.m dJ = duk.dJ(0, this.lTu);
            dJ.h(this.moR);
            for (int i = 0; i != -1; i = dJ.a(bVar, Integer.MAX_VALUE, true)) {
                this.mpl = i + this.mpl;
            }
            dJ.a(this.moI, 1, this.mpl, 0, null);
            v.a(this.lZr);
            this.mpm = true;
        } catch (Throwable th) {
            v.a(this.lZr);
            throw th;
        }
    }
}
