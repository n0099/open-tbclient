package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i implements h.c, l {
    private final Handler lYK;
    private final int mrC;
    private final a mrD;
    private final String mrG;
    private l.a mrp;
    private final e.a msl;
    private final com.google.android.exoplayer2.extractor.h msm;
    private final int msn;
    private long mso;
    private boolean msp;
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
        this.msl = aVar;
        this.msm = hVar;
        this.mrC = i;
        this.lYK = handler;
        this.mrD = aVar2;
        this.mrG = str;
        this.msn = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrp = aVar;
        q(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.msl.dyW(), this.msm.duU(), this.mrC, this.lYK, this.mrD, this, bVar2, this.mrG, this.msn);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mrp = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void p(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.mso;
        }
        if (this.mso != j || this.msp != z) {
            q(j, z);
        }
    }

    private void q(long j, boolean z) {
        this.mso = j;
        this.msp = z;
        this.mrp.a(this, new s(this.mso, this.msp), null);
    }
}
