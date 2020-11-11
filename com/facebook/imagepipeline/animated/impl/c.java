package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oRU;
    private final com.facebook.cache.common.b oTd;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> oTf = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> oTe = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b oTd;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.oTd = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aZ(this).F("imageCacheKey", this.oTd).bW("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.oTd == aVar.oTd && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.oTd.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.oTd.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String ejo() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.oTd = bVar;
        this.oRU = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.oTf.add(bVar);
        } else {
            this.oTf.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.oRU.a(Pa(i), aVar, this.oTe);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> OZ(int i) {
        return this.oRU.bu(Pa(i));
    }

    public boolean OU(int i) {
        return this.oRU.contains(Pa(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> enj() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bv;
        do {
            com.facebook.cache.common.b enk = enk();
            if (enk == null) {
                return null;
            }
            bv = this.oRU.bv(enk);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b enk() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.oTf.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Pa(int i) {
        return new a(this.oTd, i);
    }
}
