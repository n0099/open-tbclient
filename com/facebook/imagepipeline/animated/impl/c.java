package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nrS;
    private final com.facebook.cache.common.b ntb;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> ntd = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> ntc = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b ntb;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.ntb = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aQ(this).E("imageCacheKey", this.ntb).bP("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.ntb == aVar.ntb && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.ntb.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean G(Uri uri) {
            return this.ntb.G(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dNS() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.ntb = bVar;
        this.nrS = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.ntd.add(bVar);
        } else {
            this.ntd.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.nrS.a(LD(i), aVar, this.ntc);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> LC(int i) {
        return this.nrS.bl(LD(i));
    }

    public boolean Lx(int i) {
        return this.nrS.contains(LD(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dRM() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bm;
        do {
            com.facebook.cache.common.b dRN = dRN();
            if (dRN == null) {
                return null;
            }
            bm = this.nrS.bm(dRN);
        } while (bm == null);
        return bm;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dRN() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.ntd.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a LD(int i) {
        return new a(this.ntb, i);
    }
}
