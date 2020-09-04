package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> njM = a.class;
    private final com.facebook.imagepipeline.animated.impl.c nrp;
    private final boolean nrq;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nrr = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nrs;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.nrp = cVar;
        this.nrq = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lv(int i) {
        return h(this.nrp.LC(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lw(int i) {
        return h(com.facebook.common.references.a.b(this.nrs));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        return !this.nrq ? null : h(this.nrp.dRM());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Lx(int i) {
        return this.nrp.Lx(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.nrs);
        this.nrs = null;
        for (int i = 0; i < this.nrr.size(); i++) {
            com.facebook.common.references.a.c(this.nrr.valueAt(i));
        }
        this.nrr.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Ly(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.nrs);
            this.nrs = this.nrp.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.nrp.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.nrr.get(i));
                this.nrr.put(i, b);
                com.facebook.common.c.a.a(njM, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.nrr);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Ly(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nrr.get(i);
        if (aVar != null) {
            this.nrr.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(njM, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.nrr);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dUv();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.nwY, 0));
    }
}
