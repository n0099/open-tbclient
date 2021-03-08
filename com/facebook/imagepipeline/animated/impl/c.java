package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.b.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pHX;
    private final com.facebook.cache.common.b pJg;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pJi = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pJh = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.b.h.c
        /* renamed from: b */
        public void e(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b pJg;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pJg = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.bd(this).G("imageCacheKey", this.pJg).cl("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pJg == aVar.pJg && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pJg.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.pJg.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String esd() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pJg = bVar;
        this.pHX = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pJi.add(bVar);
        } else {
            this.pJi.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.pHX.a(PG(i), aVar, this.pJh);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> PF(int i) {
        return this.pHX.bw(PG(i));
    }

    public boolean PA(int i) {
        return this.pHX.contains(PG(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> evT() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bx;
        do {
            com.facebook.cache.common.b evU = evU();
            if (evU == null) {
                return null;
            }
            bx = this.pHX.bx(evU);
        } while (bx == null);
        return bx;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b evU() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pJi.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a PG(int i) {
        return new a(this.pJg, i);
    }
}
