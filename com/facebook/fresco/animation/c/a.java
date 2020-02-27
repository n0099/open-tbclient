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
    private static final Class<?> lGY = a.class;
    private static final b lOF = new c();
    @Nullable
    private com.facebook.fresco.animation.a.a lNZ;
    @Nullable
    private com.facebook.fresco.animation.d.b lOG;
    private long lOH;
    private long lOI;
    private int lOJ;
    private long lOK;
    private long lOL;
    private int lOM;
    private volatile b lON;
    @Nullable
    private volatile InterfaceC0663a lOO;
    private final Runnable lOP;
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
        this.lOK = 8L;
        this.lOL = 0L;
        this.lON = lOF;
        this.lOO = null;
        this.lOP = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lOP);
                a.this.invalidateSelf();
            }
        };
        this.lNZ = aVar;
        this.lOG = a(this.lNZ);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lNZ == null ? super.getIntrinsicWidth() : this.lNZ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lNZ == null ? super.getIntrinsicHeight() : this.lNZ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lNZ != null && this.lNZ.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.lOI = this.mStartTimeMs;
            this.lOH = -1L;
            this.lOJ = -1;
            invalidateSelf();
            this.lON.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.lOI = this.mStartTimeMs;
            this.lOH = -1L;
            this.lOJ = -1;
            unscheduleSelf(this.lOP);
            this.lON.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lNZ != null) {
            this.lNZ.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lNZ != null && this.lOG != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.lOL : Math.max(this.lOH, 0L);
            int K = this.lOG.K(max, this.lOH);
            if (K == -1) {
                K = this.lNZ.getFrameCount() - 1;
                this.lON.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.lOJ != -1 && now >= this.lOI) {
                this.lON.d(this);
            }
            boolean a = this.lNZ.a(this, canvas, K);
            if (a) {
                this.lON.a(this, K);
                this.lOJ = K;
            }
            if (!a) {
                dnr();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lOG.fh(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.lOK;
                    fg(j2);
                }
            }
            InterfaceC0663a interfaceC0663a = this.lOO;
            if (interfaceC0663a != null) {
                interfaceC0663a.a(this, this.lOG, K, a, this.mIsRunning, this.mStartTimeMs, max, this.lOH, now, now2, j, j2);
            }
            this.lOH = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lNZ != null) {
            this.lNZ.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lNZ != null) {
            this.lNZ.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fg(long j) {
        this.lOI = this.mStartTimeMs + j;
        scheduleSelf(this.lOP, this.lOI);
    }

    private void dnr() {
        this.lOM++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "Dropped a frame. Count: %s", Integer.valueOf(this.lOM));
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
        if (this.mIsRunning || this.lOH == i) {
            return false;
        }
        this.lOH = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dlq() {
        if (this.lNZ != null) {
            this.lNZ.clear();
        }
    }
}
