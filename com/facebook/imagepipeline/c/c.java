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
    private final Object mKE;
    private final String mRk;
    @Nullable
    private final com.facebook.imagepipeline.common.d mRl;
    private final com.facebook.imagepipeline.common.e mRm;
    private final com.facebook.imagepipeline.common.b mRn;
    @Nullable
    private final com.facebook.cache.common.b mRo;
    @Nullable
    private final String mRp;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mRk = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mRl = dVar;
        this.mRm = eVar;
        this.mRn = bVar;
        this.mRo = bVar2;
        this.mRp = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mRn, this.mRo, str2);
        this.mKE = obj;
        this.fcY = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mRk.equals(cVar.mRk) && com.facebook.common.internal.f.equal(this.mRl, cVar.mRl) && com.facebook.common.internal.f.equal(this.mRm, cVar.mRm) && com.facebook.common.internal.f.equal(this.mRn, cVar.mRn) && com.facebook.common.internal.f.equal(this.mRo, cVar.mRo) && com.facebook.common.internal.f.equal(this.mRp, cVar.mRp);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean H(Uri uri) {
        return dyw().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dyw() {
        return this.mRk;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mRk, this.mRl, this.mRm, this.mRn, this.mRo, this.mRp, Integer.valueOf(this.mHash));
    }
}
