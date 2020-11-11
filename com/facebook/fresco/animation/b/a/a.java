package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.fresco.animation.b.b {
    private static final Class<?> oJR = a.class;
    private final com.facebook.imagepipeline.animated.impl.c oRr;
    private final boolean oRs;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oRt = new SparseArray<>();
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oRu;

    public a(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.oRr = cVar;
        this.oRs = z;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OS(int i) {
        return h(this.oRr.OZ(i));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OT(int i) {
        return h(com.facebook.common.references.a.b(this.oRu));
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> af(int i, int i2, int i3) {
        return !this.oRs ? null : h(this.oRr.enj());
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean OU(int i) {
        return this.oRr.OU(i);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.c(this.oRu);
        this.oRu = null;
        for (int i = 0; i < this.oRt.size(); i++) {
            com.facebook.common.references.a.c(this.oRt.valueAt(i));
        }
        this.oRt.clear();
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        OV(i);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a.c(this.oRu);
            this.oRu = this.oRr.b(i, i3);
        }
        com.facebook.common.references.a.c(i3);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        g.checkNotNull(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i3 = i(aVar);
        if (i3 != null) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = this.oRr.b(i, i3);
            if (com.facebook.common.references.a.a(b)) {
                com.facebook.common.references.a.c(this.oRt.get(i));
                this.oRt.put(i, b);
                com.facebook.common.c.a.a(oJR, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.oRt);
            }
            com.facebook.common.references.a.c(i3);
        } else {
            com.facebook.common.references.a.c(i3);
        }
    }

    private synchronized void OV(int i) {
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oRt.get(i);
        if (aVar != null) {
            this.oRt.delete(i);
            com.facebook.common.references.a.c(aVar);
            com.facebook.common.c.a.a(oJR, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.oRt);
        }
    }

    @Nullable
    static com.facebook.common.references.a<Bitmap> h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        d dVar;
        try {
            if (com.facebook.common.references.a.a(aVar) && (aVar.get() instanceof d) && (dVar = (d) aVar.get()) != null) {
                return dVar.epT();
            }
            return null;
        } finally {
            com.facebook.common.references.a.c(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.g.c> i(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.e(new d(aVar, com.facebook.imagepipeline.g.g.oWX, 0));
    }
}
