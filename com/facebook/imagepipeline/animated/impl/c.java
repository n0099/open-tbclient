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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lYu;
    private final com.facebook.cache.common.b lZD;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lZF = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lZE = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b lZD;
        private final int lZH;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lZD = bVar;
            this.lZH = i;
        }

        public String toString() {
            return f.aJ(this).C("imageCacheKey", this.lZD).bM("frameIndex", this.lZH).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lZD == aVar.lZD && this.lZH == aVar.lZH;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lZD.hashCode() * 1013) + this.lZH;
        }

        @Override // com.facebook.cache.common.b
        public boolean E(Uri uri) {
            return this.lZD.E(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dmh() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lZD = bVar;
        this.lYu = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lZF.add(bVar);
        } else {
            this.lZF.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lYu.a(GJ(i), aVar, this.lZE);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> GI(int i) {
        return this.lYu.be(GJ(i));
    }

    public boolean GD(int i) {
        return this.lYu.contains(GJ(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dqe() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bf;
        do {
            com.facebook.cache.common.b dqf = dqf();
            if (dqf == null) {
                return null;
            }
            bf = this.lYu.bf(dqf);
        } while (bf == null);
        return bf;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dqf() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lZF.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a GJ(int i) {
        return new a(this.lZD, i);
    }
}
