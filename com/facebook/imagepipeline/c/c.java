package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long eSN;
    private final int mHash;
    private final Object moC;
    private final String mvi;
    @Nullable
    private final com.facebook.imagepipeline.common.d mvj;
    private final com.facebook.imagepipeline.common.e mvk;
    private final com.facebook.imagepipeline.common.b mvl;
    @Nullable
    private final com.facebook.cache.common.b mvm;
    @Nullable
    private final String mvn;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mvi = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mvj = dVar;
        this.mvk = eVar;
        this.mvl = bVar;
        this.mvm = bVar2;
        this.mvn = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mvl, this.mvm, str2);
        this.moC = obj;
        this.eSN = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mvi.equals(cVar.mvi) && com.facebook.common.internal.f.equal(this.mvj, cVar.mvj) && com.facebook.common.internal.f.equal(this.mvk, cVar.mvk) && com.facebook.common.internal.f.equal(this.mvl, cVar.mvl) && com.facebook.common.internal.f.equal(this.mvm, cVar.mvm) && com.facebook.common.internal.f.equal(this.mvn, cVar.mvn);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dtP().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dtP() {
        return this.mvi;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mvi, this.mvj, this.mvk, this.mvl, this.mvm, this.mvn, Integer.valueOf(this.mHash));
    }
}
