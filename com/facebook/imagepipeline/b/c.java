package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class c implements com.facebook.cache.common.b {
    private final long geG;
    private final int mHash;
    private final Object pdN;
    private final String pjX;
    @Nullable
    private final com.facebook.imagepipeline.common.d pjY;
    private final com.facebook.imagepipeline.common.e pjZ;
    private final com.facebook.imagepipeline.common.b pka;
    @Nullable
    private final com.facebook.cache.common.b pkb;
    @Nullable
    private final String pkc;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.pjX = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.pjY = dVar;
        this.pjZ = eVar;
        this.pka = bVar;
        this.pkb = bVar2;
        this.pkc = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.pka, this.pkb, str2);
        this.pdN = obj;
        this.geG = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.pjX.equals(cVar.pjX) && com.facebook.common.internal.f.equal(this.pjY, cVar.pjY) && com.facebook.common.internal.f.equal(this.pjZ, cVar.pjZ) && com.facebook.common.internal.f.equal(this.pka, cVar.pka) && com.facebook.common.internal.f.equal(this.pkb, cVar.pkb) && com.facebook.common.internal.f.equal(this.pkc, cVar.pkc);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean K(Uri uri) {
        return epd().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String epd() {
        return this.pjX;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.pjX, this.pjY, this.pjZ, this.pka, this.pkb, this.pkc, Integer.valueOf(this.mHash));
    }
}
