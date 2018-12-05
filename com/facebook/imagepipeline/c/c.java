package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object ihW;
    private final String ill;
    @Nullable
    private final com.facebook.imagepipeline.common.c ilm;
    private final com.facebook.imagepipeline.common.d iln;
    private final com.facebook.imagepipeline.common.a ilo;
    @Nullable
    private final com.facebook.cache.common.b ilp;
    @Nullable
    private final String ilq;
    private final int ilr;
    private final long ils;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.ill = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ilm = cVar;
        this.iln = dVar;
        this.ilo = aVar;
        this.ilp = bVar;
        this.ilq = str2;
        this.ilr = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.ilo, this.ilp, str2);
        this.ihW = obj;
        this.ils = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ilr == cVar.ilr && this.ill.equals(cVar.ill) && com.facebook.common.internal.f.equal(this.ilm, cVar.ilm) && com.facebook.common.internal.f.equal(this.iln, cVar.iln) && com.facebook.common.internal.f.equal(this.ilo, cVar.ilo) && com.facebook.common.internal.f.equal(this.ilp, cVar.ilp) && com.facebook.common.internal.f.equal(this.ilq, cVar.ilq);
        }
        return false;
    }

    public int hashCode() {
        return this.ilr;
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ill;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ill, this.ilm, this.iln, this.ilo, this.ilp, this.ilq, Integer.valueOf(this.ilr));
    }
}
