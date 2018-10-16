package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object hYY;
    private final String icn;
    @Nullable
    private final com.facebook.imagepipeline.common.c ico;
    private final com.facebook.imagepipeline.common.d icp;
    private final com.facebook.imagepipeline.common.a icq;
    @Nullable
    private final com.facebook.cache.common.b icr;
    @Nullable
    private final String ics;
    private final int ict;
    private final long icu;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.icn = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.ico = cVar;
        this.icp = dVar;
        this.icq = aVar;
        this.icr = bVar;
        this.ics = str2;
        this.ict = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.icq, this.icr, str2);
        this.hYY = obj;
        this.icu = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ict == cVar.ict && this.icn.equals(cVar.icn) && com.facebook.common.internal.f.equal(this.ico, cVar.ico) && com.facebook.common.internal.f.equal(this.icp, cVar.icp) && com.facebook.common.internal.f.equal(this.icq, cVar.icq) && com.facebook.common.internal.f.equal(this.icr, cVar.icr) && com.facebook.common.internal.f.equal(this.ics, cVar.ics);
        }
        return false;
    }

    public int hashCode() {
        return this.ict;
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.icn;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.icn, this.ico, this.icp, this.icq, this.icr, this.ics, Integer.valueOf(this.ict));
    }
}
