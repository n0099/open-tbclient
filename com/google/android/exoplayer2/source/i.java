package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class i implements h.c, l {
    private final Handler lXM;
    private final int mqE;
    private final a mqF;
    private final String mqI;
    private l.a mqr;
    private final e.a mrm;
    private final com.google.android.exoplayer2.extractor.h mrn;
    private final int mro;
    private long mrp;
    private boolean mrq;
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
        this.mrm = aVar;
        this.mrn = hVar;
        this.mqE = i;
        this.lXM = handler;
        this.mqF = aVar2;
        this.mqI = str;
        this.mro = i2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqr = aVar;
        o(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new h(this.uri, this.mrm.dxH(), this.mrn.dtE(), this.mqE, this.lXM, this.mqF, this, bVar2, this.mqI, this.mro);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((h) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mqr = null;
    }

    @Override // com.google.android.exoplayer2.source.h.c
    public void n(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.mrp;
        }
        if (this.mrp != j || this.mrq != z) {
            o(j, z);
        }
    }

    private void o(long j, boolean z) {
        this.mrp = j;
        this.mrq = z;
        this.mqr.a(this, new s(this.mrp, this.mrq), null);
    }
}
