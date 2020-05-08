package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> lQq = c.class;
    private final f lXK;
    private final com.facebook.fresco.animation.b.c lXN;
    private final SparseArray<Runnable> lXY = new SparseArray<>();
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.lXK = fVar;
        this.lXN = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.lXY) {
            if (this.lXY.get(a2) != null) {
                com.facebook.common.c.a.a(lQq, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.GD(i)) {
                com.facebook.common.c.a.a(lQq, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.lXY.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes13.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.a.a lXB;
        private final com.facebook.fresco.animation.b.b lXL;
        private final int lXZ;
        private final int lYa;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.lXB = aVar;
            this.lXL = bVar;
            this.lXZ = i;
            this.lYa = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.lXL.GD(this.lXZ)) {
                    com.facebook.common.c.a.a(c.lQq, "Frame %d is cached already.", Integer.valueOf(this.lXZ));
                    synchronized (c.this.lXY) {
                        c.this.lXY.remove(this.lYa);
                    }
                    return;
                }
                if (dg(this.lXZ, 1)) {
                    com.facebook.common.c.a.a(c.lQq, "Prepared frame frame %d.", Integer.valueOf(this.lXZ));
                } else {
                    com.facebook.common.c.a.d(c.lQq, "Could not prepare frame %d.", Integer.valueOf(this.lXZ));
                }
                synchronized (c.this.lXY) {
                    c.this.lXY.remove(this.lYa);
                }
            } catch (Throwable th) {
                synchronized (c.this.lXY) {
                    c.this.lXY.remove(this.lYa);
                    throw th;
                }
            }
        }

        private boolean dg(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.lXL.ae(i, this.lXB.getIntrinsicWidth(), this.lXB.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                            return (c || i3 == -1) ? c : dg(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.lXK.b(this.lXB.getIntrinsicWidth(), this.lXB.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.lQq, "Failed to create frame bitmap", (Throwable) e);
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) null);
                            return false;
                        }
                    default:
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) null);
                        return false;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }

        private boolean c(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
            if (com.facebook.common.references.a.a(aVar) && c.this.lXN.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.lQq, "Frame %d ready.", Integer.valueOf(this.lXZ));
                synchronized (c.this.lXY) {
                    this.lXL.b(this.lXZ, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
