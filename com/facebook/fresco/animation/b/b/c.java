package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class c implements b {
    private static final Class<?> oLv = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f oSN;
    private final com.facebook.fresco.animation.b.c oSQ;
    private final SparseArray<Runnable> oTb = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.oSN = fVar;
        this.oSQ = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.oTb) {
            if (this.oTb.get(a2) != null) {
                com.facebook.common.c.a.a(oLv, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Px(i)) {
                com.facebook.common.c.a.a(oLv, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.oTb.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes7.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.a.a oSE;
        private final com.facebook.fresco.animation.b.b oSO;
        private final int oTc;
        private final int oTd;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.oSE = aVar;
            this.oSO = bVar;
            this.oTc = i;
            this.oTd = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.oSO.Px(this.oTc)) {
                    com.facebook.common.c.a.a(c.oLv, "Frame %d is cached already.", Integer.valueOf(this.oTc));
                    synchronized (c.this.oTb) {
                        c.this.oTb.remove(this.oTd);
                    }
                    return;
                }
                if (dV(this.oTc, 1)) {
                    com.facebook.common.c.a.a(c.oLv, "Prepared frame frame %d.", Integer.valueOf(this.oTc));
                } else {
                    com.facebook.common.c.a.d(c.oLv, "Could not prepare frame %d.", Integer.valueOf(this.oTc));
                }
                synchronized (c.this.oTb) {
                    c.this.oTb.remove(this.oTd);
                }
            } catch (Throwable th) {
                synchronized (c.this.oTb) {
                    c.this.oTb.remove(this.oTd);
                    throw th;
                }
            }
        }

        private boolean dV(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.oSO.ai(i, this.oSE.getIntrinsicWidth(), this.oSE.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dV(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.oSN.b(this.oSE.getIntrinsicWidth(), this.oSE.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.oLv, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.oSQ.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.oLv, "Frame %d ready.", Integer.valueOf(this.oTc));
                synchronized (c.this.oTb) {
                    this.oSO.b(this.oTc, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
