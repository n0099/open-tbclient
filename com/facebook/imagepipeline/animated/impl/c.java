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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mtz;
    private final com.facebook.cache.common.b muI;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> muK = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> muJ = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b muI;
        private final int muM;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.muI = bVar;
            this.muM = i;
        }

        public String toString() {
            return f.aN(this).F("imageCacheKey", this.muI).bN("frameIndex", this.muM).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.muI == aVar.muI && this.muM == aVar.muM;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.muI.hashCode() * 1013) + this.muM;
        }

        @Override // com.facebook.cache.common.b
        public boolean G(Uri uri) {
            return this.muI.G(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dtP() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.muI = bVar;
        this.mtz = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.muK.add(bVar);
        } else {
            this.muK.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.mtz.a(Hx(i), aVar, this.muJ);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> Hw(int i) {
        return this.mtz.bi(Hx(i));
    }

    public boolean Hr(int i) {
        return this.mtz.contains(Hx(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dxL() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj;
        do {
            com.facebook.cache.common.b dxM = dxM();
            if (dxM == null) {
                return null;
            }
            bj = this.mtz.bj(dxM);
        } while (bj == null);
        return bj;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dxM() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.muK.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Hx(int i) {
        return new a(this.muI, i);
    }
}
