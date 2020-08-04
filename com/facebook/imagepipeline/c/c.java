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
    private final Object mSL;
    private final String mZt;
    @Nullable
    private final com.facebook.imagepipeline.common.d mZu;
    private final com.facebook.imagepipeline.common.e mZv;
    private final com.facebook.imagepipeline.common.b mZw;
    @Nullable
    private final com.facebook.cache.common.b mZx;
    @Nullable
    private final String mZy;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mZt = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mZu = dVar;
        this.mZv = eVar;
        this.mZw = bVar;
        this.mZx = bVar2;
        this.mZy = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mZw, this.mZx, str2);
        this.mSL = obj;
        this.fhF = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mZt.equals(cVar.mZt) && com.facebook.common.internal.f.equal(this.mZu, cVar.mZu) && com.facebook.common.internal.f.equal(this.mZv, cVar.mZv) && com.facebook.common.internal.f.equal(this.mZw, cVar.mZw) && com.facebook.common.internal.f.equal(this.mZx, cVar.mZx) && com.facebook.common.internal.f.equal(this.mZy, cVar.mZy);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dBJ().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dBJ() {
        return this.mZt;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mZt, this.mZu, this.mZv, this.mZw, this.mZx, this.mZy, Integer.valueOf(this.mHash));
    }
}
