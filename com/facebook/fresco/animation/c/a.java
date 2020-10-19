package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> nJf = a.class;
    private static final b nQW = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.d.b nQX;
    private long nQY;
    private long nQZ;
    @Nullable
    private com.facebook.fresco.animation.a.a nQq;
    private int nRa;
    private long nRb;
    private long nRc;
    private int nRd;
    private volatile b nRe;
    @Nullable
    private volatile InterfaceC0886a nRf;
    private final Runnable nRg;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0886a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.nRb = 8L;
        this.nRc = 0L;
        this.nRe = nQW;
        this.nRf = null;
        this.nRg = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.nRg);
                a.this.invalidateSelf();
            }
        };
        this.nQq = aVar;
        this.nQX = a(this.nQq);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nQq == null ? super.getIntrinsicWidth() : this.nQq.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nQq == null ? super.getIntrinsicHeight() : this.nQq.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.nQq != null && this.nQq.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.nQZ = this.mStartTimeMs;
            this.nQY = -1L;
            this.nRa = -1;
            invalidateSelf();
            this.nRe.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.nQZ = this.mStartTimeMs;
            this.nQY = -1L;
            this.nRa = -1;
            unscheduleSelf(this.nRg);
            this.nRe.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.nQq != null) {
            this.nQq.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nQq != null && this.nQX != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.nRc : Math.max(this.nQY, 0L);
            int J = this.nQX.J(max, this.nQY);
            if (J == -1) {
                J = this.nQq.getFrameCount() - 1;
                this.nRe.c(this);
                this.mIsRunning = false;
            } else if (J == 0 && this.nRa != -1 && now >= this.nQZ) {
                this.nRe.d(this);
            }
            boolean a2 = this.nQq.a(this, canvas, J);
            if (a2) {
                this.nRe.a(this, J);
                this.nRa = J;
            }
            if (!a2) {
                dZd();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.nQX.hb(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.nRb;
                    ha(j2);
                }
            }
            InterfaceC0886a interfaceC0886a = this.nRf;
            if (interfaceC0886a != null) {
                interfaceC0886a.a(this, this.nQX, J, a2, this.mIsRunning, this.mStartTimeMs, max, this.nQY, now, now2, j, j2);
            }
            this.nQY = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.nQq != null) {
            this.nQq.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.nQq != null) {
            this.nQq.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void ha(long j) {
        this.nQZ = this.mStartTimeMs + j;
        scheduleSelf(this.nRg, this.nQZ);
    }

    private void dZd() {
        this.nRd++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "Dropped a frame. Count: %s", Integer.valueOf(this.nRd));
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
        if (this.mIsRunning || this.nQY == i) {
            return false;
        }
        this.nQY = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dXb() {
        if (this.nQq != null) {
            this.nQq.clear();
        }
    }
}
