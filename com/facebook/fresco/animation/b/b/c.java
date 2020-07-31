package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes18.dex */
public class c implements b {
    private static final Class<?> mPx = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f mWZ;
    private final com.facebook.fresco.animation.b.c mXc;
    private final SparseArray<Runnable> mXn = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.mWZ = fVar;
        this.mXc = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mXn) {
            if (this.mXn.get(a2) != null) {
                com.facebook.common.c.a.a(mPx, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.IT(i)) {
                com.facebook.common.c.a.a(mPx, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mXn.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes18.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.a.a mWQ;
        private final com.facebook.fresco.animation.b.b mXa;
        private final int mXo;
        private final int mXp;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.mWQ = aVar;
            this.mXa = bVar;
            this.mXo = i;
            this.mXp = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mXa.IT(this.mXo)) {
                    com.facebook.common.c.a.a(c.mPx, "Frame %d is cached already.", Integer.valueOf(this.mXo));
                    synchronized (c.this.mXn) {
                        c.this.mXn.remove(this.mXp);
                    }
                    return;
                }
                if (dw(this.mXo, 1)) {
                    com.facebook.common.c.a.a(c.mPx, "Prepared frame frame %d.", Integer.valueOf(this.mXo));
                } else {
                    com.facebook.common.c.a.d(c.mPx, "Could not prepare frame %d.", Integer.valueOf(this.mXo));
                }
                synchronized (c.this.mXn) {
                    c.this.mXn.remove(this.mXp);
                }
            } catch (Throwable th) {
                synchronized (c.this.mXn) {
                    c.this.mXn.remove(this.mXp);
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
                        aVar = this.mXa.ab(i, this.mWQ.getIntrinsicWidth(), this.mWQ.getIntrinsicHeight());
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
                            aVar = c.this.mWZ.b(this.mWQ.getIntrinsicWidth(), this.mWQ.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mPx, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.mXc.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mPx, "Frame %d ready.", Integer.valueOf(this.mXo));
                synchronized (c.this.mXn) {
                    this.mXa.b(this.mXo, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
