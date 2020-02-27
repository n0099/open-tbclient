package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lKx;
    private final ScheduledExecutorService lOa;
    private boolean lOb;
    private long lOc;
    private long lOd;
    private long lOe;
    @Nullable
    private a lOf;
    private final Runnable lOg;

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
        this.lOb = false;
        this.lOd = 2000L;
        this.lOe = 1000L;
        this.lOg = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lOb = false;
                    if (c.this.dnm()) {
                        if (c.this.lOf != null) {
                            c.this.lOf.onInactive();
                        }
                    } else {
                        c.this.dnn();
                    }
                }
            }
        };
        this.lOf = aVar;
        this.lKx = bVar;
        this.lOa = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lOc = this.lKx.now();
        boolean a2 = super.a(drawable, canvas, i);
        dnn();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dnm() {
        return this.lKx.now() - this.lOc > this.lOd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dnn() {
        if (!this.lOb) {
            this.lOb = true;
            this.lOa.schedule(this.lOg, this.lOe, TimeUnit.MILLISECONDS);
        }
    }
}
