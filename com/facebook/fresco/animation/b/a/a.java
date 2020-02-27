package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lGY = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lOp;
    private final boolean lOq;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOr = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lOs;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lOp = cVar;
        this.lOq = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return h(this.lOp.Ib(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOs));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        return !this.lOq ? null : h(this.lOp.dnK());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        return this.lOp.HW(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lOs);
        this.lOs = null;
        for (int i = 0; i < this.lOr.size(); i++) {
            com.facebook.common.references.a.c(this.lOr.valueAt(i));
        }
        this.lOr.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HX(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lOs);
            this.lOs = this.lOp.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lOp.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lOr.get(i));
                this.lOr.put(i, b);
                com.facebook.common.c.a.a(lGY, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lOr);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HX(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lOr.get(i);
        if (aVar != null) {
            this.lOr.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lGY, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lOr);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dqs();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lTU, 0));
    }
}
