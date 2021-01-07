package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b pvp;
    private final ScheduledExecutorService pyS;
    private boolean pyT;
    private long pyU;
    private long pyV;
    private long pyW;
    @Nullable
    private a pyX;
    private final Runnable pyY;

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
        this.pyT = false;
        this.pyV = 2000L;
        this.pyW = 1000L;
        this.pyY = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.pyT = false;
                    if (c.this.ewF()) {
                        if (c.this.pyX != null) {
                            c.this.pyX.onInactive();
                        }
                    } else {
                        c.this.ewG();
                    }
                }
            }
        };
        this.pyX = aVar;
        this.pvp = bVar;
        this.pyS = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.pyU = this.pvp.now();
        boolean a2 = super.a(drawable, canvas, i);
        ewG();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ewF() {
        return this.pvp.now() - this.pyU > this.pyV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ewG() {
        if (!this.pyT) {
            this.pyT = true;
            this.pyS.schedule(this.pyY, this.pyW, TimeUnit.MILLISECONDS);
        }
    }
}
