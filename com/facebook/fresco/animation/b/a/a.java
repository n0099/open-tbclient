package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> pyc = a.class;
    private final com.facebook.imagepipeline.animated.impl.c pFp;
    private final boolean pFq;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pFr = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pFs;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.pFp = cVar;
        this.pFq = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pu(int i) {
        return h(this.pFp.PB(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pv(int i) {
        return h(com.facebook.common.references.a.b(this.pFs));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        return !this.pFq ? null : h(this.pFp.evK());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pw(int i) {
        return this.pFp.Pw(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.pFs);
        this.pFs = null;
        for (int i = 0; i < this.pFr.size(); i++) {
            com.facebook.common.references.a.c(this.pFr.valueAt(i));
        }
        this.pFr.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Px(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.pFs);
            this.pFs = this.pFp.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = this.pFp.b(i, i3);
            if (com.facebook.common.references.a.a(b2)) {
                com.facebook.common.references.a.c(this.pFr.get(i));
                this.pFr.put(i, b2);
                com.facebook.common.c.a.a(pyc, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.pFr);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Px(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pFr.get(i);
        if (aVar != null) {
            this.pFr.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(pyc, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.pFr);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.eyr();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.f.g.pKJ, 0));
    }
}
