package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes10.dex */
public class c implements com.facebook.cache.common.b {
    private final long dZD;
    private final Object lJB;
    private final String lPQ;
    @Nullable
    private final com.facebook.imagepipeline.common.d lPR;
    private final com.facebook.imagepipeline.common.e lPS;
    private final com.facebook.imagepipeline.common.b lPT;
    @Nullable
    private final com.facebook.cache.common.b lPU;
    @Nullable
    private final String lPV;
    private final int lPW;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lPQ = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lPR = dVar;
        this.lPS = eVar;
        this.lPT = bVar;
        this.lPU = bVar2;
        this.lPV = str2;
        this.lPW = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lPT, this.lPU, str2);
        this.lJB = obj;
        this.dZD = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lPW == cVar.lPW && this.lPQ.equals(cVar.lPQ) && com.facebook.common.internal.f.equal(this.lPR, cVar.lPR) && com.facebook.common.internal.f.equal(this.lPS, cVar.lPS) && com.facebook.common.internal.f.equal(this.lPT, cVar.lPT) && com.facebook.common.internal.f.equal(this.lPU, cVar.lPU) && com.facebook.common.internal.f.equal(this.lPV, cVar.lPV);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lPW;
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        return diF().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String diF() {
        return this.lPQ;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lPQ, this.lPR, this.lPS, this.lPT, this.lPU, this.lPV, Integer.valueOf(this.lPW));
    }
}
