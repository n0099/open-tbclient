package com.facebook.fresco.animation.b.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.a.f;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class c implements b {
    private static final Class<?> pnn = c.class;
    private final Bitmap.Config mBitmapConfig;
    private final ExecutorService mExecutorService;
    private final f puA;
    private final com.facebook.fresco.animation.b.c puD;
    private final SparseArray<Runnable> puO = new SparseArray<>();

    public c(f fVar, com.facebook.fresco.animation.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.puA = fVar;
        this.puD = cVar;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.b.b.b
    public boolean a(com.facebook.fresco.animation.b.b bVar, com.facebook.fresco.animation.a.a aVar, int i) {
        int a2 = a(aVar, i);
        synchronized (this.puO) {
            if (this.puO.get(a2) != null) {
                com.facebook.common.c.a.c(pnn, "Already scheduled decode job for frame %d", Integer.valueOf(i));
            } else if (bVar.Pa(i)) {
                com.facebook.common.c.a.c(pnn, "Frame %d is cached already.", Integer.valueOf(i));
            } else {
                a aVar2 = new a(aVar, bVar, i, a2);
                this.puO.put(a2, aVar2);
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
        private final com.facebook.fresco.animation.b.b puB;
        private final int puP;
        private final int puQ;
        private final com.facebook.fresco.animation.a.a pur;

        public a(com.facebook.fresco.animation.a.a aVar, com.facebook.fresco.animation.b.b bVar, int i, int i2) {
            this.pur = aVar;
            this.puB = bVar;
            this.puP = i;
            this.puQ = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.puB.Pa(this.puP)) {
                    com.facebook.common.c.a.c(c.pnn, "Frame %d is cached already.", Integer.valueOf(this.puP));
                    synchronized (c.this.puO) {
                        c.this.puO.remove(this.puQ);
                    }
                    return;
                }
                if (ea(this.puP, 1)) {
                    com.facebook.common.c.a.c(c.pnn, "Prepared frame frame %d.", Integer.valueOf(this.puP));
                } else {
                    com.facebook.common.c.a.d((Class<?>) c.pnn, "Could not prepare frame %d.", Integer.valueOf(this.puP));
                }
                synchronized (c.this.puO) {
                    c.this.puO.remove(this.puQ);
                }
            } catch (Throwable th) {
                synchronized (c.this.puO) {
                    c.this.puO.remove(this.puQ);
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
                        aVar = this.puB.ak(i, this.pur.getIntrinsicWidth(), this.pur.getIntrinsicHeight());
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
                            aVar = c.this.puA.f(this.pur.getIntrinsicWidth(), this.pur.getIntrinsicHeight(), c.this.mBitmapConfig);
                            i3 = -1;
                            c = c(i, aVar, i2);
                            com.facebook.common.references.a.c(aVar);
                            if (c) {
                                return c;
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a(c.pnn, "Failed to create frame bitmap", e);
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
            if (com.facebook.common.references.a.a(aVar) && c.this.puD.c(i, aVar.get())) {
                com.facebook.common.c.a.c(c.pnn, "Frame %d ready.", Integer.valueOf(this.puP));
                synchronized (c.this.puO) {
                    this.puB.b(this.puP, aVar, i2);
                }
                return true;
            }
            return false;
        }
    }
}
