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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lQL;
    private final com.facebook.cache.common.b lRS;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lRU = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lRT = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b lRS;
        private final int mFrameIndex;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lRS = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aS(this).x("imageCacheKey", this.lRS).bH("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lRS == aVar.lRS && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lRS.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean A(Uri uri) {
            return this.lRS.A(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dks() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lRS = bVar;
        this.lQL = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lRU.add(bVar);
        } else {
            this.lRU.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lQL.a(Ii(i), aVar, this.lRT);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> Ih(int i) {
        return this.lQL.bn(Ii(i));
    }

    public boolean Ic(int i) {
        return this.lQL.contains(Ii(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dok() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bo;
        do {
            com.facebook.cache.common.b dol = dol();
            if (dol == null) {
                return null;
            }
            bo = this.lQL.bo(dol);
        } while (bo == null);
        return bo;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dol() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lRU.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a Ii(int i) {
        return new a(this.lRS, i);
    }
}
