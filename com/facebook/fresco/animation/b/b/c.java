package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class c implements b {
    private static final Class<?> pxC = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f pEI;
    private final com.facebook.fresco.animation.b.c pEL;
    private final SparseArray<Runnable> pEW = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.pEI = fVar;
        this.pEL = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.pEW) {
            if (this.pEW.get(a2) != null) {
                com.facebook.common.c.a.c(pxC, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Pv(i)) {
                com.facebook.common.c.a.c(pxC, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.pEW.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes5.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.b.b pEJ;
        private final int pEX;
        private final int pEY;
        private final com.facebook.fresco.animation.a.a pEz;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.pEz = aVar;
            this.pEJ = bVar;
            this.pEX = i;
            this.pEY = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.pEJ.Pv(this.pEX)) {
                    com.facebook.common.c.a.c(c.pxC, "Frame %d is cached already.", Integer.valueOf(this.pEX));
                    synchronized (c.this.pEW) {
                        c.this.pEW.remove(this.pEY);
                    }
                    return;
                }
                if (dX(this.pEX, 1)) {
                    com.facebook.common.c.a.c(c.pxC, "Prepared frame frame %d.", Integer.valueOf(this.pEX));
                } else {
                    com.facebook.common.c.a.d((Class<?>) c.pxC, "Could not prepare frame %d.", Integer.valueOf(this.pEX));
                }
                synchronized (c.this.pEW) {
                    c.this.pEW.remove(this.pEY);
                }
            } catch (Throwable th) {
                synchronized (c.this.pEW) {
                    c.this.pEW.remove(this.pEY);
                    throw th;
                }
            }
        }

        private boolean dX(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.pEJ.ai(i, this.pEz.getIntrinsicWidth(), this.pEz.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dX(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.pEI.f(this.pEz.getIntrinsicWidth(), this.pEz.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a(c.pxC, "Failed to create frame bitmap", e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.pEL.c(i, aVar.get())) {
                com.facebook.common.c.a.c(c.pxC, "Frame %d ready.", Integer.valueOf(this.pEX));
                synchronized (c.this.pEW) {
                    this.pEJ.b(this.pEX, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
