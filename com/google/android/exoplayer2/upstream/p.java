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
    private final a<? extends T> mIL;
    private volatile long mIM;
    private final e mfN;
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
        this.mfN = eVar;
        this.dataSpec = gVar;
        this.type = i;
        this.mIL = aVar;
    }

    public final T getResult() {
        return this.result;
    }

    public long dxj() {
        return this.mIM;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.isCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwR() {
        return this.isCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException {
        f fVar = new f(this.mfN, this.dataSpec);
        try {
            fVar.open();
            this.result = this.mIL.b(this.mfN.getUri(), fVar);
        } finally {
            this.mIM = fVar.dzu();
            v.closeQuietly(fVar);
        }
    }
}
