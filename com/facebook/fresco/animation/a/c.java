package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b nMD;
    private final ScheduledExecutorService nQr;
    private boolean nQs;
    private long nQt;
    private long nQu;
    private long nQv;
    @Nullable
    private a nQw;
    private final Runnable nQx;

    /* loaded from: classes14.dex */
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
        this.nQs = false;
        this.nQu = 2000L;
        this.nQv = 1000L;
        this.nQx = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.nQs = false;
                    if (c.this.dYY()) {
                        if (c.this.nQw != null) {
                            c.this.nQw.onInactive();
                        }
                    } else {
                        c.this.dYZ();
                    }
                }
            }
        };
        this.nQw = aVar;
        this.nMD = bVar;
        this.nQr = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.nQt = this.nMD.now();
        boolean a2 = super.a(drawable, canvas, i);
        dYZ();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYY() {
        return this.nMD.now() - this.nQt > this.nQu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dYZ() {
        if (!this.nQs) {
            this.nQs = true;
            this.nQr.schedule(this.nQx, this.nQv, TimeUnit.MILLISECONDS);
        }
    }
}
