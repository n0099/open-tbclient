package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b nnk;
    private final ScheduledExecutorService nra;
    private boolean nrb;
    private long nrc;
    private long nrd;
    private long nre;
    @Nullable
    private a nrf;
    private final Runnable nrg;

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
        this.nrb = false;
        this.nrd = 2000L;
        this.nre = 1000L;
        this.nrg = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.nrb = false;
                    if (c.this.dRp()) {
                        if (c.this.nrf != null) {
                            c.this.nrf.onInactive();
                        }
                    } else {
                        c.this.dRq();
                    }
                }
            }
        };
        this.nrf = aVar;
        this.nnk = bVar;
        this.nra = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.nrc = this.nnk.now();
        boolean a2 = super.a(drawable, canvas, i);
        dRq();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dRp() {
        return this.nnk.now() - this.nrc > this.nrd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dRq() {
        if (!this.nrb) {
            this.nrb = true;
            this.nra.schedule(this.nrg, this.nre, TimeUnit.MILLISECONDS);
        }
    }
}
