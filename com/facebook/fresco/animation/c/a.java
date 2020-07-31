package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> mPx = a.class;
    private static final b mXw = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a mWQ;
    private int mXA;
    private long mXB;
    private long mXC;
    private int mXD;
    private volatile b mXE;
    @Nullable
    private volatile InterfaceC0813a mXF;
    private final Runnable mXG;
    @Nullable
    private com.facebook.fresco.animation.d.b mXx;
    private long mXy;
    private long mXz;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0813a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.mXB = 8L;
        this.mXC = 0L;
        this.mXE = mXw;
        this.mXF = null;
        this.mXG = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.mXG);
                a.this.invalidateSelf();
            }
        };
        this.mWQ = aVar;
        this.mXx = a(this.mWQ);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWQ == null ? super.getIntrinsicWidth() : this.mWQ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mWQ == null ? super.getIntrinsicHeight() : this.mWQ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.mWQ != null && this.mWQ.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mXz = this.mStartTimeMs;
            this.mXy = -1L;
            this.mXA = -1;
            invalidateSelf();
            this.mXE.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mXz = this.mStartTimeMs;
            this.mXy = -1L;
            this.mXA = -1;
            unscheduleSelf(this.mXG);
            this.mXE.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mWQ != null) {
            this.mWQ.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mWQ != null && this.mXx != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mXC : Math.max(this.mXy, 0L);
            int M = this.mXx.M(max, this.mXy);
            if (M == -1) {
                M = this.mWQ.getFrameCount() - 1;
                this.mXE.c(this);
                this.mIsRunning = false;
            } else if (M == 0 && this.mXA != -1 && now >= this.mXz) {
                this.mXE.d(this);
            }
            boolean a = this.mWQ.a(this, canvas, M);
            if (a) {
                this.mXE.a(this, M);
                this.mXA = M;
            }
            if (!a) {
                dFl();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.mXx.gg(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.mXB;
                    gf(j2);
                }
            }
            InterfaceC0813a interfaceC0813a = this.mXF;
            if (interfaceC0813a != null) {
                interfaceC0813a.a(this, this.mXx, M, a, this.mIsRunning, this.mStartTimeMs, max, this.mXy, now, now2, j, j2);
            }
            this.mXy = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mWQ != null) {
            this.mWQ.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mWQ != null) {
            this.mWQ.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void gf(long j) {
        this.mXz = this.mStartTimeMs + j;
        scheduleSelf(this.mXG, this.mXz);
    }

    private void dFl() {
        this.mXD++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "Dropped a frame. Count: %s", Integer.valueOf(this.mXD));
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
        if (this.mIsRunning || this.mXy == i) {
            return false;
        }
        this.mXy = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dDi() {
        if (this.mWQ != null) {
            this.mWQ.clear();
        }
    }
}
