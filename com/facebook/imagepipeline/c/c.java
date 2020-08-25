package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class c implements com.facebook.cache.common.b {
    private final long ftc;
    private final int mHash;
    private final Object nmD;
    private final String nti;
    @Nullable
    private final com.facebook.imagepipeline.common.d ntj;
    private final com.facebook.imagepipeline.common.e ntk;
    private final com.facebook.imagepipeline.common.b ntl;
    @Nullable
    private final com.facebook.cache.common.b ntm;
    @Nullable
    private final String ntn;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.nti = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ntj = dVar;
        this.ntk = eVar;
        this.ntl = bVar;
        this.ntm = bVar2;
        this.ntn = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.ntl, this.ntm, str2);
        this.nmD = obj;
        this.ftc = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.nti.equals(cVar.nti) && com.facebook.common.internal.f.equal(this.ntj, cVar.ntj) && com.facebook.common.internal.f.equal(this.ntk, cVar.ntk) && com.facebook.common.internal.f.equal(this.ntl, cVar.ntl) && com.facebook.common.internal.f.equal(this.ntm, cVar.ntm) && com.facebook.common.internal.f.equal(this.ntn, cVar.ntn);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dNJ().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dNJ() {
        return this.nti;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.nti, this.ntj, this.ntk, this.ntl, this.ntm, this.ntn, Integer.valueOf(this.mHash));
    }
}
