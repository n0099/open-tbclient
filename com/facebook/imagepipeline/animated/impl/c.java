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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mPy;
    private final com.facebook.cache.common.b mQH;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> mQJ = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> mQI = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final int mFrameIndex;
        private final com.facebook.cache.common.b mQH;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.mQH = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aO(this).F("imageCacheKey", this.mQH).bM("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.mQH == aVar.mQH && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.mQH.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean H(Uri uri) {
            return this.mQH.H(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dys() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.mQH = bVar;
        this.mPy = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.mQJ.add(bVar);
        } else {
            this.mQJ.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.mPy.a(IE(i), aVar, this.mQI);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> ID(int i) {
        return this.mPy.bj(IE(i));
    }

    public boolean Iy(int i) {
        return this.mPy.contains(IE(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dCn() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bk;
        do {
            com.facebook.cache.common.b dCo = dCo();
            if (dCo == null) {
                return null;
            }
            bk = this.mPy.bk(dCo);
        } while (bk == null);
        return bk;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dCo() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.mQJ.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a IE(int i) {
        return new a(this.mQH, i);
    }
}
