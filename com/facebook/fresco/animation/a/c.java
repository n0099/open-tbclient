package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lMq;
    private final ScheduledExecutorService lPT;
    private boolean lPU;
    private long lPV;
    private long lPW;
    private long lPX;
    @Nullable
    private a lPY;
    private final Runnable lPZ;

    /* loaded from: classes13.dex */
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
        this.lPU = false;
        this.lPW = 2000L;
        this.lPX = 1000L;
        this.lPZ = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lPU = false;
                    if (c.this.dnN()) {
                        if (c.this.lPY != null) {
                            c.this.lPY.onInactive();
                        }
                    } else {
                        c.this.dnO();
                    }
                }
            }
        };
        this.lPY = aVar;
        this.lMq = bVar;
        this.lPT = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lPV = this.lMq.now();
        boolean a2 = super.a(drawable, canvas, i);
        dnO();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dnN() {
        return this.lMq.now() - this.lPV > this.lPW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dnO() {
        if (!this.lPU) {
            this.lPU = true;
            this.lPT.schedule(this.lPZ, this.lPX, TimeUnit.MILLISECONDS);
        }
    }
}
