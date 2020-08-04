package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> mPz = a.class;
    private final com.facebook.imagepipeline.animated.impl.c mXi;
    private final boolean mXj;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mXk = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mXl;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.mXi = cVar;
        this.mXj = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IR(int i) {
        return h(this.mXi.IY(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IS(int i) {
        return h(com.facebook.common.references.a.b(this.mXl));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        return !this.mXj ? null : h(this.mXi.dFE());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean IT(int i) {
        return this.mXi.IT(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.mXl);
        this.mXl = null;
        for (int i = 0; i < this.mXk.size(); i++) {
            com.facebook.common.references.a.c(this.mXk.valueAt(i));
        }
        this.mXk.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        IU(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.mXl);
            this.mXl = this.mXi.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.mXi.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.mXk.get(i));
                this.mXk.put(i, b);
                com.facebook.common.c.a.a(mPz, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mXk);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void IU(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mXk.get(i);
        if (aVar != null) {
            this.mXk.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(mPz, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mXk);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dIn();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.ncQ, 0));
    }
}
