package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class c implements com.facebook.cache.common.b {
    private final long geE;
    private final int mHash;
    private final Object pdL;
    private final String pjV;
    @Nullable
    private final com.facebook.imagepipeline.common.d pjW;
    private final com.facebook.imagepipeline.common.e pjX;
    private final com.facebook.imagepipeline.common.b pjY;
    @Nullable
    private final com.facebook.cache.common.b pjZ;
    @Nullable
    private final String pka;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pjV = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pjW = dVar;
        this.pjX = eVar;
        this.pjY = bVar;
        this.pjZ = bVar2;
        this.pka = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pjY, this.pjZ, str2);
        this.pdL = obj;
        this.geE = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pjV.equals(cVar.pjV) && com.facebook.common.internal.f.equal(this.pjW, cVar.pjW) && com.facebook.common.internal.f.equal(this.pjX, cVar.pjX) && com.facebook.common.internal.f.equal(this.pjY, cVar.pjY) && com.facebook.common.internal.f.equal(this.pjZ, cVar.pjZ) && com.facebook.common.internal.f.equal(this.pka, cVar.pka);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean K(Uri uri) {
        return epc().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String epc() {
        return this.pjV;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pjV, this.pjW, this.pjX, this.pjY, this.pjZ, this.pka, Integer.valueOf(this.mHash));
    }
}
