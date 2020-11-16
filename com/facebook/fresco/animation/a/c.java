package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class c<T extends com.facebook.fresco.animation.a.a> extends b<T> {
    private final com.facebook.common.time.b oOT;
    private final ScheduledExecutorService oSF;
    private boolean oSG;
    private long oSH;
    private long oSI;
    private long oSJ;
    @Nullable
    private a oSK;
    private final Runnable oSL;

    /* loaded from: classes7.dex */
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
        this.oSG = false;
        this.oSI = 2000L;
        this.oSJ = 1000L;
        this.oSL = new Runnable() { // from class: com.facebook.fresco.animation.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.oSG = false;
                    if (c.this.emJ()) {
                        if (c.this.oSK != null) {
                            c.this.oSK.onInactive();
                        }
                    } else {
                        c.this.emK();
                    }
                }
            }
        };
        this.oSK = aVar;
        this.oOT = bVar;
        this.oSF = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.a.b, com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        this.oSH = this.oOT.now();
        boolean a2 = super.a(drawable, canvas, i);
        emK();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean emJ() {
        return this.oOT.now() - this.oSH > this.oSI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void emK() {
        if (!this.oSG) {
            this.oSG = true;
            this.oSF.schedule(this.oSL, this.oSJ, TimeUnit.MILLISECONDS);
        }
    }
}
