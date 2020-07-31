package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> mPx = a.class;
    private final com.facebook.imagepipeline.animated.impl.c mXg;
    private final boolean mXh;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mXi = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mXj;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.mXg = cVar;
        this.mXh = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IR(int i) {
        return h(this.mXg.IY(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IS(int i) {
        return h(com.facebook.common.references.a.b(this.mXj));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        return !this.mXh ? null : h(this.mXg.dFD());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean IT(int i) {
        return this.mXg.IT(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.mXj);
        this.mXj = null;
        for (int i = 0; i < this.mXi.size(); i++) {
            com.facebook.common.references.a.c(this.mXi.valueAt(i));
        }
        this.mXi.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        IU(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.mXj);
            this.mXj = this.mXg.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.mXg.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.mXi.get(i));
                this.mXi.put(i, b);
                com.facebook.common.c.a.a(mPx, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mXi);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void IU(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mXi.get(i);
        if (aVar != null) {
            this.mXi.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(mPx, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mXi);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dIm();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.ncO, 0));
    }
}
