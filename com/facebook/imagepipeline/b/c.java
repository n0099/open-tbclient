package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class c implements com.facebook.cache.common.b {
    private final long mCacheTime;
    private final int mHash;
    private final Object pqy;
    private final String pwI;
    @Nullable
    private final com.facebook.imagepipeline.common.d pwJ;
    private final com.facebook.imagepipeline.common.e pwK;
    private final com.facebook.imagepipeline.common.b pwL;
    @Nullable
    private final com.facebook.cache.common.b pwM;
    @Nullable
    private final String pwN;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pwI = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pwJ = dVar;
        this.pwK = eVar;
        this.pwL = bVar;
        this.pwM = bVar2;
        this.pwN = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pwL, this.pwM, str2);
        this.pqy = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pwI.equals(cVar.pwI) && com.facebook.common.internal.f.equal(this.pwJ, cVar.pwJ) && com.facebook.common.internal.f.equal(this.pwK, cVar.pwK) && com.facebook.common.internal.f.equal(this.pwL, cVar.pwL) && com.facebook.common.internal.f.equal(this.pwM, cVar.pwM) && com.facebook.common.internal.f.equal(this.pwN, cVar.pwN);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return ept().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String ept() {
        return this.pwI;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pwI, this.pwJ, this.pwK, this.pwL, this.pwM, this.pwN, Integer.valueOf(this.mHash));
    }
}
