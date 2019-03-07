package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jBP;
    private final String jFl;
    @Nullable
    private final com.facebook.imagepipeline.common.c jFm;
    private final com.facebook.imagepipeline.common.d jFn;
    private final com.facebook.imagepipeline.common.a jFo;
    @Nullable
    private final com.facebook.cache.common.b jFp;
    @Nullable
    private final String jFq;
    private final int jFr;
    private final long jFs;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jFl = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jFm = cVar;
        this.jFn = dVar;
        this.jFo = aVar;
        this.jFp = bVar;
        this.jFq = str2;
        this.jFr = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jFo, this.jFp, str2);
        this.jBP = obj;
        this.jFs = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jFr == cVar.jFr && this.jFl.equals(cVar.jFl) && com.facebook.common.internal.f.equal(this.jFm, cVar.jFm) && com.facebook.common.internal.f.equal(this.jFn, cVar.jFn) && com.facebook.common.internal.f.equal(this.jFo, cVar.jFo) && com.facebook.common.internal.f.equal(this.jFp, cVar.jFp) && com.facebook.common.internal.f.equal(this.jFq, cVar.jFq);
        }
        return false;
    }

    public int hashCode() {
        return this.jFr;
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jFl;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jFl, this.jFm, this.jFn, this.jFo, this.jFp, this.jFq, Integer.valueOf(this.jFr));
    }
}
