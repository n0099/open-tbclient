package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lCO = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lJS;
    private final boolean lJT;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lJU = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lJV;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lJS = cVar;
        this.lJT = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HG(int i) {
        return h(this.lJS.HN(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HH(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lJV));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        return !this.lJT ? null : h(this.lJS.dlq());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HI(int i) {
        return this.lJS.HI(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lJV);
        this.lJV = null;
        for (int i = 0; i < this.lJU.size(); i++) {
            com.facebook.common.references.a.c(this.lJU.valueAt(i));
        }
        this.lJU.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HJ(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lJV);
            this.lJV = this.lJS.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lJS.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lJU.get(i));
                this.lJU.put(i, b);
                com.facebook.common.c.a.a(lCO, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lJU);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HJ(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lJU.get(i);
        if (aVar != null) {
            this.lJU.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lCO, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lJU);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dnY();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lPw, 0));
    }
}
