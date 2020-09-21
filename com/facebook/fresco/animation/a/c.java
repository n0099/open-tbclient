package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final ScheduledExecutorService nAY;
    private boolean nAZ;
    private long nBa;
    private long nBb;
    private long nBc;
    @Nullable
    private a nBd;
    private final Runnable nBe;
    private final com.facebook.common.time.b nxk;

    /* loaded from: classes5.dex */
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
        this.nAZ = false;
        this.nBb = 2000L;
        this.nBc = 1000L;
        this.nBe = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.nAZ = false;
                    if (c.this.dVn()) {
                        if (c.this.nBd != null) {
                            c.this.nBd.onInactive();
                        }
                    } else {
                        c.this.dVo();
                    }
                }
            }
        };
        this.nBd = aVar;
        this.nxk = bVar;
        this.nAY = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.nBa = this.nxk.now();
        boolean a2 = super.a(drawable, canvas, i);
        dVo();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVn() {
        return this.nxk.now() - this.nBa > this.nBb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dVo() {
        if (!this.nAZ) {
            this.nAZ = true;
            this.nAY.schedule(this.nBe, this.nBc, TimeUnit.MILLISECONDS);
        }
    }
}
