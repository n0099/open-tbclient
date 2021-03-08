package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> pAh = a.class;
    private final com.facebook.imagepipeline.animated.impl.c pHu;
    private final boolean pHv;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pHw = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pHx;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.pHu = cVar;
        this.pHv = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Py(int i) {
        return h(this.pHu.PF(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pz(int i) {
        return h(com.facebook.common.references.a.b(this.pHx));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        return !this.pHv ? null : h(this.pHu.evT());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean PA(int i) {
        return this.pHu.PA(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.pHx);
        this.pHx = null;
        for (int i = 0; i < this.pHw.size(); i++) {
            com.facebook.common.references.a.c(this.pHw.valueAt(i));
        }
        this.pHw.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        PB(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.pHx);
            this.pHx = this.pHu.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b = this.pHu.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.pHw.get(i));
                this.pHw.put(i, b);
                com.facebook.common.c.a.a(pAh, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.pHw);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void PB(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pHw.get(i);
        if (aVar != null) {
            this.pHw.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(pAh, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.pHw);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.eyA();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.d(new d(aVar, com.facebook.imagepipeline.f.g.pMO, 0));
    }
}
