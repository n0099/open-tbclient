package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class i implements h.c, l {
    private final Handler lTV;
    private l.a mmC;
    private final int mmP;
    private final a mmQ;
    private final String mmT;
    private long mnA;
    private boolean mnB;
    private final e.a mnx;
    private final com.google.android.exoplayer2.extractor.h mny;
    private final int mnz;
    private final Uri uri;

    /* loaded from: classes4.dex */
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
        this.mnx = aVar;
        this.mny = hVar;
        this.mmP = i;
        this.lTV = handler;
        this.mmQ = aVar2;
        this.mmT = str;
        this.mnz = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mmC = aVar;
        o(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mnx.dww(), this.mny.dss(), this.mmP, this.lTV, this.mmQ, this, bVar2, this.mmT, this.mnz);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mmC = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void n(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.mnA;
        }
        if (this.mnA != j || this.mnB != z) {
            o(j, z);
        }
    }

    private void o(long j, boolean z) {
        this.mnA = j;
        this.mnB = z;
        this.mmC.a(this, new s(this.mnA, this.mnB), null);
    }
}
