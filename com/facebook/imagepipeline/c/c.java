package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class c implements com.facebook.cache.common.b {
    private final long fIB;
    private final int mHash;
    private final Object nMo;
    private final String nSR;
    @Nullable
    private final com.facebook.imagepipeline.common.d nSS;
    private final com.facebook.imagepipeline.common.e nST;
    private final com.facebook.imagepipeline.common.b nSU;
    @Nullable
    private final com.facebook.cache.common.b nSV;
    @Nullable
    private final String nSW;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.nSR = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.nSS = dVar;
        this.nST = eVar;
        this.nSU = bVar;
        this.nSV = bVar2;
        this.nSW = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.nSU, this.nSV, str2);
        this.nMo = obj;
        this.fIB = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.nSR.equals(cVar.nSR) && com.facebook.common.internal.f.equal(this.nSS, cVar.nSS) && com.facebook.common.internal.f.equal(this.nST, cVar.nST) && com.facebook.common.internal.f.equal(this.nSU, cVar.nSU) && com.facebook.common.internal.f.equal(this.nSV, cVar.nSV) && com.facebook.common.internal.f.equal(this.nSW, cVar.nSW);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return dVB().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dVB() {
        return this.nSR;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.nSR, this.nSS, this.nST, this.nSU, this.nSV, this.nSW, Integer.valueOf(this.mHash));
    }
}
