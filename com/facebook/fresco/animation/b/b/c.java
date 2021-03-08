package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class c implements b {
    private static final Class<?> pAh = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final SparseArray<Runnable> pHB = new SparseArray<>();
    private final f pHn;
    private final com.facebook.fresco.animation.b.c pHq;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.pHn = fVar;
        this.pHq = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.pHB) {
            if (this.pHB.get(a2) != null) {
                com.facebook.common.c.a.a(pAh, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.PA(i)) {
                com.facebook.common.c.a.a(pAh, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.pHB.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes4.dex */
    private class a implements Runnable {
        private final int pHC;
        private final int pHD;
        private final com.facebook.fresco.animation.a.a pHe;
        private final com.facebook.fresco.animation.b.b pHo;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.pHe = aVar;
            this.pHo = bVar;
            this.pHC = i;
            this.pHD = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.pHo.PA(this.pHC)) {
                    com.facebook.common.c.a.a(c.pAh, "Frame %d is cached already.", Integer.valueOf(this.pHC));
                    synchronized (c.this.pHB) {
                        c.this.pHB.remove(this.pHD);
                    }
                    return;
                }
                if (dY(this.pHC, 1)) {
                    com.facebook.common.c.a.a(c.pAh, "Prepared frame frame %d.", Integer.valueOf(this.pHC));
                } else {
                    com.facebook.common.c.a.d(c.pAh, "Could not prepare frame %d.", Integer.valueOf(this.pHC));
                }
                synchronized (c.this.pHB) {
                    c.this.pHB.remove(this.pHD);
                }
            } catch (Throwable th) {
                synchronized (c.this.pHB) {
                    c.this.pHB.remove(this.pHD);
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
                        aVar = this.pHo.ai(i, this.pHe.getIntrinsicWidth(), this.pHe.getIntrinsicHeight());
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
                            aVar = c.this.pHn.f(this.pHe.getIntrinsicWidth(), this.pHe.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.pAh, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.pHq.c(i, aVar.get())) {
                com.facebook.common.c.a.a(c.pAh, "Frame %d ready.", Integer.valueOf(this.pHC));
                synchronized (c.this.pHB) {
                    this.pHo.b(this.pHC, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
