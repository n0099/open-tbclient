package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> paF = a.class;
    private final com.facebook.imagepipeline.animated.impl.c phS;
    private final boolean phT;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> phU = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> phV;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.phS = cVar;
        this.phT = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qr(int i) {
        return h(this.phS.Qy(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qs(int i) {
        return h(com.facebook.common.references.a.b(this.phV));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ah(int i, int i2, int i3) {
        return !this.phT ? null : h(this.phS.esS());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Qt(int i) {
        return this.phS.Qt(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.phV);
        this.phV = null;
        for (int i = 0; i < this.phU.size(); i++) {
            com.facebook.common.references.a.c(this.phU.valueAt(i));
        }
        this.phU.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Qu(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.phV);
            this.phV = this.phS.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b = this.phS.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.phU.get(i));
                this.phU.put(i, b);
                com.facebook.common.c.a.a(paF, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.phU);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Qu(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.phU.get(i);
        if (aVar != null) {
            this.phU.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(paF, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.phU);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.evx();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.f.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.f.g.pnr, 0));
    }
}
