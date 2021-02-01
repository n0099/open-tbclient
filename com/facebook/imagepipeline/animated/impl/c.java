package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.b.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pFs;
    private final com.facebook.cache.common.b pGB;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pGD = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pGC = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.b.h.c
        /* renamed from: b */
        public void e(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b pGB;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pGB = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.bb(this).H("imageCacheKey", this.pGB).cl("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pGB == aVar.pGB && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pGB.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.pGB.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String erM() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pGB = bVar;
        this.pFs = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pGD.add(bVar);
        } else {
            this.pGD.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.pFs.a(PB(i), aVar, this.pGC);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> PA(int i) {
        return this.pFs.bu(PB(i));
    }

    public boolean Pv(int i) {
        return this.pFs.contains(PB(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> evC() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bv;
        do {
            com.facebook.cache.common.b evD = evD();
            if (evD == null) {
                return null;
            }
            bv = this.pFs.bv(evD);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b evD() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pGD.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a PB(int i) {
        return new a(this.pGB, i);
    }
}
