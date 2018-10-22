package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object hYZ;
    private final String ico;
    @Nullable
    private final com.facebook.imagepipeline.common.c icp;
    private final com.facebook.imagepipeline.common.d icq;
    private final com.facebook.imagepipeline.common.a icr;
    @Nullable
    private final com.facebook.cache.common.b ics;
    @Nullable
    private final String ict;
    private final int icu;
    private final long icv;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.ico = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.icp = cVar;
        this.icq = dVar;
        this.icr = aVar;
        this.ics = bVar;
        this.ict = str2;
        this.icu = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.icr, this.ics, str2);
        this.hYZ = obj;
        this.icv = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.icu == cVar.icu && this.ico.equals(cVar.ico) && com.facebook.common.internal.f.equal(this.icp, cVar.icp) && com.facebook.common.internal.f.equal(this.icq, cVar.icq) && com.facebook.common.internal.f.equal(this.icr, cVar.icr) && com.facebook.common.internal.f.equal(this.ics, cVar.ics) && com.facebook.common.internal.f.equal(this.ict, cVar.ict);
        }
        return false;
    }

    public int hashCode() {
        return this.icu;
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ico;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ico, this.icp, this.icq, this.icr, this.ics, this.ict, Integer.valueOf(this.icu));
    }
}
