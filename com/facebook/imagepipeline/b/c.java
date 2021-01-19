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
    private final Object pqz;
    private final String pwJ;
    @Nullable
    private final com.facebook.imagepipeline.common.d pwK;
    private final com.facebook.imagepipeline.common.e pwL;
    private final com.facebook.imagepipeline.common.b pwM;
    @Nullable
    private final com.facebook.cache.common.b pwN;
    @Nullable
    private final String pwO;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pwJ = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pwK = dVar;
        this.pwL = eVar;
        this.pwM = bVar;
        this.pwN = bVar2;
        this.pwO = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pwM, this.pwN, str2);
        this.pqz = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pwJ.equals(cVar.pwJ) && com.facebook.common.internal.f.equal(this.pwK, cVar.pwK) && com.facebook.common.internal.f.equal(this.pwL, cVar.pwL) && com.facebook.common.internal.f.equal(this.pwM, cVar.pwM) && com.facebook.common.internal.f.equal(this.pwN, cVar.pwN) && com.facebook.common.internal.f.equal(this.pwO, cVar.pwO);
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
        return this.pwJ;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pwJ, this.pwK, this.pwL, this.pwM, this.pwN, this.pwO, Integer.valueOf(this.mHash));
    }
}
