package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nBQ;
    private final com.facebook.cache.common.b nCZ;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> nDb = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> nDa = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b nCZ;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.nCZ = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aS(this).E("imageCacheKey", this.nCZ).bP("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.nCZ == aVar.nCZ && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.nCZ.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.nCZ.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dRQ() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.nCZ = bVar;
        this.nBQ = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.nDb.add(bVar);
        } else {
            this.nDb.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.nBQ.a(Mi(i), aVar, this.nDa);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> Mh(int i) {
        return this.nBQ.bn(Mi(i));
    }

    public boolean Mc(int i) {
        return this.nBQ.contains(Mi(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dVK() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bo;
        do {
            com.facebook.cache.common.b dVL = dVL();
            if (dVL == null) {
                return null;
            }
            bo = this.nBQ.bo(dVL);
        } while (bo == null);
        return bo;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dVL() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.nDb.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Mi(int i) {
        return new a(this.nCZ, i);
    }
}
