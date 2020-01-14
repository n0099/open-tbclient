package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class p<T> implements Loader.c {
    public final g dataSpec;
    private volatile boolean isCanceled;
    private final a<? extends T> mGi;
    private volatile long mGj;
    private final e mdo;
    private volatile T result;
    public final int type;

    /* loaded from: classes5.dex */
    public interface a<T> {
        T b(Uri uri, InputStream inputStream) throws IOException;
    }

    public p(e eVar, Uri uri, int i, a<? extends T> aVar) {
        this(eVar, new g(uri, 1), i, aVar);
    }

    public p(e eVar, g gVar, int i, a<? extends T> aVar) {
        this.mdo = eVar;
        this.dataSpec = gVar;
        this.type = i;
        this.mGi = aVar;
    }

    public final T getResult() {
        return this.result;
    }

    public long dvz() {
        return this.mGj;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.isCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dvh() {
        return this.isCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException {
        f fVar = new f(this.mdo, this.dataSpec);
        try {
            fVar.open();
            this.result = this.mGi.b(this.mdo.getUri(), fVar);
        } finally {
            this.mGj = fVar.dxK();
            v.closeQuietly(fVar);
        }
    }
}
