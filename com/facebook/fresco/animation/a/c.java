package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lTK;
    private long lXA;
    private long lXB;
    private long lXC;
    @Nullable
    private a lXD;
    private final Runnable lXE;
    private final ScheduledExecutorService lXy;
    private boolean lXz;

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
        this.lXz = false;
        this.lXB = 2000L;
        this.lXC = 1000L;
        this.lXE = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lXz = false;
                    if (c.this.dpK()) {
                        if (c.this.lXD != null) {
                            c.this.lXD.onInactive();
                        }
                    } else {
                        c.this.dpL();
                    }
                }
            }
        };
        this.lXD = aVar;
        this.lTK = bVar;
        this.lXy = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lXA = this.lTK.now();
        boolean a2 = super.a(drawable, canvas, i);
        dpL();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpK() {
        return this.lTK.now() - this.lXA > this.lXB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dpL() {
        if (!this.lXz) {
            this.lXz = true;
            this.lXy.schedule(this.lXE, this.lXC, TimeUnit.MILLISECONDS);
        }
    }
}
