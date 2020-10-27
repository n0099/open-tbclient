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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oIB;
    private final com.facebook.cache.common.b oJK;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> oJM = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> oJL = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b oJK;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.oJK = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aZ(this).F("imageCacheKey", this.oJK).bU("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.oJK == aVar.oJK && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.oJK.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return this.oJK.I(uri);
        }

        @Override // com.facebook.cache.common.b
        public String efz() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.oJK = bVar;
        this.oIB = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.oJM.add(bVar);
        } else {
            this.oJM.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.oIB.a(OF(i), aVar, this.oJL);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> OE(int i) {
        return this.oIB.bu(OF(i));
    }

    public boolean Oz(int i) {
        return this.oIB.contains(OF(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> ejt() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bv;
        do {
            com.facebook.cache.common.b eju = eju();
            if (eju == null) {
                return null;
            }
            bv = this.oIB.bv(eju);
        } while (bv == null);
        return bv;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b eju() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.oJM.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a OF(int i) {
        return new a(this.oJK, i);
    }
}
