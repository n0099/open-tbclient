package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> nju = a.class;
    private final com.facebook.imagepipeline.animated.impl.c nqX;
    private final boolean nqY;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nqZ = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nra;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.nqX = cVar;
        this.nqY = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lv(int i) {
        return h(this.nqX.LC(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lw(int i) {
        return h(com.facebook.common.references.a.b(this.nra));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        return !this.nqY ? null : h(this.nqX.dRD());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Lx(int i) {
        return this.nqX.Lx(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.nra);
        this.nra = null;
        for (int i = 0; i < this.nqZ.size(); i++) {
            com.facebook.common.references.a.c(this.nqZ.valueAt(i));
        }
        this.nqZ.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Ly(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.nra);
            this.nra = this.nqX.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.nqX.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.nqZ.get(i));
                this.nqZ.put(i, b);
                com.facebook.common.c.a.a(nju, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.nqZ);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Ly(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nqZ.get(i);
        if (aVar != null) {
            this.nqZ.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(nju, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.nqZ);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dUm();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.nwG, 0));
    }
}
