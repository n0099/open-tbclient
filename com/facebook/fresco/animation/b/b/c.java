package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class c implements b {
    private static final Class<?> njM = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f nri;
    private final com.facebook.fresco.animation.b.c nrl;
    private final SparseArray<Runnable> nrw = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.nri = fVar;
        this.nrl = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.nrw) {
            if (this.nrw.get(a2) != null) {
                com.facebook.common.c.a.a(njM, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Lx(i)) {
                com.facebook.common.c.a.a(njM, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.nrw.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes6.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.a.a nqZ;
        private final com.facebook.fresco.animation.b.b nrj;
        private final int nrx;
        private final int nry;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.nqZ = aVar;
            this.nrj = bVar;
            this.nrx = i;
            this.nry = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.nrj.Lx(this.nrx)) {
                    com.facebook.common.c.a.a(c.njM, "Frame %d is cached already.", Integer.valueOf(this.nrx));
                    synchronized (c.this.nrw) {
                        c.this.nrw.remove(this.nry);
                    }
                    return;
                }
                if (dE(this.nrx, 1)) {
                    com.facebook.common.c.a.a(c.njM, "Prepared frame frame %d.", Integer.valueOf(this.nrx));
                } else {
                    com.facebook.common.c.a.d(c.njM, "Could not prepare frame %d.", Integer.valueOf(this.nrx));
                }
                synchronized (c.this.nrw) {
                    c.this.nrw.remove(this.nry);
                }
            } catch (Throwable th) {
                synchronized (c.this.nrw) {
                    c.this.nrw.remove(this.nry);
                    throw th;
                }
            }
        }

        private boolean dE(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.nrj.ab(i, this.nqZ.getIntrinsicWidth(), this.nqZ.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dE(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.nri.b(this.nqZ.getIntrinsicWidth(), this.nqZ.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.njM, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.nrl.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.njM, "Frame %d ready.", Integer.valueOf(this.nrx));
                synchronized (c.this.nrw) {
                    this.nrj.b(this.nrx, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
