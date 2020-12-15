package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.b.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> piy;
    private final com.facebook.cache.common.b pjH;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pjJ = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pjI = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.b.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b pjH;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pjH = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.ba(this).E("imageCacheKey", this.pjH).ca("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pjH == aVar.pjH && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pjH.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean K(Uri uri) {
            return this.pjH.K(uri);
        }

        @Override // com.facebook.cache.common.b
        public String epd() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pjH = bVar;
        this.piy = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pjJ.add(bVar);
        } else {
            this.pjJ.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.piy.a(Qz(i), aVar, this.pjI);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> Qy(int i) {
        return this.piy.bu(Qz(i));
    }

    public boolean Qt(int i) {
        return this.piy.contains(Qz(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> esS() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bv;
        do {
            com.facebook.cache.common.b esT = esT();
            if (esT == null) {
                return null;
            }
            bv = this.piy.bv(esT);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b esT() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pjJ.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Qz(int i) {
        return new a(this.pjH, i);
    }
}
