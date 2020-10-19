package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> nJf = a.class;
    private final com.facebook.imagepipeline.animated.impl.c nQG;
    private final boolean nQH;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nQI = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nQJ;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.nQG = cVar;
        this.nQH = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> MG(int i) {
        return h(this.nQG.MN(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> MH(int i) {
        return h(com.facebook.common.references.a.b(this.nQJ));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.nQH ? null : h(this.nQG.dZv());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean MI(int i) {
        return this.nQG.MI(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.nQJ);
        this.nQJ = null;
        for (int i = 0; i < this.nQI.size(); i++) {
            com.facebook.common.references.a.c(this.nQI.valueAt(i));
        }
        this.nQI.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        MJ(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.nQJ);
            this.nQJ = this.nQG.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.nQG.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.nQI.get(i));
                this.nQI.put(i, b);
                com.facebook.common.c.a.a(nJf, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.nQI);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void MJ(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nQI.get(i);
        if (aVar != null) {
            this.nQI.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(nJf, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.nQI);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.ece();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.nWm, 0));
    }
}
