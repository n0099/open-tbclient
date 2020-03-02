package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lHa = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lOr;
    private final boolean lOs;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOt = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lOu;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lOr = cVar;
        this.lOs = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return h(this.lOr.Ib(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOu));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        return !this.lOs ? null : h(this.lOr.dnM());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        return this.lOr.HW(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lOu);
        this.lOu = null;
        for (int i = 0; i < this.lOt.size(); i++) {
            com.facebook.common.references.a.c(this.lOt.valueAt(i));
        }
        this.lOt.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HX(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lOu);
            this.lOu = this.lOr.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lOr.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lOt.get(i));
                this.lOt.put(i, b);
                com.facebook.common.c.a.a(lHa, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lOt);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HX(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lOt.get(i);
        if (aVar != null) {
            this.lOt.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lHa, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lOt);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dqu();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lTW, 0));
    }
}
