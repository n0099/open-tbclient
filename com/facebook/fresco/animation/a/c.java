package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b nmS;
    private final ScheduledExecutorService nqI;
    private boolean nqJ;
    private long nqK;
    private long nqL;
    private long nqM;
    @Nullable
    private a nqN;
    private final Runnable nqO;

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
        this.nqJ = false;
        this.nqL = 2000L;
        this.nqM = 1000L;
        this.nqO = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.nqJ = false;
                    if (c.this.dRg()) {
                        if (c.this.nqN != null) {
                            c.this.nqN.onInactive();
                        }
                    } else {
                        c.this.dRh();
                    }
                }
            }
        };
        this.nqN = aVar;
        this.nmS = bVar;
        this.nqI = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.nqK = this.nmS.now();
        boolean a2 = super.a(drawable, canvas, i);
        dRh();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dRg() {
        return this.nmS.now() - this.nqK > this.nqL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dRh() {
        if (!this.nqJ) {
            this.nqJ = true;
            this.nqI.schedule(this.nqO, this.nqM, TimeUnit.MILLISECONDS);
        }
    }
}
