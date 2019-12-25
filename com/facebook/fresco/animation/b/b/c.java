package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes11.dex */
public class c implements b {
    private static final Class<?> lCO = c.class;
    private final f lJL;
    private final com.facebook.fresco.animation.b.c lJO;
    private final SparseArray<Runnable> lJZ = new SparseArray<>();
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.lJL = fVar;
        this.lJO = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.lJZ) {
            if (this.lJZ.get(a2) != null) {
                com.facebook.common.c.a.a(lCO, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.HI(i)) {
                com.facebook.common.c.a.a(lCO, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.lJZ.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes11.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.a.a lJC;
        private final com.facebook.fresco.animation.b.b lJM;
        private final int lKa;
        private final int lKb;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.lJC = aVar;
            this.lJM = bVar;
            this.lKa = i;
            this.lKb = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.lJM.HI(this.lKa)) {
                    com.facebook.common.c.a.a(c.lCO, "Frame %d is cached already.", Integer.valueOf(this.lKa));
                    synchronized (c.this.lJZ) {
                        c.this.lJZ.remove(this.lKb);
                    }
                    return;
                }
                if (du(this.lKa, 1)) {
                    com.facebook.common.c.a.a(c.lCO, "Prepared frame frame %d.", Integer.valueOf(this.lKa));
                } else {
                    com.facebook.common.c.a.d(c.lCO, "Could not prepare frame %d.", Integer.valueOf(this.lKa));
                }
                synchronized (c.this.lJZ) {
                    c.this.lJZ.remove(this.lKb);
                }
            } catch (Throwable th) {
                synchronized (c.this.lJZ) {
                    c.this.lJZ.remove(this.lKb);
                    throw th;
                }
            }
        }

        private boolean du(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.lJM.ac(i, this.lJC.getIntrinsicWidth(), this.lJC.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : du(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.lJL.b(this.lJC.getIntrinsicWidth(), this.lJC.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.lCO, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.lJO.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.lCO, "Frame %d ready.", Integer.valueOf(this.lKa));
                synchronized (c.this.lJZ) {
                    this.lJM.b(this.lKa, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
