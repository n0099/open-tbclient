package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class c implements b {
    private static final Class<?> pnm = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final com.facebook.fresco.animation.b.c puC;
    private final SparseArray<Runnable> puN = new SparseArray<>();
    private final f puz;

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.puz = fVar;
        this.puC = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.puN) {
            if (this.puN.get(a2) != null) {
                com.facebook.common.c.a.c(pnm, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Pa(i)) {
                com.facebook.common.c.a.c(pnm, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.puN.put(a2, aVar2);
                this.mExecutorService.execute(aVar2);
            }
        }
        return true;
    }

    private static int a(com.facebook.fresco.animation.a.a aVar, int i) {
        return (aVar.hashCode() * 31) + i;
    }

    /* loaded from: classes6.dex */
    private class a implements Runnable {
        private final com.facebook.fresco.animation.b.b puA;
        private final int puO;
        private final int puP;
        private final com.facebook.fresco.animation.a.a puq;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.puq = aVar;
            this.puA = bVar;
            this.puO = i;
            this.puP = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.puA.Pa(this.puO)) {
                    com.facebook.common.c.a.c(c.pnm, "Frame %d is cached already.", Integer.valueOf(this.puO));
                    synchronized (c.this.puN) {
                        c.this.puN.remove(this.puP);
                    }
                    return;
                }
                if (ea(this.puO, 1)) {
                    com.facebook.common.c.a.c(c.pnm, "Prepared frame frame %d.", Integer.valueOf(this.puO));
                } else {
                    com.facebook.common.c.a.d((Class<?>) c.pnm, "Could not prepare frame %d.", Integer.valueOf(this.puO));
                }
                synchronized (c.this.puN) {
                    c.this.puN.remove(this.puP);
                }
            } catch (Throwable th) {
                synchronized (c.this.puN) {
                    c.this.puN.remove(this.puP);
                    throw th;
                }
            }
        }

        private boolean ea(int i, int i2) {
            com.facebook.common.references.a<Bitmap> aVar;
            int i3;
            boolean c;
            try {
                switch (i2) {
                    case 1:
                        aVar = this.puA.ak(i, this.puq.getIntrinsicWidth(), this.puq.getIntrinsicHeight());
                        i3 = 2;
                        try {
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            return (c || i3 == -1) ? c : ea(i, i3);
                        } catch (Throwable th) {
                            th = th;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            aVar = c.this.puz.f(this.puq.getIntrinsicWidth(), this.puq.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a(c.pnm, "Failed to create frame bitmap", e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.puC.c(i, aVar.get())) {
                com.facebook.common.c.a.c(c.pnm, "Frame %d ready.", Integer.valueOf(this.puO));
                synchronized (c.this.puN) {
                    this.puA.b(this.puO, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
