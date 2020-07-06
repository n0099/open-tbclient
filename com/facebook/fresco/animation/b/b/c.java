package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> mHr = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f mOP;
    private final com.facebook.fresco.animation.b.c mOS;
    private final SparseArray<Runnable> mPd = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.mOP = fVar;
        this.mOS = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mPd) {
            if (this.mPd.get(a2) != null) {
                com.facebook.common.c.a.a(mHr, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Iy(i)) {
                com.facebook.common.c.a.a(mHr, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mPd.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a mOG;
        private final com.facebook.fresco.animation.b.b mOQ;
        private final int mPe;
        private final int mPf;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.mOG = aVar;
            this.mOQ = bVar;
            this.mPe = i;
            this.mPf = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mOQ.Iy(this.mPe)) {
                    com.facebook.common.c.a.a(c.mHr, "Frame %d is cached already.", Integer.valueOf(this.mPe));
                    synchronized (c.this.mPd) {
                        c.this.mPd.remove(this.mPf);
                    }
                    return;
                }
                if (du(this.mPe, 1)) {
                    com.facebook.common.c.a.a(c.mHr, "Prepared frame frame %d.", Integer.valueOf(this.mPe));
                } else {
                    com.facebook.common.c.a.d(c.mHr, "Could not prepare frame %d.", Integer.valueOf(this.mPe));
                }
                synchronized (c.this.mPd) {
                    c.this.mPd.remove(this.mPf);
                }
            } catch (Throwable th) {
                synchronized (c.this.mPd) {
                    c.this.mPd.remove(this.mPf);
                    throw th;
                }
            }
        }

        private boolean du(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.mOQ.ae(i, this.mOG.getIntrinsicWidth(), this.mOG.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : du(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.mOP.b(this.mOG.getIntrinsicWidth(), this.mOG.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mHr, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.mOS.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mHr, "Frame %d ready.", Integer.valueOf(this.mPe));
                synchronized (c.this.mPd) {
                    this.mOQ.b(this.mPe, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
