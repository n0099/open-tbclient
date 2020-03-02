package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lKz;
    private final ScheduledExecutorService lOc;
    private boolean lOd;
    private long lOe;
    private long lOf;
    private long lOg;
    @Nullable
    private a lOh;
    private final Runnable lOi;

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
        this.lOd = false;
        this.lOf = 2000L;
        this.lOg = 1000L;
        this.lOi = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lOd = false;
                    if (c.this.dno()) {
                        if (c.this.lOh != null) {
                            c.this.lOh.onInactive();
                        }
                    } else {
                        c.this.dnp();
                    }
                }
            }
        };
        this.lOh = aVar;
        this.lKz = bVar;
        this.lOc = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lOe = this.lKz.now();
        boolean a2 = super.a(drawable, canvas, i);
        dnp();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dno() {
        return this.lKz.now() - this.lOe > this.lOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dnp() {
        if (!this.lOd) {
            this.lOd = true;
            this.lOc.schedule(this.lOi, this.lOg, TimeUnit.MILLISECONDS);
        }
    }
}
