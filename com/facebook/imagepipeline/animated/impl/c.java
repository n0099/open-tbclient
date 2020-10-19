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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nRj;
    private final com.facebook.cache.common.b nSs;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> nSu = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> nSt = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b nSs;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.nSs = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aV(this).F("imageCacheKey", this.nSs).bQ("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.nSs == aVar.nSs && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.nSs.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.nSs.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dVB() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.nSs = bVar;
        this.nRj = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.nSu.add(bVar);
        } else {
            this.nSu.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.nRj.a(MO(i), aVar, this.nSt);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> MN(int i) {
        return this.nRj.bq(MO(i));
    }

    public boolean MI(int i) {
        return this.nRj.contains(MO(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dZv() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> br;
        do {
            com.facebook.cache.common.b dZw = dZw();
            if (dZw == null) {
                return null;
            }
            br = this.nRj.br(dZw);
        } while (br == null);
        return br;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dZw() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.nSu.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a MO(int i) {
        return new a(this.nSs, i);
    }
}
