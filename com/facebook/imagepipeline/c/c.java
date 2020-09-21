package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes25.dex */
public class c implements com.facebook.cache.common.b {
    private final long fws;
    private final int mHash;
    private final com.facebook.imagepipeline.common.e nDA;
    private final com.facebook.imagepipeline.common.b nDB;
    @Nullable
    private final com.facebook.cache.common.b nDC;
    @Nullable
    private final String nDD;
    private final String nDy;
    @Nullable
    private final com.facebook.imagepipeline.common.d nDz;
    private final Object nwV;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.nDy = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.nDz = dVar;
        this.nDA = eVar;
        this.nDB = bVar;
        this.nDC = bVar2;
        this.nDD = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.nDB, this.nDC, str2);
        this.nwV = obj;
        this.fws = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.nDy.equals(cVar.nDy) && com.facebook.common.internal.f.equal(this.nDz, cVar.nDz) && com.facebook.common.internal.f.equal(this.nDA, cVar.nDA) && com.facebook.common.internal.f.equal(this.nDB, cVar.nDB) && com.facebook.common.internal.f.equal(this.nDC, cVar.nDC) && com.facebook.common.internal.f.equal(this.nDD, cVar.nDD);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return dRQ().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dRQ() {
        return this.nDy;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.nDy, this.nDz, this.nDA, this.nDB, this.nDC, this.nDD, Integer.valueOf(this.mHash));
    }
}
