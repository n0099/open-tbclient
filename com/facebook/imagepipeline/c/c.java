package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jCa;
    @Nullable
    private final com.facebook.cache.common.b jFA;
    @Nullable
    private final String jFB;
    private final int jFC;
    private final long jFD;
    private final String jFw;
    @Nullable
    private final com.facebook.imagepipeline.common.c jFx;
    private final com.facebook.imagepipeline.common.d jFy;
    private final com.facebook.imagepipeline.common.a jFz;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jFw = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jFx = cVar;
        this.jFy = dVar;
        this.jFz = aVar;
        this.jFA = bVar;
        this.jFB = str2;
        this.jFC = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jFz, this.jFA, str2);
        this.jCa = obj;
        this.jFD = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jFC == cVar.jFC && this.jFw.equals(cVar.jFw) && com.facebook.common.internal.f.equal(this.jFx, cVar.jFx) && com.facebook.common.internal.f.equal(this.jFy, cVar.jFy) && com.facebook.common.internal.f.equal(this.jFz, cVar.jFz) && com.facebook.common.internal.f.equal(this.jFA, cVar.jFA) && com.facebook.common.internal.f.equal(this.jFB, cVar.jFB);
        }
        return false;
    }

    public int hashCode() {
        return this.jFC;
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jFw;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jFw, this.jFx, this.jFy, this.jFz, this.jFA, this.jFB, Integer.valueOf(this.jFC));
    }
}
