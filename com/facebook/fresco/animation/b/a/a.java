package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> prR = a.class;
    private final com.facebook.imagepipeline.animated.impl.c pzh;
    private final boolean pzi;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzj = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pzk;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.pzh = cVar;
        this.pzi = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> QF(int i) {
        return h(this.pzh.QM(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> QG(int i) {
        return h(com.facebook.common.references.a.b(this.pzk));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ak(int i, int i2, int i3) {
        return !this.pzi ? null : h(this.pzh.exc());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean QH(int i) {
        return this.pzh.QH(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.pzk);
        this.pzk = null;
        for (int i = 0; i < this.pzj.size(); i++) {
            com.facebook.common.references.a.c(this.pzj.valueAt(i));
        }
        this.pzj.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        QI(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.pzk);
            this.pzk = this.pzh.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = this.pzh.b(i, i3);
            if (com.facebook.common.references.a.a(b2)) {
                com.facebook.common.references.a.c(this.pzj.get(i));
                this.pzj.put(i, b2);
                com.facebook.common.c.a.a(prR, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.pzj);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void QI(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pzj.get(i);
        if (aVar != null) {
            this.pzj.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(prR, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.pzj);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.ezI();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.f(new d(aVar, com.facebook.imagepipeline.f.g.pEB, 0));
    }
}
