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
    private final Object puT;
    private final String pzC;
    @Nullable
    private final com.facebook.imagepipeline.common.d pzD;
    private final com.facebook.imagepipeline.common.e pzE;
    private final com.facebook.imagepipeline.common.b pzF;
    @Nullable
    private final com.facebook.cache.common.b pzG;
    @Nullable
    private final String pzH;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pzC = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pzD = dVar;
        this.pzE = eVar;
        this.pzF = bVar;
        this.pzG = bVar2;
        this.pzH = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pzF, this.pzG, str2);
        this.puT = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pzC.equals(cVar.pzC) && com.facebook.common.internal.f.equal(this.pzD, cVar.pzD) && com.facebook.common.internal.f.equal(this.pzE, cVar.pzE) && com.facebook.common.internal.f.equal(this.pzF, cVar.pzF) && com.facebook.common.internal.f.equal(this.pzG, cVar.pzG) && com.facebook.common.internal.f.equal(this.pzH, cVar.pzH);
        }
        return false;
    }

    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean L(Uri uri) {
        return etj().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String etj() {
        return this.pzC;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pzC, this.pzD, this.pzE, this.pzF, this.pzG, this.pzH, Integer.valueOf(this.mHash));
    }
}
