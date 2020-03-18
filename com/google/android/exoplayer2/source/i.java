package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i implements h.c, l {
    private final Handler mas;
    private l.a msW;
    private final e.a mtS;
    private final com.google.android.exoplayer2.extractor.h mtT;
    private final int mtU;
    private long mtV;
    private boolean mtW;
    private final int mtj;
    private final a mtk;
    private final String mtn;
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
        this.mtS = aVar;
        this.mtT = hVar;
        this.mtj = i;
        this.mas = handler;
        this.mtk = aVar2;
        this.mtn = str;
        this.mtU = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.msW = aVar;
        r(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mtS.dzt(), this.mtT.dvr(), this.mtj, this.mas, this.mtk, this, bVar2, this.mtn, this.mtU);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.msW = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void q(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.mtV;
        }
        if (this.mtV != j || this.mtW != z) {
            r(j, z);
        }
    }

    private void r(long j, boolean z) {
        this.mtV = j;
        this.mtW = z;
        this.msW.a(this, new s(this.mtV, this.mtW), null);
    }
}
