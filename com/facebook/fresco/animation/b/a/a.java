package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> oAy = a.class;
    private final com.facebook.imagepipeline.animated.impl.c oHY;
    private final boolean oHZ;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oIa = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oIb;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.oHY = cVar;
        this.oHZ = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ox(int i) {
        return h(this.oHY.OE(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Oy(int i) {
        return h(com.facebook.common.references.a.b(this.oIb));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> af(int i, int i2, int i3) {
        return !this.oHZ ? null : h(this.oHY.ejt());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Oz(int i) {
        return this.oHY.Oz(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.oIb);
        this.oIb = null;
        for (int i = 0; i < this.oIa.size(); i++) {
            com.facebook.common.references.a.c(this.oIa.valueAt(i));
        }
        this.oIa.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        OA(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.oIb);
            this.oIb = this.oHY.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.oHY.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.oIa.get(i));
                this.oIa.put(i, b);
                com.facebook.common.c.a.a(oAy, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.oIa);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void OA(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oIa.get(i);
        if (aVar != null) {
            this.oIa.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(oAy, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.oIa);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.emc();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.oNE, 0));
    }
}
