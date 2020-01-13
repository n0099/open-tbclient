package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b lJL;
    private final ScheduledExecutorService lNo;
    private boolean lNp;
    private long lNq;
    private long lNr;
    private long lNs;
    @Nullable
    private a lNt;
    private final Runnable lNu;

    /* loaded from: classes12.dex */
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
        this.lNp = false;
        this.lNr = 2000L;
        this.lNs = 1000L;
        this.lNu = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.lNp = false;
                    if (c.this.dlY()) {
                        if (c.this.lNt != null) {
                            c.this.lNt.onInactive();
                        }
                    } else {
                        c.this.dlZ();
                    }
                }
            }
        };
        this.lNt = aVar;
        this.lJL = bVar;
        this.lNo = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.lNq = this.lJL.now();
        boolean a2 = super.a(drawable, canvas, i);
        dlZ();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dlY() {
        return this.lJL.now() - this.lNq > this.lNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dlZ() {
        if (!this.lNp) {
            this.lNp = true;
            this.lNo.schedule(this.lNu, this.lNs, TimeUnit.MILLISECONDS);
        }
    }
}
