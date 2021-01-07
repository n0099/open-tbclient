package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.b.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class c {
    private final com.facebook.cache.common.b pAT;
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pzK;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pAV = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pAU = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.b.h.c
        /* renamed from: b */
        public void e(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b pAT;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pAT = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.bb(this).I("imageCacheKey", this.pAT).cj("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pAT == aVar.pAT && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pAT.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean L(Uri uri) {
            return this.pAT.L(uri);
        }

        @Override // com.facebook.cache.common.b
        public String etn() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pAT = bVar;
        this.pzK = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pAV.add(bVar);
        } else {
            this.pAV.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.pzK.a(QN(i), aVar, this.pAU);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> QM(int i) {
        return this.pzK.bu(QN(i));
    }

    public boolean QH(int i) {
        return this.pzK.contains(QN(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> exc() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bv;
        do {
            com.facebook.cache.common.b exd = exd();
            if (exd == null) {
                return null;
            }
            bv = this.pzK.bv(exd);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b exd() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pAV.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a QN(int i) {
        return new a(this.pAT, i);
    }
}
