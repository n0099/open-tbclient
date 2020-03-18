package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> lIR = c.class;
    private final f lQb;
    private final com.facebook.fresco.animation.b.c lQe;
    private final SparseArray<Runnable> lQp = new SparseArray<>();
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.lQb = fVar;
        this.lQe = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.lQp) {
            if (this.lQp.get(a2) != null) {
                com.facebook.common.c.a.a(lIR, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Ic(i)) {
                com.facebook.common.c.a.a(lIR, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.lQp.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a lPS;
        private final com.facebook.fresco.animation.b.b lQc;
        private final int lQq;
        private final int lQr;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.lPS = aVar;
            this.lQc = bVar;
            this.lQq = i;
            this.lQr = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.lQc.Ic(this.lQq)) {
                    com.facebook.common.c.a.a(c.lIR, "Frame %d is cached already.", Integer.valueOf(this.lQq));
                    synchronized (c.this.lQp) {
                        c.this.lQp.remove(this.lQr);
                    }
                    return;
                }
                if (dw(this.lQq, 1)) {
                    com.facebook.common.c.a.a(c.lIR, "Prepared frame frame %d.", Integer.valueOf(this.lQq));
                } else {
                    com.facebook.common.c.a.d(c.lIR, "Could not prepare frame %d.", Integer.valueOf(this.lQq));
                }
                synchronized (c.this.lQp) {
                    c.this.lQp.remove(this.lQr);
                }
            } catch (Throwable th) {
                synchronized (c.this.lQp) {
                    c.this.lQp.remove(this.lQr);
                    throw th;
                }
            }
        }

        private boolean dw(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.lQc.ad(i, this.lPS.getIntrinsicWidth(), this.lPS.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dw(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.lQb.b(this.lPS.getIntrinsicWidth(), this.lPS.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.lIR, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.lQe.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.lIR, "Frame %d ready.", Integer.valueOf(this.lQq));
                synchronized (c.this.lQp) {
                    this.lQc.b(this.lQq, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
