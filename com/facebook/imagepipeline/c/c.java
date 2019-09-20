package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object keW;
    private final String kir;
    @Nullable
    private final com.facebook.imagepipeline.common.c kis;
    private final com.facebook.imagepipeline.common.d kit;
    private final com.facebook.imagepipeline.common.a kiu;
    @Nullable
    private final com.facebook.cache.common.b kiv;
    @Nullable
    private final String kiw;
    private final int kix;
    private final long kiy;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.kir = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.kis = cVar;
        this.kit = dVar;
        this.kiu = aVar;
        this.kiv = bVar;
        this.kiw = str2;
        this.kix = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.kiu, this.kiv, str2);
        this.keW = obj;
        this.kiy = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.kix == cVar.kix && this.kir.equals(cVar.kir) && com.facebook.common.internal.f.equal(this.kis, cVar.kis) && com.facebook.common.internal.f.equal(this.kit, cVar.kit) && com.facebook.common.internal.f.equal(this.kiu, cVar.kiu) && com.facebook.common.internal.f.equal(this.kiv, cVar.kiv) && com.facebook.common.internal.f.equal(this.kiw, cVar.kiw);
        }
        return false;
    }

    public int hashCode() {
        return this.kix;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return cFa().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cFa() {
        return this.kir;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.kir, this.kis, this.kit, this.kiu, this.kiv, this.kiw, Integer.valueOf(this.kix));
    }
}
