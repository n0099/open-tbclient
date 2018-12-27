package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object ilg;
    private final com.facebook.imagepipeline.common.a ioA;
    @Nullable
    private final com.facebook.cache.common.b ioB;
    @Nullable
    private final String ioC;
    private final int ioD;
    private final long ioE;
    private final String iox;
    @Nullable
    private final com.facebook.imagepipeline.common.c ioy;
    private final com.facebook.imagepipeline.common.d ioz;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.iox = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ioy = cVar;
        this.ioz = dVar;
        this.ioA = aVar;
        this.ioB = bVar;
        this.ioC = str2;
        this.ioD = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.ioA, this.ioB, str2);
        this.ilg = obj;
        this.ioE = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ioD == cVar.ioD && this.iox.equals(cVar.iox) && com.facebook.common.internal.f.equal(this.ioy, cVar.ioy) && com.facebook.common.internal.f.equal(this.ioz, cVar.ioz) && com.facebook.common.internal.f.equal(this.ioA, cVar.ioA) && com.facebook.common.internal.f.equal(this.ioB, cVar.ioB) && com.facebook.common.internal.f.equal(this.ioC, cVar.ioC);
        }
        return false;
    }

    public int hashCode() {
        return this.ioD;
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.iox;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.iox, this.ioy, this.ioz, this.ioA, this.ioB, this.ioC, Integer.valueOf(this.ioD));
    }
}
