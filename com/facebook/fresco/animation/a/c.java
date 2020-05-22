package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b mnG;
    private long mrA;
    @Nullable
    private a mrB;
    private final Runnable mrC;
    private final ScheduledExecutorService mrw;
    private boolean mrx;
    private long mry;
    private long mrz;

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
        this.mrx = false;
        this.mrz = 2000L;
        this.mrA = 1000L;
        this.mrC = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.mrx = false;
                    if (c.this.dxa()) {
                        if (c.this.mrB != null) {
                            c.this.mrB.onInactive();
                        }
                    } else {
                        c.this.dxb();
                    }
                }
            }
        };
        this.mrB = aVar;
        this.mnG = bVar;
        this.mrw = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.mry = this.mnG.now();
        boolean a2 = super.a(drawable, canvas, i);
        dxb();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxa() {
        return this.mnG.now() - this.mry > this.mrz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dxb() {
        if (!this.mrx) {
            this.mrx = true;
            this.mrw.schedule(this.mrC, this.mrA, TimeUnit.MILLISECONDS);
        }
    }
}
