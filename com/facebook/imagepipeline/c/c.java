package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class c implements com.facebook.cache.common.b {
    private final long fWM;
    private final int mHash;
    private final Object oNa;
    private final String oTC;
    @Nullable
    private final com.facebook.imagepipeline.common.d oTD;
    private final com.facebook.imagepipeline.common.e oTE;
    private final com.facebook.imagepipeline.common.b oTF;
    @Nullable
    private final com.facebook.cache.common.b oTG;
    @Nullable
    private final String oTH;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.oTC = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.oTD = dVar;
        this.oTE = eVar;
        this.oTF = bVar;
        this.oTG = bVar2;
        this.oTH = str2;
        this.mHash = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.oTF, this.oTG, str2);
        this.oNa = obj;
        this.fWM = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.mHash == cVar.mHash && this.oTC.equals(cVar.oTC) && com.facebook.common.internal.f.equal(this.oTD, cVar.oTD) && com.facebook.common.internal.f.equal(this.oTE, cVar.oTE) && com.facebook.common.internal.f.equal(this.oTF, cVar.oTF) && com.facebook.common.internal.f.equal(this.oTG, cVar.oTG) && com.facebook.common.internal.f.equal(this.oTH, cVar.oTH);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        return ejo().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String ejo() {
        return this.oTC;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.oTC, this.oTD, this.oTE, this.oTF, this.oTG, this.oTH, Integer.valueOf(this.mHash));
    }
}
