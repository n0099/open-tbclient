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
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lOl;
    private final com.facebook.cache.common.b lPs;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lPu = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lPt = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
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
        private final com.facebook.cache.common.b lPs;
        private final int mFrameIndex;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lPs = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aQ(this).x("imageCacheKey", this.lPs).bI("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lPs == aVar.lPs && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lPs.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean z(Uri uri) {
            return this.lPs.z(uri);
        }

        @Override // com.facebook.cache.common.b
        public String diF() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lPs = bVar;
        this.lOl = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lPu.add(bVar);
        } else {
            this.lPu.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lOl.a(HX(i), aVar, this.lPt);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> HW(int i) {
        return this.lOl.bl(HX(i));
    }

    public boolean HR(int i) {
        return this.lOl.contains(HX(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dmx() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bm;
        do {
            com.facebook.cache.common.b dmy = dmy();
            if (dmy == null) {
                return null;
            }
            bm = this.lOl.bm(dmy);
        } while (bm == null);
        return bm;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dmy() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lPu.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a HX(int i) {
        return new a(this.lPs, i);
    }
}
