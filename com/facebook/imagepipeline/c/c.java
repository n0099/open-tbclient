package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object kbs;
    private final String keN;
    @Nullable
    private final com.facebook.imagepipeline.common.c keO;
    private final com.facebook.imagepipeline.common.d keP;
    private final com.facebook.imagepipeline.common.a keQ;
    @Nullable
    private final com.facebook.cache.common.b keR;
    @Nullable
    private final String keS;
    private final int keT;
    private final long keU;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.keN = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.keO = cVar;
        this.keP = dVar;
        this.keQ = aVar;
        this.keR = bVar;
        this.keS = str2;
        this.keT = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.keQ, this.keR, str2);
        this.kbs = obj;
        this.keU = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.keT == cVar.keT && this.keN.equals(cVar.keN) && com.facebook.common.internal.f.equal(this.keO, cVar.keO) && com.facebook.common.internal.f.equal(this.keP, cVar.keP) && com.facebook.common.internal.f.equal(this.keQ, cVar.keQ) && com.facebook.common.internal.f.equal(this.keR, cVar.keR) && com.facebook.common.internal.f.equal(this.keS, cVar.keS);
        }
        return false;
    }

    public int hashCode() {
        return this.keT;
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        return cDR().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cDR() {
        return this.keN;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.keN, this.keO, this.keP, this.keQ, this.keR, this.keS, Integer.valueOf(this.keT));
    }
}
