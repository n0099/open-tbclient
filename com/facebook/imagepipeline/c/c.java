package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object imp;
    private final String ipF;
    @Nullable
    private final com.facebook.imagepipeline.common.c ipG;
    private final com.facebook.imagepipeline.common.d ipH;
    private final com.facebook.imagepipeline.common.a ipI;
    @Nullable
    private final com.facebook.cache.common.b ipJ;
    @Nullable
    private final String ipK;
    private final int ipL;
    private final long ipM;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.ipF = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ipG = cVar;
        this.ipH = dVar;
        this.ipI = aVar;
        this.ipJ = bVar;
        this.ipK = str2;
        this.ipL = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.ipI, this.ipJ, str2);
        this.imp = obj;
        this.ipM = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ipL == cVar.ipL && this.ipF.equals(cVar.ipF) && com.facebook.common.internal.f.equal(this.ipG, cVar.ipG) && com.facebook.common.internal.f.equal(this.ipH, cVar.ipH) && com.facebook.common.internal.f.equal(this.ipI, cVar.ipI) && com.facebook.common.internal.f.equal(this.ipJ, cVar.ipJ) && com.facebook.common.internal.f.equal(this.ipK, cVar.ipK);
        }
        return false;
    }

    public int hashCode() {
        return this.ipL;
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ipF;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ipF, this.ipG, this.ipH, this.ipI, this.ipJ, this.ipK, Integer.valueOf(this.ipL));
    }
}
