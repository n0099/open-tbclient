package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes18.dex */
public class c implements b {
    private static final Class<?> mPz = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f mXb;
    private final com.facebook.fresco.animation.b.c mXe;
    private final SparseArray<Runnable> mXp = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.mXb = fVar;
        this.mXe = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mXp) {
            if (this.mXp.get(a2) != null) {
                com.facebook.common.c.a.a(mPz, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.IT(i)) {
                com.facebook.common.c.a.a(mPz, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mXp.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a mWS;
        private final com.facebook.fresco.animation.b.b mXc;
        private final int mXq;
        private final int mXr;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.mWS = aVar;
            this.mXc = bVar;
            this.mXq = i;
            this.mXr = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mXc.IT(this.mXq)) {
                    com.facebook.common.c.a.a(c.mPz, "Frame %d is cached already.", Integer.valueOf(this.mXq));
                    synchronized (c.this.mXp) {
                        c.this.mXp.remove(this.mXr);
                    }
                    return;
                }
                if (dw(this.mXq, 1)) {
                    com.facebook.common.c.a.a(c.mPz, "Prepared frame frame %d.", Integer.valueOf(this.mXq));
                } else {
                    com.facebook.common.c.a.d(c.mPz, "Could not prepare frame %d.", Integer.valueOf(this.mXq));
                }
                synchronized (c.this.mXp) {
                    c.this.mXp.remove(this.mXr);
                }
            } catch (Throwable th) {
                synchronized (c.this.mXp) {
                    c.this.mXp.remove(this.mXr);
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
                        aVar = this.mXc.ab(i, this.mWS.getIntrinsicWidth(), this.mWS.getIntrinsicHeight());
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
                            aVar = c.this.mXb.b(this.mWS.getIntrinsicWidth(), this.mWS.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mPz, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.mXe.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mPz, "Frame %d ready.", Integer.valueOf(this.mXq));
                synchronized (c.this.mXp) {
                    this.mXc.b(this.mXq, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
