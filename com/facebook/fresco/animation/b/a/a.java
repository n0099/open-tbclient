package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lGm = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lND;
    private final boolean lNE;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lNF = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lNG;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lND = cVar;
        this.lNE = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HP(int i) {
        return h(this.lND.HW(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HQ(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNG));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        return !this.lNE ? null : h(this.lND.dmv());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HR(int i) {
        return this.lND.HR(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lNG);
        this.lNG = null;
        for (int i = 0; i < this.lNF.size(); i++) {
            com.facebook.common.references.a.c(this.lNF.valueAt(i));
        }
        this.lNF.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HS(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lNG);
            this.lNG = this.lND.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lND.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lNF.get(i));
                this.lNF.put(i, b);
                com.facebook.common.c.a.a(lGm, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lNF);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HS(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lNF.get(i);
        if (aVar != null) {
            this.lNF.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lGm, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lNF);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dpe();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lTi, 0));
    }
}
