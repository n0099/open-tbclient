package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class c implements com.facebook.cache.common.b {
    private final long mCacheTime;
    private final int mHash;
    private final Object pBi;
    private final String pHr;
    @Nullable
    private final com.facebook.imagepipeline.common.d pHs;
    private final com.facebook.imagepipeline.common.e pHt;
    private final com.facebook.imagepipeline.common.b pHu;
    @Nullable
    private final com.facebook.cache.common.b pHv;
    @Nullable
    private final String pHw;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pHr = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pHs = dVar;
        this.pHt = eVar;
        this.pHu = bVar;
        this.pHv = bVar2;
        this.pHw = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pHu, this.pHv, str2);
        this.pBi = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pHr.equals(cVar.pHr) && com.facebook.common.internal.f.equal(this.pHs, cVar.pHs) && com.facebook.common.internal.f.equal(this.pHt, cVar.pHt) && com.facebook.common.internal.f.equal(this.pHu, cVar.pHu) && com.facebook.common.internal.f.equal(this.pHv, cVar.pHv) && com.facebook.common.internal.f.equal(this.pHw, cVar.pHw);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return erU().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String erU() {
        return this.pHr;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pHr, this.pHs, this.pHt, this.pHu, this.pHv, this.pHw, Integer.valueOf(this.mHash));
    }
}
