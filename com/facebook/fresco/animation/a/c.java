package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b mKQ;
    private final ScheduledExecutorService mOE;
    private boolean mOF;
    private long mOG;
    private long mOH;
    private long mOI;
    @Nullable
    private a mOJ;
    private final Runnable mOK;

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
        this.mOF = false;
        this.mOH = 2000L;
        this.mOI = 1000L;
        this.mOK = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.mOF = false;
                    if (c.this.dBQ()) {
                        if (c.this.mOJ != null) {
                            c.this.mOJ.onInactive();
                        }
                    } else {
                        c.this.dBR();
                    }
                }
            }
        };
        this.mOJ = aVar;
        this.mKQ = bVar;
        this.mOE = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.mOG = this.mKQ.now();
        boolean a2 = super.a(drawable, canvas, i);
        dBR();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBQ() {
        return this.mKQ.now() - this.mOG > this.mOH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dBR() {
        if (!this.mOF) {
            this.mOF = true;
            this.mOE.schedule(this.mOK, this.mOI, TimeUnit.MILLISECONDS);
        }
    }
}
