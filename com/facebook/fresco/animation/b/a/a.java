package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lQq = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lXR;
    private final boolean lXS;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lXT = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lXU;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lXR = cVar;
        this.lXS = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GB(int i) {
        return h(this.lXR.GI(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GC(int i) {
        return h(com.facebook.common.references.a.b(this.lXU));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.lXS ? null : h(this.lXR.dqe());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean GD(int i) {
        return this.lXR.GD(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXU);
        this.lXU = null;
        for (int i = 0; i < this.lXT.size(); i++) {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXT.valueAt(i));
        }
        this.lXT.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        GE(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXU);
            this.lXU = this.lXR.b(i, i3);
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lXR.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXT.get(i));
                this.lXT.put(i, b);
                com.facebook.common.c.a.a(lQq, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lXT);
            }
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
        } else {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
        }
    }

    private synchronized void GE(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lXT.get(i);
        if (aVar != null) {
            this.lXT.delete(i);
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
            com.facebook.common.c.a.a(lQq, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lXT);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dsN();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.c(new d(aVar, com.facebook.imagepipeline.g.g.mdC, 0));
    }
}
