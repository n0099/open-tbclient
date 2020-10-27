package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b oDW;
    private final ScheduledExecutorService oHJ;
    private boolean oHK;
    private long oHL;
    private long oHM;
    private long oHN;
    @Nullable
    private a oHO;
    private final Runnable oHP;

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
        this.oHK = false;
        this.oHM = 2000L;
        this.oHN = 1000L;
        this.oHP = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.oHK = false;
                    if (c.this.eiW()) {
                        if (c.this.oHO != null) {
                            c.this.oHO.onInactive();
                        }
                    } else {
                        c.this.eiX();
                    }
                }
            }
        };
        this.oHO = aVar;
        this.oDW = bVar;
        this.oHJ = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.oHL = this.oDW.now();
        boolean a2 = super.a(drawable, canvas, i);
        eiX();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eiW() {
        return this.oDW.now() - this.oHL > this.oHM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eiX() {
        if (!this.oHK) {
            this.oHK = true;
            this.oHJ.schedule(this.oHP, this.oHN, TimeUnit.MILLISECONDS);
        }
    }
}
