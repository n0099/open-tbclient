package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes9.dex */
public class c implements com.facebook.cache.common.b {
    private final long dZu;
    private final Object lFY;
    private final String lMa;
    @Nullable
    private final com.facebook.imagepipeline.common.d lMb;
    private final com.facebook.imagepipeline.common.e lMc;
    private final com.facebook.imagepipeline.common.b lMd;
    @Nullable
    private final com.facebook.cache.common.b lMe;
    @Nullable
    private final String lMf;
    private final int lMg;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lMa = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lMb = dVar;
        this.lMc = eVar;
        this.lMd = bVar;
        this.lMe = bVar2;
        this.lMf = str2;
        this.lMg = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lMd, this.lMe, str2);
        this.lFY = obj;
        this.dZu = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lMg == cVar.lMg && this.lMa.equals(cVar.lMa) && com.facebook.common.internal.f.equal(this.lMb, cVar.lMb) && com.facebook.common.internal.f.equal(this.lMc, cVar.lMc) && com.facebook.common.internal.f.equal(this.lMd, cVar.lMd) && com.facebook.common.internal.f.equal(this.lMe, cVar.lMe) && com.facebook.common.internal.f.equal(this.lMf, cVar.lMf);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lMg;
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        return dhC().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dhC() {
        return this.lMa;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lMa, this.lMb, this.lMc, this.lMd, this.lMe, this.lMf, Integer.valueOf(this.lMg));
    }
}
