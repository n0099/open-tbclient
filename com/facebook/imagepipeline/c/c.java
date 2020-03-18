package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long eel;
    private final Object lMb;
    private final String lSq;
    @Nullable
    private final com.facebook.imagepipeline.common.d lSr;
    private final com.facebook.imagepipeline.common.e lSs;
    private final com.facebook.imagepipeline.common.b lSt;
    @Nullable
    private final com.facebook.cache.common.b lSu;
    @Nullable
    private final String lSv;
    private final int lSw;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lSq = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lSr = dVar;
        this.lSs = eVar;
        this.lSt = bVar;
        this.lSu = bVar2;
        this.lSv = str2;
        this.lSw = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lSt, this.lSu, str2);
        this.lMb = obj;
        this.eel = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lSw == cVar.lSw && this.lSq.equals(cVar.lSq) && com.facebook.common.internal.f.equal(this.lSr, cVar.lSr) && com.facebook.common.internal.f.equal(this.lSs, cVar.lSs) && com.facebook.common.internal.f.equal(this.lSt, cVar.lSt) && com.facebook.common.internal.f.equal(this.lSu, cVar.lSu) && com.facebook.common.internal.f.equal(this.lSv, cVar.lSv);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lSw;
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        return dks().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String dks() {
        return this.lSq;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lSq, this.lSr, this.lSs, this.lSt, this.lSu, this.lSv, Integer.valueOf(this.lSw));
    }
}
