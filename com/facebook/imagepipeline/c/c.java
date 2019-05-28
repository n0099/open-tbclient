package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jUl;
    private final String jXF;
    @Nullable
    private final com.facebook.imagepipeline.common.c jXG;
    private final com.facebook.imagepipeline.common.d jXH;
    private final com.facebook.imagepipeline.common.a jXI;
    @Nullable
    private final com.facebook.cache.common.b jXJ;
    @Nullable
    private final String jXK;
    private final int jXL;
    private final long jXM;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jXF = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jXG = cVar;
        this.jXH = dVar;
        this.jXI = aVar;
        this.jXJ = bVar;
        this.jXK = str2;
        this.jXL = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jXI, this.jXJ, str2);
        this.jUl = obj;
        this.jXM = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jXL == cVar.jXL && this.jXF.equals(cVar.jXF) && com.facebook.common.internal.f.equal(this.jXG, cVar.jXG) && com.facebook.common.internal.f.equal(this.jXH, cVar.jXH) && com.facebook.common.internal.f.equal(this.jXI, cVar.jXI) && com.facebook.common.internal.f.equal(this.jXJ, cVar.jXJ) && com.facebook.common.internal.f.equal(this.jXK, cVar.jXK);
        }
        return false;
    }

    public int hashCode() {
        return this.jXL;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jXF;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jXF, this.jXG, this.jXH, this.jXI, this.jXJ, this.jXK, Integer.valueOf(this.jXL));
    }
}
