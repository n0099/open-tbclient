package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pqN;
    private final ScheduledExecutorService pur;
    private boolean pus;
    private long put;
    private long puu;
    private long puv;
    @Nullable
    private a puw;
    private final Runnable pux;

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
        this.pus = false;
        this.puu = 2000L;
        this.puv = 1000L;
        this.pux = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.pus = false;
                    if (c.this.esN()) {
                        if (c.this.puw != null) {
                            c.this.puw.onInactive();
                        }
                    } else {
                        c.this.esO();
                    }
                }
            }
        };
        this.puw = aVar;
        this.pqN = bVar;
        this.pur = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.put = this.pqN.now();
        boolean a2 = super.a(drawable, canvas, i);
        esO();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean esN() {
        return this.pqN.now() - this.put > this.puu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void esO() {
        if (!this.pus) {
            this.pus = true;
            this.pur.schedule(this.pux, this.puv, TimeUnit.MILLISECONDS);
        }
    }
}
