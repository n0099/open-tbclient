package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lKK;
    private final ScheduledExecutorService lOn;
    private boolean lOo;
    private long lOp;
    private long lOq;
    private long lOr;
    @Nullable
    private a lOs;
    private final Runnable lOt;

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
        this.lOo = false;
        this.lOq = 2000L;
        this.lOr = 1000L;
        this.lOt = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lOo = false;
                    if (c.this.dnp()) {
                        if (c.this.lOs != null) {
                            c.this.lOs.onInactive();
                        }
                    } else {
                        c.this.dnq();
                    }
                }
            }
        };
        this.lOs = aVar;
        this.lKK = bVar;
        this.lOn = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lOp = this.lKK.now();
        boolean a2 = super.a(drawable, canvas, i);
        dnq();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dnp() {
        return this.lKK.now() - this.lOp > this.lOq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dnq() {
        if (!this.lOo) {
            this.lOo = true;
            this.lOn.schedule(this.lOt, this.lOr, TimeUnit.MILLISECONDS);
        }
    }
}
