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
    private static final Class<?> mPz = a.class;
    private static final b mXy = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a mWS;
    private long mXA;
    private long mXB;
    private int mXC;
    private long mXD;
    private long mXE;
    private int mXF;
    private volatile b mXG;
    @Nullable
    private volatile InterfaceC0813a mXH;
    private final Runnable mXI;
    @Nullable
    private com.facebook.fresco.animation.d.b mXz;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0813a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.mXD = 8L;
        this.mXE = 0L;
        this.mXG = mXy;
        this.mXH = null;
        this.mXI = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.mXI);
                a.this.invalidateSelf();
            }
        };
        this.mWS = aVar;
        this.mXz = a(this.mWS);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWS == null ? super.getIntrinsicWidth() : this.mWS.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mWS == null ? super.getIntrinsicHeight() : this.mWS.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.mWS != null && this.mWS.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mXB = this.mStartTimeMs;
            this.mXA = -1L;
            this.mXC = -1;
            invalidateSelf();
            this.mXG.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mXB = this.mStartTimeMs;
            this.mXA = -1L;
            this.mXC = -1;
            unscheduleSelf(this.mXI);
            this.mXG.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mWS != null) {
            this.mWS.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mWS != null && this.mXz != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mXE : Math.max(this.mXA, 0L);
            int M = this.mXz.M(max, this.mXA);
            if (M == -1) {
                M = this.mWS.getFrameCount() - 1;
                this.mXG.c(this);
                this.mIsRunning = false;
            } else if (M == 0 && this.mXC != -1 && now >= this.mXB) {
                this.mXG.d(this);
            }
            boolean a = this.mWS.a(this, canvas, M);
            if (a) {
                this.mXG.a(this, M);
                this.mXC = M;
            }
            if (!a) {
                dFm();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.mXz.gg(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.mXD;
                    gf(j2);
                }
            }
            InterfaceC0813a interfaceC0813a = this.mXH;
            if (interfaceC0813a != null) {
                interfaceC0813a.a(this, this.mXz, M, a, this.mIsRunning, this.mStartTimeMs, max, this.mXA, now, now2, j, j2);
            }
            this.mXA = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mWS != null) {
            this.mWS.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mWS != null) {
            this.mWS.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void gf(long j) {
        this.mXB = this.mStartTimeMs + j;
        scheduleSelf(this.mXI, this.mXB);
    }

    private void dFm() {
        this.mXF++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "Dropped a frame. Count: %s", Integer.valueOf(this.mXF));
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
        if (this.mIsRunning || this.mXA == i) {
            return false;
        }
        this.mXA = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dDj() {
        if (this.mWS != null) {
            this.mWS.clear();
        }
    }
}
