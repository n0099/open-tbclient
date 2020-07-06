package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b mKT;
    private final ScheduledExecutorService mOH;
    private boolean mOI;
    private long mOJ;
    private long mOK;
    private long mOL;
    @Nullable
    private a mOM;
    private final Runnable mON;

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
        this.mOI = false;
        this.mOK = 2000L;
        this.mOL = 1000L;
        this.mON = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.mOI = false;
                    if (c.this.dBU()) {
                        if (c.this.mOM != null) {
                            c.this.mOM.onInactive();
                        }
                    } else {
                        c.this.dBV();
                    }
                }
            }
        };
        this.mOM = aVar;
        this.mKT = bVar;
        this.mOH = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.mOJ = this.mKT.now();
        boolean a2 = super.a(drawable, canvas, i);
        dBV();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBU() {
        return this.mKT.now() - this.mOJ > this.mOK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dBV() {
        if (!this.mOI) {
            this.mOI = true;
            this.mOH.schedule(this.mON, this.mOL, TimeUnit.MILLISECONDS);
        }
    }
}
