package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class c implements com.facebook.cache.common.b {
    private final Object kcn;
    private final String kfK;
    @Nullable
    private final com.facebook.imagepipeline.common.c kfL;
    private final com.facebook.imagepipeline.common.d kfM;
    private final com.facebook.imagepipeline.common.a kfN;
    @Nullable
    private final com.facebook.cache.common.b kfO;
    @Nullable
    private final String kfP;
    private final int kfQ;
    private final long kfR;

    public c(String str, @Nullable com.facebook.imagepipeline.common.c cVar, com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.a aVar, @Nullable com.facebook.cache.common.b bVar, @Nullable String str2, Object obj) {
        this.kfK = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.kfL = cVar;
        this.kfM = dVar;
        this.kfN = aVar;
        this.kfO = bVar;
        this.kfP = str2;
        this.kfQ = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(cVar != null ? cVar.hashCode() : 0), Integer.valueOf(dVar.hashCode()), this.kfN, this.kfO, str2);
        this.kcn = obj;
        this.kfR = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.kfQ == cVar.kfQ && this.kfK.equals(cVar.kfK) && com.facebook.common.internal.f.equal(this.kfL, cVar.kfL) && com.facebook.common.internal.f.equal(this.kfM, cVar.kfM) && com.facebook.common.internal.f.equal(this.kfN, cVar.kfN) && com.facebook.common.internal.f.equal(this.kfO, cVar.kfO) && com.facebook.common.internal.f.equal(this.kfP, cVar.kfP);
        }
        return false;
    }

    public int hashCode() {
        return this.kfQ;
    }

    @Override // com.facebook.cache.common.b
    public boolean u(Uri uri) {
        return cBW().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cBW() {
        return this.kfK;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.kfK, this.kfL, this.kfM, this.kfN, this.kfO, this.kfP, Integer.valueOf(this.kfQ));
    }
}
