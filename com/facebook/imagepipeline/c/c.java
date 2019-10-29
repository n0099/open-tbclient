package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object kde;
    private final String kgB;
    @Nullable
    private final com.facebook.imagepipeline.common.c kgC;
    private final com.facebook.imagepipeline.common.d kgD;
    private final com.facebook.imagepipeline.common.a kgE;
    @Nullable
    private final com.facebook.cache.common.b kgF;
    @Nullable
    private final String kgG;
    private final int kgH;
    private final long kgI;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.kgB = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.kgC = cVar;
        this.kgD = dVar;
        this.kgE = aVar;
        this.kgF = bVar;
        this.kgG = str2;
        this.kgH = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.kgE, this.kgF, str2);
        this.kde = obj;
        this.kgI = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.kgH == cVar.kgH && this.kgB.equals(cVar.kgB) && com.facebook.common.internal.f.equal(this.kgC, cVar.kgC) && com.facebook.common.internal.f.equal(this.kgD, cVar.kgD) && com.facebook.common.internal.f.equal(this.kgE, cVar.kgE) && com.facebook.common.internal.f.equal(this.kgF, cVar.kgF) && com.facebook.common.internal.f.equal(this.kgG, cVar.kgG);
        }
        return false;
    }

    public int hashCode() {
        return this.kgH;
    }

    @Override // com.facebook.cache.common.b
    public boolean u(Uri uri) {
        return cBY().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cBY() {
        return this.kgB;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.kgB, this.kgC, this.kgD, this.kgE, this.kgF, this.kgG, Integer.valueOf(this.kgH));
    }
}
