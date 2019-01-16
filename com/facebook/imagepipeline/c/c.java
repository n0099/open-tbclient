package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object imo;
    private final String ipE;
    @Nullable
    private final com.facebook.imagepipeline.common.c ipF;
    private final com.facebook.imagepipeline.common.d ipG;
    private final com.facebook.imagepipeline.common.a ipH;
    @Nullable
    private final com.facebook.cache.common.b ipI;
    @Nullable
    private final String ipJ;
    private final int ipK;
    private final long ipL;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.ipE = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ipF = cVar;
        this.ipG = dVar;
        this.ipH = aVar;
        this.ipI = bVar;
        this.ipJ = str2;
        this.ipK = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.ipH, this.ipI, str2);
        this.imo = obj;
        this.ipL = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ipK == cVar.ipK && this.ipE.equals(cVar.ipE) && com.facebook.common.internal.f.equal(this.ipF, cVar.ipF) && com.facebook.common.internal.f.equal(this.ipG, cVar.ipG) && com.facebook.common.internal.f.equal(this.ipH, cVar.ipH) && com.facebook.common.internal.f.equal(this.ipI, cVar.ipI) && com.facebook.common.internal.f.equal(this.ipJ, cVar.ipJ);
        }
        return false;
    }

    public int hashCode() {
        return this.ipK;
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ipE;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ipE, this.ipF, this.ipG, this.ipH, this.ipI, this.ipJ, Integer.valueOf(this.ipK));
    }
}
