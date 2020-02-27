package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> lGY = c.class;
    private final f lOi;
    private final com.facebook.fresco.animation.b.c lOl;
    private final SparseArray<Runnable> lOw = new SparseArray<>();
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.lOi = fVar;
        this.lOl = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.lOw) {
            if (this.lOw.get(a2) != null) {
                com.facebook.common.c.a.a(lGY, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.HW(i)) {
                com.facebook.common.c.a.a(lGY, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.lOw.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a lNZ;
        private final com.facebook.fresco.animation.b.b lOj;
        private final int lOx;
        private final int lOy;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.lNZ = aVar;
            this.lOj = bVar;
            this.lOx = i;
            this.lOy = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.lOj.HW(this.lOx)) {
                    com.facebook.common.c.a.a(c.lGY, "Frame %d is cached already.", Integer.valueOf(this.lOx));
                    synchronized (c.this.lOw) {
                        c.this.lOw.remove(this.lOy);
                    }
                    return;
                }
                if (dv(this.lOx, 1)) {
                    com.facebook.common.c.a.a(c.lGY, "Prepared frame frame %d.", Integer.valueOf(this.lOx));
                } else {
                    com.facebook.common.c.a.d(c.lGY, "Could not prepare frame %d.", Integer.valueOf(this.lOx));
                }
                synchronized (c.this.lOw) {
                    c.this.lOw.remove(this.lOy);
                }
            } catch (Throwable th) {
                synchronized (c.this.lOw) {
                    c.this.lOw.remove(this.lOy);
                    throw th;
                }
            }
        }

        private boolean dv(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.lOj.ad(i, this.lNZ.getIntrinsicWidth(), this.lNZ.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dv(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.lOi.b(this.lNZ.getIntrinsicWidth(), this.lNZ.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.lGY, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.lOl.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.lGY, "Frame %d ready.", Integer.valueOf(this.lOx));
                synchronized (c.this.lOw) {
                    this.lOj.b(this.lOx, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
