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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lYq;
    private final com.facebook.cache.common.b lZz;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lZB = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lZA = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final int lZD;
        private final com.facebook.cache.common.b lZz;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lZz = bVar;
            this.lZD = i;
        }

        public String toString() {
            return f.aI(this).C("imageCacheKey", this.lZz).bM("frameIndex", this.lZD).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lZz == aVar.lZz && this.lZD == aVar.lZD;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lZz.hashCode() * 1013) + this.lZD;
        }

        @Override // com.facebook.cache.common.b
        public boolean E(Uri uri) {
            return this.lZz.E(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dmk() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lZz = bVar;
        this.lYq = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lZB.add(bVar);
        } else {
            this.lZB.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lYq.a(GJ(i), aVar, this.lZA);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> GI(int i) {
        return this.lYq.bd(GJ(i));
    }

    public boolean GD(int i) {
        return this.lYq.contains(GJ(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dqh() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be;
        do {
            com.facebook.cache.common.b dqi = dqi();
            if (dqi == null) {
                return null;
            }
            be = this.lYq.be(dqi);
        } while (be == null);
        return be;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dqi() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lZB.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a GJ(int i) {
        return new a(this.lZz, i);
    }
}
