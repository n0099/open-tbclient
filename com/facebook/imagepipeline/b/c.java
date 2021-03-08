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
    private final Object pDn;
    @Nullable
    private final com.facebook.cache.common.b pJA;
    @Nullable
    private final String pJB;
    private final String pJw;
    @Nullable
    private final com.facebook.imagepipeline.common.d pJx;
    private final com.facebook.imagepipeline.common.e pJy;
    private final com.facebook.imagepipeline.common.b pJz;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pJw = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pJx = dVar;
        this.pJy = eVar;
        this.pJz = bVar;
        this.pJA = bVar2;
        this.pJB = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pJz, this.pJA, str2);
        this.pDn = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pJw.equals(cVar.pJw) && com.facebook.common.internal.f.equal(this.pJx, cVar.pJx) && com.facebook.common.internal.f.equal(this.pJy, cVar.pJy) && com.facebook.common.internal.f.equal(this.pJz, cVar.pJz) && com.facebook.common.internal.f.equal(this.pJA, cVar.pJA) && com.facebook.common.internal.f.equal(this.pJB, cVar.pJB);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return esd().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String esd() {
        return this.pJw;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pJw, this.pJx, this.pJy, this.pJz, this.pJA, this.pJB, Integer.valueOf(this.mHash));
    }
}
