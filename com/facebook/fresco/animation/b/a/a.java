package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> pxC = a.class;
    private final com.facebook.imagepipeline.animated.impl.c pEP;
    private final boolean pEQ;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pER = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pES;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.pEP = cVar;
        this.pEQ = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pt(int i) {
        return h(this.pEP.PA(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pu(int i) {
        return h(com.facebook.common.references.a.b(this.pES));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        return !this.pEQ ? null : h(this.pEP.evC());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pv(int i) {
        return this.pEP.Pv(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.pES);
        this.pES = null;
        for (int i = 0; i < this.pER.size(); i++) {
            com.facebook.common.references.a.c(this.pER.valueAt(i));
        }
        this.pER.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Pw(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.pES);
            this.pES = this.pEP.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = this.pEP.b(i, i3);
            if (com.facebook.common.references.a.a(b2)) {
                com.facebook.common.references.a.c(this.pER.get(i));
                this.pER.put(i, b2);
                com.facebook.common.c.a.a(pxC, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.pER);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Pw(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pER.get(i);
        if (aVar != null) {
            this.pER.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(pxC, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.pER);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.eyj();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.f.g.pKj, 0));
    }
}
