package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pqO;
    private final ScheduledExecutorService pus;
    private boolean put;
    private long puu;
    private long puv;
    private long puw;
    @Nullable
    private a pux;
    private final Runnable puy;

    /* loaded from: classes6.dex */
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
        this.put = false;
        this.puv = 2000L;
        this.puw = 1000L;
        this.puy = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.put = false;
                    if (c.this.esN()) {
                        if (c.this.pux != null) {
                            c.this.pux.onInactive();
                        }
                    } else {
                        c.this.esO();
                    }
                }
            }
        };
        this.pux = aVar;
        this.pqO = bVar;
        this.pus = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.puu = this.pqO.now();
        boolean a2 = super.a(drawable, canvas, i);
        esO();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean esN() {
        return this.pqO.now() - this.puu > this.puv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void esO() {
        if (!this.put) {
            this.put = true;
            this.pus.schedule(this.puy, this.puw, TimeUnit.MILLISECONDS);
        }
    }
}
