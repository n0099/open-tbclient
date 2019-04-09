package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jBv;
    private final String jER;
    @Nullable
    private final com.facebook.imagepipeline.common.c jES;
    private final com.facebook.imagepipeline.common.d jET;
    private final com.facebook.imagepipeline.common.a jEU;
    @Nullable
    private final com.facebook.cache.common.b jEV;
    @Nullable
    private final String jEW;
    private final int jEX;
    private final long jEY;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jER = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jES = cVar;
        this.jET = dVar;
        this.jEU = aVar;
        this.jEV = bVar;
        this.jEW = str2;
        this.jEX = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jEU, this.jEV, str2);
        this.jBv = obj;
        this.jEY = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jEX == cVar.jEX && this.jER.equals(cVar.jER) && com.facebook.common.internal.f.equal(this.jES, cVar.jES) && com.facebook.common.internal.f.equal(this.jET, cVar.jET) && com.facebook.common.internal.f.equal(this.jEU, cVar.jEU) && com.facebook.common.internal.f.equal(this.jEV, cVar.jEV) && com.facebook.common.internal.f.equal(this.jEW, cVar.jEW);
        }
        return false;
    }

    public int hashCode() {
        return this.jEX;
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jER;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jER, this.jES, this.jET, this.jEU, this.jEV, this.jEW, Integer.valueOf(this.jEX));
    }
}
