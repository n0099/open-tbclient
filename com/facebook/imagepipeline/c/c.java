package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long eEh;
    private final Object lTz;
    private final String mae;
    @Nullable
    private final com.facebook.imagepipeline.common.d maf;
    private final com.facebook.imagepipeline.common.e mag;
    private final com.facebook.imagepipeline.common.b mah;
    @Nullable
    private final com.facebook.cache.common.b mai;
    @Nullable
    private final String maj;
    private final int mak;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.mae = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.maf = dVar;
        this.mag = eVar;
        this.mah = bVar;
        this.mai = bVar2;
        this.maj = str2;
        this.mak = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.mah, this.mai, str2);
        this.lTz = obj;
        this.eEh = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mak == cVar.mak && this.mae.equals(cVar.mae) && com.facebook.common.internal.f.equal(this.maf, cVar.maf) && com.facebook.common.internal.f.equal(this.mag, cVar.mag) && com.facebook.common.internal.f.equal(this.mah, cVar.mah) && com.facebook.common.internal.f.equal(this.mai, cVar.mai) && com.facebook.common.internal.f.equal(this.maj, cVar.maj);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mak;
    }

    @Override // com.facebook.cache.common.b
    public boolean E(Uri uri) {
        return dmh().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dmh() {
        return this.mae;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mae, this.maf, this.mag, this.mah, this.mai, this.maj, Integer.valueOf(this.mak));
    }
}
