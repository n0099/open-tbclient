package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lQm = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lXN;
    private final boolean lXO;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lXP = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lXQ;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lXN = cVar;
        this.lXO = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GB(int i) {
        return h(this.lXN.GI(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GC(int i) {
        return h(com.facebook.common.references.a.b(this.lXQ));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.lXO ? null : h(this.lXN.dqh());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean GD(int i) {
        return this.lXN.GD(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXQ);
        this.lXQ = null;
        for (int i = 0; i < this.lXP.size(); i++) {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXP.valueAt(i));
        }
        this.lXP.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        GE(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXQ);
            this.lXQ = this.lXN.b(i, i3);
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lXN.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXP.get(i));
                this.lXP.put(i, b);
                com.facebook.common.c.a.a(lQm, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lXP);
            }
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
        } else {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i3);
        }
    }

    private synchronized void GE(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lXP.get(i);
        if (aVar != null) {
            this.lXP.delete(i);
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
            com.facebook.common.c.a.a(lQm, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lXP);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dsQ();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.c(new d(aVar, com.facebook.imagepipeline.g.g.mdy, 0));
    }
}
