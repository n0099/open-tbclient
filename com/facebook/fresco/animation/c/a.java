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
    private static final Class<?> mHo = a.class;
    private static final b mPj = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    @Nullable
    private com.facebook.fresco.animation.a.a mOD;
    @Nullable
    private com.facebook.fresco.animation.d.b mPk;
    private long mPl;
    private long mPo;
    private int mPp;
    private long mPq;
    private long mPr;
    private int mPs;
    private volatile b mPt;
    @Nullable
    private volatile InterfaceC0803a mPu;
    private final Runnable mPv;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0803a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.mPq = 8L;
        this.mPr = 0L;
        this.mPt = mPj;
        this.mPu = null;
        this.mPv = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.mPv);
                a.this.invalidateSelf();
            }
        };
        this.mOD = aVar;
        this.mPk = a(this.mOD);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mOD == null ? super.getIntrinsicWidth() : this.mOD.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mOD == null ? super.getIntrinsicHeight() : this.mOD.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.mOD != null && this.mOD.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mPo = this.mStartTimeMs;
            this.mPl = -1L;
            this.mPp = -1;
            invalidateSelf();
            this.mPt.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mPo = this.mStartTimeMs;
            this.mPl = -1L;
            this.mPp = -1;
            unscheduleSelf(this.mPv);
            this.mPt.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mOD != null) {
            this.mOD.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mOD != null && this.mPk != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mPr : Math.max(this.mPl, 0L);
            int K = this.mPk.K(max, this.mPl);
            if (K == -1) {
                K = this.mOD.getFrameCount() - 1;
                this.mPt.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.mPp != -1 && now >= this.mPo) {
                this.mPt.d(this);
            }
            boolean a = this.mOD.a(this, canvas, K);
            if (a) {
                this.mPt.a(this, K);
                this.mPp = K;
            }
            if (!a) {
                dBV();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.mPk.fT(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.mPq;
                    fS(j2);
                }
            }
            InterfaceC0803a interfaceC0803a = this.mPu;
            if (interfaceC0803a != null) {
                interfaceC0803a.a(this, this.mPk, K, a, this.mIsRunning, this.mStartTimeMs, max, this.mPl, now, now2, j, j2);
            }
            this.mPl = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mOD != null) {
            this.mOD.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mOD != null) {
            this.mOD.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fS(long j) {
        this.mPo = this.mStartTimeMs + j;
        scheduleSelf(this.mPv, this.mPo);
    }

    private void dBV() {
        this.mPs++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "Dropped a frame. Count: %s", Integer.valueOf(this.mPs));
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
        if (this.mIsRunning || this.mPl == i) {
            return false;
        }
        this.mPl = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dzS() {
        if (this.mOD != null) {
            this.mOD.clear();
        }
    }
}
