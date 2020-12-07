package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes11.dex */
public class c implements b {
    private static final Class<?> paD = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f phJ;
    private final com.facebook.fresco.animation.b.c phM;
    private final SparseArray<Runnable> phX = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.phJ = fVar;
        this.phM = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.phX) {
            if (this.phX.get(a2) != null) {
                com.facebook.common.c.a.a(paD, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Qt(i)) {
                com.facebook.common.c.a.a(paD, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.phX.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a phA;
        private final com.facebook.fresco.animation.b.b phK;
        private final int phY;
        private final int phZ;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.phA = aVar;
            this.phK = bVar;
            this.phY = i;
            this.phZ = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.phK.Qt(this.phY)) {
                    com.facebook.common.c.a.a(c.paD, "Frame %d is cached already.", Integer.valueOf(this.phY));
                    synchronized (c.this.phX) {
                        c.this.phX.remove(this.phZ);
                    }
                    return;
                }
                if (ea(this.phY, 1)) {
                    com.facebook.common.c.a.a(c.paD, "Prepared frame frame %d.", Integer.valueOf(this.phY));
                } else {
                    com.facebook.common.c.a.d(c.paD, "Could not prepare frame %d.", Integer.valueOf(this.phY));
                }
                synchronized (c.this.phX) {
                    c.this.phX.remove(this.phZ);
                }
            } catch (Throwable th) {
                synchronized (c.this.phX) {
                    c.this.phX.remove(this.phZ);
                    throw th;
                }
            }
        }

        private boolean ea(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.phK.ah(i, this.phA.getIntrinsicWidth(), this.phA.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : ea(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.phJ.b(this.phA.getIntrinsicWidth(), this.phA.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.paD, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.phM.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.paD, "Frame %d ready.", Integer.valueOf(this.phY));
                synchronized (c.this.phX) {
                    this.phK.b(this.phY, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
