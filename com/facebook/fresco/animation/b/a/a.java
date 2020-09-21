package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> ntL = a.class;
    private final com.facebook.imagepipeline.animated.impl.c nBn;
    private final boolean nBo;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nBp = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nBq;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.nBn = cVar;
        this.nBo = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ma(int i) {
        return h(this.nBn.Mh(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Mb(int i) {
        return h(com.facebook.common.references.a.b(this.nBq));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.nBo ? null : h(this.nBn.dVK());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Mc(int i) {
        return this.nBn.Mc(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.nBq);
        this.nBq = null;
        for (int i = 0; i < this.nBp.size(); i++) {
            com.facebook.common.references.a.c(this.nBp.valueAt(i));
        }
        this.nBp.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Md(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.nBq);
            this.nBq = this.nBn.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.nBn.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.nBp.get(i));
                this.nBp.put(i, b);
                com.facebook.common.c.a.a(ntL, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.nBp);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Md(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nBp.get(i);
        if (aVar != null) {
            this.nBp.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(ntL, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.nBp);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dYt();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.nGV, 0));
    }
}
