package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object iaJ;
    private final String ieb;
    @Nullable
    private final com.facebook.imagepipeline.common.c iec;
    private final com.facebook.imagepipeline.common.d ied;
    private final com.facebook.imagepipeline.common.a iee;
    @Nullable
    private final com.facebook.cache.common.b ief;
    @Nullable
    private final String ieg;
    private final int ieh;
    private final long iei;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.ieb = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.iec = cVar;
        this.ied = dVar;
        this.iee = aVar;
        this.ief = bVar;
        this.ieg = str2;
        this.ieh = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.iee, this.ief, str2);
        this.iaJ = obj;
        this.iei = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.ieh == cVar.ieh && this.ieb.equals(cVar.ieb) && com.facebook.common.internal.f.equal(this.iec, cVar.iec) && com.facebook.common.internal.f.equal(this.ied, cVar.ied) && com.facebook.common.internal.f.equal(this.iee, cVar.iee) && com.facebook.common.internal.f.equal(this.ief, cVar.ief) && com.facebook.common.internal.f.equal(this.ieg, cVar.ieg);
        }
        return false;
    }

    public int hashCode() {
        return this.ieh;
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ieb;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.ieb, this.iec, this.ied, this.iee, this.ief, this.ieg, Integer.valueOf(this.ieh));
    }
}
