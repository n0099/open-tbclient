package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oTx;
    private final com.facebook.cache.common.b oUG;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> oUI = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> oUH = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a implements com.facebook.cache.common.b {
        private final int mFrameIndex;
        private final com.facebook.cache.common.b oUG;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.oUG = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.ba(this).F("imageCacheKey", this.oUG).bV("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.oUG == aVar.oUG && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.oUG.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean J(Uri uri) {
            return this.oUG.J(uri);
        }

        @Override // com.facebook.cache.common.b
        public String ejm() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.oUG = bVar;
        this.oTx = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.oUI.add(bVar);
        } else {
            this.oUI.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.oTx.a(PD(i), aVar, this.oUH);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> PC(int i) {
        return this.oTx.bv(PD(i));
    }

    public boolean Px(int i) {
        return this.oTx.contains(PD(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> enh() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bw;
        do {
            com.facebook.cache.common.b eni = eni();
            if (eni == null) {
                return null;
            }
            bw = this.oTx.bw(eni);
        } while (bw == null);
        return bw;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b eni() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.oUI.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a PD(int i) {
        return new a(this.oUG, i);
    }
}
