package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> pnm = a.class;
    private final com.facebook.imagepipeline.animated.impl.c puG;
    private final boolean puH;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> puI = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> puJ;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.puG = cVar;
        this.puH = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OY(int i) {
        return h(this.puG.Pf(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OZ(int i) {
        return h(com.facebook.common.references.a.b(this.puJ));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ak(int i, int i2, int i3) {
        return !this.puH ? null : h(this.puG.etk());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pa(int i) {
        return this.puG.Pa(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.puJ);
        this.puJ = null;
        for (int i = 0; i < this.puI.size(); i++) {
            com.facebook.common.references.a.c(this.puI.valueAt(i));
        }
        this.puI.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Pb(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.puJ);
            this.puJ = this.puG.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = this.puG.b(i, i3);
            if (com.facebook.common.references.a.a(b2)) {
                com.facebook.common.references.a.c(this.puI.get(i));
                this.puI.put(i, b2);
                com.facebook.common.c.a.a(pnm, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.puI);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Pb(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.puI.get(i);
        if (aVar != null) {
            this.puI.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(pnm, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.puI);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.evQ();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.f(new d(aVar, com.facebook.imagepipeline.f.g.pAa, 0));
    }
}
