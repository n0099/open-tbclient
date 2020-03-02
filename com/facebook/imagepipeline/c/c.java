package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long edI;
    private final Object lKk;
    @Nullable
    private final com.facebook.imagepipeline.common.d lQA;
    private final com.facebook.imagepipeline.common.e lQB;
    private final com.facebook.imagepipeline.common.b lQC;
    @Nullable
    private final com.facebook.cache.common.b lQD;
    @Nullable
    private final String lQE;
    private final int lQF;
    private final String lQz;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lQz = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lQA = dVar;
        this.lQB = eVar;
        this.lQC = bVar;
        this.lQD = bVar2;
        this.lQE = str2;
        this.lQF = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lQC, this.lQD, str2);
        this.lKk = obj;
        this.edI = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lQF == cVar.lQF && this.lQz.equals(cVar.lQz) && com.facebook.common.internal.f.equal(this.lQA, cVar.lQA) && com.facebook.common.internal.f.equal(this.lQB, cVar.lQB) && com.facebook.common.internal.f.equal(this.lQC, cVar.lQC) && com.facebook.common.internal.f.equal(this.lQD, cVar.lQD) && com.facebook.common.internal.f.equal(this.lQE, cVar.lQE);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lQF;
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        return djU().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String djU() {
        return this.lQz;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lQz, this.lQA, this.lQB, this.lQC, this.lQD, this.lQE, Integer.valueOf(this.lQF));
    }
}
