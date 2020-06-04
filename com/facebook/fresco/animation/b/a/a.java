package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> mls = a.class;
    private final com.facebook.imagepipeline.animated.impl.c msW;
    private final boolean msX;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> msY = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> msZ;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.msW = cVar;
        this.msX = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hp(int i) {
        return h(this.msW.Hw(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hq(int i) {
        return h(com.facebook.common.references.a.b(this.msZ));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.msX ? null : h(this.msW.dxL());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Hr(int i) {
        return this.msW.Hr(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.msZ);
        this.msZ = null;
        for (int i = 0; i < this.msY.size(); i++) {
            com.facebook.common.references.a.c(this.msY.valueAt(i));
        }
        this.msY.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Hs(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.msZ);
            this.msZ = this.msW.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.msW.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.msY.get(i));
                this.msY.put(i, b);
                com.facebook.common.c.a.a(mls, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.msY);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Hs(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.msY.get(i);
        if (aVar != null) {
            this.msY.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(mls, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.msY);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dAu();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.myD, 0));
    }
}
