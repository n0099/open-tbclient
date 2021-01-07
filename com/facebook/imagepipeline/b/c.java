package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class c implements com.facebook.cache.common.b {
    private final long mCacheTime;
    private final int mHash;
    private final String pBj;
    @Nullable
    private final com.facebook.imagepipeline.common.d pBk;
    private final com.facebook.imagepipeline.common.e pBl;
    private final com.facebook.imagepipeline.common.b pBm;
    @Nullable
    private final com.facebook.cache.common.b pBn;
    @Nullable
    private final String pBo;
    private final Object pva;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pBj = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pBk = dVar;
        this.pBl = eVar;
        this.pBm = bVar;
        this.pBn = bVar2;
        this.pBo = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pBm, this.pBn, str2);
        this.pva = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pBj.equals(cVar.pBj) && com.facebook.common.internal.f.equal(this.pBk, cVar.pBk) && com.facebook.common.internal.f.equal(this.pBl, cVar.pBl) && com.facebook.common.internal.f.equal(this.pBm, cVar.pBm) && com.facebook.common.internal.f.equal(this.pBn, cVar.pBn) && com.facebook.common.internal.f.equal(this.pBo, cVar.pBo);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean L(Uri uri) {
        return etn().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String etn() {
        return this.pBj;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pBj, this.pBk, this.pBl, this.pBm, this.pBn, this.pBo, Integer.valueOf(this.mHash));
    }
}
