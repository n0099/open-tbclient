package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b oNp;
    private final ScheduledExecutorService oRc;
    private boolean oRd;
    private long oRe;
    private long oRf;
    private long oRg;
    @Nullable
    private a oRh;
    private final Runnable oRi;

    /* loaded from: classes14.dex */
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
        this.oRd = false;
        this.oRf = 2000L;
        this.oRg = 1000L;
        this.oRi = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.oRd = false;
                    if (c.this.emL()) {
                        if (c.this.oRh != null) {
                            c.this.oRh.onInactive();
                        }
                    } else {
                        c.this.emM();
                    }
                }
            }
        };
        this.oRh = aVar;
        this.oNp = bVar;
        this.oRc = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.oRe = this.oNp.now();
        boolean a2 = super.a(drawable, canvas, i);
        emM();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean emL() {
        return this.oNp.now() - this.oRe > this.oRf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void emM() {
        if (!this.oRd) {
            this.oRd = true;
            this.oRc.schedule(this.oRi, this.oRg, TimeUnit.MILLISECONDS);
        }
    }
}
