package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object kcy;
    private final String kfT;
    @Nullable
    private final com.facebook.imagepipeline.common.c kfU;
    private final com.facebook.imagepipeline.common.d kfV;
    private final com.facebook.imagepipeline.common.a kfW;
    @Nullable
    private final com.facebook.cache.common.b kfX;
    @Nullable
    private final String kfY;
    private final int kfZ;
    private final long kga;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.kfT = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.kfU = cVar;
        this.kfV = dVar;
        this.kfW = aVar;
        this.kfX = bVar;
        this.kfY = str2;
        this.kfZ = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.kfW, this.kfX, str2);
        this.kcy = obj;
        this.kga = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.kfZ == cVar.kfZ && this.kfT.equals(cVar.kfT) && com.facebook.common.internal.f.equal(this.kfU, cVar.kfU) && com.facebook.common.internal.f.equal(this.kfV, cVar.kfV) && com.facebook.common.internal.f.equal(this.kfW, cVar.kfW) && com.facebook.common.internal.f.equal(this.kfX, cVar.kfX) && com.facebook.common.internal.f.equal(this.kfY, cVar.kfY);
        }
        return false;
    }

    public int hashCode() {
        return this.kfZ;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return cEm().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cEm() {
        return this.kfT;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.kfT, this.kfU, this.kfV, this.kfW, this.kfX, this.kfY, Integer.valueOf(this.kfZ));
    }
}
