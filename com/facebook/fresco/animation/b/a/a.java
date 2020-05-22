package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> mki = a.class;
    private final com.facebook.imagepipeline.animated.impl.c mrL;
    private final boolean mrM;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mrN = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mrO;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.mrL = cVar;
        this.mrM = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hn(int i) {
        return h(this.mrL.Hu(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ho(int i) {
        return h(com.facebook.common.references.a.b(this.mrO));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        return !this.mrM ? null : h(this.mrL.dxx());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Hp(int i) {
        return this.mrL.Hp(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.mrO);
        this.mrO = null;
        for (int i = 0; i < this.mrN.size(); i++) {
            com.facebook.common.references.a.c(this.mrN.valueAt(i));
        }
        this.mrN.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        Hq(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.mrO);
            this.mrO = this.mrL.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.mrL.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.mrN.get(i));
                this.mrN.put(i, b);
                com.facebook.common.c.a.a(mki, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mrN);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void Hq(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mrN.get(i);
        if (aVar != null) {
            this.mrN.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(mki, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mrN);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dAg();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.mxt, 0));
    }
}
