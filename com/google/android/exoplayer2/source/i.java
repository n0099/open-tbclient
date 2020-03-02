package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i implements h.c, l {
    private final Handler lYz;
    private final e.a mrZ;
    private l.a mre;
    private final int mrr;
    private final a mrs;
    private final String mrv;
    private final com.google.android.exoplayer2.extractor.h msa;
    private final int msb;
    private long msc;
    private boolean msd;
    private final Uri uri;

    /* loaded from: classes6.dex */
    public interface a {
        void a(IOException iOException);
    }

    public i(Uri uri, e.a aVar, com.google.android.exoplayer2.extractor.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    public i(Uri uri, e.a aVar, com.google.android.exoplayer2.extractor.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, -1, handler, aVar2, str, 1048576);
    }

    public i(Uri uri, e.a aVar, com.google.android.exoplayer2.extractor.h hVar, int i, Handler handler, a aVar2, String str, int i2) {
        this.uri = uri;
        this.mrZ = aVar;
        this.msa = hVar;
        this.mrr = i;
        this.lYz = handler;
        this.mrs = aVar2;
        this.mrv = str;
        this.msb = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mre = aVar;
        q(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mrZ.dyV(), this.msa.duT(), this.mrr, this.lYz, this.mrs, this, bVar2, this.mrv, this.msb);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mre = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void p(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.msc;
        }
        if (this.msc != j || this.msd != z) {
            q(j, z);
        }
    }

    private void q(long j, boolean z) {
        this.msc = j;
        this.msd = z;
        this.mre.a(this, new s(this.msc, this.msd), null);
    }
}
