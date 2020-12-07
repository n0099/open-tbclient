package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pea;
    private final ScheduledExecutorService phB;
    private boolean phC;
    private long phD;
    private long phE;
    private long phF;
    @Nullable
    private a phG;
    private final Runnable phH;

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
        this.phC = false;
        this.phE = 2000L;
        this.phF = 1000L;
        this.phH = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.phC = false;
                    if (c.this.esu()) {
                        if (c.this.phG != null) {
                            c.this.phG.onInactive();
                        }
                    } else {
                        c.this.esv();
                    }
                }
            }
        };
        this.phG = aVar;
        this.pea = bVar;
        this.phB = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.phD = this.pea.now();
        boolean a2 = super.a(drawable, canvas, i);
        esv();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean esu() {
        return this.pea.now() - this.phD > this.phE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void esv() {
        if (!this.phC) {
            this.phC = true;
            this.phB.schedule(this.phH, this.phF, TimeUnit.MILLISECONDS);
        }
    }
}
