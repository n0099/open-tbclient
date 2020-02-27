package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i implements h.c, l {
    private final Handler lYx;
    private final e.a mrX;
    private final com.google.android.exoplayer2.extractor.h mrY;
    private final int mrZ;
    private l.a mrc;
    private final int mrp;
    private final a mrq;
    private final String mrt;
    private long msa;
    private boolean msb;
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
        this.mrX = aVar;
        this.mrY = hVar;
        this.mrp = i;
        this.lYx = handler;
        this.mrq = aVar2;
        this.mrt = str;
        this.mrZ = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrc = aVar;
        q(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mrX.dyT(), this.mrY.duR(), this.mrp, this.lYx, this.mrq, this, bVar2, this.mrt, this.mrZ);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mrc = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void p(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.msa;
        }
        if (this.msa != j || this.msb != z) {
            q(j, z);
        }
    }

    private void q(long j, boolean z) {
        this.msa = j;
        this.msb = z;
        this.mrc.a(this, new s(this.msa, this.msb), null);
    }
}
