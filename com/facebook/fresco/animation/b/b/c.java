package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class c implements b {
    private static final Class<?> pyc = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f pFi;
    private final com.facebook.fresco.animation.b.c pFl;
    private final SparseArray<Runnable> pFw = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.pFi = fVar;
        this.pFl = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.pFw) {
            if (this.pFw.get(a2) != null) {
                com.facebook.common.c.a.c(pyc, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Pw(i)) {
                com.facebook.common.c.a.c(pyc, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.pFw.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a pEZ;
        private final com.facebook.fresco.animation.b.b pFj;
        private final int pFx;
        private final int pFy;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.pEZ = aVar;
            this.pFj = bVar;
            this.pFx = i;
            this.pFy = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.pFj.Pw(this.pFx)) {
                    com.facebook.common.c.a.c(c.pyc, "Frame %d is cached already.", Integer.valueOf(this.pFx));
                    synchronized (c.this.pFw) {
                        c.this.pFw.remove(this.pFy);
                    }
                    return;
                }
                if (dY(this.pFx, 1)) {
                    com.facebook.common.c.a.c(c.pyc, "Prepared frame frame %d.", Integer.valueOf(this.pFx));
                } else {
                    com.facebook.common.c.a.d((Class<?>) c.pyc, "Could not prepare frame %d.", Integer.valueOf(this.pFx));
                }
                synchronized (c.this.pFw) {
                    c.this.pFw.remove(this.pFy);
                }
            } catch (Throwable th) {
                synchronized (c.this.pFw) {
                    c.this.pFw.remove(this.pFy);
                    throw th;
                }
            }
        }

        private boolean dY(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.pFj.ai(i, this.pEZ.getIntrinsicWidth(), this.pEZ.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dY(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.pFi.f(this.pEZ.getIntrinsicWidth(), this.pEZ.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a(c.pyc, "Failed to create frame bitmap", e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.pFl.c(i, aVar.get())) {
                com.facebook.common.c.a.c(c.pyc, "Frame %d ready.", Integer.valueOf(this.pFx));
                synchronized (c.this.pFw) {
                    this.pFj.b(this.pFx, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
