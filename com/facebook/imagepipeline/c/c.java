package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jCi;
    private final String jFE;
    @Nullable
    private final com.facebook.imagepipeline.common.c jFF;
    private final com.facebook.imagepipeline.common.d jFG;
    private final com.facebook.imagepipeline.common.a jFH;
    @Nullable
    private final com.facebook.cache.common.b jFI;
    @Nullable
    private final String jFJ;
    private final int jFK;
    private final long jFL;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jFE = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jFF = cVar;
        this.jFG = dVar;
        this.jFH = aVar;
        this.jFI = bVar;
        this.jFJ = str2;
        this.jFK = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jFH, this.jFI, str2);
        this.jCi = obj;
        this.jFL = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jFK == cVar.jFK && this.jFE.equals(cVar.jFE) && com.facebook.common.internal.f.equal(this.jFF, cVar.jFF) && com.facebook.common.internal.f.equal(this.jFG, cVar.jFG) && com.facebook.common.internal.f.equal(this.jFH, cVar.jFH) && com.facebook.common.internal.f.equal(this.jFI, cVar.jFI) && com.facebook.common.internal.f.equal(this.jFJ, cVar.jFJ);
        }
        return false;
    }

    public int hashCode() {
        return this.jFK;
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jFE;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jFE, this.jFF, this.jFG, this.jFH, this.jFI, this.jFJ, Integer.valueOf(this.jFK));
    }
}
