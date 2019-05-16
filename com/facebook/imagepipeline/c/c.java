package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jUk;
    private final String jXE;
    @Nullable
    private final com.facebook.imagepipeline.common.c jXF;
    private final com.facebook.imagepipeline.common.d jXG;
    private final com.facebook.imagepipeline.common.a jXH;
    @Nullable
    private final com.facebook.cache.common.b jXI;
    @Nullable
    private final String jXJ;
    private final int jXK;
    private final long jXL;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jXE = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jXF = cVar;
        this.jXG = dVar;
        this.jXH = aVar;
        this.jXI = bVar;
        this.jXJ = str2;
        this.jXK = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jXH, this.jXI, str2);
        this.jUk = obj;
        this.jXL = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jXK == cVar.jXK && this.jXE.equals(cVar.jXE) && com.facebook.common.internal.f.equal(this.jXF, cVar.jXF) && com.facebook.common.internal.f.equal(this.jXG, cVar.jXG) && com.facebook.common.internal.f.equal(this.jXH, cVar.jXH) && com.facebook.common.internal.f.equal(this.jXI, cVar.jXI) && com.facebook.common.internal.f.equal(this.jXJ, cVar.jXJ);
        }
        return false;
    }

    public int hashCode() {
        return this.jXK;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jXE;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jXE, this.jXF, this.jXG, this.jXH, this.jXI, this.jXJ, Integer.valueOf(this.jXK));
    }
}
