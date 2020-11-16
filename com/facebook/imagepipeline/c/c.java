package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class c implements com.facebook.cache.common.b {
    private final long fWt;
    private final int mHash;
    private final Object oOE;
    private final String oVf;
    @Nullable
    private final com.facebook.imagepipeline.common.d oVg;
    private final com.facebook.imagepipeline.common.e oVh;
    private final com.facebook.imagepipeline.common.b oVi;
    @Nullable
    private final com.facebook.cache.common.b oVj;
    @Nullable
    private final String oVk;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.oVf = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.oVg = dVar;
        this.oVh = eVar;
        this.oVi = bVar;
        this.oVj = bVar2;
        this.oVk = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.oVi, this.oVj, str2);
        this.oOE = obj;
        this.fWt = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.oVf.equals(cVar.oVf) && com.facebook.common.internal.f.equal(this.oVg, cVar.oVg) && com.facebook.common.internal.f.equal(this.oVh, cVar.oVh) && com.facebook.common.internal.f.equal(this.oVi, cVar.oVi) && com.facebook.common.internal.f.equal(this.oVj, cVar.oVj) && com.facebook.common.internal.f.equal(this.oVk, cVar.oVk);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean J(Uri uri) {
        return ejm().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String ejm() {
        return this.oVf;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.oVf, this.oVg, this.oVh, this.oVi, this.oVj, this.oVk, Integer.valueOf(this.mHash));
    }
}
