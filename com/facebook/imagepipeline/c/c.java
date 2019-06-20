package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jUo;
    private final String jXI;
    @Nullable
    private final com.facebook.imagepipeline.common.c jXJ;
    private final com.facebook.imagepipeline.common.d jXK;
    private final com.facebook.imagepipeline.common.a jXL;
    @Nullable
    private final com.facebook.cache.common.b jXM;
    @Nullable
    private final String jXN;
    private final int jXO;
    private final long jXP;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jXI = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jXJ = cVar;
        this.jXK = dVar;
        this.jXL = aVar;
        this.jXM = bVar;
        this.jXN = str2;
        this.jXO = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jXL, this.jXM, str2);
        this.jUo = obj;
        this.jXP = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jXO == cVar.jXO && this.jXI.equals(cVar.jXI) && com.facebook.common.internal.f.equal(this.jXJ, cVar.jXJ) && com.facebook.common.internal.f.equal(this.jXK, cVar.jXK) && com.facebook.common.internal.f.equal(this.jXL, cVar.jXL) && com.facebook.common.internal.f.equal(this.jXM, cVar.jXM) && com.facebook.common.internal.f.equal(this.jXN, cVar.jXN);
        }
        return false;
    }

    public int hashCode() {
        return this.jXO;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jXI;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jXI, this.jXJ, this.jXK, this.jXL, this.jXM, this.jXN, Integer.valueOf(this.jXO));
    }
}
