package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public class c implements b {
    private static final Class<?> nJf = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final com.facebook.fresco.animation.b.c nQC;
    private final SparseArray<Runnable> nQN = new SparseArray<>();
    private final f nQz;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.nQz = fVar;
        this.nQC = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.nQN) {
            if (this.nQN.get(a2) != null) {
                com.facebook.common.c.a.a(nJf, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.MI(i)) {
                com.facebook.common.c.a.a(nJf, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.nQN.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes14.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.b.b nQA;
        private final int nQO;
        private final int nQP;
        private final com.facebook.fresco.animation.a.a nQq;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.nQq = aVar;
            this.nQA = bVar;
            this.nQO = i;
            this.nQP = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.nQA.MI(this.nQO)) {
                    com.facebook.common.c.a.a(c.nJf, "Frame %d is cached already.", Integer.valueOf(this.nQO));
                    synchronized (c.this.nQN) {
                        c.this.nQN.remove(this.nQP);
                    }
                    return;
                }
                if (dI(this.nQO, 1)) {
                    com.facebook.common.c.a.a(c.nJf, "Prepared frame frame %d.", Integer.valueOf(this.nQO));
                } else {
                    com.facebook.common.c.a.d(c.nJf, "Could not prepare frame %d.", Integer.valueOf(this.nQO));
                }
                synchronized (c.this.nQN) {
                    c.this.nQN.remove(this.nQP);
                }
            } catch (Throwable th) {
                synchronized (c.this.nQN) {
                    c.this.nQN.remove(this.nQP);
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
                        aVar = this.nQA.ae(i, this.nQq.getIntrinsicWidth(), this.nQq.getIntrinsicHeight());
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
                            aVar = c.this.nQz.b(this.nQq.getIntrinsicWidth(), this.nQq.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.nJf, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.nQC.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.nJf, "Frame %d ready.", Integer.valueOf(this.nQO));
                synchronized (c.this.nQN) {
                    this.nQA.b(this.nQO, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
