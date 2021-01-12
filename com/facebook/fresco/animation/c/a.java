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
    private static final Class<?> pnm = a.class;
    private static final b puW = new c();
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d psd;
    @Nullable
    private com.facebook.fresco.animation.d.b puX;
    private long puY;
    private long puZ;
    @Nullable
    private com.facebook.fresco.animation.a.a puq;
    private int pva;
    private long pvb;
    private long pvc;
    private int pvd;
    private volatile b pve;
    @Nullable
    private volatile InterfaceC1046a pvf;
    private final Runnable pvg;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1046a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pvb = 8L;
        this.pvc = 0L;
        this.pve = puW;
        this.pvf = null;
        this.pvg = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pvg);
                a.this.invalidateSelf();
            }
        };
        this.puq = aVar;
        this.puX = a(this.puq);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.puq == null ? super.getIntrinsicWidth() : this.puq.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.puq == null ? super.getIntrinsicHeight() : this.puq.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.puq != null && this.puq.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.puZ = this.mStartTimeMs;
            this.puY = -1L;
            this.pva = -1;
            invalidateSelf();
            this.pve.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.puZ = this.mStartTimeMs;
            this.puY = -1L;
            this.pva = -1;
            unscheduleSelf(this.pvg);
            this.pve.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.puq != null) {
            this.puq.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.puq != null && this.puX != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pvc : Math.max(this.puY, 0L);
            int O = this.puX.O(max, this.puY);
            if (O == -1) {
                O = this.puq.getFrameCount() - 1;
                this.pve.a(this);
                this.mIsRunning = false;
            } else if (O == 0 && this.pva != -1 && now >= this.puZ) {
                this.pve.b(this);
            }
            boolean a2 = this.puq.a(this, canvas, O);
            if (a2) {
                this.pve.a(this, O);
                this.pva = O;
            }
            if (!a2) {
                esS();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.puX.iJ(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pvb;
                    iI(j2);
                }
            }
            InterfaceC1046a interfaceC1046a = this.pvf;
            if (interfaceC1046a != null) {
                interfaceC1046a.a(this, this.puX, O, a2, this.mIsRunning, this.mStartTimeMs, max, this.puY, now, now2, j, j2);
            }
            this.puY = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.psd == null) {
            this.psd = new d();
        }
        this.psd.setAlpha(i);
        if (this.puq != null) {
            this.puq.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.psd == null) {
            this.psd = new d();
        }
        this.psd.setColorFilter(colorFilter);
        if (this.puq != null) {
            this.puq.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.puq == null) {
            return 0;
        }
        return this.puq.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = puW;
        }
        this.pve = bVar;
    }

    private void iI(long j) {
        this.puZ = this.mStartTimeMs + j;
        scheduleSelf(this.pvg, this.puZ);
    }

    private void esS() {
        this.pvd++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(pnm, "Dropped a frame. Count: %s", Integer.valueOf(this.pvd));
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
        if (this.mIsRunning || this.puY == i) {
            return false;
        }
        this.puY = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void eqR() {
        if (this.puq != null) {
            this.puq.clear();
        }
    }
}
