package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a nAX;
    @Nullable
    private com.facebook.fresco.animation.d.b nBE;
    private long nBF;
    private long nBG;
    private int nBH;
    private long nBI;
    private long nBJ;
    private int nBK;
    private volatile b nBL;
    @Nullable
    private volatile InterfaceC0868a nBM;
    private final Runnable nBN;
    private static final Class<?> ntL = a.class;
    private static final b nBD = new c();

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0868a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.nBI = 8L;
        this.nBJ = 0L;
        this.nBL = nBD;
        this.nBM = null;
        this.nBN = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.nBN);
                a.this.invalidateSelf();
            }
        };
        this.nAX = aVar;
        this.nBE = a(this.nAX);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nAX == null ? super.getIntrinsicWidth() : this.nAX.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nAX == null ? super.getIntrinsicHeight() : this.nAX.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.nAX != null && this.nAX.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.nBG = this.mStartTimeMs;
            this.nBF = -1L;
            this.nBH = -1;
            invalidateSelf();
            this.nBL.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.nBG = this.mStartTimeMs;
            this.nBF = -1L;
            this.nBH = -1;
            unscheduleSelf(this.nBN);
            this.nBL.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.nAX != null) {
            this.nAX.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nAX != null && this.nBE != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.nBJ : Math.max(this.nBF, 0L);
            int J = this.nBE.J(max, this.nBF);
            if (J == -1) {
                J = this.nAX.getFrameCount() - 1;
                this.nBL.c(this);
                this.mIsRunning = false;
            } else if (J == 0 && this.nBH != -1 && now >= this.nBG) {
                this.nBL.d(this);
            }
            boolean a = this.nAX.a(this, canvas, J);
            if (a) {
                this.nBL.a(this, J);
                this.nBH = J;
            }
            if (!a) {
                dVs();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.nBE.gJ(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.nBI;
                    gI(j2);
                }
            }
            InterfaceC0868a interfaceC0868a = this.nBM;
            if (interfaceC0868a != null) {
                interfaceC0868a.a(this, this.nBE, J, a, this.mIsRunning, this.mStartTimeMs, max, this.nBF, now, now2, j, j2);
            }
            this.nBF = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.nAX != null) {
            this.nAX.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.nAX != null) {
            this.nAX.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void gI(long j) {
        this.nBG = this.mStartTimeMs + j;
        scheduleSelf(this.nBN, this.nBG);
    }

    private void dVs() {
        this.nBK++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "Dropped a frame. Count: %s", Integer.valueOf(this.nBK));
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
        if (this.mIsRunning || this.nBF == i) {
            return false;
        }
        this.nBF = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dTq() {
        if (this.nAX != null) {
            this.nAX.clear();
        }
    }
}
