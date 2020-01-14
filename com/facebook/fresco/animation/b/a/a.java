package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> lGr = a.class;
    private final com.facebook.imagepipeline.animated.impl.c lNI;
    private final boolean lNJ;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lNK = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lNL;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.lNI = cVar;
        this.lNJ = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HP(int i) {
        return h(this.lNI.HW(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HQ(int i) {
        return h(com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNL));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        return !this.lNJ ? null : h(this.lNI.dmx());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HR(int i) {
        return this.lNI.HR(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.lNL);
        this.lNL = null;
        for (int i = 0; i < this.lNK.size(); i++) {
            com.facebook.common.references.a.c(this.lNK.valueAt(i));
        }
        this.lNK.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        HS(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.lNL);
            this.lNL = this.lNI.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.lNI.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.lNK.get(i));
                this.lNK.put(i, b);
                com.facebook.common.c.a.a(lGr, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.lNK);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void HS(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lNK.get(i);
        if (aVar != null) {
            this.lNK.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(lGr, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.lNK);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.dpg();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.b(new d(aVar, com.facebook.imagepipeline.g.g.lTn, 0));
    }
}
