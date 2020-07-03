package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long fcY;
    private final int mHash;
    private final Object mKB;
    private final String mRh;
    @Nullable
    private final com.facebook.imagepipeline.common.d mRi;
    private final com.facebook.imagepipeline.common.e mRj;
    private final com.facebook.imagepipeline.common.b mRk;
    @Nullable
    private final com.facebook.cache.common.b mRl;
    @Nullable
    private final String mRm;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mRh = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mRi = dVar;
        this.mRj = eVar;
        this.mRk = bVar;
        this.mRl = bVar2;
        this.mRm = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mRk, this.mRl, str2);
        this.mKB = obj;
        this.fcY = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mRh.equals(cVar.mRh) && com.facebook.common.internal.f.equal(this.mRi, cVar.mRi) && com.facebook.common.internal.f.equal(this.mRj, cVar.mRj) && com.facebook.common.internal.f.equal(this.mRk, cVar.mRk) && com.facebook.common.internal.f.equal(this.mRl, cVar.mRl) && com.facebook.common.internal.f.equal(this.mRm, cVar.mRm);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean H(Uri uri) {
        return dys().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dys() {
        return this.mRh;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mRh, this.mRi, this.mRj, this.mRk, this.mRl, this.mRm, Integer.valueOf(this.mHash));
    }
}
