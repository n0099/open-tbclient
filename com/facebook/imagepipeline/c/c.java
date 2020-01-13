package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes10.dex */
public class c implements com.facebook.cache.common.b {
    private final long dZD;
    private final Object lJw;
    private final String lPL;
    @Nullable
    private final com.facebook.imagepipeline.common.d lPM;
    private final com.facebook.imagepipeline.common.e lPN;
    private final com.facebook.imagepipeline.common.b lPO;
    @Nullable
    private final com.facebook.cache.common.b lPP;
    @Nullable
    private final String lPQ;
    private final int lPR;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lPL = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lPM = dVar;
        this.lPN = eVar;
        this.lPO = bVar;
        this.lPP = bVar2;
        this.lPQ = str2;
        this.lPR = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lPO, this.lPP, str2);
        this.lJw = obj;
        this.dZD = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lPR == cVar.lPR && this.lPL.equals(cVar.lPL) && com.facebook.common.internal.f.equal(this.lPM, cVar.lPM) && com.facebook.common.internal.f.equal(this.lPN, cVar.lPN) && com.facebook.common.internal.f.equal(this.lPO, cVar.lPO) && com.facebook.common.internal.f.equal(this.lPP, cVar.lPP) && com.facebook.common.internal.f.equal(this.lPQ, cVar.lPQ);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lPR;
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        return diD().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String diD() {
        return this.lPL;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lPL, this.lPM, this.lPN, this.lPO, this.lPP, this.lPQ, Integer.valueOf(this.lPR));
    }
}
