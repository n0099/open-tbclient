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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mXL;
    private final com.facebook.cache.common.b mYU;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> mYW = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> mYV = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b mYU;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.mYU = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aO(this).F("imageCacheKey", this.mYU).bK("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.mYU == aVar.mYU && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.mYU.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean G(Uri uri) {
            return this.mYU.G(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dBJ() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.mYU = bVar;
        this.mXL = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.mYW.add(bVar);
        } else {
            this.mYW.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.mXL.a(IZ(i), aVar, this.mYV);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> IY(int i) {
        return this.mXL.bj(IZ(i));
    }

    public boolean IT(int i) {
        return this.mXL.contains(IZ(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dFE() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bk;
        do {
            com.facebook.cache.common.b dFF = dFF();
            if (dFF == null) {
                return null;
            }
            bk = this.mXL.bk(dFF);
        } while (bk == null);
        return bk;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dFF() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.mYW.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a IZ(int i) {
        return new a(this.mYU, i);
    }
}
