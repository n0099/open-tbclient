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
    private static final Class<?> lQq = a.class;
    private static final b lYh = new c();
    @Nullable
    private com.facebook.fresco.animation.a.a lXB;
    @Nullable
    private com.facebook.fresco.animation.d.b lYi;
    private long lYj;
    private long lYk;
    private int lYl;
    private long lYm;
    private long lYn;
    private int lYo;
    private volatile b lYp;
    @Nullable
    private volatile InterfaceC0728a lYq;
    private final Runnable lYr;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0728a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lYm = 8L;
        this.lYn = 0L;
        this.lYp = lYh;
        this.lYq = null;
        this.lYr = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lYr);
                a.this.invalidateSelf();
            }
        };
        this.lXB = aVar;
        this.lYi = a(this.lXB);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lXB == null ? super.getIntrinsicWidth() : this.lXB.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lXB == null ? super.getIntrinsicHeight() : this.lXB.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lXB != null && this.lXB.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lYk = this.mStartTimeMs;
            this.lYj = -1L;
            this.lYl = -1;
            invalidateSelf();
            this.lYp.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lYk = this.mStartTimeMs;
            this.lYj = -1L;
            this.lYl = -1;
            unscheduleSelf(this.lYr);
            this.lYp.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lXB != null) {
            this.lXB.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lXB != null && this.lYi != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lYn : Math.max(this.lYj, 0L);
            int I = this.lYi.I(max, this.lYj);
            if (I == -1) {
                I = this.lXB.getFrameCount() - 1;
                this.lYp.c(this);
                this.mIsRunning = false;
            } else if (I == 0 && this.lYl != -1 && now >= this.lYk) {
                this.lYp.d(this);
            }
            boolean a = this.lXB.a(this, canvas, I);
            if (a) {
                this.lYp.a(this, I);
                this.lYl = I;
            }
            if (!a) {
                dpM();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lYi.fO(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lYm;
                    fN(j2);
                }
            }
            InterfaceC0728a interfaceC0728a = this.lYq;
            if (interfaceC0728a != null) {
                interfaceC0728a.a(this, this.lYi, I, a, this.mIsRunning, this.mStartTimeMs, max, this.lYj, now, now2, j, j2);
            }
            this.lYj = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lXB != null) {
            this.lXB.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lXB != null) {
            this.lXB.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fN(long j) {
        this.lYk = this.mStartTimeMs + j;
        scheduleSelf(this.lYr, this.lYk);
    }

    private void dpM() {
        this.lYo++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "Dropped a frame. Count: %s", Integer.valueOf(this.lYo));
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
        if (this.mIsRunning || this.lYj == i) {
            return false;
        }
        this.lYj = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dnI() {
        if (this.lXB != null) {
            this.lXB.clear();
        }
    }
}
