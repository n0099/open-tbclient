package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class c implements b {
    private static final Class<?> ntL = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f nBg;
    private final com.facebook.fresco.animation.b.c nBj;
    private final SparseArray<Runnable> nBu = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.nBg = fVar;
        this.nBj = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.nBu) {
            if (this.nBu.get(a2) != null) {
                com.facebook.common.c.a.a(ntL, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Mc(i)) {
                com.facebook.common.c.a.a(ntL, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.nBu.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a nAX;
        private final com.facebook.fresco.animation.b.b nBh;
        private final int nBv;
        private final int nBw;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.nAX = aVar;
            this.nBh = bVar;
            this.nBv = i;
            this.nBw = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.nBh.Mc(this.nBv)) {
                    com.facebook.common.c.a.a(c.ntL, "Frame %d is cached already.", Integer.valueOf(this.nBv));
                    synchronized (c.this.nBu) {
                        c.this.nBu.remove(this.nBw);
                    }
                    return;
                }
                if (dI(this.nBv, 1)) {
                    com.facebook.common.c.a.a(c.ntL, "Prepared frame frame %d.", Integer.valueOf(this.nBv));
                } else {
                    com.facebook.common.c.a.d(c.ntL, "Could not prepare frame %d.", Integer.valueOf(this.nBv));
                }
                synchronized (c.this.nBu) {
                    c.this.nBu.remove(this.nBw);
                }
            } catch (Throwable th) {
                synchronized (c.this.nBu) {
                    c.this.nBu.remove(this.nBw);
                    throw th;
                }
            }
        }

        private boolean dI(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.nBh.ae(i, this.nAX.getIntrinsicWidth(), this.nAX.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dI(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.nBg.b(this.nAX.getIntrinsicWidth(), this.nAX.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.ntL, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.nBj.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.ntL, "Frame %d ready.", Integer.valueOf(this.nBv));
                synchronized (c.this.nBu) {
                    this.nBh.b(this.nBv, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
