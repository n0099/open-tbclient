package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public class c implements b {
    private static final Class<?> oJR = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f oRk;
    private final com.facebook.fresco.animation.b.c oRn;
    private final SparseArray<Runnable> oRy = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.oRk = fVar;
        this.oRn = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.oRy) {
            if (this.oRy.get(a2) != null) {
                com.facebook.common.c.a.a(oJR, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.OU(i)) {
                com.facebook.common.c.a.a(oJR, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.oRy.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes14.dex */
    private class a implements Runnable {
        private final int oRA;
        private final com.facebook.fresco.animation.a.a oRb;
        private final com.facebook.fresco.animation.b.b oRl;
        private final int oRz;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.oRb = aVar;
            this.oRl = bVar;
            this.oRz = i;
            this.oRA = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.oRl.OU(this.oRz)) {
                    com.facebook.common.c.a.a(c.oJR, "Frame %d is cached already.", Integer.valueOf(this.oRz));
                    synchronized (c.this.oRy) {
                        c.this.oRy.remove(this.oRA);
                    }
                    return;
                }
                if (dU(this.oRz, 1)) {
                    com.facebook.common.c.a.a(c.oJR, "Prepared frame frame %d.", Integer.valueOf(this.oRz));
                } else {
                    com.facebook.common.c.a.d(c.oJR, "Could not prepare frame %d.", Integer.valueOf(this.oRz));
                }
                synchronized (c.this.oRy) {
                    c.this.oRy.remove(this.oRA);
                }
            } catch (Throwable th) {
                synchronized (c.this.oRy) {
                    c.this.oRy.remove(this.oRA);
                    throw th;
                }
            }
        }

        private boolean dU(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.oRl.af(i, this.oRb.getIntrinsicWidth(), this.oRb.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dU(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.oRk.b(this.oRb.getIntrinsicWidth(), this.oRb.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.oJR, "Failed to create frame bitmap", (Throwable) e);
                            com.facebook.common.references.a.c(null);
                            return false;
                        }
                    default:
                        com.facebook.common.references.a.c(null);
                        return false;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }

        private boolean c(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
            if (com.facebook.common.references.a.a(aVar) && c.this.oRn.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.oJR, "Frame %d ready.", Integer.valueOf(this.oRz));
                synchronized (c.this.oRy) {
                    this.oRl.b(this.oRz, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
