package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pDC;
    private final ScheduledExecutorService pHf;
    private boolean pHg;
    private long pHh;
    private long pHi;
    private long pHj;
    @Nullable
    private a pHk;
    private final Runnable pHl;

    /* loaded from: classes4.dex */
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
        this.pHg = false;
        this.pHi = 2000L;
        this.pHj = 1000L;
        this.pHl = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.pHg = false;
                    if (c.this.evw()) {
                        if (c.this.pHk != null) {
                            c.this.pHk.onInactive();
                        }
                    } else {
                        c.this.evx();
                    }
                }
            }
        };
        this.pHk = aVar;
        this.pDC = bVar;
        this.pHf = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.pHh = this.pDC.now();
        boolean a2 = super.a(drawable, canvas, i);
        evx();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean evw() {
        return this.pDC.now() - this.pHh > this.pHi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evx() {
        if (!this.pHg) {
            this.pHg = true;
            this.pHf.schedule(this.pHl, this.pHj, TimeUnit.MILLISECONDS);
        }
    }
}
