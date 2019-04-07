package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object jBu;
    private final String jEQ;
    @Nullable
    private final com.facebook.imagepipeline.common.c jER;
    private final com.facebook.imagepipeline.common.d jES;
    private final com.facebook.imagepipeline.common.a jET;
    @Nullable
    private final com.facebook.cache.common.b jEU;
    @Nullable
    private final String jEV;
    private final int jEW;
    private final long jEX;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.jEQ = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.jER = cVar;
        this.jES = dVar;
        this.jET = aVar;
        this.jEU = bVar;
        this.jEV = str2;
        this.jEW = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.jET, this.jEU, str2);
        this.jBu = obj;
        this.jEX = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.jEW == cVar.jEW && this.jEQ.equals(cVar.jEQ) && com.facebook.common.internal.f.equal(this.jER, cVar.jER) && com.facebook.common.internal.f.equal(this.jES, cVar.jES) && com.facebook.common.internal.f.equal(this.jET, cVar.jET) && com.facebook.common.internal.f.equal(this.jEU, cVar.jEU) && com.facebook.common.internal.f.equal(this.jEV, cVar.jEV);
        }
        return false;
    }

    public int hashCode() {
        return this.jEW;
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jEQ;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.jEQ, this.jER, this.jES, this.jET, this.jEU, this.jEV, Integer.valueOf(this.jEW));
    }
}
