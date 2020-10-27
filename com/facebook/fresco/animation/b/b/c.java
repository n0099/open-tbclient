package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.b.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public class c implements b {
    private static final Class<?> oAy = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f oHR;
    private final com.facebook.fresco.animation.b.c oHU;
    private final SparseArray<Runnable> oIf = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.oHR = fVar;
        this.oHU = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.oIf) {
            if (this.oIf.get(a2) != null) {
                com.facebook.common.c.a.a(oAy, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Oz(i)) {
                com.facebook.common.c.a.a(oAy, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.oIf.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.a.a oHI;
        private final com.facebook.fresco.animation.b.b oHS;
        private final int oIg;
        private final int oIh;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.oHI = aVar;
            this.oHS = bVar;
            this.oIg = i;
            this.oIh = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.oHS.Oz(this.oIg)) {
                    com.facebook.common.c.a.a(c.oAy, "Frame %d is cached already.", Integer.valueOf(this.oIg));
                    synchronized (c.this.oIf) {
                        c.this.oIf.remove(this.oIh);
                    }
                    return;
                }
                if (dR(this.oIg, 1)) {
                    com.facebook.common.c.a.a(c.oAy, "Prepared frame frame %d.", Integer.valueOf(this.oIg));
                } else {
                    com.facebook.common.c.a.d(c.oAy, "Could not prepare frame %d.", Integer.valueOf(this.oIg));
                }
                synchronized (c.this.oIf) {
                    c.this.oIf.remove(this.oIh);
                }
            } catch (Throwable th) {
                synchronized (c.this.oIf) {
                    c.this.oIf.remove(this.oIh);
                    throw th;
                }
            }
        }

        private boolean dR(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.oHS.af(i, this.oHI.getIntrinsicWidth(), this.oHI.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : dR(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.oHR.b(this.oHI.getIntrinsicWidth(), this.oHI.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a((Class<?>) c.oAy, "Failed to create frame bitmap", (Throwable) e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.oHU.b(i, aVar.get())) {
                com.facebook.common.c.a.a(c.oAy, "Frame %d ready.", Integer.valueOf(this.oIg));
                synchronized (c.this.oIf) {
                    this.oHS.b(this.oIg, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
