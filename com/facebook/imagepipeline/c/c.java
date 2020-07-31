package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes4.dex */
public class c implements com.facebook.cache.common.b {
    private final long fhF;
    private final int mHash;
    private final Object mSJ;
    private final String mZr;
    @Nullable
    private final com.facebook.imagepipeline.common.d mZs;
    private final com.facebook.imagepipeline.common.e mZt;
    private final com.facebook.imagepipeline.common.b mZu;
    @Nullable
    private final com.facebook.cache.common.b mZv;
    @Nullable
    private final String mZw;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mZr = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mZs = dVar;
        this.mZt = eVar;
        this.mZu = bVar;
        this.mZv = bVar2;
        this.mZw = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mZu, this.mZv, str2);
        this.mSJ = obj;
        this.fhF = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mZr.equals(cVar.mZr) && com.facebook.common.internal.f.equal(this.mZs, cVar.mZs) && com.facebook.common.internal.f.equal(this.mZt, cVar.mZt) && com.facebook.common.internal.f.equal(this.mZu, cVar.mZu) && com.facebook.common.internal.f.equal(this.mZv, cVar.mZv) && com.facebook.common.internal.f.equal(this.mZw, cVar.mZw);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dBI().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dBI() {
        return this.mZr;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mZr, this.mZs, this.mZt, this.mZu, this.mZv, this.mZw, Integer.valueOf(this.mHash));
    }
}
