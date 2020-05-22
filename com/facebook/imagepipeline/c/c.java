package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long eSC;
    private final int mHash;
    private final Object mnr;
    private final String mtY;
    @Nullable
    private final com.facebook.imagepipeline.common.d mtZ;
    private final com.facebook.imagepipeline.common.e mua;
    private final com.facebook.imagepipeline.common.b mub;
    @Nullable
    private final com.facebook.cache.common.b muc;
    @Nullable
    private final String mud;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mtY = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.mtZ = dVar;
        this.mua = eVar;
        this.mub = bVar;
        this.muc = bVar2;
        this.mud = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mub, this.muc, str2);
        this.mnr = obj;
        this.eSC = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.mtY.equals(cVar.mtY) && com.facebook.common.internal.f.equal(this.mtZ, cVar.mtZ) && com.facebook.common.internal.f.equal(this.mua, cVar.mua) && com.facebook.common.internal.f.equal(this.mub, cVar.mub) && com.facebook.common.internal.f.equal(this.muc, cVar.muc) && com.facebook.common.internal.f.equal(this.mud, cVar.mud);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dtB().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dtB() {
        return this.mtY;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mtY, this.mtZ, this.mua, this.mub, this.muc, this.mud, Integer.valueOf(this.mHash));
    }
}
