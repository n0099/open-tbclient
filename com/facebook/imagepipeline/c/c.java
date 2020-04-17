package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long eEc;
    private final Object lTv;
    private final String lZZ;
    @Nullable
    private final com.facebook.imagepipeline.common.d maa;
    private final com.facebook.imagepipeline.common.e mab;
    private final com.facebook.imagepipeline.common.b mad;
    @Nullable
    private final com.facebook.cache.common.b mae;
    @Nullable
    private final String maf;
    private final int mag;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lZZ = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.maa = dVar;
        this.mab = eVar;
        this.mad = bVar;
        this.mae = bVar2;
        this.maf = str2;
        this.mag = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mad, this.mae, str2);
        this.lTv = obj;
        this.eEc = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mag == cVar.mag && this.lZZ.equals(cVar.lZZ) && com.facebook.common.internal.f.equal(this.maa, cVar.maa) && com.facebook.common.internal.f.equal(this.mab, cVar.mab) && com.facebook.common.internal.f.equal(this.mad, cVar.mad) && com.facebook.common.internal.f.equal(this.mae, cVar.mae) && com.facebook.common.internal.f.equal(this.maf, cVar.maf);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mag;
    }

    @Override // com.facebook.cache.common.b
    public boolean E(Uri uri) {
        return dmk().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dmk() {
        return this.lZZ;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lZZ, this.maa, this.mab, this.mad, this.mae, this.maf, Integer.valueOf(this.mag));
    }
}
