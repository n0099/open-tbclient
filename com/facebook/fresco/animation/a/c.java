package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lJQ;
    private final ScheduledExecutorService lNt;
    private boolean lNu;
    private long lNv;
    private long lNw;
    private long lNx;
    @Nullable
    private a lNy;
    private final Runnable lNz;

    /* loaded from: classes12.dex */
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
        this.lNu = false;
        this.lNw = 2000L;
        this.lNx = 1000L;
        this.lNz = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lNu = false;
                    if (c.this.dma()) {
                        if (c.this.lNy != null) {
                            c.this.lNy.onInactive();
                        }
                    } else {
                        c.this.dmb();
                    }
                }
            }
        };
        this.lNy = aVar;
        this.lJQ = bVar;
        this.lNt = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lNv = this.lJQ.now();
        boolean a2 = super.a(drawable, canvas, i);
        dmb();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dma() {
        return this.lJQ.now() - this.lNv > this.lNw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dmb() {
        if (!this.lNu) {
            this.lNu = true;
            this.lNt.schedule(this.lNz, this.lNx, TimeUnit.MILLISECONDS);
        }
    }
}
