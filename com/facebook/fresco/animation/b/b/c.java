package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes13.dex */
public class c implements b {
    private static final Class<?> mki = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f mrE;
    private final com.facebook.fresco.animation.b.c mrH;
    private final SparseArray<Runnable> mrS = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.mrE = fVar;
        this.mrH = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.mrS) {
            if (this.mrS.get(a2) != null) {
                com.facebook.common.c.a.a(mki, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Hp(i)) {
                com.facebook.common.c.a.a(mki, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.mrS.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.b.b mrF;
        private final int mrT;
        private final int mrU;
        private final com.facebook.fresco.animation.a.a mrv;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.mrv = aVar;
            this.mrF = bVar;
            this.mrT = i;
            this.mrU = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mrF.Hp(this.mrT)) {
                    com.facebook.common.c.a.a(c.mki, "Frame %d is cached already.", Integer.valueOf(this.mrT));
                    synchronized (c.this.mrS) {
                        c.this.mrS.remove(this.mrU);
                    }
                    return;
                }
                if (dl(this.mrT, 1)) {
                    com.facebook.common.c.a.a(c.mki, "Prepared frame frame %d.", Integer.valueOf(this.mrT));
                } else {
                    com.facebook.common.c.a.d(c.mki, "Could not prepare frame %d.", Integer.valueOf(this.mrT));
                }
                synchronized (c.this.mrS) {
                    c.this.mrS.remove(this.mrU);
                }
            } catch (Throwable th) {
                synchronized (c.this.mrS) {
                    c.this.mrS.remove(this.mrU);
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
                        aVar = this.mrF.ae(i, this.mrv.getIntrinsicWidth(), this.mrv.getIntrinsicHeight());
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
                            aVar = c.this.mrE.b(this.mrv.getIntrinsicWidth(), this.mrv.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.mki, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.mrH.a(i, aVar.get())) {
                com.facebook.common.c.a.a(c.mki, "Frame %d ready.", Integer.valueOf(this.mrT));
                synchronized (c.this.mrS) {
                    this.mrF.b(this.mrT, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
