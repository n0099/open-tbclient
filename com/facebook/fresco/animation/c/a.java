package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> njM = a.class;
    private static final b nrF = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a nqZ;
    @Nullable
    private com.facebook.fresco.animation.d.b nrG;
    private long nrH;
    private long nrI;
    private int nrJ;
    private long nrK;
    private long nrL;
    private int nrM;
    private volatile b nrN;
    @Nullable
    private volatile InterfaceC0871a nrO;
    private final Runnable nrP;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0871a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.nrK = 8L;
        this.nrL = 0L;
        this.nrN = nrF;
        this.nrO = null;
        this.nrP = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.nrP);
                a.this.invalidateSelf();
            }
        };
        this.nqZ = aVar;
        this.nrG = a(this.nqZ);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nqZ == null ? super.getIntrinsicWidth() : this.nqZ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nqZ == null ? super.getIntrinsicHeight() : this.nqZ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.nqZ != null && this.nqZ.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.nrI = this.mStartTimeMs;
            this.nrH = -1L;
            this.nrJ = -1;
            invalidateSelf();
            this.nrN.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.nrI = this.mStartTimeMs;
            this.nrH = -1L;
            this.nrJ = -1;
            unscheduleSelf(this.nrP);
            this.nrN.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.nqZ != null) {
            this.nqZ.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nqZ != null && this.nrG != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.nrL : Math.max(this.nrH, 0L);
            int M = this.nrG.M(max, this.nrH);
            if (M == -1) {
                M = this.nqZ.getFrameCount() - 1;
                this.nrN.c(this);
                this.mIsRunning = false;
            } else if (M == 0 && this.nrJ != -1 && now >= this.nrI) {
                this.nrN.d(this);
            }
            boolean a = this.nqZ.a(this, canvas, M);
            if (a) {
                this.nrN.a(this, M);
                this.nrJ = M;
            }
            if (!a) {
                dRu();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.nrG.gv(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.nrK;
                    gu(j2);
                }
            }
            InterfaceC0871a interfaceC0871a = this.nrO;
            if (interfaceC0871a != null) {
                interfaceC0871a.a(this, this.nrG, M, a, this.mIsRunning, this.mStartTimeMs, max, this.nrH, now, now2, j, j2);
            }
            this.nrH = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.nqZ != null) {
            this.nqZ.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.nqZ != null) {
            this.nqZ.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void gu(long j) {
        this.nrI = this.mStartTimeMs + j;
        scheduleSelf(this.nrP, this.nrI);
    }

    private void dRu() {
        this.nrM++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "Dropped a frame. Count: %s", Integer.valueOf(this.nrM));
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
        if (this.mIsRunning || this.nrH == i) {
            return false;
        }
        this.nrH = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dPs() {
        if (this.nqZ != null) {
            this.nqZ.clear();
        }
    }
}
