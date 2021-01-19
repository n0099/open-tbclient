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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pvk;
    private final com.facebook.cache.common.b pwt;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> pwv = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> pwu = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b pwt;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.pwt = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.bb(this).I("imageCacheKey", this.pwt).ck("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.pwt == aVar.pwt && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.pwt.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.pwt.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String ept() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        this.pwt = bVar;
        this.pvk = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.pwv.add(bVar);
        } else {
            this.pwv.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return this.pvk.a(Pg(i), aVar, this.pwu);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> Pf(int i) {
        return this.pvk.bu(Pg(i));
    }

    public boolean Pa(int i) {
        return this.pvk.contains(Pg(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> etk() {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bv;
        do {
            com.facebook.cache.common.b etl = etl();
            if (etl == null) {
                return null;
            }
            bv = this.pvk.bv(etl);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b etl() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.pwv.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Pg(int i) {
        return new a(this.pwt, i);
    }
}
