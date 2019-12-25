package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lGn;
    private final ScheduledExecutorService lJD;
    private boolean lJE;
    private long lJF;
    private long lJG;
    private long lJH;
    @Nullable
    private a lJI;
    private final Runnable lJJ;

    /* loaded from: classes11.dex */
    public interface a {
        void onInactive();
    }

    public static <T extends com.facebook.fresco.animation.a.a & a> b<T> a(T t, com.facebook.common.time.b bVar, ScheduledExecutorService scheduledExecutorService) {
        return a(t, (a) t, bVar, scheduledExecutorService);
    }

    public static <T extends com.facebook.fresco.animation.a.a> b<T> a(T t, a aVar, com.facebook.common.time.b bVar, ScheduledExecutorService scheduledExecutorService) {
        return new c(t, aVar, bVar, scheduledExecutorService);
    }

    private c(@Nullable T t, @Nullable a aVar, com.facebook.common.time.b bVar, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.lJE = false;
        this.lJG = 2000L;
        this.lJH = 1000L;
        this.lJJ = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lJE = false;
                    if (c.this.dkT()) {
                        if (c.this.lJI != null) {
                            c.this.lJI.onInactive();
                        }
                    } else {
                        c.this.dkU();
                    }
                }
            }
        };
        this.lJI = aVar;
        this.lGn = bVar;
        this.lJD = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lJF = this.lGn.now();
        boolean a2 = super.a(drawable, canvas, i);
        dkU();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dkT() {
        return this.lGn.now() - this.lJF > this.lJG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dkU() {
        if (!this.lJE) {
            this.lJE = true;
            this.lJD.schedule(this.lJJ, this.lJH, TimeUnit.MILLISECONDS);
        }
    }
}
