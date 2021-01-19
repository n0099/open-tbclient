package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> pnn = a.class;
    private static final b puX = new c();
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d pse;
    @Nullable
    private com.facebook.fresco.animation.d.b puY;
    private long puZ;
    @Nullable
    private com.facebook.fresco.animation.a.a pur;
    private long pva;
    private int pvb;
    private long pvc;
    private long pvd;
    private int pve;
    private volatile b pvf;
    @Nullable
    private volatile InterfaceC1046a pvg;
    private final Runnable pvh;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1046a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pvc = 8L;
        this.pvd = 0L;
        this.pvf = puX;
        this.pvg = null;
        this.pvh = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pvh);
                a.this.invalidateSelf();
            }
        };
        this.pur = aVar;
        this.puY = a(this.pur);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pur == null ? super.getIntrinsicWidth() : this.pur.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pur == null ? super.getIntrinsicHeight() : this.pur.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.pur != null && this.pur.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pva = this.mStartTimeMs;
            this.puZ = -1L;
            this.pvb = -1;
            invalidateSelf();
            this.pvf.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pva = this.mStartTimeMs;
            this.puZ = -1L;
            this.pvb = -1;
            unscheduleSelf(this.pvh);
            this.pvf.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.pur != null) {
            this.pur.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pur != null && this.puY != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pvd : Math.max(this.puZ, 0L);
            int O = this.puY.O(max, this.puZ);
            if (O == -1) {
                O = this.pur.getFrameCount() - 1;
                this.pvf.a(this);
                this.mIsRunning = false;
            } else if (O == 0 && this.pvb != -1 && now >= this.pva) {
                this.pvf.b(this);
            }
            boolean a2 = this.pur.a(this, canvas, O);
            if (a2) {
                this.pvf.a(this, O);
                this.pvb = O;
            }
            if (!a2) {
                esS();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.puY.iJ(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pvc;
                    iI(j2);
                }
            }
            InterfaceC1046a interfaceC1046a = this.pvg;
            if (interfaceC1046a != null) {
                interfaceC1046a.a(this, this.puY, O, a2, this.mIsRunning, this.mStartTimeMs, max, this.puZ, now, now2, j, j2);
            }
            this.puZ = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.pse == null) {
            this.pse = new d();
        }
        this.pse.setAlpha(i);
        if (this.pur != null) {
            this.pur.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pse == null) {
            this.pse = new d();
        }
        this.pse.setColorFilter(colorFilter);
        if (this.pur != null) {
            this.pur.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.pur == null) {
            return 0;
        }
        return this.pur.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = puX;
        }
        this.pvf = bVar;
    }

    private void iI(long j) {
        this.pva = this.mStartTimeMs + j;
        scheduleSelf(this.pvh, this.pva);
    }

    private void esS() {
        this.pve++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(pnn, "Dropped a frame. Count: %s", Integer.valueOf(this.pve));
        }
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    @Nullable
    private static com.facebook.fresco.animation.d.b a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.facebook.fresco.animation.d.a(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.mIsRunning || this.puZ == i) {
            return false;
        }
        this.puZ = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void eqR() {
        if (this.pur != null) {
            this.pur.clear();
        }
    }
}
