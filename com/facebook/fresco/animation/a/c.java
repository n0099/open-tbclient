package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b mSZ;
    private final ScheduledExecutorService mWR;
    private boolean mWS;
    private long mWT;
    private long mWU;
    private long mWV;
    @Nullable
    private a mWW;
    private final Runnable mWX;

    /* loaded from: classes18.dex */
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
        this.mWS = false;
        this.mWU = 2000L;
        this.mWV = 1000L;
        this.mWX = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.mWS = false;
                    if (c.this.dFg()) {
                        if (c.this.mWW != null) {
                            c.this.mWW.onInactive();
                        }
                    } else {
                        c.this.dFh();
                    }
                }
            }
        };
        this.mWW = aVar;
        this.mSZ = bVar;
        this.mWR = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.mWT = this.mSZ.now();
        boolean a2 = super.a(drawable, canvas, i);
        dFh();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dFg() {
        return this.mSZ.now() - this.mWT > this.mWU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dFh() {
        if (!this.mWS) {
            this.mWS = true;
            this.mWR.schedule(this.mWX, this.mWV, TimeUnit.MILLISECONDS);
        }
    }
}
