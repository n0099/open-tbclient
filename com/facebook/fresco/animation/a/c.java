package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pAX;
    private final ScheduledExecutorService pEA;
    private boolean pEB;
    private long pEC;
    private long pED;
    private long pEE;
    @Nullable
    private a pEF;
    private final Runnable pEG;

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
        this.pEB = false;
        this.pED = 2000L;
        this.pEE = 1000L;
        this.pEG = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.pEB = false;
                    if (c.this.evf()) {
                        if (c.this.pEF != null) {
                            c.this.pEF.onInactive();
                        }
                    } else {
                        c.this.evg();
                    }
                }
            }
        };
        this.pEF = aVar;
        this.pAX = bVar;
        this.pEA = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.pEC = this.pAX.now();
        boolean a2 = super.a(drawable, canvas, i);
        evg();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean evf() {
        return this.pAX.now() - this.pEC > this.pED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evg() {
        if (!this.pEB) {
            this.pEB = true;
            this.pEA.schedule(this.pEG, this.pEE, TimeUnit.MILLISECONDS);
        }
    }
}
