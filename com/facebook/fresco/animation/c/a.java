package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> lQm = a.class;
    private static final b lYd = new c();
    @Nullable
    private com.facebook.fresco.animation.a.a lXx;
    @Nullable
    private com.facebook.fresco.animation.d.b lYe;
    private long lYf;
    private long lYg;
    private int lYh;
    private long lYi;
    private long lYj;
    private int lYk;
    private volatile b lYl;
    @Nullable
    private volatile InterfaceC0707a lYm;
    private final Runnable lYn;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0707a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lYi = 8L;
        this.lYj = 0L;
        this.lYl = lYd;
        this.lYm = null;
        this.lYn = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lYn);
                a.this.invalidateSelf();
            }
        };
        this.lXx = aVar;
        this.lYe = a(this.lXx);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lXx == null ? super.getIntrinsicWidth() : this.lXx.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lXx == null ? super.getIntrinsicHeight() : this.lXx.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lXx != null && this.lXx.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lYg = this.mStartTimeMs;
            this.lYf = -1L;
            this.lYh = -1;
            invalidateSelf();
            this.lYl.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lYg = this.mStartTimeMs;
            this.lYf = -1L;
            this.lYh = -1;
            unscheduleSelf(this.lYn);
            this.lYl.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lXx != null) {
            this.lXx.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lXx != null && this.lYe != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lYj : Math.max(this.lYf, 0L);
            int I = this.lYe.I(max, this.lYf);
            if (I == -1) {
                I = this.lXx.getFrameCount() - 1;
                this.lYl.c(this);
                this.mIsRunning = false;
            } else if (I == 0 && this.lYh != -1 && now >= this.lYg) {
                this.lYl.d(this);
            }
            boolean a = this.lXx.a(this, canvas, I);
            if (a) {
                this.lYl.a(this, I);
                this.lYh = I;
            }
            if (!a) {
                dpP();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lYe.fO(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lYi;
                    fN(j2);
                }
            }
            InterfaceC0707a interfaceC0707a = this.lYm;
            if (interfaceC0707a != null) {
                interfaceC0707a.a(this, this.lYe, I, a, this.mIsRunning, this.mStartTimeMs, max, this.lYf, now, now2, j, j2);
            }
            this.lYf = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lXx != null) {
            this.lXx.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lXx != null) {
            this.lXx.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fN(long j) {
        this.lYg = this.mStartTimeMs + j;
        scheduleSelf(this.lYn, this.lYg);
    }

    private void dpP() {
        this.lYk++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "Dropped a frame. Count: %s", Integer.valueOf(this.lYk));
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
        if (this.mIsRunning || this.lYf == i) {
            return false;
        }
        this.lYf = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dnL() {
        if (this.lXx != null) {
            this.lXx.clear();
        }
    }
}
