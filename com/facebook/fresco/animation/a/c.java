package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b moR;
    private final ScheduledExecutorService msH;
    private boolean msI;
    private long msJ;
    private long msK;
    private long msL;
    @Nullable
    private a msM;
    private final Runnable msN;

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
        this.msI = false;
        this.msK = 2000L;
        this.msL = 1000L;
        this.msN = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.msI = false;
                    if (c.this.dxo()) {
                        if (c.this.msM != null) {
                            c.this.msM.onInactive();
                        }
                    } else {
                        c.this.dxp();
                    }
                }
            }
        };
        this.msM = aVar;
        this.moR = bVar;
        this.msH = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.msJ = this.moR.now();
        boolean a2 = super.a(drawable, canvas, i);
        dxp();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxo() {
        return this.moR.now() - this.msJ > this.msK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dxp() {
        if (!this.msI) {
            this.msI = true;
            this.msH.schedule(this.msN, this.msL, TimeUnit.MILLISECONDS);
        }
    }
}
