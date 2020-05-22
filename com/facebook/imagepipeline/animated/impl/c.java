package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> msp;
    private final com.facebook.cache.common.b mty;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> mtA = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> mtz = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mtC;
        private final com.facebook.cache.common.b mty;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.mty = bVar;
            this.mtC = i;
        }

        public String toString() {
            return f.aN(this).F("imageCacheKey", this.mty).bN("frameIndex", this.mtC).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.mty == aVar.mty && this.mtC == aVar.mtC;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.mty.hashCode() * 1013) + this.mtC;
        }

        @Override // com.facebook.cache.common.b
        public boolean G(Uri uri) {
            return this.mty.G(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dtB() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.mty = bVar;
        this.msp = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.mtA.add(bVar);
        } else {
            this.mtA.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.msp.a(Hv(i), aVar, this.mtz);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> Hu(int i) {
        return this.msp.bi(Hv(i));
    }

    public boolean Hp(int i) {
        return this.msp.contains(Hv(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dxx() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj;
        do {
            com.facebook.cache.common.b dxy = dxy();
            if (dxy == null) {
                return null;
            }
            bj = this.msp.bj(dxy);
        } while (bj == null);
        return bj;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dxy() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.mtA.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Hv(int i) {
        return new a(this.mty, i);
    }
}
