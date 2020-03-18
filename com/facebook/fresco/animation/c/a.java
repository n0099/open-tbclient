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
    private static final Class<?> lIR = a.class;
    private static final b lQy = new c();
    @Nullable
    private com.facebook.fresco.animation.a.a lPS;
    private long lQA;
    private long lQB;
    private int lQC;
    private long lQD;
    private long lQE;
    private int lQF;
    private volatile b lQG;
    @Nullable
    private volatile InterfaceC0664a lQH;
    private final Runnable lQI;
    @Nullable
    private com.facebook.fresco.animation.d.b lQz;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0664a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lQD = 8L;
        this.lQE = 0L;
        this.lQG = lQy;
        this.lQH = null;
        this.lQI = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lQI);
                a.this.invalidateSelf();
            }
        };
        this.lPS = aVar;
        this.lQz = a(this.lPS);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lPS == null ? super.getIntrinsicWidth() : this.lPS.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lPS == null ? super.getIntrinsicHeight() : this.lPS.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lPS != null && this.lPS.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lQB = this.mStartTimeMs;
            this.lQA = -1L;
            this.lQC = -1;
            invalidateSelf();
            this.lQG.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lQB = this.mStartTimeMs;
            this.lQA = -1L;
            this.lQC = -1;
            unscheduleSelf(this.lQI);
            this.lQG.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lPS != null) {
            this.lPS.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lPS != null && this.lQz != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lQE : Math.max(this.lQA, 0L);
            int K = this.lQz.K(max, this.lQA);
            if (K == -1) {
                K = this.lPS.getFrameCount() - 1;
                this.lQG.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.lQC != -1 && now >= this.lQB) {
                this.lQG.d(this);
            }
            boolean a = this.lPS.a(this, canvas, K);
            if (a) {
                this.lQG.a(this, K);
                this.lQC = K;
            }
            if (!a) {
                dnS();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lQz.fi(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lQD;
                    fh(j2);
                }
            }
            InterfaceC0664a interfaceC0664a = this.lQH;
            if (interfaceC0664a != null) {
                interfaceC0664a.a(this, this.lQz, K, a, this.mIsRunning, this.mStartTimeMs, max, this.lQA, now, now2, j, j2);
            }
            this.lQA = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lPS != null) {
            this.lPS.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lPS != null) {
            this.lPS.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fh(long j) {
        this.lQB = this.mStartTimeMs + j;
        scheduleSelf(this.lQI, this.lQB);
    }

    private void dnS() {
        this.lQF++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "Dropped a frame. Count: %s", Integer.valueOf(this.lQF));
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
        if (this.mIsRunning || this.lQA == i) {
            return false;
        }
        this.lQA = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dlQ() {
        if (this.lPS != null) {
            this.lPS.clear();
        }
    }
}
