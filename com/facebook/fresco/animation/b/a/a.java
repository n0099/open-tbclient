package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> paD = a.class;
    private final com.facebook.imagepipeline.animated.impl.c phQ;
    private final boolean phR;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> phS = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> phT;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.phQ = cVar;
        this.phR = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qr(int i) {
        return h(this.phQ.Qy(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qs(int i) {
        return h(com.facebook.common.references.a.b(this.phT));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ah(int i, int i2, int i3) {
        return !this.phR ? null : h(this.phQ.esR());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Qt(int i) {
        return this.phQ.Qt(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.phT);
        this.phT = null;
        for (int i = 0; i < this.phS.size(); i++) {
            com.facebook.common.references.a.c(this.phS.valueAt(i));
        }
        this.phS.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Qu(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.phT);
            this.phT = this.phQ.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b = this.phQ.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.phS.get(i));
                this.phS.put(i, b);
                com.facebook.common.c.a.a(paD, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.phS);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Qu(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.phS.get(i);
        if (aVar != null) {
            this.phS.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(paD, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.phS);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.evw();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.f.g.pnp, 0));
    }
}
