package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class c implements com.facebook.cache.common.b {
    private final long edV;
    private final Object lKv;
    private final String lQK;
    @Nullable
    private final com.facebook.imagepipeline.common.d lQL;
    private final com.facebook.imagepipeline.common.e lQM;
    private final com.facebook.imagepipeline.common.b lQN;
    @Nullable
    private final com.facebook.cache.common.b lQO;
    @Nullable
    private final String lQP;
    private final int lQQ;

    public c(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, Object obj) {
        this.lQK = (String) com.facebook.common.internal.g.checkNotNull(str);
        this.lQL = dVar;
        this.lQM = eVar;
        this.lQN = bVar;
        this.lQO = bVar2;
        this.lQP = str2;
        this.lQQ = com.facebook.common.util.a.a(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), this.lQN, this.lQO, str2);
        this.lKv = obj;
        this.edV = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.lQQ == cVar.lQQ && this.lQK.equals(cVar.lQK) && com.facebook.common.internal.f.equal(this.lQL, cVar.lQL) && com.facebook.common.internal.f.equal(this.lQM, cVar.lQM) && com.facebook.common.internal.f.equal(this.lQN, cVar.lQN) && com.facebook.common.internal.f.equal(this.lQO, cVar.lQO) && com.facebook.common.internal.f.equal(this.lQP, cVar.lQP);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lQQ;
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        return djV().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String djV() {
        return this.lQK;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.lQK, this.lQL, this.lQM, this.lQN, this.lQO, this.lQP, Integer.valueOf(this.lQQ));
    }
}
