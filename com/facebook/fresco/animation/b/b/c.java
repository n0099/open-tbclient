package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> mls = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f msP;
    private final com.facebook.fresco.animation.b.c msS;
    private final SparseArray<Runnable> mtd = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.msP = fVar;
        this.msS = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mtd) {
            if (this.mtd.get(a2) != null) {
                com.facebook.common.c.a.a(mls, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Hr(i)) {
                com.facebook.common.c.a.a(mls, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mtd.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a msG;
        private final com.facebook.fresco.animation.b.b msQ;
        private final int mte;
        private final int mtf;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.msG = aVar;
            this.msQ = bVar;
            this.mte = i;
            this.mtf = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.msQ.Hr(this.mte)) {
                    com.facebook.common.c.a.a(c.mls, "Frame %d is cached already.", Integer.valueOf(this.mte));
                    synchronized (c.this.mtd) {
                        c.this.mtd.remove(this.mtf);
                    }
                    return;
                }
                if (dl(this.mte, 1)) {
                    com.facebook.common.c.a.a(c.mls, "Prepared frame frame %d.", Integer.valueOf(this.mte));
                } else {
                    com.facebook.common.c.a.d(c.mls, "Could not prepare frame %d.", Integer.valueOf(this.mte));
                }
                synchronized (c.this.mtd) {
                    c.this.mtd.remove(this.mtf);
                }
            } catch (Throwable th) {
                synchronized (c.this.mtd) {
                    c.this.mtd.remove(this.mtf);
                    throw th;
                }
            }
        }

        private boolean dl(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.msQ.ae(i, this.msG.getIntrinsicWidth(), this.msG.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dl(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.msP.b(this.msG.getIntrinsicWidth(), this.msG.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mls, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.msS.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mls, "Frame %d ready.", Integer.valueOf(this.mte));
                synchronized (c.this.mtd) {
                    this.msQ.b(this.mte, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
