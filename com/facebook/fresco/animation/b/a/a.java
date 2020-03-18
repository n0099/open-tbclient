package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lIR = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lQi;
    private final boolean lQj;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lQk = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lQl;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lQi = cVar;
        this.lQj = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ia(int i) {
        return h(this.lQi.Ih(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ib(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lQl));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        return !this.lQj ? null : h(this.lQi.dok());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Ic(int i) {
        return this.lQi.Ic(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lQl);
        this.lQl = null;
        for (int i = 0; i < this.lQk.size(); i++) {
            com.facebook.common.references.a.c(this.lQk.valueAt(i));
        }
        this.lQk.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Id(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lQl);
            this.lQl = this.lQi.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lQi.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lQk.get(i));
                this.lQk.put(i, b);
                com.facebook.common.c.a.a(lIR, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lQk);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Id(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lQk.get(i);
        if (aVar != null) {
            this.lQk.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lIR, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lQk);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dqS();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lVN, 0));
    }
}
