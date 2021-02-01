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
    private final Object pAI;
    private final String pGR;
    @Nullable
    private final com.facebook.imagepipeline.common.d pGS;
    private final com.facebook.imagepipeline.common.e pGT;
    private final com.facebook.imagepipeline.common.b pGU;
    @Nullable
    private final com.facebook.cache.common.b pGV;
    @Nullable
    private final String pGW;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pGR = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pGS = dVar;
        this.pGT = eVar;
        this.pGU = bVar;
        this.pGV = bVar2;
        this.pGW = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pGU, this.pGV, str2);
        this.pAI = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pGR.equals(cVar.pGR) && com.facebook.common.internal.f.equal(this.pGS, cVar.pGS) && com.facebook.common.internal.f.equal(this.pGT, cVar.pGT) && com.facebook.common.internal.f.equal(this.pGU, cVar.pGU) && com.facebook.common.internal.f.equal(this.pGV, cVar.pGV) && com.facebook.common.internal.f.equal(this.pGW, cVar.pGW);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return erM().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String erM() {
        return this.pGR;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pGR, this.pGS, this.pGT, this.pGU, this.pGV, this.pGW, Integer.valueOf(this.mHash));
    }
}
