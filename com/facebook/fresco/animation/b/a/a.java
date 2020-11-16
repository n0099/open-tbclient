package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> oLv = a.class;
    private final com.facebook.imagepipeline.animated.impl.c oSU;
    private final boolean oSV;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oSW = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oSX;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.oSU = cVar;
        this.oSV = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pv(int i) {
        return h(this.oSU.PC(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pw(int i) {
        return h(com.facebook.common.references.a.b(this.oSX));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        return !this.oSV ? null : h(this.oSU.enh());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Px(int i) {
        return this.oSU.Px(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.oSX);
        this.oSX = null;
        for (int i = 0; i < this.oSW.size(); i++) {
            com.facebook.common.references.a.c(this.oSW.valueAt(i));
        }
        this.oSW.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Py(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.oSX);
            this.oSX = this.oSU.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.oSU.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.oSW.get(i));
                this.oSW.put(i, b);
                com.facebook.common.c.a.a(oLv, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.oSW);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Py(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oSW.get(i);
        if (aVar != null) {
            this.oSW.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(oLv, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.oSW);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.epR();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.oYA, 0));
    }
}
