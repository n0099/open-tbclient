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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pFS;
    private final com.facebook.cache.common.b pHb;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pHd = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pHc = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b pHb;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pHb = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.bb(this).H("imageCacheKey", this.pHb).cl("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pHb == aVar.pHb && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pHb.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.pHb.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String erU() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pHb = bVar;
        this.pFS = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pHd.add(bVar);
        } else {
            this.pHd.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.pFS.a(PC(i), aVar, this.pHc);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> PB(int i) {
        return this.pFS.bu(PC(i));
    }

    public boolean Pw(int i) {
        return this.pFS.contains(PC(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> evK() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bv;
        do {
            com.facebook.cache.common.b evL = evL();
            if (evL == null) {
                return null;
            }
            bv = this.pFS.bv(evL);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b evL() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pHd.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a PC(int i) {
        return new a(this.pHb, i);
    }
}
