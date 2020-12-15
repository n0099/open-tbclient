package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pec;
    private final ScheduledExecutorService phD;
    private boolean phE;
    private long phF;
    private long phG;
    private long phH;
    @Nullable
    private a phI;
    private final Runnable phJ;

    /* loaded from: classes11.dex */
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
        this.phE = false;
        this.phG = 2000L;
        this.phH = 1000L;
        this.phJ = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.phE = false;
                    if (c.this.esv()) {
                        if (c.this.phI != null) {
                            c.this.phI.onInactive();
                        }
                    } else {
                        c.this.esw();
                    }
                }
            }
        };
        this.phI = aVar;
        this.pec = bVar;
        this.phD = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.phF = this.pec.now();
        boolean a2 = super.a(drawable, canvas, i);
        esw();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean esv() {
        return this.pec.now() - this.phF > this.phG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void esw() {
        if (!this.phE) {
            this.phE = true;
            this.phD.schedule(this.phJ, this.phH, TimeUnit.MILLISECONDS);
        }
    }
}
