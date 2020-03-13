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
    private static final Class<?> lHl = a.class;
    private static final b lOS = new c();
    @Nullable
    private com.facebook.fresco.animation.d.b lOT;
    private long lOU;
    private long lOV;
    private int lOW;
    private long lOX;
    private long lOY;
    private int lOZ;
    @Nullable
    private com.facebook.fresco.animation.a.a lOm;
    private volatile b lPa;
    @Nullable
    private volatile InterfaceC0663a lPb;
    private final Runnable lPc;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0663a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lOX = 8L;
        this.lOY = 0L;
        this.lPa = lOS;
        this.lPb = null;
        this.lPc = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lPc);
                a.this.invalidateSelf();
            }
        };
        this.lOm = aVar;
        this.lOT = a(this.lOm);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lOm == null ? super.getIntrinsicWidth() : this.lOm.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lOm == null ? super.getIntrinsicHeight() : this.lOm.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lOm != null && this.lOm.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lOV = this.mStartTimeMs;
            this.lOU = -1L;
            this.lOW = -1;
            invalidateSelf();
            this.lPa.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lOV = this.mStartTimeMs;
            this.lOU = -1L;
            this.lOW = -1;
            unscheduleSelf(this.lPc);
            this.lPa.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lOm != null) {
            this.lOm.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lOm != null && this.lOT != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lOY : Math.max(this.lOU, 0L);
            int K = this.lOT.K(max, this.lOU);
            if (K == -1) {
                K = this.lOm.getFrameCount() - 1;
                this.lPa.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.lOW != -1 && now >= this.lOV) {
                this.lPa.d(this);
            }
            boolean a = this.lOm.a(this, canvas, K);
            if (a) {
                this.lPa.a(this, K);
                this.lOW = K;
            }
            if (!a) {
                dnv();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lOT.fh(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lOX;
                    fg(j2);
                }
            }
            InterfaceC0663a interfaceC0663a = this.lPb;
            if (interfaceC0663a != null) {
                interfaceC0663a.a(this, this.lOT, K, a, this.mIsRunning, this.mStartTimeMs, max, this.lOU, now, now2, j, j2);
            }
            this.lOU = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lOm != null) {
            this.lOm.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lOm != null) {
            this.lOm.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fg(long j) {
        this.lOV = this.mStartTimeMs + j;
        scheduleSelf(this.lPc, this.lOV);
    }

    private void dnv() {
        this.lOZ++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "Dropped a frame. Count: %s", Integer.valueOf(this.lOZ));
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
        if (this.mIsRunning || this.lOU == i) {
            return false;
        }
        this.lOU = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dlt() {
        if (this.lOm != null) {
            this.lOm.clear();
        }
    }
}
