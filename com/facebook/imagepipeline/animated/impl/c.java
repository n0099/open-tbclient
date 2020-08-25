package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nrA;
    private final com.facebook.cache.common.b nsJ;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> nsL = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> nsK = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b nsJ;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.nsJ = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aQ(this).E("imageCacheKey", this.nsJ).bP("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.nsJ == aVar.nsJ && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.nsJ.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean G(Uri uri) {
            return this.nsJ.G(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dNJ() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.nsJ = bVar;
        this.nrA = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.nsL.add(bVar);
        } else {
            this.nsL.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.nrA.a(LD(i), aVar, this.nsK);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> LC(int i) {
        return this.nrA.bl(LD(i));
    }

    public boolean Lx(int i) {
        return this.nrA.contains(LD(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dRD() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bm;
        do {
            com.facebook.cache.common.b dRE = dRE();
            if (dRE == null) {
                return null;
            }
            bm = this.nrA.bm(dRE);
        } while (bm == null);
        return bm;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dRE() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.nsL.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a LD(int i) {
        return new a(this.nsJ, i);
    }
}
