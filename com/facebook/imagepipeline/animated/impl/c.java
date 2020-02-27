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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lOS;
    private final com.facebook.cache.common.b lPZ;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lQb = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lQa = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b lPZ;
        private final int mFrameIndex;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lPZ = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aS(this).x("imageCacheKey", this.lPZ).bH("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lPZ == aVar.lPZ && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lPZ.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean A(Uri uri) {
            return this.lPZ.A(uri);
        }

        @Override // com.facebook.cache.common.b
        public String djS() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lPZ = bVar;
        this.lOS = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lQb.add(bVar);
        } else {
            this.lQb.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lOS.a(Ic(i), aVar, this.lQa);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> Ib(int i) {
        return this.lOS.bn(Ic(i));
    }

    public boolean HW(int i) {
        return this.lOS.contains(Ic(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dnK() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bo;
        do {
            com.facebook.cache.common.b dnL = dnL();
            if (dnL == null) {
                return null;
            }
            bo = this.lOS.bo(dnL);
        } while (bo == null);
        return bo;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dnL() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lQb.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Ic(int i) {
        return new a(this.lPZ, i);
    }
}
