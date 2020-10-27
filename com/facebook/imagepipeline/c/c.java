package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class c implements com.facebook.cache.common.b {
    private final long fQW;
    private final int mHash;
    private final Object oDH;
    private final String oKj;
    @Nullable
    private final com.facebook.imagepipeline.common.d oKk;
    private final com.facebook.imagepipeline.common.e oKl;
    private final com.facebook.imagepipeline.common.b oKm;
    @Nullable
    private final com.facebook.cache.common.b oKn;
    @Nullable
    private final String oKo;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.oKj = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.oKk = dVar;
        this.oKl = eVar;
        this.oKm = bVar;
        this.oKn = bVar2;
        this.oKo = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.oKm, this.oKn, str2);
        this.oDH = obj;
        this.fQW = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.oKj.equals(cVar.oKj) && com.facebook.common.internal.f.equal(this.oKk, cVar.oKk) && com.facebook.common.internal.f.equal(this.oKl, cVar.oKl) && com.facebook.common.internal.f.equal(this.oKm, cVar.oKm) && com.facebook.common.internal.f.equal(this.oKn, cVar.oKn) && com.facebook.common.internal.f.equal(this.oKo, cVar.oKo);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return efz().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String efz() {
        return this.oKj;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.oKj, this.oKk, this.oKl, this.oKm, this.oKn, this.oKo, Integer.valueOf(this.mHash));
    }
}
