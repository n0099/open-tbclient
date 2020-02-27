package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long edH;
    private final Object lKi;
    private final com.facebook.imagepipeline.common.b lQA;
    @Nullable
    private final com.facebook.cache.common.b lQB;
    @Nullable
    private final String lQC;
    private final int lQD;
    private final String lQx;
    @Nullable
    private final com.facebook.imagepipeline.common.d lQy;
    private final com.facebook.imagepipeline.common.e lQz;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lQx = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lQy = dVar;
        this.lQz = eVar;
        this.lQA = bVar;
        this.lQB = bVar2;
        this.lQC = str2;
        this.lQD = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lQA, this.lQB, str2);
        this.lKi = obj;
        this.edH = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lQD == cVar.lQD && this.lQx.equals(cVar.lQx) && com.facebook.common.internal.f.equal(this.lQy, cVar.lQy) && com.facebook.common.internal.f.equal(this.lQz, cVar.lQz) && com.facebook.common.internal.f.equal(this.lQA, cVar.lQA) && com.facebook.common.internal.f.equal(this.lQB, cVar.lQB) && com.facebook.common.internal.f.equal(this.lQC, cVar.lQC);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lQD;
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        return djS().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String djS() {
        return this.lQx;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lQx, this.lQy, this.lQz, this.lQA, this.lQB, this.lQC, Integer.valueOf(this.lQD));
    }
}
