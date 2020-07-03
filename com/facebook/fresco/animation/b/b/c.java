package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> mHo = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f mOM;
    private final com.facebook.fresco.animation.b.c mOP;
    private final SparseArray<Runnable> mPa = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.mOM = fVar;
        this.mOP = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mPa) {
            if (this.mPa.get(a2) != null) {
                com.facebook.common.c.a.a(mHo, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Iy(i)) {
                com.facebook.common.c.a.a(mHo, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mPa.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a mOD;
        private final com.facebook.fresco.animation.b.b mON;
        private final int mPb;
        private final int mPc;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.mOD = aVar;
            this.mON = bVar;
            this.mPb = i;
            this.mPc = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mON.Iy(this.mPb)) {
                    com.facebook.common.c.a.a(c.mHo, "Frame %d is cached already.", Integer.valueOf(this.mPb));
                    synchronized (c.this.mPa) {
                        c.this.mPa.remove(this.mPc);
                    }
                    return;
                }
                if (du(this.mPb, 1)) {
                    com.facebook.common.c.a.a(c.mHo, "Prepared frame frame %d.", Integer.valueOf(this.mPb));
                } else {
                    com.facebook.common.c.a.d(c.mHo, "Could not prepare frame %d.", Integer.valueOf(this.mPb));
                }
                synchronized (c.this.mPa) {
                    c.this.mPa.remove(this.mPc);
                }
            } catch (Throwable th) {
                synchronized (c.this.mPa) {
                    c.this.mPa.remove(this.mPc);
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
                        aVar = this.mON.ae(i, this.mOD.getIntrinsicWidth(), this.mOD.getIntrinsicHeight());
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
                            aVar = c.this.mOM.b(this.mOD.getIntrinsicWidth(), this.mOD.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mHo, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.mOP.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mHo, "Frame %d ready.", Integer.valueOf(this.mPb));
                synchronized (c.this.mPa) {
                    this.mON.b(this.mPb, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
