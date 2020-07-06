package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> mHr = a.class;
    private final com.facebook.imagepipeline.animated.impl.c mOW;
    private final boolean mOX;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mOY = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mOZ;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.mOW = cVar;
        this.mOX = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Iw(int i) {
        return h(this.mOW.ID(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ix(int i) {
        return h(com.facebook.common.references.a.b(this.mOZ));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.mOX ? null : h(this.mOW.dCr());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Iy(int i) {
        return this.mOW.Iy(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.mOZ);
        this.mOZ = null;
        for (int i = 0; i < this.mOY.size(); i++) {
            com.facebook.common.references.a.c(this.mOY.valueAt(i));
        }
        this.mOY.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Iz(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.mOZ);
            this.mOZ = this.mOW.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.mOW.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.mOY.get(i));
                this.mOY.put(i, b);
                com.facebook.common.c.a.a(mHr, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mOY);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Iz(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mOY.get(i);
        if (aVar != null) {
            this.mOY.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(mHr, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mOY);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dFa();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.mUN, 0));
    }
}
