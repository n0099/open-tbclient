package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes12.dex */
public class c implements b {
    private static final Class<?> lGr = c.class;
    private final f lNB;
    private final com.facebook.fresco.animation.b.c lNE;
    private final SparseArray<Runnable> lNP = new SparseArray<>();
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.lNB = fVar;
        this.lNE = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.lNP) {
            if (this.lNP.get(a2) != null) {
                com.facebook.common.c.a.a(lGr, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.HR(i)) {
                com.facebook.common.c.a.a(lGr, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.lNP.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes12.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.b.b lNC;
        private final int lNQ;
        private final int lNR;
        private final com.facebook.fresco.animation.a.a lNs;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.lNs = aVar;
            this.lNC = bVar;
            this.lNQ = i;
            this.lNR = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.lNC.HR(this.lNQ)) {
                    com.facebook.common.c.a.a(c.lGr, "Frame %d is cached already.", Integer.valueOf(this.lNQ));
                    synchronized (c.this.lNP) {
                        c.this.lNP.remove(this.lNR);
                    }
                    return;
                }
                if (ds(this.lNQ, 1)) {
                    com.facebook.common.c.a.a(c.lGr, "Prepared frame frame %d.", Integer.valueOf(this.lNQ));
                } else {
                    com.facebook.common.c.a.d(c.lGr, "Could not prepare frame %d.", Integer.valueOf(this.lNQ));
                }
                synchronized (c.this.lNP) {
                    c.this.lNP.remove(this.lNR);
                }
            } catch (Throwable th) {
                synchronized (c.this.lNP) {
                    c.this.lNP.remove(this.lNR);
                    throw th;
                }
            }
        }

        private boolean ds(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.lNC.ac(i, this.lNs.getIntrinsicWidth(), this.lNs.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : ds(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.lNB.b(this.lNs.getIntrinsicWidth(), this.lNs.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.lGr, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.lNE.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.lGr, "Frame %d ready.", Integer.valueOf(this.lNQ));
                synchronized (c.this.lNP) {
                    this.lNC.b(this.lNQ, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
