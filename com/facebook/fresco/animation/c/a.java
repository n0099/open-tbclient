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
    private static final Class<?> lHa = a.class;
    private static final b lOH = new c();
    @Nullable
    private com.facebook.fresco.animation.d.b lOI;
    private long lOJ;
    private long lOK;
    private int lOL;
    private long lOM;
    private long lON;
    private int lOO;
    private volatile b lOP;
    @Nullable
    private volatile InterfaceC0663a lOQ;
    private final Runnable lOR;
    @Nullable
    private com.facebook.fresco.animation.a.a lOb;
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
        this.lOM = 8L;
        this.lON = 0L;
        this.lOP = lOH;
        this.lOQ = null;
        this.lOR = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lOR);
                a.this.invalidateSelf();
            }
        };
        this.lOb = aVar;
        this.lOI = a(this.lOb);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lOb == null ? super.getIntrinsicWidth() : this.lOb.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lOb == null ? super.getIntrinsicHeight() : this.lOb.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lOb != null && this.lOb.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lOK = this.mStartTimeMs;
            this.lOJ = -1L;
            this.lOL = -1;
            invalidateSelf();
            this.lOP.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lOK = this.mStartTimeMs;
            this.lOJ = -1L;
            this.lOL = -1;
            unscheduleSelf(this.lOR);
            this.lOP.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lOb != null) {
            this.lOb.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lOb != null && this.lOI != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lON : Math.max(this.lOJ, 0L);
            int K = this.lOI.K(max, this.lOJ);
            if (K == -1) {
                K = this.lOb.getFrameCount() - 1;
                this.lOP.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.lOL != -1 && now >= this.lOK) {
                this.lOP.d(this);
            }
            boolean a = this.lOb.a(this, canvas, K);
            if (a) {
                this.lOP.a(this, K);
                this.lOL = K;
            }
            if (!a) {
                dnu();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lOI.fh(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lOM;
                    fg(j2);
                }
            }
            InterfaceC0663a interfaceC0663a = this.lOQ;
            if (interfaceC0663a != null) {
                interfaceC0663a.a(this, this.lOI, K, a, this.mIsRunning, this.mStartTimeMs, max, this.lOJ, now, now2, j, j2);
            }
            this.lOJ = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lOb != null) {
            this.lOb.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lOb != null) {
            this.lOb.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fg(long j) {
        this.lOK = this.mStartTimeMs + j;
        scheduleSelf(this.lOR, this.lOK);
    }

    private void dnu() {
        this.lOO++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "Dropped a frame. Count: %s", Integer.valueOf(this.lOO));
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
        if (this.mIsRunning || this.lOJ == i) {
            return false;
        }
        this.lOJ = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dls() {
        if (this.lOb != null) {
            this.lOb.clear();
        }
    }
}
