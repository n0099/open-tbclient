package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.c.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class c {
    private final h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lKv;
    private final com.facebook.cache.common.b lLC;
    @GuardedBy("this")
    private final LinkedHashSet<com.facebook.cache.common.b> lLE = new LinkedHashSet<>();
    private final h.c<com.facebook.cache.common.b> lLD = new h.c<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.animated.impl.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.c.h.c
        /* renamed from: b */
        public void d(com.facebook.cache.common.b bVar, boolean z) {
            c.this.a(bVar, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a implements com.facebook.cache.common.b {
        private final com.facebook.cache.common.b lLC;
        private final int mFrameIndex;

        public a(com.facebook.cache.common.b bVar, int i) {
            this.lLC = bVar;
            this.mFrameIndex = i;
        }

        public String toString() {
            return f.aQ(this).x("imageCacheKey", this.lLC).bH("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.lLC == aVar.lLC && this.mFrameIndex == aVar.mFrameIndex;
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.lLC.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.b
        public boolean z(Uri uri) {
            return this.lLC.z(uri);
        }

        @Override // com.facebook.cache.common.b
        public String dhC() {
            return null;
        }
    }

    public c(com.facebook.cache.common.b bVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        this.lLC = bVar;
        this.lKv = hVar;
    }

    public synchronized void a(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.lLE.add(bVar);
        } else {
            this.lLE.remove(bVar);
        }
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b(int i, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return this.lKv.a(HO(i), aVar, this.lLD);
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> HN(int i) {
        return this.lKv.bk(HO(i));
    }

    public boolean HI(int i) {
        return this.lKv.contains(HO(i));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dlq() {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl;
        do {
            com.facebook.cache.common.b dlr = dlr();
            if (dlr == null) {
                return null;
            }
            bl = this.lKv.bl(dlr);
        } while (bl == null);
        return bl;
    }

    @Nullable
    private synchronized com.facebook.cache.common.b dlr() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.lLE.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    private a HO(int i) {
        return new a(this.lLC, i);
    }
}
