package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class p<T> implements Loader.c {
    public final g dataSpec;
    private volatile boolean isCanceled;
    private final a<? extends T> mGQ;
    private volatile long mGR;
    private final e mdW;
    private volatile T result;
    public final int type;

    /* loaded from: classes6.dex */
    public interface a<T> {
        T b(Uri uri, InputStream inputStream) throws IOException;
    }

    public p(e eVar, Uri uri, int i, a<? extends T> aVar) {
        this(eVar, new g(uri, 1), i, aVar);
    }

    public p(e eVar, g gVar, int i, a<? extends T> aVar) {
        this.mdW = eVar;
        this.dataSpec = gVar;
        this.type = i;
        this.mGQ = aVar;
    }

    public final T getResult() {
        return this.result;
    }

    public long dwL() {
        return this.mGR;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.isCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwt() {
        return this.isCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException {
        f fVar = new f(this.mdW, this.dataSpec);
        try {
            fVar.open();
            this.result = this.mGQ.b(this.mdW.getUri(), fVar);
        } finally {
            this.mGR = fVar.dyW();
            v.closeQuietly(fVar);
        }
    }
}
