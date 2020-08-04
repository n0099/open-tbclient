package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b mTb;
    private final ScheduledExecutorService mWT;
    private boolean mWU;
    private long mWV;
    private long mWW;
    private long mWX;
    @Nullable
    private a mWY;
    private final Runnable mWZ;

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
        this.mWU = false;
        this.mWW = 2000L;
        this.mWX = 1000L;
        this.mWZ = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.mWU = false;
                    if (c.this.dFh()) {
                        if (c.this.mWY != null) {
                            c.this.mWY.onInactive();
                        }
                    } else {
                        c.this.dFi();
                    }
                }
            }
        };
        this.mWY = aVar;
        this.mTb = bVar;
        this.mWT = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.mWV = this.mTb.now();
        boolean a2 = super.a(drawable, canvas, i);
        dFi();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dFh() {
        return this.mTb.now() - this.mWV > this.mWW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dFi() {
        if (!this.mWU) {
            this.mWU = true;
            this.mWT.schedule(this.mWZ, this.mWX, TimeUnit.MILLISECONDS);
        }
    }
}
