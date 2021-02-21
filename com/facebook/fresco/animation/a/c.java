package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pBx;
    private final ScheduledExecutorService pFa;
    private boolean pFb;
    private long pFc;
    private long pFd;
    private long pFe;
    @Nullable
    private a pFf;
    private final Runnable pFg;

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
        this.pFb = false;
        this.pFd = 2000L;
        this.pFe = 1000L;
        this.pFg = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.pFb = false;
                    if (c.this.evn()) {
                        if (c.this.pFf != null) {
                            c.this.pFf.onInactive();
                        }
                    } else {
                        c.this.evo();
                    }
                }
            }
        };
        this.pFf = aVar;
        this.pBx = bVar;
        this.pFa = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.pFc = this.pBx.now();
        boolean a2 = super.a(drawable, canvas, i);
        evo();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean evn() {
        return this.pBx.now() - this.pFc > this.pFd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evo() {
        if (!this.pFb) {
            this.pFb = true;
            this.pFa.schedule(this.pFg, this.pFe, TimeUnit.MILLISECONDS);
        }
    }
}
