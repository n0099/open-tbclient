package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class i implements h.c, l {
    private final Handler lXR;
    private final int mqJ;
    private final a mqK;
    private final String mqN;
    private l.a mqw;
    private final e.a mrr;
    private final com.google.android.exoplayer2.extractor.h mrs;
    private final int mrt;
    private long mru;
    private boolean mrv;
    private final Uri uri;

    /* loaded from: classes5.dex */
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
        this.mrr = aVar;
        this.mrs = hVar;
        this.mqJ = i;
        this.lXR = handler;
        this.mqK = aVar2;
        this.mqN = str;
        this.mrt = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqw = aVar;
        o(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mrr.dxJ(), this.mrs.dtG(), this.mqJ, this.lXR, this.mqK, this, bVar2, this.mqN, this.mrt);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mqw = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void n(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.mru;
        }
        if (this.mru != j || this.mrv != z) {
            o(j, z);
        }
    }

    private void o(long j, boolean z) {
        this.mru = j;
        this.mrv = z;
        this.mqw.a(this, new s(this.mru, this.mrv), null);
    }
}
