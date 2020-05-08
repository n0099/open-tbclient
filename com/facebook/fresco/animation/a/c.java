package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lTO;
    private final ScheduledExecutorService lXC;
    private boolean lXD;
    private long lXE;
    private long lXF;
    private long lXG;
    @Nullable
    private a lXH;
    private final Runnable lXI;

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
        this.lXD = false;
        this.lXF = 2000L;
        this.lXG = 1000L;
        this.lXI = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lXD = false;
                    if (c.this.dpH()) {
                        if (c.this.lXH != null) {
                            c.this.lXH.onInactive();
                        }
                    } else {
                        c.this.dpI();
                    }
                }
            }
        };
        this.lXH = aVar;
        this.lTO = bVar;
        this.lXC = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lXE = this.lTO.now();
        boolean a2 = super.a(drawable, canvas, i);
        dpI();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpH() {
        return this.lTO.now() - this.lXE > this.lXF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dpI() {
        if (!this.lXD) {
            this.lXD = true;
            this.lXC.schedule(this.lXI, this.lXG, TimeUnit.MILLISECONDS);
        }
    }
}
