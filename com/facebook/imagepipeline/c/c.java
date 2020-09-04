package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class c implements com.facebook.cache.common.b {
    private final long ftg;
    private final int mHash;
    private final Object nmV;
    private final String ntA;
    @Nullable
    private final com.facebook.imagepipeline.common.d ntB;
    private final com.facebook.imagepipeline.common.e ntC;
    private final com.facebook.imagepipeline.common.b ntD;
    @Nullable
    private final com.facebook.cache.common.b ntE;
    @Nullable
    private final String ntF;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.ntA = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ntB = dVar;
        this.ntC = eVar;
        this.ntD = bVar;
        this.ntE = bVar2;
        this.ntF = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.ntD, this.ntE, str2);
        this.nmV = obj;
        this.ftg = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.ntA.equals(cVar.ntA) && com.facebook.common.internal.f.equal(this.ntB, cVar.ntB) && com.facebook.common.internal.f.equal(this.ntC, cVar.ntC) && com.facebook.common.internal.f.equal(this.ntD, cVar.ntD) && com.facebook.common.internal.f.equal(this.ntE, cVar.ntE) && com.facebook.common.internal.f.equal(this.ntF, cVar.ntF);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        return dNS().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dNS() {
        return this.ntA;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ntA, this.ntB, this.ntC, this.ntD, this.ntE, this.ntF, Integer.valueOf(this.mHash));
    }
}
