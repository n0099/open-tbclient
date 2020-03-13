package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lHl = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lOC;
    private final boolean lOD;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOE = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lOF;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lOC = cVar;
        this.lOD = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return h(this.lOC.Ib(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOF));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        return !this.lOD ? null : h(this.lOC.dnN());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        return this.lOC.HW(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lOF);
        this.lOF = null;
        for (int i = 0; i < this.lOE.size(); i++) {
            com.facebook.common.references.a.c(this.lOE.valueAt(i));
        }
        this.lOE.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HX(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lOF);
            this.lOF = this.lOC.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lOC.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lOE.get(i));
                this.lOE.put(i, b);
                com.facebook.common.c.a.a(lHl, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lOE);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HX(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lOE.get(i);
        if (aVar != null) {
            this.lOE.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lHl, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lOE);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dqv();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lUh, 0));
    }
}
