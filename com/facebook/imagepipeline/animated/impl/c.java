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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lOg;
    private final com.facebook.cache.common.b lPn;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lPp = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lPo = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b lPn;
        private final int mFrameIndex;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lPn = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aQ(this).x("imageCacheKey", this.lPn).bI("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lPn == aVar.lPn && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lPn.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean z(Uri uri) {
            return this.lPn.z(uri);
        }

        @Override // com.facebook.cache.common.b
        public String diD() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lPn = bVar;
        this.lOg = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lPp.add(bVar);
        } else {
            this.lPp.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lOg.a(HX(i), aVar, this.lPo);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> HW(int i) {
        return this.lOg.bl(HX(i));
    }

    public boolean HR(int i) {
        return this.lOg.contains(HX(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dmv() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bm;
        do {
            com.facebook.cache.common.b dmw = dmw();
            if (dmw == null) {
                return null;
            }
            bm = this.lOg.bm(dmw);
        } while (bm == null);
        return bm;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dmw() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lPp.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a HX(int i) {
        return new a(this.lPn, i);
    }
}
